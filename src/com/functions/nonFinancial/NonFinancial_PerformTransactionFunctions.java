package com.functions.nonFinancial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.NonFinancialScreens.NonFinancial_PerformTransaction;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;



public class NonFinancial_PerformTransactionFunctions extends Initialize_Browser {
	
	public NonFinancial_PerformTransactionFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	BaseUtils utility = new BaseUtils(driver);
	NonFinancial_PerformTransaction nonfinancial_PerformTransaction;
	NonFinancial_ValidationMsz reusablefunction;
	
	
	
	//Agent Change
	
	public void NonFinancial_performtxnAgentChange() throws Exception {

		try
		{
			nonfinancial_PerformTransaction = new NonFinancial_PerformTransaction(driver); 
			reusablefunction = new NonFinancial_ValidationMsz(driver);
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
						
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(nonfinancial_PerformTransaction.Select_AgentOption,reader.getMapData(CommonVariable.Select_AgentOption, map));
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
						
				
			nonfinancial_PerformTransaction.Add_NewAgentAff.click();
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			extent_Reportlogger(" Successfully Displayed "," Agent Change EditAffiliationDetailsScreen ", "Pass");
			excelWrite.writeInCell(" Agent Change EditAffiliationDetailsScreen Successfully Displayed ","pass");
			
			nonfinancial_PerformTransaction.Locate_Agent.click();
			nonfinancial_PerformTransaction.Locate_Agent.sendKeys("000001");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			nonfinancial_PerformTransaction.Locate_Agent.sendKeys(Keys.ARROW_DOWN);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			nonfinancial_PerformTransaction.Locate_Agent.sendKeys(Keys.ENTER);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					
			utility.enter_Text(nonfinancial_PerformTransaction.AgentChange_EffDate,reader.getMapData(CommonVariable.AgentChange_EffDate,map));
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			utility.enter_Text(nonfinancial_PerformTransaction.Agency_TermDate,reader.getMapData(CommonVariable.Agency_TermDate,map));
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			nonfinancial_PerformTransaction.AgentChange_EffCategory.click();
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			nonfinancial_PerformTransaction.AgentChange_EffCategory.sendKeys(Keys.ARROW_DOWN);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			nonfinancial_PerformTransaction.AgentChange_EffCategory.sendKeys(Keys.ENTER);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));// explicit wait
			
			extent_Reportlogger(" Data Entered Successfully "," Agent Change EditAffiliationDetailsScreen ", "Pass");
			excelWrite.writeInCell(" Agent Change EditAffiliationDetailsScreen Data Entered Successfully ","pass");
			
						
			nonfinancial_PerformTransaction.ValidateInput_AgentChange.click();
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS)); // explicit wait
			
			reusablefunction.validationMessagecheck("AgentChange","Y131");
			
	
			
						
			
				
			
	} catch (Exception e) {
		
		extent_Reportlogger("Event Confirmation execution Failed","Event Confirmation Screen", "Fail");
		excelWrite.writeInCell("Failed in Event Confirmation", "Fail");

		ErrorLogger.logError(e.getClass().getName(),
				"NonFinancial_performtxnAgentChange", e.getMessage());

		throw e;
		
	}
}
	
	
	//NFO
	public void NonFinancial_performtxnNFO() throws Exception {

		try
		{
			nonfinancial_PerformTransaction = new NonFinancial_PerformTransaction(driver); 
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			nonfinancial_PerformTransaction.AddNew_NFO.click();
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.enter_Text(nonfinancial_PerformTransaction.Eff_Date,reader.getMapData(CommonVariable.Eff_Date, map));
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(nonfinancial_PerformTransaction.Primary_NFO,reader.getMapData(CommonVariable.Primary_NFO, map));
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			//System.out.println(nonfinancial_PerformTransaction.Alt_NFO+">>boolean value");
			if (reader.getMapData(CommonVariable.Primary_NFO, map).equalsIgnoreCase("APL(Automatic Premium Loan)")) {
				utility.selectvalueByText_DropdownList(nonfinancial_PerformTransaction.Alt_NFO,reader.getMapData(CommonVariable.Alt_NFO, map));
			}else {
				System.out.println("no elemenet is present");
			}
				System.out.println("after if loop");	
				
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS)); //Explicit Wait
			nonfinancial_PerformTransaction.Save_Btn.click();
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS)); //Explicit Wait
			
			extent_Reportlogger(" data Sucessfully Selected and Saved  "," NFO EnterDetailsScreen ", "Pass");
			excelWrite.writeInCell(" NFO Data Successfully Selected and Saved ","pass");
			
			nonfinancial_PerformTransaction.NFO_Submit_Btn.click();
			
			//event Confirmation
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			System.out.println("Get Frame");
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			String eventCode = "Y185";
			
			String NFO_eventCode = nonfinancial_PerformTransaction.NFO_eventCode.getText();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			System.out.println("Got event Code");
			
			if (NFO_eventCode.equalsIgnoreCase(eventCode)) {				
				
				extent_Reportlogger(" Sucessfully updated in Vpas ","NFO EventConfirmationScreen", "Pass");
				excelWrite.writeInCell(" NFO successfully updated in Vpas ","pass");
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
				utility.click_On_Button(nonfinancial_PerformTransaction.NFO_DoneBtn);
				
					}
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			
			utility.dropdown_selectByValue(nonfinancial_PerformTransaction.NFGoodto_Proceed,reader.getMapData(CommonVariable.NFGoodto_Proceed,map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			utility.dropdown_selectByValue(nonfinancial_PerformTransaction.NFtrack_Corros,reader.getMapData(CommonVariable.NFtrack_Corros,map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger("Process Decesion respsonse sucessfully selected","NFO ProcessDecesionScreen", "Pass");
			excelWrite.writeInCell(" Process Decesion respsonse sucessfully selected","pass");
			
			nonfinancial_PerformTransaction.Submit_CommPage.click();
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			
	} catch (Exception e) {
		
	extent_Reportlogger("Event Confirmation execution Failed","Event Confirmation Screen", "Fail");
		excelWrite.writeInCell("Failed in Event Confirmation", "Fail");

		ErrorLogger.logError(e.getClass().getName(),
				"NonFinancial_performtxnNFO", e.getMessage());

		throw e;
		
	}
}
	
	//Dividend Option Change
	
	public void NonFinancial_performtxnDOC() throws Exception {

		try
		{
			nonfinancial_PerformTransaction = new NonFinancial_PerformTransaction(driver); 
			reusablefunction = new NonFinancial_ValidationMsz(driver);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			nonfinancial_PerformTransaction.AddNew_DividendOption.click();
			
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(nonfinancial_PerformTransaction.Fixed_PremiumStatus,reader.getMapData(CommonVariable.Fixed_PremiumStatus, map));
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(nonfinancial_PerformTransaction.Dividend_Option,reader.getMapData(CommonVariable.Dividend_Option, map));
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			nonfinancial_PerformTransaction.EffDate_DOC.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			nonfinancial_PerformTransaction.EffDate_DOC.clear();
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(nonfinancial_PerformTransaction.EffDate_DOC,reader.getMapData(CommonVariable.EffDate_DOC, map));
						
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(nonfinancial_PerformTransaction.Excess_DivOption,reader.getMapData(CommonVariable.Excess_DivOption, map));
			
						
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));			
							
			nonfinancial_PerformTransaction.Optional_PayInd.click();
			
			extent_Reportlogger(" data Sucessfully Selected and Saved  ","Add Dividend Option Screen ", "Pass");
			excelWrite.writeInCell(" Dividend Option Data Successfully Selected and Saved ","pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			nonfinancial_PerformTransaction.ValidateInput_DOC.click();
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			//Message Screen Validation 
						
			reusablefunction.validationMessagecheck("DividendOptionChange","Y184");
			
		
			
					
			
			
	} catch (Exception e) {
		extent_Reportlogger("Event Confirmation execution Failed","Event Confirmation Screen", "Fail");
		excelWrite.writeInCell("Failed in Event Confirmation", "Fail");

		ErrorLogger.logError(e.getClass().getName(),
				"NonFinancial_performtxnDOC", e.getMessage());

		throw e;
		
		
	}
}
	
	
	
}

		
	
		
		
	
	
	

