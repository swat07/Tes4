package com.pages.Workflow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.AddressChangeScreens.CSWD_LandingPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class ReconCheckScreen  extends Initialize_Browser {
	
	public ReconCheckScreen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	BaseUtils utility = new BaseUtils(driver);
	
	
	//@FindBy(id = "Finding1")
	@FindBy(xpath="//select[@id='Finding1']")
	public WebElement taskToPerf_correction;
	
	@FindBy(xpath="//select[@id='Finding2']")
	public WebElement inquiry_igo;
	
	@FindBy(xpath="//button[text()='  Submit ']")
	public WebElement submit;
	
	@FindBy(xpath="//a[contains(text(),' Execute CheckList')]")
	public WebElement executeChecklist;
	
	
	public void processTask() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//System.out.println("inside frame");

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		try {
			if ((taskToPerf_correction!= null || taskToPerf_correction
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.sign_Verified, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.sign_Verified, map));

			}
			
			extent_Reportlogger("Executed successfully",
					"IGO questions  Processed", "PASS");
			excelWrite.writeInCell(" IGO questions  Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
		} catch (Exception e) {
			extent_Reportlogger(":not Processed", "IGO questions", "FAIL");
			excelWrite.writeInCell("IGO questions Processed Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(), "IGO Processed",
					e.getMessage());
			throw e;
		}

	}
	
	
	public void proceTask(String text) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//System.out.println("inside frame");

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		try {
			if ((taskToPerf_correction!= null || taskToPerf_correction
					.isDisplayed())
					/*&& ((reader.getMapData(CommonVariable.sign_Verified, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.sign_Verified, map));*/
				&&((text) != null)) {
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
					utility.selectvalueByText_DropdownList(taskToPerf_correction,
							text);

			}
			
			extent_Reportlogger(":Executed successfully",
					"IGO questions Processed", "PASS");
			excelWrite.writeInCell(" IGO questions Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
		} catch (Exception e) {
			extent_Reportlogger(":not Processed", "IGO questions", "FAIL");
			excelWrite.writeInCell("IGO questions Processed Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(), "IGO Processed",
					e.getMessage());
			throw e;
		}

	}
	
	
	public void proceigo(String text) throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//System.out.println("inside frame");

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		try {
			if ((inquiry_igo!= null || inquiry_igo
					.isDisplayed())
					/*&& ((reader.getMapData(CommonVariable.sign_Verified, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.sign_Verified, map));*/
				&&((text) != null)) {
					//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
					utility.selectvalueByText_DropdownList(inquiry_igo,
							text);

			}
			
			extent_Reportlogger("Executed successfully",
					"IGO questions  Processed", "PASS");
			excelWrite.writeInCell(" IGO questions  Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
		} catch (Exception e) {
			extent_Reportlogger(":not Processed", "IGO questions", "FAIL");
			excelWrite.writeInCell("IGO questions Processed Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(), "IGO Processed",
					e.getMessage());
			throw e;
		}

	}
	
	
	public void quesIGOTask() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//System.out.println("inside frame");

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		try {
			if ((taskToPerf_correction!= null || taskToPerf_correction
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.sign_Verified, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.sign_Verified, map));

			}
			
			extent_Reportlogger(" :Executed successfully",
					" ClntIllustrationReq IGO questions", "PASS");
			excelWrite.writeInCell("ClntIllustrationReq IGO questions  Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			this.SubmitClick("ClntIllustrationReq Page");
			
			if ((taskToPerf_correction!= null || taskToPerf_correction
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.CorrectionReq, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.CorrectionReq, map));

			}
			
			extent_Reportlogger(" :Executed successfully",
					" NGOIllustrationReq IGO questions", "PASS");
			excelWrite.writeInCell("NGOIllustrationReq IGO questions  Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			this.SubmitClick("NGOIllustrationReq Page");
			
			if ((taskToPerf_correction!= null || taskToPerf_correction
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.clientIGO, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.clientIGO, map));

			}
			
			extent_Reportlogger(" :Executed successfully",
					" ClntIllustrationReq IGO questions", "PASS");
			excelWrite.writeInCell("ClntIllustrationReq  IGO questions  Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			this.SubmitClick("ClntIllustrationReq Page");
			
			if ((taskToPerf_correction!= null || taskToPerf_correction
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.generalIGO, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.generalIGO, map));

			}
			
			extent_Reportlogger(" :Executed successfully",
					" GenrateIllustration IGO questions", "PASS");
			excelWrite.writeInCell("GenrateIllustration IGO questions  Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			this.SubmitClick("GenrateIllustration Page");
		} catch (Exception e) {
			extent_Reportlogger(":not Processed", "IGO questions", "FAIL");
			excelWrite.writeInCell("IGO questions Processed Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(), "IGO Processed",
					e.getMessage());
			throw e;
		}

	}
	
	
	public void correctionTask() throws Exception {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//System.out.println("inside frame");

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		try {
			if ((taskToPerf_correction!= null || taskToPerf_correction
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.CorrectionReq, map)) != null)) {
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(taskToPerf_correction,
						reader.getMapData(CommonVariable.CorrectionReq, map));

			}
			
			extent_Reportlogger("Executed successfully",
					"IGO questions  Processed", "PASS");
			excelWrite.writeInCell(" IGO questions  Processed", "Pass");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		} catch (Exception e) {
			extent_Reportlogger(":not Processed", "IGO questions", "FAIL");
			excelWrite.writeInCell("IGO questions Processed Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(), "IGO Processed",
					e.getMessage());
			throw e;
		}

	}
	
	
	public void SubmitClick(String text) throws Exception {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			//submit.click();
			utility.click_On_Button(submit);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			extent_Reportlogger(":Clicked", text+"Submit button", "PASS");
			excelWrite.writeInCell("submit button is clicked successfull",
					"PASS");
		} catch (Exception e) {
			extent_Reportlogger(":not clicked", "submit button", "FAIL");
			excelWrite.writeInCell("submit button Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(), "Submitbutton",
					e.getMessage());
			throw e;
		}
	}
	
	public void executeChecklist() throws Exception {
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			extent_Reportlogger(" Executed successfully", "executeChecklist ",
					"Pass");

			utility.click_On_Link(executeChecklist);

			excelWrite.writeInCell("Clicked on Execute Checklist", "Pass");

		} catch (Exception e) {

			extent_Reportlogger("Execution failed", "executeChecklist Screen",
					"Fail");
			excelWrite.writeInCell("Click on Execute Checklist", "Fail");
			ErrorLogger.logError(e.getClass().getName(), "executeChecklist",
					e.getMessage());
			throw e;
		}
	}

	

}
