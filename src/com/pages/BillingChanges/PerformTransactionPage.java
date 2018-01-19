package com.pages.BillingChanges;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class PerformTransactionPage extends Initialize_Browser{
	
	
	
	public PerformTransactionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	BaseUtils utility = new BaseUtils(driver);

	@FindBy(id = "BillingChangeOptions")
	public WebElement selectBillingOptionChange;

	@FindBy(xpath = ".//*[@id='$PpyWorkPage$pCurrBillToDateSpan']/img")
	public WebElement calendarImage_1;

	@FindBy(className = "inactvIcon")
	public WebElement calendarImage;
	
	@FindBy(xpath="//button//div[text()='Change Payor']")
	WebElement chngePayor;
	
	@FindBy(id="sPolicyOwnerPolicy Owner")
	WebElement radioPolicyOwner;
	
	@FindBy(id="PolicyOwner")
	WebElement dropPolicyOwner;
	
	@FindBy(xpath="//button//div[text()='Submit To VPAS']")
	WebElement submitVpas;

	@FindBy(id = "CurrBillToDate")
	public WebElement billChangeDate_txtBox;

	//@FindBy(xpath = "//div[text()='Change Bill to Date']")
	@FindBy(name="BillToDateChanges_pyWorkPage_11")
	public WebElement changeBillToDate_btn;

	@FindBy(id = "NewBillToDate")
	public WebElement newBillToDate;

	@FindBy(xpath = "//*[@id='RULE_KEY']/div[3]/div/div/div[2]/div/div/div/div/div/div/div/span/button")
	public WebElement submitBillToDate_btn;

	//@FindBy(xpath = "//*[@id='RULE_KEY']/div[3]/div/div/div[1]/div/div/span/button")
	@FindBy(xpath="//button//div[text()='Close']")
	public WebElement close_btn;

	//@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div/div/div/span/button")
	@FindBy(xpath="//button//div[starts-with(text(),'Done')]")
	//@FindBy(xpath="//button//div[Starts With(text(),'Done Changes')]")
	public WebElement doneChanges;

	@FindBy(xpath = ".//*[@id='EXPAND-INNERDIV']/div/div[3]/div/div/span[2]")
	public WebElement status;
	
	@FindBy(xpath="//div[text()='Data Submitted Successfully']")
	public WebElement popText;
	
	@FindBy(xpath="//div[text()='Data Submitted Successfully']")
	//@FindBy(xpath=".//*[@id='RULE_KEY']/div[1]/div/div/div/div/div")
	WebElement popupText;
	
	@FindBy(id = "NewDOM")
	public WebElement newDOM;
	
	@FindBy(xpath="//button//div[text()='Submit Day Of Month']")
	WebElement submitDayMonth_btn;
	
	@FindBy(id="AmountDue")
	WebElement amount;
	
	@FindBy(id="RePrintInd")
	WebElement reprint;
	
	//@FindBy(xpath="button//div[contains(text(),'Submit')]")
	//@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]") //correct
	@FindBy(xpath="//div[@class='layout-body clearfix']//div[@class='pzbtn-mid'][contains(.,'Submit')]") //trial
	WebElement submit;
	
	@FindBy(xpath="//button//div[text()='Add New']")
	WebElement addNew;
	
	@FindBy(id="BillingType")
	WebElement billingType;
	
	@FindBy(id="NewAccountType")
	WebElement newAccountType;
	
	@FindBy(id="BillingElectEffDate")
	WebElement billingEffectiveDate;
	
	@FindBy(xpath="//*[@id='RULE_KEY']/div[3]/div/div/div/div/div/span/button")
	WebElement addNew1;
	
	@FindBy(id="NewBillElecType")
	WebElement billingElecType;
	
	@FindBy(id="NewBillCompType")
	WebElement billingCompType;
	
	@FindBy(id="PaymentOrder")
	WebElement paymentOrder;
	
	@FindBy(id="EffDate")
	WebElement EffDate;
	
	@FindBy(xpath="(.//*[@id='EffDate'])[2]")
	WebElement domEffDate;
	
	@FindBy(id="LoanRepayAmt")
	WebElement loanpayAmnt;
	
	@FindBy(xpath="//button//div[text()='Change Method/Frequency']")
	WebElement changeMethod_Freq;
	
	@FindBy(id="PaymentMethodE")
	WebElement eft;
	
	@FindBy(id="PaymentMethodM")
	WebElement mailing;
	
	@FindBy(xpath="//button//div[text()='Add New Account']")
	WebElement addNewAccount;
	
	@FindBy(id="NewABANumber")
	WebElement abaNumber;
	
	@FindBy(id="NewAccountNumber")
	WebElement newAccntNumber;
	
	@FindBy(id="NewAccountType")
	WebElement accountType;
	
	@FindBy(xpath="//button//div[text()='Update EFT Account']")
	WebElement updateAccount;
	
	@FindBy(xpath="//button//div[text()='Change Payor']")
	WebElement payrChnge;
	
	@FindBy(id="IsPolicyOwnerPolicy Owner")
	WebElement payrOwner;
	
	@FindBy(id="PolicyOwner")
	WebElement policyOwner;
	
	@FindBy(id="BillingStatusOption")
	WebElement billingStatus;
	
	@FindBy(id="ReasCode")
	WebElement reasonCode;
	
	@FindBy(id="EndDate")
	WebElement endDatee;
	
	@FindBy(id="NoOfBillCycles")
	WebElement noOfBillCycle;
	
	@FindBy(xpath="//button//div[text()='Changed planned premium']")
	WebElement planedButton;

	@FindBy(id="NewModalPremium")
	WebElement enterNewModal;
	
	@FindBy(id="AddressLine1")
	WebElement mailAddLine1;
	
	@FindBy(id="AddressLine2")
	WebElement mailAddLine2;
	
	@FindBy(id="AddressLine3")
	WebElement mailAddLine3;
	
	@FindBy(id="AddressLine4")
	WebElement mailAddLine4;
	
	@FindBy(id="AddressCountry")
	WebElement mailAddcountry;
	
	@FindBy(id="AddressCity")
	WebElement mailAddcity;
	
	@FindBy(id="AddressState")
	WebElement mailAddstate;
	
	@FindBy(id="AddressZip")
	WebElement mailAddzipcode;
	
	@FindBy(xpath="//button//div[text()='Update Mailing Address']")
	WebElement updateAddress;
	
	@FindBy(xpath="//table[@pl_prop='.BillingMntInfo']//tbody")
	WebElement tabl;
	
	
	
	
	
	
	
	public boolean verifyPopUp(String name) throws Exception {

		String actual = "Data Submitted Successfully";
		String expected = popText.getText();
		//System.out.println(actual+">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+expected+">>>>>>expected value");
		
			if (actual.equalsIgnoreCase(expected)) {
				extent_Reportlogger(" :Data Submitted Successfully",
						"performTransaction"+ name +"Screen", "pass");
				excelWrite.writeInCell(
						"Data Submitted Successfully", "Pass");
				return true;
			}

		else {
			extent_Reportlogger(" :Data is not Submitted Successfully",
					"performTransaction"+ name +" Screen", "fail");
			excelWrite.writeInCell(
					"Data is not Submitted Successfully", "fail");
			return false;
		}
		}
	
	public boolean verifyPopup(String name) throws Exception {

		String actual = "Data Submited Successfully";
		String expected = popupText.getText();
		//System.out.println(actual+">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+expected+">>>>>>expected value");
		if (actual.equalsIgnoreCase(expected)) {
			extent_Reportlogger(" :Data is Submited Successfully",
					"performTransaction" + name + "Screen", "pass");
			excelWrite.writeInCell(
			"Data is Submited Successfully", "Pass");
			return true;

		} else {
			extent_Reportlogger(":Data is not Submited Successfully",
					"performTransaction"+ name +" Screen", "fail");
			excelWrite.writeInCell(
					"Data is Submited not Successfully", "fail");
			return false;
		}
		}
		

	
	
	public void modifyBill_ToDate() throws Exception {

		try {
			utility.click_On_Button(changeBillToDate_btn);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.enter_Text(newBillToDate,
					reader.getMapData(CommonVariable.newBillToDate, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(submitBillToDate_btn);
			extent_Reportlogger(
					 ": Bill date entered successfully",
					"performTransaction BillDate Screen", "pass");
			excelWrite.writeInCell(
					reader.getMapData(CommonVariable.newBillToDate, map)
							+ ": Bill date entered", "Pass");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			Assert.assertTrue(verifyPopUp("Bill Date"), "Entered date validation");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(close_btn);

		} catch (InterruptedException e) {
			extent_Reportlogger(":Execution failed",
					"performTransaction bill date Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction bil date Screen", "fail");
			throw e;
		}

	}
	
	
	public void modifyDate_OfMonth() throws Exception{
		try {
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		domEffDate.clear();	
		utility.enter_Text(domEffDate, reader.getMapData(CommonVariable.effectiveDate, map));	
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		/*extent_Reportlogger(
				reader.getMapData(CommonVariable.effectiveDate, map)
						+ ":DOM Effective date entered",
				"performTransaction DOM Screen", "pass");
		excelWrite.writeInCell(
				reader.getMapData(CommonVariable.effectiveDate, map)
						+ ":Date Of Month Effective date entered", "pass");*/
		utility.enter_Text(newDOM,reader.getMapData(CommonVariable.newDayOfMonth, map));
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		extent_Reportlogger(": Entered successfully",
				"performTransaction DOM Screen", "pass");
		excelWrite.writeInCell(
				reader.getMapData(CommonVariable.effectiveDate, map)
				+ ":DOM Effective date entered"+
				reader.getMapData(CommonVariable.newDayOfMonth, map)
						+ ": New day of month entered", "pass");
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		//newDOM.sendKeys(Keys.TAB);
		//System.out.println("after tab");
		//submitDayMonth_btn.sendKeys(Keys.ENTER);
		//System.out.println("after tab enter");
		//utility.click_On_Button(submitDayMonth_btn);
		utility.click_On_Button(submit);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-450)", "");
		extent_Reportlogger(":Button clicked",
				"performTransaction DOM Screen", "pass");
		//System.out.println("after tab enter button");
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		//Change not allowed. New Day Of Month may not match the current Day Of Month.
		} catch (InterruptedException e) {
			extent_Reportlogger(" :Execution failed",
					"performTransaction DOM Screen", "fail");
			excelWrite.writeInCell(
					
					"performTransaction Screen", "fail");
			throw e;
		}
	}
	
	public void modifyManual_Bill() throws Exception {

		try {
			
			utility.enter_Text(amount,
					reader.getMapData(CommonVariable.amount, map));
			extent_Reportlogger(
					reader.getMapData(CommonVariable.amount, map)
							+ ":Manual bill Amount entered",
					"performTransaction Manual bill Screen", "pass");
			excelWrite.writeInCell(
					
					reader.getMapData(CommonVariable.amount, map)
							+ ":Manual bill Amount entered", "pass");
			reprint.click();
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,450)", "");
			//Assert.assertTrue(verifyPopUp(), "Entered date validation");
			////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger("performTransaction Manual Bill failed",
					"performTransaction Manual bill Screen", "fail");
			excelWrite.writeInCell(
					
					"performTransaction Manual Bill Screen", "fail");
			throw e;
		}

	}
	
	public void modifyBilling_Elections() throws Exception{

		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			System.out.println("befr add new");
			//addNew.click();
			utility.click_On_Button(addNew);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(billingEffectiveDate, reader.getMapData(CommonVariable.effectiveDate, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(billingType, reader.getMapData(CommonVariable.billingTyp, map));
			extent_Reportlogger(" :Entered Successfully",
					"performTransaction billing_Elections Screen", "pass");
			excelWrite.writeInCell(
					reader.getMapData(CommonVariable.effectiveDate, map)+" :Effective date entered"+
					reader.getMapData(CommonVariable.billingTyp, map)
							+ " :billing type selected", "pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			/*utility.click_On_Button(submit);
			//submit.click();
			utility.click_On_Button(submit);
			utility.click_On_Button(submit);*/
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			Assert.assertTrue(verifyPopUp("Billing elections"), "Entered date validation");

		//	System.out.println("after sub,it");
			utility.click_On_Button(close_btn);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			selectField();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,350)", "");
			
			driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div[3]/div/div/div/div/div/span/button")).click();
			//utility.click_On_Button(addNew);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(billingElecType, reader.getMapData(CommonVariable.electionType, map));
			utility.selectvalueByText_DropdownList(billingCompType, reader.getMapData(CommonVariable.compType, map));
			utility.enter_Text(paymentOrder, reader.getMapData(CommonVariable.paymentOrder, map));
			extent_Reportlogger(" :Entered Successfully",
					"performTransac billing_Elections Screen", "pass");
			excelWrite.writeInCell(
					reader.getMapData(CommonVariable.paymentOrder, map)+" :payment order entered"+
					reader.getMapData(CommonVariable.electionType, map)
							+ " :election type selected"+reader.getMapData(CommonVariable.compType, map)
							+ " :comp type selected", "pass");
			
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			//Assert.assertTrue(verifyPopUp("Billing elections"), "validation is done successfully");
			utility.click_On_Button(close_btn);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
		} catch (Exception e) {
			extent_Reportlogger("performTransaction failed",
					"performTransaction Screen", "fail");
			excelWrite.writeInCell(
					
					"performTransaction Screen", "fail");
			e.printStackTrace();
		}

	}
	
	public void selectField() throws Exception{
		try
		{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		//List<WebElement>l=driver.findElements(By.xpath("(.//*[@id='gridLayoutTable'])[1]//tbody//tr"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		
		//code to extract data from table
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
		//table[@ pl_prop='.BillingMntInfo']//tbody//tr[2]//td[1]
		//System.out.println("dcsacd");
		List<WebElement> rows =tabl.findElements(By.tagName("tr"));
	//	List<WebElement> cols =tabl.findElements(By.tagName("td"));
		int countRows = rows.size();
	//	int countCols = cols.size();
	
		//System.out.println(countRows+"Gfg"+ countCols);
		 for (int a = 2; a <= countRows; a++) {
			//for (int b = 1; b <= 2; b++) {
		
		
		String datevalue=driver.findElement(By.xpath("//table[@pl_prop='.BillingMntInfo']//tbody//tr["+ a + "]//td[1]")).getText();
		
		String billingTypevalue=	driver.findElement(By.xpath("//table[@pl_prop='.BillingMntInfo']//tbody//tr["+ a + "]//td[2]")).getText();
		//System.out.println(datevalue+">>>>>>"+billingTypevalue+">>>>>>"+a);
		
				String excelDate = reader.getMapData(
						CommonVariable.effectiveDate, map);
				String excelType = reader.getMapData(CommonVariable.billingTyp,
						map);

				// System.out.println(datevalue+">>>>>>"+excelDate+"dateeeeeeeeeeeeeeeeeeee"+billingTypevalue+">>>>>>"+excelType);
				if (datevalue.equalsIgnoreCase(excelDate)
						&& billingTypevalue.equalsIgnoreCase(excelType)) {
					// System.out.println("inside if equals");
					driver.findElement(
							By.xpath("//table[@pl_prop='.BillingMntInfo']//tbody//tr["
									+ a + "]//td[1]")).click();
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8,TimeUnit.SECONDS));
					// jse.executeScript("window.scrollBy(0,350)", "");
					break;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void modifyLoan_Bill() throws Exception{

		try {
			
			utility.click_On_Button(addNew);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(EffDate, reader.getMapData(CommonVariable.effectiveDate, map));
			extent_Reportlogger(
					reader.getMapData(CommonVariable.effectiveDate, map)
							+ ":Loan Effective date entered",
					"performTransaction loan Screen", "pass");
			excelWrite.writeInCell(
					
					reader.getMapData(CommonVariable.effectiveDate, map)
							+ ":Loan Effective date entered", "pass");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(loanpayAmnt, reader.getMapData(CommonVariable.amount, map));
			extent_Reportlogger(
					reader.getMapData(CommonVariable.amount, map)
							+ ":Loan Amount entered",
					"performTransac Loan Screen", "pass");
			excelWrite.writeInCell(
					reader.getMapData(CommonVariable.amount, map)
							+ ":Loan Amount entered", "pass");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			Assert.assertTrue(verifyPopUp("Loan Bill"), "Entered date validation");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(close_btn);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger("performTransaction failed",
					"performTransaction Loan Screen", "fail");
			excelWrite.writeInCell(
					
					"performTransaction Loan Screen", "fail");
			throw e;
		}

	}
	
	public void modifyBillingChange_MailToEFT() throws Exception{

		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(changeMethod_Freq);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(eft);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			utility.click_On_Button(addNewAccount);
			utility.enter_Text(abaNumber, reader.getMapData(CommonVariable.abaNumberr, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(newAccntNumber, reader.getMapData(CommonVariable.accountNumber, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(newAccountType, reader.getMapData(CommonVariable.accounttype, map));
			
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
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			Assert.assertTrue(verifyPopUp("MailTo EFT"), "Entered date validation");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(close_btn);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			
		} catch (Exception e) {
			extent_Reportlogger("performTransaction failed",
					"performTransaction MailTo EFT Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction MailTo EFT"
					+ "Screen", "fail");
			throw e;
		}

	}
	
	public void modifyBillingChange_EFTToMail() throws Exception{
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			utility.click_On_Button(changeMethod_Freq);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(mailing);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			
			
			if (!(reader.getMapData(CommonVariable.edit_addressLine1,map) == null || reader.getMapData(CommonVariable.edit_addressLine1,map) == "")) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				mailAddLine1.clear();
				utility.enter_Text(mailAddLine1,
						reader.getMapData(CommonVariable.edit_addressLine1,map));
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			}
			////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			if (!(reader.getMapData(CommonVariable.edit_addressLine2,map) == null || reader.getMapData(CommonVariable.edit_addressLine2,map) == "")) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				mailAddLine2.clear();
				utility.enter_Text(mailAddLine2,
						reader.getMapData(CommonVariable.edit_addressLine2,map));
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			}
			if (!(reader.getMapData(CommonVariable.edit_addressLine3,map) == null || reader.getMapData(CommonVariable.edit_addressLine3,map) == "")) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				mailAddLine3.clear();
				utility.enter_Text(mailAddLine3,
						reader.getMapData(CommonVariable.edit_addressLine3,map));
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			}
			if (!(reader.getMapData(CommonVariable.edit_addressLine4,map) == null || reader.getMapData(CommonVariable.edit_addressLine4,map) == "")) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				mailAddLine4.clear();
				utility.enter_Text(mailAddLine4,
						reader.getMapData(CommonVariable.edit_addressLine4,map));
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			}
			

			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			utility.selectvalueByText_DropdownList(mailAddstate,
					reader.getMapData(CommonVariable.edit_State,map));
			
			utility.selectvalueByText_DropdownList(
					mailAddcountry,
					reader.getMapData(CommonVariable.edit_Country,map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			mailAddcity.clear();
			utility.enter_Text(mailAddcity,
					reader.getMapData(CommonVariable.edit_City,map));
			
			if (!(CommonVariable.edit_ZipCode == null || CommonVariable.edit_ZipCode == "")) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				mailAddzipcode.clear();
				String zip_Code = reader.getMapData(CommonVariable.edit_ZipCode,map);
				System.out.println(zip_Code);
				String regex = "\\d{5}";
				if (zip_Code.matches(regex)) {
					utility.enter_Text(mailAddzipcode, zip_Code);
				} else {
					excelWrite.writeInCell(
							"Invalid Zip Code: ZIP code should be 5 digit numeric - "
									+ zip_Code, "Fail");
					ErrorLogger
							.logError("CSWD_Resuablefunction_AddressChange",
									"checkAddressData_copy_Existing",
									"Invalid Zip Code: ZIP code should be 5 digit numeric");

				}
			
			}
			
			System.out.println("befr shot");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			extent_Reportlogger("Entered details",
					"performTransc address EFTToMail Screen", "pass");
			excelWrite.writeInCell("Entered details successfully", "pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			utility.click_On_Button(updateAddress);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,350)", "");
			utility.click_On_Button(doneChanges);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(15, TimeUnit.SECONDS));
			jse.executeScript("window.scrollBy(0,350)", "");
			utility.click_On_Button(submit);
		} catch (Exception e) {
			extent_Reportlogger("Executed failed",
					"perfrmTransaction EFTToMail Screen", "fail");
			excelWrite.writeInCell(
					"perfrmTransaction EFTToMail Screen", "fail");
			throw e;
		}
		
		
		
	}
	
	public void modify_payorChange() throws Exception{
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,350)", "");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(payrChnge);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(payrOwner);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			Select sel=new Select(policyOwner);
			sel.selectByIndex(1);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			extent_Reportlogger(":Entered details successfully",
					"performTransac payor Screen", "pass");
			excelWrite.writeInCell("Entered details successfully", "pass");
			utility.click_On_Button(submitVpas);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			verifyPopUp("Payor");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger(" :Execution failed",
					"performTransaction payor Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction payor Screen", "fail");
			throw e;
		}
	}

	
	
	
	public void modify_PlannedPremium() throws Exception{
		
		try {
			System.out.println("in method");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			utility.click_On_Button(planedButton);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.enter_Text(enterNewModal, reader.getMapData(CommonVariable.newModalPremium, map));
			extent_Reportlogger(":Entered details successfully",
					"performTransac PlannedPremium Screen", "pass");
			excelWrite.writeInCell(reader.getMapData(CommonVariable.newModalPremium, map)+": Premium entered successfully", "pass");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			verifyPopUp("Planned Premium");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
			utility.click_On_Button(close_btn);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger(":Execuiton failed",
					"performTransaction PlannedPremium Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction Screen", "fail");
			ErrorLogger.logError(e.getClass().getName(),
					"modify_PlannedPremium", e.getMessage());
			throw e;
		}
		
	}
	
	
	public void modify_billingToCancel() throws Exception {
		
		try {
			utility.selectvalueByText_DropdownList(billingStatus,
					reader.getMapData(CommonVariable.bilingStatus, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(reasonCode,
					reader.getMapData(CommonVariable.resnCode, map));
			extent_Reportlogger(":Entered details successfully",
					"performTransac billingToCancel Screen", "pass");
			excelWrite.writeInCell(reader.getMapData(CommonVariable.resnCode, map)+":entered successfully", "pass");
		
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			reasonCode.sendKeys(Keys.TAB);
			utility.click_On_Button(submit);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
		} catch (Exception e) {
			extent_Reportlogger("performTransaction failed",
					"performTransaction billingToCancel Screen", "fail");
			excelWrite.writeInCell(
					"performTransaction Screen", "fail");
			ErrorLogger.logError(e.getClass().getName(),
					"modify_billingToCancel", e.getMessage());
			throw e;
			
		}

	}


	public void modify_billingToSuspend() throws Exception{
		try {
			utility.selectvalueByText_DropdownList(billingStatus, reader.getMapData(CommonVariable.bilingStatus, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(reasonCode, reader.getMapData(CommonVariable.resnCode, map));
			utility.enter_Text(endDatee, reader.getMapData(CommonVariable.endDate, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.enter_Text(noOfBillCycle, reader.getMapData(CommonVariable.noBillCycle, map));
			extent_Reportlogger(":Entered details successfully",
					"performTransac billingToSuspend Screen", "pass");
			excelWrite
					.writeInCell(
							reader.getMapData(CommonVariable.bilingStatus, map)
									+ ":selected successfully"
									+ reader.getMapData(
											CommonVariable.resnCode, map)
									+ ":selected successfully"
									+ reader.getMapData(CommonVariable.endDate,
											map)
									+ ":entered successfully"
									+ reader.getMapData(
											CommonVariable.noBillCycle, map)
									+ ":entered successfully", "pass");

			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			Actions actions = new Actions(driver);
			actions.moveToElement(submit).click().build().perform();
		
			//utility.click_On_Button(submit);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger(":Execution failed",
					"performTransaction billingToSuspend Screen", "fail");
			excelWrite.writeInCell(
					
					"performTransaction Screen", "fail");
			throw e;
		}
		
	}


	public void modify_CancelToResume() throws Exception{
		try {
			utility.selectvalueByText_DropdownList(billingStatus, reader.getMapData(CommonVariable.bilingStatus, map));
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(reasonCode, reader.getMapData(CommonVariable.resnCode, map));
			extent_Reportlogger(":Entered details successfully",
					"performTransac CancelToResume Screen", "pass");
			excelWrite
					.writeInCell(
							reader.getMapData(CommonVariable.bilingStatus, map)
									+ ":selected successfully"
									+ reader.getMapData(
											CommonVariable.resnCode, map)
									+ ":selected successfully"
									, "pass");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			reasonCode.sendKeys(Keys.TAB);
			utility.click_On_Button(submit);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			utility.click_On_Button(submit);
		} catch (Exception e) {
			extent_Reportlogger(":Execution failed",
					"performTransaction CancelToResume Screen", "fail");
			excelWrite.writeInCell(
					
					"performTransaction Screen", "fail");
			throw e;
		}
		
	}

	
	
	
}
