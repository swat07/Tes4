package com.pages.commonFunctionality;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class GoodOrderCheck extends Test_BaseClass 
{
	public GoodOrderCheck(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);

	@FindBy(xpath = "//table[@pl_prop='.CheckList(Target).ItemsCapture']")
	public WebElement taskToPerf_Table;
	
	@FindBy(id = "")
	public WebElement taskToPerf_drpdwns;
	
	@FindBy(id = "Finding1")
	public WebElement procDec_SignValidate_drpdwn;
	
	@FindBy(id = "Finding2")
	public WebElement procDec_NonFinReq_drpdwn;
	
	@FindBy(id = "Finding3")
	public WebElement good_Order_Rqsvst_drpdwn;
	
	@FindBy(xpath = "//button[text()='  Submit ']")
	public WebElement submit_Btn;
	
	
	public void taskToPerformDrpDwns() throws Exception {
		try {

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			List<WebElement> taskToPerf_TableRows=taskToPerf_Table.findElements(By.tagName("tr"));
			
			for(int i=1;i<taskToPerf_TableRows.size();i++){
				utility.dropdown_selectByVisibleText(driver.findElement(By.id("Response"+i+"")),"Yes");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			}
			extent_Reportlogger("Test Step Execution successfull","taskToPerformDrpDwns", "PASS");
			excelWrite.writeInCell("taskToPerformDrpDwns Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "taskToPerformDrpDwns", "FAIL");
			excelWrite.writeInCell("taskToPerformDrpDwns Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"taskToPerformDrpDwns", e.getMessage());
			throw e;
		}
	}
	
	public void processDecisionDrpDwns() throws Exception {
		try {
			utility.dropdown_selectByVisibleText(procDec_SignValidate_drpdwn,reader.getMapData(CommonVariable.signature_Validation_Qsn, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			utility.dropdown_selectByVisibleText(procDec_NonFinReq_drpdwn,reader.getMapData(CommonVariable.Nonfin_Process_Qsn, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			utility.dropdown_selectByVisibleText(good_Order_Rqsvst_drpdwn,reader.getMapData(CommonVariable.rqvst_Good_Order, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","processDecisionDrpDwns", "PASS");
			excelWrite.writeInCell("processDecisionDrpDwns Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "processDecisionDrpDwns", "FAIL");
			excelWrite.writeInCell("processDecisionDrpDwns Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"processDecisionDrpDwns", e.getMessage());
			throw e;
		}
	}
	
	public void submit() throws Exception {
		try {
			submit_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","submit", "PASS");
			excelWrite.writeInCell("submit Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "submit", "FAIL");
			excelWrite.writeInCell("submit Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"submit", e.getMessage());
			throw e;
	}
}

	
}
