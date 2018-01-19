package com.pages.PolicyTermination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.pages.PolicyChangeScreens.PolicyChange_IGOVerfication;
import com.pages.PolicyChangeScreens.PolicyChange_PerformTransactionScreen;
import com.pages.PolicyChangeScreens.PolicyChange_ValidationMszScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ScreenShot;
import com.utility.Test_BaseClass;


public class PolicyTerminationRecessionPage extends Test_BaseClass {
	
	

	public PolicyTerminationRecessionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	




	//span[@class="textMiddle"]//label[text()='Tax']
	
	@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Tax']")
	public WebElement click_OnTax;
	
	@FindBy(id = "IRSDistCode")
	public WebElement Select_IRSDistributionCode;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Calculate')]")
	public WebElement click_Calculatebutton;
	
	@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Disbursement']")
	public WebElement click_Disbursement;
	
	@FindBy(id = "VerifiedDisbFlag")
	public WebElement Select_VerifiedDisbFlag;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement Select_Validatebutton;
	
	@FindBy(xpath = "//div[@class=oflowDivM]//span[text()='Info']")
	public WebElement verify_ValidationNoErrMsg;
	
	//@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	
	//@FindBy(xpath = "//*[@id='HarnessFooter']/tbody/tr/td[2]/table/tbody/tr/td/nobr/span/button")
	@FindBy(xpath = "//*[@id='HarnessFooter']//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement validateInput_Close_Btn;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
	//@FindBy(xpath = "//*[@id='RULE_KEY']/div[3]/div/div/div/div/div/span/button")
	public WebElement validateSubmit_Btn;
	
	//*[@id='gridLayoutTable']
	@FindBy(xpath = "//*[@id='gridLayoutTable']")
	public WebElement click_outerlayer;
	
	
	@FindBy(xpath="//div[@class='field-item dataLabelRead']")
	public WebElement checkNoerror_validateMessages1;
	
	@FindBy(xpath=".//*[@id='RULE_KEY']/table/tbody/tr/td[1]/nobr/label")
	public WebElement review_ValidationMsz;
	
	@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
	public WebElement validateMessagesTable;
	
	@FindBy(id = "submitButton")
	public WebElement CLick_OnDone;
	
	@FindBy(xpath="//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/span")
	public WebElement codeText;
	
	@FindBy(xpath = "//select[@id='ReasonCode']")
	public WebElement CLick_Onreasoncode;
	
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate Selection')]")
	public WebElement validatebtn;
	
	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement click_Validatebutton;
	
	
/*	public String verify_EventCodeforSurrender() throws Exception 
	{
	
		
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		String getTextPopUp = driver.findElement(By.xpath("//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/span")).getText().trim();
		
		
		System.out.println("Verify_PopUp : " +getTextPopUp);
		extent_Reportlogger("Verify_EventCodeforSurrender", "Alpha Maintenance", "PASS");
	
		excelWrite.writeInCell(
				"Verify_EventCodeforSurrender", "Pass");
		
		
		
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		return getTextPopUp;
	}*/
	
	public void verify_EventCodeforSurrender(String testCaseName,String eventCode) throws Exception 
	{
		
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
				String getTextPopUp = driver.findElement(By.xpath("//label[text()='Event Code']/following-sibling::div//span")).getText();
				
				//String getTextPopUp = driver.findElement(By.xpath("//div[@class='content layout-content-default']//div[2]//div[@class='field-item dataValueRead']//span")).getText();
				System.out.println("IGPRenwel_eventCOde"+getTextPopUp);
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				if(getTextPopUp.equalsIgnoreCase(eventCode))
				{
					extent_Reportlogger(":Execution Successfully Done : Event Code is : "+getTextPopUp, "verifyEventCodeforSurrender", "PASS");
					excelWrite.writeInCell("verifyEventCodeforSurrender Test Step Execution Successfull: Event Code is "+getTextPopUp, "PASS");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					CLick_OnDone.click();
					
					excelWrite.writeInCell(
							"Clicked on Done Button", "Pass");
					extent_Reportlogger(":Executed Successfully", "Done process", "Pass");
					
					
			
					
				}
				else
				{
					extent_Reportlogger("Event Confirmation value is not Expected",
							"Failed in  Event Confirmation", "FAIL");
					excelWrite.writeInCell(
							"Event Confirmation value is not Expected ", "Fail");
				}

	}
	
	
	public void select_taxValidation() throws Exception{
		
		try{
		
			
			utility.click_On_Button(click_Disbursement);
			
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			*/
			extent_Reportlogger(":Successfully Run", "click_Disbursement", "PASS");
			
			excelWrite.writeInCell(
					"click_DisbursementisDone", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		
			utility.click_On_Button(Select_VerifiedDisbFlag);
			
			extent_Reportlogger(":Successfully Run", "Select_VerifiedDisbFlag", "PASS");
			
			excelWrite.writeInCell(
					"Select_VerifiedDisbFlag is Done", "Pass");
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			click_Validatebutton.click();
			
			
			//Code for Validation Window Handle
			
			excelWrite.writeInCell(
					"ValidatebuttonClickDone", "Pass");
			extent_Reportlogger(":Successfully Run", "ValidatebuttonClick", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			String noError_validateMesage = "";
			String reviewMessages="";
			String value = "";
			String mainwindow = "";
			mainwindow = driver.getWindowHandle();

			 excelWrite.writeInCell(
						"select_validateoptionDone", "Pass");
				extent_Reportlogger(":SuccessfullyRun", "select_validateoption", "Pass");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			String parentwindow = driver.getWindowHandle();
			System.out.println("Before switching " + driver.getTitle());
			
			Set<String> s1 = driver.getWindowHandles();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			Iterator<String> i1	=s1.iterator();
			while (i1.hasNext()){
				String child_window = i1.next();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				System.out.println("value" +child_window);
				if (!parentwindow.equalsIgnoreCase(child_window)){
					
					driver.switchTo().window(child_window);
					((JavascriptExecutor)driver).executeScript("window.focus();");
//					driver.manage().window().setPosition(new Point(2000, 500));
					System.out.println( "After switching" +driver.getTitle());
					break;
				
				
				}
			}
			
			excelWrite.writeInCell(
					"Moved_ToValidation_WindowDone", "Pass");
			extent_Reportlogger(":SuccessfullyDone", "Moved_ToValidation_Windowdone", "Pass");
			
			ArrayList<String> validationlist = new ArrayList<String>();
			
			String value1 = "";
		
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			if (utility.isWebElementExist(review_ValidationMsz))
			{
				
				List<WebElement> rows = validateMessagesTable
						.findElements(By.tagName("tr"));
				List<WebElement> cols = validateMessagesTable
						.findElements(By.tagName("td"));
				int countRows = rows.size();
				int countCols = cols.size();
				
				System.out.println(countRows + countCols);
				outerLoop: for (int i = 2; i <= countRows; i++) {
					for (int j = 3; j <= 5; j++) {

						if (rowsExist(i, j)) {
							System.out.println("entering");

							value1 = driver
									.findElement(
											By.xpath("//table[@id='bodyTbl_right']//tbody//tr["
													+ i + "]//td[" + j + "]"))
									.getText();

							System.out.println("table value" + value1);
							validationlist.add(value1);

						} else {
							System.out.println("exit");
							break outerLoop;
						}
					}
				}
				driver.manage().window().maximize();
			

			if (validationlist.contains("Fatal") || validationlist.contains("Stop")) {
				
				System.out.println("Inside Fatal");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
				
				extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
				excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
				
				
				/*extent_Reportlogger("FATAL Error:",
						"User is InsideFatalError", "PASS");	
				
					excelWrite.writeInCell(
							"User is inside FATAL Error", "Pass");*/

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				validateInput_Close_Btn.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				
				driver.switchTo().window(parentwindow);
				System.out.println("Switch to parent window "
						+ driver.switchTo().window(parentwindow).getTitle());
			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				
				

				extent_Reportlogger("FATAL Error :  ",
					"SubmitButtonisDisabled", "PASS");
				
					excelWrite.writeInCell(
							"InsideFatalErrorSubmitButtonisDisabled", "Pass");

			}
			
			
		
			else if (validationlist.contains("Info") || validationlist.contains("Warning")) {
				
				System.out.println("inside Info");
			
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
				
				extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
				excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
				
				
				
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			validateInput_Close_Btn.click();
			/*extent_Reportlogger("Test Step Execution Successfull", "closeButtonClick", "PASS");
 			excelWrite.writeInCell("closeButtonClick Test Step Execution Successfull", "PASS");*/
 			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			driver.switchTo().window(mainwindow);
			System.out.println("Switch to parent window "
					+ driver.switchTo().window(mainwindow).getTitle());
		
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			Actions actions = new Actions(driver);
			actions.moveToElement(validateSubmit_Btn).click()
					.perform();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			
			
			//Code for EventCode Handling
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			
			verify_EventCodeforSurrender("PolicyTermination", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
			System.out.println("Event code Value" + reader.getMapData(CommonVariable.selectEventCode_Validation, map));
			
		
			
			excelWrite.writeInCell(
					"InfoMszVerifyDone", "Pass");
			extent_Reportlogger("InfoMszVerifyDone", "InfoMszVerifyDone", "Pass");
	
		}
			}
		
		}

	catch (InterruptedException e) {
		
		//extent_Reportlogger("submit_InfoToVpas", "Login Fail Screen", "FAIL");
		extent_Reportlogger("InfoMszVerifyDone Failed",
				"InfoMszVerifyDone", "FAIL");
		excelWrite.writeInCell(
				"InfoMszVerifyDone", "Fail");
		
		
		e.printStackTrace();
	}
				
		

	}

	public void clkSelectionTaxIRSCode()throws Exception {
		
		try{
			
			utility.click_On_Button(click_OnTax);
			
			excelWrite.writeInCell(
					"click_OnTaxDone", "Pass");
			extent_Reportlogger(":Successfully Done", "click_OnTax", "Pass");
			
			
			utility.selectvalueByText_DropdownList(Select_IRSDistributionCode, reader.getMapData(CommonVariable.select_IRS_Distribution_Code, map));
		
			excelWrite.writeInCell("Selected IRSDistributionCode = " + reader.getMapData(CommonVariable.select_IRS_Distribution_Code, map), "Pass"); 
		
			extent_Reportlogger(": is Executed Successfully Done", "clkSelectionTaxIRSCode", "Pass");
		
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "clkSelectionTaxIRSCode", "FAIL");
			
			excelWrite.writeInCell(
					"clkSelectionTaxIRSCode", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	} 

	public boolean rowsExist(int i, int j)
	{
		try {

			
			
			driver.findElement(
					By.xpath("//table[@id='bodyTbl_right']//tbody//tr["
							+ i + "]//td[" + j + "]")).getTagName();
			
			
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}

