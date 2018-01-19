package com.pages.commonFunctionality;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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


public class RestrictedPersonCheck extends Initialize_Browser{
	
BaseUtils utility = new BaseUtils(driver);
public RestrictedPersonCheck(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(id = "Finding1")
	public WebElement ofac_drpDwn;
	
	@FindBy(xpath = "//button[text()='  Submit ']")
	public WebElement submit_Btn;
	
	public void ofacProcessDecisionTask() throws Exception
	{
		try{
			utility.dropdown_selectByVisibleText(ofac_drpDwn,"Yes");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","ofacProcessDecisionTask", "PASS");
			excelWrite.writeInCell("ofacProcessDecisionTask Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "ofacProcessDecisionTask", "FAIL");
			excelWrite.writeInCell("ofacProcessDecisionTask Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"ofacProcessDecisionTask", e.getMessage());
			throw e;
	}
	}
	
}
