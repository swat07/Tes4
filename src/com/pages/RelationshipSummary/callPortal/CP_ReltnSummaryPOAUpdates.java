package com.pages.RelationshipSummary.callPortal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import com.functions.relationshipSummary.RelationshipSummaryCommonOprations;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class CP_ReltnSummaryPOAUpdates extends Test_BaseClass {
	public CP_ReltnSummaryPOAUpdates(WebDriver driver){
		this.driver = driver;
		 PageFactory.initElements(driver, this);

}

	BaseUtils utility = new BaseUtils(driver);
	RelationshipSummaryCommonOprations Relationship_userPersonalDetails;
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement vPAS_Close_Btn;
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Change POA(s)')]")
	public WebElement click_ChangePOA;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Alpha')]")
	public WebElement click_ADDAlpha;
	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,'  Submit New Alpha Info To VPAS(R) ')]")
	public WebElement Submit_Updated_Alpha_InfoToVPAS;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit To VPAS')]")
	public WebElement submit_SendToVpas;

	@FindBy(id = "submitButton")
	public WebElement click_On_Submit;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Update Alpha')]")
	public WebElement click_UpdateAlpha;
	
	@FindBy(id = "FirstName")
	public WebElement enter_UpdateName;
	
	@FindBy(id = "pySelected1")
	public WebElement clkChekboxToUpdate;
	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,'  Submit Updated Alpha Info To VPAS(R) ')]")
	public WebElement submit_UpdatedInfo;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement click_Close;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Change POA(s)')]")
	public WebElement click_OnChangePOABtn;
	
	@FindBy(id = "MCWrapUpComments")
	public WebElement wrapUpDetails_TxtBox;
	
	@FindBy(xpath = "//div[text()='Launch']")
	public WebElement launch_Btn;
	
	//@FindBy(xpath = "//div[text()='+ Action']")
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'+ Action')]")
	public WebElement action_Link;
	


	
	public void clickChangePOA()throws Exception {
		
		try{
			utility.click_On_Button(click_ChangePOA);
			utility.click_On_Button(click_ADDAlpha);
			
	
			extent_Reportlogger(":SucessfullyDone", "clickChangePOA", "PASS");
			excelWrite.writeInCell(
					"clickChangePOADone", "Pass");
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "clickChangePOA", "FAIL");
			
			excelWrite.writeInCell(
					"clickChangePOA", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	
	public void submitAlphaInfoToVPAS()throws Exception {
		
		try{
			utility.click_On_Button(Submit_Updated_Alpha_InfoToVPAS);
		
			extent_Reportlogger(":SucessfullyDone", "submitAlphaInfoToVPAS", "PASS");
			excelWrite.writeInCell(
					"submitAlphaInfoToVPASDone", "Pass");
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "submitAlphaInfoToVPAS", "FAIL");
			
			excelWrite.writeInCell(
					"submitAlphaInfoToVPAS", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	
	
	public void POADateandTypeSelection()throws Exception
			{
		try 
		{
			System.out.println("Inside selection completed!!");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			WebElement wb=driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']"));
			List<WebElement> elements=wb.findElements(By.tagName("tr"));
			System.out.println("no of rows: "+ elements.size());
			int enter_POAData = elements.size();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[1]//input[@type='checkbox']")).click();
		
			System.out.println("Selection completed!!");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[5]//input")), reader.getMapData(CommonVariable.enter_AccessEndDate, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			System.out.println("Print "+  reader.getMapData(CommonVariable.enter_AccessType, map));
			System.out.println("MAp value*****"+map);
			
			int i = enter_POAData-1;
		
			System.out.println("MAp value*****" +i);
	
			
			System.out.println("below click on check box");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
		utility.selectvalueByText_DropdownList(driver.findElement(By.xpath("//*[@id='WebAccessType"+i+"']")), reader.getMapData(CommonVariable.enter_AccessType, map));
		excelWrite.writeInCell(
				"POADateandTypeSelectionisDone", "Pass");
		extent_Reportlogger(":ExecutedSucessfully", "POADateandTypeSelection", "Pass");
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		submit_SendToVpas.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			Actions action = new Actions(driver);
			action.moveToElement(click_On_Submit).click().perform();
			
			
			System.out.println(" clicked on  Submit button");
		
	
	
		excelWrite.writeInCell(
				"select_PoAdata excuted successfully", "Pass");
		extent_Reportlogger("select_PoAdata excuted successfully", "select_PoAdata Screen", "Pass");
			
		}
		 catch (InterruptedException e) {
			
			e.printStackTrace();
			excelWrite.writeInCell(
					"select_PoAdata excuted Unsuccessfully", "Fail");
			extent_Reportlogger("select_PoAdata excuted Unsuccessfully", "select_PoAdata Screen", "Fail");
				
		}
		
		
		}
	public void action_LinkClick() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			driver.switchTo().defaultContent();
			driver.switchTo().frame("cpmInteractionDivFrame");
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			action_Link.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "action_LinkClick", "PASS");
			excelWrite.writeInCell("action_LinkClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "action_LinkClick", "FAIL");
			excelWrite.writeInCell("action_LinkClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"action_LinkClick", e.getMessage());
			throw e;
		}
}

	public void expandAction_SelectCategoryPOA() throws Exception {
		try {
			/*String action=reader.getMapData(CommonVariable.action, map);
			driver.findElement(By.xpath("//li//span[text()='"+action+"']/ancestor::li[1]/preceding-sibling::li//div[@id='iconExpandCollapse']")).click();*/
			
			String subAction=reader.getMapData(CommonVariable.subAction, map);
			driver.findElement(By.xpath("//div[@id[contains(.,'McCamish-FW-MCRMFW-Data-IDCategories-Financial')]]//span[text()='"+subAction+"']")).click();
			
			extent_Reportlogger("Test Step Execution Successfull", "expandAction_SelectCategory", "PASS");
			excelWrite.writeInCell("expandAction_SelectCategory Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "expandAction_SelectCategory", "FAIL");
			excelWrite.writeInCell("expandAction_SelectCategory Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"expandAction_SelectCategory", e.getMessage());
			throw e;
		}
}
	public void launch_ButtonClick() throws Exception {
		try {
			
			
			launch_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "launch_ButtonClick", "PASS");
			excelWrite.writeInCell("launch_ButtonClick Test Step Execution Successfull", "PASS");
		}
		
		catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "launch_ButtonClick", "FAIL");
			excelWrite.writeInCell("launch_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"launch_ButtonClick", e.getMessage());
			throw e;
		}
}
	

	public void selectRecordForUpdate() throws Exception {
		try{
			
			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
			System.out.println("Inside selectRecordForUpdate ");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			WebElement wb=driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']"));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			List<WebElement> elements=wb.findElements(By.tagName("tr"));
			System.out.println("no of rows: "+ elements.size());
			int enter_POAData = elements.size();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[1]//input[@type='checkbox']")).click();
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(click_UpdateAlpha);
			extent_Reportlogger(":Sucessfully Done", "selectRecordForUpdate", "Pass");
			excelWrite.writeInCell(
					"selectRecordForUpdate is Done", "Pass");
			
	
		}
		catch (Exception e) {
			extent_Reportlogger(":Failed", "selectRecordForUpdate", "FAIL");
			
			excelWrite.writeInCell(
					"selectRecordForUpdate", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			throw e;
			
		}
		
	}
	public void recordSelectionforUpdate() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(clkChekboxToUpdate);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			System.out.println("Inside upate1");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//utility.click_On_Button(click_UpdateAlpha);
			click_UpdateAlpha.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//utility.click_On_Button(enter_UpdateName);
			enter_UpdateName.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			enter_UpdateName.clear();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(enter_UpdateName, (reader.getMapData(CommonVariable.update_First_Name, map)+Keys.TAB));

			/*
			extent_Reportlogger(":Sucessfully Done", "enterandSubmitUpdatedName", "PASS");

			
			excelWrite.writeInCell("enterandSubmitUpdatedName = " + reader.getMapData(CommonVariable.update_First_Name, map ), "Pass"); */
		
			utility.click_On_Button(submit_UpdatedInfo);
			/*extent_Reportlogger("Test step Execution Successfull", "recordSelectionforUpdate:", "PASS");
			excelWrite.writeInCell("recordSelectionforUpdate Test Step Execution Successfull", "PASS");*/
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "recordSelectionforUpdate", "FAIL");
			excelWrite.writeInCell("recordSelectionforUpdate Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"recordSelectionforUpdate", e.getMessage());
			throw e;
		}
}
	
	public void enterandSubmitUpdatedName() throws Exception {
		try {
			
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//utility.click_On_Button(enter_UpdateName);
			enter_UpdateName.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			enter_UpdateName.clear();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(enter_UpdateName, (reader.getMapData(CommonVariable.update_First_Name, map)+Keys.TAB));

			
			extent_Reportlogger(":Sucessfully Done", "enterandSubmitUpdatedName", "PASS");

			
			excelWrite.writeInCell("enterandSubmitUpdatedName = " + reader.getMapData(CommonVariable.update_First_Name, map ), "Pass"); 
		
			utility.click_On_Button(submit_UpdatedInfo);
		}
		
		catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterandSubmitUpdatedName", "FAIL");
			excelWrite.writeInCell("enterandSubmitUpdatedName Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterandSubmitUpdatedName", e.getMessage());
			throw e;
		}
}
	
	public void enterandSubmitUpdatedName1() throws Exception {
		try {
			
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//utility.click_On_Button(enter_UpdateName);
			enter_UpdateName.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			enter_UpdateName.clear();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(enter_UpdateName, (reader.getMapData(CommonVariable.update_First_Name, map)+Keys.TAB));

			
			extent_Reportlogger(":Sucessfully Done", "enterandSubmitUpdatedName", "PASS");

			
			excelWrite.writeInCell("enterandSubmitUpdatedName = " + reader.getMapData(CommonVariable.update_First_Name, map ), "Pass"); 
		
			utility.click_On_Button(submit_UpdatedInfo);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			vPAS_Close_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(click_OnChangePOABtn);
			
			utility.click_On_Button(submit_SendToVpas);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(click_On_Submit);
			
		
		}
		
		catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterandSubmitUpdatedName", "FAIL");
			excelWrite.writeInCell("enterandSubmitUpdatedName Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterandSubmitUpdatedName", e.getMessage());
			throw e;
		}
}
	public void submitAlphaUpdatedInfoToVPAS()throws Exception {
		
		try{
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(click_OnChangePOABtn);
			
			utility.click_On_Button(submit_SendToVpas);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(click_On_Submit);
			
			
		
			extent_Reportlogger(":SucessfullyDone", "submitAlphaUpdatedInfoToVPAS", "PASS");
			excelWrite.writeInCell(
					"submitAlphaUpdatedInfoToVPASDone", "Pass");
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "submitAlphaUpdatedInfoToVPAS", "FAIL");
			
			excelWrite.writeInCell(
					"submitAlphaUpdatedInfoToVPAS", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}

	public void enterWrapUpDetails() throws Exception {
		try {
			
			String details=reader.getMapData(CommonVariable.wrapUp_Details, map);
			wrapUpDetails_TxtBox.sendKeys(details);
			
			utility.click_On_Button(click_On_Submit);
			
			
	
			
			extent_Reportlogger("Test Step Execution Successfull", "enterWrapUpDetails_EndInteraction", "PASS");
			excelWrite.writeInCell("enterWrapUpDetails_EndInteraction Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterWrapUpDetails_EndInteraction", "FAIL");
			excelWrite.writeInCell("enterWrapUpDetails_EndInteraction Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterWrapUpDetails_EndInteraction", e.getMessage());
			throw e;
		}
}
}
	
	
	
	
