package com.functions.addressChange;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.pages.AddressChangeScreens.CSWD_GoodOrderCheckPage;
import com.pages.AddressChangeScreens.CSWD_LandingPage;
import com.pages.AddressChangeScreens.VPAS_PopUpPage;
import com.pages.PolicyChangeScreens.PolicyChange_PerformTransactionScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;

public class InitialCommonScreens_ReusableFunction extends Test_BaseClass {

	public InitialCommonScreens_ReusableFunction(WebDriver driver) {
		this.driver = driver;
	}

	CSWD_LandingPage objLandingPage;
	CSWD_GoodOrderCheckPage cswd_GoodOrderCheckPage;
	BaseUtils utility = new BaseUtils(driver);
	VPAS_PopUpPage verifyMsz;

	public void landing_page() throws Exception {
		try {

			// access to landing page
			objLandingPage = new CSWD_LandingPage(driver);
			objLandingPage.selectCase();

			excelWrite.writeInCell("Landing Page executed", "Pass");

		} catch (WebDriverException e) {

			excelWrite.writeInCell("landing page execution failed", "Fail");
			extent_Reportlogger(" Execution failed", "landing_page", "Fail");

			ErrorLogger.logError(e.getClass().getName(), "landing_page",
					e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	public void selectCategoryAndTransaction() throws Exception {

		try {
			// utility = new BaseUtils(driver);
			String categorySelected = "";
			String policyNumber = "";
			String transactionSelected = "";
			categorySelected = reader.getMapData(
					CommonVariable.select_Category, map);

			policyNumber = reader.getMapData(CommonVariable.policy_Number, map);

			transactionSelected = reader.getMapData(CommonVariable.selectTran,
					map);

			driver.switchTo().frame("PegaGadget1Ifr");
			objLandingPage = new CSWD_LandingPage(driver);

			utility.waitForElement(driver, "//select[@id='KeyTopic1']", 3);

			utility.selectvalueByText_DropdownList(
					objLandingPage.selectCategory_drpdwn,
					reader.getMapData(CommonVariable.select_Category, map));

			utility.enter_Text(objLandingPage.policyNo,
					reader.getMapData(CommonVariable.policy_Number, map));

			utility.click_On_Button(objLandingPage.submit_Btn);
			System.out.println("sdasda");
			/* utility.waitForElement(driver, ".//*[@id='PolicyCategory']", 20); */
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

			utility.selectvalueByText_DropdownList(
					objLandingPage.policyTransaction_drpdwn,
					reader.getMapData(CommonVariable.selectTran, map));

			excelWrite.writeInCell(
					"selectCategoryAndTransaction(Category Selected = "
							+ categorySelected + ", "
							+ "PolicyNumber passed = " + policyNumber + " and "
							+ "Transaction Selected = " + transactionSelected
							+ ")", "Pass");

			extent_Reportlogger(" Executed successfully",
					"selectCategoryAndTransaction", "Pass");

			utility.click_On_Button(objLandingPage.submit_Btn);

		} catch (Exception e) {

			extent_Reportlogger("Execution failed",
					"selectCategoryAndTransaction", "Fail");
			excelWrite.writeInCell(
					"selectCategoryAndTransaction execution failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"selectCategoryAndTransaction", e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	// process exceute checklist
	public void executeChecklist() throws Exception {
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			objLandingPage = new CSWD_LandingPage(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");

			extent_Reportlogger(" Executed successfully", "executeChecklist ",
					"Pass");

			utility.click_On_Link(objLandingPage.executeChecklist);

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

	public void processTasks() throws Exception {
		try {

			// ("Switch to Yes/No Page");
			cswd_GoodOrderCheckPage = new CSWD_GoodOrderCheckPage(driver);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			if ((cswd_GoodOrderCheckPage.taskToPerf_SignVerified_drpdwn != null || cswd_GoodOrderCheckPage.taskToPerf_SignVerified_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.sign_Verified, map)) != null)) {
				utility.select_DropdownList(
						cswd_GoodOrderCheckPage.taskToPerf_SignVerified_drpdwn,
						reader.getMapData(CommonVariable.sign_Verified, map));

			}

			if ((cswd_GoodOrderCheckPage.taskToPerf_ReqIGO_drpdwn != null || cswd_GoodOrderCheckPage.taskToPerf_ReqIGO_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.request_IGO, map)) != null)) {
				utility.select_DropdownList(
						cswd_GoodOrderCheckPage.taskToPerf_ReqIGO_drpdwn,
						reader.getMapData(CommonVariable.request_IGO, map));
			}

			if ((cswd_GoodOrderCheckPage.procDec_SignValidate_drpdwn != null || cswd_GoodOrderCheckPage.procDec_SignValidate_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.SignValidate, map)) != null)) {
				utility.select_DropdownList(
						cswd_GoodOrderCheckPage.procDec_SignValidate_drpdwn,
						reader.getMapData(CommonVariable.SignValidate, map));
			}

			if ((cswd_GoodOrderCheckPage.procDec_NonFinReq_drpdwn != null || cswd_GoodOrderCheckPage.procDec_NonFinReq_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.NonFinReq, map)) != null)) {
				utility.select_DropdownList(
						cswd_GoodOrderCheckPage.procDec_NonFinReq_drpdwn,
						reader.getMapData(CommonVariable.NonFinReq, map));
			}

			if ((cswd_GoodOrderCheckPage.procDec_GoodOrderReq_drpdwn != null || cswd_GoodOrderCheckPage.procDec_GoodOrderReq_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.GoodOrdReq, map)) != null)) {
				utility.select_DropdownList(
						cswd_GoodOrderCheckPage.procDec_GoodOrderReq_drpdwn,
						reader.getMapData(CommonVariable.GoodOrdReq, map));
			}

			extent_Reportlogger("Executed successfully",
					"IGO questions  Processed", "PASS");

			utility.click_On_Button(objLandingPage.submitProcessTask_Btn);

			excelWrite.writeInCell(" IGO questions  Processed", "Pass");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");

			if ((cswd_GoodOrderCheckPage.oFCA_drpdwn != null || cswd_GoodOrderCheckPage.oFCA_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.OFCAsuccessful, map)) != null)) {
				utility.select_DropdownList(
						cswd_GoodOrderCheckPage.oFCA_drpdwn,
						reader.getMapData(CommonVariable.OFCAsuccessful, map));
			}

			utility.click_On_Button(objLandingPage.submitProcessTask_Btn);

			excelWrite.writeInCell("OFAC check Processed = "
					+ CommonVariable.OFCAsuccessful, "Pass");

		} catch (Exception e) {

			extent_Reportlogger(" Execution failed", "processTasks Screen",
					"Fail");
			excelWrite.writeInCell("Failed in Process Task", "Fail");
			ErrorLogger.logError(e.getClass().getName(), "processTasks",
					e.getMessage());
			throw e;
		}

	}

	public void vpas_Submit(String textMsz) throws Exception {
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

				verifyMsz.submit_Vpsa_Btn.click();

				Assert.assertTrue(this.checkStatus(textMsz),
						"verifying the status");
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

	public boolean checkStatus(String textMsz) throws Exception {

		verifyMsz = new VPAS_PopUpPage(driver);
		String Expected = "Resolved-Completed";
		String actual = verifyMsz.status.getText();

		if (actual.equalsIgnoreCase(Expected)) {
			excelWrite.writeInCell(

			textMsz + ":" + actual, "Pass");

			extent_Reportlogger("  :  " + actual, textMsz, "Pass");
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
