package com.pages.CP_BO_Intent_Mapping;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class CP_OtherActions extends Initialize_Browser {

	public CP_OtherActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	BaseUtils utility = new BaseUtils(driver);
	 static String inv_ID=null;
	
	
	@FindBy(xpath = "//a[text()='Other Actions ']")
	public WebElement otherActions_Menu;
	
	@FindBy(xpath = "//td[@title='Initiate Back Office Workflow']")
	public WebElement initiate_BO_WorkFlow;
	
	@FindBy(xpath = "//td[@title='Refresh']")
	public WebElement refresh;
	
	@FindBy(xpath = "//textarea[@id='MCIntentAddlComments']")
	public WebElement comments_TxtBox;
	
	@FindBy(id = "submitButton")
	public WebElement submit_Btn;
	
	@FindBy(xpath = "//label[text()='A work flow has been created in Back Office with the ID :']/ancestor::td[1]/following-sibling::td//span")
	public WebElement bo_ID;
	
	@FindBy(id = "pyDescription")
	public WebElement currentCarrier_DrpDwn;
	
	@FindBy(xpath = "//div[@class='search-area']//input[@class='SearchResultsPromptText']")
	public WebElement search_CaseID;
	
	@FindBy(id = "searchMenuButton")
	public WebElement searchMenu_Btn;

	@FindBy(id = "pzWorkLastUpdated")
	public WebElement latsUpdated_drpDown;
	
	@FindBy(xpath = "//a[text()='        Inv Perform Trans   ']")
	public WebElement inv_PerformTrans;
	
	@FindBy(xpath = "//a[text()='        Execute CheckList   ']")
	public WebElement execute_CheckList;
	
	@FindBy(id = "searchMenuButton")
	public WebElement searhMenu_Btn;
	
	
	public void selectOtherActions(String actionToBeSelected) throws Exception {
		try {
			otherActions_Menu.click();
			driver.findElement(By.xpath("//td[@title='"+actionToBeSelected+"']")).click();
			
			extent_Reportlogger("Test Step Execution successfull","selectOtherOptions_"+actionToBeSelected, "PASS");
			excelWrite.writeInCell("selectOtherOptions Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectOtherOptions_"+actionToBeSelected, "FAIL");
			excelWrite.writeInCell("selectOtherOptions_"+actionToBeSelected+" Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"selectOtherOptions_"+actionToBeSelected, e.getMessage());
			throw e;
	}
}
	public void enterCommentsAndSubmit() throws Exception {
		try {
			comments_TxtBox.sendKeys(reader.getMapData(CommonVariable.comments, map),Keys.TAB);
			submit_Btn.click();

			extent_Reportlogger("Test Step Execution successfull","enterCommentsAndSubmit", "PASS");
			excelWrite.writeInCell("selectOtherOptions Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed","enterCommentsAndSubmit", "FAIL");
			excelWrite.writeInCell("enterCommentsAndSubmit Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"enterCommentsAndSubmit", e.getMessage());
			throw e;
	}
}
	
	public void saveID_ClickOnDone() throws Exception {
		try {
			inv_ID= bo_ID.getText().trim();
			submit_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "saveID_ClickOnDone", "PASS");
			excelWrite.writeInCell("saveID_ClickOnDone Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "saveID_ClickOnDone", "FAIL");
			excelWrite.writeInCell("saveID_ClickOnDone Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"saveID_ClickOnDone", e.getMessage());
			throw e;
		}
}

	public void moveToBO() throws Exception {
		try {
			driver.switchTo().defaultContent();
			utility.selectvalueByText_DropdownList(currentCarrier_DrpDwn,"Back Office FW Sliver 6");
			
			Thread.sleep(1000);
			extent_Reportlogger("Test Step Execution Successfull", "moveToBO", "PASS");
			excelWrite.writeInCell("moveToBO Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "moveToBO", "FAIL");
			excelWrite.writeInCell("moveToBO Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"moveToBO", e.getMessage());
			throw e;
		}
}

	public void searchCaseAndOpenInv() throws Exception {
		try {
			Thread.sleep(1000);
			search_CaseID.sendKeys(inv_ID);
			Thread.sleep(1000);
			searchMenu_Btn.click();
			//driver.switchTo().frame(driver.findElement(By.id("PegaGadget0Ifr")));
			//driver.switchTo().defaultContent();
			//driver.switchTo().frame(driver.findElement(By.id("_searchPanel_iframe")));
			//utility.selectvalueByText_DropdownList(latsUpdated_drpDown, "Today");
			Thread.sleep(1000);
			System.out.println("ID: "+inv_ID);
			//driver.findElement(By.xpath("//a[@title='"+inv_ID+"']")).click();
			
			extent_Reportlogger("Test Step Execution Successfull", "searchCaseAndOpenInv", "PASS");
			excelWrite.writeInCell("searchCaseAndOpenInv Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "searchCaseAndOpenInv", "FAIL");
			excelWrite.writeInCell("searchCaseAndOpenInv Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"searchCaseAndOpenInv", e.getMessage());
			throw e;
		}
}
	
	public void click_INV_PerformTrans() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			inv_PerformTrans.click();
			extent_Reportlogger("Test Step Execution Successfull", "click_INV_PerformTrans", "PASS");
			excelWrite.writeInCell("click_INV_PerformTrans Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "click_INV_PerformTrans", "FAIL");
			excelWrite.writeInCell("click_INV_PerformTrans Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"click_INV_PerformTrans", e.getMessage());
			throw e;
		}
}
	
	public void click_Execute_CheckList() throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			execute_CheckList.click();
			extent_Reportlogger("Test Step Execution Successfull", "click_Execute_CheckList", "PASS");
			excelWrite.writeInCell("click_Execute_CheckList Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "click_Execute_CheckList", "FAIL");
			excelWrite.writeInCell("click_Execute_CheckList Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"click_Execute_CheckList", e.getMessage());
			throw e;
		}
}
	
	public void openLinkFrom_CaseContents(String linkName) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			driver.findElement(By.xpath("//a[contains(.,'"+linkName+"')]")).click();
			Thread.sleep(1000);
			extent_Reportlogger("Test Step Execution Successfull", "openLinkFrom_CaseContents_"+linkName, "PASS");
			excelWrite.writeInCell("openLinkFrom_CaseContents: "+linkName+" Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "openLinkFrom_CaseContents_"+linkName, "FAIL");
			excelWrite.writeInCell("openLinkFrom_CaseContents: "+linkName+" Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"openLinkFrom_CaseContents: "+linkName, e.getMessage());
			throw e;
		}
}

	

}
