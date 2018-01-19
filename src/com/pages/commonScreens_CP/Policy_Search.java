package com.pages.commonScreens_CP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class Policy_Search extends Initialize_Browser{
	public Policy_Search(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	//BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(id = "SearchFilterPolicyNumberFilter")
	public WebElement policyNo_RadioBtn;
	
	@FindBy(id = "SearchValue")
	public WebElement startingWith_TxtBox;
	
	@FindBy(id = "submitButton")
	public WebElement submit_Btn;
	
	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement validate_Btn;
	
	@FindBy(xpath = "//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']")
	public WebElement investmentFunds_Table;
	
	public void selectPolicyNoRadioButton_EnterPolicyNo() throws Exception {
		try {
			driver.switchTo().frame("cpmInteractionDivFrame").switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			System.out.println("CP frame");
			policyNo_RadioBtn.click();
			
			String policy_Number=reader.getMapData(CommonVariable.policy_Number, map);
			startingWith_TxtBox.sendKeys(policy_Number);
			
			extent_Reportlogger("Test Step Execution Successfull", "selectPolicyNoRadioButton_EnterPolicyNo", "PASS");
			excelWrite.writeInCell("selectPolicyNoRadioButton_EnterPolicyNo Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectPolicyNoRadioButton_EnterPolicyNo", "FAIL");
			excelWrite.writeInCell("selectPolicyNoRadioButton_EnterPolicyNo Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectPolicyNoRadioButton_EnterPolicyNo", e.getMessage());
			throw e;
		}
}
	
	public void submit_ButtonClick() throws Exception {
		try {
			Thread.sleep(2000);
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

	public void policySearch() throws Exception {
		try {
			selectPolicyNoRadioButton_EnterPolicyNo();
			submit_ButtonClick();
			driver.switchTo().frame(driver.switchTo().activeElement());
			submit_ButtonClick();
			
			extent_Reportlogger("Test Step Execution Successfull", "policySearch", "PASS");
			excelWrite.writeInCell("policySearch Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "policySearch", "FAIL");
			excelWrite.writeInCell("policySearch Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"policySearch", e.getMessage());
			throw e;
		}
}
	
}
