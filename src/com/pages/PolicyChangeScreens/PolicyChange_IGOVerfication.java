package com.pages.PolicyChangeScreens;

import java.util.concurrent.TimeUnit;

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

public class PolicyChange_IGOVerfication extends Initialize_Browser {
	
	
	
	public PolicyChange_IGOVerfication(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	//@FindBy(linkText = "PCPerformTrans")
	//@FindBy(xpath = ".//*[@id='$PCaseContentsPage$ppxResults$l2$ppxResults$l1']/ul/li[2]/div/a[1]")
	
	@FindBy(xpath = "//li[@id='$PCaseContentsPage$ppxResults$l2$ppxResults$l1']//ul//li[2]//div//a[1]")
	public WebElement pcPerformTrans_linktxt;
	
	
	
	@FindBy(xpath = "//li[@id='$PCaseContentsPage$ppxResults$l2$ppxResults$l1']//ul//li[2]//div//a[1]")
	public WebElement reduceFace_linktxt;
	
	@FindBy(id = "Response1")
	public WebElement taskToPerf_Formreceived_drpdwn;
	
	@FindBy(id = "Response2")
	public WebElement taskToPerf_requiredSignValidated_drpdwn;

	
	@FindBy(id = "Response3")
	public WebElement taskToPerf_ReqIGO_drpdwn;
	
	@FindBy(id = "Finding1")
	public WebElement procDec_SignValidate_drpdwn;
	
	@FindBy(id = "Finding2")
	public WebElement procDec_GoodOrderReq_drpdwn;
	
	@FindBy(xpath = ".//*[@id='submitButton']")
	
	public WebElement submit_Btn;
	
	
	public void policyChange_processTask() throws Exception {

		try
		{
			
			
		

		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		

		
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((taskToPerf_Formreceived_drpdwn != null || taskToPerf_Formreceived_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.appropriate_Formreceived,
						map)) != null)) {
			utility.selectvalueByText_DropdownList(
					taskToPerf_Formreceived_drpdwn,
					reader.getMapData(CommonVariable.appropriate_Formreceived,
							map));
		}

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((taskToPerf_requiredSignValidated_drpdwn != null || taskToPerf_requiredSignValidated_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.reqSign_validated, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					taskToPerf_requiredSignValidated_drpdwn,
					reader.getMapData(CommonVariable.reqSign_validated, map));
		}

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

		if ((taskToPerf_ReqIGO_drpdwn != null || taskToPerf_ReqIGO_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.request_IGO, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					taskToPerf_ReqIGO_drpdwn,
					reader.getMapData(CommonVariable.request_IGO, map));
		}

		

		if ((procDec_SignValidate_drpdwn != null || procDec_SignValidate_drpdwn
				.isDisplayed())
				&& ((reader
						.getMapData(CommonVariable.policysign_Validat, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					procDec_SignValidate_drpdwn,
					reader.getMapData(CommonVariable.policysign_Validat, map));
		}

		

		if ((procDec_GoodOrderReq_drpdwn != null || procDec_GoodOrderReq_drpdwn
				.isDisplayed())
				&& ((reader.getMapData(CommonVariable.GoodOrdReq, map)) != null)) {
			utility.selectvalueByText_DropdownList(
					procDec_GoodOrderReq_drpdwn,
					reader.getMapData(CommonVariable.GoodOrdReq, map));
		}
		

		extent_Reportlogger("processed successfully",
				"iGO Questions ", "Pass");
		excelWrite.writeInCell(
				"iGO Questions processed successfully", "Pass");
		
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("PegaGadget2Ifr");
		 

		submit_Btn.click();
		

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
