package com.pages.commonScreens_CP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class Owner_Verification extends Initialize_Browser{
	public Owner_Verification(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(id = "VerifyAll")
	public WebElement veryQsns_ChkBox;
	
	
	public void select_VerifyAllQsns_CheckBox() throws Exception {
		try {
			veryQsns_ChkBox.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "select_VerifyAllQsns_CheckBox", "PASS");
			excelWrite.writeInCell("select_VerifyAllQsns_CheckBox Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "select_VerifyAllQsns_CheckBox", "FAIL");
			excelWrite.writeInCell("select_VerifyAllQsns_CheckBox Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"select_VerifyAllQsns_CheckBox", e.getMessage());
			throw e;
		}
}
	
	public void verifyAllQsnsAndSubmit() throws Exception {
		try {
			select_VerifyAllQsns_CheckBox();
			Policy_Search policy_Search=new Policy_Search(driver);
			policy_Search.submit_ButtonClick();
			
			extent_Reportlogger("Test Step Execution Successfull", "verifyAllQsnsAndSubmit", "PASS");
			excelWrite.writeInCell("verifyAllQsnsAndSubmit Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "verifyAllQsnsAndSubmit", "FAIL");
			excelWrite.writeInCell("verifyAllQsnsAndSubmit Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"verifyAllQsnsAndSubmit", e.getMessage());
			throw e;
		}
}
}
