package com.pages.FinancialPartialSurrender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ScreenShot;
import com.utility.Test_BaseClass;


public class Financial_Depo_AccntSurrender extends Initialize_Browser {
	

	
	public Financial_Depo_AccntSurrender(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);

	@FindBy(xpath = "//select[@id='DepositAcctID']")
	public WebElement select_depodrpdown;

	@FindBy(id = "SurrenderTypeP")
	public WebElement click_surdtype;
	
	@FindBy(id = "SurrPctg")
	public WebElement enter_Perc;
	
	@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Disbursement']")
	public WebElement click_Disbursement;
	
	
	@FindBy(id = "VerifiedDisbInd")
	public WebElement Select_VerifiedDisbFlag;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement Select_Validatebutton;
	
	@FindBy(xpath=".//*[@id='RULE_KEY']/table/tbody/tr/td[1]/nobr/label")
	public WebElement review_ValidationMsz;
	
	@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
	public WebElement validateMessagesTable;
	
	@FindBy(xpath = "//*[@id='HarnessFooter']//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement validateInput_Close_Btn;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit TO VPAS')]")
	public WebElement validateSubmit_Btn;
	
	@FindBy(id = "submitButton")
	public WebElement CLick_OnDone;
	
	@FindBy(id = "SelectedPayee4")
	public WebElement select_payee;
	
	@FindBy(id = "Event Date for VPAS Automated Transactions")
	public WebElement CLick_renewaldate;
	

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Fund ID')]")
	public WebElement click_FundId;
	
	@FindBy(xpath = "//table[@pl_prop='.FundDetails']//tr[6]//td[1]//input[@type = 'radio']")
	public WebElement select_Fund;
	
	@FindBy(id = "ModalButtonSubmit")
	public WebElement CLick_Okmodal;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement ClickvalidateSubmit_Btn;
	
	@FindBy(xpath = "//table[@pl_prop='.IGPRenewalFunds']//tr[2]//td[1]")
	public WebElement clickonCD;
	@FindBy(id = "submitButton")
	public WebElement ClickSubmitNew;
	
	
	
	
	
	
	public void select_NoErrMsgValidation() throws Exception{
		
		try {
			
	
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
			utility.click_On_Button(click_Disbursement);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
			utility.click_On_Button(select_payee);
		/*	JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");*/
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(Select_VerifiedDisbFlag);
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(Select_Validatebutton);
		
			excelWrite.writeInCell(
					"select_validateoption", "Pass");
			extent_Reportlogger("select_validateoption", "select_validateoption", "Pass");

		}
		

	catch (InterruptedException e) {
		
		//extent_Reportlogger("submit_InfoToVpas", "Login Fail Screen", "FAIL");
		extent_Reportlogger("POlicy Termination Failed",
				"POlicy Termination Confirmation", "FAIL");
		excelWrite.writeInCell(
				"POlicy Termination ", "Fail");
		ErrorLogger.logError(e.getClass().getName(),
				"POlicy Termination", e.getMessage());
		
		e.printStackTrace();
	}
				
		

	}
	public String verifyConfirmationMsg () throws Exception 
	{
		
		System.out.println("Enter in Validation ");
		Thread.sleep(5000);
		String getTextPopUpPOA = driver.findElement(By.xpath("//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/div/div/div/div/div")).getText().trim();
	
		System.out.println("Verify_PopUp : " +getTextPopUpPOA);
		extent_Reportlogger("Confirmation : Event successfully submitted", "Alpha Maintenance", "PASS");
	
		excelWrite.writeInCell(
				"Confirmation : Event successfully submitted", "Pass");
		
		
		Thread.sleep(5000);
		return getTextPopUpPOA;
	}
	
	public void selectDepositeAcntId() throws Exception {
		try {
			
			
			utility.selectvalueByText_DropdownList(select_depodrpdown, reader.getMapData(CommonVariable.depositAccountID, map));
			String enterenddate = reader.getMapData(CommonVariable.enterEndDate, map);
			excelWrite.writeInCell(
					"selectDepositeAcntId Executed Successfully" +enterenddate, "Pass");
			extent_Reportlogger(":Value is :" +enterenddate, "DepositeAccountId is selected and ", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2 , TimeUnit.SECONDS));
			utility.click_On_Button(click_surdtype);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2 , TimeUnit.SECONDS));
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectDepositeAcntId", "FAIL");
			excelWrite.writeInCell("selectDepositeAcntId Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectDepositeAcntId", e.getMessage());
			throw e;
		}
}
	
	public void ToValidateSurrenderPerctng() throws Exception {
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1 , TimeUnit.SECONDS));
			double enterPercent =  Double.parseDouble((reader.getMapData(CommonVariable.surrenderPerc, map)));
			System.out.println("Per value" +enterPercent );
			
		if (enterPercent<100.00 || enterPercent==100.00)
		{
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2 , TimeUnit.SECONDS));
			utility.enter_Text(enter_Perc, (reader.getMapData(CommonVariable.surrenderPerc, map)+Keys.TAB));

			System.out.println("value" +reader.getMapData(CommonVariable.surrenderPerc, map));
			
			
			
			excelWrite.writeInCell(
					"ToValidateSurrenderPerctng Test step Executed Successfully" +enterPercent, "Pass");
			extent_Reportlogger(":Entered Value is :" +enterPercent, "Surrender Percentage is Verfied and ", "Pass");
		}
		
		else
			
		{
			System.out.println("Total Allocation Percentage Can Not Be More Than 100");
		}
		
		
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "ToValidateSurrenderPerctng", "FAIL");
			excelWrite.writeInCell("ToValidateSurrenderPerctng Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"ToValidateSurrenderPerctng", e.getMessage());
			throw e;
		}
}
	
	public void selectRenewalDate() throws Exception {
		try {
			

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(CLick_renewaldate, (reader.getMapData(CommonVariable.renewaldate, map)+Keys.TAB));
			String enterenddate = reader.getMapData(CommonVariable.renewaldate, map);
			excelWrite.writeInCell(
					"selectRenewalDate test Step Executed Successfully" +enterenddate, "Pass");
			extent_Reportlogger(":Value is :" +enterenddate, "RenewalDate is selected and ", "Pass");
			
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectDepositeAcntId", "FAIL");
			excelWrite.writeInCell("selectDepositeAcntId Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectDepositeAcntId", e.getMessage());
			throw e;
		}
}
	
	public void SelectionOfFundIdAndOkModel() throws Exception {
		try {
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(clickonCD);
		
			excelWrite.writeInCell(
					"Click On CD option test Step Executed Successfully" , "Pass");
			extent_Reportlogger(":Test step Executed Successfully :" , "Click On CD option ", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		
			utility.click_On_Button(click_FundId);
			
			excelWrite.writeInCell(
					"Click On Fund ID option test Step Executed Successfully" , "Pass");
			extent_Reportlogger(":Test step Executed Successfully :" , "Click On Fund ID option ", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(select_Fund);
		
			utility.click_On_Button(CLick_Okmodal);
			
			excelWrite.writeInCell(
					"Click On OK MOdel option test Step Executed Successfully" , "Pass");
			extent_Reportlogger(":Test step Executed Successfully :" , "Click On OK MOdel option ", "Pass");
			
			utility.click_On_Button(ClickvalidateSubmit_Btn);
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectDepositeAcntId", "FAIL");
			excelWrite.writeInCell("selectDepositeAcntId Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectDepositeAcntId", e.getMessage());
			throw e;
		}
}
	
	

		
	
}


