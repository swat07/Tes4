package com.pages.FinancialPartialSurrender;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ScreenShot;
import com.utility.Test_BaseClass;


public class Fin_PartialSurrenderLoan_S520Page extends Initialize_Browser {

	
	
	public Fin_PartialSurrenderLoan_S520Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	Financial_Partial_SurrenderPage financialPartialSurrenderPage;
	Financial_PartialSurrenderFin_Valueupdate FinPartialSurrenderFin_Valueupdate;
	Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page;


	
	@FindBy(xpath = "//select[@id='ProcRepayForm']")
	public WebElement select_Repayment;
	
	
	@FindBy(id = "LoanAmount")
	public WebElement enter_LoanAmount;
	
	@FindBy(id = "Repayments")
	public WebElement enter_Payments;
	
	@FindBy(xpath = "//select[@id='RepayFreq']")
	public WebElement select_RepayFreq;
	
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
	public WebElement validatebtn;

	@FindBy(xpath = "//*[@id='RULE_KEY']/div/div/div/div/div/div")
	public WebElement Select_validationmsg;
	
	@FindBy(xpath=".//*[@id='RULE_KEY']/table/tbody/tr/td[1]/nobr/label")
	public WebElement review_ValidationMsz;
	
	@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
	public WebElement validateMessagesTable;
	


	@FindBy(xpath = "//*[@id='HarnessFooter']//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement validateInput_Close_Btn;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
	public WebElement validateSubmit_Btn;
	
	@FindBy(id = "submitButton")
	public WebElement ClickSubmitNew;
	
	@FindBy(xpath = "//button[text() = '  Submit ']")
	public WebElement newDoneButton;
	
	@FindBy(xpath = "//button[text() = '  Done ']")
	public WebElement eventConfirmation_DoneButton;
	
	@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Disbursement']")
	public WebElement click_Disbursement;
	
	@FindBy(id = "VerifiedDisbFlag")
	public WebElement Select_VerifiedDisbFlag;
	
	@FindBy(xpath = "//table[@id='bodyTbl_right']//tr[2]//td[2]")
	public WebElement  eventConfirmTable;
	
	@FindBy(xpath = "//div[@class='field-item dataValueRead']//span[text()='S506']")
	public WebElement  eventcode;
	
	

	public void select_NoErrMsgValidation() throws Exception{
		
		try{
			financialPartialSurrenderPage = new Financial_Partial_SurrenderPage(driver);
			FinPartialSurrenderFin_Valueupdate = new Financial_PartialSurrenderFin_Valueupdate(driver);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			finPartialSurrenderLoan_S520Page= new Fin_PartialSurrenderLoan_S520Page(driver);
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(click_Disbursement);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(Select_VerifiedDisbFlag);
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			validatebtn.click();
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			extent_Reportlogger("click_Validatebutton", "click_Validatebutton done", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
	
			

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			
			String value = "";
			String mainwindow = "";
			mainwindow = driver.getWindowHandle();

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			 excelWrite.writeInCell(
						"validateoption", "Pass");
				extent_Reportlogger("validateoption", "validateoption", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			String parentwindow = driver.getWindowHandle();
			System.out.println("Before switching " + driver.getTitle());
			
			Set<String> s1 = driver.getWindowHandles();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			Iterator<String> i1	=s1.iterator();
			while (i1.hasNext()){
				String child_window = i1.next();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				System.out.println("value" +child_window);
				if (!parentwindow.equalsIgnoreCase(child_window)){
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
					driver.switchTo().window(child_window);
					((JavascriptExecutor)driver).executeScript("window.focus();");
//					driver.manage().window().setPosition(new Point(2000, 500));
					System.out.println( "After switching" +driver.getTitle());
					break;
				
				
				}
			}
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			excelWrite.writeInCell(
					"Moved_ToValidation_Window", "Pass");
			extent_Reportlogger("Moved_ToValidation_Windowdone", "ValidationScreen", "Pass");
			
		
	
	
			System.out.println("inside verify_NOValidationMsg ");
			ArrayList<String> validationlist = new ArrayList<String>();
			
			String value1 = "";
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
			
			if (utility.isWebElementExist(review_ValidationMsz))
			{
				System.out.println("sdf");

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

							value1 = driver
									.findElement(
											By.xpath("//table[@id='bodyTbl_right']//tbody//tr["
													+ i + "]//td[" + j + "]"))
									.getText();

							System.out.println("table value" + value1);
							validationlist.add(value1);

						} else {
							System.out.println("exit");
							break outerLoop;
						}
					}
				}
			
			
	
				if (validationlist.contains("Fatal") || validationlist.contains("Stop")) {

					System.out.println("inside fatal");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
					extent_Reportlogger("InsideFatalError",
							"InsideFatalError", "PASS");
					
						excelWrite.writeInCell(
								"InsideFatalError", "Pass");

					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					validateInput_Close_Btn.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					System.out.println("Error occur");
					driver.switchTo().window(parentwindow);
					System.out.println("Switch to parent window "
							+ driver.switchTo().window(parentwindow).getTitle());
				
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					//clickCancel_Btn.click();

					extent_Reportlogger("FatalErrorSubmitButtonisDisabled ",
							"InsideFatalErrorSubmitButtonisDisabled", "PASS");
					
						excelWrite.writeInCell(
								"InsideFatalErrorSubmitButtonisDisabled", "Pass");

				}
				

			
			/*	else if (utility.isWebElementExist(Select_validationmsg))
				{

					
					String validationmsgactual=Select_validationmsg.getText().trim();
					System.out.println("Status expected: "+reader.getMapData(CommonVariable.validation_msg, map));*/
					
			else if (validationlist.contains("Info") || validationlist.contains("Warning")) {
				
				System.out.println("Inside INFo");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
				
				excelWrite.writeInCell(
						"NOErrOccur_Validation_Window", "Pass");
				extent_Reportlogger("NOErrOccur_Validation_Window!!", "Validation Screen", "Pass");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
					validateInput_Close_Btn.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
					System.out.println("Clicked on CLose");
				
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
					driver.switchTo().window(mainwindow);
					System.out.println("Switch to parent window "
							+ driver.switchTo().window(mainwindow).getTitle());
					extent_Reportlogger("validateSubmit_Btn ",
							"validateSubmit_Btn", "PASS");
					
						excelWrite.writeInCell(
								"validateSubmit_Btn", "Pass");

					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					System.out.println("Inside Submit");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(11, TimeUnit.SECONDS));
					Actions actions = new Actions(driver);
					actions.moveToElement(validateSubmit_Btn).click()
							.perform();
					extent_Reportlogger("verify_EventCodeforSurrender1 ",
							"verify_EventCodeforSurrender1", "PASS");
					
						excelWrite.writeInCell(
								"verify_EventCodeforSurrender1", "Pass");	
					
				
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
						System.out.println("Event code Value!!!" + reader.getMapData(CommonVariable.selectEventCode_Validation, map));
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						finPartialSurrenderLoan_S520Page.verify_EventCodeforSurrendertable("Financial_PartialSurrenderFin_valueUpdate", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
					excelWrite.writeInCell(
							"InfoMszVerifyDone", "Pass");
					extent_Reportlogger("InfoMszVerifyDone", "InfoMszVerifyDone", "Pass");
			
				}
					
				}
				}

			catch (InterruptedException e) {
				
				//extent_Reportlogger("submit_InfoToVpas", "Login Fail Screen", "FAIL");
				extent_Reportlogger("InfoMszVerifyDone Failed",
						"InfoMszVerifyDone", "FAIL");
				excelWrite.writeInCell(
						"InfoMszVerifyDone", "Fail");
				
				
				e.printStackTrace();
			}
						
				

			}
	public void verify_EventCodeforSurrendertable(String eventType,String eventCode) throws Exception 
	{
	
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
	
		//table[@pl_prop_class= 'McCamish-Data-EventSummary']//tr[1]//th[2]//div
		List<WebElement> we = driver.findElements(By.xpath("//table[@pl_prop_class= 'McCamish-Data"+eventType+"']//tr[1]//th"));
		
		String eventCode_Value="";
		for(int i=1;i<=we.size();i++){
			System.out.println("Size"+we.size());
			System.out.println("Inside For loop");
			
			String eventCode_Text=driver.findElement(By.xpath("//table[@pl_prop_class= 'McCamish-Data"+eventType+"']//tr[1]//th["+i+"]//div")).getText().trim();
			System.out.println("Xpath "+eventCode_Text );
			
			if(eventCode_Text.equalsIgnoreCase("EVENT CODE")){
				 eventCode_Value=driver.findElement(By.xpath("//table[@pl_prop_class= 'McCamish-Data"+eventType+"']//tr[2]//td["+i+"]//span")).getText();
				System.out.println("Valuee" +eventCode_Value);
				break;
			}
		}
	
			
		if(eventCode_Value.equalsIgnoreCase(eventCode))
		{
			System.out.println("Inside Event codee");
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			extent_Reportlogger(":Execution is Successfully Done : Event Code is : "+eventCode_Value, "verifyEventCode", "PASS");
			excelWrite.writeInCell("VerifyEventCodeforPolicy Test Step Execution Successfully Done: Event Code is "+eventCode_Value, "PASS");
			
		
			//newDoneButton.click();
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			Actions actions = new Actions(driver);
			actions.moveToElement(ClickSubmitNew).click()
					.perform();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
				excelWrite.writeInCell(
							"verifyPolicyRescissionEventCode is Executed Successfully", "Pass");
					extent_Reportlogger(":Executed Successfully", "verifyPolicyRescissionEventCode", "Pass");
					//eventConfirmation_DoneButton
				
				}
				else
				{
					extent_Reportlogger("Event Confirmation value is not Expected",
							"Failed in  Event Confirmation", "FAIL");
					excelWrite.writeInCell(
							"Event Confirmation value is not Expected ", "Fail");
				}
	}

		
		/*if(testCaseName.equalsIgnoreCase("Financial_PartialSurrenderLoan_S520") || testCaseName.equalsIgnoreCase("Financial_PartialSurrenderFin_valueUpdate") 
				||(testCaseName.equalsIgnoreCase("Financial_PartialSurrender_SystematicRMD") || (testCaseName.equalsIgnoreCase("Financial_Deposit_AccountSurrender"))))
		{
			
		if(eventCode_Value.equalsIgnoreCase(eventCode))
		{
			System.out.println("inside second if");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			System.out.println("Done button");
		
			//newDoneButton.click();//	
			eventConfirmation_DoneButton.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
				excelWrite.writeInCell(
							"verifyPolicyRescissionEventCodeDone", "Pass");
					extent_Reportlogger("verifyPolicyRescissionEventCodeDone", "Owner Manitenance", "Pass");
					//eventConfirmation_DoneButton
					
				}
		
		
				else
				{
					extent_Reportlogger("Event Confirmation value is not Expected",
							"Failed in  Event Confirmation", "FAIL");
					excelWrite.writeInCell(
							"Event Confirmation value is not Expected ", "Fail");
				}
	}

			*/
	
	
	

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
	
	public void enter_LoanAmount() throws Exception {
		try {
			
			
			String enterLoanAmount = reader.getMapData(CommonVariable.enterNewamnt, map);
			
			enter_LoanAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterLoanAmount); 
			
			excelWrite.writeInCell(
					"enterLoanAmount Executed Successfully" +enterLoanAmount, "Pass");
			extent_Reportlogger(":TestStep Executed Successfully" +enterLoanAmount, "enterLoanAmount", "Pass");
			
			
			
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterLoanAmount", "FAIL");
			excelWrite.writeInCell("enterLoanAmount Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterLoanAmount", e.getMessage());
			throw e;
		}
}

	public void select_RepaymentAndPayment() throws Exception {
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(select_Repayment, reader.getMapData(CommonVariable.selectRepayment, map));
			
			String RepmntValue = reader.getMapData(CommonVariable.selectRepayment, map);
			
			excelWrite.writeInCell(
					"select_Repayment Executed Successfully" +RepmntValue, "Pass");
			extent_Reportlogger(":Value is :" +RepmntValue, "Repayment selected and", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.enter_Text(enter_Payments,(reader.getMapData(CommonVariable.enterPayment, map )+Keys.TAB));
			
			String paymntvalue = reader.getMapData(CommonVariable.enterPayment, map );
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			excelWrite.writeInCell(
					"select_RepaymentAndPayment Executed Successfully" +paymntvalue, "Pass");
			extent_Reportlogger(":Value is :" +paymntvalue, "Payment selected and", "Pass");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
			
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "select_RepaymentAndPayment", "FAIL");
			excelWrite.writeInCell("select_RepaymentAndPayment Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"select_RepaymentAndPayment", e.getMessage());
			throw e;
		}
}
	
	public void selectFrequency() throws Exception {
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.selectvalueByText_DropdownList(select_RepayFreq, reader.getMapData(CommonVariable.selectFrequency, map));
			String selectFrequency = reader.getMapData(CommonVariable.selectFrequency, map);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			excelWrite.writeInCell(
					"selectFrequency Executed Successfully" +selectFrequency, "Pass");
			extent_Reportlogger(":Value is :" +selectFrequency, "Frequency is selected and", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			
			
			
			
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectFrequency", "FAIL");
			excelWrite.writeInCell("selectFrequency Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectFrequency", e.getMessage());
			throw e;
		}
}
	
	
	
	
	
	
	
}


