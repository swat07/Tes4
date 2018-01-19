package com.pages.commonFunctionality;

import java.util.List;
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


public class CaseContents extends Initialize_Browser{
	
BaseUtils utility = new BaseUtils(driver);
public CaseContents(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(xpath = "//table[@pl_prop='CaseContentsPage.pxResults']")
	public WebElement assignedTo_Table;
	
	@FindBy(id = "FindingApproveCheckList")
	public WebElement Finding_drpDwn;
	
	@FindBy(xpath = "//a[@class='Header_nav'][contains(.,'Create')]")
	WebElement create;

	@FindBy(xpath = "//td[text()='BckOff']")
	WebElement backOffice;

	
	public void assignedToCheck(String expectedAssignedTo) throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,150)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			List<WebElement> taskToPerf_TableRows=assignedTo_Table.findElements(By.tagName("tr"));
			System.out.println("table size: "+taskToPerf_TableRows.size());
			WebElement wb=driver.findElement(By.xpath("//table[@pl_prop='CaseContentsPage.pxResults'][contains(.,'"+expectedAssignedTo+"')]"));
			if(wb.isDisplayed()){
				extent_Reportlogger("Test Step Execution successfull","assignedToCheck_"+expectedAssignedTo, "PASS");
				excelWrite.writeInCell("assignedToCheck_"+expectedAssignedTo+" Test Step Execution successfull", "PASS");
			
			}
			else{
				extent_Reportlogger("Test Step Execution failed", "assignedToCheck_"+expectedAssignedTo, "FAIL");
			excelWrite.writeInCell("assignedToCheck_"+expectedAssignedTo+" Test Step Execution Failed", "FAIL");
		}
			//String actualAssignedToLastItem=driver.findElement(By.xpath("//table[@pl_prop='CaseContentsPage.pxResults']//tr["+taskToPerf_TableRows.size()+"]//td[3]//div//div")).getText().trim();
			//System.out.println("table size: "+taskToPerf_TableRows.size()+", Assigned to: "+actualAssignedToLastItem);
			/*if(actualAssignedToLastItem.equals(expectedAssignedTo)){
				extent_Reportlogger("Test Step Execution successfull","assignedToCheck_"+expectedAssignedTo, "PASS");
				excelWrite.writeInCell("assignedToCheck_"+expectedAssignedTo+" Test Step Execution successfull", "PASS");
			}
			else{
				extent_Reportlogger("Test Step Execution failed", "assignedToCheck_"+expectedAssignedTo, "FAIL");
			excelWrite.writeInCell("assignedToCheck_"+expectedAssignedTo+" Test Step Execution Failed", "FAIL");
		}*/
			
			
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "assignedToCheck_"+expectedAssignedTo, "FAIL");
		excelWrite.writeInCell("assignedToCheck_"+expectedAssignedTo+" Test Step Execution Failed", "FAIL");
		ErrorLogger.logError(e.getClass().getName(),"assignedToCheck_"+expectedAssignedTo, e.getMessage());
		throw e;
		}
}
}
