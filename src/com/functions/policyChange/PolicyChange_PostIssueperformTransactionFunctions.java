package com.functions.policyChange;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.AddressChangeScreens.AddressType_PhoneChange;
import com.pages.AddressChangeScreens.CopyExistandAddNew_PerformTranPage;
import com.pages.PolicyChangeScreens.PolicyChange_PerformTransactionScreen;
import com.pages.PolicyChangeScreens.PolicyChange_ValidationMszScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class PolicyChange_PostIssueperformTransactionFunctions extends
		Initialize_Browser {

	public PolicyChange_PostIssueperformTransactionFunctions(WebDriver driver) {
		this.driver = driver;
	}

	PolicyChange_PerformTransactionScreen policyPerformTrans_locators;

	BaseUtils utility = new BaseUtils(driver);
	CopyExistandAddNew_PerformTranPage addAddress;
	AddressType_PhoneChange addPhoneinfo;

	PolicyChange_ValidationMszScreen validationMszFun;
	String currentValue = "";
	String newValue = "";

	public void policy_CoverageAgeMaintenance(String testCaseName,
			String eventCode) throws Exception {

		try {
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			this.select_coverageDetails();


			currentValue = policyPerformTrans_locators.policyChange_CurrentVal
					.getText();

			newValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			policyPerformTrans_locators.newValue_txtBox.sendKeys(newValue,
					Keys.TAB);

			extent_Reportlogger("Entered newValue for CoverageAgeMaintenance ",
					" coveragedetails Screen", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (currentValue.equalsIgnoreCase(newValue)) {

				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} else {
				utility.click_On_Button(policyPerformTrans_locators.validateInput_Btn);

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);

			}
		} catch (Exception e) {

			extent_Reportlogger(" execution Failed",
					"policy_CoverageAgeMaintenance ", "Fail");
			excelWrite.writeInCell("Failed in policy_CoverageAgeMaintenance",
					"Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CoverageAgeMaintenance", e.getMessage());
			e.printStackTrace();
			throw e;

		}

	}

	public void policy_CellSexMaintenance(String testCaseName, String eventCode)
			throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,350)", "");

			currentValue = policyPerformTrans_locators.policyChange_CurrentVal
					.getText();
			
			newValue=reader.getMapData(CommonVariable.atOrpostIssues_NewValues,map);
			
			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.newValue_txtBox, reader
							.getMapData(
									CommonVariable.atOrpostIssues_NewValues,
									map));

			extent_Reportlogger("entered CellSex_NewValue & backdatedReason  ",
					"CellSex_performTrans ", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (currentValue.equalsIgnoreCase(newValue)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			}

			else {
				policyPerformTrans_locators.validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				excelWrite.writeInCell(
						" CellSex_performTrans Values entered successfully ",
						"Pass");

				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);

			}

		} catch (Exception e) {

			extent_Reportlogger(" execution Failed",
					"policy_CellSexMaintenance ", "Fail");
			excelWrite.writeInCell("Failed in policy_CellSexMaintenance",
					"Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CellSexMaintenance", e.getMessage());
			e.printStackTrace();
			throw e;

		}
	}

	public void policy_CoverageSexMainteance(String testCaseName,
			String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.coverageAge_NewValue_drpDwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			extent_Reportlogger("entered CoverageSexMainteance New value  ",
					"CoverageSexMainteance performTrans Screen", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} else {
				policyPerformTrans_locators.validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);
			}

		} catch (Exception e) {

			extent_Reportlogger(" execution Failed",
					"policy_CoverageSexMainteance  ", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_CoverageSexMainteance", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CoverageSexMainteance", e.getMessage());

			throw e;

		}
	}

	public void policy_CoverageSmokeClassMaintenance(String testCaseName,
			String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			String CoverageSmoke_NewValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			}

			else {
				policyPerformTrans_locators.validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);

			}

		} catch (Exception e) {

			extent_Reportlogger(" execution Failed",
					"policy_CoverageSmokeClassMaintenance Screen", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_CoverageSmokeClassMaintenance", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CoverageSmokeClassMaintenance", e.getMessage());

			throw e;

		}
	}

	public void poilcy_CoverageRateClassMaintenance(String testCaseName,
			String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} else

			{
				policyPerformTrans_locators.validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);
			}

		} catch (Exception e) {

			extent_Reportlogger(" execution Failed",
					"policy_CoverageRateMaintenance ", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_CoverageRateMaintenance", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CoverageRateMaintenance", e.getMessage());

			throw e;

		}
	}

	public void policy_CoverageUnderwritingClass(String testCaseName,
			String eventCode) throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);

			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz)) {

				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} else {

				policyPerformTrans_locators.validateInput_Btn.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);
			}

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"policy_CoverageUnderwritingClass ", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_CoverageUnderwritingClass", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CoverageUnderwritingClass", e.getMessage());

		}
	}

	public void policy_BackDatedCoverageUnderwriting(String testCaseName,
			String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			String effDate = "";
			String eventDate = "";

			effDate = reader.getMapData(CommonVariable.covrage_effectiveDate,
					map);

			eventDate = reader
					.getMapData(CommonVariable.covrage_eventDate, map);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			policyPerformTrans_locators.addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effDate,Keys.TAB);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			policyPerformTrans_locators.addCovrge_EventDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			} else {
				policyPerformTrans_locators.validateInput_Btn.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);

			}

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"policy_BackDatedCoverageUnderwriting  Screen", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_BackDatedCoverageUnderwriting", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_BackDatedCoverageUnderwriting", e.getMessage());

			throw e;
		}

	}

	public void policy_CoverageSubStandard(String testCaseName, String eventCode)
			throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			}

			else {
				utility.click_On_Button(policyPerformTrans_locators.validateInput_EditCoverage);

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);

			}

		} catch (Exception e) {

			extent_Reportlogger(" execution Failed",
					"policy_CoverageSubStandard ", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_CoverageSubStandard", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CoverageSubStandard", e.getMessage());

			throw e;

		}
	}

	public void policy_CoverageRateMultiple(String testCaseName,
			String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			String new_Val = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			policyPerformTrans_locators.newValue_txtBox.clear();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			policyPerformTrans_locators.newValue_txtBox.sendKeys(new_Val,
					Keys.TAB);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			}

			else {
				policyPerformTrans_locators.validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);

			}

		} catch (Exception e) {

			extent_Reportlogger(" execution Failed",
					"policy_CoverageRateMultiple ", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_CoverageRateMultiple", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"policy_CoverageRateMultiple", e.getMessage());

			throw e;

		}
	}

	public void policy_LevelCOIRateOptionMaintenance(String testCaseName,
			String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz))

			{

				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			} else {

				policyPerformTrans_locators.validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);

			}

		} catch (Exception e) {

			extent_Reportlogger("policy_LevelCOIRate execution Failed",
					"policy_LevelCOIRate  Screen", "Fail");
			excelWrite.writeInCell(

			"Failed in policy_LevelCOIRate", "Fail");

			ErrorLogger.logError(e.getClass().getName(), "policy_LevelCOIRate",
					e.getMessage());

			throw e;

		}
	}

	public void policy_Addcoverage(String testCaseName, String eventCode)
			throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			String faceAmount = "";

			faceAmount = reader.getMapData(CommonVariable.coverage_FaceAmount,
					map);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,150)", "");

			utility.click_On_Link(policyPerformTrans_locators.AddCoverage_linktxt);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.coveragedetails_drpdwn,
					reader.getMapData(CommonVariable.coverageID, map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));

			if (faceAmount != null || !(faceAmount == "")) {
				utility.enter_Text(
						policyPerformTrans_locators.coverage_FaceAmount,
						faceAmount);

			}

			Thread.sleep(4000);
			

			if (utility
					.isWebElementExist(policyPerformTrans_locators.faceAmountValidate))

			{
				String faceValidteVal1 = policyPerformTrans_locators.faceAmountValidate
						.getAttribute("title");

				extent_Reportlogger(":" + faceValidteVal1,
						"faceValidteVal Indicator", "Pass");
				excelWrite.writeInCell("faceValidteVal Indicator:"
						+ faceValidteVal1, "Pass");
				
			} else {
				utility.selectvalueByText_DropdownList(
						policyPerformTrans_locators.coverageIssueState_drpdwn,
						reader.getMapData(CommonVariable.coverage_IssueState,
								map));

				utility.click_On_Button(policyPerformTrans_locators.coverageSave_Btn);

				utility.click_On_Link(policyPerformTrans_locators.coverage_InsuranceDtls_Labl);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");

				utility.select_DropdownList(
						policyPerformTrans_locators.insuredSmokeClass_drpdwn,
						reader.getMapData(CommonVariable.insuredSmokeClass, map));

				utility.selectvalueByText_DropdownList(
						policyPerformTrans_locators.coverageSex_drpdwn,
						reader.getMapData(CommonVariable.coverageSex, map));

				utility.select_DropdownList(
						policyPerformTrans_locators.coverageRateClass_drpdwn,
						reader.getMapData(CommonVariable.coverageRateClass, map));

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

				extent_Reportlogger("Entered Coverage details ",
						"policy_Addcoverage prform trans Screen", "Pass");

				utility.click_On_Button(policyPerformTrans_locators.coverageSave_Btn);

				excelWrite.writeInCell("Entered Coverage details", "Pass");

				String flatExtra_Value = reader.getMapData(
						CommonVariable.Flag_FlatExtra, map);
				if (flatExtra_Value.equalsIgnoreCase("Y")) {

					utility.click_On_Link(policyPerformTrans_locators.coverage_FlatExtra_Labl);

					utility.click_On_Link(policyPerformTrans_locators.flagExtraAddItem_linktxt);

					utility.selectvalueByText_DropdownList(
							policyPerformTrans_locators.flagExtraMode_drpdwn,
							reader.getMapData(CommonVariable.flatExtra_Mode,
									map));

					utility.selectvalueByText_DropdownList(
							policyPerformTrans_locators.flatExtra_Type_drpdwn,
							reader.getMapData(CommonVariable.flatExtra_Type,
									map));

					utility.selectvalueByText_DropdownList(
							policyPerformTrans_locators.flatExtraCountry_drpdwn,
							reader.getMapData(CommonVariable.flatExtra_Country,
									map));

				}

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				policyPerformTrans_locators.ValidateaddCovrage_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				validationMszFun
						.validationMessagecheck(testCaseName, eventCode);
			}

		} catch (Exception e) {

			extent_Reportlogger("policy_Addcoverage execution Failed",
					"policy_Addcoverage Screen", "Fail");
			excelWrite.writeInCell("Failed in policy_Addcoverage", "Fail");

			ErrorLogger.logError(e.getClass().getName(), "policy_Addcoverage",
					e.getMessage());
			e.printStackTrace();
			throw e;

		}
	}

	public void policy_Reduceface(String testCaseName, String eventCode)
			throws Exception {
		try {
			// verify Validate Selection

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			String eventDate = reader.getMapData(
					CommonVariable.covrage_eventDate, map);
			String effdate = reader.getMapData(
					CommonVariable.covrage_effectiveDate, map);

			policyPerformTrans_locators.reduce_EventDate_txtbox.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			policyPerformTrans_locators.addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effdate,
					Keys.TAB);

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.click_On_Button(policyPerformTrans_locators.reduceValidateSel_Btn);

			// handle reduce Face Grid
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			policyPerformTrans_locators.reduceFaceChecklist.click();

			utility.enter_Text(policyPerformTrans_locators.reduce_NewFaceAmt,
					reader.getMapData(CommonVariable.reduce_newFaceAmt, map));

			// String
			// faceval=policyPerformTrans_locators.reducefaceErrMsz.getAttribute("title");

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.reduceiRS_DistCode_drpdwn,
					reader.getMapData(CommonVariable.iRS_Distributioncode, map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			policyPerformTrans_locators.ValidateaddCovrage_Btn.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);

		} catch (Exception e) {
			extent_Reportlogger(" execution Failed", "policy_Reduceface",
					"Fail");
			excelWrite.writeInCell("Failed in policy_Reduceface", "Fail");

			ErrorLogger.logError(e.getClass().getName(), "policy_Reduceface",
					e.getMessage());
			e.printStackTrace();
			throw e;

		}
	}

	public void policy_TerminateCoverage(String testCaseName, String eventCode)
			throws Exception {

		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			policyPerformTrans_locators.checkBox1_EditCoverage.click();
			System.out.println("sdasd");

			policyPerformTrans_locators.expirydate_EditCovergae.clear();

			utility.enter_Text(
					policyPerformTrans_locators.expirydate_EditCovergae,
					(reader.getMapData(CommonVariable.Expire_Date, map)));

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.issueState_DropDown,
					reader.getMapData(CommonVariable.IssueState_Name, map));

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.reason_EditCoverage,
					reader.getMapData(CommonVariable.Reason, map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			extent_Reportlogger("Enetred the values Edit Coverage values ",
					"Edit Coverage  Screen", "Pass");

			policyPerformTrans_locators.validateInput_EditCoverage.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);

		} catch (Exception e) {
			extent_Reportlogger("execution Failed", "policy_TerminateCoverage",
					"Fail");

			excelWrite.writeInCell("policy_TerminateCoverage Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"policy_TerminateCoverage", e.getMessage());
			throw e;

		}

	}

	public void policyChange_empDate(String testCaseName, String eventCode)
			throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");

			utility.click_On_Link(policyPerformTrans_locators.EmpDateChange_Link);

			System.out.println("before frame");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			System.out.println("enterd date>>> after frame");

			String date = reader.getMapData(CommonVariable.new_EmpDate, map);
			System.out.println("date" + date);

			System.out.println(policyPerformTrans_locators.NewEmpDate_tbl
					.getText() + " >>>>>> value from UI date");
			policyPerformTrans_locators.NewEmpDate_tbl.clear();

			utility.enter_Text(
					policyPerformTrans_locators.NewEmpDate_tbl,
					(reader.getMapData(CommonVariable.new_EmpDate, map) + Keys.TAB));

			excelWrite.writeInCell("NewEmpDate_tbl", "Pass");
			extent_Reportlogger("Enetered new employemnt date",
					"Employment date screen", "Pass");

			System.out.println("completed");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			policyPerformTrans_locators.empDateValidatebtn.click();
			System.out.println("clicked!!!");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);

			System.out.println("hheelloo");

		} catch (Exception e) {

			extent_Reportlogger("execution Failed", "policyChange_empDate",
					"Fail");

			excelWrite.writeInCell("policyChange_empDate Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"policyChange_empDate", e.getMessage());
			throw e;

		}
	}

	// genric post issue for phase2
	public void genricPolicy_postIssueCriteria(String testCaseName,
			String eventCode) throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			String new_Val = "";
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,350)", "");

			new_Val = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			utility.enter_Text(policyPerformTrans_locators.newValue_txtBox,
					new_Val);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");

			utility.click_On_Button(policyPerformTrans_locators.validateInput_Btn);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);
		} catch (Exception e) {

			extent_Reportlogger(" Excuetion Failed",
					"genricPolicy_postIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"genricPolicy_postIssueCriteria execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"genricPolicy_postIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

		}

	}

	public void dBOchange_postIssueCriteria(String testCaseName,
			String eventCode) throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			String newDBoptionVal = "";

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			newDBoptionVal = reader.getMapData(
					CommonVariable.newDeathBenOption, map);
			utility.select_DropdownList(
					policyPerformTrans_locators.newDBOption_drpdwn,
					newDBoptionVal);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));

			if (newDBoptionVal.equalsIgnoreCase("D")) {

				policyPerformTrans_locators.dBOStrtYearCode.sendKeys(reader
						.getMapData(CommonVariable.death_BOStrtYearCode, map));

				utility.enter_Text(policyPerformTrans_locators.dBOStrtYearCode,
						reader.getMapData(CommonVariable.death_BOStrtYearCode,
								map));
			}

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");

			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);

		} catch (Exception e) {
			extent_Reportlogger(" Excuetion Failed",
					"dBOchange_postIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"dBOchange_postIssueCriteria execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"dBOchange_postIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

		}

	}

	// By Alok

	public void FaceChanges_postIssueCriteria(String testCaseName,
			String eventCode) throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			/*
			 * prformTransfun = new
			 * PolicyChange_PostIssueperformTransactionFunctions( driver);
			 */

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			String eventDate = reader.getMapData(
					CommonVariable.covrage_eventDate, map);
			String effdate = reader.getMapData(
					CommonVariable.covrage_effectiveDate, map);

			policyPerformTrans_locators.reduce_EventDate_txtbox.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			policyPerformTrans_locators.addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effdate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.click_On_Button(policyPerformTrans_locators.reduceValidateSel_Btn);
			policyPerformTrans_locators.reduceFaceChecklist.click();
			utility.enter_Text(policyPerformTrans_locators.reduce_NewFaceAmt,
					(reader.getMapData(CommonVariable.reduce_newFaceAmt, map)));
			utility.click_On_Button(policyPerformTrans_locators.FaceIncreaseInfo_Btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(policyPerformTrans_locators.Add_LayerImage);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));

			String Rem_LayerAmount = "";
			Rem_LayerAmount = policyPerformTrans_locators.Rem_layer_amount
					.getText();
			String splitVal1 = Rem_LayerAmount.substring(1);
			System.out.println("Rem_LayerAmount" + splitVal1);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			policyPerformTrans_locators.Layer_FaceAmt_TextBox.sendKeys(Keys
					.chord(Keys.CONTROL, "a"));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			policyPerformTrans_locators.Layer_FaceAmt_TextBox.sendKeys(
					Keys.BACK_SPACE, splitVal1);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			utility.click_On_Button(policyPerformTrans_locators.AddLayer_Ok_Btn);
			utility.click_On_Button(policyPerformTrans_locators.FaceIncreaseClose_Btn);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			validationMszFun.validationMessagecheck(testCaseName, eventCode);

		} catch (Exception e) {
			extent_Reportlogger(" Excuetion Failed",
					"FaceChanges_postIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"FaceChanges_postIssueCriteria execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"FaceChanges_postIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

		}

	}

	// Alok FaceChangesConversion

	public void FaceChangesConversion_postIssueCriteria(String testCaseName,
			String eventCode) throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			/*
			 * prformTransfun = new
			 * PolicyChange_PostIssueperformTransactionFunctions( driver);
			 */

			System.out.println("Inside Method");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			System.out.println("Inside Frame");

			String eventDate = reader.getMapData(
					CommonVariable.covrage_eventDate, map);
			String effdate = reader.getMapData(
					CommonVariable.covrage_effectiveDate, map);

			policyPerformTrans_locators.reduce_EventDate_txtbox.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			policyPerformTrans_locators.addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effdate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.click_On_Button(policyPerformTrans_locators.reduceValidateSel_Btn);
			policyPerformTrans_locators.reduceFaceChecklist.click();
			utility.enter_Text(policyPerformTrans_locators.reduce_NewFaceAmt,
					(reader.getMapData(CommonVariable.reduce_newFaceAmt, map)));

			policyPerformTrans_locators.Conversion_ChkBox.click();

			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			validationMszFun.validationMessagecheck(testCaseName, eventCode);

		} catch (Exception e) {
			extent_Reportlogger(" Excuetion Failed",
					"FaceChangesConversion_postIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"FaceChangesConversion_postIssueCriteria execution Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"FaceChangesConversion_postIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

		}

	}

	public void select_coverageDetails() throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			String CoverageDetails_Value = reader.getMapData(
					CommonVariable.coverageAge_CoverageDetails, map);

			if (!(CoverageDetails_Value.equalsIgnoreCase("All - All Coverages"))) {

				utility.selectvalueByText_DropdownList(
						policyPerformTrans_locators.coveragedetails_drpdwn,
						reader.getMapData(
								CommonVariable.coverageAge_CoverageDetails, map));

				Thread.sleep(1000);
				utility.selectvalueByText_DropdownList(
						policyPerformTrans_locators.coverageLayerSel_drpdwn,
						reader.getMapData(
								CommonVariable.coverageAge_LayerSelec, map));

			}

			else {
				utility.selectvalueByText_DropdownList(
						policyPerformTrans_locators.coveragedetails_drpdwn,
						reader.getMapData(
								CommonVariable.coverageAge_CoverageDetails, map));

			}

			utility.click_On_Button(policyPerformTrans_locators.addSelectedCoverage_Btn);

		} catch (Exception e) {

			extent_Reportlogger(" execution Failed", "select_coverageDetails ",
					"Fail");
			excelWrite.writeInCell(

			"select_coverageDetails execution Failed", "Fail");
			throw e;

		}

	}

	
	public void C227_annuitantCorrection(String testCaseName,String eventCode ) throws Exception
	{
		try
		{
			
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			PolicyChange_PostIssueperformTransactionFunctions prformTransfun;
			
			prformTransfun = new PolicyChange_PostIssueperformTransactionFunctions(
					driver);
		
			 addAddress =new CopyExistandAddNew_PerformTranPage(driver);
			 addPhoneinfo = new AddressType_PhoneChange(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			policyPerformTrans_locators.atIssue_rdBtn.click();
			

			utility.select_DropdownList(policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));
			
			
			utility.click_On_Button(policyPerformTrans_locators.Locate_Btn);
			
			utility.click_On_Button(policyPerformTrans_locators.AddIndividual_Btn);
			
			
			//Personal Info			
			utility.enter_Text(policyPerformTrans_locators.enter_FirstName,reader.getMapData(CommonVariable.enter_FirstName,map));
			utility.enter_Text(policyPerformTrans_locators.enter_LastName, reader.getMapData(CommonVariable.enter_LastName,map));
			utility.enter_Text(policyPerformTrans_locators.enter_SSNNumber, reader.getMapData(CommonVariable.enter_SSNNumber,map));
			utility.enter_Text(policyPerformTrans_locators.enter_Birthdate, reader.getMapData(CommonVariable.enter_Birthdate,map));
				
			
			//Address Information	
			policyPerformTrans_locators.AddInfo_Expand.click();	
			policyPerformTrans_locators.AddNew_radioBtn.click();
			
			jse.executeScript("window.scrollBy(0,200)", "");
			addAddress.upadteAddress();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			//Add Phone			
			policyPerformTrans_locators.PhoneInfo_Expand.click();
			addPhoneinfo.enter_Phone_Information();	
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			//Add Email			
			policyPerformTrans_locators.EmailInfo_Expand.click();
			utility.enter_Text(policyPerformTrans_locators.enter_New_Email,reader.getMapData(CommonVariable.enter_New_Email,map));
			utility.enter_Text(policyPerformTrans_locators.enter_Confirm_Email,reader.getMapData(CommonVariable.enter_Confirm_Email,map));
			
			utility.click_On_Button(policyPerformTrans_locators.Submit_Annuitant_btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			
			extent_Reportlogger(":" + testCaseName,
					" Success Messages Displayed successfully ", "Pass");
			
			utility.click_On_Button(policyPerformTrans_locators.FaceIncreaseClose_Btn);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);
			
			
	/*		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			policyPerformTrans_locators.reduceFaceChecklist.click();
			
			utility.enter_Text(policyPerformTrans_locators.reduce_NewFaceAmt,
					reader.getMapData(CommonVariable.reduce_newFaceAmt, map));
			
			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));*/

			validationMszFun.validationMessagecheck(testCaseName, eventCode);
			
			
		}catch(Exception e)
		{
			extent_Reportlogger(" Excuetion Failed",
					"C227_AnnuitantCorrection", "Fail");
			excelWrite.writeInCell(
					"C227_AnnuitantCorrection execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"C227_AnnuitantCorrection", e.getMessage());

			e.printStackTrace();
			throw e;

			
		}
	}
	
	
	
	
	
	
	
}
