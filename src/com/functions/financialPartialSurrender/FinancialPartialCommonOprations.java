package com.functions.financialPartialSurrender;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.FinancialPartialSurrender.Financial_Partial_SurrenderPage;
import com.pages.FinancialPartialSurrender.Financial_SystematicRMD;
import com.pages.RelationshipSummary.RelationshipSummary_Owner_Change;
import com.pages.RelationshipSummary.callPortal.CP_ReltnSummaryAssigneemaintenance;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;
//import com.utility.excelWrite;
import com.utility.WriteExcelFile;

public class FinancialPartialCommonOprations extends Test_BaseClass {

	
	public FinancialPartialCommonOprations(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	Financial_SystematicRMD finSystematicRMD;
	
	//Method for Enter enterEventTypeAndSelection
	
			public void enterEventTypeAndSelection() throws Exception{
				
				try{
					
					
					Financial_Partial_SurrenderPage financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);

				
					Financial_SystematicRMD finSystematicRMD = new Financial_SystematicRMD(driver);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					
					utility.selectvalueByText_DropdownList(financialPartialSurrenderPage.slect_EventType, reader.getMapData(CommonVariable.event_Type, map));
					String eventtype = reader.getMapData(CommonVariable.event_Type, map);
					excelWrite.writeInCell(
							"Selected Event type is " +eventtype, "Pass");
					extent_Reportlogger(":Selected Value is :" +eventtype, "Select Event Type is done and ", "Pass");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					financialPartialSurrenderPage.click_ValidateSelection.click();
					
					
					excelWrite.writeInCell(
							"click on ValidateSelection is done", "Pass");
					extent_Reportlogger(":Executed Successfully", "ValidateSelectionCheck", "Pass");
				
					String enterAmountTC1 = reader.getMapData(CommonVariable.enter_FlatAmount, map);
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
					financialPartialSurrenderPage.select_FlatAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmountTC1);
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
					//utility.click_On_Button(financialPartialSurrenderPage.click_OnTax);
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
				
				
				
				
				
				} catch (Exception e) {
							extent_Reportlogger("Test Step Execution failed", "enterEventTypeAndSelection", "FAIL");
							excelWrite.writeInCell("enterEventTypeAndSelection Test Step Execution Unsuccessfull", "Fail");
							ErrorLogger.logError(e.getClass().getName(),"enterEventTypeAndSelection", e.getMessage());
							throw e;
						}
				}
			
			public void enterEventTypeAndSelectionforHardship() throws Exception{
				
				try{
					
					
					Financial_Partial_SurrenderPage financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);

				
					Financial_SystematicRMD finSystematicRMD = new Financial_SystematicRMD(driver);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					
					utility.selectvalueByText_DropdownList(financialPartialSurrenderPage.slect_EventType, reader.getMapData(CommonVariable.event_Type, map));
					String eventtype = reader.getMapData(CommonVariable.event_Type, map);
					excelWrite.writeInCell(
							"Selected Event type is " +eventtype, "Pass");
					extent_Reportlogger(":Selected Value is :" +eventtype, "Select Event Type is done and ", "Pass");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					financialPartialSurrenderPage.click_ValidateSelection.click();
					
					
					excelWrite.writeInCell(
							"click on ValidateSelection is done", "Pass");
					extent_Reportlogger(":Executed Successfully", "ValidateSelectionCheck", "Pass");
				
//					String enterAmountTC1 = reader.getMapData(CommonVariable.enter_FlatAmount, map);
//					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
//					financialPartialSurrenderPage.FlatAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmountTC1);
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
					//utility.click_On_Button(financialPartialSurrenderPage.click_OnTax);
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
				
				
				
				
				
				} catch (Exception e) {
							extent_Reportlogger("Test Step Execution failed", "enterEventTypeAndSelection", "FAIL");
							excelWrite.writeInCell("enterEventTypeAndSelection Test Step Execution Unsuccessfull", "Fail");
							ErrorLogger.logError(e.getClass().getName(),"enterEventTypeAndSelection", e.getMessage());
							throw e;
						}
				}
			
			
			
					
}
