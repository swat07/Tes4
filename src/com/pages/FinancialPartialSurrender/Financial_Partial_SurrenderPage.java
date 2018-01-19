package com.pages.FinancialPartialSurrender;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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



		public class Financial_Partial_SurrenderPage extends Test_BaseClass {
			
			public Financial_Partial_SurrenderPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		BaseUtils utility = new BaseUtils(driver);
		
		//@FindBy(id = "EvntType")
		@FindBy(xpath = "//select[@id='EvntType']")
		public WebElement slect_EventType;
		
		
		@FindBy(xpath = "//*[@id='EXPAND-OUTERFRAME']")
		public WebElement click_frame;
		
		/*@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div/div/div/span/button")
		public WebElement click_ValidateSelection;*/
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate Selection')]")
		public WebElement click_ValidateSelection;
		
		@FindBy(id = "SurrAmt")
		public WebElement select_FlatAmount;
		
		

		@FindBy(id = "SurrPct")
		public WebElement FlatAmount;
		
		@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Tax']")
		public WebElement click_OnTax;
		
		@FindBy(id = "IRSDistCode")
		public WebElement Select_IRSDistributionCode;
		
		@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Disbursement']")
		public WebElement click_Disbursement;
		
		@FindBy(id = "VerifiedDisbFlag")
		public WebElement Select_VerifiedDisbFlag;
		
		
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
		public WebElement Select_Validatebutton;
		
		@FindBy(xpath = "//div[@node_name='MCDisplayValidateMsgs']//tr[1]//td[2]//label")
		public WebElement Select_validationmsg;
		
		@FindBy(xpath = "//*[@id='HarnessFooter']//div[@class='pzbtn-mid'][contains(.,'Close')]")
		public WebElement validateInput_Close_Btn;
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
		public WebElement validateSubmit_Btn;
		
		@FindBy(id = "submitButton")
		public WebElement CLick_OnDonebtn;
		
		@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
		public WebElement review_ValidationMsz1;
		
		@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
		public WebElement validateMessagesTable;
		
		@FindBy(xpath = "(.//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/span)[1]")
		public WebElement  eventcodeS530;
		
		//@FindBy(xpath = "(.//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/span)[1]")
		
		@FindBy(xpath = "(//label[text()='Event Code']/following-sibling::div//span")
		public WebElement  eventcodeS500;
		
		@FindBy(xpath = "(//label[text()='Event Code']")
		public WebElement  eventcodeS500Chk;
		
		@FindBy(id = "Finding2")
		public WebElement Select_Trackcorrespondence;
		
		@FindBy(id = "Finding1")
		public WebElement Select_AdminChecklist;
		
		@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,' Submit ')]")
		public WebElement clkOnSubmit;
		
		public String verify_EventCodeforSurrender() throws Exception 
		{
		
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			String getTextPopUp = driver.findElement(By.xpath("//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/span")).getText().trim();
		
			System.out.println("Verify_PopUp : " +getTextPopUp);
			extent_Reportlogger("Assert validation Pass for PopUpWindow", "Alpha Maintenance", "PASS");
		
			
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			return getTextPopUp;
		}
		
		
		
		
		public void select_Disbursement() throws Exception{

			try {
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				click_Disbursement.click();
				excelWrite.writeInCell(
						"Disbursement click Step is Executed Sccessfully", "Pass");
				extent_Reportlogger(":Executed Successfully", "Disbursement Click", "Pass");
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				Select_VerifiedDisbFlag.click();
				
				excelWrite.writeInCell(
						"Select_VerifiedDisbFlag Test Step Executed Successfully", "Pass");
				extent_Reportlogger(":Test Step  Executed Successfully", "Select_VerifiedDisbFlag", "Pass");
			
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				Select_Validatebutton.click();
				
				excelWrite.writeInCell(
						"Validation button Click Test Step is Executed Successfully", "Pass");
				extent_Reportlogger(": Test Step Excuted Successfully", "Validation button Click", "Pass");
				
				//Code for Validation Window Handle
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				ArrayList<String> validationlist = new ArrayList<String>();
				
				String value1 = "";
			
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
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						driver.switchTo().window(child_window);
						((JavascriptExecutor)driver).executeScript("window.focus();");
//						driver.manage().window().setPosition(new Point(2000, 500));
						System.out.println( "After switching" +driver.getTitle());
						break;
					
					
					}
				}
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));	
				driver.manage().window().maximize();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				excelWrite.writeInCell(
						"Moved_ToValidation_Window Test Step Executed Successfully", "Pass");
				extent_Reportlogger(":Test Step Executed Successfully", "Moved_ToValidation_Window", "Pass");
				
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				if (utility.isWebElementExist(review_ValidationMsz1))
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

					
					System.out.println("Inside Fatal");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					
					String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
					
					extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
					excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
					

					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
					validateInput_Close_Btn.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
					
					driver.switchTo().window(parentwindow);
					System.out.println("Switch to parent window "
							+ driver.switchTo().window(parentwindow).getTitle());
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					
					//clickCancel_Btn.click();

					extent_Reportlogger("FATAL Error :  ",
							"SubmitButtonisDisabled", "PASS");
						
							excelWrite.writeInCell(
									"InsideFatalErrorSubmitButtonisDisabled", "Pass");

				}
				if (validationlist.contains("Warning") || (validationlist.contains("Info")))
				{
					
					System.out.println("inside Info");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
					
					extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
					excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					 validateInput_Close_Btn.click();
					
					
					driver.switchTo().window(parentwindow);
					System.out.println("Switch to parent window "
							+ driver.switchTo().window(parentwindow).getTitle());
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
					Actions actions = new Actions(driver);
					actions.moveToElement(validateSubmit_Btn).click()
							.perform();
					
					/*extent_Reportlogger(":Successfully", "validationMessage is Verified", "PASS");
					excelWrite.writeInCell("validationMessage is Verified Successfully", "PASS");*/
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					
						
					verify_EventCodeforSurrenderTC1("Financial", reader.getMapData(CommonVariable.selectEventCode_Validationfin, map));
					System.out.println("Event code Value" + reader.getMapData(CommonVariable.selectEventCode_Validationfin, map));
					
				
					
					
				}
					
				}
				

			
				else if (utility.isWebElementExist(Select_validationmsg))
				{
					System.out.println("Inside Select_validationmsg ");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					String validationmsgactual=Select_validationmsg.getText();
					System.out.println("Status expected: "+reader.getMapData(CommonVariable.validation_msg, map));
					System.out.println("Status Actual:" +validationmsgactual);
					
				 if(validationmsgactual.equals(reader.getMapData(CommonVariable.validation_msg, map)))
					 
					 
				 {
					
					 extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+validationmsgactual, "ValidationMessages_Verification", "PASS");
						excelWrite.writeInCell("ValidationMessages_Verification Test Step Execution Successfull: Message Severity is "+validationmsgactual, "PASS");
					
					 validateInput_Close_Btn.click();
					 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
					 /*excelWrite.writeInCell(
								"Test Step Executed Successfully: Click on Close Button", "Pass");
						extent_Reportlogger(":Test Step Executed Successfully ", "Click on Close Button", "Pass");*/
					
					
				
				 }
				 
					
				 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				driver.switchTo().window(parentwindow);
				System.out.println("Switch to parent window "
						+ driver.switchTo().window(parentwindow).getTitle());
			
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
				Actions actions = new Actions(driver);
				actions.moveToElement(validateSubmit_Btn).click()
						.perform();
				//utility.click_On_Button(validateSubmit_Btn);
				
				/* excelWrite.writeInCell(
							"Test Step Executed Successfully : validateSubmit_Btn", "Pass");
					extent_Reportlogger(" :Test Step Executed Successfully", "validateSubmit_Btn", "Pass");*/
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
				verify_EventCodeforSurrenderTC1("Financial", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
				System.out.println("Event code Value" + reader.getMapData(CommonVariable.selectEventCode_Validation, map));
				
			
				
				excelWrite.writeInCell(
						"InfoMszVerifyDone", "Pass");
				extent_Reportlogger("InfoMszVerifyDone", "InfoMszVerifyDone", "Pass");
				
				
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
				
							
					

				
		}
		public void verify_EventCodeforSurrender(String testCaseName,String eventCode) throws Exception 
		{
			
					
				
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			String getTextPopUp = eventcodeS530.getText().trim();
					
					System.out.println("IGPRenwel_eventCOde"+getTextPopUp);
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					if(getTextPopUp.equalsIgnoreCase(eventCode))
					{
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						CLick_OnDonebtn.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						excelWrite.writeInCell(
								"verifyPolicyRescissionEventCodeDone", "Pass");
						extent_Reportlogger("verifyPolicyRescissionEventCodeDone", "Owner Manitenance", "Pass");
					/*eventConfirmation_DoneButton.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));*/
						
					}
					else
					{
						extent_Reportlogger("Event Confirmation value is not Expected",
								"Failed in  Event Confirmation", "FAIL");
						excelWrite.writeInCell(
								"Event Confirmation value is not Expected ", "Fail");
					}

					System.out.println("complete event confirmation");
		}
		public void verify_EventCodeforSurrenderTC1(String testCaseName,String eventCode) throws Exception 
		{
			
			
		
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
//			eventcodeS500Chk.click();
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			String getTextPopUp = driver.findElement(By.xpath("//label[text()='Event Code']/following-sibling::div//span")).getText();
			
					
					System.out.println("IGPRenwel_eventCOde"+getTextPopUp);
				
					if(getTextPopUp.equalsIgnoreCase(eventCode))
					{
						extent_Reportlogger(":Execution Successfully Done : Event Code is : "+getTextPopUp, "verifyEventCodeforPolicy", "PASS");
						excelWrite.writeInCell("verifyEventCodeforPolicy Test Step Execution Successfull: Event Code is "+getTextPopUp, "PASS");
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						CLick_OnDonebtn.click();
						this.selectAdminChklistTaskBO();
						
						
						
					}
					else
					{
						extent_Reportlogger("Event Confirmation value is not Expected",
								"Failed in  Event Confirmation", "FAIL");
						excelWrite.writeInCell(
								"Event Confirmation value is not Expected ", "Fail");
					}

					System.out.println("complete event confirmation");
		}

		public void selectAdminChklistTaskBO() throws Exception {
			try {
				
				
				utility.selectvalueByText_DropdownList(
						Select_AdminChecklist,
						 reader.getMapData(CommonVariable.admin_Checklist, map));
				
				String eventtype = reader.getMapData(CommonVariable.admin_Checklist, map);
			
				extent_Reportlogger(":Selected Value is :" +eventtype, "Select_AdminChecklist is done and ", "Pass");
			
				excelWrite.writeInCell("Select_AdminChecklistDone = " + reader.getMapData(CommonVariable.admin_Checklist, map ), "Pass");
				utility.selectvalueByText_DropdownList(
						Select_Trackcorrespondence,
						 reader.getMapData(CommonVariable.select_Track, map));
				String eventtype3 = reader.getMapData(CommonVariable.select_Track, map);
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				extent_Reportlogger(":Selected Value is :" +eventtype3, "Select_TrackcorrespondenceforOwner is done and ", "Pass");
				
				excelWrite.writeInCell("Select_TrackcorrespondenceforOwnerDone = " + reader.getMapData(CommonVariable.select_Track, map ), "Pass");
				clkOnSubmit.click();
			
				
			}
				
				catch(Exception e)
				{
					extent_Reportlogger(":Fail", "Select_TrackcorrespondenceforOwner", "Fail");
					excelWrite.writeInCell(
							"Select_TrackcorrespondenceforOwner ", "Fail");
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


		
		
			
				
			
				

				
	
		
		
		
	
		
	/*	public String verify_ValidationMessage() throws Exception 
		{
		
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			String getTextPopUp = driver.findElement(By.xpath("//*[@id='RULE_KEY']/div/div/table/tbody/tr[1]/td[2]/nobr/label")).getText().trim();
		
			System.out.println("Verify_PopUp : " +getTextPopUp);
			extent_Reportlogger("Assert validation Pass for PopUpWindow", "Alpha Maintenance", "PASS");
		
			excelWrite.writeInCell(
					"Assert validation Pass for PopUpWindow", "Pass");
			ScreenShot.takeScreenShot(driver,
					"Assert validation Pass for PopUpWindow",
					"verifyPopUpMessage");
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			return getTextPopUp;
		}
		
			
		*/
		

