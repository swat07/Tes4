package com.pages.Investment_BO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class VPAS_Confirmation extends Test_BaseClass{
	public VPAS_Confirmation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='I am done']")
    public WebElement  iAmDone_Btn;
	
	@FindBy(xpath = "//button[text()='  Done ']")
    public WebElement  done_Btn;
	
	@FindBy(xpath = "//button[text()='  Submit ']")
    public WebElement  submit_Btn;

	public void iAmDone_ButtonClick() throws Exception {
 		try {
 			iAmDone_Btn.click();
 			
 			extent_Reportlogger("Test Step Execution Successfull", "iAmDone_ButtonClick", "PASS");
 			excelWrite.writeInCell("iAmDone_ButtonClick Test Step Execution Successfull", "PASS");
 		} catch (Exception e) {
 			extent_Reportlogger("Test Step Execution failed", "iAmDone_ButtonClick", "FAIL");
 			excelWrite.writeInCell("iAmDone_ButtonClick Test Step Execution Unsuccessfull", "Fail");
 			ErrorLogger.logError(e.getClass().getName(),"iAmDone_ButtonClick", e.getMessage());
 			throw e;
 		}
 }
	
	public void done_ButtonClick() throws Exception {
 		try {
 			done_Btn.click();
 			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
 			
 			extent_Reportlogger("Test Step Execution Successfull", "done_Btn", "PASS");
 			excelWrite.writeInCell("done_Btn Test Step Execution Successfull", "PASS");
 		} catch (Exception e) {
 			extent_Reportlogger("Test Step Execution failed", "done_Btn", "FAIL");
 			excelWrite.writeInCell("done_Btn Test Step Execution Unsuccessfull", "Fail");
 			ErrorLogger.logError(e.getClass().getName(),"done_Btn", e.getMessage());
 			throw e;
 		}
 }
	
	public void done_ButtonClick_DCAEvent() throws Exception {
 		try {
 			driver.findElement(By.xpath("//div[text()='Done']")).click();
 			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
 			
 			extent_Reportlogger("Test Step Execution Successfull", "done_ButtonClick_DCAEvent", "PASS");
 			excelWrite.writeInCell("done_ButtonClick_DCAEvent Test Step Execution Successfull", "PASS");
 		} catch (Exception e) {
 			extent_Reportlogger("Test Step Execution failed", "done_ButtonClick_DCAEvent", "FAIL");
 			excelWrite.writeInCell("done_ButtonClick_DCAEvent Test Step Execution Unsuccessfull", "Fail");
 			ErrorLogger.logError(e.getClass().getName(),"done_ButtonClick_DCAEvent", e.getMessage());
 			throw e;
 		}
 }
	
	public void cgoConfirmationSubmit_ButtonClick() throws Exception {
 		try {
 			submit_Btn.click();
 			
 			extent_Reportlogger("Test Step Execution Successfull", "done_Btn", "PASS");
 			excelWrite.writeInCell("done_Btn Test Step Execution Successfull", "PASS");
 		} catch (Exception e) {
 			extent_Reportlogger("Test Step Execution failed", "done_Btn", "FAIL");
 			excelWrite.writeInCell("done_Btn Test Step Execution Unsuccessfull", "Fail");
 			ErrorLogger.logError(e.getClass().getName(),"done_Btn", e.getMessage());
 			throw e;
 		}
 }
}
