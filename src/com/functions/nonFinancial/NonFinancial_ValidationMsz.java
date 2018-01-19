package com.functions.nonFinancial;

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
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.NonFinancialScreens.NonFinancial_PerformTransaction;
import com.pages.NonFinancialScreens.NonFinancial_ValidationScreen;

import com.pages.PolicyChangeScreens.PolicyChange_ValidationMszScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class NonFinancial_ValidationMsz extends Test_BaseClass {

	public NonFinancial_ValidationMsz(WebDriver driver) {
		this.driver = driver;
	}
	
	NonFinancial_ValidationScreen nonFinancial_Validationlocators;
	NonFinancial_PerformTransaction nonfinancial_PerformTransaction;
	BaseUtils utility = new BaseUtils(driver);

	public void validationMessagecheck(String TestcaseName, String eventCode)
			throws Exception {

		try {
			nonFinancial_Validationlocators = new NonFinancial_ValidationScreen(driver
					);

			nonfinancial_PerformTransaction = new NonFinancial_PerformTransaction(driver);
			ArrayList<String> validationlist = new ArrayList<String>();

			// String DefaultaddCoverage_ValidationMsZ =
			// "There are no validation messages.";

			String noError_validateMesage = "";
			String value = "";
			// String mainwindow = "";
			String reviewMessages = "";
			String addCovrage_validateMesage = "";

			String parentwindow = driver.getWindowHandle();
			System.out.println("Before switching " + driver.getTitle());

			Set<String> s1 = driver.getWindowHandles();
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			Iterator<String> i1 = s1.iterator();
			while (i1.hasNext()) {
				String child_window = i1.next();
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
				System.out.println("value" + child_window);
				if (!parentwindow.equalsIgnoreCase(child_window)) {
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7,TimeUnit.SECONDS));
					driver.switchTo().window(child_window);
					((JavascriptExecutor) driver)
							.executeScript("window.focus();");
					// driver.manage().window().setPosition(new Point(2000,
					// 500));
					System.out.println("After switching" + driver.getTitle());
					break;

				}
			}

			driver.manage().window().maximize();
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			if (utility
					.isWebElementExist(nonFinancial_Validationlocators.checkNoerror_validateMessages1)) {

				noError_validateMesage = nonFinancial_Validationlocators.checkNoerror_validateMessages1
						.getText();

			}
			System.out.println("entering fatal");
			if (utility
					.isWebElementExist(nonFinancial_Validationlocators.review_ValidationMsz)) {

				List<WebElement> rows = nonFinancial_Validationlocators.validateMessagesTable
						.findElements(By.tagName("tr"));
				List<WebElement> cols = nonFinancial_Validationlocators.validateMessagesTable
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
											By.xpath("//table[@pl_prop_class='McCamish-Data-ValidateSummery']//tbody//tr["
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
			}

			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			if (validationlist.contains("Fatal")
					|| validationlist.contains("Warning")
					|| validationlist.contains("Stop")) {

				System.out.println("inside fatal");

				extent_Reportlogger(
						"CSR is not  able to update "
								+ TestcaseName
								+ " with new value due to Fatal or Stop Severity occur and Submit Button will be disable ",
						validationlist.get(1) + "" + validationlist.get(2) + ""
								+ "  Validation Messages Screen", "Pass");

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				nonFinancial_Validationlocators.validateInput_Close_Btn.click();
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS)); 
				System.out.println("Error occur");

				excelWrite
						.writeInCell(

								validationlist.get(1)
										+ ""
										+ validationlist.get(2)
										+ " CSR is not  able to update "
										+ TestcaseName
										+ " with new value due to Fatal or Stop Severity occur and Submit Button will be disable",
								"Pass");

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				driver.switchTo().window(parentwindow);// changes

				System.out.println("Switch to parent window "
						+ driver.switchTo().window(parentwindow).getTitle());// changes

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			}

			else if ((addCovrage_validateMesage
					.equalsIgnoreCase("There are no validation messages.")
					|| noError_validateMesage
							.equalsIgnoreCase("No Validation Messages") || validationlist
						.contains("Warning"))) {

				if (noError_validateMesage
						.equalsIgnoreCase("No Validation Messages")) {
					excelWrite.writeInCell(

					noError_validateMesage + ":" + "CSR is able to update "
							+ TestcaseName + "  with new value.", "Pass");
					extent_Reportlogger(noError_validateMesage + ":"
							+ " CSR is able to update " + TestcaseName
							+ "  with new value. ",
							"  Validation Messages Screen ", "Pass");

				}
				if (addCovrage_validateMesage
						.equalsIgnoreCase("There are no validation messages.")) {
					excelWrite.writeInCell(

					addCovrage_validateMesage + ":" + "CSR is able to update "
							+ TestcaseName + "  with new value.", "Pass");
					extent_Reportlogger(addCovrage_validateMesage + ":"
							+ " CSR is able to update " + TestcaseName
							+ "  with new value. ",
							"  Validation Messages Screen ", "Pass");

				}
				if (validationlist.contains("Warning")) {

					String a = validationlist.get(1);
					String b = validationlist.get(2);

					System.out.println("inside warning");
					if (!(validationlist.isEmpty())) {
						excelWrite.writeInCell(

						"" + "" + validationlist.get(1) + " : "
								+ validationlist.get(2)
								+ "CSR is able to update " + TestcaseName
								+ "  with new value.", "Pass");
						extent_Reportlogger("CSR is able to update "
								+ TestcaseName + "  with new value. ",
								"Validation Messages Screen ", "Pass");

					}
				}

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				nonFinancial_Validationlocators.validateInput_Close_Btn.click();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

				driver.switchTo().window(parentwindow);// changes

				System.out.println("Switch to parent window "
						+ driver.switchTo().window(parentwindow).getTitle());// changes

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,-200)", "");

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				Actions actions = new Actions(driver);

				actions.moveToElement(nonFinancial_Validationlocators.validateInput_Submit_Btn).click().perform();

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(15, TimeUnit.SECONDS));
				jse.executeScript("window.scrollBy(0,-200)", "");
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
					System.out.println("Page Loaded and scrolled");
			
				//switch to event confirmation screen button
				
				if (TestcaseName.equalsIgnoreCase("DividendOptionChange")
						) {

					extent_Reportlogger(" Event Sucessfully updated in Vpas ","EventConfirmationScreen", "Pass");
					excelWrite.writeInCell(" Event successfully updated in Vpas ", "pass");
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7,TimeUnit.SECONDS));

					nonfinancial_PerformTransaction.DividendConfirmation_Submit.click();

					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(6,TimeUnit.SECONDS));
					
				}
				
				else if( TestcaseName.equalsIgnoreCase("AgentChange"))
					
				{
					
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));	
					
					jse.executeScript("window.scrollBy(0,-200)", "");
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					nonfinancial_PerformTransaction.Done_AgentChange.click();
					
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("PegaGadget2Ifr");
					System.out.println("sdfsdgfs");
					
					utility.dropdown_selectByValue(nonfinancial_PerformTransaction.NFGoodto_Proceed,reader.getMapData(CommonVariable.NFGoodto_Proceed,map));
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					utility.dropdown_selectByValue(nonfinancial_PerformTransaction.NFtrack_Corros,reader.getMapData(CommonVariable.NFtrack_Corros,map));
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					extent_Reportlogger("respsonse sucessfully selected","AgentChange ProcessDecesionScreen ", "Pass");
					excelWrite.writeInCell(" Process Decesion respsonse successfully selected","pass");
					
					nonfinancial_PerformTransaction.Submit_CommPage.click();
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					
					
				}
				
				
				
				
				
			}
		} catch (Exception e) {
			//e.printStackTrace();
			
		extent_Reportlogger("Execution  Failed",
					"NonFinancial validationMessagecheck", "Fail");
			excelWrite.writeInCell("NonFinancial validationMessagecheck",
					"Fail");
			throw e;

		}

	}

	public boolean rowsExist(int i, int j) {
		try {

			/*
			 * driver.findElement(
			 * By.xpath("//table[@pl_prop='.ValidateList']//tbody//tr[" + i +
			 * "]//td[" + j + "]")).getTagName();
			 */

			driver.findElement(
					By.xpath("//table[@pl_prop_class='McCamish-Data-ValidateSummery']//tbody//tr["
							+ i + "]//td[" + j + "]")).getTagName();

			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
