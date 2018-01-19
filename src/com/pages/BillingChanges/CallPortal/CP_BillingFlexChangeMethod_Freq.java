/*package com.pages.BillingChanges.CallPortal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.functions.billingChanges.BillingChangesFlexibleProd;
import com.pages.BillingChanges.PerformTransactionPage;
import com.pages.commonScreens_CP.Action_Summary;
import com.pages.commonScreens_CP.Workflow_Confirmation;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class CP_BillingFlexChangeMethod_Freq extends Initialize_Browser {

	public CP_BillingFlexChangeMethod_Freq(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	BaseUtils utility = new BaseUtils(driver);

	// Locators Payor Change

	@FindBy(xpath = ".//*[@id='EffDate']")
	public WebElement CP_BillingChangeEffDate;

	@FindBy(xpath = ".//*[@id='BillingChangeOptions']")
	WebElement CP_BillingChangeOptions;

	@FindBy(xpath = "//div[text()='Change Payor']")
	WebElement CP_ChangePayor;

	@FindBy(xpath = ".//*[@id='IsPolicyOwnerPolicy Owner']")
	WebElement CP_PolicyOwnerRadioBtn;

	@FindBy(xpath = ".//*[@id='PolicyOwner']")
	WebElement CP_PolicyOwnerDrpDwn;

	// @FindBy(xpath =
	// "//div[@class='pzbtn-rnd'][contains(.,'Submit To VPAS')]")
	@FindBy(xpath = "//div[text()='Submit To VPAS']")
	WebElement CP_BillingSubmitVpas;

	@FindBy(xpath = "//div[text()='Done']")
	WebElement CP_BillingDoneBtn;

	@FindBy(xpath = ".//*[@id='StrongButton']/tbody/tr/td[2]")
	WebElement mailtoEftDoneBtn;

	// VPAS confirmation message
	@FindBy(xpath = "//div[text()='Data Submitted Successfully']")
	WebElement CP_VpasConfirmation;

	// Locators Bill To date

	@FindBy(xpath = "//div[text()='Change Bill to Date']")
	WebElement CP_BillToDateChangeBtn;

	@FindBy(xpath = ".//*[@id='NewBillToDate']")
	WebElement CP_NewBillToDateTextBox;

	@FindBy(xpath = "//div[text()='submit bill to date']")
	WebElement CP_SubmitBillToDateBtn;

	@FindBy(xpath = "//div[text()='Close']")
	WebElement CP_CloseBTD;

	@FindBy(xpath = "//button[@name='MainlingAddress_pyWorkPage.BillingAddress_24']//div[text()='Done changes']")
	WebElement EftToMailDoneChangesBTD;
	// Locators DOm

	@FindBy(xpath = "//div[text()='Done Changes']")
	WebElement CP_DoneChangesBTD;

	@FindBy(xpath = "//div[@node_name='EFTAccountDetailsMain']//button[@name='EFTAccountDetailsMain_pyWorkPage_28']//div[text()='Done Changes']")
	WebElement CP_MailToEftDOneChnages;

	@FindBy(id = "NewDOM")
	WebElement cp_DOM_txtBox;

	@FindBy(xpath = "//div[text()='Submit Day Of Month']")
	WebElement cp_submitDOM_Btn;

	@FindBy(xpath = "//label[@for='ErrorStatus']/following-sibling::div")
	WebElement cp_vPASErrorMsz;

	// Locators Manual Bill

	@FindBy(xpath = ".//*[@id='AmountDue']")
	WebElement CP_ManualBillAmt;

	@FindBy(xpath = ".//*[@id='RePrintInd']")
	WebElement CP_ReprintCheckBox;

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement CP_ManualBillSubmitBtn;

	@FindBy(xpath = ".//*[@class='field-item dataLabelWrite']")
	WebElement CP_SuccessFullMssgMbill;

	@FindBy(xpath = ".//*[@id='EffDate']")
	// Added on 25/09
	WebElement CP_ChangeMethodFlexEffDate;

	// Locators loan bill

	@FindBy(xpath = "//div[text()='Add New']")
	WebElement CP_AddNewLoanBill;

	@FindBy(xpath = ".//*[@id='EffDate']")
	WebElement CP_EffDateLoanBill;

	@FindBy(xpath = ".//*[@id='LoanRepayAmt']")
	WebElement CP_LoanRepayAmtLoanBill;

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement CP_LoanBillSubmitBtn;

	@FindBy(xpath = ".//*[@class='field-item dataLabelWrite']")
	WebElement CP_SuccessFullMssgLbill;

	@FindBy(xpath = "//div[text()='Close']")
	WebElement CP_LoanBillCloseBtn;

	// Locators Billing Changes Mail to EFT

	@FindBy(xpath = "//div[text()='Change Method/Frequency']")
	WebElement CP_ChangeMethodFreqBtn;

	@FindBy(xpath = ".//*[@id='PaymentMethodE']")
	WebElement CP_EFTRadioBtn;

	// @FindBy(xpath="//div[text()='Add New Account']")
	@FindBy(xpath = "//div[@id='INNERDIV-SubSectionBillMethodChangeBBBBBB']//button[@name='EFTAccountDetailsMain_pyWorkPage_26']")
	WebElement CP_AddNewAccntBtn;

	@FindBy(id = "NewABANumber")
	WebElement abaNumber;

	@FindBy(id = "NewAccountNumber")
	WebElement newAccntNumber;

	@FindBy(xpath = "//select[@id='NewAccountType']")
	WebElement accountType_drpDown;

	@FindBy(xpath = "//button//div[text()='Update EFT Account']")
	WebElement updateAccount;

	// @FindBy(xpath =
	// ".//*[@id='RULE_KEY']/div[3]/div/div/div/div/div/div/div/div/div/div/span/button")
	@FindBy(xpath = "//div[text()='Submit']")
	WebElement billingStatus_submit;

	@FindBy(id = "PaymentMethodM")
	WebElement mailing;

	@FindBy(xpath = "//label[@for='ErrorMessageDetails']/following-sibling::div")
	WebElement cp_billingErrorMsz;

	@FindBy(id = "BillingStatusOption")
	WebElement billingStatus;

	@FindBy(id = "ReasCode")
	WebElement reasonCode;

	// locators Billing election
	@FindBy(xpath = "//button//div[text()='Add New']")
	WebElement addNew_Btn;

	@FindBy(xpath = "//button[@name='BillingElectList_pyWorkPage_127']")
	WebElement rcrdAddnew_Btn;

	@FindBy(id = "BillingElectEffDate")
	WebElement billingEffectiveDate;

	@FindBy(id = "BillingType")
	WebElement billingType;

	@FindBy(xpath = "//table[@pl_prop='.BillingMntInfo']//tbody")
	WebElement cpBilling_tabl;

	@FindBy(id = "NewBillElecType")
	WebElement billingElecType;

	@FindBy(id = "NewBillCompType")
	WebElement billingCompType;

	@FindBy(id = "PaymentOrder")
	WebElement paymentOrder;

	// EFT to Mail
	@FindBy(xpath = "//button//div[text()='Change Method/Frequency']")
	WebElement changeMethod_Freq;

	@FindBy(xpath = "//button//div[text()='Update Mailing Address']")
	WebElement updateAddress;

	// //Loctaors Planned Premium date

	@FindBy(xpath = "//button//div[text()='Changed planned premium']")
	WebElement planedPrem_Btn;

	@FindBy(id = "NewModalPremium")
	WebElement enterNewModal;

	@FindBy(xpath = "//button//div[text()='Submit New Premium']")
	WebElement submitNewPrem_Btn;

	@FindBy(xpath = "//label[@for='.ErrorMessageDetails']/following-sibling::div")
	WebElement premumErrorMsz;

	// Locators Billing To Suspend

	@FindBy(xpath = ".//*[@id='EndDate']")
	WebElement CP_SuspendEndDateTxtBox;

	@FindBy(id="NoOfBillCycles")
	WebElement CP_NoOfBillTxtBox;
	
	
	
	

	@FindBy(xpath = "//div[text()='Submit']")
	WebElement CP_SuspendSubmitBtn;

	// Address Change
	@FindBy(id = "AddressLine1")
	WebElement addressLine1;

	@FindBy(id = "AddressLine2")
	WebElement addressLine2;

	@FindBy(id = "AddressLine3")
	WebElement addressLine3;

	@FindBy(id = "AddressLine4")
	WebElement addressLine4;

	@FindBy(id = "AddressCity")
	WebElement address_City;

	@FindBy(xpath = "//select[@id='AddressState']")
	WebElement address_State_drpdwn;

	@FindBy(id = "AddressZip")
	WebElement address_Zip;

	@FindBy(xpath = "//select[@id='AddressCountry']")
	WebElement address_Country_drpdwn;

	// Payor Change

	public void billingChangesFlexible_PayorChangeMethod() throws Exception {

		try {

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);

			CP_ChangePayor.click();

			System.out.println("Clicked on Change Payor");
			// Thread.sleep(20000);

			CP_PolicyOwnerRadioBtn.click();
			CP_PolicyOwnerDrpDwn.click();
			CP_PolicyOwnerDrpDwn.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			// CP_PolicyOwnerDrpDwn.sendKeys(Keys.ENTER);

			extent_Reportlogger(" Successfully Updated ",
					"Payor Change Details ", "Pass");
			excelWrite.writeInCell(
					" Payor Change Details Updated Successfully ", "pass");

			CP_BillingSubmitVpas.click();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");

			System.out.println("Clicked on Submit VPAS");
			Thread.sleep(20000);

			this.verifyMsz();
			// Thread.sleep(10000);

			CP_BillingDoneBtn.click();

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChangesFlexible_PayorChange", "Fail");
			excelWrite.writeInCell(
					"billingChangesFlexible_PayorChange Test Case Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexible_PayorChange", e.getMessage());
			e.printStackTrace();

			throw e;

		}
	}

	// Bill To Date

	public void billingChangesFlexible_BillToDateMethod() throws Exception {

		try {

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);

			CP_BillToDateChangeBtn.click();
			CP_NewBillToDateTextBox.click();
			utility.enter_Text(CP_NewBillToDateTextBox,
					reader.getMapData(CommonVariable.CP_NewBillingDate, map));
			CP_SubmitBillToDateBtn.click();

			this.verifyMsz();

			CP_CloseBTD.click();
			CP_DoneChangesBTD.click();

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChangesFlexible_BillToDate", "Fail");
			excelWrite.writeInCell(
					"billingChangesFlexible_BillToDate Test Case Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexible_BillToDate", e.getMessage());
			e.printStackTrace();

		}

	}

	// DOM
	public void billingChangesFlexible_DOM() throws Exception {
		try {

			String effDate = "";
			effDate = reader.getMapData(CommonVariable.cp_Effectivedate, map);

			CP_BillingChangeEffDate.sendKeys(Keys.chord(Keys.CONTROL, "a"),
					Keys.BACK_SPACE, effDate, Keys.TAB);

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			Thread.sleep(20000);

			cp_DOM_txtBox.sendKeys(
					reader.getMapData(CommonVariable.cp_DOM, map), Keys.TAB);

			cp_submitDOM_Btn.click();
			Thread.sleep(20000);
			jse.executeScript("window.scrollBy(0,-250)", "");

			this.verifyMsz();

			utility.click_On_Button(CP_DoneChangesBTD);

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChangesFlexible_DOM", "Fail");
			excelWrite.writeInCell(
					"billingChangesFlexible_DOM Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChangesFlexible_DOM", e.getMessage());
			e.printStackTrace();
			throw e;

		}

	}

	public void billingChngFlex_PlannedPremUpdt() throws Exception {

		try {

			String effDate = "";
			effDate = reader.getMapData(CommonVariable.cp_Effectivedate, map);
			if (!(effDate == null) && !(effDate == "")) {
				CP_BillingChangeEffDate.sendKeys(Keys.chord(Keys.CONTROL, "a"),
						Keys.BACK_SPACE, effDate, Keys.TAB);
			}

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");

			Thread.sleep(20000);
			planedPrem_Btn.click();

			utility.enter_Text(enterNewModal,
					reader.getMapData(CommonVariable.newModalPremium, map));

			extent_Reportlogger("successfully updated",
					"Planned premium details", "Pass");
			excelWrite.writeInCell(
					"Planned premium details successfully updated", "Pass");

			utility.click_On_Button(submitNewPrem_Btn);

			if (utility.isWebElementExist(premumErrorMsz)) {
				String premiumErrMsz = premumErrorMsz.getText();
				extent_Reportlogger(":" + premiumErrMsz, "VpasError Message",
						"Pass");
				excelWrite.writeInCell("VpasError Message :" + premiumErrMsz,
						"pass");

			} else {
				this.verifyMsz();

				utility.click_On_Button(CP_CloseBTD);

				utility.click_On_Button(CP_DoneChangesBTD);

				this.callPortalBillingFlexible_EndInteraction();
			}

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChngFlex_PlannedPremUpdt", "Fail");
			excelWrite.writeInCell(
					"billingChngFlex_PlannedPremUpdt Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChngFlex_PlannedPremUpdt", e.getMessage());
			e.printStackTrace();
			throw e;

		}
	}

	// Manual Bill

	public void BillingChangesFlexible_ManualBillMethod() throws Exception {

		try {

			// added on 2509
			// //utility.enter_Text(CP_ChangeMethodFlexEffDate,reader.getMapData(CommonVariable.CP_ChangeMethodFlexEffDate,map));
			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);

			CP_ManualBillAmt.click();
			utility.enter_Text(CP_ManualBillAmt,
					reader.getMapData(CommonVariable.CP_ManualBillAmt, map));
			CP_ReprintCheckBox.click();
			CP_ManualBillSubmitBtn.click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");

			this.verifyMsz();

			CP_DoneChangesBTD.click();

		} catch (Exception e) {

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

	// Loan Bill

	public void BillingChangesFlexible_LoanBillMethod() throws Exception {

		try {

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);
			CP_AddNewLoanBill.click();
			utility.enter_Text(CP_EffDateLoanBill,
					reader.getMapData(CommonVariable.CP_EffDateLoanBill, map));
			utility.enter_Text(CP_LoanRepayAmtLoanBill, reader.getMapData(
					CommonVariable.CP_LoanRepayAmtLoanBill, map));
			CP_LoanBillSubmitBtn.click();

			this.verifyMsz();

			CP_LoanBillCloseBtn.click();
			Thread.sleep(20000);
			CP_DoneChangesBTD.click();

		} catch (Exception e) {

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

	public void billingChngFlex_billElections() throws Exception {
		try {

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);

			addNew_Btn.click();

			String effDate = "";
			effDate = reader.getMapData(CommonVariable.cp_Effectivedate, map);
			if (!(effDate == null) && !(effDate == "")) {
				billingEffectiveDate.sendKeys(Keys.chord(Keys.CONTROL, "a"),
						Keys.BACK_SPACE, effDate, Keys.TAB);
			} else {
				extent_Reportlogger("is required", "New Effective Date  ",
						"Pass");
				excelWrite
						.writeInCell("New Effective Date is required", "Pass");
			}

			utility.selectvalueByText_DropdownList(billingType,
					reader.getMapData(CommonVariable.billingTyp, map));

			CP_ManualBillSubmitBtn.click();

			this.verifyMsz();

			CP_CloseBTD.click();

			// slect record based on date and billing type
			this.selectField_BillingElect();

			Thread.sleep(3000);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,150)", "");

			driver.findElement(
					By.xpath(".//*[@id='RULE_KEY']/div[3]/div/div/div/div/div/span/button"))
					.click();

			// rcrdAddnew_Btn.click();

			utility.selectvalueByText_DropdownList(billingElecType,
					reader.getMapData(CommonVariable.electionType, map));
			utility.selectvalueByText_DropdownList(billingCompType,
					reader.getMapData(CommonVariable.compType, map));
			utility.enter_Text(paymentOrder,
					reader.getMapData(CommonVariable.paymentOrder, map));
			extent_Reportlogger(" Entered Successfully",
					"Billing election details", "pass");
			excelWrite.writeInCell(
					reader.getMapData(CommonVariable.paymentOrder, map)
							+ " :payment order entered"
							+ reader.getMapData(CommonVariable.electionType,
									map) + " :election type selected"
							+ reader.getMapData(CommonVariable.compType, map)
							+ " :comp type selected", "pass");

			CP_ManualBillSubmitBtn.click();

			CP_CloseBTD.click();

			CP_ManualBillSubmitBtn.click();

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChngFlex_billElections", "Fail");
			excelWrite.writeInCell(
					"billingChngFlex_billElections Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChngFlex_billElections", e.getMessage());
			e.printStackTrace();
			throw e;

		}
	}

	public void billingChngFlex_EFTtoMail() throws Exception {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);

			utility.click_On_Button(changeMethod_Freq);

			utility.click_On_Button(mailing);
			jse.executeScript("window.scrollBy(0,250)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			this.billing_genericUpdateAddress();

			extent_Reportlogger("Entered details",
					"performTransc address EFTToMail Screen", "pass");
			excelWrite.writeInCell("Entered details successfully", "pass");
			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			utility.click_On_Button(updateAddress);
			this.verifyMsz();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			jse.executeScript("window.scrollBy(0,250)", "");

			utility.click_On_Button(EftToMailDoneChangesBTD);
			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			jse.executeScript("window.scrollBy(0,-200)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			utility.click_On_Button(billingStatus_submit);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			utility.click_On_Button(mailtoEftDoneBtn);
			
			

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChngFlex_EFTtoMail", "Fail");
			excelWrite.writeInCell(
					"billingChngFlex_EFTtoMail Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChngFlex_EFTtoMail", e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	//
	// Billing Changes Mail to EFt

	public void billingChngFlex_MailtoEFT() throws Exception {

		try {
			Actions actions = new Actions(driver);

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);
			CP_ChangeMethodFreqBtn.click();
			boolean flag = CP_EFTRadioBtn.isSelected();

			CP_EFTRadioBtn.click();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			// Actions actions = new Actions(driver);
			actions.moveToElement(CP_AddNewAccntBtn).click().build().perform();
			utility.click_On_Button(CP_AddNewAccntBtn);

			utility.enter_Text(abaNumber,
					reader.getMapData(CommonVariable.abaNumberr, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(newAccntNumber,
					reader.getMapData(CommonVariable.accountNumber, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(accountType_drpDown,
					reader.getMapData(CommonVariable.accounttype, map));

			extent_Reportlogger(":Data is entered successfully for MailToEft",
					"Entered MailToEFT data", "pass");
			excelWrite
					.writeInCell(
							"AbaNumber Entered = "
									+ reader.getMapData(
											CommonVariable.abaNumberr, map)
									+ ", "
									+ "NewAcountNumber passed = "
									+ reader.getMapData(
											CommonVariable.accountNumber, map)
									+ " and "
									+ "NewAcountType Selected = "
									+ reader.getMapData(
											CommonVariable.accounttype, map),
							"Pass");

			utility.click_On_Button(updateAccount);

			this.verifyMsz();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(CP_MailToEftDOneChnages);
			// utility.click_On_Button(CP_DoneChangesBTD);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			utility.click_On_Button(CP_ManualBillSubmitBtn);
			// actions.moveToElement(CP_ManualBillSubmitBtn).click().build().perform();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			// actions.moveToElement(CP_BillingDoneBtn).click().build().perform();
			// utility.click_On_Button(CP_BillingDoneBtn);
			utility.click_On_Button(mailtoEftDoneBtn);

		} catch (Exception e) {

			extent_Reportlogger("Execution Failed",
					"billingChngFlex_MailtoEFT", "Fail");
			excelWrite.writeInCell(
					"billingChngFlex_MailtoEFT Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChngFlex_MailtoEFT", e.getMessage());
			e.printStackTrace();
			throw e;

		}

	}

	public void billingChngFlex_BillingtoCancel() throws Exception {
		try {

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);
			billingChngFlex_BillingStatusChange("cp_BillingtoCancel");

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChngFlex_BillingtoCancel", "Fail");
			excelWrite.writeInCell(
					"billingChngFlex_BillingtoCancel Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChngFlex_BillingtoCancel", e.getMessage());
			e.printStackTrace();
			throw e;

		}
	}

	public void billingChngFlex_CanceltoResume() throws Exception {
		try {
			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);
			billingChngFlex_BillingStatusChange("cp_CanceltoResume");

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed",
					"billingChngFlex_CanceltoResume", "Fail");
			excelWrite.writeInCell(
					"billingChngFlex_CanceltoResume Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChngFlex_CanceltoResume", e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	// Billing To Suspend

	public void BillingChangesFlexible_BillingToSuspendMethod()
			throws Exception {

		try {

			utility.selectvalueByText_DropdownList(CP_BillingChangeOptions,
					reader.getMapData(CommonVariable.CP_BillingChangeOptions,
							map));
			Thread.sleep(20000);

			utility.selectvalueByText_DropdownList(billingStatus,
					reader.getMapData(CommonVariable.bilingStatus, map));

			utility.selectvalueByText_DropdownList(reasonCode,
					reader.getMapData(CommonVariable.resnCode, map));
			reasonCode.sendKeys(Keys.TAB);
			// Thread.sleep(10000);

			
			 utility.enter_Text(CP_SuspendEndDateTxtBox,reader.getMapData(
			  CommonVariable.CP_SuspendEndDateTxtBox, map));
			  
			 Thread.sleep(2000);
			  CP_SuspendEndDateTxtBox.sendKeys(
						Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, reader.getMapData(
								  CommonVariable.CP_SuspendEndDateTxtBox, map),
						Keys.TAB);
			  Thread.sleep(20000);
			  
			  CP_NoOfBillTxtBox.sendKeys(reader.getMapData(CommonVariable .CP_NoOfBillTxtBox, map),
						Keys.TAB);
			  
			  utility.enter_Text(
			 CP_NoOfBillTxtBox,reader.getMapData(CommonVariable
			  .CP_NoOfBillTxtBox, map));
			 

			Thread.sleep(3000);
			CP_SuspendSubmitBtn.click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");

			this.verifyMsz();

			CP_DoneChangesBTD.click();

		} catch (Exception e) {

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

	public void selectField_BillingElect() throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,150)", "");
			Thread.sleep(3000);

			List<WebElement> rows = cpBilling_tabl.findElements(By
					.tagName("tr"));
			int countRows = rows.size();

			for (int a = 2; a <= countRows; a++) {

				String datevalue = driver
						.findElement(
								By.xpath("//table[@pl_prop='.BillingMntInfo']//tbody//tr["
										+ a + "]//td[1]")).getText();

				String billingTypevalue = driver
						.findElement(
								By.xpath("//table[@pl_prop='.BillingMntInfo']//tbody//tr["
										+ a + "]//td[2]")).getText();

				String excelDate = reader.getMapData(
						CommonVariable.cp_Effectivedate, map);
				String excelType = reader.getMapData(CommonVariable.billingTyp,
						map);

				if (datevalue.equalsIgnoreCase(excelDate)
						&& billingTypevalue.equalsIgnoreCase(excelType)) {

					driver.findElement(
							By.xpath("//table[@pl_prop='.BillingMntInfo']//tbody//tr["
									+ a + "]//td[1]")).click();

					break;

				}

			}

		} catch (Exception e) {
			extent_Reportlogger("Execution Failed", "selectField_BillingElect",
					"Fail");
			excelWrite.writeInCell("selectField_BillingElect Test Case Failed",
					"Fail");
		}
	}

	// Generic billing status Function

	public void billingChngFlex_BillingStatusChange(String testCaseName)
			throws Exception {

		try {
			utility.selectvalueByText_DropdownList(billingStatus,
					reader.getMapData(CommonVariable.bilingStatus, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(reasonCode,
					reader.getMapData(CommonVariable.resnCode, map));

			extent_Reportlogger(":" + testCaseName
					+ "Entered details successfully", "BillingStatusChange",
					"pass");
			excelWrite.writeInCell("BillingStatusChange:" + testCaseName
					+ "Entered details successfully", "pass");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			reasonCode.sendKeys(Keys.TAB);

			Actions actions = new Actions(driver);
			actions.moveToElement(billingStatus_submit).click().build()
					.perform();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			utility.click_On_Button(billingStatus_submit);
			billingStatus_submit.click();
			billingStatus_submit.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			if (utility.isWebElementExist(cp_billingErrorMsz)) {
				String errorMsz = cp_billingErrorMsz.getText();
				
			} else {
				this.verifyMsz();
				if (testCaseName.equalsIgnoreCase("cp_BillingtoCancel")
						|| testCaseName.equalsIgnoreCase("cp_CanceltoResume")) {

					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,
							TimeUnit.SECONDS));
					CP_DoneChangesBTD.click();
				}
			}
		} catch (Exception e) {
			extent_Reportlogger(" execution failed",
					"billingChngFlex_BillingStatusChange", "fail");
			excelWrite.writeInCell(
					"billingChngFlex_BillingStatusChange execution failed",
					"fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billingChngFlex_BillingStatusChange", e.getMessage());
			throw e;

		}

	}

	public void callPortalBillingFlexible_EndInteraction() throws Exception {
		try {
			Workflow_Confirmation workflow_Confirmation = new Workflow_Confirmation(
					driver);
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
					"callPortalBillingFlexible_EndInteraction", "FAIL");
			excelWrite
					.writeInCell(
							"callPortalBillingFlexible_EndInteraction Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"callPortalBillingFlexible_EndInteraction", e.getMessage());
			throw e;
		}
	}

	public void verifyMsz() throws Exception {
		String Expected_VpasMssg = "Data Submitted Successfully";
		String Vpas_ActualMssg = CP_VpasConfirmation.getText();
		System.out.println("Vpas_ActualMssg" + Vpas_ActualMssg);
		if (Expected_VpasMssg.equalsIgnoreCase(Vpas_ActualMssg)) {

			extent_Reportlogger("Data Submitted Successfully",
					"Vpas Confirmation", "Pass");
			excelWrite.writeInCell("Data Submitted Successfully to Vpas",
					"pass");

		}

		else {
			extent_Reportlogger("Failed", "Vpas Confirmation", "Fail");
			excelWrite.writeInCell("Vpas Confirmation Failed", "Fail");

		}

	}

	public void billing_genericUpdateAddress() throws Exception {
		try {
			// flexBilling = new PerformTransactionPage();

			String addressLin1 = "";
			String addressLin2 = "";
			String addressLin3 = "";
			String addressLin4 = "";
			String editCity = "";
			String editZipCode = "";
			String editState = "";

			addressLin1 = reader.getMapData(CommonVariable.edit_addressLine1,
					map);
			addressLin2 = reader.getMapData(CommonVariable.edit_addressLine2,
					map);
			addressLin3 = reader.getMapData(CommonVariable.edit_addressLine3,
					map);
			addressLin4 = reader.getMapData(CommonVariable.edit_addressLine4,
					map);
			editCity = reader.getMapData(CommonVariable.edit_City, map);
			editZipCode = reader.getMapData(CommonVariable.edit_ZipCode, map);
			editState = reader.getMapData(CommonVariable.edit_State, map);

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			if (!(addressLin1 == null || addressLin1 == "")) {
				
				addressLine1.sendKeys(
						Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, addressLin1,
						Keys.TAB);

			}

			if (!(addressLin2 == null || addressLin2 == "")) {
				
				addressLine2.sendKeys(
						Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, addressLin2,
						Keys.TAB);

			}
			if (!(addressLin3 == null || addressLin3 == "")) {
				
				addressLine3.sendKeys(
						Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, addressLin3,
						Keys.TAB);

			}
			if (!(addressLin4 == null || addressLin4 == "")) {
				
				addressLine4.sendKeys(
						Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, addressLin4,
						Keys.TAB);

			}

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			if (!(editCity == null || editCity == "")) {
				
				address_City.sendKeys(
						Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, editCity,
						Keys.TAB);

			} else {
				extent_Reportlogger(":City Should Not be blank",
						"upadteAddress", "Pass");
				excelWrite.writeInCell(
						"upadteAddress:City Should Not be blank", "Pass");

			}

			

			utility.selectvalueByText_DropdownList(address_State_drpdwn,
					reader.getMapData(CommonVariable.edit_State, map));
			

			
			if (!(editZipCode == null || editZipCode == "")) {

				
				System.out.println(editZipCode);
				String regex = "\\d{5}";
				if (editZipCode.matches(regex)) {
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					address_Zip.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, editZipCode,
							Keys.TAB);
					
				} else {
					excelWrite.writeInCell(
							"Invalid Zip Code: ZIP code should be 5 digit numeric - "
									+ editZipCode, "Fail");

				}

			}
			

			utility.selectvalueByText_DropdownList(address_Country_drpdwn,
					reader.getMapData(CommonVariable.edit_Country, map));

			extent_Reportlogger(" test step execution   successfully ",
					"Upadte  address", "Pass");

			excelWrite.writeInCell(
					"Upadte  address test step execution   successfully ",
					"Pass");

		} catch (Exception e) {
			extent_Reportlogger(" Execution failed",
					"billing_genericUpdateAddress", "FAIL");
			excelWrite.writeInCell(
					"billing_genericUpdateAddress  Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"billing_genericUpdateAddress", e.getMessage());
			throw e;

		}
	}

}
*/