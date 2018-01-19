package com.pages.FinancialPartialSurrender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
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

public class FinancialForfeitureNonVest extends Initialize_Browser {
	
	
	public FinancialForfeitureNonVest(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//select[@id='XferCashDivSel']")
	public WebElement selctVestedtransfer ;
	
	@FindBy(xpath = "//select[@id='VestOpt']")
	public WebElement SelectVestOpt ;
	
	@FindBy(xpath = "//select[@id='EvntType']")
	public WebElement slect_EventType;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Calculate')]")
	public WebElement Calculate_Btn;
	
	//Method for Enter enterEventTypeAndSelection
	
	public void selectVestedTransferandPercentage () throws Exception{
		
		try{
			
			Financial_Partial_SurrenderPage financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);
			System.out.println("inside page");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(slect_EventType, reader.getMapData(CommonVariable.event_Type, map));
			String eventtype = reader.getMapData(CommonVariable.event_Type, map);
			excelWrite.writeInCell(
					"Selected Event type is " +eventtype, "Pass");
			extent_Reportlogger(":Selected Value is :" +eventtype, "Select Event Type is done and ", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			financialPartialSurrenderPage.click_ValidateSelection.click();
			
			
			excelWrite.writeInCell(
					"click on ValidateSelection is done", "Pass");
			extent_Reportlogger(":Executed Successfully", "ValidateSelectionCheck", "Pass");
		
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			
			utility.selectvalueByText_DropdownList(selctVestedtransfer, reader.getMapData(CommonVariable.Vestedtransfer, map));
			String eventtype2 = reader.getMapData(CommonVariable.Vestedtransfer, map);
			excelWrite.writeInCell(
					"Selected Vestedtransfer is " +eventtype2, "Pass");
			extent_Reportlogger(":Selected Value is :" +eventtype2, "Select Vestedtransfer is done and ", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
			
			utility.selectvalueByText_DropdownList(SelectVestOpt, reader.getMapData(CommonVariable.Vesting_Percent, map));
			System.out.println("Vlauuue"+reader.getMapData(CommonVariable.Vesting_Percent, map));
			String eventtype1 = reader.getMapData(CommonVariable.Vesting_Percent, map);
			excelWrite.writeInCell(
					"Selected VestingPercent is " +eventtype1, "Pass");
			extent_Reportlogger(":Selected Value is :" +eventtype1, "Select VestingPercent is done and ", "Pass");
			
	
		
		} catch (Exception e) {
					extent_Reportlogger("Test Step Execution failed", "enterEventTypeAndSelection", "FAIL");
					excelWrite.writeInCell("enterEventTypeAndSelection Test Step Execution Unsuccessfull", "Fail");
					ErrorLogger.logError(e.getClass().getName(),"enterEventTypeAndSelection", e.getMessage());
					throw e;
				}
		}
	public void selectTrxnMethodandAmount() throws Exception{
		
		try{
			
			
			Financial_Partial_SurrenderPage financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);

		
			Financial_SystematicRMD finSystematicRMD = new Financial_SystematicRMD(driver);
		
		/*
			String enterAmountTC1 = reader.getMapData(CommonVariable.enter_FlatAmount, map);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			financialPartialSurrenderPage.select_FlatAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmountTC1);*/
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			
			financialPartialSurrenderPage.click_OnTax.click();
			//financialPartialSurrenderPage.click_OnTax.click();
			
			excelWrite.writeInCell(
					"Click on Tax Option is Done", "Pass");
			extent_Reportlogger(":Executed Successfully", "click_OnTaxOption", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(finSystematicRMD.Select_IRSDistributionCode, reader.getMapData(CommonVariable.IRS_Distributioncode, map));
			
			String IRSDistributioncode=reader.getMapData(CommonVariable.IRS_Distributioncode, map);
			excelWrite.writeInCell(
					"Select_IRSDistributionCode id Done" +IRSDistributioncode, "Pass");
			extent_Reportlogger(":Executed Successfully and IRSDistributionCode is :" +IRSDistributioncode, "Select_IRSDistributionCode", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			Calculate_Btn.click();
		
		
		
		
		} catch (Exception e) {
					extent_Reportlogger("Test Step Execution failed", "enterEventTypeAndSelection", "FAIL");
					excelWrite.writeInCell("enterEventTypeAndSelection Test Step Execution Unsuccessfull", "Fail");
					ErrorLogger.logError(e.getClass().getName(),"enterEventTypeAndSelection", e.getMessage());
					throw e;
				}
		}
	
}
