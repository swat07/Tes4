package com.functions.premiumProcessing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.PremiumProcessing.Remittance_PremiumPaymntP300;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;
//import com.utility.excelWrite;

public class premiumProcessingCommonOprations extends Test_BaseClass {
	public premiumProcessingCommonOprations(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	BaseUtils utility = new BaseUtils(driver);
	
	
	
	public void processPremiumTasks() throws Exception {
		try {
			
			Remittance_PremiumPaymntP300 Remittance_PremiumPaymntP300 = new Remittance_PremiumPaymntP300(driver);

		
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
		


			if ((Remittance_PremiumPaymntP300.Select_Remitdrpdwn != null || Remittance_PremiumPaymntP300.Select_Remitdrpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.Select_Remitdrp, map)) != null)) {
				utility.select_DropdownList(
						Remittance_PremiumPaymntP300.Select_Remitdrpdwn,
						reader.getMapData(CommonVariable.Select_Remitdrp, map));
				
				String Select_Remitdrp = reader.getMapData(CommonVariable.Select_Remitdrp, map);
				extent_Reportlogger(":Test Step Executed Successfully and Value is =" +Select_Remitdrp, "Select_Remitdrpdown", "PASS");
				excelWrite.writeInCell("Select_AdminChecklist Test Step Executed Successfully: = " + Select_Remitdrp, "Pass");

			}

			

			if ((Remittance_PremiumPaymntP300.select_Payment_drpdwn != null || Remittance_PremiumPaymntP300.select_Payment_drpdwn
					.isDisplayed())
					&& ((reader.getMapData(CommonVariable.select_Paymentdrp, map)) != null)) {
				utility.select_DropdownList(
						Remittance_PremiumPaymntP300.select_Payment_drpdwn,
						reader.getMapData(CommonVariable.select_Paymentdrp, map));
				String Select_Remitdrp = reader.getMapData(CommonVariable.select_Paymentdrp, map);
				extent_Reportlogger(":Test Step Executed Successfully  and Value is = " +Select_Remitdrp, "select_Paymentdrp", "PASS");
				excelWrite.writeInCell("select_Paymentdrp Test Step Executed Successfully: = " + Select_Remitdrp, "Pass");
			}

			
			Remittance_PremiumPaymntP300.submitProcessTask_Btn.click();

			extent_Reportlogger(":Test Step Executed Successfully", "clickOnSubmitProcessTask_Btn", "PASS");
			excelWrite.writeInCell(
					"clickOnSubmitProcessTask_Btn Test Step Executed Successfully", "Pass");
			
			
		} catch (Exception e) {
			
			extent_Reportlogger("Test Step Executed UnSuccessfully", "processPremiumTasks", "FAIL");
			excelWrite.writeInCell(
					"processPremiumTasks Test Step Executed UnSuccessfully", "FAIL");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	
	

}
