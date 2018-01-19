package com.functions.common_CP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.CP_BO_Intent_Mapping.CP_OtherActions;
import com.pages.Investment_BO.ExistingDCASchedule;
import com.pages.Investment_BO.Perform_Transactions;
import com.pages.Investment_BO.ValidationMessagesAllocation_Window;
import com.pages.commonScreens_CP.Action_Summary;
import com.pages.commonScreens_CP.Owner_Verification;
import com.pages.commonScreens_CP.Policy_Search;
import com.pages.commonScreens_CP.Welcome_Page;
import com.pages.commonScreens_CP.Workflow_Confirmation;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class Common_Functions extends Initialize_Browser {

	public Common_Functions(WebDriver driver) {
		this.driver = driver;
	}

	public void callPortal_ActionLaunch() throws Exception {
		try {
			Welcome_Page welcome_Page = new Welcome_Page(driver);
			Policy_Search policy_Search = new Policy_Search(driver);
			Owner_Verification owner_Verification = new Owner_Verification(
					driver);
			Action_Summary action_Summary = new Action_Summary(driver);

			welcome_Page.serviceACustomer_LinkClick();
			policy_Search.policySearch();
			driver.switchTo().frame(driver.switchTo().activeElement());
			owner_Verification.verifyAllQsnsAndSubmit();
			action_Summary.action_LinkClick();
			action_Summary.expandAction_SelectCategory();
			action_Summary.launch_ButtonClick();

			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"callPortal_ActionLaunch", "FAIL");
			excelWrite
					.writeInCell(
							"callPortal_ActionLaunch Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"callPortal_ActionLaunch", e.getMessage());
			throw e;
		}
	}

	public void callPortal_EndInteraction() throws Exception {
		try {
			Workflow_Confirmation workflow_Confirmation = new Workflow_Confirmation(
					driver);
			Action_Summary action_Summary = new Action_Summary(driver);

			// workflow_Confirmation.vpas_confirmation();
			workflow_Confirmation.enterComments();
			workflow_Confirmation.done_ButtonClick();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("cpmInteractionDivFrame");
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));

			action_Summary.wrapUp_LinkClick();
			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
			action_Summary.enterWrapUpDetails_EndInteraction();
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"callPortal_EndInteraction", "FAIL");
			excelWrite
					.writeInCell(
							"callPortal_EndInteraction Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"callPortal_EndInteraction", e.getMessage());
			throw e;
		}
	}

	public void callPortalBilling_EndInteraction() throws Exception {
		try {
			Action_Summary action_Summary = new Action_Summary(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("cpmInteractionDivFrame");
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));

			action_Summary.wrapUp_LinkClick();
			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
			action_Summary.enterWrapUpDetails_EndInteraction();
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"callPortalBilling_EndInteraction", "FAIL");
			excelWrite
					.writeInCell(
							"callPortalBilling_EndInteraction Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"callPortalBilling_EndInteraction", e.getMessage());
			throw e;
		}
	}
	
	public void cp_BO_IntentMapping_InitiateBO_Flow1() throws Exception {
		try {
		CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
		Action_Summary action_Summary = new Action_Summary(driver);
		
		callPortal_ActionLaunch();
		cp_OtherActions.enterCommentsAndSubmit();
		cp_OtherActions.saveID_ClickOnDone();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("cpmInteractionDivFrame");
		driver.switchTo().frame(
				driver.findElement(By.xpath("//frame[@name='DIACTION']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//frame[@name='DIACTION']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//frame[@name='DIACTION']")));

		action_Summary.wrapUp_LinkClick();
		driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
		action_Summary.enterWrapUpDetails_EndInteraction();
		cp_OtherActions.moveToBO();
		cp_OtherActions.searchCaseAndOpenInv();
		
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"cp_BO_IntentMapping_InitiateBO_Flow", "FAIL");
			excelWrite
					.writeInCell(
							"cp_BO_IntentMapping_InitiateBO_Flow Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"cp_BO_IntentMapping_InitiateBO_Flow", e.getMessage());
			throw e;
		}
	}

	public void cp_BO_IntentMapping_InitiateBO_Flow2() throws Exception {
		try {
		CP_OtherActions cp_OtherActions = new CP_OtherActions(driver);
		Action_Summary action_Summary = new Action_Summary(driver);
		
		callPortal_ActionLaunch();
		cp_OtherActions.selectOtherActions("Initiate Back Office Workflow");
		cp_OtherActions.enterCommentsAndSubmit();
		cp_OtherActions.saveID_ClickOnDone();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("cpmInteractionDivFrame");
		driver.switchTo().frame(
				driver.findElement(By.xpath("//frame[@name='DIACTION']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//frame[@name='DIACTION']")));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//frame[@name='DIACTION']")));

		action_Summary.wrapUp_LinkClick();
		driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
		action_Summary.enterWrapUpDetails_EndInteraction();
		cp_OtherActions.moveToBO();
		cp_OtherActions.searchCaseAndOpenInv();
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"cp_BO_IntentMapping_InitiateBO_Flow", "FAIL");
			excelWrite
					.writeInCell(
							"cp_BO_IntentMapping_InitiateBO_Flow Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"cp_BO_IntentMapping_InitiateBO_Flow", e.getMessage());
			throw e;
		}
	}
	
}
