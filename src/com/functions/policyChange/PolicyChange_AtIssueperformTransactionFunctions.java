package com.functions.policyChange;

import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.AddressChangeScreens.AddressType_PhoneChange;
import com.pages.AddressChangeScreens.CopyExistandAddNew_PerformTranPage;
import com.pages.AddressChangeScreens.VPAS_PopUpPage;
import com.pages.PolicyChangeScreens.PolicyChange_IGOVerfication;
import com.pages.PolicyChangeScreens.PolicyChange_PDCVpasScreen;
import com.pages.PolicyChangeScreens.PolicyChange_PerformTransactionScreen;
import com.pages.PolicyChangeScreens.PolicyChange_ValidationMszScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;
import com.utility.WriteExcelFile;

public class PolicyChange_AtIssueperformTransactionFunctions extends
		Test_BaseClass {

	public PolicyChange_AtIssueperformTransactionFunctions(WebDriver driver) {
		this.driver = driver;
	}

	String currentValue = "";
	String newValue = "";
	BaseUtils utility = new BaseUtils(driver);

	PolicyChange_PerformTransactionScreen policyPerformTrans_locators;

	PolicyChange_ValidationMszScreen validationMszFun;

	PolicyChange_PostIssueperformTransactionFunctions prformTransfun;
	PolicyChange_PostIssueperformTransactionFunctions postIssueFun;
	VPAS_PopUpPage verfyMsz;
	CopyExistandAddNew_PerformTranPage addAddress;
	AddressType_PhoneChange addPhoneinfo;

	public void dOIChange_SelectionCriteria(String testCaseName,String eventCode) throws Exception {
		try {
			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.doiChangeNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			policyPerformTrans_locators.validateInput_Btn.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);

		}

		catch (Exception e) {

			extent_Reportlogger(" Execution Failed",
					"dOIChange_SelectionCriteria ", "Fail");
			excelWrite.writeInCell("Failed in dOIChange_SelectionCriteria",
					"Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"dOIChange_SelectionCriteria", e.getMessage());

			throw e;

		}

	}

	public void cellAgeMaintance_SelectionCriteria(String testCaseName,String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			String cellAge_CurrentValue = "";
			String cellAge_NewValue = "";

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			policyPerformTrans_locators.atIssue_rdBtn.click();

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			utility.enter_Text(policyPerformTrans_locators.newValue_txtBox,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues, map));

			extent_Reportlogger("Values entered successfully ",
					"PolicyChange_CellAgeMaintance SelectionCriteria ", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			policyPerformTrans_locators.validateInput_Btn.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck( testCaseName, eventCode);

		} catch (Exception e) {
			extent_Reportlogger("Excuetion Failed",
					"cellAgeMaintance_SelectionCriteria", "Fail");
			excelWrite
					.writeInCell(
							"PolicyChange_CellAgeMaintance  SelectionCriteria execution Failed",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"PolicyChange_CellAgeMaintance", e.getMessage());

			e.printStackTrace();
			throw e;

		}
	}

	public void policy_DateChange(String testCaseName,String eventCode) throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			// pDCVpasScreenlocators = new PolicyChange_PDCVpasScreen();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			policyPerformTrans_locators.policychange_AddNewDate_Btn.click();

			extent_Reportlogger("Clicked Succesfully", " Add new Dates ",
					"Pass");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			policyPerformTrans_locators.policyYearDate_txtBox.sendKeys(
					reader.getMapData(CommonVariable.policy_YearDate, map),
					Keys.TAB);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			policyPerformTrans_locators.policyIssueDate_txtBox.sendKeys(
					reader.getMapData(CommonVariable.policy_issuedate, map),
					Keys.TAB);

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			excelWrite
					.writeInCell(
							"Successfully entered the policy_YearDate & policy_issuedate ",
							"Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			policyPerformTrans_locators.policyDateValidate_Btn.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck( testCaseName, eventCode);

			extent_Reportlogger("Successfully updated to  PDCVpas ",
					"  PDCVpas screen", "Pass");

			// pDCVpasScreenlocators.PDCVpasSubmit_Btn.click();

			excelWrite
					.writeInCell(
							"CSR is able to process Policy date change-I120 successfully from CSWD. ",
							"Pass");

		} catch (Exception e) {
			extent_Reportlogger(" Excuetion Failed", "policy_DateChange",
					"Fail");
			excelWrite.writeInCell("policy_DateChangea execution Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(), "policy_DateChange",
					e.getMessage());

			e.printStackTrace();
			throw e;

		}
	}

	// Phase2 Test Cases

	public void coverageAgeMaint_atIssueCriteria(String testCaseName,String eventCode) throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			prformTransfun = new PolicyChange_PostIssueperformTransactionFunctions(
					driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			policyPerformTrans_locators.atIssue_rdBtn.click();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			prformTransfun.select_coverageDetails();

			currentValue = policyPerformTrans_locators.policyChange_CurrentVal
					.getText();

			newValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);
			
			utility.enter_Text(policyPerformTrans_locators.newValue_txtBox,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			extent_Reportlogger("Values entered successfully ",
					"coverageAgeMaint_atIssueCriteria ", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (currentValue.equalsIgnoreCase(newValue)) {

				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} 
			else
			{

			policyPerformTrans_locators.validateInput_Btn.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName,
					eventCode);
			}
		} catch (Exception e) {
			extent_Reportlogger(" Excuetion Failed",
					"coverageAgeMaint_atIssueCriteria", "Fail");
			excelWrite
					.writeInCell(
							"coverageAgeMaint_atIssueCriteria execution Failed",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"coverageAgeMaint_atIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

		}

	}

	// Phase2 Generic method

	public void genricPolicy_atIssueCriteria(String testCaseName,
			String eventCode) throws Exception {
		try {

			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			prformTransfun = new PolicyChange_PostIssueperformTransactionFunctions(
					driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			policyPerformTrans_locators.atIssue_rdBtn.click();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			if ((testCaseName.equalsIgnoreCase("I212_CellSex"))) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				
				currentValue = policyPerformTrans_locators.currentValue_txtBox
						.getAttribute("value");
				System.out.println("currentValue"+currentValue);

				newValue = reader.getMapData(
						CommonVariable.atOrpostIssues_NewValues, map);

			}
			
			else
			{
			prformTransfun.select_coverageDetails();
			
			}
			
			newValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);
			
			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.postIssueNewValue_drpdwn,
					newValue);

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (utility
					.isWebElementExist(policyPerformTrans_locators.currentandNewvalueerrorMsz) || currentValue.equalsIgnoreCase(newValue)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} 
			else
			{
			policyPerformTrans_locators.validateInput_Btn.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);
			}


		} catch (Exception e) {

			extent_Reportlogger(" Excuetion Failed",
					"genricPolicy_atIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"genricPolicy_atIssueCriteria execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"genricPolicy_atIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

		}
	}

	
	public void dBOchange_atIssueCriteria(String testCaseName, String eventCode)
			throws Exception {
		try {
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			prformTransfun = new PolicyChange_PostIssueperformTransactionFunctions(
					driver);
			String newDBoptionVal = "";

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			policyPerformTrans_locators.atIssue_rdBtn.click();

			utility.selectvalueByText_DropdownList(
					policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			// C:C---Specified Face + Return of Premium</option>
			// D:D---TSI & Optional Extra Death Benefit</option>
			// V:V---Variable Annuity</option>

			newDBoptionVal = reader.getMapData(
					CommonVariable.newDeathBenOption, map);
			utility.select_DropdownList(policyPerformTrans_locators.newDBOption_drpdwn, newDBoptionVal);
			if (newDBoptionVal.equalsIgnoreCase("D")) {
				
				policyPerformTrans_locators.dBOStrtYearCode.sendKeys(reader.getMapData(CommonVariable.death_BOStrtYearCode,
						map));
				/*utility.enter_Text(policyPerformTrans_locators.dBOStrtYearCode,
						reader.getMapData(CommonVariable.death_BOStrtYearCode,
								map));*/
			}

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");

			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);

		} catch (Exception e) {
			extent_Reportlogger(" Excuetion Failed",
					"dBOchange_atIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"dBOchange_atIssueCriteria execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"dBOchange_atIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

		}
	}

	
	
	public void facechange_atIssueCriteria(String testCaseName,String eventCode ) throws Exception
	{
		try
		{
			
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			prformTransfun = new PolicyChange_PostIssueperformTransactionFunctions(
					driver);
		

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			policyPerformTrans_locators.atIssue_rdBtn.click();
			

			utility.select_DropdownList(policyPerformTrans_locators.backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));
			
			
			utility.click_On_Button(policyPerformTrans_locators.reduceValidateSel_Btn);
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			policyPerformTrans_locators.reduceFaceChecklist.click();
			
			utility.enter_Text(policyPerformTrans_locators.reduce_NewFaceAmt,
					reader.getMapData(CommonVariable.reduce_newFaceAmt, map));
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			
			if(utility.isWebElementExist(policyPerformTrans_locators.reducefaceErrMsz))
			
			{
				String faceerromszVal=policyPerformTrans_locators.reducefaceErrMsz.getAttribute("title");
				
				
				extent_Reportlogger(":" + faceerromszVal,
						"reduce face Error Message  ", "Pass");
				
			}
			else
			{
			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);
			}
			
			
		}catch(Exception e)
		{
			extent_Reportlogger(" Excuetion Failed",
					"facechange_atIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"facechange_atIssueCriteria execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"facechange_atIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

			
		}
	}
	
	//At Issue By Alok
	
	public void I227_AnnuitantCorrection(String testCaseName,String eventCode ) throws Exception
	{
		try
		{
			
			policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
					driver);
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
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
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			
			//Add Email	
			
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(policyPerformTrans_locators.EmailInfo_Expand).click().build().perform();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//policyPerformTrans_locators.EmailInfo_Expand.click();
			utility.enter_Text(policyPerformTrans_locators.enter_New_Email,reader.getMapData(CommonVariable.enter_New_Email,map));
			utility.enter_Text(policyPerformTrans_locators.enter_Confirm_Email,reader.getMapData(CommonVariable.enter_Confirm_Email,map));
			
			
			utility.click_On_Button(policyPerformTrans_locators.Submit_Annuitant_btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			extent_Reportlogger(":" + testCaseName," Success Messages Displayed successfully ", "Pass");
			
			Actions actions = new Actions(driver);
			actions.moveToElement(policyPerformTrans_locators.FaceIncreaseClose_Btn).click().build().perform();
			utility.click_On_Button(policyPerformTrans_locators.FaceIncreaseClose_Btn);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(policyPerformTrans_locators.ValidateaddCovrage_Btn);			
			validationMszFun.validationMessagecheck(testCaseName, eventCode);
			
			
		}catch(Exception e)
		{
			extent_Reportlogger(" Excuetion Failed",
					"AnnuitantCorrectionI227_atIssueCriteria", "Fail");
			excelWrite.writeInCell(
					"AnnuitantCorrectionI227_atIssueCriteria execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"AnnuitantCorrectionI227_atIssueCriteria", e.getMessage());

			e.printStackTrace();
			throw e;

			
		}
	}
	
	

	
	public void addCoverage_AtIssue(String testCaseName,String eventCode) throws Exception
	{
		try
		{
		policyPerformTrans_locators = new PolicyChange_PerformTransactionScreen(
				driver);
		validationMszFun = new PolicyChange_ValidationMszScreen(driver);
		prformTransfun = new PolicyChange_PostIssueperformTransactionFunctions(
				driver);
		postIssueFun= new PolicyChange_PostIssueperformTransactionFunctions(driver);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");

		policyPerformTrans_locators.atIssue_rdBtn.click();
		
		//Customized value enter in backdated Drop down
		String addCov_backDatedRson= reader.getMapData(CommonVariable.backdated_Reason, map);
				String splitVal1= addCov_backDatedRson.substring(0,3);
		String splitVal2=addCov_backDatedRson.substring(3);
				StringJoiner joiner = new StringJoiner(",");
		joiner.add(splitVal1).add(splitVal2);
		String addCovrge_joinedString = joiner.toString(); // "01,02,03"
				
		
		utility.select_DropdownList(policyPerformTrans_locators.backdatedReason_drpdwn,
				addCovrge_joinedString);
		
		postIssueFun.policy_Addcoverage(testCaseName,eventCode);
		}
		catch(Exception e)
		{
			extent_Reportlogger(" Excuetion Failed",
					"addCoverage_AtIssue", "Fail");
			excelWrite.writeInCell(
					"addCoverage_AtIssue execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"addCoverage_AtIssue", e.getMessage());

			e.printStackTrace();
			throw e;
		}
		
		
	}
	

}
