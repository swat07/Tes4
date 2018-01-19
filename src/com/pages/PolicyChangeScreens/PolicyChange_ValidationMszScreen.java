package com.pages.PolicyChangeScreens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import com.pages.AddressChangeScreens.VPAS_PopUpPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class PolicyChange_ValidationMszScreen extends Initialize_Browser {

	public PolicyChange_ValidationMszScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	PolicyChange_eventConfirmationScreen evntConfirmFun;
	PolicyChange_PerformTransactionScreen policyChange_locators;
	BaseUtils utility = new BaseUtils(driver);
	VPAS_PopUpPage verifyMsz;
	ArrayList<String> validationlist;

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-Data-ValidateSummery']")
	public WebElement validateMessagesTable;

	
	@FindBy(xpath = "//table[@id='bodyTbl_right']//tbody//tr")
	public WebElement rows;

	@FindBy(xpath = "//table[@pl_prop='.ValidationSummary']")
	public WebElement policyChangedate_validateMessagesTable;

	@FindBy(xpath = ".//*[@id='RULE_KEY']/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/span")
	public WebElement validateMessages;

	@FindBy(xpath = "//table[@aria-label='Validation Messages']/following-sibling::table//div[@class='field-item dataLabelRead']")
	public WebElement checkNoerror_validateMessages1;

	@FindBy(xpath = "//div[@pyclassname='McCamish-FW-BckOff-Work-PolicyChanges-FaceChange']//div[@class='field-item dataLabelRead']")
	public WebElement reduceface_ValidateMsz;
	
	@FindBy(xpath="//table[@pl_prop='.FCValSubmitValSumm']")
	public WebElement reducefaceTble;

	// @FindBy(xpath="//table[@pl_prop='.FCValSubmitValSumm']//div[text()='validation summary']")
	/*
	 * @FindBy(xpath="//table[@summary='.SubmitValidateValSummList']") public
	 * WebElement faceChange_ValidateMsz;
	 */

	@FindBy(xpath = "//table[@pl_prop='.SubmitValidateValSummList']")
	public WebElement faceChange_ValidateMsz;

	@FindBy(xpath = "//div[@node_name='MCDisplayValidateMsgs']//table//tr[1]//td[2]//label")
	public WebElement addCovrage_ValidationMsz;

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-Data-ValidateSummery']")
	public WebElement review_ValidationMsz;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement validateInput_Close_Btn;

	public void validationMessagecheck(String TestcaseName, String eventCode)
			throws Exception {

		try {
			policyChange_locators = new PolicyChange_PerformTransactionScreen(
					driver);

			evntConfirmFun = new PolicyChange_eventConfirmationScreen(driver);

			
			validationlist = new ArrayList<String>();

			String DefaultaddCoverage_ValidationMsZ = "There are no validation messages.";

			String noError_validateMesage = "";
			String value = "";
			// String mainwindow = "";
			String reviewMessages = "";
			String addCovrage_validateMesage = "";

			String parentwindow = driver.getWindowHandle();
			System.out.println("Before switching " + driver.getTitle());

			Set<String> s1 = driver.getWindowHandles();

			Iterator<String> i1 = s1.iterator();
			while (i1.hasNext()) {
				String child_window = i1.next();

				
				if (!parentwindow.equalsIgnoreCase(child_window)) {

					driver.switchTo().window(child_window);
					((JavascriptExecutor) driver)
							.executeScript("window.focus();");

					break;

				}
			}

			driver.manage().window().maximize();

						
			/*if (utility.isWebElementExist(checkNoerror_validateMessages1)){

				noError_validateMesage = checkNoerror_validateMessages1
						.getText();

			}*/
			if (TestcaseName.equalsIgnoreCase("C195_Facechanges") && utility.isWebElementExist(reduceface_ValidateMsz)) {
				
		
				noError_validateMesage = reduceface_ValidateMsz.getText();
				
				
			
				
			}
				
			

			else if ( TestcaseName.equalsIgnoreCase("C195_Facechanges") || TestcaseName.equalsIgnoreCase("I195_FacechangesatIssue") || TestcaseName.equalsIgnoreCase("C185_Facechanges")  || TestcaseName.equalsIgnoreCase("C197_FacechangesConversion")) {

				
				List<WebElement> rows = faceChange_ValidateMsz.findElements(By
						.tagName("tr"));
				List<WebElement> cols = faceChange_ValidateMsz.findElements(By
						.tagName("td"));
				int countRows = rows.size();
				int countCols = cols.size();

				for (int i = 2; i <= countRows; i++) {
					if (rowsExistfaceChange(i))
					{
						value = driver
								.findElement(
										By.xpath("//table[@summary='.SubmitValidateValSummList']//tbody//tr["
												+ i + "]//td[3]")).getText();

						validationlist.add(value);
					} else
						break;
				}

			}
			
			else if (TestcaseName.equalsIgnoreCase("C150_AddCoverage") 
					|| TestcaseName.equalsIgnoreCase("I175_DBOChange") || TestcaseName.equalsIgnoreCase("C175_DBOChange")) {
				addCovrage_validateMesage = addCovrage_ValidationMsz.getText();

			}

			else if (utility.isWebElementExist(checkNoerror_validateMessages1)){

				noError_validateMesage = checkNoerror_validateMessages1
						.getText();

			}
			else	/*if (utility.isWebElementExist(review_ValidationMsz))*/ {

				List<WebElement> rows = validateMessagesTable.findElements(By
						.tagName("tr"));
				List<WebElement> cols = validateMessagesTable.findElements(By
						.tagName("td"));
				int countRows = rows.size();
				int countCols = cols.size();
				System.out.println("inside table");
				System.out.println(countRows + countCols);
				outerLoop: for (int i = 2; i <= countRows; i++) {
					for (int j = 3; j <= 5; j++) {

						if (rowsExist(i, j)) {

							value = driver
									.findElement(
											By.xpath("//table[@pl_prop_class='McCamish-Data-ValidateSummery']//tbody//tr["
													+ i + "]//td[" + j + "]"))
									.getText();

							validationlist.add(value);

						} else {

							break outerLoop;
						}
					}
				}
			}

			if (validationlist.contains("Fatal")
					|| validationlist.contains("Stop")) {

				extent_Reportlogger(
						"CSR is not  able to update "
								+ TestcaseName
								+ " with new value due to Fatal or Stop Severity occur and Submit Button will be disable ",
						
								"  Validation Messages Screen", "Fail");

				utility.click_On_Button(validateInput_Close_Btn);

				excelWrite
						.writeInCell(" CSR is not  able to update "
										+ TestcaseName
										+ " with new value due to Fatal or Stop Severity occur and Submit Button will be disable",
								"Fail");

				driver.switchTo().window(parentwindow);// changes

			}
			else if  ((addCovrage_validateMesage
					.equalsIgnoreCase("There are no validation messages.")
					|| noError_validateMesage
							.equalsIgnoreCase("No Validation Messages") || validationlist
						.contains("Warning")))
			{

			

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
			else  if (addCovrage_validateMesage
						.equalsIgnoreCase("There are no validation messages.")) {
					excelWrite.writeInCell(

					addCovrage_validateMesage + ":" + "CSR is able to update "
							+ TestcaseName + "  with new value.", "Pass");
					extent_Reportlogger(addCovrage_validateMesage + ":"
							+ " CSR is able to update " + TestcaseName
							+ "  with new value. ",
							"  Validation Messages Screen ", "Pass");

				}
			 
			else
				{	
					 

					
					if (!(validationlist.isEmpty())) {
						excelWrite.writeInCell("Warning Severity"
								+ "CSR is able to update " + TestcaseName
								+ "  with new value.", "Pass");
						extent_Reportlogger("CSR is able to update "
								+ TestcaseName + "  with new value. ",
								"Validation Messages Screen ", "Pass");

					}
				}

				utility.click_On_Button(validateInput_Close_Btn);

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				driver.switchTo().window(parentwindow);// changes

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,-100)", "");

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");

				utility.click_On_Button(policyChange_locators.validateInput_Submit_Btn);
				
				
				extent_Reportlogger("Succesfully"," Clicked on submit button and Landing to event Confirmation Screen", "pass");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				

				evntConfirmFun.policyChange_EventConfiramtion(TestcaseName,
						eventCode);
				if(TestcaseName.equalsIgnoreCase("I211_CoverageAge") || TestcaseName.equalsIgnoreCase("I212_CellSex") || TestcaseName.equalsIgnoreCase("I213_CoverageSex")||
						TestcaseName.equalsIgnoreCase("I214_CoverageSmoke") || TestcaseName.equalsIgnoreCase("I215_CoverageRate")||
						TestcaseName.equalsIgnoreCase("I216_CoverageUnderwriting")|| TestcaseName.equalsIgnoreCase("I218_CoverageSubStandard")||
						TestcaseName.equalsIgnoreCase("I219_CoverageRateMult")|| TestcaseName.equalsIgnoreCase("I222_LevelCOIRate")||
						TestcaseName.equalsIgnoreCase("C210_CellAge")|| TestcaseName.equalsIgnoreCase("I175_DBOChange")||
						TestcaseName.equalsIgnoreCase("C175_DBOChange") || TestcaseName.equalsIgnoreCase("I195_FacechangesatIssue")
						|| TestcaseName.equalsIgnoreCase("I150_AddCoverage") ||TestcaseName.equalsIgnoreCase("C185_Facechanges") || TestcaseName.equalsIgnoreCase("C197_FacechangesConversion")|| TestcaseName.equalsIgnoreCase("C227_AnnuitantCorrection") || TestcaseName.equalsIgnoreCase("I227_AnnuitantCorrection") )
				{
					this.vpas_Submit();
				}
				
				
				
				
				

			}else
				
			{
				excelWrite.writeInCell("Message on Validation Messages Screen has not been Verified: "
						+ TestcaseName, "Fail");
				extent_Reportlogger(":"+ TestcaseName,			
						"Message on Validation Messages Screen has not been Verified ", "Fail");

			}
			

		} catch (Exception e) {
			extent_Reportlogger(TestcaseName + " Execution  Failed",
					"policy validationMessagecheck", "Fail");
			excelWrite.writeInCell(
					"policy validationMessagecheck Execution  Failed in"
							+ TestcaseName, "Fail");
			throw e;
		}

	}

	public boolean rowsExist(int i, int j) {
		try {

			driver.findElement(
					By.xpath("//table[@pl_prop_class='McCamish-Data-ValidateSummery']//tbody//tr["
							+ i + "]//td[" + j + "]")).getTagName();

			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean rowsExistfaceChange(int i) {

		try {

			driver.findElement(
					By.xpath("//table[@summary='.SubmitValidateValSummList']//tbody//tr["
							+ i + "]//td[3]")).getTagName();

			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void vpas_Submit() throws Exception {
		try {

			verifyMsz = new VPAS_PopUpPage(driver);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			String peerreviewStatus = verifyMsz.peerReviewStatus.getText();
			// System.out.println("peerreviewStatus"+peerreviewStatus);

			if (peerreviewStatus == null || peerreviewStatus == ""
					|| peerreviewStatus.isEmpty()) {

				utility.selectvalueByText_DropdownList(
						verifyMsz.goodTo_Proceed,
						reader.getMapData(CommonVariable.goodTo_Proceed, map));

				utility.selectvalueByText_DropdownList(verifyMsz.track,
						reader.getMapData(CommonVariable.track_Value, map));

				excelWrite.writeInCell(

				"  Successfully proceed to letter confirmation Screen", "PASS");

				extent_Reportlogger("",
						"Successfully proceed to letter confirmation Screen",
						"Pass");

				utility.click_On_Button(verifyMsz.submit_Vpsa_Btn);

				Assert.assertTrue(this.checkStatus(), "verifying the status");
			} else {

				excelWrite.writeInCell(

				"  Successfully proceed to Pending-Peer Review Screen", "PASS");

				extent_Reportlogger("",
						"Successfully proceed to Pending-Peer Review Screen",
						"Pass");
			}

		} catch (Exception e) {

			ErrorLogger.logError(e.getClass().getName(), "vpas_Submit() ",
					e.getMessage());
			e.printStackTrace();
			throw e;

		}
	}

	public boolean checkStatus() throws Exception {

		verifyMsz = new VPAS_PopUpPage(driver);
		String Expected = "Resolved-Completed";
		String actual = verifyMsz.status.getText();

		if (actual.equalsIgnoreCase(Expected)) {
			excelWrite.writeInCell("Message has  been verified :"

			+ actual, "Pass");

			extent_Reportlogger("  :  " + actual, "Message has  been verified",
					"Pass");
			return true;

		} else {
			excelWrite.writeInCell("Message has not been verified" + ":"
					+ actual, "Fail");

			extent_Reportlogger("  :  " + actual,
					" Message has not been verified ", "Fail");

			return false;
		}
	}

}
