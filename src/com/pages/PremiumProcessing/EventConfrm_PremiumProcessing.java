package com.pages.PremiumProcessing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class EventConfrm_PremiumProcessing extends  Test_BaseClass  {
	
	public EventConfrm_PremiumProcessing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Remittance')]")
	public WebElement click_AddRemittance;
	
	@FindBy(xpath = "//select[@id='EvntCode']")
	public WebElement Select_EvntCode;
	
	@FindBy(id = "PmtAmt")
	public WebElement Select_PmtAmt;
	
	@FindBy(xpath = "//select[@id='DepAcctID']")
	public WebElement Select_DepAcctID;
	
	@FindBy(id = "InterestAmt")
	public WebElement entert_InterestAmt;
	
	@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Event Details']")
	public WebElement EventDetails;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement click_Validate;
	
	@FindBy(id = "LoanAmt")
	public WebElement Select_LoanAmt;
	
	@FindBy(id = "DepAmt")
	public WebElement Select_DepAmt;
	
	
	
	
	public void eventCodeSelectionProcess() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(click_AddRemittance);
			
			utility.selectvalueByText_DropdownList(Select_EvntCode, reader.getMapData(CommonVariable.EventType, map));
			 String EventValue = reader.getMapData(CommonVariable.EventType, map);
			 
			excelWrite.writeInCell(
					"Selection of EventCode for Remittance PremiumPymnt is Done = " +EventValue, "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully" +EventValue, "Selection of EventCode for Remittance PremiumPymnt", "PASS");
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "eventCodeSelectionProcess", "FAIL");
			excelWrite.writeInCell("eventCodeSelectionProcess Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"eventCodeSelectionProcess", e.getMessage());
			throw e;
		}
}

	public void enterCashAmountProc() throws Exception {
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			String enterAmount2 = reader.getMapData(CommonVariable.enter_cashAmnt, map);
			System.out.println("Amount"  + reader.getMapData(CommonVariable.enter_cashAmnt, map));
			Select_PmtAmt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmount2); 
			
			
			excelWrite.writeInCell(
					"Enter PaymentAmount for Remittance PremiumPymnt is Done : Amount is :  = " +enterAmount2, "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully : Amount is : " +enterAmount2, "Enter PaymentAmount for Remittance PremiumPymnt", "PASS");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterCashAmountProc", "FAIL");
			excelWrite.writeInCell("enterCashAmountProc Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterCashAmountProc", e.getMessage());
			throw e;
		}
}
	public void enterDepAcctID() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(Select_DepAcctID, reader.getMapData(CommonVariable.enter_DepAcctID, map));
			String enterAmount2 = reader.getMapData(CommonVariable.enter_DepAcctID, map);
		
			excelWrite.writeInCell(
					"Enter DepositeAccountId for Remittance PremiumPymnt is Done : Value is :  = " +enterAmount2, "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully : Value is : " +enterAmount2, "Enter DepositeAccountId for Remittance PremiumPymnt", "PASS");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
			String enterDepoAmount = reader.getMapData(CommonVariable.enter_cashAmnt, map);
			System.out.println("Amount"  + reader.getMapData(CommonVariable.enter_cashAmnt, map));
			Select_DepAmt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterDepoAmount); 
			
			excelWrite.writeInCell(
					"Enter DepositeAmount for Remittance PremiumPymnt is Done : Amount is :  = " +enterDepoAmount, "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully : Amount is : " +enterDepoAmount, "Enter DepositeAmount for Remittance PremiumPymnt", "PASS");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterDepAcctID", "FAIL");
			excelWrite.writeInCell("enterDepAcctID Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterDepAcctID", e.getMessage());
			throw e;
		}
}
	
	public void clickOnValidateBtn() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(EventDetails);
			
			excelWrite.writeInCell(
					"EventDetails button clicked", "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully ", "Click OnEventDetail Button", "PASS");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			utility.click_On_Button(click_Validate);
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "clickOnValidateBtn", "FAIL");
			excelWrite.writeInCell("clickOnValidateBtn Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"clickOnValidateBtn", e.getMessage());
			throw e;
		}
}
	public void enterIntrstAmnt() throws Exception {
		try {
			
			String enterAmountIntrst = reader.getMapData(CommonVariable.enter_cashAmnt, map);
			System.out.println("Amount"  + reader.getMapData(CommonVariable.enter_cashAmnt, map));
		
			entert_InterestAmt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmountIntrst);
			
			 
			excelWrite.writeInCell(
					"enterIntrstAmount for Remittance PremiumPymnt is Done : Amount is :  = " +enterAmountIntrst, "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully : Amount is : " +enterAmountIntrst, "Enter IntrestAMount for Remittance PremiumPymnt", "PASS");
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "action_LinkClick", "FAIL");
			excelWrite.writeInCell("action_LinkClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"action_LinkClick", e.getMessage());
			throw e;
		}
}
	public void enterLoanAmount() throws Exception {
		try {
			
			
			String enter_LoanAmtt = reader.getMapData(CommonVariable.enter_LoanAmt, map);
			System.out.println("Amount"  + reader.getMapData(CommonVariable.enter_LoanAmt, map));
			Select_LoanAmt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enter_LoanAmtt,Keys.TAB); 
			
			excelWrite.writeInCell(
					"Enter LoanAMount for Remittance PremiumPymnt is Done : Amount is :  = " +enter_LoanAmtt, "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully : Amount is : " +enter_LoanAmtt, "Enter LoanAmount for Remittance PremiumPymnt", "PASS");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterLoanAmount", "FAIL");
			excelWrite.writeInCell("enterLoanAmount Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterLoanAmount", e.getMessage());
			throw e;
		}
}

	public void clickEventDetails() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.click_On_Button(EventDetails);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
			utility.click_On_Button(EventDetails);
			
			excelWrite.writeInCell(
					"Click on EventDetails Tab: Test Step Executed Successfully  " , "Pass");	
			extent_Reportlogger(":Test Step Executed Successfully " , "Click on EventDetails Tab", "PASS");
		
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(click_Validate);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterLoanAmount", "FAIL");
			excelWrite.writeInCell("enterLoanAmount Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterLoanAmount", e.getMessage());
			throw e;
		}
}
	public void clickEventDetailsAndValidateBtn() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.click_On_Button(EventDetails);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.click_On_Button(EventDetails);
			excelWrite.writeInCell(
					"Select EventDetails Test Step Executed Successfully", "Pass");	
			extent_Reportlogger("Test Step Executed Successfully", "EventDetails", "PASS");
			utility.click_On_Button(click_Validate);
			
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "clickEventDetailsAndValidateBtn", "FAIL");
			excelWrite.writeInCell("clickEventDetailsAndValidateBtn Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"clickEventDetailsAndValidateBtn", e.getMessage());
			throw e;
		}
}
}
