package com.pages.Investment_BO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class ValidationMessagesAllocation_Window extends Test_BaseClass{
	public ValidationMessagesAllocation_Window(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@node_name='MCDisplayValidateMsgs']//tr[1]//td[2]//label ")
	public WebElement validationMsgs_Txt;
	
	@FindBy(xpath="//table[@pl_prop_class='McCamish-Data-ValidateSummery']")
	public WebElement severity_Table;
	
	@FindBy(xpath = "//div[text()='Close']")
    public WebElement  vaidationPopupClose_Btn;
	
	@FindBy(xpath="//table[@param_name='EXPANDEDSubSectionMCDisplayValidateMsgsB']//div//table//tr[1]//td[1]//label")
	public WebElement invstmnt_ReviewMsz;
	
    @FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
	public WebElement invstmnt_validateMessagesTable;

    @FindBy(xpath = "//div[text()='Submit']")
    public WebElement submit_Btn;
    
    public void switchTo_Window(String windowTitle) throws Exception 
	{
		try
		{
			Thread.sleep(2000);
			for(String window : driver.getWindowHandles()){
				System.out.println("number of Windows: "+driver.getWindowHandles().size());
				driver.switchTo().window(window);
				 ((JavascriptExecutor) driver).executeScript("window.focus();");
				   System.out.println(":Window name: "+driver.getTitle());
				   if(driver.getTitle().equalsIgnoreCase(windowTitle)){
					   break;
				   }
				}
			driver.manage().window().maximize();
			
			extent_Reportlogger("Test Step Execution Successfull", "switchTo_Window("+windowTitle+")", "PASS");
 			excelWrite.writeInCell("switchTo_Window("+windowTitle+") Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
 			extent_Reportlogger("Test Step Execution failed", "switchTo_Window("+windowTitle+")", "FAIL");
 			excelWrite.writeInCell("switchTo_Window("+windowTitle+") Test Step Execution Unsuccessfull", "FAIL");
 			ErrorLogger.logError(e.getClass().getName(),"switchTo_Window("+windowTitle+")", e.getMessage());
 			throw e;
 		}
 }	
    
    public void validationMessages_Verification(String validationWindow) throws Exception {
 		try {
 			String msg1="",msg2="";
 			if(validationWindow.equalsIgnoreCase("CGO Allocation") || validationWindow.equalsIgnoreCase("DCAEvent")){
 				WebElement we=driver.findElement(By.xpath("//table[@param_name='EXPANDEDMCDisplayValidateMessagesSection']//table[2]"));
 				List<WebElement> tableContent=we.findElements(By.tagName("table"));
 				System.out.println("table size:"+tableContent.size());
 				if(tableContent.size()==0)
 				{
	 				msg2=driver.findElement(By.xpath("//div[@node_name='MCDisplayValidateMsgs']//div[@class='field-item dataLabelRead']")).getText();
	 	 			System.out.println("cgo_msg3 : "+msg2);
	 	 		}
 				else{
 	 				msg1=driver.findElement(By.xpath("//div[@node_name='MCDisplayValidateMsgs']//tr[1]//td[1]//label")).getText();
 	 	 			msg2=driver.findElement(By.xpath("//div[@node_name='MCDisplayValidateMsgs']//tr[1]//td[2]//label")).getText();
 	 	 			System.out.println("Msg1 : "+msg1);
 	 	 			System.out.println("Msg2 : "+msg2);
 	 			}
 			}
 			else{
 				msg1=driver.findElement(By.xpath("//div[@node_name='MCDisplayValidateMsgs']//tr[1]//td[1]//label")).getText();
 	 			msg2=driver.findElement(By.xpath("//div[@node_name='MCDisplayValidateMsgs']//tr[1]//td[2]//label")).getText();
 	 			System.out.println("Msg1 : "+msg1);
 	 			System.out.println("Msg2 : "+msg2);
 			}
 			
 			//div[@node_name='MCDisplayValidateMsgs']//table[@section_index='1']//tr[1]//td[1]//label
 			
 			List<WebElement> severity=driver.findElements(By.xpath("//tr[@oaargs[contains(.,'McCamish-Data')]]"));
 			if(msg1.equalsIgnoreCase("Please review the validation messages.")){
 				for(int i=2;i<=severity.size();i++){
 					String severityValue=driver.findElement(By.xpath("//tr["+i+"][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
 					if(severityValue.equalsIgnoreCase("Warning") || severityValue.equalsIgnoreCase("Info")){
 						if(i==severity.size()){
 	 						extent_Reportlogger("Test Step Execution Successfull: Error Severity is "+severityValue, "validationMessages_Verification", "PASS");
 	 						excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Error Severity is "+severityValue, "PASS");
 	 					}
 					}
 					else{
 						extent_Reportlogger("Test Step Execution failed: Error Severity other than Warning/Info displayed", "validationMessages_Verification", "FAIL");
 		 	 			excelWrite.writeInCell("validationMessages_Verification Test Step Execution Unsuccessfull: Error Severity other than Warning/Info displayed", "FAIL");
 		 	 			break;
 					}
 				}
 			}
 			else if(msg2.equalsIgnoreCase("There are no validation messages. ") || (msg2.equalsIgnoreCase("No Validation Messages"))){
 				extent_Reportlogger("Test Step Execution Successfull: No Error(There are no validation messages.)", "validationMessages_Verification", "PASS");
 	 			excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: No Error(There are no validation messages.)", "PASS");
 			}
 		} catch (Exception e) {
 			extent_Reportlogger("Test Step Execution failed", "validationMessages_Verification", "FAIL");
 			excelWrite.writeInCell("validationMessages_Verification Test Step Execution Unsuccessfull", "FAIL");
 			ErrorLogger.logError(e.getClass().getName(),"validationMessages_Verification", e.getMessage());
 			throw e;
 		}
 }
     
    public void closeButtonClick(String parentWindowName) throws Exception {
 		try {
 			vaidationPopupClose_Btn.click();
 			
 			switchTo_Window(parentWindowName);
 			
 			extent_Reportlogger("Test Step Execution Successfull", "closeButtonClick", "PASS");
 			excelWrite.writeInCell("closeButtonClick Test Step Execution Successfull", "PASS");
 		} catch (Exception e) {
 			extent_Reportlogger("Test Step Execution failed", "closeButtonClick", "FAIL");
 			excelWrite.writeInCell("closeButtonClick Test Step Execution Unsuccessfull", "Fail");
 			ErrorLogger.logError(e.getClass().getName(),"closeButtonClick", e.getMessage());
 			throw e;
 		}
    }

	public void proceedWithSubmitAfterValidation() throws Exception {
		try {
			submit_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "proceedWithSubmitAfterValidation", "PASS");
			excelWrite.writeInCell("proceedWithSubmitAfterValidation Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "proceedWithSubmitAfterValidation", "FAIL");
			excelWrite.writeInCell("proceedWithSubmitAfterValidation Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"proceedWithSubmitAfterValidation", e.getMessage());
			throw e;
		}
	}
}

