/*package com.testScript;

import org.testng.annotations.Test;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.functions.common_CP.Common_Functions;

import com.pages.BillingChanges.CallPortal.CP_BillingFlexChangeMethod_Freq;
import com.pages.commonScreens_CP.Action_Summary;
import com.utility.BaseUtils;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class Test_BillingChngsFlxblePrdt_CP extends Test_BaseClass {

	BaseUtils utility = new BaseUtils(driver);
	CP_BillingFlexChangeMethod_Freq CP_BillingFlexibleScreens;
	Common_Functions common_Functions;

	// Test Case 1

	@Test(priority = 0)
	public void CP_PayorChange_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens
					.billingChangesFlexible_PayorChangeMethod();

			common_Functions.callPortalBilling_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChangesFlexible_PayorChange", "Fail");
			excelWrite.writeInCell(
					"BillingChangesFlexible_PayorChange Test Case Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexible_PayorChange", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 2

	@Test(priority = 1)
	public void CP_BillToDate_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.billingChangesFlexible_BillToDateMethod();

			common_Functions.callPortalBilling_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChangesFlexible_BillToDate", "Fail");
			excelWrite.writeInCell(
					"BillingChangesFlexible_BillToDate Test Case Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexible_BillToDate", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 3

	@Test(priority = 2)
	public void CP_DOM_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.billingChangesFlexible_DOM();

			CP_BillingFlexibleScreens
					.callPortalBillingFlexible_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChangesFlexible_DOM", "Fail");
			excelWrite.writeInCell(
					"BillingChangesFlexible_DOM Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexible_DOM", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 4

	@Test(priority = 3)
	public void CP_PlannedPremUpdt_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.billingChngFlex_PlannedPremUpdt();

			CP_BillingFlexibleScreens
					.callPortalBillingFlexible_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"CP_PlannedPremUpdt_FlexibleProduct", "Fail");
			excelWrite.writeInCell(
					"CP_PlannedPremUpdt_FlexibleProduct Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_PlannedPremUpdt_FlexibleProduct", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 5

	@Test(priority = 4)
	public void CP_ManualBill_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
		Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.BillingChangesFlexible_ManualBillMethod();

			common_Functions.callPortalBilling_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChangesFlexible_ManualBill", "Fail");
			excelWrite.writeInCell(
					"BillingChangesFlexible_ManualBill Test Case Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexible_ManualBill", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 6
	@Test(priority = 5)
	public void CP_BillingChngFlex_billElections() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
		Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.billingChngFlex_billElections();

			CP_BillingFlexibleScreens
					.callPortalBillingFlexible_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChngFlex_billElections", "Fail");
			excelWrite.writeInCell(
					"BillingChngFlex_billElections Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChngFlex_billElections", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 7

	@Test(priority = 6)
	public void CP_LoanBill_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.BillingChangesFlexible_LoanBillMethod();
			common_Functions.callPortalBilling_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChangesFlexible_LoanBill", "Fail");
			excelWrite.writeInCell(
					"BillingChangesFlexible_LoanBill Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexible_LoanBill", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 8

	@Test(priority = 7)
	public void CP_MailtoEFT_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens
					.billingChngFlex_MailtoEFT();
			CP_BillingFlexibleScreens
			.callPortalBillingFlexible_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"CP_MailtoEFT_FlexibleProduct", "Fail");
			excelWrite
					.writeInCell(
							"CP_MailtoEFT_FlexibleProduct Test Case Failed",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"CP_MailtoEFT_FlexibleProduct",
					e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 9
	@Test(priority = 8)
	public void CP_EFTtoMail_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.billingChngFlex_EFTtoMail();

			CP_BillingFlexibleScreens
					.callPortalBillingFlexible_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChngFlex_billElections", "Fail");
			excelWrite.writeInCell(
					"BillingChngFlex_billElections Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChngFlex_billElections", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 10

	@Test(priority = 9)
	public void CP_BillingtoCancel_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.billingChngFlex_BillingtoCancel();

			CP_BillingFlexibleScreens
					.callPortalBillingFlexible_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChngFlex_billElections", "Fail");
			excelWrite.writeInCell(
					"BillingChngFlex_billElections Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChngFlex_billElections", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 11

	@Test(priority = 10)
	public void CP_BillingToSuspend_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens
					.BillingChangesFlexible_BillingToSuspendMethod();
			common_Functions.callPortalBilling_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChangesFlexible_BillingToSuspend", "Fail");
			excelWrite.writeInCell(
					"BillingChangesFlexible_BillingToSuspend Test Case Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChangesFlexible_BillingToSuspend", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	// Test Case 12
	@Test(priority = 11)
	public void CP_CanceltoResume_FlexibleProduct() throws Exception {
		try {
			CP_BillingFlexibleScreens = new CP_BillingFlexChangeMethod_Freq(driver);
			Common_Functions common_Functions = new Common_Functions(driver);

			common_Functions.callPortal_ActionLaunch();
			CP_BillingFlexibleScreens.billingChngFlex_CanceltoResume();

			CP_BillingFlexibleScreens
					.callPortalBillingFlexible_EndInteraction();

		}

		catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"BillingChngFlex_billElections", "Fail");
			excelWrite.writeInCell(
					"BillingChngFlex_billElections Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"BillingChngFlex_billElections", e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

}
*/