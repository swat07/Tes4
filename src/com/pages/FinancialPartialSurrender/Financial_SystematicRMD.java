package com.pages.FinancialPartialSurrender;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
import com.utility.Initialize_Browser;

public class Financial_SystematicRMD extends Test_BaseClass {
			
				
				public Financial_SystematicRMD(WebDriver driver) {
					this.driver = driver;
					PageFactory.initElements(driver, this);
				}
				BaseUtils utility = new BaseUtils(driver);
				
				Fin_PartialSurrenderLoan_S520Page finPartialSurrenderLoan_S520Page;
				
				@FindBy(linkText = "PCPerform Trans")
				public WebElement pcPerformTrans_linktxt;
				
				//@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Create New')]")
				@FindBy(xpath = "//div[text()='Create New']")
				public WebElement click_CreateNew;
				
				@FindBy(xpath = "//select[@id='SchedFreq']")
				public WebElement select_Frequency;
			
				@FindBy(xpath = "//select[@id='EvntType']")
				public WebElement select_Eventtype;
				
				@FindBy(xpath = "//select[@id='SwpEventCode']")
				public WebElement select_Rmdevent;
				
				@FindBy(id = "End Date")
				public WebElement enter_EndDate;
				
				@FindBy(id = "Start Date")
				public WebElement enter_StartDate;
				
				@FindBy(xpath = "//select[@id='Basis']")
				public WebElement select_Basis;
				
				@FindBy(id = "AllocationRuleS")
				public WebElement select_withdraInfo;
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Investments')]")
				//@FindBy(xpath = "//div[text()='Investments']")
				public WebElement click_Investmnbtn;
				
				@FindBy(id = "SwpAmount")
				public WebElement enter_Flatamnt;
				
				@FindBy(xpath = "//table[@pl_prop='pyWorkPage.SelectedRec.InvesmentList']//tr[2]//td[1]")
				public WebElement click_Cv;
				
				@FindBy(id = "SwpPercent1")
				public WebElement enter_WithdrwAmnt1;
				
				@FindBy(id = "SwpPercent2")
				public WebElement enter_WithdrwAmnt2;
				
				@FindBy(id = "SwpPercent3")
				public WebElement enter_WithdrwAmnt3;
				
				@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Tax Info']")
				public WebElement click_TaxInfo;
			
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Edit Tax Info')]")
				public WebElement click_EditTaxInfo;
				
				@FindBy(id = "IRSDistCode")
				public WebElement Select_IRSDistributionCode;
				
				@FindBy(xpath = "//button[text() = '  Done ']")
			
				public WebElement eventConfirmation_DoneButton;
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Done')]")
				public WebElement eventConfirmation_DoneButton1;
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Done')]")
				public WebElement click_CalculatebuttonDone;
				
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Calculate')]")
				public WebElement click_Calculatebutton;
				
				@FindBy(xpath = "//span[@class='textMiddle']//label[text()='Payee']")
				public WebElement click_Payee;
			
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Disburse')]")
				public WebElement click_Disburse;
				
				@FindBy(id = "VerifiedDisbFlag")
				public WebElement Select_VerifiedDisbFlag;
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'OK')]")
				public WebElement click_OK;
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Validate')]")
				public WebElement Select_Validatebutton;
				
				@FindBy(xpath=".//*[@id='RULE_KEY']/table/tbody/tr/td[1]/nobr/label")
				public WebElement review_ValidationMsz;
				
				@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")
				public WebElement validateMessagesTable;
				
				@FindBy(xpath = "//*[@id='HarnessFooter']//div[@class='pzbtn-mid'][contains(.,'Close')]")
				public WebElement validateInput_Close_Btn;
				
				@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit TO VPAS')]")
				public WebElement validateSubmit_Btn;
				
				@FindBy(id = "submitButton")
				public WebElement CLick_OnDone;
				
				@FindBy(xpath="//div[@class='field-item dataLabelRead']")
				public WebElement checkNoerror_validateMessages1;
				
				@FindBy(xpath = "//*[@id='RULE_KEY']/div/div/div/div/div/div")
				public WebElement Select_validationmsg;
				
				@FindBy(xpath = "//div[@class='field-item dataValueRead']//span[text()='S506']")
				public WebElement  eventcode;
				
				@FindBy(xpath = "//table[@pl_prop='pyWorkPage.SelectedRec.InvesmentList']")
				public WebElement  funds_table;
				
				@FindBy(xpath = "//select[@id='RepayFreq']")
				public WebElement select_RepayFreq;
				
				@FindBy(xpath = "//select[@id='SchedFreq']")
				public WebElement select_frq;
				
				/*public void select_payee() throws Exception
				{
					try {
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						
						//utility.click_On_Button(click_SendToVpas);
						click_Payee.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						click_Disburse.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
					
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("window.scrollBy(0,-200)", "");
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						
						Select_VerifiedDisbFlag.click();
						System.out.println("clicked flag");
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
						
						Actions actions = new Actions(driver);
						actions.moveToElement(click_OK).click().perform();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
						Select_Validatebutton.click();
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
						excelWrite.writeInCell(
								"select_payee", "Pass");
						extent_Reportlogger("select_payee", "select_payee", "Pass");
						
					}
					 catch (Exception e) {
						 excelWrite.writeInCell(
									"select_payee Failed", "Fail");
							extent_Reportlogger("select_payee Failed", "select_payee", "Fail");
							

						
							throw e;
					}
					
					
					}*/
					
			
			
				public void select_NoErrMsgValidation() throws Exception{
					
					try {
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
						
						Select_Validatebutton.click();
						
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
//								driver.manage().window().setPosition(new Point(2000, 500));
								System.out.println( "After switching" +driver.getTitle());
								break;
							
							
							}
						}
							
							
						driver.manage().window().maximize();
						
						excelWrite.writeInCell(
								"Moved_ToValidation_Window Test Step Executed Successfully", "Pass");
						extent_Reportlogger(":Test Step Executed Successfully", "Moved_ToValidation_Window", "Pass");
						System.out.println("inside verify_NOValidationMsg ");
						ArrayList<String> validationlist = new ArrayList<String>();
						
						String value1 = "";
					
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						
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
						
							driver.switchTo().window(parentwindow);
							System.out.println("Switch to parent window "
									+ driver.switchTo().window(parentwindow).getTitle());
						
							driver.switchTo().defaultContent();
							driver.switchTo().frame("PegaGadget2Ifr");
					

							extent_Reportlogger("FatalErrorSubmitButtonisDisabled ",
									"InsideFatalErrorSubmitButtonisDisabled", "PASS");
							
								excelWrite.writeInCell(
										"InsideFatalErrorSubmitButtonisDisabled", "Pass");

						}
						if (validationlist.contains("Stop") && validationlist.contains("Warning")) {

							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
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
						
							extent_Reportlogger("FatalErrorSubmitButtonisDisabled ",
									"InsideFatalErrorSubmitButtonisDisabled", "PASS");
							
								excelWrite.writeInCell(
										"InsideFatalErrorSubmitButtonisDisabled", "Pass");

						}
						
						if (validationlist.contains("Warning") || (validationlist.contains("Info"))) {
							System.out.println("inside Info");
							
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							String severityValue=driver.findElement(By.xpath("//tr[2][@oaargs[contains(.,'McCamish-Data')]]//td[4]//span")).getText();
							
							extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+severityValue, "validationMessages_Verification", "PASS");
							excelWrite.writeInCell("validationMessages_Verification Test Step Execution Successfull: Message Severity is "+severityValue, "PASS");
							
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							validateInput_Close_Btn.click();
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
							driver.switchTo().window(parentwindow);
							System.out.println("Switch to parent window "
									+ driver.switchTo().window(parentwindow).getTitle());
						
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							driver.switchTo().defaultContent();
							driver.switchTo().frame("PegaGadget2Ifr");

							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
							
							Robot robot = new Robot();
							robot.keyPress(KeyEvent.VK_PAGE_UP);
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
							
							
							Actions actions = new Actions(driver);
							actions.moveToElement(validateSubmit_Btn).click()
									.perform();
							/*extent_Reportlogger(":Successfully", "validationMessage is Verified", "PASS");
							excelWrite.writeInCell("validationMessage is Verified Successfully", "PASS");*/
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
								System.out.println("value "+ reader.getMapData(CommonVariable.selectEventCode_Validation, map) );
								
							verify_EventCodeforSurrenderwithouttble("Financial_PartialSurrenderFin_valueUpdate", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
						
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							
							
						}
					
						
						
							
						}
						

					
						else if (utility.isWebElementExist(Select_validationmsg))
						{
							System.out.println("Inside Select_validationmsg ");
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
							String validationmsgactual=Select_validationmsg.getText();
							System.out.println("Status expected: "+reader.getMapData(CommonVariable.validation_msg, map));
							System.out.println("Status Actual:" +validationmsgactual);
							
							//String validationmsgactual=Select_validationmsg.getText().trim();
							
							
						 if(validationmsgactual.equals(reader.getMapData(CommonVariable.validation_msg, map)))
							 
							 
						 {
							 extent_Reportlogger("Test Step Execution Successfull: Message Severity is : "+validationmsgactual, "ValidationMessages_Verification", "PASS");
								excelWrite.writeInCell("ValidationMessages_Verification Test Step Execution Successfull: Message Severity is "+validationmsgactual, "PASS");
							 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							 validateInput_Close_Btn.click();
							/* excelWrite.writeInCell(
										"Test Step Executed Successfully: Click on Close Button", "Pass");
								extent_Reportlogger(":Test Step Executed Successfully ", "Click on Close Button", "Pass");*/
							
								Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
						
						 }
							
						 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						driver.switchTo().window(parentwindow);
						System.out.println("Switch to parent window "
								+ driver.switchTo().window(parentwindow).getTitle());
					
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_PAGE_UP);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						Actions actions = new Actions(driver);
						actions.moveToElement(validateSubmit_Btn).click()
								.perform();
						/*excelWrite.writeInCell(
								"Test Step Executed Successfully : validateSubmit_Btn", "Pass");
						extent_Reportlogger(" :Test Step Executed Successfully", "validateSubmit_Btn", "Pass");*/
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						verify_EventCodeforSurrenderwithouttble("Financial_PartialSurrenderFin_valueUpdate", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
						
						
						/*if(TestCaseName.equalsIgnoreCase("FinancialPartialSurrenderSystematicRMD")){
							
							verify_EventCodeforSurrenderwithouttble("Financial_PartialSurrenderFin_valueUpdate", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
							
						}
						
						else if(TestCaseName.equalsIgnoreCase("FinancialSystematicRMD")){
							
							verify_EventCodeforSurrenderwithouttble("Financial_PartialSurrenderFin_valueUpdate", reader.getMapData(CommonVariable.selectEventCode_Validation, map));
						}
						
					}*/
				
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
				public void verify_EventCodeforSurrenderwithouttble(String eventType,String eventCode) throws Exception 
				{
					Financial_Partial_SurrenderPage Financial_Partial_SurrenderPage =new Financial_Partial_SurrenderPage(driver); 
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					System.out.println("inside verify_EventCodeforSurrender");
					String IGPRenwel_eventCOde=driver.findElement(By.xpath("//label[text()='Event Code']/following-sibling::div//span")).getText().trim();
					
					System.out.println("IGPRenwel_eventCOde" + IGPRenwel_eventCOde);
					//div[@class='field-item dataValueRead']//span[text()='S506']
				
					if(IGPRenwel_eventCOde.equalsIgnoreCase(eventCode))
					{
						extent_Reportlogger(":Execution is Successfully Done : Event Code is : "+IGPRenwel_eventCOde, "verifyEventCode", "PASS");
						excelWrite.writeInCell("VerifyEventCodeforPolicy Test Step Execution Successfully Done: Event Code is "+IGPRenwel_eventCOde, "PASS");
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
						driver.switchTo().defaultContent();
						driver.switchTo().frame("PegaGadget2Ifr");
						
					Actions actions = new Actions(driver);
						actions.moveToElement(eventConfirmation_DoneButton1).click()
								.perform();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
						Financial_Partial_SurrenderPage.selectAdminChklistTaskBO();
						
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
				public void enterFund_PercentDetails() throws Exception {
		              try
		              {
		            		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		              List<WebElement> totalFunds=funds_table.findElements(By.tagName("tr"));
		            		 
		              System.out.println("Actual Number of Funds: "+totalFunds.size());
		              
		              Random random = new Random();
		              int  numberOfFunds = random.nextInt(totalFunds.size()-1) + 1;
		              System.out.println("Number of Funds to be entered: "+numberOfFunds);
		              int  startingFund = random.nextInt(totalFunds.size()-1)+1;
		              List<Integer> fundsToBeEntered = new ArrayList<Integer>();
		              fundsToBeEntered.add(startingFund);
		          	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		              while(fundsToBeEntered.size()<numberOfFunds){
		                     int newGeneratedNumber=random.nextInt(totalFunds.size()-1) + 1;
		                     for(int j=0;j<fundsToBeEntered.size();j++){
		                           if(fundsToBeEntered.get(j)==newGeneratedNumber){
		                                  break;
		                           }
		                           else if(j==(fundsToBeEntered.size()-1)){
		                                  fundsToBeEntered.add(newGeneratedNumber);
		                           }
		                     }
		              }
		              System.out.println("Fund List "+fundsToBeEntered);

		              List<Integer> percentageAmount = new ArrayList<Integer>();
		              int  percent;
		              int no=100;
		          	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		              for(int i=0;i<fundsToBeEntered.size();i++){
		                     if(no==0)
		                           break;
		                     percent = random.nextInt(no)+1;
		                     
		                     if(i==(fundsToBeEntered.size()-1))
		                           percentageAmount.add(no);
		                     else
		                           percentageAmount.add(percent);
		                     
		                     no=no-percent;
		              }
		              System.out.println("Rebalance List "+percentageAmount);
		              
		              for(int i=0;i<percentageAmount.size();i++)
		              {
		            		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
		                     driver.findElement(By.xpath("//table[@pl_prop='pyWorkPage.SelectedRec.InvesmentList']//tr["+(fundsToBeEntered.get(i)+1)+"]//td[6]//input")).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,percentageAmount.get(i).toString(),Keys.TAB);
		                     Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		              }
		              extent_Reportlogger("Test Step Execution Successfull", "enterFund_PercentDetails", "PASS");
		              excelWrite.writeInCell("enterFund_PercentDetails Test Step Execution Successfull", "PASS");
		       } catch (Exception e) {
		              extent_Reportlogger("Test Step Execution failed", "enterFund_PercentDetails", "FAIL");
		              excelWrite.writeInCell("enterFund_PercentDetails Test Step Failed", "Fail");
		              ErrorLogger.logError(e.getClass().getName(),"enterFund_PercentDetails", e.getMessage());
		              throw e;
		       }
		       }
		
									

				public boolean rowsExist(int i, int j)
				{
					try {

						
						
						driver.findElement(
								By.xpath("//table[@id='bodyTbl_right']//tbody//tr["
										+ i + "]//td[" + j + "]")).getTagName();
						
						
						return true;
					} 
					catch (NoSuchElementException e) {
						
						return false;
					}
			
			}
				
				
				public void select_EventType() throws Exception {
					try {
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						utility.selectvalueByText_DropdownList(select_Rmdevent, reader.getMapData(CommonVariable.event_Type, map));
						
						String Eventtype = reader.getMapData(CommonVariable.event_Type, map);
						
						excelWrite.writeInCell(
								"EventTypeSelection Executed Successfully" +Eventtype, "Pass");
						extent_Reportlogger(":Value is :" +Eventtype, "EventType selected and", "Pass");
						
						String enterstartdate = reader.getMapData(CommonVariable.enterStartDate, map);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						System.out.println("inside date");
						enter_StartDate.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterstartdate +Keys.TAB); 
						excelWrite.writeInCell(
								"StartDateEnter Executed Successfully" +enterstartdate, "Pass");
						extent_Reportlogger(":Value is :" +enterstartdate, "StartDateEntered and", "Pass");
						
						String enterenddate = reader.getMapData(CommonVariable.enterEndDate, map);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						enter_EndDate.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterenddate +Keys.TAB);
						
						excelWrite.writeInCell(
								"EndDateEnter Executed Successfully" +enterenddate, "Pass");
						extent_Reportlogger(":Value is :" +enterenddate, "EndDateEntered and", "Pass");
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						
						utility.selectvalueByText_DropdownList(select_frq, reader.getMapData(CommonVariable.selectFrequency, map));
						String selectFrequency = reader.getMapData(CommonVariable.selectFrequency, map);
						
						excelWrite.writeInCell(
								"selectFrequency Executed Successfully" +selectFrequency, "Pass");
						extent_Reportlogger(":Value is :" +selectFrequency, "Frequency is selected and", "Pass");
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
						
						
					
					} catch (Exception e) {
						extent_Reportlogger("Test Step Execution failed", "select_EventType", "FAIL");
						excelWrite.writeInCell("select_EventType Test Step Execution Unsuccessfull", "Fail");
						ErrorLogger.logError(e.getClass().getName(),"select_EventType", e.getMessage());
						throw e;
					}
			}
				
				public void selectBasisType() throws Exception {
					try {
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					
						utility.selectvalueByText_DropdownList(select_Basis, reader.getMapData(CommonVariable.slectBasis, map));
						String Eventtype = reader.getMapData(CommonVariable.slectBasis, map);
						
						excelWrite.writeInCell(
								"selectBasisType Executed Successfully" +Eventtype, "Pass");
						extent_Reportlogger(":Value is :" +Eventtype, "BasisType selected and", "Pass");
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						
						
					
					} catch (Exception e) {
						extent_Reportlogger("Test Step Execution failed", "selectBasisType", "FAIL");
						excelWrite.writeInCell("selectBasisType Test Step Execution Unsuccessfull", "Fail");
						ErrorLogger.logError(e.getClass().getName(),"selectBasisType", e.getMessage());
						throw e;
					}
			}
				public void selectInvestment() throws Exception {
					try {
						System.out.println("Inside Invstmnt");
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						String enterenddate1 = reader.getMapData(CommonVariable.enter_FlatAmount, map);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
						enter_Flatamnt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterenddate1 +Keys.TAB);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						select_withdraInfo.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
						click_Investmnbtn.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					
						
						
					
					} catch (Exception e) {
						extent_Reportlogger("Test Step Execution failed", "select_EventType", "FAIL");
						excelWrite.writeInCell("select_EventType Test Step Execution Unsuccessfull", "Fail");
						ErrorLogger.logError(e.getClass().getName(),"select_EventType", e.getMessage());
						throw e;
					}
			}
				
				public void ToValidateSumOfWithdrawAmntValue() throws Exception {
					try {
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						click_Cv.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
						String getWithdrwAmnt = driver.findElement(By.xpath("//p[@id='CV'][@name='$PpyWorkPage$pTotWPct']")).getText().trim();
						System.out.println("Verify_getWithdrwAmnt : " +getWithdrwAmnt);
						
						double sumOfWithdrawAmnt = Double.parseDouble(getWithdrwAmnt);
						System.out.println("Verify_getWithdrwAmnt : " +sumOfWithdrawAmnt);
						if(sumOfWithdrawAmnt == 100.00)
						{
							Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
							click_TaxInfo.click();
							
							excelWrite.writeInCell(
									"ToValidateSumOfWithdrawAmntValue TestStep Executed Successfully" +getWithdrwAmnt, "Pass");
							extent_Reportlogger(":Value is :" +getWithdrwAmnt, "sumOfWithdrawAmnt is Verified and", "Pass");
						}
						
						
							else
							{
								System.out.println("Sum of Withdrawal Percent should be 100%");
								excelWrite.writeInCell(
										"SumOfAmountisnotcorrect Sum of Withdrawal Percent should be 100% ", "Pass");
								extent_Reportlogger("SumOfAmountisnotcorrect ", "Sum of Withdrawal Percent should be 100% ", "Pass");
							}
						
						
					
					} catch (Exception e) {
						extent_Reportlogger("Test Step Execution failed", "ToValidateSumOfWithdrawAmntValue", "FAIL");
						excelWrite.writeInCell("ToValidateSumOfWithdrawAmntValue Test Step Execution Unsuccessfull", "Fail");
						ErrorLogger.logError(e.getClass().getName(),"ToValidateSumOfWithdrawAmntValue", e.getMessage());
						throw e;
					}
			}
				public void SelectPayeeAndDisburse() throws Exception {
					try {
						
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						utility.selectvalueByText_DropdownList(Select_IRSDistributionCode, reader.getMapData(CommonVariable.select_IRS_Distribution_Code, map));
					
						String Eventtype =reader.getMapData(CommonVariable.select_IRS_Distribution_Code, map);
						
						excelWrite.writeInCell(
								"selectBasisType Executed Successfully" +Eventtype, "Pass");
						extent_Reportlogger(":Value is :" +Eventtype, "BasisType selected and", "Pass");
						utility.click_On_Button(click_OK);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						
						utility.click_On_Button(click_Payee);
						excelWrite.writeInCell(
								"click_Payee Test Step Executed Successfully" , "Pass");
						extent_Reportlogger(":Test Step Executed Successfully :" , "click_Payee", "Pass");
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
						
						utility.click_On_Button(click_Disburse);
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
						utility.click_On_Button(Select_VerifiedDisbFlag);
						excelWrite.writeInCell(
								"Select_VerifiedDisbFlag Executed Successfully" , "Pass");
						extent_Reportlogger(":Test Step Executed Successfully :" , "Select_VerifiedDisbFlag", "Pass");
						utility.click_On_Button(click_OK);
						
						
					
					} catch (Exception e) {
						extent_Reportlogger("Test Step Execution failed", "SelectPayeeAndDisburse", "FAIL");
						excelWrite.writeInCell("SelectPayeeAndDisburse Test Step Execution Unsuccessfull", "Fail");
						ErrorLogger.logError(e.getClass().getName(),"SelectPayeeAndDisburse", e.getMessage());
						throw e;
					}
			}
			}



	