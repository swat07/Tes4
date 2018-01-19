package com.testScript;

import org.testng.annotations.Test;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;
import com.utility.WriteExcelFile;

import com.pages.commonFunctionality.BulkProcessWork;
import com.pages.commonFunctionality.CaseContents;
import com.pages.commonFunctionality.CaseSummaryHeader;
import com.pages.commonFunctionality.CheckListCopyPage;
import com.pages.commonFunctionality.CheckListForApproval;
import com.pages.commonFunctionality.CheckListVersionPage;
import com.pages.commonFunctionality.EditCheckListEnterNotesPage;
import com.pages.commonFunctionality.GoodOrderCheck;
import com.pages.commonFunctionality.ManagerPortalLandingPage;
import com.pages.commonFunctionality.OpenAssignments;
import com.pages.commonFunctionality.OtherOptions;
import com.pages.commonFunctionality.RestrictedPersonCheck;


public class Test_Common_Functionalities extends Test_BaseClass {
	
	ManagerPortalLandingPage admmPrtl;
	CheckListVersionPage chkLstVrsn;
	CheckListCopyPage chkLstCopy;
	EditCheckListEnterNotesPage chkListNotes;
	OpenAssignments openAssignments;
	GoodOrderCheck goodOrderCheck;
	CaseSummaryHeader caseSummaryHeader;
	
	BaseUtils utility = new BaseUtils(driver);

	@Test(priority = 0)
	public void admin_Checklist_NewQsn() throws Exception {

		try {
			admmPrtl=new ManagerPortalLandingPage(driver);
			chkLstVrsn=new CheckListVersionPage(driver);
			chkLstCopy=new CheckListCopyPage(driver);
			chkListNotes=new EditCheckListEnterNotesPage(driver);
			CheckListForApproval checkListForApproval=new CheckListForApproval(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			
			//To add a new Question
			//admmPrtl.selectManagerPortal();
			admmPrtl.openAdminCatalog();
			admmPrtl.openBuildNonFinActNFIGOcheck();
			chkLstVrsn.selectProduct_Category();
			chkLstCopy.selectValuesInCheckListCopy();
			chkListNotes.addNewQuestion();
			checkListForApproval.submitForApproval();
			checkListForApproval.submitForConfirmation();
			openAssignments.clickCaseLink("Admin CkList");
			openAssignments.approveTask();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			openAssignments.clickExecuteCheckList();
			openAssignments.taskToPerformQuestions();
			
			//To remove updated Question
			admmPrtl.openAdminCatalog();
			admmPrtl.openBuildNonFinActNFIGOcheck();
			chkLstVrsn.selectProduct_Category();
			chkLstCopy.selectValuesInCheckListCopy();
			chkListNotes.deleteQuestion();
			checkListForApproval.submitForApproval();
			checkListForApproval.submitForConfirmation();
			openAssignments.clickCaseLink("Admin CkList");
			openAssignments.approveTask();
			//openAssignments.createBackOff();
			//openAssignments.selectCategoryTransaction();
			//openAssignments.clickExecuteCheckList();
			
			extent_Reportlogger("Test Case Execution Successfull", "admin_Checklist_NewQsn", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "admin_Checklist_NewQsn", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"admin_Checklist_NewQsn", e.getMessage());
			throw e;
		}
		
	}
	
	@Test(priority = 1)
	public void admin_Checklist_CopyQsn() throws Exception {
		try {
			admmPrtl=new ManagerPortalLandingPage(driver);
			chkLstVrsn=new CheckListVersionPage(driver);
			chkLstCopy=new CheckListCopyPage(driver);
			chkListNotes=new EditCheckListEnterNotesPage(driver);
			CheckListForApproval checkListForApproval=new CheckListForApproval(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			
			//admmPrtl.selectManagerPortal();
			admmPrtl.openAdminCatalog();
			admmPrtl.openBuildNonFinActNFIGOcheck();
			chkLstVrsn.selectProduct_Category();
			chkLstCopy.selectQsnToCopy();
			chkListNotes.copyQuestion();
			checkListForApproval.submitForApproval();
			checkListForApproval.submitForConfirmation();
			openAssignments.clickCaseLink("Admin CkList");
			openAssignments.approveTask();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			openAssignments.clickExecuteCheckList();
			openAssignments.taskToPerformQuestions();
			

			//To remove updated Question
			admmPrtl.openAdminCatalog();
			admmPrtl.openBuildNonFinActNFIGOcheck();
			chkLstVrsn.selectProduct_Category();
			chkLstCopy.selectValuesInCheckListCopy();
			chkListNotes.deleteQuestion();
			checkListForApproval.submitForApproval();
			checkListForApproval.submitForConfirmation();
			openAssignments.clickCaseLink("Admin CkList");
			openAssignments.approveTask();
			//openAssignments.createBackOff();
			//openAssignments.selectCategoryTransaction();
			//openAssignments.clickExecuteCheckList();
			
			extent_Reportlogger("Test Case Execution Successfull", "admin_Checklist_CopyQsn", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "admin_Checklist_CopyQsn", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"admin_Checklist_CopyQsn", e.getMessage());
			throw e;
		}
		
	}
	
	@Test(priority = 2)
	public void terminateWorkItem() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			
			//admmPrtl.selectManagerPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			caseSummaryHeader.terminateClick();
			
			extent_Reportlogger("Test Case Execution Successfull", "terminateWorkItem", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
	} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "terminateWorkItem", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"terminateWorkItem", e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 3)
	public void reOpenWorkItem() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			
			//admmPrtl.selectManagerPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			caseSummaryHeader.terminateClick();
			caseSummaryHeader.reOpenClick();

			extent_Reportlogger("Test Case Execution Successfull", "reOpenWorkItem", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "reOpenWorkItem", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"reOpenWorkItem", e.getMessage());
			throw e;
		}
	}
	
	@Test(priority = 4)
	public void qsnPostedToSME_WB() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			RestrictedPersonCheck rstrctdPrsnCheck=new RestrictedPersonCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			OtherOptions othrOptions=new OtherOptions(driver);
			CaseContents caseContents=new CaseContents(driver);
			
			//admmPrtl.selectUserPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			caseSummaryHeader.caseSummaryInExecuteCheckList();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();
			othrOptions.addNewQuestionOtherOptions();
			goodOrderCheck.submit();
			//driver.switchTo().defaultContent();
			//driver.switchTo().frame("PegaGadget2Ifr");
			caseContents.assignedToCheck("NonFinSMEWB");
			
			extent_Reportlogger("Test Case Execution Successfull", "qsnPostedToSME_WB", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "qsnPostedToSME_WB", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"qsnPostedToSME_WB", e.getMessage());
			throw e;
	}
}

	@Test(priority = 5)
	public void respondToQsn_Verification() throws Exception {
		try {
			admmPrtl=new ManagerPortalLandingPage(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			RestrictedPersonCheck rstrctdPrsnCheck=new RestrictedPersonCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			OtherOptions othrOptions=new OtherOptions(driver);
			CaseContents caseContents=new CaseContents(driver);
			
			//admmPrtl.selectUserPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			caseSummaryHeader.caseSummaryInExecuteCheckList();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();
			othrOptions.addNewQuestionOtherOptions();
			goodOrderCheck.submit();
			caseContents.assignedToCheck("NonFinSMEWB");
			openAssignments.clickCaseLink("Respond To Question");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget3Ifr");
			othrOptions.respondToQuestion();
			
			extent_Reportlogger("Test Case Execution Successfull", "respondToQsn_Verification", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
	} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "respondToQsn_Verification", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"respondToQsn_Verification", e.getMessage());
			throw e;
		}
		
	}
	
	@Test(priority = 6)
	public void notifyManagerForAssignment() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			RestrictedPersonCheck rstrctdPrsnCheck=new RestrictedPersonCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			OtherOptions othrOptions=new OtherOptions(driver);
			
			//admmPrtl.selectUserPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			caseSummaryHeader.caseSummaryInExecuteCheckList();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();
			othrOptions.notifyOtherOptions();
			goodOrderCheck.submit();
			/*goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();*/
			
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "notifyManagerForAssignment", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"notifyManagerForAssignment", e.getMessage());
			throw e;
	}
}
	
	@Test(priority = 7)
	public void urgencyDecreaseVerification() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			RestrictedPersonCheck rstrctdPrsnCheck=new RestrictedPersonCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			OtherOptions othrOptions=new OtherOptions(driver);
			
			//admmPrtl.selectUserPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			caseSummaryHeader.caseSummaryInExecuteCheckList();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();
			othrOptions.enterValueToAdjustUrgency();
			goodOrderCheck.submit();
			caseSummaryHeader.urgencyUpdate();
			
			extent_Reportlogger("Test Case Execution Successfull", "urgencyDecreaseVerification", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "urgencyDecreaseVerification", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"urgencyDecreaseVerification", e.getMessage());
			throw e;
	}
}
	
	@Test(priority = 8)
	public void urgencyIncreaseVerification() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			RestrictedPersonCheck rstrctdPrsnCheck=new RestrictedPersonCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			OtherOptions othrOptions=new OtherOptions(driver);
			
			//admmPrtl.selectUserPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			caseSummaryHeader.caseSummaryInExecuteCheckList();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();
			othrOptions.enterValueToAdjustUrgency();
			goodOrderCheck.submit();
			caseSummaryHeader.urgencyUpdate();
			
			extent_Reportlogger("Test Case Execution Successfull", "urgencyIncreaseVerification", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "urgencyIncreaseVerification", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"urgencyIncreaseVerification", e.getMessage());
			throw e;
	}
}
		
	@Test(priority = 9)
	public void adHoc_AssignTaskToOtherCSR() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			RestrictedPersonCheck rstrctdPrsnCheck=new RestrictedPersonCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			OtherOptions othrOptions=new OtherOptions(driver);
			CaseContents caseContents= new CaseContents(driver);
			
			//admmPrtl.selectUserPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			caseSummaryHeader.caseSummaryInExecuteCheckList();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();
			othrOptions.createAdHocWorkOtherOptions();
			caseContents.assignedToCheck(reader.getMapData(CommonVariable.assignedTo_Operator, map));
			
			extent_Reportlogger("Test Case Execution Successfull", "adHoc_AssignTaskToOtherCSR", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "adHoc_AssignTaskToOtherCSR", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"adHoc_AssignTaskToOtherCSR", e.getMessage());
			throw e;
	}
}
	
	@Test(priority = 10)
	public void returnTo_WorkBasket() throws Exception {
		try{
			admmPrtl=new ManagerPortalLandingPage(driver);
			OpenAssignments openAssignments=new OpenAssignments(driver);
			goodOrderCheck=new GoodOrderCheck(driver);
			RestrictedPersonCheck rstrctdPrsnCheck=new RestrictedPersonCheck(driver);
			caseSummaryHeader=new CaseSummaryHeader(driver);
			OtherOptions othrOptions=new OtherOptions(driver);
			CaseContents caseContents=new CaseContents(driver);
			
			//admmPrtl.selectUserPortal();
			openAssignments.createBackOff();
			openAssignments.selectCategoryTransaction();
			caseSummaryHeader.caseSummaryInExecuteCheckList();
			openAssignments.clickExecuteCheckList();
			goodOrderCheck.taskToPerformDrpDwns();
			goodOrderCheck.processDecisionDrpDwns();
			goodOrderCheck.submit();
			rstrctdPrsnCheck.ofacProcessDecisionTask();
			goodOrderCheck.submit();
			othrOptions.returnToWorkbasketOtherOptions();
			goodOrderCheck.submit();
			caseContents.assignedToCheck("NonFinWB");
			
			extent_Reportlogger("Test Case Execution Successfull", "returnTo_WorkBasket", "PASS");
			excelWrite.writeInCell("Test Case Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Execution failed", "returnTo_WorkBasket", "FAIL");
			excelWrite.writeInCell("Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"returnTo_WorkBasket", e.getMessage());
			throw e;
	}
}
	
	@Test(priority = 11)
	public void bulkTransfer_CSRTo_OtherCSR() throws Exception {
	try{
		admmPrtl=new ManagerPortalLandingPage(driver);
		OpenAssignments openAssignments=new OpenAssignments(driver);
		BulkProcessWork bulkProcessWork=new BulkProcessWork(driver);
		
		//admmPrtl.selectUserPortal();
		openAssignments.optionsBulkTransferClick();
		bulkProcessWork.selectCaseType();
		bulkProcessWork.filterWorkClick();
		bulkProcessWork.selectActionTransferAssignment();
		bulkProcessWork.reAssignPopup("CSR");
		bulkProcessWork.processingResultsUpdate_AfterTransfer();
		
		extent_Reportlogger("Test Case Execution Successfull", "bulkTransfer_CSRTo_OtherCSR", "PASS");
		excelWrite.writeInCell("Test Case Failed", "Fail");
	} catch (Exception e) {
		extent_Reportlogger("Test Case Execution failed", "bulkTransfer_CSRTo_OtherCSR", "FAIL");
		excelWrite.writeInCell("Test Case Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),
				"bulkTransfer_CSRTo_OtherCSR", e.getMessage());
		throw e;
}
}

	@Test(priority = 12)
	public void bulkTransfer_CSRTo_WB() throws Exception {
	try{
		admmPrtl=new ManagerPortalLandingPage(driver);
		OpenAssignments openAssignments=new OpenAssignments(driver);
		BulkProcessWork bulkProcessWork=new BulkProcessWork(driver);
		
		//admmPrtl.selectUserPortal();
		openAssignments.optionsBulkTransferClick();
		bulkProcessWork.selectCaseType();
		bulkProcessWork.filterWorkClick();
		bulkProcessWork.selectActionTransferAssignment();
		bulkProcessWork.reAssignPopup("WB");
		bulkProcessWork.processingResultsUpdate_AfterTransfer();
		
		extent_Reportlogger("Test Case Execution Successfull", "bulkTransfer_CSRTo_WB", "PASS");
		excelWrite.writeInCell("Test Case Failed", "Fail");
	} catch (Exception e) {
		extent_Reportlogger("Test Case Execution failed", "bulkTransfer_CSRTo_WB", "FAIL");
		excelWrite.writeInCell("Test Case Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),
				"bulkTransfer_CSRTo_WB", e.getMessage());
		throw e;
}
}
	
	@Test(priority = 13)
	public void bulkTransfer_FailedMessage_Verification() throws Exception {
	try{
		admmPrtl=new ManagerPortalLandingPage(driver);
		OpenAssignments openAssignments=new OpenAssignments(driver);
		BulkProcessWork bulkProcessWork=new BulkProcessWork(driver);
		
		openAssignments.optionsBulkTransferClick();
		bulkProcessWork.selectCaseType();
		bulkProcessWork.filterWorkClick();
		bulkProcessWork.selectActionTransferAssignment();
		bulkProcessWork.reAssignPopup("WB");
		bulkProcessWork.processingResultsUpdate_AfterTransfer();
		bulkProcessWork.failedStatusMessageVerification();
		
		extent_Reportlogger("Test Case Execution Successfull", "bulkTransfer_FailedMessage_Verification", "PASS");
		excelWrite.writeInCell("Test Case Failed", "Fail");
	} catch (Exception e) {
		extent_Reportlogger("Test Case Execution failed", "bulkTransfer_FailedMessage_Verification", "FAIL");
		excelWrite.writeInCell("Test Case Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),
				"bulkTransfer_FailedMessage_Verification", e.getMessage());
		throw e;
}
}
}


