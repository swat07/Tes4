package com.testScript;

import org.testng.annotations.Test;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.functions.billingChanges.BillingChangesFixedProd;
import com.utility.BaseUtils;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;

public class Test_BillingChangesFixedProduct extends Test_BaseClass {

	
	InitialCommonScreens_ReusableFunction resuablefunction;
	BaseUtils utility = new BaseUtils(driver);
	BillingChangesFixedProd billingChangesFixedProd;
	
	
	@Test(priority = 0)
	public void billingChangesFixedProduct_BillingtoCancel() throws Exception {

		try {
			
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Get data from excel for Address change test case
	
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for fixed product
			
			billingChangesFixedProd.modify_billing_statusChanges("BillingtoCancel");
			
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFixedProduct_BillingtoCancel", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
		
			extent_Reportlogger("Test Case BillingtoCancel Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFixedProduct_BillingtoCancel", e.getMessage());
			
			throw e;
		}

	}
	
	@Test(priority = 1)
	public void billingChangesFixedProduct_CanceltoResume() throws Exception {

		try {
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for fixed product
			billingChangesFixedProd.modify_billing_statusChanges("CanceltoResume");
			
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFixedProduct_CanceltoResume", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case CanceltoResume Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFixedProduct_CanceltoResume", e.getMessage());
			
			
			throw e;
		}

	}
	
	
	@Test(priority = 2)
	public void billingChangesFixedProduct_CancelPolicyLapse() throws Exception {

		try {
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			//calling common function for fixed product
			billingChangesFixedProd.modify_billing_statusChanges("Cancel Policy Lapse");
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFixedProduct_CancelPolicyLapse", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case CancelPolicyLapse Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case CancelPolicyLapse Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFixedProduct_CancelPolicyLapse", e.getMessage());
			
			
			throw e;
		}

	}
	
	@Test(priority = 3)
	public void billingChangesFixedProduct_BillAhead() throws Exception {

		try {
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			//calling common function for fixed product
			billingChangesFixedProd.modify_billingAhead();
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFixedProduct_BillAhead", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case Bill Ahead Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFixedProduct_BillAhead", e.getMessage());
			
			
			throw e;
		}

	}
	
	@Test(priority = 4)
	public void billingChangesFixedProduct_ReBill() throws Exception {

		try {
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			//calling common function for fixed product
			billingChangesFixedProd.modify_billingRebill();
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFixedProduct_ReBill", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case ReBill Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFixedProduct_ReBill", e.getMessage());
			
			
			throw e;
		}

	}
	
	@Test(priority = 5)
	public void billingChangesFixedProduct_MailToEFT() throws Exception {

		try {
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			//calling common function for fixed product
			billingChangesFixedProd.modify_billingMailToEft();
			//Logging the logs in extent and excel			
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFixedProduct_MailToEFT", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case MailToEFT Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFixedProduct_MailToEFT", e.getMessage());
			
			
			throw e;
		}

	}
	
	
	@Test(priority = 5)
	public void billingChangesFixedProduct_EFTToMail() throws Exception {

		try {
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			//calling common function for fixed product
			billingChangesFixedProd.modify_billingEftToMail();
			//Logging the logs in extent and excel					
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFixedProduct_EFTToMail", "PASS");
			
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
		} catch (Exception e) {
			extent_Reportlogger("Test Case EFTToMail Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFixedProduct_EFTToMail", e.getMessage());
			throw e;
		}

	}
	
	
}
