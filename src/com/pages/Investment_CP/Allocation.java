package com.pages.Investment_CP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.commonScreens_CP.Owner_Verification;
import com.pages.commonScreens_CP.Policy_Search;
import com.pages.commonScreens_CP.Welcome_Page;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class Allocation extends Test_BaseClass{
	public Allocation(WebDriver driver) {
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
	
	public void callPortal_ActionLaunch() throws Exception {
		try {
			Welcome_Page welcome_Page = new Welcome_Page(driver);
			Policy_Search policy_Search=new Policy_Search(driver);
			Owner_Verification owner_Verification= new Owner_Verification(driver);
			
			welcome_Page.serviceACustomer_LinkClick();
			policy_Search.policySearch();
			driver.switchTo().frame(driver.switchTo().activeElement());
			owner_Verification.verifyAllQsnsAndSubmit();
			action_LinkClick();
			expandAction_SelectCategory();
			launch_ButtonClick();
			
			extent_Reportlogger("Test Step Execution Successfull", "callPortal_ActionLaunch", "PASS");
			excelWrite.writeInCell("callPortal_ActionLaunch Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "callPortal_ActionLaunch", "FAIL");
			excelWrite.writeInCell("callPortal_ActionLaunch Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"callPortal_ActionLaunch", e.getMessage());
			throw e;
		}
}
}
