package com.pages.PolicyChangeScreens;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;




import com.pages.AddressChangeScreens.AddressType_PhoneChange;
import com.pages.AddressChangeScreens.CopyExistandAddNew_PerformTranPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class PolicyChange_PerformTransactionScreen extends Initialize_Browser {

	public PolicyChange_PerformTransactionScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ".//*[@id='AtPstIssueSelAtIssue']")
	public WebElement atIssue_rdBtn;

	@FindBy(xpath = ".//*[@id='NewValue']")
	public WebElement newValue_txtBox;

	@FindBy(id = "CurrentValueDesc")
	public WebElement currentValue_txtBox;

	@FindBy(xpath = "//table[@pl_prop='.PolicyMaintList']//tr[2]//td[4]")
	public WebElement policyChange_CurrentVal;

	@FindBy(xpath = "//select[@id='BackdatedRsn']")
	public WebElement backdatedReason_drpdwn;

	@FindBy(xpath = "//select[@id='NewValue']")
	public WebElement doiChangeNewValue_drpdwn;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate Input')]")
	// @FindBy(xpath="//button[@type='button']//div[text()='Validate Input']")
	public WebElement validateInput_Btn;

	@FindBy(xpath = "//div[text()='Validate']")
	// @FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement ValidateaddCovrage_Btn;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
	public WebElement validateInput_Submit_Btn;

	@FindBy(xpath = ".//*[@id='PegaRULESErrorFlag']")
	
	
	// @FindBy(xpath
	// ="//div[@id='$PpyWorkPage$pCellDetails$pNewValueError']//span[@id='PegaRULESErrorFlag']")
	public WebElement currentandNewvalueerrorMsz;

	// Policy date Change Locators

	@FindBy(xpath = ".//*[@id='Event Date']")
	public WebElement addCovrge_EventDate;

	@FindBy(xpath = ".//*[@id='EffDate']")
	public WebElement addCovrge_EffDate;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add NewDates')]")
	public WebElement policychange_AddNewDate_Btn;

	@FindBy(xpath = ".//*[@id='PolYrDate']")
	public WebElement policyYearDate_txtBox;

	@FindBy(xpath = ".//*[@id='PolIssDate']")
	public WebElement policyIssueDate_txtBox;

	@FindBy(xpath = ".//*[@id='FreeLookExp']")
	public WebElement policyFreeLookDate_txtbox;

	@FindBy(xpath = ".//*[@id='InitAllocDate']")
	public WebElement policyInitAllocDate_txtBox;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement policyDateValidate_Btn;

	// policy Coverage age maintaince locators
	// Selected value from dropdown

	@FindBy(xpath = "//select[@id='NewValue']")
	// option[@selected='']")
	public WebElement postIssue_SelectedNewValue_drpdwn;

	@FindBy(xpath = "//select[@id='NewValue']")
	public WebElement postIssueNewValue_drpdwn;

	@FindBy(xpath = "//table[@id='bodyTbl_right']//tbody//tr[2]//td[4]")
	public WebElement postIssueCurrentValue;

	@FindBy(xpath = "//table[@id='bodyTbl_right']//tbody//tr[2]//td[5]//select[@id='NewValue']")
	public WebElement coverageAge_NewValue_drpDwn;

	@FindBy(xpath = "//select[@id='CoverageID']")
	public WebElement coveragedetails_drpdwn;

	@FindBy(xpath = "//select[@id='LayerID']")
	public WebElement coverageLayerSel_drpdwn;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Selected Coverage')]")
	public WebElement addSelectedCoverage_Btn;

	@FindBy(xpath = ".//*[@id='$PpyWorkPage$pPolicyMaintList$l1']/td[6]/div/span/i/img")
	public WebElement coverageAge_DeleteBtn;

	// Addcoverage Link
	@FindBy(linkText = "Add Coverage")
	public WebElement AddCoverage_linktxt;

	@FindBy(xpath = "//select[@id='IssueState']")
	public WebElement coverageIssueState_drpdwn;

	@FindBy(xpath = ".//*[@id='FaceAmount']")
	public WebElement coverage_FaceAmount;

	@FindBy(xpath = ".//*[@id='RowDetailsButtonSubmit']")
	public WebElement coverageSave_Btn;

	@FindBy(xpath = "//label[text()='Insured Details']")
	public WebElement coverage_InsuranceDtls_Labl;

	@FindBy(xpath = "//label[text()='Flat Extra']")
	public WebElement coverage_FlatExtra_Labl;

	@FindBy(xpath = ".//*[@id='PrimaryInsured']")
	public WebElement primaryInsured_txt;

	@FindBy(xpath = "//select[@id='SmokeClass']")
	public WebElement insuredSmokeClass_drpdwn;

	@FindBy(xpath = "//select[@id='SubstandardRate']")
	public WebElement substandardRate_drpdwn;

	@FindBy(xpath = "//select[@id='UWType']")
	public WebElement coverageUWType_drpdwn;

	@FindBy(xpath = "//select[@id='CoverageSex']")
	public WebElement coverageSex_drpdwn;

	// @FindBy(xpath =
	// "//select[@name='$PpyWorkPage$pCoveragesInfo$l1$pRateClass']")

	@FindBy(id = "RateClass")
	public WebElement coverageRateClass_drpdwn;

	@FindBy(xpath = "//select[@id='RateOptionID']")
	public WebElement coverageRateOptionID_drpdwn;

	@FindBy(linkText = "Add Item")
	public WebElement flagExtraAddItem_linktxt;

	@FindBy(linkText = "Delete")
	public WebElement flagExtraDelete_linktxt;

	@FindBy(xpath = "//select[@id='Mode1']")
	public WebElement flagExtraMode_drpdwn;

	@FindBy(xpath = "//select[@id='FlatExtraType1']")
	public WebElement flatExtra_Type_drpdwn;

	@FindBy(xpath = "//select[@id='Country1']")
	public WebElement flatExtraCountry_drpdwn;

	// Reduce Face Locators

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate Selection')]")
	public WebElement reduceValidateSel_Btn;

	@FindBy(xpath = ".//*[@id='EvntDate']")
	public WebElement reduce_EventDate_txtbox;

	@FindBy(xpath = "//table[@pl_prop='.MCGetEventValSummary']//tbody//tr[2]//td[3]")
	public WebElement monthAnnvDate_tbl;

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-Data-FaceChange']//tbody")
	public WebElement reduceFaceGrid_table;

	@FindBy(xpath = "//input[@id='pySelected1'][@type='checkbox']")
	public WebElement reduceFaceChecklist;

	@FindBy(xpath = ".//*[@id='NewFaceAmt']")
	public WebElement reduce_NewFaceAmt;

	@FindBy(xpath = "//select[@id='IRSDistCode1']")
	public WebElement reduceiRS_DistCode_drpdwn;

	// Employment Date Change Locators - Starts

	@FindBy(linkText = "Employment Date Change")
	public WebElement EmpDateChange_Link;

	@FindBy(id = "Employment Date - New Value")
	public WebElement NewEmpDate_tbl;

	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement empDateValidatebtn;

	// Employment Data Change Locators - Ends

	// Policy Change , policy termination locators starts

	@FindBy(xpath = "//table[@pl_prop='.AllCoverages']//tr[2]//td[1]")
	// @FindBy(xpath=" //table[@pl_prop='.PolicyDetailsList']//tr[2]//td[1]//div")
	public WebElement checkBox1_EditCoverage;

	@FindBy(xpath = ".//*[@id='RowSelected2']")
	public WebElement checkBox2_EditCoverage;

	@FindBy(xpath = ".//*[@id='Expire Date']")
	public WebElement expirydate_EditCovergae;

	@FindBy(xpath = ".//*[@id='IssueState1']")
	public WebElement issueState_DropDown;

	@FindBy(xpath = ".//*[@id='CarrValue1']")
	public WebElement carrierValue_EditCoverage;

	@FindBy(xpath = ".//*[@id='CovStatus1']")
	public WebElement reason_EditCoverage;

	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Validate Input')]")
	public WebElement validateInput_EditCoverage;

	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Submit')]")
	public WebElement submit_EditCovergae;

	// Coverage Sub standard

	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Validate Input')]")
	public WebElement validateInput_CoverageSubStand;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pCoveragesInfo$l1$pFaceAmountError']//span")
	public WebElement faceAmountValidate;

	@FindBy(xpath = ".//*[@id='PegaRULESErrorFlag']")
	public WebElement reducefaceErrMsz;

	// Policy Chnage Phase 2 Locators

	@FindBy(xpath = "//select[@id='NewDBOption']")
	public WebElement newDBOption_drpdwn;

	@FindBy(id = "DBOStrtYearCode")
	public WebElement dBOStrtYearCode;

	// Coverage Face Change Increase
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Face Increase Info')]")
	public WebElement FaceIncreaseInfo_Btn;

	@FindBy(xpath = "//img[@src='webwb/pxadd_new_13085064758.gif!!.gif']")
	public WebElement Add_LayerImage;

	@FindBy(xpath = "//p[@name='$PpyWorkPage$pMCFaceChgParam$pCoverageParamInfo$l1$pRemLayerAmt'][@class='leftJustifyStyle']")
	public WebElement Rem_layer_amount;

	@FindBy(xpath = "//input[@id='LayerFA']")
	public WebElement Layer_FaceAmt_TextBox;

	@FindBy(xpath = "//button[@id='RowDetailsButtonSubmit']")
	public WebElement AddLayer_Ok_Btn;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement FaceIncreaseClose_Btn;

	// Face Change Conversion

	@FindBy(xpath = "//input[@id='Conversion1']")
	public WebElement Conversion_ChkBox;

	// AnnuitantCorrection

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Locate')]")
	public WebElement Locate_Btn;

	@FindBy(id = "SearchLastName")
	public WebElement searchLastName_txtBox;

	// @FindBy(xpath =
	// "//button[@name='MCAlphaMaintSearchRec_pyWorkPage_25']//div[text()='Search Individual Records']")
	@FindBy(xpath = "//div[text()='Search Individual Records']")
	public WebElement searchIndRcrds_Btn;

	@FindBy(xpath = "//div[text()='Select Record']")
	public WebElement selectRcrds_Btn;

	@FindBy(xpath = "//table[@pl_prop='FindPolicyRecords.pxResults']")
	public WebElement searchtble;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Individual')]")
	public WebElement AddIndividual_Btn;

	@FindBy(xpath = "//button[@class='buttonTdButton']")
	public WebElement Submit_Annuitant_btn;

	@FindBy(xpath = "//input[@id='FirstName']")
	public WebElement enter_FirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement enter_LastName;

	@FindBy(xpath = "//input[@id='EmailAddress']")
	public WebElement enter_New_Email;

	@FindBy(xpath = "//input[@id='pyNote']")
	public WebElement enter_Confirm_Email;

	@FindBy(xpath = "//span[@class='accord_titleBarLabelStyle'][contains(.,'Address Information')]")
	public WebElement AddInfo_Expand;

	@FindBy(xpath = "//span[@class='accord_titleBarLabelStyle'][contains(.,'Phone Information')]")
	public WebElement PhoneInfo_Expand;

	@FindBy(xpath = "//span[@class='accord_titleBarLabelStyle'][contains(.,'Email Information')]")
	public WebElement EmailInfo_Expand;

	@FindBy(xpath = "//input[@id='AddressUpdateTypeAddNew']")
	public WebElement AddNew_radioBtn;

	@FindBy(name = "$PTempAddSelection$pSelectAddChgType")
	public WebElement select_ChangeAddressType_drpdwn;

	@FindBy(xpath = "//input[@id='SSN']")
	public WebElement enter_SSNNumber;

	@FindBy(xpath = "//input[@id='Birth Date']")
	public WebElement enter_Birthdate;

	@FindBy(xpath = ".//*[@id='AtPstIssueSelPostIssue']")
	public WebElement postIssue_rdBtn;
	
	
	
	
	//PostIssue or atIssue Function
	
		
	String currentValue = "";
	String newValue = "";
	BaseUtils utility = new BaseUtils(driver);

	
	PolicyChange_ValidationMszScreen validationMszFun;
		
	CopyExistandAddNew_PerformTranPage addAddress;
	AddressType_PhoneChange addPhoneinfo;
	
	//PostIssue policy change functions>>>>>>>>>>>>>>>>>>
	
	public void policy_CoverageAgeMaintenance(String testCaseName,
			String eventCode) throws Exception {

		try {
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			
			this.select_coverageDetails();


			currentValue = policyChange_CurrentVal
					.getText();

			newValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			newValue_txtBox.sendKeys(newValue,
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
				utility.click_On_Button(validateInput_Btn);

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,350)", "");

						
			newValue=reader.getMapData(CommonVariable.atOrpostIssues_NewValues,map);
			
			utility.selectvalueByText_DropdownList(
					newValue_txtBox, reader
							.getMapData(
									CommonVariable.atOrpostIssues_NewValues,
									map));

			extent_Reportlogger("entered CellSex_NewValue & backdatedReason  ",
					"CellSex_performTrans ", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			currentValue = currentValue_txtBox.getText();
					
			
			if (currentValue.equalsIgnoreCase(newValue)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			}

			else {
				validateInput_Btn.click();

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					coverageAge_NewValue_drpDwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			extent_Reportlogger("entered CoverageSexMainteance New value  ",
					"CoverageSexMainteance performTrans Screen", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			//WebElement a=driver.findElement(By.cssSelector("span#PegaRULESErrorFlag"));
			
			//boolean a= currentandNewvalueerrorMsz.isDisplayed();
				
			if (this
					.isWebElementExist(currentandNewvalueerrorMsz))
			{
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} else {
				
				validateInput_Btn.click();

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			String CoverageSmoke_NewValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			utility.selectvalueByText_DropdownList(
					postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			extent_Reportlogger(":  "+testCaseName,
					"Entered Values Succesfully", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			}

			else {
				validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

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

		
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			extent_Reportlogger(":  "+testCaseName,
					"Entered Values Succesfully", "Pass");

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} else

			{
				validateInput_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

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
			

			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			extent_Reportlogger(":  "+testCaseName,
					"Entered Values Succesfully", "Pass");

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz)) {

				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} else {

				validateInput_Btn.click();
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

			addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effDate,Keys.TAB);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			addCovrge_EventDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);

			utility.selectvalueByText_DropdownList(
					backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));
			
			extent_Reportlogger(": "+testCaseName,
					"Entered Values Succesfully", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			} else {
				validateInput_Btn.click();
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
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			utility.selectvalueByText_DropdownList(
					postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger(":  "+testCaseName,
					"Entered Values Succesfully", "Pass");

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			}

			else {
				utility.click_On_Button(validateInput_EditCoverage);

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			String new_Val = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			newValue_txtBox.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, new_Val,
					Keys.TAB);
		

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger(": "+testCaseName,
					"Entered Values Succesfully", "Pass");

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			}

			else {
				validateInput_Btn.click();

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			this.select_coverageDetails();

			utility.selectvalueByText_DropdownList(
					postIssueNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger(": "+testCaseName,
					"Entered Values Succesfully", "Pass");

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz))

			{

				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");

			} else {

				validateInput_Btn.click();

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			String faceAmount = "";

			faceAmount = reader.getMapData(CommonVariable.coverage_FaceAmount,
					map);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,150)", "");

			utility.click_On_Link(AddCoverage_linktxt);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			utility.selectvalueByText_DropdownList(
					coveragedetails_drpdwn,
					reader.getMapData(CommonVariable.coverageID, map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));

			if (faceAmount != null || !(faceAmount == "")) {
				utility.enter_Text(
						coverage_FaceAmount,
						faceAmount);

			}

			Thread.sleep(4000);
			

			if (this
					.isWebElementExist(faceAmountValidate))

			{
				String faceValidteVal1 = faceAmountValidate
						.getAttribute("title");

				extent_Reportlogger(":" + faceValidteVal1,
						"faceValidteVal Indicator", "Pass");
				excelWrite.writeInCell("faceValidteVal Indicator:"
						+ faceValidteVal1, "Pass");
				
			} else {
				
				utility.selectvalueByText_DropdownList(
						coverageIssueState_drpdwn,
						reader.getMapData(CommonVariable.coverage_IssueState,
								map));

				utility.click_On_Button(coverageSave_Btn);

				utility.click_On_Link(coverage_InsuranceDtls_Labl);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");

				utility.select_DropdownList(
						insuredSmokeClass_drpdwn,
						reader.getMapData(CommonVariable.insuredSmokeClass, map));

				utility.selectvalueByText_DropdownList(
						coverageSex_drpdwn,
						reader.getMapData(CommonVariable.coverageSex, map));

				utility.select_DropdownList(
						coverageRateClass_drpdwn,
						reader.getMapData(CommonVariable.coverageRateClass, map));

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

				extent_Reportlogger("Entered Coverage details ",
						"policy_Addcoverage prform trans Screen", "Pass");

				utility.click_On_Button(coverageSave_Btn);

				excelWrite.writeInCell("Entered Coverage details", "Pass");

				String flatExtra_Value = reader.getMapData(
						CommonVariable.Flag_FlatExtra, map);
				if (flatExtra_Value.equalsIgnoreCase("Y")) {

					utility.click_On_Link(coverage_FlatExtra_Labl);

					utility.click_On_Link(flagExtraAddItem_linktxt);

					utility.selectvalueByText_DropdownList(
							flagExtraMode_drpdwn,
							reader.getMapData(CommonVariable.flatExtra_Mode,
									map));

					utility.selectvalueByText_DropdownList(
							flatExtra_Type_drpdwn,
							reader.getMapData(CommonVariable.flatExtra_Type,
									map));

					utility.selectvalueByText_DropdownList(
							flatExtraCountry_drpdwn,
							reader.getMapData(CommonVariable.flatExtra_Country,
									map));

				}

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				ValidateaddCovrage_Btn.click();

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			String eventDate = reader.getMapData(
					CommonVariable.covrage_eventDate, map);
			String effdate = reader.getMapData(
					CommonVariable.covrage_effectiveDate, map);

			reduce_EventDate_txtbox.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effdate,
					Keys.TAB);

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.click_On_Button(reduceValidateSel_Btn);

			// handle reduce Face Grid
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			reduceFaceChecklist.click();

			utility.enter_Text(reduce_NewFaceAmt,
					reader.getMapData(CommonVariable.reduce_newFaceAmt, map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			if(this.isWebElementExist(reducefaceErrMsz))
			{
				

				String faceerromszVal=reducefaceErrMsz.getAttribute("title");
				
				
				extent_Reportlogger(":" + faceerromszVal,
						"reduce face Error Message  ", "Fail");
				
				excelWrite.writeInCell(
						"reduce face Error Message :"+ faceerromszVal, "Fail");
				
			}
			else
			{
				
			

			utility.selectvalueByText_DropdownList(
					reduceiRS_DistCode_drpdwn,
					reader.getMapData(CommonVariable.iRS_Distributioncode, map));
			
			extent_Reportlogger(": "+testCaseName,
					"Entered Values Succesfully", "Pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			ValidateaddCovrage_Btn.click();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validationMszFun.validationMessagecheck(testCaseName, eventCode);
			}

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			checkBox1_EditCoverage.click();
			System.out.println("sdasd");

			expirydate_EditCovergae.clear();

			utility.enter_Text(
					expirydate_EditCovergae,
					(reader.getMapData(CommonVariable.Expire_Date, map)));

			utility.selectvalueByText_DropdownList(
					issueState_DropDown,
					reader.getMapData(CommonVariable.IssueState_Name, map));

			utility.selectvalueByText_DropdownList(
					reason_EditCoverage,
					reader.getMapData(CommonVariable.Reason, map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			extent_Reportlogger("Enetred the values Edit Coverage values ",
					"Edit Coverage  Screen", "Pass");

			validateInput_EditCoverage.click();

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
		
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");

			utility.click_On_Link(EmpDateChange_Link);

			System.out.println("before frame");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			System.out.println("enterd date>>> after frame");

			String date = reader.getMapData(CommonVariable.new_EmpDate, map);
			System.out.println("date" + date);

			
			NewEmpDate_tbl.clear();

			utility.enter_Text(
					NewEmpDate_tbl,
					(reader.getMapData(CommonVariable.new_EmpDate, map) + Keys.TAB));

			excelWrite.writeInCell("NewEmpDate_tbl", "Pass");
			extent_Reportlogger("Enetered new employemnt date",
					"Employment date screen", "Pass");

			System.out.println("completed");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			empDateValidatebtn.click();
		

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
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			String new_Val = "";
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,350)", "");

			new_Val = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);

			utility.enter_Text(newValue_txtBox,
					new_Val);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");

			utility.click_On_Button(validateInput_Btn);

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
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);

			String newDBoptionVal = "";

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			newDBoptionVal = reader.getMapData(
					CommonVariable.newDeathBenOption, map);
			utility.select_DropdownList(
					newDBOption_drpdwn,
					newDBoptionVal);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (newDBoptionVal.equalsIgnoreCase("D")) {

				/*dBOStrtYearCode.sendKeys(reader
						.getMapData(CommonVariable.death_BOStrtYearCode, map));*/

				String yearCode="";
				yearCode=reader.getMapData(CommonVariable.death_BOStrtYearCode,
						map);
				dBOStrtYearCode.sendKeys(yearCode,Keys.TAB);
			}

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");

			utility.click_On_Button(ValidateaddCovrage_Btn);

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

			reduce_EventDate_txtbox.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effdate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.click_On_Button(reduceValidateSel_Btn);
			reduceFaceChecklist.click();
			utility.enter_Text(reduce_NewFaceAmt,
					(reader.getMapData(CommonVariable.reduce_newFaceAmt, map)));
			utility.click_On_Button(FaceIncreaseInfo_Btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(Add_LayerImage);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));

			String Rem_LayerAmount = "";
			Rem_LayerAmount = Rem_layer_amount
					.getText();
			String splitVal1 = Rem_LayerAmount.substring(1);
			System.out.println("Rem_LayerAmount" + splitVal1);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			Layer_FaceAmt_TextBox.sendKeys(Keys
					.chord(Keys.CONTROL, "a"));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			Layer_FaceAmt_TextBox.sendKeys(
					Keys.BACK_SPACE, splitVal1);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			utility.click_On_Button(AddLayer_Ok_Btn);
			utility.click_On_Button(FaceIncreaseClose_Btn);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			utility.click_On_Button(ValidateaddCovrage_Btn);
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

			reduce_EventDate_txtbox.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, eventDate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			addCovrge_EffDate.sendKeys(
					Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, effdate,
					Keys.TAB);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.click_On_Button(reduceValidateSel_Btn);
			reduceFaceChecklist.click();
			utility.enter_Text(reduce_NewFaceAmt,
					(reader.getMapData(CommonVariable.reduce_newFaceAmt, map)));

			Conversion_ChkBox.click();

			utility.click_On_Button(ValidateaddCovrage_Btn);
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

			

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			String CoverageDetails_Value = reader.getMapData(
					CommonVariable.coverageAge_CoverageDetails, map);

			if (!(CoverageDetails_Value.equalsIgnoreCase("All - All Coverages"))) {

				utility.selectvalueByText_DropdownList(
						coveragedetails_drpdwn,
						reader.getMapData(
								CommonVariable.coverageAge_CoverageDetails, map));

				Thread.sleep(1000);
				utility.selectvalueByText_DropdownList(
						coverageLayerSel_drpdwn,
						reader.getMapData(
								CommonVariable.coverageAge_LayerSelec, map));

			}

			else {
				utility.selectvalueByText_DropdownList(
						coveragedetails_drpdwn,
						reader.getMapData(
								CommonVariable.coverageAge_CoverageDetails, map));

			}

			utility.click_On_Button(addSelectedCoverage_Btn);

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
			
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			
			
			
		
			 addAddress =new CopyExistandAddNew_PerformTranPage(driver);
			 addPhoneinfo = new AddressType_PhoneChange(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			postIssue_rdBtn.click();
			
			//code for serach new Details
			
			utility.click_On_Button(Locate_Btn);
			Thread.sleep(2000);
		//	String srchLastNameVal=reader.getMapData(CommonVariable.Search_LastName, map);
			
						
			//utility.enter_Text(searchLastName_txtBox, srchLastNameVal);
			
			
			utility.click_On_Button(searchIndRcrds_Btn);
			
		    Thread.sleep(5000);
			
			List<WebElement> rows = searchtble.findElements(By
					.tagName("tr"));
			
			int countRows=rows.size();		
			
			for(int i=2;i<=countRows;i++)
				
			{
				
				
				String personNme=driver
						.findElement(
								By.xpath("//table[@pl_prop='FindPolicyRecords.pxResults']//tbody//tr["
										+ i + "]//td[3]"))
						.getText();
				
				String SSN =driver
						.findElement(
								By.xpath("//table[@pl_prop='FindPolicyRecords.pxResults']//tbody//tr["
										+ i + "]//td[4]"))
						.getText();
				
				String dateofbrth=driver
						.findElement(
								By.xpath("//table[@pl_prop='FindPolicyRecords.pxResults']//tbody//tr["
										+ i + "]//td[5]"))
						.getText();
				
				
				
				if((personNme!=" ") &&  !(personNme.isEmpty()) && !(SSN.isEmpty()) && (SSN!=" ") && !(dateofbrth.isEmpty()) && (dateofbrth!=" ") )
				{ 
					System.out.println("inside if");
					System.out.println("sdsa");
					
					driver
					.findElement(
							By.xpath("//table[@pl_prop='FindPolicyRecords.pxResults']//tbody//tr["
									+ i + "]//td[2]//input[@type='radio']")).click();
					
					
					utility.click_On_Button(selectRcrds_Btn);
					
					break;
					
					
				}
				
			}
				
						
			//Address Information	
			AddInfo_Expand.click();	
			
			AddNew_radioBtn.click();
			
			jse.executeScript("window.scrollBy(0,200)", "");
			
			addAddress.enter_NewAddress();
			//click on check box for which you want to copy
			
			addAddress.updateAddressType_withNewAddress("add_NewAddress");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
						
			//Add Email
			jse.executeScript("window.scrollBy(0,200)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			EmailInfo_Expand.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.enter_Text(enter_New_Email,reader.getMapData(CommonVariable.enter_New_Email,map));
			utility.enter_Text(enter_Confirm_Email,reader.getMapData(CommonVariable.enter_Confirm_Email,map));
			//Add Email completes
						
			//Add Phone			
			PhoneInfo_Expand.click();
			addPhoneinfo.enter_Phone_Information();	
			jse.executeScript("window.scrollBy(0,200)", "");			
			//Add phone completes
									
			utility.click_On_Button(Submit_Annuitant_btn);
						
			extent_Reportlogger(":" + testCaseName,
					" Success Messages Displayed successfully ", "Pass");
			
			utility.click_On_Button(FaceIncreaseClose_Btn);
			
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			utility.click_On_Button(ValidateaddCovrage_Btn);
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
	
	////atIssue policy change functions>>>>>>>>>>>>>>>>>>
	
	public void dOIChange_SelectionCriteria(String testCaseName,String eventCode) throws Exception {
		try {
			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			utility.selectvalueByText_DropdownList(
					backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			utility.selectvalueByText_DropdownList(
					doiChangeNewValue_drpdwn,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues,
							map));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			validateInput_Btn.click();

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			String cellAge_CurrentValue = "";
			String cellAge_NewValue = "";

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			atIssue_rdBtn.click();

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			utility.selectvalueByText_DropdownList(
					backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			utility.enter_Text(newValue_txtBox,
					reader.getMapData(CommonVariable.atOrpostIssues_NewValues, map));

			extent_Reportlogger("Values entered successfully ",
					"PolicyChange_CellAgeMaintance SelectionCriteria ", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			validateInput_Btn.click();

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
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			// pDCVpasScreenlocators = new PolicyChange_PDCVpasScreen();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			policychange_AddNewDate_Btn.click();

			extent_Reportlogger("Clicked Succesfully", " Add new Dates ",
					"Pass");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			policyYearDate_txtBox.sendKeys(
					reader.getMapData(CommonVariable.policy_YearDate, map),
					Keys.TAB);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			policyIssueDate_txtBox.sendKeys(
					reader.getMapData(CommonVariable.policy_issuedate, map),
					Keys.TAB);

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			excelWrite
					.writeInCell(
							"Successfully entered the policy_YearDate & policy_issuedate ",
							"Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			policyDateValidate_Btn.click();

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
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			atIssue_rdBtn.click();

			utility.selectvalueByText_DropdownList(
					backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			this.select_coverageDetails();

			currentValue = policyChange_CurrentVal
					.getText();

			newValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);
			
			utility.enter_Text(newValue_txtBox,
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

			validateInput_Btn.click();

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

			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			atIssue_rdBtn.click();

			utility.selectvalueByText_DropdownList(
					backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			if ((testCaseName.equalsIgnoreCase("I212_CellSex"))) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				
				Thread.sleep(2000);
				
				currentValue = currentValue_txtBox
						.getAttribute("value");
				//System.out.println("currentValue"+currentValue);

				/*newValue = reader.getMapData(
						CommonVariable.atOrpostIssues_NewValues, map);*/

			}
			
			else
			{
			this.select_coverageDetails();
			
			}
			
			newValue = reader.getMapData(
					CommonVariable.atOrpostIssues_NewValues, map);
			
			utility.selectvalueByText_DropdownList(
					postIssueNewValue_drpdwn,
					newValue);

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if (this
					.isWebElementExist(currentandNewvalueerrorMsz) || currentValue.equalsIgnoreCase(newValue)) {
				extent_Reportlogger(":No Validation Performed:" + testCaseName,
						"New value can not be same as current value", "Fail");
				excelWrite.writeInCell(
						"New value can not be same as current value : No Validation Performed :"
								+ testCaseName, "Fail");
			} 
			else
			{
			validateInput_Btn.click();

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
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			
			String newDBoptionVal = "";

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			atIssue_rdBtn.click();

			utility.selectvalueByText_DropdownList(
					backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));

			// C:C---Specified Face + Return of Premium</option>
			// D:D---TSI & Optional Extra Death Benefit</option>
			// V:V---Variable Annuity</option>

			newDBoptionVal = reader.getMapData(
					CommonVariable.newDeathBenOption, map);
			utility.select_DropdownList(newDBOption_drpdwn, newDBoptionVal);
			Thread.sleep(3000);
			if (newDBoptionVal.equalsIgnoreCase("D")) {
				
				String yearCode="";
				yearCode=reader.getMapData(CommonVariable.death_BOStrtYearCode,
						map);
				dBOStrtYearCode.sendKeys(yearCode,Keys.TAB);
				
			}

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");

			utility.click_On_Button(ValidateaddCovrage_Btn);

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
			
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			
		

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			atIssue_rdBtn.click();
			

			utility.select_DropdownList(backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));
			
			
			utility.click_On_Button(reduceValidateSel_Btn);
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));

			reduceFaceChecklist.click();
			
			utility.enter_Text(reduce_NewFaceAmt,
					reader.getMapData(CommonVariable.reduce_newFaceAmt, map));
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			
			if(this.isWebElementExist(reducefaceErrMsz))
			
			{
				String faceerromszVal=reducefaceErrMsz.getAttribute("title");
				
				
				extent_Reportlogger(":" + faceerromszVal,
						"reduce face Error Message  ", "Fail");
				
				excelWrite.writeInCell(
						"reduce face Error Message :"+ faceerromszVal, "Fail");
				
			}
			else
			{
			extent_Reportlogger(":" + testCaseName,
					" Values entered successfully ", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			utility.click_On_Button(ValidateaddCovrage_Btn);

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
			
			
			validationMszFun = new PolicyChange_ValidationMszScreen(driver);
			
		
			 addAddress =new CopyExistandAddNew_PerformTranPage(driver);
			 addPhoneinfo = new AddressType_PhoneChange(driver);
			 			  

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			atIssue_rdBtn.click();
			

			utility.select_DropdownList(backdatedReason_drpdwn,
					reader.getMapData(CommonVariable.backdated_Reason, map));
			
			utility.click_On_Button(Locate_Btn);
			
			utility.click_On_Button(AddIndividual_Btn);
			
			
			//Personal Info			
			utility.enter_Text(enter_FirstName,reader.getMapData(CommonVariable.enter_FirstName,map));
			utility.enter_Text(enter_LastName, reader.getMapData(CommonVariable.enter_LastName,map));
			utility.enter_Text(enter_SSNNumber, reader.getMapData(CommonVariable.enter_SSNNumber,map));
			utility.enter_Text(enter_Birthdate, reader.getMapData(CommonVariable.enter_Birthdate,map));
				
			
			//Address Information	
			AddInfo_Expand.click();	
			AddNew_radioBtn.click();
			
			jse.executeScript("window.scrollBy(0,200)", "");
			addAddress.enter_NewAddress();
			
							
			//Add Email
			jse.executeScript("window.scrollBy(0,200)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			EmailInfo_Expand.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.enter_Text(enter_New_Email,reader.getMapData(CommonVariable.enter_New_Email,map));
			utility.enter_Text(enter_Confirm_Email,reader.getMapData(CommonVariable.enter_Confirm_Email,map));
			//Add email completes
			
			
			//Add Phone			
			PhoneInfo_Expand.click();
			addPhoneinfo.enter_Phone_Information();	
			jse.executeScript("window.scrollBy(0,200)", "");
			//Add phone completes
			
			
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));	
			utility.click_On_Button(Submit_Annuitant_btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			extent_Reportlogger(":" + testCaseName," Success Messages Displayed successfully ", "Pass");
			
			Actions actions = new Actions(driver);
			actions.moveToElement(FaceIncreaseClose_Btn).click().build().perform();
			utility.click_On_Button(FaceIncreaseClose_Btn);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(ValidateaddCovrage_Btn);	
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
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
		
		validationMszFun = new PolicyChange_ValidationMszScreen(driver);
		
		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");

		atIssue_rdBtn.click();
		Thread.sleep(4000);
		//Customized value enter in backdated Drop down
		String addCov_backDatedRson= reader.getMapData(CommonVariable.backdated_Reason, map);
				String splitVal1= addCov_backDatedRson.substring(0,3);
		String splitVal2=addCov_backDatedRson.substring(3);
				StringJoiner joiner = new StringJoiner(",");
		joiner.add(splitVal1).add(splitVal2);
		String addCovrge_joinedString = joiner.toString(); // "01,02,03"
				
		
		utility.select_DropdownList(backdatedReason_drpdwn,
				addCovrge_joinedString);
		
		this.policy_Addcoverage(testCaseName,eventCode);
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
	
	public boolean isWebElementExist(WebElement value) {
		try {

			value.isDisplayed();
				
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	

}
