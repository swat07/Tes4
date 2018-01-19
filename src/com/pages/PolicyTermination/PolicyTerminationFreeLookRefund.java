package com.pages.PolicyTermination;


	import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

	import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.pages.AddressChangeScreens.CSWD_GoodOrderCheckPage;
import com.pages.AddressChangeScreens.CSWD_LandingPage;
import com.pages.PolicyChangeScreens.PolicyChange_IGOVerfication;
import com.pages.PolicyChangeScreens.PolicyChange_PerformTransactionScreen;
import com.pages.PolicyChangeScreens.PolicyChange_ValidationMszScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ScreenShot;
import com.utility.Test_BaseClass;

	
	public class PolicyTerminationFreeLookRefund extends Test_BaseClass {
		
		
		
		public PolicyTerminationFreeLookRefund(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		BaseUtils utility = new BaseUtils(driver);
		
		
			
		PolicyTerminationRecessionPage PolicyTermination_Recession;
		CSWD_GoodOrderCheckPage cswd_GoodOrderCheckPage;
		CSWD_LandingPage objLandingPage;
		
		
		@FindBy(id = "Finding1")
		public WebElement procDec_SignValidate_drpdwn;

		
		@FindBy(id = "Finding2")
		public WebElement procDec_GoodOrderReq_drpdwn;
		
		@FindBy(id = "submitButton")
		public WebElement submitProcessTask_Btn;
		
		@FindBy(xpath = "//*[@id='$PCaseContentsPage$ppxResults$l1']/ul/li[2]/div/a[1]")
		public WebElement executeChecklist;
		

		
		public void policyTerminationprocessTasks() throws Exception {
			try {

				// ("Switch to Yes/No Page");
				cswd_GoodOrderCheckPage = new CSWD_GoodOrderCheckPage(driver);
			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
			


				if ((procDec_SignValidate_drpdwn != null || procDec_SignValidate_drpdwn
						.isDisplayed())
						&& ((reader.getMapData(CommonVariable.SignValidate, map)) != null)) {
					utility.select_DropdownList(procDec_SignValidate_drpdwn,reader.getMapData(CommonVariable.SignValidate, map));
					
				String procDecValue = reader.getMapData(CommonVariable.SignValidate, map);
				
					extent_Reportlogger("Selected value is : "+procDecValue, "For procDec_SignValidate", "PASS");
					
					excelWrite.writeInCell(
							"procDec_SignValidate value Selected is : "+procDecValue, "PASS");
					
					
				}
				
		
				
				if ((procDec_GoodOrderReq_drpdwn != null ||procDec_GoodOrderReq_drpdwn
						.isDisplayed())
						&& ((reader.getMapData(CommonVariable.GoodOrdReq, map)) != null)) {
					utility.select_DropdownList(
							procDec_GoodOrderReq_drpdwn,
							reader.getMapData(CommonVariable.GoodOrdReq, map));
					
					String GoodOrdReqValue = reader.getMapData(CommonVariable.GoodOrdReq, map);
					
					extent_Reportlogger("Selected value is : "+GoodOrdReqValue, "For procDec_GoodOrderReq", "PASS");
					
					excelWrite.writeInCell(
							"procDec_GoodOrderReq value Selected  is : "+GoodOrdReqValue, "PASS");
				}

				excelWrite.writeInCell(
						"processTasks excuted successfully", "Pass");
				extent_Reportlogger(":successfully", "processTasks excuted ", "Pass");
				
				
	

				submitProcessTask_Btn.click();
			

				objLandingPage = new CSWD_LandingPage(driver);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");

				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				
				executeChecklist.click();


				excelWrite.writeInCell(
						"Click on Execute Checklist for policy termination", "Pass");
				extent_Reportlogger(":Executed Successfully", "Excecution of Checklist", "Pass");
				
				//ScreenShot.takeScreenShot(driver, "Click on Execute Checklist for ploicy termination", "Click on Execute Checklist for ploicy termination");

				// Switch to yes on OFCA Successfull
			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");

				if ((procDec_SignValidate_drpdwn != null || procDec_SignValidate_drpdwn
						.isDisplayed())
						&& ((reader.getMapData(CommonVariable.restriction_chk, map)) != null)) {
					utility.select_DropdownList(procDec_SignValidate_drpdwn,reader.getMapData(CommonVariable.restriction_chk, map));
					String restriction_chkValue = reader.getMapData(CommonVariable.restriction_chk, map);
					
					extent_Reportlogger("Selected value is : "+restriction_chkValue, "For restriction_chkValue", "PASS");
					
					excelWrite.writeInCell(
							"restriction_chkValue value Selected  is: "+restriction_chkValue, "PASS");
					
				}
				
				submitProcessTask_Btn.click();
				
			
			
				
			} catch (Exception e) {
				extent_Reportlogger("processTasks excution failed",
						"processTasks Screen", "FAIL");
				excelWrite.writeInCell(
						"Failed in Process Task", "Fail");
				ErrorLogger.logError(e.getClass().getName(), "processTasks",
						e.getMessage());
				throw e;
			}

		}
		
		
		
		
		
		public void processTask_Surrender() throws Exception {
			try {

				// ("Switch to Yes/No Page");
				cswd_GoodOrderCheckPage = new CSWD_GoodOrderCheckPage(driver);
				
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
			
				if ((procDec_SignValidate_drpdwn != null || procDec_SignValidate_drpdwn
						.isDisplayed())
						&& ((reader.getMapData(CommonVariable.SignValidate, map)) != null)) {
					utility.select_DropdownList(procDec_SignValidate_drpdwn,reader.getMapData(CommonVariable.SignValidate, map));
					String procDec_SignValidate = reader.getMapData(CommonVariable.SignValidate, map);
					
					extent_Reportlogger("Selected value is : "+procDec_SignValidate, "For procDec_SignValidate", "PASS");
					
					excelWrite.writeInCell(
							"procDec_SignValidate value Selected  is: "+procDec_SignValidate, "PASS");
				}
				
			
				
				
				if ((procDec_GoodOrderReq_drpdwn != null ||procDec_GoodOrderReq_drpdwn
						.isDisplayed())
						&& ((reader.getMapData(CommonVariable.GoodOrdReq, map)) != null)) {
					utility.select_DropdownList(
							procDec_GoodOrderReq_drpdwn,
							reader.getMapData(CommonVariable.GoodOrdReq, map));
					
					String procDec_GoodOrderReq_drpdwn = reader.getMapData(CommonVariable.GoodOrdReq, map);
					
					extent_Reportlogger("Selected value is : "+procDec_GoodOrderReq_drpdwn, "For procDec_GoodOrderReq", "PASS");
					
					excelWrite.writeInCell(
							"procDec_GoodOrderReq value Selected  is: "+procDec_GoodOrderReq_drpdwn, "PASS");
				}
				
				submitProcessTask_Btn.click();

				
				excelWrite.writeInCell(
						"processTasks excuted successfully", "Pass");
				extent_Reportlogger(":Excuted successfully", "ProcessTasks", "Pass");
				
				//ScreenShot.takeScreenShot(driver, "processTasks excuted successfully", "processTasks excuted successfully");
	

			} catch (Exception e) {
				extent_Reportlogger("processTasks excution failed",
						"processTasks Screen", "FAIL");
				excelWrite.writeInCell(
						"Failed in Process Task", "Fail");
				ErrorLogger.logError(e.getClass().getName(), "processTasks",
						e.getMessage());
				throw e;
			}

		}
		
		
	

}