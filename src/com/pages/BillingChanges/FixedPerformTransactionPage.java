package com.pages.BillingChanges;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;



/**
 *Class contains the locator 
 *Class contains the methods which are using the webElements and use to perform the functionality
 */

public class FixedPerformTransactionPage extends Initialize_Browser {

	BaseUtils utility = new BaseUtils(driver);

	public FixedPerformTransactionPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);

	}
	//WebElements with the define locators
	
	@FindBy(id = "ChangeStatus")
	WebElement status;

	@FindBy(id = "Eff Date.")
	WebElement effectiveDate;

	// @FindBy(xpath="//div[@class='layout-body clearfix']//div[@class='pzbtn-mid'][contains(.,'Submit')]")
	// //trial
	//@FindBy(id ="submitButton")
	@FindBy(xpath="//button[@id='submitButton']")
	WebElement submit;
	
	@FindBy(xpath="//button//div[text()='Submit']")
	WebElement subButton;
	
	@FindBy(xpath = "//button[text() = '  Done ']")
	WebElement newDone;

	@FindBy(xpath = ".//*[@id='RULE_KEY']/table/tbody/tr[1]/td[1]/nobr/label/b")
	WebElement message;

	@FindBy(xpath = "//button//div[text()='Bill Next Invoice']")
	WebElement billVoiceButton;

	// @FindBy(xpath="//button//div[starts-with(text(),'Done')]")
	@FindBy(xpath = "//button[starts-with(text(),'Done')]")
	WebElement done;

	@FindBy(xpath = "(.//*[@id='RULE_KEY']/table/tbody/tr[1]/td/nobr/label)[3]")
	WebElement expMsg;

	@FindBy(xpath = "//button//div[text()='RegenerateBill Unpaid Invoices']")
	WebElement unpaidInvoice;
	
	@FindBy(xpath="//table[@pl_prop='MCBillingHistory.pxResults']//tr[2]//td[1]//input[@type='radio']")
	
	WebElement radioInvoice;

	@FindBy(id = "PaymentMethodE")
	WebElement eft;

	@FindBy(xpath = "(.//*[@id='LocalRadio'])[3]")
	WebElement quartely;

	@FindBy(id = "AddNewEFTNew EFT Account")
	WebElement newEftAcount;

	@FindBy(id = "NewABANumber")
	WebElement abaNumber;

	@FindBy(id = "NewAccountNumber")
	WebElement newAcountNumber;

	@FindBy(id = "NewAccountType")
	WebElement newAcountType;

	@FindBy(id = "NewDOM")
	WebElement newDom;
	
	@FindBy(id="PaymentMethodM")
	WebElement mailing;
	
	@FindBy(id="IsPayorChange")
	WebElement payorOption;
	
	@FindBy(id="InsuredOtherThanPayorCPOI")
	WebElement payorOptionUnInsured;
	
	@FindBy(xpath="//button//div[text()='Add / Search Alpha For Owner']")
	WebElement addAlpa;
	
	@FindBy(id="FirstName")
	WebElement enter_FirstName;
	
	@FindBy(id="LastName")
	WebElement enter_LastName;
	
	@FindBy(id="SSN")
	WebElement enter_SSNNUmber;
	
	@FindBy(id="Birth Date")
	WebElement enter_BirthDate;
	
	@FindBy(xpath="//button[text()='  Submit New Alpha Info To VPAS(R) ']")
	WebElement submitVpasbutton;
	
	@FindBy(xpath=".//*[@id='RULE_KEY']/div[1]/div/div/div/div/div/div/div/div[2]/div/div/span")
					//*[@id='RULE_KEY']/div[1]/div/div/div/div/div/div/div/div[2]/div/div/span
	WebElement popUpMsg;
	
	@FindBy(xpath="//button//div[text()='Close']")
	WebElement close;
	
	@FindBy(id="DOMChangeB")
	WebElement beginningPeriod;
	
	
	//Method performing the billing status change scenarios.
	
	public void modify_BillingToCancel(String name) throws Exception {

		try {
			//Selecting the data from drop down
			utility.selectvalueByText_DropdownList(status,
					reader.getMapData(CommonVariable.status, map));
			////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//Logging the logs in excel
			excelWrite.writeInCell(
					reader.getMapData(CommonVariable.status, map) + ":" + name
							+ " data selected", "pass");
			
			//Checking the effective date value from excel is null or empty and if not then entering the effective date in required field
			if (!(reader.getMapData(CommonVariable.effectiveDate, map) == null || reader
					.getMapData(CommonVariable.effectiveDate, map) == "")) {
				System.out.println("inside date");
				effectiveDate.clear();
				////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				utility.enter_Text(effectiveDate,
						reader.getMapData(CommonVariable.effectiveDate, map));
				//Logging the logs in excel
				excelWrite.writeInCell(
						reader.getMapData(CommonVariable.effectiveDate, map)
								+ ": Effective date entered", "pass");
			}
			//Logging the logs in extent
			extent_Reportlogger(" :Executed successfully", "performTransaction"
					+ name + "Screen", "pass");
			
			
			////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			//clicking on submit button
			utility.click_On_Button(submit);
			////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//verifying the status by calling the check status method
			checkStatus(name);
			//clicking on submit button
			utility.click_On_Button(submit);

		} catch (Exception e) {
			//Logging the logs in extent reports and excel reports
			extent_Reportlogger(" :Execution failed",
					"performTransaction" + name + "Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction" + name +  "Screen", "fail");
			ErrorLogger.logError(e.getClass().getName(), "performTransaction",
					e.getMessage());
			throw e;
		}

	}
	
	//Common method to verify the VPAS status by validating the expected and actual message

	public boolean checkStatus(String name) throws Exception {

		String Expected = "The information was successfully updated to VPAS.";
		String actual = message.getText();

		if (actual.equalsIgnoreCase(Expected)) {
			excelWrite.writeInCell(
					 actual,
					"Pass");

			extent_Reportlogger(actual, "Perform Transaction" + name
					+ " Screen", "Pass");
			return true;

		} else {
			excelWrite.writeInCell(
				 actual,
					"Fail");

			extent_Reportlogger(actual,
					" work flow will  not be Perform Transaction " + name
							+ " Screen", "Fail");

			return false;
		}
	}
	
	//Common method to verify the VPAS status by validating the expected and actual message
	public boolean checkMsg(String name) throws Exception {

		String popUpMessageTextExpectedforPOA = "-VPAS(R) UPDATE SUCCESSFUL";
		String actual = popUpMsg.getText();

		if (actual.equalsIgnoreCase(popUpMessageTextExpectedforPOA)) {
			excelWrite.writeInCell(
					 actual,
					"Pass");

			extent_Reportlogger(actual, "Perform Transaction" + name
					+ " Screen", "Pass");
			return true;

		} else {
			excelWrite.writeInCell(
					 actual,
					"Fail");

			extent_Reportlogger(actual,
					" work flow will not be Perform Transaction " + name
							+ " Screen", "Fail");

			return false;
		}
	}
		
	//Common method to verify the data status by validating the expected and actual message
	public boolean verifyStatus(String name) throws Exception {

		String Expected = "Data Successfully Updated in VPAS";
		String actual = expMsg.getText();

		if (actual.equalsIgnoreCase(Expected)) {
			excelWrite.writeInCell(
					 actual,
					"Pass");

			extent_Reportlogger(actual, "Perform Transaction" + name
					+ " Screen", "Pass");
			return true;

		} else {
			excelWrite.writeInCell(
					 actual,
					"Fail");

			extent_Reportlogger(actual,
					" work flow will  not be Perform Transaction " + name
							+ " Screen", "Fail");

			return false;
		}
	}
	
	
	//Method to modify bill ahead scenarios
	public void modify_BillAhead() throws Exception {
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			//clicking the bill voice button
			utility.click_On_Button(billVoiceButton);
			//Logging the logs in extent and excel
			extent_Reportlogger("bill voice button is clicked",
					"modify_BillAhead", "pass");
			excelWrite.writeInCell(
					"bill voice button is clicked", "pass");
			//scrolling down the page using java script executor
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,450)", "");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			//clicking on submit button
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//validating the expected and actual message using verifyStatus method
			verifyStatus("Bill Ahead");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//Clicking on submit button
			utility.click_On_Button(submit);

		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Execution failed",
					"performTransaction voiceScreen", "fail");
			excelWrite.writeInCell(
					"performTransaction voice Screen", "fail");
			ErrorLogger.logError(e.getClass().getName(), "performTransaction",
					e.getMessage());
			throw e;
		}

	}
	
	
	//Method to modify bill ahead scenarios
	public void modify_ReBill() throws Exception {
		try {
			radioInvoice.click();
			extent_Reportlogger(":Selected Successfully",
					"performTransac ReBill Invoice Screen", "pass");
			//Clicking the Invoice unpaid button
			utility.click_On_Button(unpaidInvoice);
			//Logging the logs in extent and excel
			extent_Reportlogger("bill unpaidInvoice button is clicked",
					"performTransaction ReBill Screen", "pass");
			excelWrite.writeInCell(
					"ReBill voice button is clicked", "pass");
			//System.out.println("done");
			//switching to frame
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			//Clicking on submit button
			utility.click_On_Button(newDone);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//validating the expected and actual message using checkStatus method
			checkStatus("ReBill");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//submit.sendKeys(Keys.ENTER);
			//Clicking on submit button
			utility.click_On_Button(submit);

		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Execution failed",
					"performTransaction ReBill Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction ReBill Screen", "fail");
			ErrorLogger.logError(e.getClass().getName(), "performTransaction",
					e.getMessage());
			throw e;
		}

	}

	public void modify_MailToEFT() throws Exception {

		try {
			//clicking on eft radio button
			utility.click_On_Button(eft);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//changing the frequency to Quarterly 
			utility.click_On_Button(quartely);
			//clicking on submit button
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			//Select New EFT details radio button
			utility.click_On_Button(newEftAcount);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//Entering the details like: ABA Number, Account Number, Account Type
			utility.enter_Text(abaNumber,
					reader.getMapData(CommonVariable.abaNumberr, map));
			utility.enter_Text(newAcountNumber,
					reader.getMapData(CommonVariable.accountNumber, map));
			utility.selectvalueByText_DropdownList(newAcountType,
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

			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			utility.enter_Text(newDom,
					reader.getMapData(CommonVariable.newDayOfMonth, map));
			extent_Reportlogger(" :Entered Successfully",
					"Entered MailToEFT day of Month", "pass");
			excelWrite.writeInCell(
					"New Day of Month entered= "
							+ reader.getMapData(CommonVariable.newDayOfMonth,
									map), "pass");
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			checkStatus("MailToEFT");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Execution failed",
					"performTransaction MailToEft Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction MailToEft Screen", "fail");
			ErrorLogger.logError(e.getClass().getName(), "performTransaction",
					e.getMessage());
			throw e;
		}

	}

	public void modify_EftToMail() throws Exception {
		
		try {
			utility.click_On_Button(mailing);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(payorOption, reader.getMapData(CommonVariable.payroptn, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			utility.click_On_Button(payorOptionUnInsured);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(addAlpa);
			utility.enter_Text(enter_FirstName,(reader.getMapData(CommonVariable.enter_FirstName, map )+Keys.TAB));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			System.out.println("Enter FN");
			utility.enter_Text(enter_LastName, (reader.getMapData(CommonVariable.enter_LastName, map)+Keys.TAB));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			/*excelWrite.writeInCell(
					
					"enter_UserPersonalDetailsSuccessfully", "Pass");
			extent_Reportlogger("enter_UserPersonalDetailsSuccessfully",
					"contact Change", "Pass");*/

			String ssN_Number = reader.getMapData(
					CommonVariable.enter_SSNNumber, map);

			String regex = "\\d{9}";

			if (ssN_Number.matches(regex)) {

				utility.enter_Text(
						enter_SSNNUmber,
						(reader.getMapData(CommonVariable.enter_SSNNumber, map) + Keys.TAB));
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.enter_Text(
						enter_BirthDate,
						(reader.getMapData(CommonVariable.enter_Birthdate, map) + Keys.TAB));
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				extent_Reportlogger(":Entered Successfully",
						"Enter_UserPersonalDetails screen", "PASS");
				excelWrite.writeInCell(
						"Enter_UserPersonalDetails Done ", "Pass");
			} else {

				System.out.println("User Entered wrong SSN 9 digitnumber!!!");
			}
			utility.click_On_Button(submitVpasbutton);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			checkMsg("EFT To Mail");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(close);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			System.out.println("befr scroll");
			addAlpa.sendKeys(Keys.TAB);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(subButton);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			utility.click_On_Button(beginningPeriod);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			checkStatus("Eft to MAil");
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		} catch (Exception e) {
			//Logging the logs in extent and excel
			extent_Reportlogger(" :Execution failed",
					"performTransaction EftToMail Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction EftToMail Screen", "fail");
			ErrorLogger.logError(e.getClass().getName(), "performTransaction",
					e.getMessage());
			e.printStackTrace();
		}

	}

}
