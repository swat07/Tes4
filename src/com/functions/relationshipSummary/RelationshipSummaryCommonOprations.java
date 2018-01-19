package com.functions.relationshipSummary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.RelationshipSummary.RelationshipSummary_Owner_Change;
import com.pages.RelationshipSummary.callPortal.CP_ReltnSummaryAssigneemaintenance;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
//import com.utility.excelWrite;
import com.utility.Test_BaseClass;

public class RelationshipSummaryCommonOprations extends Test_BaseClass
{
	
	BaseUtils utility = new BaseUtils(driver);


	public RelationshipSummaryCommonOprations(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@base_ref='pyWorkPage']//li//table//label[text()='Email Information']")
	public WebElement click_EmailInformation1;
	
	public void checkingEffectiveDate() throws Exception{
		try{
			
			CP_ReltnSummaryAssigneemaintenance ReltnSummaryAssigneemaintenance= new CP_ReltnSummaryAssigneemaintenance(driver);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			if (!(reader.getMapData(CommonVariable.enterEffectiveDate, map) == null || reader.getMapData(CommonVariable.enterEffectiveDate, map) == ""))
			{
				System.out.println("inside date");
				ReltnSummaryAssigneemaintenance.effectiveDate.clear();
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				utility.enter_Text(ReltnSummaryAssigneemaintenance.effectiveDate, reader.getMapData(CommonVariable.enterEffectiveDate, map));
				
				excelWrite.writeInCell(
						reader.getMapData(CommonVariable.enterEffectiveDate, map)
								+ ": Effective date entered", "pass");
				extent_Reportlogger(" :Executed successfully", "EffectiveDate", "pass");
			
			}
		
		}
		
			 catch (Exception e) {
					extent_Reportlogger("Test Step Execution failed", "checkingEffectiveDate", "FAIL");
					excelWrite.writeInCell("checkingEffectiveDate Test Step Execution Unsuccessfull", "Fail");
					ErrorLogger.logError(e.getClass().getName(),"checkingEffectiveDate", e.getMessage());
					throw e;
				}
		}
			
			
		
		
	

	//Method for Enter UserDetails
	

	public void enter_UserPersonalDetails() throws Exception {
	try {
			//ReltnSummaryAssigneemaintenance = new CP_ReltnSummaryAssigneemaintenance(driver);
		CP_ReltnSummaryAssigneemaintenance ReltnSummaryAssigneemaintenance= new CP_ReltnSummaryAssigneemaintenance(driver);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,400)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_FirstName,(reader.getMapData(CommonVariable.enter_FirstName, map )+Keys.TAB));
			
		
			
			extent_Reportlogger(":Sucessfully Done and Value is :"+ reader.getMapData(CommonVariable.enter_FirstName, map ), "enter_FirstName", "PASS");

			
			excelWrite.writeInCell("Enter First Name = " + reader.getMapData(CommonVariable.enter_FirstName, map ), "Pass"); 
			utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_LastName, (reader.getMapData(CommonVariable.enter_LastName, map)+Keys.TAB));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger(":Sucessfully Done and Value is :"+ reader.getMapData(CommonVariable.enter_LastName, map ), "enter_LastName", "PASS");

			
			excelWrite.writeInCell("Enter Last Name = " + reader.getMapData(CommonVariable.enter_LastName, map ), "Pass"); 
	
			String ssN_Number=reader.getMapData(CommonVariable.enter_SSNNumber, map);
			
			String regex = "\\d{9}";
			
			if(ssN_Number.matches(regex))
			{
				
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_SSNNUmber, (reader.getMapData(CommonVariable.enter_SSNNumber, map)+Keys.TAB));
				
				
				
				extent_Reportlogger(":Sucessfully Done and Value is :" +reader.getMapData(CommonVariable.enter_SSNNumber, map), "Entered_SSNNUmber", "PASS");
	
				
				excelWrite.writeInCell("Enter SSNNumber = " + reader.getMapData(CommonVariable.enter_SSNNumber, map ), "Pass"); 
		
		
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_BirthDate, (reader.getMapData(CommonVariable.enter_Birthdate, map)+Keys.TAB));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				
			}
			
				else {
				
					extent_Reportlogger("User Entered wrong SSN 9 digitnumber!!!", "SSN NUmber for contact change screen", "PASS");
					excelWrite.writeInCell("Enter SSNNumber = " + reader.getMapData(CommonVariable.enter_SSNNumber, map ), "Pass"); 
			
				}
			
				
				
				excelWrite.writeInCell(
						"enter_UserPersonalDetailsSuccessfullyDone", "Pass");
				extent_Reportlogger(":SuccessfullyDone", "enter_UserPersonalDetails", "PASS");
	
		
		}
		
	 catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enter_UserPersonalDetails", "FAIL");
			excelWrite.writeInCell("enter_UserPersonalDetails Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enter_UserPersonalDetails", e.getMessage());
			throw e;
		}
}
	
	public void chkValidEmailId() throws Exception {
		try {
				
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			Actions actions = new Actions(driver);
			actions.moveToElement(click_EmailInformation1).doubleClick().perform();
				
	
			CP_ReltnSummaryAssigneemaintenance ReltnSummaryAssigneemaintenance= new CP_ReltnSummaryAssigneemaintenance(driver);
			utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_EmailInfo, (reader.getMapData(CommonVariable.enter_New_Email, map)+Keys.TAB));
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			String emailId = reader.getMapData(CommonVariable.enter_New_Email, map);
			
			String confEmailId = reader.getMapData(CommonVariable.enter_Confirm_Email, map);
			if(emailId.equals(confEmailId))
			{
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_ConfirmEmailInfo, (reader.getMapData(CommonVariable.enter_Confirm_Email, map)+Keys.TAB));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				excelWrite.writeInCell(
						"EmailConfirmationisDone", "Pass");
				extent_Reportlogger(":SuccessfullyDone", "EmailConfirmation", "PASS");
				
	
				
			}
			else if(! emailId.equals(confEmailId))
			{
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_ConfirmEmailInfo, (reader.getMapData(CommonVariable.enter_Confirm_Email, map)+Keys.TAB));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				String invalidEmailidText =ReltnSummaryAssigneemaintenance.Select_invalidIderrMsg.getText().trim();
				System.out.println("Status Actual: "+invalidEmailidText);
				
				excelWrite.writeInCell(
						"EmailConfirmationisDone", "Pass");
				extent_Reportlogger(":SuccessfullyDone", "EmailConfirmation", "PASS");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				ReltnSummaryAssigneemaintenance.click_SubmitAplha.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
	
				
			}
	
			else{
				
				utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_ConfirmEmailInfo, (reader.getMapData(CommonVariable.enter_Confirm_Email, map)+Keys.TAB));
				extent_Reportlogger("Failed:New&ConfirmEmailIdshouldNotSame", "EmailConfirmation", "Fail");
				excelWrite.writeInCell("emailIdConfirmMsz = " + reader.getMapData(CommonVariable.emailIdConfirmMsz, map ), "Fail");	
				//Please ensure that new & confirm email address values are same
			
			}
		
			
			
			}
			
		catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "EmailConfirmation", "FAIL");
			excelWrite.writeInCell("EmailConfirmation Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"EmailConfirmation", e.getMessage());
			throw e;
		}
	}
		
	
	

	
	
	public void verifyPOPUPMsg() throws Exception {

		
		try {
			
			CP_ReltnSummaryAssigneemaintenance ReltnSummaryAssigneemaintenance= new CP_ReltnSummaryAssigneemaintenance(driver);
			ReltnSummaryAssigneemaintenance.click_SubmitAplha.click();
			System.out.println("INside PopUp");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5,
					TimeUnit.SECONDS));
			String validationmsgactual=ReltnSummaryAssigneemaintenance.SelectPOPUpMsz.getText().trim();
			System.out.println("Status Actual: "+validationmsgactual);
				
			 if(validationmsgactual.equals(reader.getMapData(CommonVariable.expectedPOPUpMsg, map)))
				 
				 
			 {
				 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,
							TimeUnit.SECONDS));
				 System.out.println("Status Expected: "+reader.getMapData(CommonVariable.expectedPOPUpMsg, map));
				
				 extent_Reportlogger(":Sucessfully Done " +validationmsgactual, "VerifyPOPUPMsg", "PASS");

				excelWrite.writeInCell("VerifyPOPUPMsg = " + validationmsgactual, "Pass"); 

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5,
						TimeUnit.SECONDS));
					Actions action = new Actions(driver);
					action.moveToElement(ReltnSummaryAssigneemaintenance.vPAS_Close_Btn)
							.click().perform();

					extent_Reportlogger(":Sucessfully Done", "vPAS_Close_Btn click", "PASS");

					excelWrite.writeInCell("Test Step Executed Successfully:vPAS_Close_Btn" , "Pass");
			
			 }
			 else{
				 
				 extent_Reportlogger("Fail :incorrectMessage", "VerifyPOPUPMsg", "PASS");

					excelWrite.writeInCell("IncorrectMessagePOPUPMsg" , "Pass"); 

				 
			 }
		}
		
		catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "VerifyPOPUPMsg", "FAIL");
			excelWrite.writeInCell("VerifyPOPUPMsg Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"VerifyPOPUPMsg", e.getMessage());
			throw e;
		}
}

	
	
	
	
	public void editUserPersonalDetails() throws Exception {
		try {
			CP_ReltnSummaryAssigneemaintenance ReltnSummaryAssigneemaintenance= new CP_ReltnSummaryAssigneemaintenance(driver);
			
			
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				ReltnSummaryAssigneemaintenance.enter_UpdateName.clear();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.enter_Text(ReltnSummaryAssigneemaintenance.enter_UpdateName, (reader.getMapData(CommonVariable.update_First_Name, map)+Keys.TAB));
				
				extent_Reportlogger(":Sucessfully Done", "enter_UpdateNameContingent", "PASS");
				excelWrite.writeInCell("enter_UpdateNameContingent = " + reader.getMapData(CommonVariable.update_First_Name, map ), "PASS"); 
				ReltnSummaryAssigneemaintenance.clkSubmitbtn.click();
		
		
			}
			
			catch(Exception e)
			{
				extent_Reportlogger(":Fail", "enter_UpdateNameContingent", "Fail");
				excelWrite.writeInCell("enter_UpdateNameContingent fail = " + reader.getMapData(CommonVariable.update_First_Name, map ), "Fail"); 
			}
		}
	
	
	public void verifyAddedInfoPOPUPMsg() throws Exception {

		
		try {
			
			CP_ReltnSummaryAssigneemaintenance ReltnSummaryAssigneemaintenance= new CP_ReltnSummaryAssigneemaintenance(driver);
		System.out.println("Insidee Popup");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,
					TimeUnit.SECONDS));
			String validationmsgactual=ReltnSummaryAssigneemaintenance.SelectAddedInfoPOPUpMsz.getText().trim();
			String[] actualMessage_Values = validationmsgactual.split(":");
			String actualValue=actualMessage_Values[2];
		
			System.out.println("actualMessageValues" +actualMessage_Values[2]);
			System.out.println("Excelvalue " +(reader.getMapData(CommonVariable.expectedAddedPOPUpMsg, map)));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,
					TimeUnit.SECONDS));
				
			 if(actualValue.equals(reader.getMapData(CommonVariable.expectedAddedPOPUpMsg, map)))
				 
				 
			 {
				 	/**/
				 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5,
							TimeUnit.SECONDS));
	
				 
				 ReltnSummaryAssigneemaintenance.vPAS_Close_Btn.click();
				 
				 extent_Reportlogger(":Sucessfully Done" +validationmsgactual, "VerifyAddedPOPUPMsg", "PASS");

					excelWrite.writeInCell("VerifyAddedPOPUPMsg = " + validationmsgactual, "Pass"); 
				
				/* extent_Reportlogger(":Sucessfully Done", "vPAS_Close_Btn", "PASS");

				excelWrite.writeInCell("vPAS_Close_Btnis done", "Pass");*/ 
				


			 }
			 else{
				 
				 extent_Reportlogger("Fail :incorrectMessage", "VerifyPOPUPMsg", "PASS");

					excelWrite.writeInCell("IncorrectMessagePOPUPMsg" , "Pass"); 

				 
			 }
		}
		
		catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "VerifyEditPOPUPMsg", "FAIL");
			excelWrite.writeInCell("VerifyEditPOPUPMsg Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"VerifyEditPOPUPMsg", e.getMessage());
			throw e;
		}
}

	
	
	
	
}
