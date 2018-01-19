package com.functions.nonFinancial;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;







import com.pages.AddressChangeScreens.CSWD_GoodOrderCheckPage;
import com.pages.AddressChangeScreens.CSWD_LandingPage;
import com.pages.NonFinancialScreens.NonFinancial_ProcessTask;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class NonFinancial_ProcessTaskFunction extends Initialize_Browser {
	public NonFinancial_ProcessTaskFunction(WebDriver driver) {
		this.driver = driver;
	}
	
	//CSWD_LandingPage objLandingPage;
	BaseUtils utility = new BaseUtils(driver);
	
	public void NonFinancial_processTask() throws Exception {

		try
		{
			
			NonFinancial_ProcessTask NonFinancial_ProcessTasklocators = new NonFinancial_ProcessTask(driver);
			CSWD_GoodOrderCheckPage cswd_GoodOrderCheckPage = new CSWD_GoodOrderCheckPage(driver);
			
	//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		System.out.println("inside frame");

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

	//signature validated dropdown
		if ((NonFinancial_ProcessTasklocators.taskToPerf_requiredSignValidated_drpdwn != null || NonFinancial_ProcessTasklocators.taskToPerf_requiredSignValidated_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.reqSign_validatedNF, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					NonFinancial_ProcessTasklocators.taskToPerf_requiredSignValidated_drpdwn,
					reader.getMapData(CommonVariable.reqSign_validatedNF, map));
		}

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		//Non fin Request dropdown
		if ((NonFinancial_ProcessTasklocators.nonfinreq_drpdwn != null || NonFinancial_ProcessTasklocators.nonfinreq_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.request_NonFin, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					NonFinancial_ProcessTasklocators.nonfinreq_drpdwn,
					reader.getMapData(CommonVariable.request_NonFin, map));
		}

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		


		//Good Order Request question
		if ((NonFinancial_ProcessTasklocators.procDec_GoodOrderReq_drpdwn != null || NonFinancial_ProcessTasklocators.procDec_GoodOrderReq_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.GoodOrdReqNF, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					NonFinancial_ProcessTasklocators.procDec_GoodOrderReq_drpdwn,
					reader.getMapData(CommonVariable.GoodOrdReqNF, map));
		}
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

		
		excelWrite.writeInCell(
				"Task Processed", "Pass");
		
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("PegaGadget2Ifr");

		  NonFinancial_ProcessTasklocators.submit_Btn.click();
		  System.out.println("processed  Task");
		
		//OFAC
		
		if ((cswd_GoodOrderCheckPage.oFCA_drpdwn != null || cswd_GoodOrderCheckPage.oFCA_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.OFCAsuccessful_NF, map)) != null)) {
			utility.select_DropdownList(
					cswd_GoodOrderCheckPage.oFCA_drpdwn,
					reader.getMapData(CommonVariable.OFCAsuccessful_NF, map));
		}
		
		
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0,-200)", "");
		  		
		  //Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		//utility.click_On_Button(objLandingPage.submitProcessTask_Btn);
		  NonFinancial_ProcessTasklocators.ProcessTask_submit.click();
		//objLandingPage.submitProcessTask_Btn.click();
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		System.out.println("Clicked");
		
		
		excelWrite.writeInCell("OFAC check Processed = " + CommonVariable.OFCAsuccessful, "Pass");

	}catch (Exception e) {
		extent_Reportlogger("processTasks excution failed",
				"processTasks Screen", "FAIL");
		excelWrite.writeInCell(
				"Failed in Process Task", "Fail");
		ErrorLogger.logError(e.getClass().getName(), "Non Financial",
				e.getMessage());
		throw e;
	}
		
	}	
	
	
	

}
