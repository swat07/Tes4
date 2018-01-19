package com.testScript;

import org.testng.annotations.Test;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.pages.Investment_BO.CGO_Allocation;
import com.pages.Investment_BO.CGO_Termination;
import com.pages.Investment_BO.ExistingDCASchedule;
import com.pages.Investment_BO.Investment_Allocation;
import com.pages.Investment_BO.Process_Tasks;
import com.pages.Investment_BO.Perform_Transactions;
import com.pages.Investment_BO.Transfer_Allocation;
import com.pages.Investment_BO.VPAS_Confirmation;
import com.pages.Investment_BO.ValidationMessagesAllocation_Window;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;
import com.utility.WriteExcelFile;

public class Test_Investment_BO extends Test_BaseClass {
	
	InitialCommonScreens_ReusableFunction resuablefunction;
	
	@Test(priority = 0)
	public void bckOff_Allocation_T710() throws Exception {
		try {
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			Investment_Allocation investment_Allocation=new Investment_Allocation(driver);
			Perform_Transactions perform_Transactions= new Perform_Transactions(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			VPAS_Confirmation vPAS_Confirmation=new VPAS_Confirmation(driver);
			
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			process_Tasks.invstment_IGOVerification();
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
			driver.switchTo().frame("PegaGadget2Ifr");
			validationMessagesAllocation_Window.proceedWithSubmitAfterValidation();
			//perform_Transactions.submitButtonClick();
			vPAS_Confirmation.iAmDone_ButtonClick();
			process_Tasks.invCSRLetter_Tasks();
		}
		catch(Exception e)
		{
			extent_Reportlogger("Test Case Execution Failed","bckOff_Allocation_T710", "Fail");
			excelWrite.writeInCell("bckOff_Allocation_T710 Test Case Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"bckOff_Allocation_T710", e.getMessage());
			throw e;
		}
		}
	
	@Test(priority=1)
	public void bckOff_Allocation_T730() throws Exception
	{
		try
		{
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			Investment_Allocation investment_Allocation=new Investment_Allocation(driver);
			Perform_Transactions perform_Transactions= new Perform_Transactions(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			VPAS_Confirmation vPAS_Confirmation=new VPAS_Confirmation(driver);
			
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			process_Tasks.invstment_IGOVerification();
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
			driver.switchTo().frame("PegaGadget2Ifr");
			validationMessagesAllocation_Window.proceedWithSubmitAfterValidation();
			vPAS_Confirmation.iAmDone_ButtonClick();
			process_Tasks.invCSRLetter_Tasks();
	}
	catch(Exception e)
	{
		extent_Reportlogger("Test Case Execution Failed","bckOff_Allocation_T730", "Fail");
		excelWrite.writeInCell("bckOff_Allocation_T730 Test Case Execution Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"bckOff_Allocation_T730", e.getMessage());
		throw e;
	}
	}
	
	@Test(priority=2)
	public void bckOff_DCA_T705() throws Exception
	{
		try
		{
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			ExistingDCASchedule existingDCASchedule=new ExistingDCASchedule(driver);
			Perform_Transactions perform_Transactions= new Perform_Transactions(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			VPAS_Confirmation vPAS_Confirmation=new VPAS_Confirmation(driver);
			
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			process_Tasks.invstment_IGOVerification();
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
			driver.switchTo().frame("PegaGadget2Ifr");
			perform_Transactions.submitButtonClick();
			vPAS_Confirmation.done_ButtonClick_DCAEvent();
			process_Tasks.invCSRLetter_Tasks();
		
	}
	catch(Exception e)
	{
		extent_Reportlogger("Test Case Execution Failed","bckOff_DCA_T705", "Fail");
		excelWrite.writeInCell("bckOff_DCA_T705 Test Case Execution Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"bckOff_DCA_T705", e.getMessage());
		throw e;
	}
	}
	
	@Test(priority=3)
	public void bckOff_FundTransfer_T700() throws Exception
	{
		try
		{
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			ExistingDCASchedule existingDCASchedule=new ExistingDCASchedule(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			VPAS_Confirmation vPAS_Confirmation=new VPAS_Confirmation(driver);
			Transfer_Allocation transfer_Allocation=new Transfer_Allocation(driver);
			
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			process_Tasks.invstment_IGOVerification();
			existingDCASchedule.enterEventDateAndEffDate();
			existingDCASchedule.validateSel_ButtonClick();
			existingDCASchedule.proceed_ButtonClick();
			transfer_Allocation.selectTransferByAndMode();
			transfer_Allocation.enterTransferFromDetails_FundTransfer();
			transfer_Allocation.enterTransferToDetails_FundTransfer();
			transfer_Allocation.validateAndCalculate_ButtonClick();
			validationMessagesAllocation_Window.switchTo_Window("MC Display Validate Messages Class for Fund Transfer");
			validationMessagesAllocation_Window.validationMessages_Verification("Fund Transfer");
			validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			transfer_Allocation.continue_ButtonClick();
			transfer_Allocation.confirm_ButtonClick();
			vPAS_Confirmation.done_ButtonClick();
			process_Tasks.invCSRLetter_Tasks();
	}
	catch(Exception e)
	{
		extent_Reportlogger("Test Case Execution Failed","bckOff_FundTransfer_T700", "Fail");
		excelWrite.writeInCell("bckOff_FundTransfer_T700 Test Case Execution Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"bckOff_FundTransfer_T700", e.getMessage());
		throw e;
	}
	}
	
	@Test(priority=4)
	public void bckOff_CGO_Termination_A009() throws Exception
	{
		try
		{
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			CGO_Termination cgo_Termination=new CGO_Termination(driver);
			VPAS_Confirmation vPAS_Confirmation=new VPAS_Confirmation(driver);
			
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			process_Tasks.invstment_IGOVerification();
			cgo_Termination.selectPremiumAccount();
			cgo_Termination.loadFunds_ButtonClick();
			cgo_Termination.selectCGOFundForTermination();
			cgo_Termination.enterTransferFundDetails_CGO_Termination();
			cgo_Termination.validate_ButtonClick();
			validationMessagesAllocation_Window.switchTo_Window("Validation Messages CGO Termination");
			validationMessagesAllocation_Window.validationMessages_Verification("CGO_Termination");
			validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			cgo_Termination.submit_ButtonClick();
			vPAS_Confirmation.done_ButtonClick();
			}
	catch(Exception e)
	{
		extent_Reportlogger("Test Case Execution Failed","bckOff_CGO_Termination_A009", "Fail");
		excelWrite.writeInCell("bckOff_CGO_Termination_A009 Test Case Execution Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"bckOff_CGO_Termination_A009", e.getMessage());
		throw e;
	}
	}

	@Test(priority=5)
	public void bckOff_CGO_ManualAllocation_T590() throws Exception
	{
		try
		{
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			CGO_Allocation cgo_Allocation=new CGO_Allocation(driver);
			VPAS_Confirmation vPAS_Confirmation=new VPAS_Confirmation(driver);
			
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			process_Tasks.invstment_IGOVerification();
			cgo_Allocation.enterEventDateAndEffDate();
			cgo_Allocation.selectPremiumAccount();
			cgo_Allocation.fundAllocation_ButtonClick();
			cgo_Allocation.enterInvestmentFundDetails("CGO");
			cgo_Allocation.ok_ButtonClick();
			cgo_Allocation.validate_ButtonClick();
			validationMessagesAllocation_Window.switchTo_Window("Validation Messages CGO Allocation");
			validationMessagesAllocation_Window.validationMessages_Verification("CGO Allocation");
			validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			cgo_Allocation.submit_ButtonClick();
			vPAS_Confirmation.cgoConfirmationSubmit_ButtonClick();
			process_Tasks.invCSRLetter_Tasks();
	}
	catch(Exception e)
	{
		extent_Reportlogger("Test Case Execution Failed","bckOff_CGO_ManualAllocation_T590", "Fail");
		excelWrite.writeInCell("bckOff_CGO_ManualAllocation_T590 Test Case Execution Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"bckOff_CGO_ManualAllocation_T590", e.getMessage());
		throw e;
	}
	}
	
	@Test(priority=6)
	public void bckOff_EquityIndexAllocation_T790() throws Exception
	{
		try
		{
			resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			Process_Tasks process_Tasks = new Process_Tasks(driver);
			ValidationMessagesAllocation_Window validationMessagesAllocation_Window=new ValidationMessagesAllocation_Window(driver);
			CGO_Allocation cgo_Allocation=new CGO_Allocation(driver);
			VPAS_Confirmation vPAS_Confirmation=new VPAS_Confirmation(driver);
			
			resuablefunction.landing_page();
			resuablefunction.selectCategoryAndTransaction();
			resuablefunction.executeChecklist();
			process_Tasks.invstment_IGOVerification();
			cgo_Allocation.enterEventDateAndEffDate();
			cgo_Allocation.selectPremiumAccount();
			cgo_Allocation.fundAllocation_ButtonClick();
			cgo_Allocation.enterInvestmentFundDetails("Equity Index Fund");
			cgo_Allocation.ok_ButtonClick();
			cgo_Allocation.validate_ButtonClick();
			validationMessagesAllocation_Window.switchTo_Window("Validation Messages CGO Allocation");
			validationMessagesAllocation_Window.validationMessages_Verification("CGO Allocation");
			validationMessagesAllocation_Window.closeButtonClick("Back Office User Portal");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			cgo_Allocation.submit_ButtonClick();
			vPAS_Confirmation.cgoConfirmationSubmit_ButtonClick();
			process_Tasks.invCSRLetter_Tasks();
	}
	catch(Exception e)
	{
		extent_Reportlogger("Test Case Execution Failed","bckOff_EquityIndexAllocation_T790", "Fail");
		excelWrite.writeInCell("bckOff_EquityIndexAllocation_T790 Test Case Execution Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"bckOff_EquityIndexAllocation_T790", e.getMessage());
		throw e;
	}
	}
	
}
