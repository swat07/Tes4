

package com.pages.AddressChangeScreens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class VPAS_PopUpPage extends Initialize_Browser  {
	CopyExistandAddNew_PerformTranPage CopyExistandAddNew;
	

	
	
public VPAS_PopUpPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);

}
BaseUtils utility = new BaseUtils(driver); 
    
 	// Click on pop

 	@FindBy(xpath = "//*[@id='EXPAND-OUTERFRAME']/tbody/tr/td")
 	 WebElement vPAS_PopUp;

 	// Click on cloase Buton

 	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
 	 WebElement vPAS_Close_Btn;
 	
 	@FindBy(className = "buttonTdButton")
	 WebElement updated_VPAS;
 	
 	@FindBy(xpath = "//label[@for='.ErrorMessage']/following-sibling::div//span")
	 WebElement popUp_ErrorMessage;
 	
 	@FindBy(xpath = "//label[@for='.Description']/following-sibling::div//span")
	public WebElement verify_Message;

 	@FindBy(xpath="//*[@id='EXPAND-INNERDIV']/div/div[3]/div/div/span[2]")
	public WebElement status;

 	@FindBy(xpath = ".//*[@id='EXPAND-INNERDIV']/div/div[3]/div/div/span[2]")
    public WebElement peerReviewStatus;
 	
 	@FindBy(id = "Finding1")
	public WebElement goodTo_Proceed;

	@FindBy(id = "Finding2")
	public WebElement track;
	
	@FindBy(xpath = ".//*[@id='submitButton']")
	public WebElement submit_Vpsa_Btn;
     
     public void submit_InfoToVPAS(String addressTCName) throws Exception {
 		try {
 			
 			CopyExistandAddNew = new CopyExistandAddNew_PerformTranPage(driver);
 			
 			String actualMsg1 = "";
 			String actualMsg2 = "";
 			String addNew_AddValues = "";

 			ArrayList<String> validationlist = new ArrayList<String>();

 			String textInsideInputBox = CopyExistandAddNew.address_City
 					.getAttribute("value");
 			
 			List<WebElement> rows = CopyExistandAddNew.addNew_AddTableData
 					.findElements(By.tagName("tr"));

 			int countRows = rows.size();

 			for (int i = 2; i <= countRows; i++) {

 				addNew_AddValues = driver
 						.findElement(
 								By.xpath("//table[@pl_prop='MCAlphaMaintPage.AddressList']//tbody//tr["
 										+ i + "]//td[2]")).getText();

 				validationlist.add(addNew_AddValues);

 			}
 		
 			//Check popUp will come when city is blank at Add new Address 
 			if (textInsideInputBox.isEmpty()
 					&& addressTCName.equalsIgnoreCase("add_NewAddress")
 					&& validationlist.contains(null))

 			{
 				
 			
 				utility.click_On_Button(updated_VPAS);
 			

 				utility.click_On_Button(vPAS_PopUp);

 			

 				if (utility
 						.isWebElementExist(popUp_ErrorMessage)) {
 					actualMsg2 = popUp_ErrorMessage.getText();

 					excelWrite.writeInCell(

 					addressTCName + " Pop Up message - " + actualMsg2, "Pass");
 				}

 				actualMsg1 = verify_Message.getText();

 				excelWrite.writeInCell(

 				addressTCName + " Pop Up message - " + actualMsg1, "Pass");

 				extent_Reportlogger( " Message - ",addressTCName+
 						" : PopUp error  ", "Pass");
 				

 				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

 				utility.click_On_Button(vPAS_Close_Btn);

 			

 			}

 			else {

 			
 				updated_VPAS.click();

 			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

 				utility.click_On_Button(vPAS_PopUp);

 				boolean flag = vPAS_PopUp.isEnabled();

 				boolean flag1 = vPAS_PopUp.isDisplayed();

 				// Verify Popup Message
 				if (verify_PopUp_Message(addressTCName)) {

 					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10,
 							TimeUnit.SECONDS));

 					excelWrite.writeInCell(

 					addressTCName + " pop_Up Displayed with verified Message",
 							"Pass");

 					Actions action = new Actions(driver);
 					action.moveToElement(vPAS_Close_Btn)
 							.click().perform();

 				
 				} else {
 					extent_Reportlogger(
 							addressTCName + " Pop Up Not Displayed",
 							"Pop Up Not Displayed screen", "FAIL");
 					excelWrite.writeInCell(

 					addressTCName + " Pop Up Not Displayed", "Fail");

 					ErrorLogger.logError("CSWD_AddressChange",
 							"submit_InfoToVPAS", addressTCName
 									+ "Pop Up Not Displayed");

 					throw new Exception("PopUp not displayed");
 				}

 			}
 		}

 		catch (Exception e) {
 			excelWrite.writeInCell(

 			"Failed in Submit To VPAS Method", "Fail");

 			ErrorLogger.logError(e.getClass().getName(), "ChangeINAddress",
 					e.getMessage());

 			throw e;
 		}
 	}

 	public boolean verify_PopUp_Message(String addressTCName) throws Exception {

 		try {
 			// addressChangePage = new CSWD_AddressChange(driver);
 			ArrayList<String> expectedMessage_List = new ArrayList<String>();
 			ArrayList<String> updated_ActualMessageList = new ArrayList<String>();
 			String addressTypes_Values = "";
 			if (addressTCName.equalsIgnoreCase("copy_Existing")) {

 				addressTypes_Values = reader.getMapData(
 						CommonVariable.selectAddressType_WithNewAddress, map)
 						.toString();
 			}

 			else if (addressTCName.equalsIgnoreCase("add_NewAddress")) {

 				addressTypes_Values = reader.getMapData(
 						CommonVariable.add_NewAddress, map).toString();
 			}
 			String updatded_actualMsg = "";
 			String expectedMsg = "";

 			String defaultMsg = "ALPHANAME-VPAS(R) UPDATE SUCCESSFUL";

 			String actualMsg = verify_Message.getText();

 			if (addressTypes_Values.length() == 0) {
 				updatded_actualMsg = defaultMsg;
 			}

 			else {
 				String[] actualMessage_Values = actualMsg.split("[-:]");
 				int array_lenth = actualMessage_Values.length;
 				System.out.println("lenth of array" + array_lenth);

 				for (int k = 1; k < actualMessage_Values.length - 2; k = k + 2) {
 					updated_ActualMessageList.add(actualMessage_Values[k]);
 				}
 				Collections.sort(updated_ActualMessageList,
 						String.CASE_INSENSITIVE_ORDER);

 				for (int j = 0; j < updated_ActualMessageList.size(); j++) {
 					updatded_actualMsg = updatded_actualMsg + "ALPHAADDRESS-"
 							+ updated_ActualMessageList.get(j)
 							+ ": VPAS(R) UPDATE SUCCESSFUL" + "\n";
 				}
 				updatded_actualMsg = updatded_actualMsg + defaultMsg;

 			}

 			String[] tokens = addressTypes_Values.split(",");
 			if (addressTypes_Values.length() == 0) {
 				expectedMsg = defaultMsg;
 			} else {
 				for (String orderingValue : tokens) {
 					expectedMessage_List.add(orderingValue);
 					// Collections.addAll(myList, orderingValue);

 				}

 				Collections.sort(expectedMessage_List,
 						String.CASE_INSENSITIVE_ORDER);

 				for (int i = 0; i < expectedMessage_List.size(); i++) {

 					expectedMsg = expectedMsg + "ALPHAADDRESS-"
 							+ expectedMessage_List.get(i)
 							+ ": VPAS(R) UPDATE SUCCESSFUL" + "\n";

 				}
 				expectedMsg = expectedMsg + defaultMsg;

 			}

 			if (updatded_actualMsg.equalsIgnoreCase(expectedMsg)) {

 				extent_Reportlogger(":" +addressTCName + ": "
 						+ actualMsg, "vPAS Message", "PASS");
 				excelWrite.writeInCell(

 				addressTCName + " : Pop Up message - " + actualMsg, "Pass");

 				return true;
 			} else

 			{

 				extent_Reportlogger(
 						" has not been verified screen",
 						"vPASPOP_UP Message ", "FaiL");
 				excelWrite.writeInCell(

 				"vPASPOP_UP Message not Verified", "Fail");

 				return false;
 			}

 		} catch (Exception e) {
 			excelWrite.writeInCell(

 			"Failed in verify vPAS PopUp_Message", "Fail");

 			ErrorLogger.logError(e.getClass().getName(),
 					"ChangeINAddress : verify_PopUp_Message", e.getMessage());

 			throw e;
 		}

 	}
 	
 	
 // Finally process to vpas submission
 	public void vpas_Submit() throws Exception {
 		try {

 			
 			
 		
 			driver.switchTo().defaultContent();
 			driver.switchTo().frame("PegaGadget2Ifr");
 			utility.selectvalueByText_DropdownList(
 					goodTo_Proceed,
 					reader.getMapData(CommonVariable.goodTo_Proceed, map));
 		
 			utility.selectvalueByText_DropdownList(track,
 					reader.getMapData(CommonVariable.track_Value, map));

 			excelWrite.writeInCell(

 			" Address Submitted to VPAS Successfully", "PASS");

 			submit_Vpsa_Btn.click();

 	
 			Assert.assertTrue(checkStatus(), "verifying the status");
 			
 		} catch (Exception e) {

 			ErrorLogger.logError(e.getClass().getName(),
 					"Address_Change_Backoff-vpas_Submit() ", e.getMessage());
 			e.printStackTrace();
 			throw e;

 		}
 	}

 	public boolean checkStatus() throws Exception {

 		String Expected = "Resolved-Completed";
 		String actual = status.getText();

 		if (actual.equalsIgnoreCase(Expected)) {
 			excelWrite
 					.writeInCell(

 							"CSR is  able to edit/add the address/phone details for the selected relationship : "
 									+ actual, "Pass");

 			extent_Reportlogger("  :  "
 							+ actual, "CSR is   able to edit/add the address/phone details for the selected relationship", "Pass");
 			return true;

 		} else {
 			excelWrite
 					.writeInCell(

 							"CSR is not  able to edit/add the address/phone details for the selected relationship : "
 									+ actual, "Fail");

 			extent_Reportlogger(
 					"  :  "
 							+ actual,
 					" CSR is not  able to edit/add the address/phone details for the selected relationship ", "Fail");

 			return false;
 		}
 	}


}

