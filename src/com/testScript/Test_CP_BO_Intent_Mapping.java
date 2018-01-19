package com.testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.functions.common_CP.Common_Functions;
import com.functions.relationshipSummary.RelationshipSummaryCommonOprations;
import com.functions.relationshipSummary.RelationshipSummaryGoodToProcsFunction;
import com.pages.CP_BO_Intent_Mapping.CP_OtherActions;
import com.pages.FinancialPartialSurrender.Financial_FullSurrender;
import com.pages.Investment_BO.ExistingDCASchedule;
import com.pages.Investment_BO.Investment_Allocation;
import com.pages.Investment_BO.Perform_Transactions;
import com.pages.Investment_BO.Process_Tasks;
import com.pages.Investment_BO.ValidationMessagesAllocation_Window;
import com.pages.RelationshipSummary.BO_ReltnSummaryAssigneemaintenance;
import com.pages.RelationshipSummary.RelationshipSummary_Owner_Change;
import com.pages.RelationshipSummary.callPortal.CP_ReltnSummaryAssigneemaintenance;
import com.pages.RelationshipSummary.callPortal.CP_ReltnSummaryBeneficiarymaintenance;
import com.pages.commonFunctionality.CaseSummaryHeader;
import com.pages.commonScreens_CP.Workflow_Confirmation;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;

	public class Test_CP_BO_Intent_Mapping extends Test_BaseClass {
		
		@Test(priority = 0)
		public void billing_Send_Billing_Notice_CP_BO() throws Exception {
			
			try {
				
				Common_Functions common_Functions = new Common_Functions(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Send Billing Notice");
			}
			catch(Exception e)
			{
				extent_Reportlogger("Test Case Execution Failed","billing_Send_Billing_Notice_CP_BO", "Fail");
				excelWrite.writeInCell("billing_Send_Billing_Notice_CP_BO Test Case Execution Failed", "Fail");
				ErrorLogger.logError(e.getClass().getName(),"billing_Send_Billing_Notice_CP_BO", e.getMessage());
				throw e;
			}
			/*finally{
				ITestResult result;
				result=Reporter.getCurrentTestResult();
				System.out.println("Test Name:"+result.getTestName());
				System.out.println("Test Name:"+result.getName()+"Status:"+result.getStatus());
				finalReport(result.getName(), result.getStatus());
			}*/
			}
		
		@Test(priority=1)
		public void billing_Update_PlannedPremium_CP_BO() throws Exception
		{
			ITestResult result;
			result=Reporter.getCurrentTestResult();
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Update Planned Premium");	
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","billing_Update_PlannedPremium_CP_BO", "Fail");
			excelWrite.writeInCell("billing_Update_PlannedPremium_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"billing_Update_PlannedPremium_CP_BO", e.getMessage());
			throw e;
		}/*
			finally{
				System.out.println("Test Name:"+result.getTestName());
				System.out.println("Test Name:"+result.getName());
				finalReport(result.getName(), result.getStatus());
			}*/
		}
		
		@Test(priority=2)
		public void claim_Enter_DeathNotification_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Enter Death Notification");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","claim_Enter_DeathNotification_CP_BO", "Fail");
			excelWrite.writeInCell("claim_Enter_DeathNotification_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"claim_Enter_DeathNotification_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=3)
		public void claim_Enter_Disability_Notification_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Enter Disability Notification");
				
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","claim_Enter_Disability_Notification_CP_BO", "Fail");
			excelWrite.writeInCell("claim_Enter_Disability_Notification_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"claim_Enter_Disability_Notification_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=4)
		public void financial_Full_Surrender_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				Financial_FullSurrender financial_FullSurrender=new Financial_FullSurrender(driver);
				ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
				Workflow_Confirmation workflow_Confirmation=new Workflow_Confirmation(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invstment_IGOVerification();
				financial_FullSurrender.taxAndDisbursementTabProcess();
				validationMessagesAllocation_Window.switchTo_Window("Validation Messages Policy Termination");
				validationMessagesAllocation_Window.validationMessages_Verification("Validation Messages Policy Termination");
				validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget1Ifr");
				validationMessagesAllocation_Window.proceedWithSubmitAfterValidation();
				workflow_Confirmation.vpas_confirmation();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Full Surrender");
				
				
					
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","financial_Full_Surrender_CP_BO", "Fail");
			excelWrite.writeInCell("financial_Full_Surrender_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"financial_Full_Surrender_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=5)
		public void financial_Loan_By_Phone_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Loan By Phone");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","financial_Loan_By_Phone_CP_BO", "Fail");
			excelWrite.writeInCell("financial_Loan_By_Phone_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"financial_Loan_By_Phone_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=6)
		public void financial_Partial_Withdrawal_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Partial Withdrawal");
					
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","financial_Partial_Withdrawal_CP_BO", "Fail");
			excelWrite.writeInCell("financial_Partial_Withdrawal_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"financial_Partial_Withdrawal_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=7)
		public void formsRequest_AAR_DCA_Request_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("AAR / DCA Request");
					
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_AAR_DCA_Request_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_AAR_DCA_Request_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_AAR_DCA_Request_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=8)
		public void formsRequest_Acknowledgement_Of_Insurance_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Acknowledgement of Insurance");
				
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_Acknowledgement_Of_Insurance_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_Acknowledgement_Of_Insurance_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_Acknowledgement_Of_Insurance_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=9)
		public void formsRequest_AdHoc_Correspondence_Request_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Ad-Hoc Correspondence Request");
				
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_AdHoc_Correspondence_Request_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_AdHoc_Correspondence_Request_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_AdHoc_Correspondence_Request_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=10)
		public void formsRequest_Age_Correction_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Age Correction");
				
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_Age_Correction_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_Age_Correction_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_Age_Correction_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=11)
		public void formsRequest_Duplicate_Statements_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Duplicate Statements");
				
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_Duplicate_Statements_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_Duplicate_Statements_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_Duplicate_Statements_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=12)
		public void formsRequest_Freelook_Termination_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions=new CP_OtherActions(driver);
				Financial_FullSurrender financial_FullSurrender=new Financial_FullSurrender(driver);
				ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
				Workflow_Confirmation workflow_Confirmation=new Workflow_Confirmation(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Perform Transaction");
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.switchTo().activeElement());
				financial_FullSurrender.taxAndDisbursementTabProcess();
				validationMessagesAllocation_Window.switchTo_Window("Validation Messages Policy Termination");
				validationMessagesAllocation_Window.validationMessages_Verification("Freelook Termination");
				validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget1Ifr");
				validationMessagesAllocation_Window.proceedWithSubmitAfterValidation();
				workflow_Confirmation.vpas_confirmation();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Freelook Termination");
				
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_Freelook_Termination_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_Freelook_Termination_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_Freelook_Termination_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=13)
		public void formsRequest_Loan_Agreement_Form_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Loan Agreement Form");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_Loan_Agreement_Form_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_Loan_Agreement_Form_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_Loan_Agreement_Form_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=14)
		public void formsRequest_SWP_Set_Up_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("SWP Set Up");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","formsRequest_SWP_Set_Up_CP_BO", "Fail");
			excelWrite.writeInCell("formsRequest_SWP_Set_Up_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"formsRequest_SWP_Set_Up_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=15)
		public void policyMaintenance_Research_CP_BO() throws Exception {
			try {
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Research");
			}
			catch(Exception e)
			{
				extent_Reportlogger("Test Case Execution Failed","policyMaintenance_Research_CP_BO", "Fail");
				excelWrite.writeInCell("policyMaintenance_Research_CP_BO Test Case Execution Failed", "Fail");
				ErrorLogger.logError(e.getClass().getName(),"policyMaintenance_Research_CP_BO", e.getMessage());
				throw e;
			}
		}
		
		@Test(priority=16)
		public void nonFinancial_Agent_Change_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Agent Change");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_Agent_Change_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_Agent_Change_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_Agent_Change_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=17)
		public void nonFinancial_Duplicate_Policy_Request_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Duplicate Policy Request");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_Duplicate_Policy_Request_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_Duplicate_Policy_Request_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_Duplicate_Policy_Request_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=18)
		public void nonFinancial_Inforce_Illustrations_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Inforce Illustrations");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_Inforce_Illustrations_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_Inforce_Illustrations_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_Inforce_Illustrations_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=19)
		public void nonFinancial_Loan_History_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Loan History");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_Loan_History_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_Loan_History_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_Loan_History_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=20)
		public void nonFinancial_Manual_Report_Request_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Manual Report Request");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_Manual_Report_Request_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_Manual_Report_Request_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_Manual_Report_Request_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=21)
		public void nonFinancial_NFO_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("NFO");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_NFO_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_NFO_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_NFO_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=22)
		public void nonFinancial_Policy_History_Request_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
				cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Policy History Request");
			}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_Policy_History_Request_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_Policy_History_Request_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_Policy_History_Request_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=23)
		public void nonFinancial_TIN_SSN_Corrections_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
			
			common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
			cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
			process_Tasks.invPerformTrans_Tasks();
			process_Tasks.invCSRLetter_Tasks();
			caseSummaryHeader.caseStatusValidation("TIN/SSN Corrections");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","nonFinancial_TIN_SSN_Corrections_CP_BO", "Fail");
			excelWrite.writeInCell("nonFinancial_TIN_SSN_Corrections_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"nonFinancial_TIN_SSN_Corrections_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=24)
		public void complaints_Consumer_Agent_Complaint_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
			
			common_Functions.cp_BO_IntentMapping_InitiateBO_Flow1();
			cp_OtherActions.openLinkFrom_CaseContents("Execute CheckList");
			process_Tasks.invPerformTrans_Tasks();
			process_Tasks.invCSRLetter_Tasks();
			caseSummaryHeader.caseStatusValidation("Consumer/Agent Complaint");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","complaints_Consumer_Agent_Complaint_CP_BO", "Fail");
			excelWrite.writeInCell("complaints_Consumer_Agent_Complaint_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"complaints_Consumer_Agent_Complaint_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=25)
		public void assigneeChange_Relationship_Summary_CP_BO() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				CP_ReltnSummaryAssigneemaintenance CP_ReltnSumryAssigneemaintenance= new CP_ReltnSummaryAssigneemaintenance(driver);
				RelationshipSummaryCommonOprations RelationshipSummaryCommomOp = new RelationshipSummaryCommonOprations(driver);
				BO_ReltnSummaryAssigneemaintenance BO_ReltnSummaryAssigneemaintenance = new BO_ReltnSummaryAssigneemaintenance(driver);
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow2();
				cp_OtherActions.openLinkFrom_CaseContents("NFProcTran");
				CP_ReltnSumryAssigneemaintenance.addNewAssigne();
				RelationshipSummaryCommomOp.enter_UserPersonalDetails();
				RelationshipSummaryCommomOp.chkValidEmailId();
				RelationshipSummaryCommomOp.verifyPOPUPMsg();
				CP_ReltnSumryAssigneemaintenance.selectAssigneeType();
				CP_ReltnSumryAssigneemaintenance.sendAssigneeToVPAS();
				RelationshipSummaryCommomOp.editUserPersonalDetails();
				RelationshipSummaryCommomOp.verifyAddedInfoPOPUPMsg();
				CP_ReltnSumryAssigneemaintenance.sendUpdatedAssigneeToVPAS();
				BO_ReltnSummaryAssigneemaintenance.submitConfirmation();
				//BO_ReltnSummaryAssigneemaintenance.selectAdminChklistTaskBO();
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Assignee Change");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","assigneeChange_Relationship_Summary_CP_BO", "Fail");
			excelWrite.writeInCell("assigneeChange_Relationship_Summary_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"assigneeChange_Relationship_Summary_CP_BO", e.getMessage());
			throw e;
		}
		}
	
		@Test(priority=26)
		public void beneficiaryChange_Relationship_Summary_CP_BO() throws Exception
		{
			try
			{
				BaseUtils utility = new BaseUtils(driver);
				String benefiaciaryTypeOptionTextExpected = "Primary Beneficiary";
				Process_Tasks process_Tasks = new Process_Tasks(driver);
				Common_Functions common_Functions = new Common_Functions(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				RelationshipSummaryCommonOprations RelationshipSummaryCommonOprations = new RelationshipSummaryCommonOprations(driver);
				CP_ReltnSummaryBeneficiarymaintenance ReltnSummaryBeneficiarymaintenance = new CP_ReltnSummaryBeneficiarymaintenance(driver);
				RelationshipSummary_Owner_Change RelationshipSummary_Owner = new RelationshipSummary_Owner_Change(driver);

				
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow2();
				cp_OtherActions.openLinkFrom_CaseContents("NFProc Trans");
				RelationshipSummary_Owner.select_AddBeneficiaryUser();
				utility.click_On_Button(RelationshipSummary_Owner.click_AddAlphaforBeneficiary);
				
			//Calling Common Function for Enter User details
				RelationshipSummaryCommonOprations.enter_UserPersonalDetails();
				RelationshipSummaryCommonOprations.chkValidEmailId();
				
			//Code for Successfully Updated PoPUp verfication message
				RelationshipSummaryCommonOprations.verifyPOPUPMsg();
		

			//COde to Verify Default selection must be Primary User
				
				RelationshipSummary_Owner.click_SerachAlphaForBeneficiary();
				
		
				String clickPrimaryOptionText = RelationshipSummary_Owner.verifyPrimaryBeneficiaryType();
		
				Assert.assertEquals(clickPrimaryOptionText, benefiaciaryTypeOptionTextExpected);
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.enter_Text(RelationshipSummary_Owner.enter_Percentage, (reader.getMapData(CommonVariable.Enter_New_Percentage, map)+Keys.TAB));
				extent_Reportlogger(":Sucessfully Done", "Enter_New_Percentage", "PASS");
				excelWrite.writeInCell("Enter_New_PercentageisDone = " + reader.getMapData(CommonVariable.Enter_New_Percentage, map), "Pass"); 
				System.out.println("Inside New Perci");
				int enter_Percentage = Integer.parseInt(reader.getMapData(CommonVariable.Enter_New_Percentage, map));
				if(enter_Percentage<100 ||enter_Percentage==100)
				{
			
			
					utility.select_DropdownList(RelationshipSummary_Owner.select_Relationship, reader.getMapData(CommonVariable.select_Relationship, map));
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
	
					extent_Reportlogger(":Sucessfully Done", "RelationshipTypeselection", "PASS");
			
					excelWrite.writeInCell(
					"RelationshipTypeselectionisDone ", "Pass");
	
			
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					RelationshipSummary_Owner.click_AddAlphaforBeneficiary.click();
			
				}
		
				else
				{
					
			
					extent_Reportlogger(" AllocationPercentageCanNotBeMoreThan100", "Beneficiary Change", "Fail");
					excelWrite.writeInCell(
					"AllocationPercentageCanNotBeMoreThan100 ", "Fail");
				}
			
			
			//Enter details for Contingent 
		
				ReltnSummaryBeneficiarymaintenance.enter_UserPersonalDetailsForContingentUser();
			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
			
				RelationshipSummary_Owner.submit_ContingentBeneficiaryType();
				
				ReltnSummaryBeneficiarymaintenance.selectRelationShipForContingentUser();
				
				ReltnSummaryBeneficiarymaintenance.UpdateandSendInfoToVPASforContingentBeneficiary();
				RelationshipSummaryCommonOprations.verifyAddedInfoPOPUPMsg();
				RelationshipSummary_Owner.submit_InfoToVPASConti();
				
				process_Tasks.invPerformTrans_Tasks();
				process_Tasks.invCSRLetter_Tasks();
				caseSummaryHeader.caseStatusValidation("Beneficiary Change");
				
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","beneficiaryChange_Relationship_Summary_CP_BO", "Fail");
			excelWrite.writeInCell("beneficiaryChange_Relationship_Summary_CP_BO Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"beneficiaryChange_Relationship_Summary_CP_BO", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=27)
		public void investment_CP_BO_Allocation_T710() throws Exception
		{
			try
			{
			Common_Functions common_Functions = new Common_Functions(driver);
			Investment_Allocation investment_Allocation=new Investment_Allocation(driver);
			Perform_Transactions perform_Transactions= new Perform_Transactions(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			Workflow_Confirmation workflow_Confirmation=new Workflow_Confirmation(driver);
			CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
			CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
			
			common_Functions.cp_BO_IntentMapping_InitiateBO_Flow2();
			cp_OtherActions.openLinkFrom_CaseContents("Inv Perform Trans");
			investment_Allocation.createNewAllocationClick();
			investment_Allocation.allocationAddNewVarialble_Popup();
			investment_Allocation.cdAccountSelection();
			investment_Allocation.enterFundDetails(".ReAllocFunds","4");
			investment_Allocation.total_Verification();
			perform_Transactions.validateButtonClick();
			validationMessagesAllocation_Window.switchTo_Window("Validation Messages Allocation");
			validationMessagesAllocation_Window.validationMessages_Verification("Allocation");
			validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			validationMessagesAllocation_Window.proceedWithSubmitAfterValidation();
			workflow_Confirmation.vpas_confirmation();
			caseSummaryHeader.caseStatusValidation("Allocation");
			
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","investment_CP_BO_Allocation_T710", "Fail");
			excelWrite.writeInCell("investment_CP_BO_Allocation_T710 Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"investment_CP_BO_Allocation_T710", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=28)
		public void investment_CP_BO_Allocation_T730() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				Investment_Allocation investment_Allocation=new Investment_Allocation(driver);
				Perform_Transactions perform_Transactions= new Perform_Transactions(driver);
				ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
				Workflow_Confirmation workflow_Confirmation=new Workflow_Confirmation(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow2();
				cp_OtherActions.openLinkFrom_CaseContents("Inv Perform Trans");
				investment_Allocation.createNewAllocationClick();
				investment_Allocation.allocationAddNewVarialble_Popup();
				investment_Allocation.enterScheduleDetails();
				investment_Allocation.enterFundDetails(".InvSetupFunds","5");
				investment_Allocation.enterFundDetails(".InvSetupFunds","6");
				investment_Allocation.enterFundDetails(".InvSetupFunds","7");
				investment_Allocation.total_Verification();
				perform_Transactions.validateButtonClick();
				validationMessagesAllocation_Window.switchTo_Window("Validation Messages Allocation");
				validationMessagesAllocation_Window.validationMessages_Verification("Allocation");
				validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget1Ifr");
				validationMessagesAllocation_Window.proceedWithSubmitAfterValidation();
				workflow_Confirmation.vpas_confirmation();
				caseSummaryHeader.caseStatusValidation("Allocation");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","investment_CP_BO_Allocation_T730", "Fail");
			excelWrite.writeInCell("investment_CP_BO_Allocation_T730 Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"investment_CP_BO_Allocation_T730", e.getMessage());
			throw e;
		}
		}
		
		@Test(priority=29)
		public void investment_CP_BO_DCA_T705() throws Exception
		{
			try
			{
				Common_Functions common_Functions = new Common_Functions(driver);
				
				ExistingDCASchedule existingDCASchedule=new ExistingDCASchedule(driver);
				Perform_Transactions perform_Transactions= new Perform_Transactions(driver);
				ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
				Workflow_Confirmation workflow_Confirmation=new Workflow_Confirmation(driver);
				CaseSummaryHeader caseSummaryHeader=new CaseSummaryHeader(driver);
				CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
				
				common_Functions.cp_BO_IntentMapping_InitiateBO_Flow2();
				cp_OtherActions.openLinkFrom_CaseContents("PerformDCAEvent");
				existingDCASchedule.addNewSchedule_ButtonClick();
				existingDCASchedule.enterStartingDetails();
				existingDCASchedule.enterTransferFromDetails_DCA();
				existingDCASchedule.enterTransferToDetails_DCA();
				existingDCASchedule.proceed_ButtonClick();
				perform_Transactions.validateButtonClick();
				validationMessagesAllocation_Window.switchTo_Window("Validation Messages DCAEvent");
				validationMessagesAllocation_Window.validationMessages_Verification("DCAEvent");
				validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget1Ifr");
				validationMessagesAllocation_Window.proceedWithSubmitAfterValidation();
				workflow_Confirmation.vpas_confirmation();
				caseSummaryHeader.caseStatusValidation("DCAEvent");
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","investment_CP_BO_DCA_T705", "Fail");
			excelWrite.writeInCell("investment_CP_BO_DCA_T705 Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"investment_CP_BO_DCA_T705", e.getMessage());
			throw e;
		}
		}
	}
		
		