package com.pages.commonScreens_CP;

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
import com.utility.Test_BaseClass;


public class Action_Summary extends Initialize_Browser{
	public Action_Summary(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//div[text()='+ Action']")
	public WebElement action_Link;
	
	@FindBy(xpath = "//div[text()='Launch']")
	public WebElement launch_Btn;
	
	@FindBy(xpath = "//div[text()='To Do']")
	public WebElement toDo_Btn;

	@FindBy(xpath = "//div[text()='Wrap Up']")
	public WebElement wrapUp_Link;
	
	@FindBy(id = "MCWrapUpComments")
	public WebElement wrapUpDetails_TxtBox;
	
	@FindBy(xpath = "//div[text()='End Interaction']")
	public WebElement endInteraction_Btn;
	
	public void action_LinkClick() throws Exception {
		try {
			action_Link.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "action_LinkClick", "PASS");
			excelWrite.writeInCell("action_LinkClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "action_LinkClick", "FAIL");
			excelWrite.writeInCell("action_LinkClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"action_LinkClick", e.getMessage());
			throw e;
		}
}

	public void expandAction_SelectCategory() throws Exception {
		try {
			String action=reader.getMapData(CommonVariable.action, map);
			driver.findElement(By.xpath("//li//span[text()='"+action+"']/ancestor::li[1]/preceding-sibling::li//div[@id='iconExpandCollapse']")).click();
			
			String subAction=reader.getMapData(CommonVariable.subAction, map);
			driver.findElement(By.xpath("//div[@id[contains(.,'McCamish-FW-MCRMFW-Data-IDCategories-Financial')]]//span[text()='"+subAction+"']")).click();
			
			extent_Reportlogger("Test Step Execution Successfull", "expandAction_SelectCategory", "PASS");
			excelWrite.writeInCell("expandAction_SelectCategory Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "expandAction_SelectCategory", "FAIL");
			excelWrite.writeInCell("expandAction_SelectCategory Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"expandAction_SelectCategory", e.getMessage());
			throw e;
		}
}
	
	//AddreeChange Expand Action
	public void backTrackexpandAction_SelectCategory() throws Exception {
	try {
		/*String action=reader.getMapData(CommonVariable.action, map);
		driver.findElement(By.xpath("//li//span[text()='"+action+"']/ancestor::li[1]/preceding-sibling::li//div[@id='iconExpandCollapse']")).click();*/
		
		String subAction=reader.getMapData(CommonVariable.subAction, map);
		driver.findElement(By.xpath("//div[@id[contains(.,'McCamish-FW-MCRMFW-Data-IDCategories-Financial')]]//span[text()='"+subAction+"']")).click();
		
		extent_Reportlogger("Test Step Execution Successfull", "expandAction_SelectCategory", "PASS");
		excelWrite.writeInCell("expandAction_SelectCategory Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "expandAction_SelectCategory", "FAIL");
		excelWrite.writeInCell("expandAction_SelectCategory Test Step Execution Unsuccessfull", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"expandAction_SelectCategory", e.getMessage());
		throw e;
	}
}
	
	
	public void launch_ButtonClick() throws Exception {
		try {
			launch_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "launch_ButtonClick", "PASS");
			excelWrite.writeInCell("launch_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "launch_ButtonClick", "FAIL");
			excelWrite.writeInCell("launch_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"launch_ButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void wrapUp_LinkClick() throws Exception {
		try {
			wrapUp_Link.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "wrapUp_LinkClick", "PASS");
			excelWrite.writeInCell("wrapUp_LinkClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "wrapUp_LinkClick", "FAIL");
			excelWrite.writeInCell("wrapUp_LinkClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"wrapUp_LinkClick", e.getMessage());
			throw e;
		}
}
	
	public void enterWrapUpDetails_EndInteraction() throws Exception {
		try {
			String details=reader.getMapData(CommonVariable.wrapUp_Details, map);
			wrapUpDetails_TxtBox.sendKeys(details);
			
			endInteraction_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "enterWrapUpDetails_EndInteraction", "PASS");
			excelWrite.writeInCell("enterWrapUpDetails_EndInteraction Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterWrapUpDetails_EndInteraction", "FAIL");
			excelWrite.writeInCell("enterWrapUpDetails_EndInteraction Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterWrapUpDetails_EndInteraction", e.getMessage());
			throw e;
		}
}
}