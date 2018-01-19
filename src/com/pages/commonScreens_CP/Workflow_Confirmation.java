package com.pages.commonScreens_CP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class Workflow_Confirmation extends Test_BaseClass{
	public Workflow_Confirmation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	//VPAS Confirmation
	@FindBy(xpath = "//div[text()='Event Code']/ancestor::tr[1]/following-sibling::tr[1]//span")
	public WebElement event_Code;
	
	@FindBy(xpath = "//div[text()='I am done']")
	public WebElement iAmDone_Btn;
	
	@FindBy(xpath = "//div[text()='Done']")
	public WebElement done_Btn;
	
	//Workflow Confirmation
	@FindBy(id = "MCIntentAddlComments")
	public WebElement comment_TxtBox;
	
	@FindBy(id = "submitButton")
	public WebElement submit_Btn;
	
	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement validate_Btn;
	
	@FindBy(xpath = "//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']")
	public WebElement investmentFunds_Table;
	
	@FindBy(xpath = "//div[@id='cpmNavigationTabs-DIV']//li[2]//div[@node_name='CPMNavigationTabData']//label")
	public WebElement tab_Name;
	
	public void vpas_confirmation() throws Exception {
		try {
			String tab=reader.getMapData(CommonVariable.subAction, map);
			
			/*driver.switchTo().defaultContent();
			driver.switchTo().frame("cpmInteractionDivFrame");
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			
			String tab=tab_Name.getText().trim();*/
			
			
			String eventCode="";
			
			if(tab.equalsIgnoreCase("Allocation")){
				eventCode=event_Code.getText();
				iAmDone_Btn.click();
				}
			else if(tab.equalsIgnoreCase("Allocation")){
				eventCode=event_Code.getText();
				iAmDone_Btn.click();
			}
			else if(tab.equalsIgnoreCase("DCAEvent")){
				eventCode=driver.findElement(By.xpath("//div[@param_name[contains(.,'VPASConfirmation')]]//div[2]//tr[2]//td[1]//span")).getText();
				done_Btn.click();
			}
			else if(tab.equalsIgnoreCase("Fund Transfer")){
				eventCode=driver.findElement(By.xpath("//div[@node_name='WorkflowConfirmation']//tr[contains(.,//label[text()='Event Code :'])]//td[2]//span")).getText();
				submit_Btn.click();
			}
			System.out.println("Event Code:"+eventCode );
			
			if(eventCode.equals("")){
				extent_Reportlogger(" :Execution unsuccessfull(Event code is null)", "vpas_confirmation", "FAIL");
				excelWrite.writeInCell("vpas_confirmation Test Step Execution unsuccessfull(No event code is null)", "FAIL");
			}
			else
			{
				extent_Reportlogger(" :Execution Successfull(Event code is: "+eventCode+")", "vpas_confirmation", "PASS");
				excelWrite.writeInCell("vpas_confirmation Test Step Execution Successfull(Event code is: "+eventCode+")", "PASS");
			}
			
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "vpas_confirmation", "FAIL");
			excelWrite.writeInCell("vpas_confirmation Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"vpas_confirmation", e.getMessage());
			throw e;
		}
}
	
	public void enterComments() throws Exception {
		try {
			String comments=reader.getMapData(CommonVariable.comments, map);
			comment_TxtBox.sendKeys(comments);
			
			extent_Reportlogger(":Execution Successfull", "enterComments", "PASS");
			excelWrite.writeInCell("enterComments Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger(":Execution failed", "enterComments", "FAIL");
			excelWrite.writeInCell("enterComments Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterComments", e.getMessage());
			throw e;
		}
}
	
	public void done_ButtonClick() throws Exception {
		try {
			submit_Btn.click();
			
			extent_Reportlogger(" :Execution Successfull", "done_ButtonClick", "PASS");
			excelWrite.writeInCell("done_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger(" :Execution failed", "done_ButtonClick", "FAIL");
			excelWrite.writeInCell("done_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"done_ButtonClick", e.getMessage());
			throw e;
		}
}
}

