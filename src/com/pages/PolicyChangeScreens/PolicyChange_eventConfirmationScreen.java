package com.pages.PolicyChangeScreens;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.Initialize_Browser;

public class PolicyChange_eventConfirmationScreen extends Initialize_Browser {

	public PolicyChange_eventConfirmationScreen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	PolicyChange_PerformTransactionScreen policyPerformTrans_locators;
	BaseUtils utility = new BaseUtils(driver);
	// event confiramtion doi changes table satus

	@FindBy(xpath = "//table[@pl_prop='.PolicyMaintList']")
	public WebElement eventConfirmation_table;

	@FindBy(xpath = ".//table[@pl_prop='.PolicyMaintList']//tr[2]//td[1]//span")
	public WebElement eventConfirmation_currentValue;

	@FindBy(xpath = ".//table[@pl_prop='.PolicyMaintList']//tr[2]//td[2]//span")
	public WebElement eventConfirmation_NewValue;

	@FindBy(xpath = ".//table[@pl_prop='.PolicyMaintList']//tr[2]//td[3]//span")
	public WebElement eventConfirmation_TransactionStatus;

	@FindBy(xpath = ".//table[@pl_prop='.PolicyMaintList']//tr[2]//td[4]//span")
	public WebElement eventConfirmation_EventCode;

	@FindBy(xpath = ".//table[@pl_prop='.PolicyMaintList']//tr[2]//td[5]//span")
	public WebElement eventConfirmation_EventStatus;

	@FindBy(xpath = ".//*[@id='submitButton']")
	public WebElement eventConfirmation_DoneBtn;

	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Done')]")
	public WebElement Done_Button;

	@FindBy(xpath = ".//*[@id='submitButton']")
	public WebElement Submit_empDate;

	// Reduce Face
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Done')]")
	public WebElement reduceFace_DoneBtn;

	@FindBy(xpath = "//table[@pl_prop='.CoveragesInfo']//tr[2]//td[5]")
	public WebElement addCovrge_EventCode;

	@FindBy(xpath = "//table[@pl_prop='.SubmitEventSumm']//tbody//tr[2]//td[1]")
	public WebElement reduceFace_eventCode;

	// Rate Covergae Multiple and substandard
	
	 @FindBy(xpath = ".//table[@pl_prop='.PolicyMaintList']//tr[2]//td[7]")
	 public WebElement RateMultipleandSubstnd;
	 

	// Terminate Coverage
	@FindBy(xpath = "//table[@pl_prop='.SubmitList']//tr[2]//td[2]")
	public WebElement eventConfirmationTerminateCoverage_EventStatus;

	// Emp Date Change
	@FindBy(xpath = "//table[@pl_prop='.EventSummary']//tr[2]//td[1]")
	public WebElement eventConfirmationEmpDateChange_EventStatus;
	
	
	//Phase two etset case
	
	@FindBy(xpath = "//span[contains(text(),'Event Code')]")
			public WebElement dbOChnge_EvntCode;
	
	
	
	@FindBy(xpath = "//div[@pyclassname='McCamish-FW-BckOff-Work-PolicyChanges-AnnuitantChange']//table//tr[2]//td[4]//span")
	public WebElement annuitantEvent_Code;
	
	public void policyChange_EventConfiramtion(String testCaseName,
			String eventCode) throws Exception {

		try {
			
			ArrayList<String> eventlist = new ArrayList<String>();
			String genericSubmit_eventCode = "";
			String eventValues = "";
			String genricDone_eventCode = "";
			String dboeventCode="";

			driver.switchTo().defaultContent();

			driver.switchTo().frame("PegaGadget2Ifr");
			Thread.sleep(2000);
						
	

			if (utility
					.isWebElementExist(eventConfirmation_table)) {

				if (testCaseName.equalsIgnoreCase("C222_LevelCOIRate")
						|| testCaseName
								.equalsIgnoreCase("C216_CoverageUnderwriting") || testCaseName.equalsIgnoreCase("C216_CoveragebckDatedUnderwriting")

						|| testCaseName
								.equalsIgnoreCase("C211_CoverageAge")
						|| testCaseName
								.equalsIgnoreCase("C213_CoverageSex")
						|| testCaseName
								.equalsIgnoreCase("C214_CoverageSmoke")
						|| testCaseName
								.equalsIgnoreCase("C215_CoverageRate")||  testCaseName.equalsIgnoreCase("I211_CoverageAge")|| testCaseName.equalsIgnoreCase("I222_LevelCOIRate")||testCaseName.equalsIgnoreCase("I216_CoverageUnderwriting") ||testCaseName.equalsIgnoreCase("I215_CoverageRate")|| testCaseName.equalsIgnoreCase("I213_CoverageSex") || testCaseName.equalsIgnoreCase("I214_CoverageSmoke")) {
					eventValues = driver
							.findElement(
									By.xpath("//table[@pl_prop='.PolicyMaintList']//tr[2]//td[7]"))
							.getText();
					genericSubmit_eventCode = eventValues;

				}

				if (testCaseName.equalsIgnoreCase("I165_DOIChange")
						|| testCaseName.equalsIgnoreCase("I210_Cellage")
						|| testCaseName.equalsIgnoreCase("C212_CellSex") || testCaseName.equalsIgnoreCase("C210_CellAge") || testCaseName.equalsIgnoreCase("I212_CellSex")) {
					eventValues = driver
							.findElement(
									By.xpath("//table[@pl_prop='.PolicyMaintList']//tr[2]//td[4]"))
							.getText();
					genericSubmit_eventCode = eventValues;
					

				}

			}

			if (testCaseName.equalsIgnoreCase("Policydatechange")) {

				eventConfirmation_DoneBtn.click();

			}
			// reduce face
			

			if (testCaseName.equalsIgnoreCase("C195_Facechanges") || testCaseName.equalsIgnoreCase("I195_FacechangesatIssue") ||testCaseName.equalsIgnoreCase("C185_Facechanges")|| testCaseName.equalsIgnoreCase("C197_FacechangesConversion")) {

				genricDone_eventCode = reduceFace_eventCode
						.getText();

			}

			// addCOverage

			if (testCaseName.equalsIgnoreCase("C150_AddCoverage") || testCaseName.equalsIgnoreCase("I150_AddCoverage")) {

				genricDone_eventCode = addCovrge_EventCode
						.getText();

			}

			// SubStandard and Coverage Rate

			if (testCaseName.equalsIgnoreCase("C218_CoverageSubStandard") ||  testCaseName.equalsIgnoreCase("I218_CoverageSubStandard")) {

				genericSubmit_eventCode = RateMultipleandSubstnd
						.getText();

			}

			if (testCaseName.equalsIgnoreCase("C219_CoverageRate") || testCaseName.equalsIgnoreCase("I219_CoverageRateMult")) {

				genericSubmit_eventCode = RateMultipleandSubstnd
						.getText();

			}

			// Emp Date Change

			if (testCaseName.equalsIgnoreCase("C220_Empdatechange")) {

				genericSubmit_eventCode = eventConfirmationEmpDateChange_EventStatus
						.getText();

			}

			// Terminate Coverage

			if (testCaseName.equalsIgnoreCase("C161_CoverageTermination")) {

				genricDone_eventCode = eventConfirmationTerminateCoverage_EventStatus
						.getText();

			}

			//dbo Change Event Confirmation
			
			if (testCaseName.equalsIgnoreCase("I175_DBOChange") ||testCaseName.equalsIgnoreCase("C175_DBOChange"))
			{
				
				 dboeventCode= dbOChnge_EvntCode.getText();
				String[] words=dboeventCode.split(" ");
				 genericSubmit_eventCode=words[10];
	
			}
			
			if(testCaseName.equalsIgnoreCase("C227_AnnuitantCorrection") || testCaseName.equalsIgnoreCase("I227_AnnuitantCorrection"))
			{
				
			genericSubmit_eventCode = annuitantEvent_Code
					.getText();
			
			}
			
			if (genericSubmit_eventCode != null
					&& !(genericSubmit_eventCode == "")
					&& !(genericSubmit_eventCode.isEmpty())) {

				if (genericSubmit_eventCode.equals(eventCode)) {

					
				
					utility.click_On_Button(eventConfirmation_DoneBtn);
							

					excelWrite.writeInCell(testCaseName + " having  eventCode "
							+ genericSubmit_eventCode
							+ " successfully updated in Vpas ", "pass");
					
					extent_Reportlogger(testCaseName + " having"
							+ genericSubmit_eventCode
							+ " successfully updated in Vpas ",
							"Event Confirmation Screen", "Pass");

					

				} else {

					extent_Reportlogger(testCaseName + " : "

					+ "EventCode does not match ",
							" Event Confirmation execution failed ", "Fail");

					excelWrite.writeInCell("EventCode does not match" + ":"
							+ "Event Confirmation execution failed ", "Fail");

				}
			} else if (genricDone_eventCode != null
					&& !(genricDone_eventCode == "")
					&& !(genricDone_eventCode.isEmpty())) {

				if (genricDone_eventCode.equalsIgnoreCase(eventCode)) {

					
					
					utility.click_On_Button(Done_Button);

					extent_Reportlogger(testCaseName + "  having event code  "
							+ genricDone_eventCode
							+ " is successfully updated in Vpas ",
							" Event Confirmation Screen in ", "Pass");
					
					excelWrite.writeInCell(testCaseName + " having  eventCode "
							+ genricDone_eventCode
							+ " successfully updated in Vpas ", "pass");

				} else {

					extent_Reportlogger(testCaseName + " : "

					+ "EventCode does not match ",
							" Event Confirmation execution failed ", "Fail");

					excelWrite.writeInCell("EventCode does not match" + ":"
							+ "Event Confirmation execution failed ", "Fail");

				}
			}
			
			
		
			

		} catch (Exception e) {
			extent_Reportlogger(testCaseName + " execution Failed",
					"policyChange_EventConfiramtion", "Fail");
			excelWrite.writeInCell("Failed in  Event Confirmation in "
					+ testCaseName, "Fail");
			throw e;
		}

	}
	
	
}
