package com.pages.Investment_BO;

import java.util.concurrent.TimeUnit;

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
import com.utility.Test_BaseClass;


public class Process_Tasks extends Test_BaseClass{
	
	public Process_Tasks(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	BaseUtils utility = new BaseUtils(driver);
	
	//IGO Verification locators
	@FindBy(id="Finding1")
	public WebElement prcDec_SignValidate_drpdwn;

	@FindBy(id = "Finding2")
	public WebElement procDec_GoodOrderReq_drpdwn;
	
	public void invstment_IGOVerification() throws Exception {
		try
		{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.switchTo().activeElement());
		utility.dropdown_selectByVisibleText(prcDec_SignValidate_drpdwn,reader.getMapData(CommonVariable.policysign_Validated, map));
		
		utility.dropdown_selectByVisibleText(procDec_GoodOrderReq_drpdwn,reader.getMapData(CommonVariable.GoodOrdReq, map));
		
		CSWD_LandingPage objLandingPage =new CSWD_LandingPage(driver);
		utility.click_On_Button(objLandingPage.submitProcessTask_Btn);
		
		extent_Reportlogger(" successfully Executed","invstment_IGOVerification", "Pass");
		excelWrite.writeInCell("invstment_IGOVerification successful", "PASS");
		}
		catch(Exception e)
		{
			extent_Reportlogger(" Execution failed","invstment_IGOVerification", "Fail");
			excelWrite.writeInCell("Failed in invstment_IGOVerification", "Fail");
			ErrorLogger.logError(e.getClass().getName(), "invstment_IGOVerification",e.getMessage());
			throw e;
		}
	}

	public void invCSRLetter_Tasks() throws Exception {
		try
		{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.switchTo().activeElement());
		utility.dropdown_selectByVisibleText(prcDec_SignValidate_drpdwn,reader.getMapData(CommonVariable.transaction_Processed, map));
		utility.dropdown_selectByVisibleText(procDec_GoodOrderReq_drpdwn,reader.getMapData(CommonVariable.track_Correspondence, map));
		CSWD_LandingPage objLandingPage =new CSWD_LandingPage(driver);
		utility.click_On_Button(objLandingPage.submitProcessTask_Btn);
		
		extent_Reportlogger(" successfully Executed","invCSRLetter_Tasks", "Pass");
		excelWrite.writeInCell("invCSRLetter_Tasks successful", "PASS");
		}
		catch(Exception e)
		
		{
			extent_Reportlogger(" Execution failed","invCSRLetter_Tasks", "Fail");
			excelWrite.writeInCell("Failed in invCSRLetter_Tasks", "Fail");
			ErrorLogger.logError(e.getClass().getName(), "invCSRLetter_Tasks",e.getMessage());
			throw e;
			
		}
	}
	
	public void invPerformTrans_Tasks() throws Exception {
		try
		{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.switchTo().activeElement());
		
		utility.dropdown_selectByVisibleText(prcDec_SignValidate_drpdwn,reader.getMapData(CommonVariable.entryPertaining_Request, map));
		
		CSWD_LandingPage objLandingPage =new CSWD_LandingPage(driver);
		utility.click_On_Button(objLandingPage.submitProcessTask_Btn);
		
		extent_Reportlogger(" successfully Executed","invPerformTrans_Tasks", "Pass");
		excelWrite.writeInCell("invPerformTrans_Tasks successful", "PASS");
		}
		catch(Exception e)
		{
			extent_Reportlogger(" Execution failed","invPerformTrans_Tasks", "Fail");
			excelWrite.writeInCell("Failed in invPerformTrans_Tasks", "Fail");
			ErrorLogger.logError(e.getClass().getName(), "invPerformTrans_Tasks",e.getMessage());
			throw e;
			
		}
	}
}
