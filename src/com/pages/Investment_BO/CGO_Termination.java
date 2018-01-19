package com.pages.Investment_BO;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.utility.Test_BaseClass;


public class CGO_Termination extends Test_BaseClass{
	public CGO_Termination(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(id = "FinAcctSel")
	public WebElement premiumAccount_drpDwn;
	
	@FindBy(xpath = "//div[text()='Load Funds']")
	public WebElement loadFunds_Btn;
	
	@FindBy(xpath = "//table[@summary='Terminating CGO Funds']//table[@pl_prop_class='McCamish-Data-GetFundTransferData']")
	public WebElement cgoTerminating_Table;
	
	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement validate_Btn;
	
	@FindBy(xpath = "//div[text()='Edit']")
	public WebElement edit_Btn;
	
	@FindBy(xpath = "//div[text()='Submit']")
	public WebElement submit_Btn;
	
	@FindBy(xpath = "//button[text()='  Confirm ']")
	public WebElement confirm_Btn;
	
	@FindBy(id = "ReasonCode")
	public WebElement backDated_reason;
	
	@FindBy(id = "EffDate")
	public WebElement eff_Date;
	
	public void selectPremiumAccount() throws Exception {
		try {
			String premiumAccnt=reader.getMapData(CommonVariable.premium_Account, map);
			utility.selectvalueByText_DropdownList(premiumAccount_drpDwn,premiumAccnt);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "selectPremiumAccount", "PASS");
			excelWrite.writeInCell("selectPremiumAccount Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectPremiumAccount", "FAIL");
			excelWrite.writeInCell("selectPremiumAccount Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectPremiumAccount", e.getMessage());
			throw e;
		}
}
	public void enterEff_Date() throws Exception {
		try {
			String effc_Date=reader.getMapData(CommonVariable.effective_Date, map);
			eff_Date.sendKeys(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+effc_Date+Keys.TAB);
			Thread.sleep(1000);
			if(backDated_reason.isDisplayed()){
			String reason=reader.getMapData(CommonVariable.backdated_Reason, map);
			utility.dropdown_selectByValue(backDated_reason, reason);
			Thread.sleep(1000);
			}
			extent_Reportlogger("Test Step Execution Successfull", "enterEff_Date", "PASS");
			excelWrite.writeInCell("enterEff_Date Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterEff_Date", "FAIL");
			excelWrite.writeInCell("enterEff_Date Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterEff_Date", e.getMessage());
			throw e;
		}
}
	public void loadFunds_ButtonClick() throws Exception {
		try {
			loadFunds_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "loadFunds_ButtonClick", "PASS");
			excelWrite.writeInCell("loadFunds_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "loadFunds_ButtonClick", "FAIL");
			excelWrite.writeInCell("loadFunds_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"loadFunds_ButtonClick", e.getMessage());
			throw e;
		}
}

	public void selectCGOFundForTermination() throws Exception {
		try {
			List<WebElement> funds=cgoTerminating_Table.findElements(By.tagName("tr"));
			System.out.println("Actual Number of CGO "+funds.size());
			
			Random random = new Random();
			int n=random.nextInt(funds.size()-1)+2;
			
			driver.findElement(By.xpath("//table[@summary='Terminating CGO Funds']//table[@pl_prop_class='McCamish-Data-GetFundTransferData']//tr["+n+"]//td[1]//span")).click();
			
			extent_Reportlogger("Test Step Execution Successfull", "selectCGOFundForTermination", "PASS");
			excelWrite.writeInCell("selectCGOFundForTermination Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectCGOFundForTermination", "FAIL");
			excelWrite.writeInCell("selectCGOFundForTermination Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectCGOFundForTermination", e.getMessage());
			throw e;
		}
}

	public void enterTransferFundDetails_CGO_Termination() throws Exception {
		try {
			ExistingDCASchedule existingDCASchedule=new ExistingDCASchedule(driver);
			existingDCASchedule.enterFund_PercentDetails("CGOTermination","CGOTerminationToFunds");
			
			extent_Reportlogger("Test Step Execution Successfull", "enterTransferFundDetails_CGO_Termination", "PASS");
			excelWrite.writeInCell("enterTransferFundDetails_CGO_Termination Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterTransferFundDetails_CGO_Termination", "FAIL");
			excelWrite.writeInCell("enterTransferFundDetails_CGO_Termination Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterTransferFundDetails_CGO_Termination", e.getMessage());
			throw e;
		}
}

	public void validate_ButtonClick() throws Exception {
		try {
			validate_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "validate_ButtonClick", "PASS");
			excelWrite.writeInCell("validate_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "validate_ButtonClick", "FAIL");
			excelWrite.writeInCell("validate_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"validate_ButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void edit_ButtonClick() throws Exception {
		try {
			edit_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "edit_ButtonClick", "PASS");
			excelWrite.writeInCell("edit_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "edit_ButtonClick", "FAIL");
			excelWrite.writeInCell("edit_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"edit_ButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void submit_ButtonClick() throws Exception {
		try {
			submit_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "submit_ButtonClick", "PASS");
			excelWrite.writeInCell("submit_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "submit_ButtonClick", "FAIL");
			excelWrite.writeInCell("submit_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"submit_ButtonClick", e.getMessage());
			throw e;
		}
}
}
