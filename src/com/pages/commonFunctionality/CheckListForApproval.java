package com.pages.commonFunctionality;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class CheckListForApproval extends Initialize_Browser{
	public CheckListForApproval(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@id='pyActionArea']//label")
	public WebElement apprvlMsg;
	
	@FindBy(id = "submitButton")
	public WebElement next_Btn;
	

	public void submitForApproval() throws Exception{
		//Click on Submit Button for Approval
		try{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-100)", "");
			next_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			if(apprvlMsg.getText().equals("The Check List has been Submited for Approval")){
				extent_Reportlogger("Test Step Execution successfull: Actual Message is same as Expected Message","submitForApproval", "PASS");
				excelWrite.writeInCell("submitForApproval Test Step Execution successfull: Actual Message differs from Expected Message", "PASS");
			}else{
				extent_Reportlogger("Test Step Execution failed: Actual Message differs from Expected Message","submitForApproval", "FAIL");
				excelWrite.writeInCell("submitForApproval Test Step Execution failed: Actual Message differs from Expected Message", "Fail");
			}
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "submitForApproval", "FAIL");
			excelWrite.writeInCell("submitForApproval Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"submitForApproval", e.getMessage());
			throw e;
	}
	}
	
	public void submitForConfirmation() throws Exception{
		//Click on Submit Button for Confirmation
		try{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-100)", "");
			next_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			extent_Reportlogger("Test Step Execution successfull","submitForConfirmation", "PASS");
			excelWrite.writeInCell("submitForConfirmation Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "submitForConfirmation", "FAIL");
			excelWrite.writeInCell("submitForConfirmation Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"submitForConfirmation", e.getMessage());
			throw e;
	}
	}
}
