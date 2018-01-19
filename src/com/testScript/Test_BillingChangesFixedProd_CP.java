/*package com.testScript;

import org.testng.annotations.Test;

import com.functions.billingChanges.BillingChangesFixedProd;
import com.functions.common_CP.Common_Functions;

import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;

public class Test_BillingChangesFixedProd_CP extends Test_BaseClass {
	
	BillingChangesFixedProd billingChangesFixedProd;
	
	
	
	@Test(priority = 0)
	public void CP_BillingtoCancel_FixedProduct() throws Exception {

		try {
			// Get data from excel for Address change test case
			Common_Functions common_Functions = new Common_Functions(driver);
			CP_BillingFixedProductPage cp_billingfixed=new CP_BillingFixedProductPage(driver);
			// Calling to common pages
			common_Functions.callPortal_ActionLaunch();
			
			//calling common function for fixed product
			
			cp_billingfixed.modify_BillingToCancel("BillingtoCancel");
			common_Functions.callPortal_EndInteraction();
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "CP_BillingtoCancel_FixedProduct", "PASS");
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
	public void CP_CanceltoResume_FixedProduct() throws Exception {

		try {
			
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			Common_Functions common_Functions = new Common_Functions(driver);
			CP_BillingFixedProductPage cp_billingfixed=new CP_BillingFixedProductPage(driver);
			// Calling to common pages
			common_Functions.callPortal_ActionLaunch();
			
			//calling common function for fixed product
			cp_billingfixed.modify_BillingToCancel("CanceltoResume");
			common_Functions.callPortal_EndInteraction();
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "CP_CanceltoResume_FixedProduct", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case CanceltoResume Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_CanceltoResume_FixedProduct", e.getMessage());
			
			
			throw e;
		}

	}
	
	
	@Test(priority = 2)
	public void CP_CancelPolicyLapse_FixedProduct() throws Exception {

		try {
			
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			Common_Functions common_Functions = new Common_Functions(driver);
			CP_BillingFixedProductPage cp_billingfixed=new CP_BillingFixedProductPage(driver);
			// Calling to common pages
			common_Functions.callPortal_ActionLaunch();
			//calling common function for fixed product
			cp_billingfixed.modify_BillingToCancel("Cancel Policy Lapse");
			common_Functions.callPortal_EndInteraction();
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "CP_CancelPolicyLapse_FixedProduct", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case CancelPolicyLapse Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case CancelPolicyLapse Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_CancelPolicyLapse_FixedProduct", e.getMessage());
			
			
			throw e;
		}

	}
	
	@Test(priority = 3)
	public void CP_BillAhead_FixedProduct() throws Exception {

		try {
			logger = report
					.startTest("billingChangesFixedProduct_BillAhead");
			// Get data from excel for Address change test case
			
			Common_Functions common_Functions = new Common_Functions(driver);
			CP_BillingFixedProductPage cp_billingfixed=new CP_BillingFixedProductPage(driver);
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			common_Functions.callPortal_ActionLaunch();
			//calling common function for fixed product
			cp_billingfixed.modify_BillAhead();
			common_Functions.callPortal_EndInteraction();
			//billingChangesFixedProd.modify_billingAhead();
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "CP_BillAhead_FixedProduct", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case Bill Ahead Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_BillAhead_FixedProduct", e.getMessage());
			
			
			throw e;
		}

	}
	
	@Test(priority = 4)
	public void CP_ReBill_FixedProduct() throws Exception {

		try {
			// Get data from excel for Address change test case
			Common_Functions common_Functions = new Common_Functions(driver);
			CP_BillingFixedProductPage cp_billingfixed=new CP_BillingFixedProductPage(driver);
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			common_Functions.callPortal_ActionLaunch();
			//calling common function for fixed product
			cp_billingfixed.modify_ReBill();
			common_Functions.callPortal_EndInteraction();
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "CP_ReBill_FixedProduct", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case ReBill Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_ReBill_FixedProduct", e.getMessage());
			
			
			throw e;
		}

	}
	
	@Test(priority = 5)
	public void CP_MailToEFT_FixedProduct() throws Exception {

		try {
			logger = report
					.startTest("billingChangesFixedProduct_MailToEFT");
			Common_Functions common_Functions = new Common_Functions(driver);
			billingChangesFixedProd = new BillingChangesFixedProd(driver);
			// Get data from excel for Address change test case
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			common_Functions.callPortal_ActionLaunch();
			//calling common function for fixed product
			billingChangesFixedProd.modify_billingMailToEft();
			common_Functions.callPortal_EndInteraction();
			//Logging the logs in extent and excel			
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "CP_MailToEFT_FixedProduct", "PASS");
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case MailToEFT Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_MailToEFT_FixedProduct", e.getMessage());
			
			
			throw e;
		}

	}
	
	
	@Test(priority = 5)
	public void CP_EFTToMail_FixedProduct() throws Exception {

		try {
			logger = report
					.startTest("billingChangesFixedProduct_MailToEFT");
			Common_Functions common_Functions = new Common_Functions(driver);
			CP_BillingFixedProductPage cp_billingfixed=new CP_BillingFixedProductPage(driver);
			//performTransaction = new PerformTransactionPage(driver);
			// Calling to common pages
			common_Functions.callPortal_ActionLaunch();
			//calling common function for fixed product
			cp_billingfixed.modify_EftToMail();
			common_Functions.callPortal_EndInteraction();
			//Logging the logs in extent and excel					
			extent_Reportlogger(" :Test_Case_Executed_Successfully", "CP_EFTToMail_FixedProduct", "PASS");
			
			excelWrite.writeInCell(
					"Test Case Successfull", "Pass");
		} catch (Exception e) {
			extent_Reportlogger("Test Case EFTToMail Failed", "Failed Screen", "FAIL");
			excelWrite.writeInCell(
					"Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_EFTToMail_FixedProduct", e.getMessage());
			throw e;
		}

	}
	
	
	
	

}
*/