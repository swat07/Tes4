package com.testScript;


	import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.functions.financialPartialSurrender.FinancialPartialCommonOprations;
import com.pages.AddressChangeScreens.CSWD_GoodOrderCheckPage;
import com.pages.AddressChangeScreens.CSWD_LandingPage;
import com.pages.FinancialPartialSurrender.Fin_PartialSurrenderLoan_S520Page;
import com.pages.FinancialPartialSurrender.FinancialForfeitureNonVest;
import com.pages.FinancialPartialSurrender.Financial_Depo_AccntSurrender;
import com.pages.FinancialPartialSurrender.Financial_PartialSurrenderFin_Valueupdate;
import com.pages.FinancialPartialSurrender.Financial_Partial_SurrenderPage;
import com.pages.FinancialPartialSurrender.Financial_SystematicRMD;
import com.pages.Login.CSWD_LoginPage;
import com.pages.PolicyTermination.PolicyTerminationFreeLookRefund;


import com.utility.BaseUtils;
import com.utility.Test_BaseClass;


	public class Test_Financial_PartialSurrender extends Test_BaseClass {
		
		
		CSWD_LoginPage objLogin;
		CSWD_LandingPage objLandingPage;
		CSWD_GoodOrderCheckPage objGoodOrdChkPage;
		
		
		Financial_Partial_SurrenderPage financialPartialSurrenderPage;
		
		Financial_SystematicRMD finSystematicRMD;
		FinancialPartialCommonOprations FinancialPartialCommonOprations;
		Financial_PartialSurrenderFin_Valueupdate financial_PartialSurrenderFin_Valueupdate;
		Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page;
		
		Financial_Depo_AccntSurrender fin_Deposit_AccountSurrender;
	
		PolicyTerminationFreeLookRefund PolicyTermination_FreeLookRefund;
		
		BaseUtils utility = new BaseUtils(driver);
	
		
	String submitMsgTextExpected = "Confirmation : Event successfully submitted";
		
		
		
		 //Financial_Partial Surrender_S500_TC1 start here
		
		@Test(priority = 0)
		public void Financial_Partial_Surrender_S500() throws Exception {

			try {
			
				financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);
				finSystematicRMD = new Financial_SystematicRMD(driver);
				
				FinancialPartialCommonOprations	FinancialPartialCommonOprations = new FinancialPartialCommonOprations(driver);
				InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
				// Calling to common pages
				resuablefunction.landing_page();
				resuablefunction.selectCategoryAndTransaction();
				resuablefunction.executeChecklist();
				//Caling Common Function for Financial page
				
				FinancialPartialCommonOprations.enterEventTypeAndSelection();
				
				//Calling financialPartialSurrenderPage functions
				
				financialPartialSurrenderPage.select_Disbursement();
			
		
				
				} catch (Exception e) {
					extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
					excelWrite.writeInCell(
							"Test Case Failed", "Fail");
				
					
					throw e;
				}

			}

	

		
		//Financial_Partial_SurrenderForce_out TC2 start here
		
				@Test(priority = 1)
				public void Financial_Partial_SurrenderForce_out() throws Exception {

					try {
						
						finSystematicRMD = new Financial_SystematicRMD(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						Financial_Partial_SurrenderPage financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);
						FinancialPartialCommonOprations FinancialPartialCommonOprations = new FinancialPartialCommonOprations(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						// Calling to Financial_Partial_SurrenderForce_out functions
					
					
						FinancialPartialCommonOprations.enterEventTypeAndSelection();
						
						financialPartialSurrenderPage.select_Disbursement();
						excelWrite.writeInCell(
								"Partial Surrender is done", "Pass");
						extent_Reportlogger("Partial Surrender is done", "Validation Screen", "Pass");
				
						
						} catch (Exception e) {
							extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Failed", "Fail");
						
							
							throw e;
						}

					}
	
				//Financial_Partial Surrender_Loan-S520 TC3 start here
				
				@Test(priority = 2)
				public void Financial_PartialSurrenderLoan_S520() throws Exception {

					try {
						
						
						
						Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page = new Fin_PartialSurrenderLoan_S520Page(driver);
						financial_PartialSurrenderFin_Valueupdate = new Financial_PartialSurrenderFin_Valueupdate(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("window.scrollBy(0,250)", "");
						finPartialSurrenderLoan_S520Page.enter_LoanAmount();
					
						finPartialSurrenderLoan_S520Page.select_RepaymentAndPayment();
						finPartialSurrenderLoan_S520Page.selectFrequency();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						finPartialSurrenderLoan_S520Page.validatebtn.click();
					
						financial_PartialSurrenderFin_Valueupdate.verify_NOValidationMsg("FinancialPartialSurrenderLoanS520");
					
							
						} catch (Exception e) {
							extent_Reportlogger("Financial_PartialSurrenderLoan_S520 TestCase Run Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Financial_PartialSurrenderLoan_S520 TestCase Run Failed", "Fail");
							
							
							throw e;
						}

					}

				
				
				
				
				//Financial_PartialSurrenderFin_valueUpdate TC4 start here
				
				@Test(priority = 3)
				public void Financial_PartialSurrenderFin_valueUpdate() throws Exception {

					try {
				
						
						financial_PartialSurrenderFin_Valueupdate = new Financial_PartialSurrenderFin_Valueupdate(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
						//Calling Financial_PartialSurrenderFin_valueUpdate functions
						financial_PartialSurrenderFin_Valueupdate.clkOnValidationAndAddBtn();
						financial_PartialSurrenderFin_Valueupdate.select_fieldDropdownvalue();
						financial_PartialSurrenderFin_Valueupdate.enter_AmountValue();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						financial_PartialSurrenderFin_Valueupdate.validatebtn.click();
						financial_PartialSurrenderFin_Valueupdate.verify_NOValidationMsg("FinancialPartialSurrenderFinvalueUpdate");
						
					
				
						} catch (Exception e) {
							extent_Reportlogger("Financial_PartialSurrenderFin_valueUpdate Test Case RunFailed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Financial_PartialSurrenderFin_valueUpdate Test Case Run Failed", "Fail");
						
							
							throw e;
						}

					}

				
				//Financial_PartialSurrender_SystematicRMD TC5 start here
				
				@Test(priority = 4)
				public void Financial_PartialSurrender_SystematicRMD() throws Exception {

					try {
						
						
						finSystematicRMD = new Financial_SystematicRMD(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page = new Fin_PartialSurrenderLoan_S520Page(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
						//Calling Financial_PartialSurrender_SystematicRMD
						finSystematicRMD.click_CreateNew.click();
						finSystematicRMD.select_EventType();
						finSystematicRMD.selectBasisType();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						finSystematicRMD.select_withdraInfo.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						finSystematicRMD.click_Investmnbtn.click();
					
						
						//Enter Percent one by one 
						
						/*String enterAmount11 = reader.getMapData(CommonVariable.slectwtdrwaAmnt1, map);
						finSystematicRMD.enter_WithdrwAmnt1.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmount11 +Keys.TAB); 
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						
						String enterAmountt2 = reader.getMapData(CommonVariable.slectwtdrwaAmnt2, map);
						finSystematicRMD.enter_WithdrwAmnt2.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmountt2 +Keys.TAB); 
					
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						excelWrite.writeInCell(
								"slectwtdrwaAmnt1 ", "Pass");
						extent_Reportlogger("slectwtdrwaAmnt1 ", "slectwtdrwaAmnt1 ", "Pass");*/
						
						/*String enterAmountt3 = reader.getMapData(CommonVariable.slectwtdrwaAmnt3, map);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						finSystematicRMD.enter_WithdrwAmnt3.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmountt3); 
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
						*/
						
						//New Code for random Enter Percentage value
					
						finSystematicRMD.enterFund_PercentDetails();
						finSystematicRMD.ToValidateSumOfWithdrawAmntValue();	
						finSystematicRMD.click_EditTaxInfo.click();
						finSystematicRMD.SelectPayeeAndDisburse();
					
						finSystematicRMD.select_NoErrMsgValidation();
					
						} catch (Exception e) {
							extent_Reportlogger("Test Case Financial_PartialSurrender_SystematicRMD Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Financial_PartialSurrender_SystematicRMD Failed", "Fail");
							
							throw e;
						}

					}

			
		
				
				
				//Financial_PartialSurrenderFin_valueUpdate TC6 start here
				
				@Test(priority = 5)
				public void Financial_Deposit_AccountSurrender() throws Exception {

					try {
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						finSystematicRMD = new Financial_SystematicRMD(driver);
						fin_Deposit_AccountSurrender = new Financial_Depo_AccntSurrender(driver);
						financial_PartialSurrenderFin_Valueupdate = new Financial_PartialSurrenderFin_Valueupdate(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						//Calling Financial_Deposit_AccountSurrender functions
						fin_Deposit_AccountSurrender.selectDepositeAcntId();
						fin_Deposit_AccountSurrender.ToValidateSurrenderPerctng();
				
						fin_Deposit_AccountSurrender.select_NoErrMsgValidation();
					
						financial_PartialSurrenderFin_Valueupdate.verify_NOValidationMsg("FinancialDepositAccountSurrender");
					
						
						
						} catch (Exception e) {
							extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Failed", "Fail");
							
							throw e;
						}

					}

				
				
				
					//Financial_PartialSurrenderFin_valueUpdate TC7 start here
				
				@Test(priority = 6)
				public void Financial_IGP_Renewal() throws Exception {

					try {
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						fin_Deposit_AccountSurrender = new Financial_Depo_AccntSurrender(driver);
						PolicyTermination_FreeLookRefund = new PolicyTerminationFreeLookRefund(driver);
						financial_PartialSurrenderFin_Valueupdate = new Financial_PartialSurrenderFin_Valueupdate(driver);
						
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						
						//Calling Financial_IGP_Renewal functions
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						fin_Deposit_AccountSurrender.selectRenewalDate();

						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						fin_Deposit_AccountSurrender.CLick_renewaldate.click();
						fin_Deposit_AccountSurrender.SelectionOfFundIdAndOkModel();
						
						//Validation window handle code
						financial_PartialSurrenderFin_Valueupdate.verify_NOValidationMsg("FinancialIGPRenewal");
						
						
					} catch (Exception e) {
						extent_Reportlogger("Financial_IGP_Renewal TestCase Run Failed", "Failed Screen", "FAIL");
						excelWrite.writeInCell(
								"Financial_IGP_Renewal TestCase Run Failed", "Fail");
					
						
						throw e;
					}

				}
				// PHASE-2 Start Financial_Partial Surrender_S500_TC1 start here
				
				@Test(priority = 7)
				public void Financial_RMDWithdrawal() throws Exception {

					try {
					
						financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);
						finSystematicRMD = new Financial_SystematicRMD(driver);
						
						FinancialPartialCommonOprations	FinancialPartialCommonOprations = new FinancialPartialCommonOprations(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						//Caling Common Function for Financial page
						
						FinancialPartialCommonOprations.enterEventTypeAndSelection();
						
						//Calling financialPartialSurrenderPage functions
						
						financialPartialSurrenderPage.select_Disbursement();
						
						excelWrite.writeInCell(
								"Partial Surrender is done", "Pass");
						extent_Reportlogger(" : Test Step Executed Successfully", "Financial", "Pass");
				
						
						} catch (Exception e) {
							extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Failed", "Fail");
						
							
							throw e;
						}

					}
				// PHASE-2 TC2 Start Financial_Partial Financial_Hardship start here
				
				@Test(priority = 8)
				public void Financial_Hardship() throws Exception {

					try {
					
						financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);
						finSystematicRMD = new Financial_SystematicRMD(driver);
						
						FinancialPartialCommonOprations	FinancialPartialCommonOprations = new FinancialPartialCommonOprations(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						//Caling Common Function for Financial page
						
						FinancialPartialCommonOprations.enterEventTypeAndSelectionforHardship();
						
						//Calling financialPartialSurrenderPage functions
						
						financialPartialSurrenderPage.select_Disbursement();
						
						excelWrite.writeInCell(
								"Partial Surrender is done", "Pass");
						extent_Reportlogger(" : Test Step Executed Successfully", "Financial", "Pass");
				
						
						} catch (Exception e) {
							extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Failed", "Fail");
						
							
							throw e;
						}

					}
				// PHASE-2 TC3 Start Financial_Partial Financial_Hardship start here
				
				@Test(priority = 9)
				public void Financial_ForfeitureNonVest() throws Exception {

					try {
						
						FinancialForfeitureNonVest Financial_ForfeitureNonVest =new FinancialForfeitureNonVest(driver);
						financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);
						finSystematicRMD = new Financial_SystematicRMD(driver);
						
						FinancialPartialCommonOprations	FinancialPartialCommonOprations = new FinancialPartialCommonOprations(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						//Caling Common Function for Financial page
						
						Financial_ForfeitureNonVest.selectVestedTransferandPercentage();
						Financial_ForfeitureNonVest.selectTrxnMethodandAmount();
						
						//Calling financialPartialSurrenderPage functions
						
						financialPartialSurrenderPage.select_Disbursement();
						
						excelWrite.writeInCell(
								"Partial Surrender is done", "Pass");
						extent_Reportlogger(" : Test Step Executed Successfully", "Financial", "Pass");
				
						
						} catch (Exception e) {
							extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Failed", "Fail");
						
							
							throw e;
						}

					}
				// PHASE-2 TC4 Start Financial_SystematicRMD start here
				
				@Test(priority = 10)
				public void Financial_SystematicRMD() throws Exception {

					try {
						
						
						finSystematicRMD = new Financial_SystematicRMD(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page = new Fin_PartialSurrenderLoan_S520Page(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
						//Calling Financial_PartialSurrender_SystematicRMD
						finSystematicRMD.click_CreateNew.click();
						finSystematicRMD.select_EventType();
						finSystematicRMD.selectBasisType();
						finSystematicRMD.selectInvestment();
					
						//New Code for random Enter Percentage value
					
						finSystematicRMD.enterFund_PercentDetails();
						finSystematicRMD.ToValidateSumOfWithdrawAmntValue();	
						finSystematicRMD.click_EditTaxInfo.click();
						finSystematicRMD.SelectPayeeAndDisburse();
					
						finSystematicRMD.select_NoErrMsgValidation();
					
						
						extent_Reportlogger(":Executed successfully ", "Financial_PartialSurrender_SystematicRMD ", "Pass");
						
							excelWrite.writeInCell(
									"Financial_PartialSurrender_SystematicRMD Executed successfully", "Pass");
						} catch (Exception e) {
							extent_Reportlogger("Test Case Financial_PartialSurrender_SystematicRMD Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Financial_PartialSurrender_SystematicRMD Failed", "Fail");
							
							throw e;
						}

					}
				
				// PHASE-2 TC5 Start Financial_SEPP_S507 start here
				@Test(priority = 11)
				public void Financial_SEPP_S507() throws Exception {

					try {
						
						
						finSystematicRMD = new Financial_SystematicRMD(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page = new Fin_PartialSurrenderLoan_S520Page(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
						//Calling Financial_PartialSurrender_SystematicRMD
						finSystematicRMD.click_CreateNew.click();
						finSystematicRMD.select_EventType();
						finSystematicRMD.selectBasisType();
						finSystematicRMD.selectInvestment();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					/*	finSystematicRMD.select_withdraInfo.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						finSystematicRMD.click_Investmnbtn.click();*/
					
					
						//New Code for random Enter Percentage value
					
						finSystematicRMD.enterFund_PercentDetails();
						finSystematicRMD.ToValidateSumOfWithdrawAmntValue();	
						finSystematicRMD.click_EditTaxInfo.click();
						finSystematicRMD.SelectPayeeAndDisburse();
					
						finSystematicRMD.select_NoErrMsgValidation();
					
						
						extent_Reportlogger(":Executed successfully ", "Financial_PartialSurrender_SystematicRMD ", "Pass");
						
							excelWrite.writeInCell(
									"Financial_PartialSurrender_SystematicRMD Executed successfully", "Pass");
						} catch (Exception e) {
							extent_Reportlogger("Test Case Financial_PartialSurrender_SystematicRMD Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Financial_PartialSurrender_SystematicRMD Failed", "Fail");
							
							throw e;
						}

					}


				// PHASE-2 TC6 Start Financial_SystematicRMD_Canadian start here
				@Test(priority = 12)
				public void Financial_SystematicRMD_Canadian() throws Exception {

					try {
						
						
						finSystematicRMD = new Financial_SystematicRMD(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page = new Fin_PartialSurrenderLoan_S520Page(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
						//Calling Financial_PartialSurrender_SystematicRMD
						finSystematicRMD.click_CreateNew.click();
						finSystematicRMD.select_EventType();
						finSystematicRMD.selectBasisType();
						finSystematicRMD.selectInvestment();
						
					
					
						//New Code for random Enter Percentage value
					
						finSystematicRMD.enterFund_PercentDetails();
						finSystematicRMD.ToValidateSumOfWithdrawAmntValue();	
						finSystematicRMD.click_EditTaxInfo.click();
						finSystematicRMD.SelectPayeeAndDisburse();
					
						finSystematicRMD.select_NoErrMsgValidation();
					
						
						extent_Reportlogger(":Executed successfully ", "Financial_PartialSurrender_SystematicRMD ", "Pass");
						
							excelWrite.writeInCell(
									"Financial_PartialSurrender_SystematicRMD Executed successfully", "Pass");
						} catch (Exception e) {
							extent_Reportlogger("Test Case Financial_PartialSurrender_SystematicRMD Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Financial_PartialSurrender_SystematicRMD Failed", "Fail");
							
							throw e;
						}

					}
				// PHASE-2 TC7 Start Financial_AdvisoryFee  start here
				@Test(priority = 13)
				public void Financial_AdvisoryFee() throws Exception {

					try {
						
						
						finSystematicRMD = new Financial_SystematicRMD(driver);
						InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
						Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page = new Fin_PartialSurrenderLoan_S520Page(driver);
						// Calling to common pages
						resuablefunction.landing_page();
						resuablefunction.selectCategoryAndTransaction();
						resuablefunction.executeChecklist();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
						//Calling Financial_PartialSurrender_SystematicRMD
						finSystematicRMD.click_CreateNew.click();
						finSystematicRMD.select_EventType();
						finSystematicRMD.selectBasisType();
						finSystematicRMD.selectInvestment();
						
					
						//New Code for random Enter Percentage value
					
						finSystematicRMD.enterFund_PercentDetails();
						finSystematicRMD.ToValidateSumOfWithdrawAmntValue();	
						finSystematicRMD.click_EditTaxInfo.click();
						finSystematicRMD.SelectPayeeAndDisburse();
					
						finSystematicRMD.select_NoErrMsgValidation();
					
						
						extent_Reportlogger(":Executed successfully ", "Financial_PartialSurrender_SystematicRMD ", "Pass");
						
							excelWrite.writeInCell(
									"Financial_PartialSurrender_SystematicRMD Executed successfully", "Pass");
						} catch (Exception e) {
							extent_Reportlogger("Test Case Financial_PartialSurrender_SystematicRMD Failed", "Failed Screen", "FAIL");
							excelWrite.writeInCell(
									"Test Case Financial_PartialSurrender_SystematicRMD Failed", "Fail");
							
							throw e;
						}

					}






	}