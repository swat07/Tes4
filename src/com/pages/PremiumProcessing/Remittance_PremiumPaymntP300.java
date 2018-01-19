package com.pages.PremiumProcessing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.pages.AddressChangeScreens.CSWD_GoodOrderCheckPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class Remittance_PremiumPaymntP300 extends Test_BaseClass {

	
	

	public Remittance_PremiumPaymntP300(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	
	
	
	
	@FindBy(id = "Owner Change")
	public WebElement OwnerChange;
	
	
	
	@FindBy(id = "Response1")
	public WebElement select_Payment_drpdwn;

	
	@FindBy(id = "Finding1")
	public WebElement Select_Remitdrpdwn;
	
	
	@FindBy(id = "Finding2")
	public WebElement Select_AutoRin;
	
	@FindBy(id = "submitButton")
	public WebElement submitProcessTask_Btn;
	
	@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
	public WebElement validateMessagesTable;
	
	@FindBy(xpath=".//*[@id='$PpyWorkPage$pRemittanceList$l10']/td[5]")
	public WebElement review_Zerovalue;
	
	
	

	
	
	@FindBy(id = "InterestAmt")
	public WebElement entert_InterestAmt;
	
	@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Event Details']")
	public WebElement EventDetails;
	
	
	@FindBy(id = "GenConfirm")
	public WebElement Select_GenConfirm;
	
	
	
	@FindBy(id = "pyTemplateCheckbox")
	public WebElement Select_pyTemplateCheckbox;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate Input')]")
	public WebElement click_ValidateInput;
	
	@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Add Bill']")
	public WebElement click_AddBill;
	
	
	@FindBy(xpath = "//table[@pl_prop='MCRemitEvent.BillList']//tr[2]//td[1]//input[@type='radio']")
	public WebElement select_insured;
	
	@FindBy(id = "PmtAmt")
	public WebElement Select_PmtAmt;
	
	
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement click_Validate;
	
	@FindBy(xpath=".//*[@id='RULE_KEY']/table/tbody/tr/td[1]/nobr/label")
	public WebElement review_ValidationMsz;
	
	@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
	public WebElement validateMessagesTable1;
	
	@FindBy(xpath = "//*[@id='HarnessFooter']//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement validateInput_Close_Btn;

	@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
	public WebElement review_ValidationMsz1;
	
	@FindBy(xpath = "//*[@id='RULE_KEY']/table/tbody/tr[1]/td[2]/nobr/label")
	public WebElement Select_validationmsg;
	
	@FindBy(xpath="//table[@id='bodyTbl_right']//tbody//tr")
	public WebElement rows;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
	public WebElement validateSubmit_Btn;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Save Event')]")
	public WebElement click_EventSubmitbtn;
	
	@FindBy(xpath = "//button[text() = '  Done ']")
	public WebElement eventConfirmation_DoneButton;
	
	@FindBy(id = "submitButton")
	public WebElement newSubmit;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Cancel')]")
	public WebElement clickCancel_Btn;
	
	@FindBy(xpath = "//table[@id='bodyTbl_right']//tr[2]//td[2]")
	public WebElement  eventConfirmTable;
	
	@FindBy(id = "LoanAmt")
	public WebElement Select_LoanAmt;
	
	public void processPremiumTasks() throws Exception {
		try {

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			System.out.println("inside frame");

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			if ((Select_Remitdrpdwn != null || Select_Remitdrpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.Select_Remitdrp, map)) != null)) {
				utility.select_DropdownList(
						Select_Remitdrpdwn,
						reader.getMapData(CommonVariable.Select_Remitdrp, map));

			}

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			if ((select_Payment_drpdwn != null || select_Payment_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.select_Paymentdrp, map)) != null)) {
				utility.select_DropdownList(
						select_Payment_drpdwn,
						reader.getMapData(CommonVariable.select_Paymentdrp, map));
			}

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			submitProcessTask_Btn.click();

			extent_Reportlogger("DoneprocessPremiumTasks", "processPremiumTasks", "PASS");
			excelWrite.writeInCell(
					"DoneprocessPremiumTasks", "Pass");
			
			
		} catch (Exception e) {
			
			extent_Reportlogger("processPremiumTasks", "processPremiumTasks", "FAIL");
			excelWrite.writeInCell(
					"processPremiumTasks", "FAIL");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public void processPremiumTasksTC6() throws Exception {
		try {

			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			


			if ((Select_Remitdrpdwn != null || Select_Remitdrpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.Select_Remitdrp, map)) != null)) {
				utility.select_DropdownList(
						Select_Remitdrpdwn,
						reader.getMapData(CommonVariable.Select_Remitdrp, map));
				String Select_Remitdrp = reader.getMapData(CommonVariable.Select_Remitdrp, map);
				extent_Reportlogger(":Test Step Executed Successfully " +Select_Remitdrp, "Select_Remitdrpdown", "PASS");
				excelWrite.writeInCell("Select_AdminChecklist Test Step Executed Successfully: = " + Select_Remitdrp, "Pass");

			}

		

			if ((select_Payment_drpdwn != null || select_Payment_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.select_Paymentdrp, map)) != null)) {
				utility.select_DropdownList(
						select_Payment_drpdwn,
						reader.getMapData(CommonVariable.select_Paymentdrp, map));
				String Select_Remitdrp = reader.getMapData(CommonVariable.select_Paymentdrp, map);
				extent_Reportlogger(":Test Step Executed Successfully " +Select_Remitdrp, "Select_Remitdrpdown", "PASS");
				excelWrite.writeInCell("Select_AdminChecklist Test Step Executed Successfully: = " + Select_Remitdrp, "Pass");
			}

			

			if ((Select_AutoRin != null || Select_AutoRin
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.selectAutoRein, map)) != null)) {
				utility.select_DropdownList(
						Select_AutoRin,
						reader.getMapData(CommonVariable.selectAutoRein, map));
				String Select_Remitdrp = reader.getMapData(CommonVariable.selectAutoRein, map);
				extent_Reportlogger(":Test Step Executed Successfully " +Select_Remitdrp, "Select_Remitdrpdown", "PASS");
				excelWrite.writeInCell("Select_AdminChecklist Test Step Executed Successfully: = " + Select_Remitdrp, "Pass");
			}

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			submitProcessTask_Btn.click();

			extent_Reportlogger("DoneprocessPremiumTasks", "processPremiumTasks", "PASS");
			excelWrite.writeInCell(
					"DoneprocessPremiumTasks", "Pass");
			
			
		} catch (Exception e) {
			
			extent_Reportlogger("processPremiumTasks", "processPremiumTasks", "FAIL");
			excelWrite.writeInCell(
					"processPremiumTasks", "FAIL");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	public void select_AmountRemaining()
			throws Exception
			{
		try 
		{
			Thread.sleep(5000);
			WebElement wb=driver.findElement(By.xpath("//table[@pl_prop='.RemittanceList']"));
			List<WebElement> elements=wb.findElements(By.tagName("tr"));
			System.out.println("no of rows: "+ elements.size());
			
			List<WebElement> rows = validateMessagesTable
					.findElements(By.tagName("tr"));
			
			/*String reviewValue="";
			
			reviewValue=review_Zerovalue.getText();*/
			
			String value = "";
			String zeroValue = "$0.00";
			int countRows = rows.size();
			
			 for (int i = 2; i <= countRows; i++) {
				

					System.out.println("entering into loop");
					value = driver.findElement(By.xpath("//table[@pl_prop='.RemittanceList']//tbody//tr["+ i + "]//td[4]")).getText();
					System.out.println("table value " + value);
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		
				if ((value != zeroValue || !value.isEmpty()))
						{
					System.out.println("Value is not zero");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					driver.findElement(By.xpath("//table[@pl_prop='.RemittanceList']//tbody//tr["+ i + "]//td[4]")).click();
					break ;
						}
				else {
					System.out.println("exit");
				}
			
				
			 }
		
				extent_Reportlogger(":Test Step Executed Successfully", "select_AmountRemaining", "PASS");
				excelWrite.writeInCell(
						"select_AmountRemaining Test Step Executed Successfully", "Pass");
				
				
			} catch (Exception e) {
				
				extent_Reportlogger(":Test Step Executed UnSuccessfully", "select_AmountRemaining", "FAIL");
				excelWrite.writeInCell(
						"select_AmountRemaining Test Step Executed UnSuccessfully", "FAIL");
				e.printStackTrace();
				throw e;
			}
			
		}
	public void perform_EventdetailsTask () throws Exception {
		try {

			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.click_On_Button(Select_GenConfirm);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.click_On_Button(Select_pyTemplateCheckbox);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.click_On_Button(click_ValidateInput);
			
			extent_Reportlogger(":Test Step Executed Successfully", "click_ValidateInput", "PASS");
			
			excelWrite.writeInCell(
					"clickOnValidateInput Test Step Executed Successfully", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			utility.click_On_Button(click_AddBill);
	
			extent_Reportlogger(":Test Step Executed Successfully", "clickOnAddBill", "PASS");
			excelWrite.writeInCell(
					"click_AddBill Test Step Executed Successfully", "Pass");
			
			utility.click_On_Button(select_insured);
		
		
	
			extent_Reportlogger(":Test Step Executed Successfully", "perform_EventdetailsTask", "PASS");
			excelWrite.writeInCell(
					"perform_EventdetailsTask Test Step Executed Successfully", "Pass");
	
		} catch (Exception e) {
			
			extent_Reportlogger("perform_EventdetailsTask", "perform_EventdetailsTask", "FAIL");
			excelWrite.writeInCell(
					"perform_EventdetailsTask", "FAIL");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	
	public void ToVerifyValidationMsg() throws Exception{
		
		try{
			
			excelWrite.writeInCell(
					"Validation button Click Test Step is Executed Successfully", "Pass");
			extent_Reportlogger(": Test Step Excuted Successfully", "Validation button Click", "Pass");
		
			
			//Code for Validation Window Handle
			
			//Code for Validation Window Handle
			ArrayList<String> validationlist = new ArrayList<String>();
			
			String value1 = "";
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			String value = "";
			String mainwindow = "";
			mainwindow = driver.getWindowHandle();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			String parentwindow = driver.getWindowHandle();
			System.out.println("Before switching " + driver.getTitle());
			
			Set<String> s1 = driver.getWindowHandles();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			Iterator<String> i1	=s1.iterator();
			while (i1.hasNext()){
				String child_window = i1.next();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				System.out.println("value" +child_window);
				if (!parentwindow.equalsIgnoreCase(child_window)){
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
					driver.switchTo().window(child_window);
					((JavascriptExecutor)driver).executeScript("window.focus();");
//					driver.manage().window().setPosition(new Point(2000, 500));
					System.out.println( "After switching" +driver.getTitle());
					break;
				
				
				}
			}
				
				
			driver.manage().window().maximize();
			
			/*excelWrite.writeInCell(
					"Moved_ToValidation_Window Test Step Executed Successfully", "Pass");
			extent_Reportlogger(":Test Step Executed Successfully", "Moved_ToValidation_Window", "Pass");
		*/
			
			
			if (utility.isWebElementExist(review_ValidationMsz1))
			{
				

				List<WebElement> rows = validateMessagesTable
						.findElements(By.tagName("tr"));
				List<WebElement> cols = validateMessagesTable
						.findElements(By.tagName("td"));
				int countRows = rows.size();
				int countCols = cols.size();
				System.out.println("inside table");
				System.out.println(countRows + countCols);
				outerLoop: for (int i = 2; i <= countRows; i++) {
					for (int j = 3; j <= 5; j++) {

						if (rowsExist(i, j)) {
							System.out.println("entering");

							value = driver
									.findElement(
											By.xpath("//table[@id='bodyTbl_right']//tbody//tr["
													+ i + "]//td[" + j + "]"))
									.getText();

							System.out.println("table value" + value);
							validationlist.add(value);

						} else {
							System.out.println("exit");
							break outerLoop;
						}
					}
				}
			

			if (validationlist.contains("Fatal") || validationlist.contains("Stop")) {

				System.out.println("Inside Fatal");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				
				String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
				
				extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
				excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
				

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				validateInput_Close_Btn.click();
								
				driver.switchTo().window(parentwindow);
				System.out.println("Switch to parent window "
						+ driver.switchTo().window(parentwindow).getTitle());
			
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				clickCancel_Btn.click();

				extent_Reportlogger("FatalErrorSubmitButtonisDisabled ",
						"InsideFatalErrorSubmitButtonisDisabled", "PASS");
				
					excelWrite.writeInCell(
							"InsideFatalErrorSubmitButtonisDisabled", "Pass");

			}
			
			if (validationlist.contains("Warning") || (validationlist.contains("Info")))
			{
				System.out.println("inside Info");
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
				
				extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
				excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				validateInput_Close_Btn.click();
			
				
				driver.switchTo().window(parentwindow);
				System.out.println("Switch to parent window "
						+ driver.switchTo().window(parentwindow).getTitle());
			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				click_EventSubmitbtn.click();
			
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				Actions actions = new Actions(driver);
				actions.moveToElement(validateSubmit_Btn).click()
						.perform();
				excelWrite.writeInCell(
						"Test Step Executed Successfully : validateSubmit_Btn", "Pass");
				extent_Reportlogger(" :Test Step Executed Successfully", "validateSubmit_Btn", "Pass");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				verify_PermEventCodeforSurrender("PremiumProcessing", reader.getMapData(CommonVariable.selectEventCode, map));
				System.out.println("Event code Value" + reader.getMapData(CommonVariable.selectEventCode, map));
				
			
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
				
				excelWrite.writeInCell(
						"InfoMszVerifyDone", "Pass");
				extent_Reportlogger("InfoMszVerifyDone", "InfoMszVerifyDone", "Pass");
				
				
				
			}
				
			}
		
			else if (utility.isWebElementExist(Select_validationmsg))
			{

				System.out.println("Inside Select_validationmsg ");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				String validationmsgactual=Select_validationmsg.getText();
				System.out.println("Status expected: "+reader.getMapData(CommonVariable.validation_msg, map));
				System.out.println("Status Actual:" +validationmsgactual);
			
				
			 if(validationmsgactual.equals(reader.getMapData(CommonVariable.validation_msg, map)))
				 
				 
			 {
				 extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+validationmsgactual, "ValidationMessages_Verification", "PASS");
					excelWrite.writeInCell("ValidationMessages_Verification Test Step Execution Successfull: Message Severity is "+validationmsgactual, "PASS");
				
					validateInput_Close_Btn.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
				 /*excelWrite.writeInCell(
							"Test Step Executed Successfully: Click on Close Button", "Pass");
					extent_Reportlogger(":Test Step Executed Successfully ", "Click on Close Button", "Pass");
			*/
				
			
			 }
				
		
			driver.switchTo().window(parentwindow);
			System.out.println("Switch to parent window "
					+ driver.switchTo().window(parentwindow).getTitle());
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			
			Actions actions = new Actions(driver);

			actions.moveToElement(
					click_EventSubmitbtn).click()
					.perform();
			
			//utility.click_On_Button(click_EventSubmitbtn);
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			//utility.click_On_Button(click_EventSubmitbtn);
			//click_EventSubmitbtn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			validateSubmit_Btn.click();
			
			excelWrite.writeInCell(
					"Test Step Executed Successfully : validateSubmit_Btn", "Pass");
			extent_Reportlogger(" :Test Step Executed Successfully", "validateSubmit_Btn", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				
			verify_PermEventCodeforSurrender("PremiumProcessing", reader.getMapData(CommonVariable.selectEventCode, map));
			System.out.println("Event code Value" + reader.getMapData(CommonVariable.selectEventCode, map));
			
		
		}
	
		
		}

			catch (Exception e) {
				
			
				
				extent_Reportlogger("perform_transactionisFailed",
						"perform_transactionisFailed", "FAIL");
				excelWrite.writeInCell(
						"perform_transactionisFailed", "Fail");
			
				
				e.printStackTrace();
			}
	}
			
			/*Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(eventConfirmation_DoneButton).click()
					.perform();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			extent_Reportlogger("clickonDone", "click_OnDone", "PASS");
			
			excelWrite.writeInCell(
					"click_OnDone", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
			excelWrite.writeInCell(
					"perform_transactionisdoneSuccesfully", "Pass");
			extent_Reportlogger("perform_transactionisdoneSuccesfully", "Transaction_Screen", "Pass");
			
			
		}
	
		
		}

			catch (Exception e) {
				
			
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
				extent_Reportlogger("perform_transactionisFailed",
						"perform_transactionisFailed", "FAIL");
				excelWrite.writeInCell(
						"perform_transactionisFailed", "Fail");
			
				
				e.printStackTrace();
			}
					*/	
				

			
	public void verify_PermEventCodeforSurrender(String testCaseName,String eventCode) throws Exception 
	{
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				String getTextPopUp = driver.findElement(By.xpath("//table[@pl_prop_class= 'McCamish-Data-Remittance']//tr[2]//td[2]")).getText().trim();
				
				System.out.println("IGPRenwel_eventCOde"+getTextPopUp);
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				if(getTextPopUp.equalsIgnoreCase(eventCode))
				{
					extent_Reportlogger(":Execution is Successfully Done : Event Code is : "+getTextPopUp, "verifyEventCode", "PASS");
					excelWrite.writeInCell("VerifyEventCodeforPolicy Test Step Execution Successfully Done: Event Code is "+getTextPopUp, "PASS");
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
					Actions actions = new Actions(driver);
					actions.moveToElement(newSubmit).click()
							.perform();
				
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
					
					excelWrite.writeInCell(
								"verifyPolicyRescissionEventCode is Executed Successfully", "Pass");
						extent_Reportlogger(":Executed Successfully", "verifyPolicyRescissionEventCode", "Pass");
							
						}
						else
						{
							extent_Reportlogger("Event Confirmation value is not Expected",
									"Failed in  Event Confirmation", "FAIL");
							excelWrite.writeInCell(
									"Event Confirmation value is not Expected ", "Fail");
						}

					
			}
			

	public boolean rowsExist(int i, int j)
	{
		try {

			
			
			driver.findElement(
					By.xpath("//table[@id='bodyTbl_right']//tbody//tr["
							+ i + "]//td[" + j + "]")).getTagName();
			
			
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
}

