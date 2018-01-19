package com.pages.Investment_BO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class Perform_Transactions extends Test_BaseClass{
	public Perform_Transactions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement validate_Btn;
	
	@FindBy(xpath = "//div[text()='Submit']")
	public WebElement submit_Btn;
	
	
	public void validateButtonClick() throws Exception {
		try {
			validate_Btn.click();
			Thread.sleep(2000);
			
			extent_Reportlogger("Test Step Execution Successfull", "validateButtonClick", "PASS");
			excelWrite.writeInCell("validateButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "validateButtonClick", "FAIL");
			excelWrite.writeInCell("validateButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"validateButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void submitButtonClick() throws Exception {
		try {
			submit_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "submitButtonClick", "PASS");
			excelWrite.writeInCell("submitButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "submitButtonClick", "FAIL");
			excelWrite.writeInCell("submitButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"submitButtonClick", e.getMessage());
			throw e;
		}
}

	
}
