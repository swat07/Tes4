package com.pages.FinancialPartialSurrender;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

import com.pages.PolicyChangeScreens.PolicyChange_eventConfirmationScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ScreenShot;
import com.utility.Test_BaseClass;



		public class Financial_PartialSurrenderFin_Valueupdate extends Initialize_Browser {
					
					
					public Financial_PartialSurrenderFin_Valueupdate(WebDriver driver) {
						this.driver = driver;
						
						PageFactory.initElements(driver, this);

					}
					
					Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page;
				
					@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate Input Criteria')]")
					//@FindBy(xpath = "//div[text()='Create New']")
					public WebElement click_Validatebtn;
					
					@FindBy(xpath = "//div[text()='Add']")
					public WebElement click_Addbtn;
					
					@FindBy(id = "NewValue1")
					public WebElement enter_NewValue;
					
					//@FindBy(id = "FieldValue1")
					
					@FindBy(xpath = "//select[@id='FieldValue1']")
					public WebElement enter_FieldValue;
					
					@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
					public WebElement validatebtn;
				
					//@FindBy(xpath = "//*[@id='RULE_KEY']/div/div/div/div/div/div")
					
					//@FindBy(xpath = "//div[@node_name='MCDisplayValidateMsgs']//tr[1]//td[2]//label")
					@FindBy(xpath = "//*[@id='RULE_KEY']/div/div/div/div/div/div")
					public WebElement Select_validationmsg;
					
					@FindBy(xpath = "//table[@pl_prop='.EventSummary']")
					public WebElement eventConfirmation_table;
					

					@FindBy(xpath = "//*[@id='HarnessFooter']//div[@class='pzbtn-mid'][contains(.,'Close')]")
					public WebElement validateInput_Close_Btn;
					
					@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
					public WebElement validateSubmit_Btn;
					
					@FindBy(xpath = ".//*[@id='submitButton']")
					public WebElement eventConfirmation_DoneButton;
					
					@FindBy(xpath = "//button[text() = '  Done ']")
					public WebElement NeweventConfirmation_DoneButton;
					
					@FindBy(xpath = "//table[@pl_prop='.IGPConfirmation']")
					public WebElement eventConfirmation_table1;
					
					
					
					@FindBy(xpath = "(//table[@id='bodyTbl_right']//td[1]//div//span)[1]")
					public WebElement  eventConfirmTable;
					
					
					@FindBy(xpath="//div[@pyclassname='McCamish-FW-BckOff-Work-PolicyChanges-CellCovMaint']//div[@class='field-item dataLabelRead']")
					public WebElement checkNoerror_validateMessages1;
					
					@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
					public WebElement review_ValidationMsz;
					
					
					@FindBy(xpath="//table[@pl_prop='.ValidateList']//tr[2]//td[4]")
					public WebElement review_fatalerro;
					
					@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
					public WebElement review_ValidationMsz1;
					
					@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
					public WebElement validateMessagesTable;
					
					@FindBy(xpath = "//table[@id='bodyTbl_right']//tr[2]//td[1]")
					public WebElement  eventConfirmTable1;
					
					
					BaseUtils utility = new BaseUtils(driver);
					
					public void verify_NOValidationMsg(String TestCaseName) throws Exception{

						try {
							
							Financial_Depo_AccntSurrender Financial_Depo_AccntSurrender = new Financial_Depo_AccntSurrender(driver);
							finPartialSurrenderLoan_S520Page= new Fin_PartialSurrenderLoan_S520Page(driver);
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							excelWrite.writeInCell(
									"Validation button Click Test Step is Executed Successfully", "Pass");
							extent_Reportlogger(": Test Step Excuted Successfully", "Validation button Click", "Pass");
						
							
							//Code for Validation Window Handle
							
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
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
									driver.switchTo().window(child_window);
									((JavascriptExecutor)driver).executeScript("window.focus();");
//									driver.manage().window().setPosition(new Point(2000, 500));
									System.out.println( "After switching" +driver.getTitle());
									break;
								
								
								}
							}
								
								
							driver.manage().window().maximize();
							
							excelWrite.writeInCell(
									"Moved_ToValidation_Window Test Step Executed Successfully", "Pass");
							extent_Reportlogger(":Test Step Executed Successfully", "Moved_ToValidation_Window", "Pass");
						
							ArrayList<String> validationlist = new ArrayList<String>();
							
							String value1 = "";
						
							
							if (utility.isWebElementExist(review_ValidationMsz))
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
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								
								driver.switchTo().window(parentwindow);
								System.out.println("Switch to parent window "
										+ driver.switchTo().window(parentwindow).getTitle());
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								driver.switchTo().defaultContent();
								driver.switchTo().frame("PegaGadget2Ifr");
								
								//clickCancel_Btn.click();

								extent_Reportlogger("FATAL Error :  ",
										"SubmitButtonisDisabled", "PASS");
									
										excelWrite.writeInCell(
												"InsideFatalErrorSubmitButtonisDisabled", "Pass");

							}
						
							if (validationlist.contains("Warning") || (validationlist.contains("Info"))) {
								System.out.println("inside Info");
								
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
								String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
								extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
								excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
								
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
								validateInput_Close_Btn.click();
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
								driver.switchTo().window(parentwindow);
								System.out.println("Switch to parent window "
										+ driver.switchTo().window(parentwindow).getTitle());
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
								driver.switchTo().defaultContent();
								driver.switchTo().frame("PegaGadget2Ifr");
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
								
								
								Actions actions = new Actions(driver);
								actions.moveToElement(validateSubmit_Btn).click()
										.perform();
								/*excelWrite.writeInCell(
										"Test Step Executed Successfully : validateSubmit_Btn", "Pass");
								extent_Reportlogger(" :Test Step Executed Successfully", "validateSubmit_Btn", "Pass");*/
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
								
								if (TestCaseName.equalsIgnoreCase("FinancialIGPRenewal"))
								{
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
								finPartialSurrenderLoan_S520Page.verify_EventCodeforSurrendertable("-Financial-IGPRenewal", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
								}
								
								
								
								else if(TestCaseName.equalsIgnoreCase("FinancialDepositAccountSurrender")||TestCaseName.equalsIgnoreCase("FinancialPartialSurrenderLoanS520")||TestCaseName.equalsIgnoreCase("FinancialPartialSurrenderFinvalueUpdate"));
								{
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
									finPartialSurrenderLoan_S520Page.verify_EventCodeforSurrendertable("-EventSummary", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
								}
								
								
								
								
							}
						
							
							}
						
							else if (utility.isWebElementExist(Select_validationmsg))
							{
								System.out.println("Inside Select_validationmsg ");
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								String validationmsgactual=Select_validationmsg.getText();
								System.out.println("Status expected: "+reader.getMapData(CommonVariable.validation_msg, map));
								System.out.println("Status Actual:" +validationmsgactual);
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								/*String validationmsgactual=Select_validationmsg.getText().trim();
								System.out.println("Status expected: "+reader.getMapData(CommonVariable.validation_msg, map));*/
								
							 if(validationmsgactual.equals(reader.getMapData(CommonVariable.validation_msg, map)))
								 
								 
							 {
								 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								 extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+validationmsgactual, "ValidationMessages_Verification", "PASS");
									excelWrite.writeInCell("ValidationMessages_Verification Test Step Execution Successfull: Message Severity is "+validationmsgactual, "PASS");
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								 validateInput_Close_Btn.click();
								/* excelWrite.writeInCell(
											"Test Step Executed Successfully: Click on Close Button", "Pass");
									extent_Reportlogger(":Test Step Executed Successfully ", "Click on Close Button", "Pass");*/
								
							
							 }
								
							 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
								
								driver.switchTo().window(parentwindow);
								System.out.println("Switch to parent window "
										+ driver.switchTo().window(parentwindow).getTitle());
							
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
								driver.switchTo().defaultContent();
								driver.switchTo().frame("PegaGadget2Ifr");
								
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
								
								Robot robot = new Robot();
								robot.keyPress(KeyEvent.VK_PAGE_UP);
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
							Actions actions = new Actions(driver);
							actions.moveToElement(validateSubmit_Btn).click()
									.perform();
							
							/*excelWrite.writeInCell(
									"Test Step Executed Successfully : validateSubmit_Btn", "Pass");
							extent_Reportlogger(" :Test Step Executed Successfully", "validateSubmit_Btn", "Pass");*/
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
							
							if (TestCaseName.equalsIgnoreCase("FinancialIGPRenewal"))
							{
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
							finPartialSurrenderLoan_S520Page.verify_EventCodeforSurrendertable("-Financial-IGPRenewal", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
							}
							
							
							
							else if(TestCaseName.equalsIgnoreCase("FinancialDepositAccountSurrender")||TestCaseName.equalsIgnoreCase("FinancialPartialSurrenderLoanS520")||TestCaseName.equalsIgnoreCase("FinancialPartialSurrenderFinvalueUpdate"));
							{
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
								finPartialSurrenderLoan_S520Page.verify_EventCodeforSurrendertable("-EventSummary", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
							}
						
							
							
							
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
										
					public void verify_EventCodeforSurrendertableTC03(String testCaseName,String eventCode) throws Exception 
					{
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						
						System.out.println("inside verify_EventCodeforSurrender for TC_06");
						
						String IGPRenwel_eventCOde=eventConfirmTable.getText();
						
						System.out.println("IGPRenwel_eventCOde" + IGPRenwel_eventCOde);
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						if(IGPRenwel_eventCOde.equalsIgnoreCase(eventCode))
						{
							System.out.println("Inside If loop");
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
							driver.switchTo().defaultContent();
							driver.switchTo().frame("PegaGadget2Ifr");
							
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
							/*Actions actions = new Actions(driver);
							actions.moveToElement(eventConfirmation_DoneButton).click()
									.perform();*/
						
							eventConfirmation_DoneButton.click();
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
							
								excelWrite.writeInCell(
											"verifyPolicyRescissionEventCodeDone", "Pass");
									extent_Reportlogger("verifyPolicyRescissionEventCodeDone", "Owner Manitenance", "Pass");
							
									
								}
								else
								{
									extent_Reportlogger("Event Confirmation value is not Expected",
											"Failed in  Event Confirmation", "FAIL");
									excelWrite.writeInCell(
											"Event Confirmation value is not Expected ", "Fail");
								}

							
					}
					

							
					
					public void financialPartialSurrender_EventCode(String testCaseName,String eventCode) throws Exception 
					{
						try {
								
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							System.out.println("inside financialPartialSurrender_EventCode ");
							ArrayList<String> eventList = new ArrayList<String>();
								String eventCode1="";
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								driver.switchTo().defaultContent();
								driver.switchTo().frame("PegaGadget2Ifr");
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(15, TimeUnit.SECONDS));
								List<WebElement> rows = eventConfirmation_table.findElements(By.tagName("tr"));
								List<WebElement> cols = eventConfirmation_table.findElements(By.tagName("td"));
								int countRows = rows.size();
								int countCols = cols.size();
								System.out.println("inside table");
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								System.out.println(countRows + countCols);
								for(int j=1; j<=countCols; j++)
								{
									
									String eventValues = driver.findElement(By.xpath("//table[@pl_prop='.EventSummary']//tr[2]//td["+j+"]")).getText();
									eventList.add(eventValues);
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
									System.out.println("Event value" +eventValues );
									
								}
								
								eventCode1 = eventList.get(0);
								
								System.out.println("Event code value" +eventCode1 );
								
								if(eventCode1.equals(eventCode))
								{
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
									extent_Reportlogger("Event Confirmation value is  Expected",
											"Pass in  Event Confirmation", "PASS");
									excelWrite.writeInCell(
											"Event Confirmation value is  Expected ", "PASS");
								
								}
								
							
								else
								{
									extent_Reportlogger("Event Confirmation value is not Expected",
											"Failed in  Event Confirmation", "FAIL");
									excelWrite.writeInCell(
											"Event Confirmation value is not Expected ", "Fail");
								}

								//eventConfirmation_locators.eventConfirmation_DoneBtn.click();
								System.out.println("complete event confirmation");
							} 
						catch (Exception e) {
								extent_Reportlogger("Event Confirmation Failed",
										"Failed in  Event Confirmation", "FAIL");
								excelWrite.writeInCell(
										"Failed in  Event Confirmation ", "Fail");
							}

						
					}
					public void FinancialTC03EventCode(String testCaseName,String eventCode) throws Exception 
					{
						System.out.println("inside first value");
								
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
								
							String IGPRenwel_eventCOde=eventConfirmTable.getText();
								
								System.out.println("IGPRenwel_eventCOde"+IGPRenwel_eventCOde);
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								if(IGPRenwel_eventCOde.equalsIgnoreCase(eventCode))
								{
									System.out.println("Inside IF");
									extent_Reportlogger("Event Confirmation value is  Expected",
											"Pass in  Event Confirmation", "PASS");
									excelWrite.writeInCell(
											"Event Confirmation value is  Expected ", "PASS");
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6, TimeUnit.SECONDS));
									NeweventConfirmation_DoneButton.click();
									Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
									
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
			
								
						
							

					private boolean rowsExist(int i, int j) {
						try {

							
							
							driver.findElement(
									By.xpath("//table[@id='bodyTbl_right']//tbody//tr["
											+ i + "]//td[" + j + "]")).getTagName();
							
							
							return true;
						} catch (NoSuchElementException e) {
							return false;
						}
					}
					
					
					public void clkOnValidationAndAddBtn() throws Exception {
						try {

							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							utility.click_On_Button(click_Validatebtn);
							
							
							excelWrite.writeInCell(
									"click_Validatebtn Test Step Executed Successfully", "Pass");
							extent_Reportlogger(":Test Step Executed Successfully", "click_Validatebtn", "Pass");
							utility.click_On_Button(click_Addbtn);
							
							
							excelWrite.writeInCell(
									"click_AddBtn Test Step Executed Successfully", "Pass");
							extent_Reportlogger(":Test Step Executed Successfully", "click_AddBtn", "Pass");
							
							
						} catch (Exception e) {
							extent_Reportlogger("Test Step Execution failed", "clkOnValidationAndAddBtn", "FAIL");
							excelWrite.writeInCell("clkOnValidationAndAddBtn Test Step Execution Unsuccessfull", "Fail");
							ErrorLogger.logError(e.getClass().getName(),"clkOnValidationAndAddBtn", e.getMessage());
							throw e;
						}
				}
					
					public void select_fieldDropdownvalue() throws Exception {
						try {
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							utility.selectvalueByText_DropdownList(enter_FieldValue, reader.getMapData(CommonVariable.fieldDrpdown, map));
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							String RepmntValue = reader.getMapData(CommonVariable.fieldDrpdown, map);
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							excelWrite.writeInCell(
									"select_fieldDropdownvalue Executed Successfully" +RepmntValue, "Pass");
							extent_Reportlogger(":Value is :" +RepmntValue, "FieldDropDown selected and", "Pass");
							
							
						} catch (Exception e) {
							extent_Reportlogger("Test Step Execution failed", "clkOnValidationAndAddBtn", "FAIL");
							excelWrite.writeInCell("clkOnValidationAndAddBtn Test Step Execution Unsuccessfull", "Fail");
							ErrorLogger.logError(e.getClass().getName(),"clkOnValidationAndAddBtn", e.getMessage());
							throw e;
						}
				}
					
					public void enter_AmountValue() throws Exception {
						try {

							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							String enterAmount =  reader.getMapData(CommonVariable.enterNewamnt, map);
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							enter_NewValue.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmount +Keys.TAB); 
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							System.out.println("value" + reader.getMapData(CommonVariable.enterNewamnt, map));
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							excelWrite.writeInCell(
									"select_fieldDropdownvalue Executed Successfully" +enterAmount, "Pass");
							extent_Reportlogger(":Value is :" +enterAmount, "FieldDropDown selected and", "Pass");
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							
						} catch (Exception e) {
							extent_Reportlogger("Test Step Execution failed", "enter_AmountValue", "FAIL");
							excelWrite.writeInCell("enter_AmountValue Test Step Execution Unsuccessfull", "Fail");
							ErrorLogger.logError(e.getClass().getName(),"enter_AmountValue", e.getMessage());
							throw e;
						}
				}

					
					
		}
					
					
					
				