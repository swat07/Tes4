package com.functions.policyChange;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.PolicyChangeScreens.PolicyChange_IGOVerfication;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.WriteExcelFile;

public class PolicyChange_IGOVerficationFunction extends Initialize_Browser {
	public PolicyChange_IGOVerficationFunction(WebDriver driver) {
		this.driver = driver;
	}
	

	PolicyChange_IGOVerfication policy_ProcessTasklocators;
	BaseUtils utility = new BaseUtils(driver);
	
	public void policyChange_processTask() throws Exception {

		try
		{
			
			policy_ProcessTasklocators = new PolicyChange_IGOVerfication(driver);
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		System.out.println("inside frame");

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((policy_ProcessTasklocators.taskToPerf_Formreceived_drpdwn != null || policy_ProcessTasklocators.taskToPerf_Formreceived_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.appropriate_Formreceived,
						map)) != null)) {
			utility.selectvalueByText_DropdownList(
					policy_ProcessTasklocators.taskToPerf_Formreceived_drpdwn,
					reader.getMapData(CommonVariable.appropriate_Formreceived,
							map));
		}

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((policy_ProcessTasklocators.taskToPerf_requiredSignValidated_drpdwn != null || policy_ProcessTasklocators.taskToPerf_requiredSignValidated_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.reqSign_validated, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					policy_ProcessTasklocators.taskToPerf_requiredSignValidated_drpdwn,
					reader.getMapData(CommonVariable.reqSign_validated, map));
		}

		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((policy_ProcessTasklocators.taskToPerf_ReqIGO_drpdwn != null || policy_ProcessTasklocators.taskToPerf_ReqIGO_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.request_IGO, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					policy_ProcessTasklocators.taskToPerf_ReqIGO_drpdwn,
					reader.getMapData(CommonVariable.request_IGO, map));
		}

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((policy_ProcessTasklocators.procDec_SignValidate_drpdwn != null || policy_ProcessTasklocators.procDec_SignValidate_drpdwn
				.isDisplayed())
				&& ((reader
						.getMapData(CommonVariable.policysign_Validat, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					policy_ProcessTasklocators.procDec_SignValidate_drpdwn,
					reader.getMapData(CommonVariable.policysign_Validat, map));
		}

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((policy_ProcessTasklocators.procDec_GoodOrderReq_drpdwn != null || policy_ProcessTasklocators.procDec_GoodOrderReq_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.GoodOrdReq, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					policy_ProcessTasklocators.procDec_GoodOrderReq_drpdwn,
					reader.getMapData(CommonVariable.GoodOrdReq, map));
		}
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

		extent_Reportlogger("processed successfully",
				"iGO Questions ", "Pass");
		excelWrite.writeInCell(
				"iGO Questions processed successfully", "Pass");
		
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("PegaGadget2Ifr");
		 

		policy_ProcessTasklocators.submit_Btn.click();
		System.out.println("processed  Task");

	}catch (Exception e) {
		extent_Reportlogger("processTasks excution failed",
				"iGO Questions ", "FAIL");
		excelWrite.writeInCell(
				"Failed in iGO Questions ", "Fail");
		ErrorLogger.logError(e.getClass().getName(), "Policy Change",
				e.getMessage());
		throw e;
	}
		
	}	
	

	
	
}
