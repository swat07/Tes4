package com.testScript;

import org.testng.annotations.Test;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.functions.billingChanges.BillingChangesFlexibleProd;
import com.pages.BillingChanges.PerformTransactionPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;

public class Test_BillingChangeFlexibleProd extends Test_BaseClass {

	
	InitialCommonScreens_ReusableFunction resuablefunction;
	BaseUtils utility = new BaseUtils(driver);
	PerformTransactionPage performTransaction;
	BillingChangesFlexibleProd billingChangesFlexibleProd;
	

	@Test(priority = 0)
	public void billingChangesFlexibleProduct_PayorChange() throws Exception {

		try {
			
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillChanges(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));
			
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_PayorChange", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexibleProduct_PayorChange", e.getMessage());
			throw e;
		}

	}

	
	
	
	@Test(priority = 1)
	public void billingChangesFlexibleProduct_BillToDate() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillChanges(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_BillToDate", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_BillToDate Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexibleProduct_BillToDate", e.getMessage());
			throw e;
		}

	}

	
	@Test(priority = 2)
	public void billingChangesFlexibleProduct_DayOfMonth() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillChanges(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));
			
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_DayOfMonth", "PASS");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_DayOfMonth Successfull", "Pass");
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_DayOfMonth Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexibleProduct_DayOfMonth", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 3)
	public void billingChangesFlexibleProduct_PlannedPremiumUpdate() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillChanges(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));
			
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_PlannedPremiumUpdate", "PASS");
			excelWrite.writeInCell(
					"BillingChangesFlexibleProduct_PlannedPremiumUpdate Successfull", "Pass");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"BillingChangesFlexibleProduct_PlannedPremiumUpdate Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexibleProduct_PlannedPremiumUpdate", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 4)
	public void billingChangesFlexibleProduct_ManualBill() throws Exception {

		try {
			
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillChanges(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));

			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_ManualBill", "PASS");
			excelWrite.writeInCell(
					"BillingChangesFlexibleProduct_ManualBill Successfull", "Pass");
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"BillingChangesFlexibleProduct_ManualBill Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexibleProduct_ManualBill", e.getMessage());
			
			throw e;
		}

	}

	@Test(priority = 5)
	public void billingChangesFlexibleProduct_BillingElections() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
		
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillingelections(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));
			
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_BillingElections", "PASS");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_BillingElections Successfull", "Pass");
			
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_BillingElections Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexibleProduct_BillingElections", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 6)
	public void billingChangesFlexibleProduct_LoanBill() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillChanges(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));

			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_LoanBill", "PASS");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_LoanBill Successfull", "Pass");
			
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_LoanBill Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexibleProduct_LoanBill", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 7)
	public void billingChanges_FlexibleProduct_Billing_Method_MailToEFT() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBilling_MailToEFT(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChanges_FlexibleProduct_Billing_Method_MailToEFT", "PASS");
			excelWrite.writeInCell(
					"billingChanges_FlexibleProduct_Billing_Method_MailToEFT Successfull", "Pass");
			
		} catch (Exception e) {
			//Logging the logs in extent and excel			
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChanges_FlexibleProduct_Billing_Method_MailToEFT Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChanges_FlexibleProduct_Billing_Method_MailToEFT", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 8)
	public void billingChanges_FlexibleProduct_EFTToMail() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBilling_EFTToMail(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));
			//Logging the logs in extent and excel
			extent_Reportlogger(":Test_Case_Executed_Successfully", "billingChanges_FlexibleProduct_EFTToMail", "PASS");
			excelWrite.writeInCell(
					"billingChanges_FlexibleProduct_EFTToMail Successfull", "Pass");
			
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "billingChanges_FlexibleProduct_EFTToMail", "FAIL");
			excelWrite.writeInCell(
					"billingChanges_FlexibleProduct_EFTToMail Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChanges_FlexibleProduct_EFTToMail", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 9)
	public void billingChangesFlexibleProduct_BillingtoCancel() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillingCancel(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));

			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_BillingtoCancel", "PASS");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_BillingtoCancel Successfull", "Pass");
			
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_BillingtoCancel Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexibleProduct_BillingtoCancel", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 10)
	public void billingChangesFlexibleProduct_BillingtoSuspend() throws Exception {

		try {
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillingSuspend(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));

			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_BillingtoSuspend", "PASS");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_BillingtoSuspend Successfull", "Pass");
			
		} catch (Exception e) {
			//Logging the logs in extent and excel			
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_BillingtoSuspend Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexibleProduct_BillingtoSuspend", e.getMessage());
			throw e;
		}

	}
	
	@Test(priority = 11)
	public void billingChangesFlexibleProduct_CanceltoResume() throws Exception {

		try {
			
			// Get data from excel for Address change test case
			performTransaction = new PerformTransactionPage(driver);
			billingChangesFlexibleProd = new BillingChangesFlexibleProd(driver);
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			// Calling to common pages
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			resuablefunction.processTasks();
			
			//calling common function for flexible product
			billingChangesFlexibleProd.modifyBillingResume(performTransaction.selectBillingOptionChange,
				reader.getMapData(CommonVariable.billingChangeOption, map));

			//Logging the logs in extent and excel	
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "billingChangesFlexibleProduct_CanceltoResume", "PASS");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_CanceltoResume Successfull", "Pass");
			
		} catch (Exception e) {
			//Logging the logs in extent and excel	
			extent_Reportlogger("Test Case Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"billingChangesFlexibleProduct_CanceltoResume Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexibleProduct_CanceltoResume", e.getMessage());
			throw e;
		}

	}
	
}
