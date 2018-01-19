package com.pages.Investment_BO;

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
import com.utility.Test_BaseClass;


public class Transfer_Allocation extends Test_BaseClass{
	public Transfer_Allocation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//div[text()='Validate & Calculate']")
	public WebElement validateAndCalculate_Btn;
	
	@FindBy(id = "TransferCriteria")
	public WebElement transferBy_drpDwn;
	
	@FindBy(id = "AmountTransferMode")
	public WebElement transferMode_drpDwn;
	
	@FindBy(xpath = "//div[text()='Continue']")
	public WebElement continue_Btn;
	
	@FindBy(xpath = "//button[text()='  Confirm ']")
	public WebElement confirm_Btn;
	
	
	public void selectTransferByAndMode() throws Exception {
		try {
			String transferBy=reader.getMapData(CommonVariable.transferTo_MethodOr_TransferBy, map);
			utility.selectvalueByText_DropdownList(transferBy_drpDwn,transferBy);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			if(transferBy.equals("Amount")){
				utility.selectvalueByText_DropdownList(transferMode_drpDwn,reader.getMapData(CommonVariable.transfer_Mode, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			}
			extent_Reportlogger("Test Step Execution Successfull", "selectTransferByAndMode", "PASS");
			excelWrite.writeInCell("selectTransferByAndMode Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectTransferByAndMode", "FAIL");
			excelWrite.writeInCell("selectTransferByAndMode Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectTransferByAndMode", e.getMessage());
			throw e;
		}
}

	public void enterTransferFromDetails_FundTransfer() throws Exception {
		try {
			ExistingDCASchedule existingDCASchedule=new ExistingDCASchedule(driver);
			String transferToMethod=reader.getMapData(CommonVariable.transferTo_MethodOr_TransferBy, map);
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			if(transferToMethod.equals("Amount")){
				existingDCASchedule.enterFund_AmountDetails("FundTransfer","MCFundTransferAmountFrom");
			}
			else if(transferToMethod.equals("Percentage"))
			{
				existingDCASchedule.enterFund_PercentDetails("FundTransfer","MCFundTransferPercentageFrom");
			}
			else if(transferToMethod.equals("Units"))
			{
				existingDCASchedule.enterFund_UnitsDetails("FundTransfer","MCFundTransferUnitsFrom");
			}
			extent_Reportlogger("Test Step Execution Successfull", "enterTransferFromDetails_FundTransfer", "PASS");
			excelWrite.writeInCell("enterTransferFromDetails_FundTransfer Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterTransferFromDetails_FundTransfer", "FAIL");
			excelWrite.writeInCell("enterTransferFromDetails_FundTransfer Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterTransferFromDetails_FundTransfer", e.getMessage());
			throw e;
		}
	}
		
	public void enterTransferToDetails_FundTransfer() throws Exception {
		try {
			ExistingDCASchedule existingDCASchedule=new ExistingDCASchedule(driver);
			String transferBy=reader.getMapData(CommonVariable.transferTo_MethodOr_TransferBy, map);
			String transferMode=reader.getMapData(CommonVariable.transfer_Mode, map);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			if(transferBy.equals("Amount") && transferMode.equals("Amount")){
				existingDCASchedule.enterFund_AmountDetails("FundTransfer","MCFundTransferAmountTo");
			}
			else if(transferBy.equals("Amount") && transferMode.equals("Percentage")){
				existingDCASchedule.enterFund_PercentDetails("FundTransfer","MCFundTransferAmountTobyPCT");
			}
			else if(transferBy.equals("Percentage"))
			{
				existingDCASchedule.enterFund_PercentDetails("FundTransfer","MCFundTransferPctTo");
			}
			else if(transferBy.equals("Units"))
			{
				existingDCASchedule.enterFund_PercentDetails("FundTransfer","MCFundTransferUnitsTo");
			}
			
			extent_Reportlogger("Test Step Execution Successfull", "enterTransferToDetails_FundTransfer", "PASS");
			excelWrite.writeInCell("enterTransferToDetails_FundTransfer Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterTransferToDetails_FundTransfer", "FAIL");
			excelWrite.writeInCell("enterTransferToDetails_FundTransfer Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterTransferToDetails_FundTransfer", e.getMessage());
			throw e;
		}
}
	
	public void validateAndCalculate_ButtonClick() throws Exception {
		try {
			validateAndCalculate_Btn.click();
			Thread.sleep(1000);
			
			extent_Reportlogger("Test Step Execution Successfull", "validateAndCalculate_ButtonClick", "PASS");
			excelWrite.writeInCell("validateAndCalculate_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "validateAndCalculate_ButtonClick", "FAIL");
			excelWrite.writeInCell("validateAndCalculate_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"validateAndCalculate_ButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void continue_ButtonClick() throws Exception {
		try {
			
			String tagName=continue_Btn.getTagName();
			System.out.println("tagName1: "+tagName);
			continue_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "continue_ButtonClick", "PASS");
			excelWrite.writeInCell("continue_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "continue_ButtonClick", "FAIL");
			excelWrite.writeInCell("continue_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"continue_ButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void confirm_ButtonClick() throws Exception {
		try {
			confirm_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "confirm_ButtonClick", "PASS");
			excelWrite.writeInCell("confirm_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "confirm_ButtonClick", "FAIL");
			excelWrite.writeInCell("confirm_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"confirm_ButtonClick", e.getMessage());
			throw e;
		}
}
}
