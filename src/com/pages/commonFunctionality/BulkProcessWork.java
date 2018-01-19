package com.pages.commonFunctionality;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


public class BulkProcessWork extends Initialize_Browser{
	
	BaseUtils utility = new BaseUtils(driver);
	public BulkProcessWork(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		//Case Type table
		@FindBy(id = "pyTempOperatorAssignedTo")
		public WebElement assignedToOperator_drpDwn;
		
		@FindBy(id = "pyTempOperatorCaseType")
		public WebElement caseType_drpDwn;
		
		@FindBy(xpath = "pyTempOperatorString")
		WebElement workStatus_DrpDwn;

		@FindBy(xpath = "//input[@name='$PpyBulkProcessingPage$ppyConditionList$l2$ppyTempText']")
		WebElement assigneToOperator_txtBox;

		@FindBy(xpath = "//div[text()='Filter Work']")
		WebElement filterWork_Btn;
		
		//Select Action
		@FindBy(xpath = "//div[@node_name='BulkProcessingSelectAll_bckoff']//input[@type='checkbox']")
		WebElement selectAll_chckBox;
		
		@FindBy(xpath = "//div[text()='Select Action ']")
		WebElement selectAction;
		
		@FindBy(xpath = "//td[text()='Transfer assignment']")
		WebElement transferAssignment;
		
		//Re Assign Pop up
		@FindBy(id = "objOperatorSelect")
		WebElement trnsfrToOpr_Drpdwn;
		
		@FindBy(id = "objWBSelect")
		WebElement trnsfrToWB_DrpDwn;

		@FindBy(xpath = "//div[text()='OK']")
		WebElement popupOK_Btn;
		
		//Processing Results
		@FindBy(xpath = "//table[@pl_prop='pyBulkProcessReport.pxResults']")
		WebElement processingResults_table;
		
		public void selectCaseType() throws Exception {
			try {
				assigneToOperator_txtBox.clear();
				assigneToOperator_txtBox.sendKeys(reader.getMapData(CommonVariable.assignedTo_Operator, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				
				extent_Reportlogger("Test Step Execution successfull","selectCaseType", "PASS");
				excelWrite.writeInCell("selectCaseType Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectCaseType", "FAIL");
			excelWrite.writeInCell("selectCaseType Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"selectCaseType", e.getMessage());
			throw e;
		}
		}
		
		public void filterWorkClick() throws Exception {
			try {
				filterWork_Btn.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				
				extent_Reportlogger("Test Step Execution successfull","filterWorkClick", "PASS");
				excelWrite.writeInCell("filterWorkClick Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "filterWorkClick", "FAIL");
			excelWrite.writeInCell("filterWorkClick Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"filterWorkClick", e.getMessage());
			throw e;
		}
}
		
		public void selectActionTransferAssignment() throws Exception{
		try {
				selectAll_chckBox.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				
				selectAction.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				transferAssignment.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				extent_Reportlogger("Test Step Execution successfull","selectActionTransferAssignment", "PASS");
				excelWrite.writeInCell("selectActionTransferAssignment Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectActionTransferAssignment", "FAIL");
			excelWrite.writeInCell("selectActionTransferAssignment Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"selectActionTransferAssignment", e.getMessage());
			throw e;
		}
}

		public void reAssignPopup(String toCSROrWB) throws Exception{
			try {
				if(toCSROrWB.equals("CSR")){
					utility.selectvalueByText_DropdownList(trnsfrToOpr_Drpdwn, reader.getMapData(CommonVariable.transferTo_Operator, map));
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				}
				else if(toCSROrWB.equals("WB")){
					utility.selectvalueByText_DropdownList(trnsfrToWB_DrpDwn, reader.getMapData(CommonVariable.transferTo_WB, map));
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				}
					popupOK_Btn.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
					
					extent_Reportlogger("Test Step Execution successfull","reAssignPopup_"+toCSROrWB, "PASS");
					excelWrite.writeInCell("reAssignPopup_"+toCSROrWB+" Test Step Execution successfull", "PASS");
			} catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "reAssignPopup_"+toCSROrWB, "FAIL");
				excelWrite.writeInCell("reAssignPopup_"+toCSROrWB+" Test Step Failed", "FAIL");
				ErrorLogger.logError(e.getClass().getName(),"reAssignPopup_"+toCSROrWB, e.getMessage());
				throw e;
			}
	}

		public void processingResultsUpdate_AfterTransfer() throws Exception{
			try {
					List<WebElement> selectActionResults=driver.findElements(By.xpath("//table[@pl_prop='pyBulkProcessReport.pxResults']//tr[@id[contains(.,'$PpyBulkProcessReport$ppxResults$')]]"));
					int i=1;
					int size=selectActionResults.size();
					while(i<=selectActionResults.size()){
						String processing_Result=driver.findElement(By.xpath("//table[@pl_prop='pyBulkProcessReport.pxResults']//tr[@id[contains(.,'$PpyBulkProcessReport$ppxResults$')]]["+i+"]//td[8]//a")).getText().trim();
						if(processing_Result.equals("Transferred") || processing_Result.equals("Failed") || processing_Result.equals("Skipped")){
							if(i==(selectActionResults.size()-1)){
								extent_Reportlogger("Test Step Execution successfull","processingResultsUpdate_AfterTransfer", "PASS");
								excelWrite.writeInCell("processingResultsUpdate_AfterTransfer Test Step Execution successfull", "PASS");
							}
							i++;
						}
							else{
								extent_Reportlogger("Test Step Execution failed", "processingResultsUpdate_AfterTransfer", "FAIL");
								excelWrite.writeInCell("processingResultsUpdate_AfterTransfer Test Step Failed", "FAIL");
								break;
							}
						}
			} catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "processingResultsUpdate_AfterTransfer", "FAIL");
				excelWrite.writeInCell("processingResultsUpdate_AfterTransfer Test Step Failed", "FAIL");
				ErrorLogger.logError(e.getClass().getName(),"processingResultsUpdate_AfterTransfer", e.getMessage());
				throw e;
			}
		}

		public void failedStatusMessageVerification() throws Exception{
			try {
					List<WebElement> selectActionResults=driver.findElements(By.xpath("//table[@pl_prop='pyBulkProcessReport.pxResults']//tr[@id[contains(.,'$PpyBulkProcessReport$ppxResults$')]]"));
					int i=1;
					while(i<=selectActionResults.size()){
						String processing_Result=driver.findElement(By.xpath("//table[@pl_prop='pyBulkProcessReport.pxResults']//tr[@id[contains(.,'$PpyBulkProcessReport$ppxResults$')]]["+i+"]//td[8]//a")).getText().trim();
						if(processing_Result.equals("Failed"))
						{
							String failed_Msg=driver.findElement(By.xpath("//table[@pl_prop='pyBulkProcessReport.pxResults']//tr[@id[contains(.,'$PpyBulkProcessReport$ppxResults$')]]["+i+"]//td[8]//a")).getAttribute("title");
							if(failed_Msg.equals("Required skills is not matching with selected operator profile (or) Selected workbasket is not applicable."))
							{
								extent_Reportlogger("Test Step Execution successfull","failedStatusMessageVerification", "PASS");
								excelWrite.writeInCell("failedStatusMessageVerification Test Step Execution successfull", "PASS");
							}
							else
							{
								extent_Reportlogger("Test Step Execution failed", "failedStatusMessageVerification", "FAIL");
								excelWrite.writeInCell("failedStatusMessageVerification Test Step Failed", "FAIL");
							}
							break;
						}
					}
			}catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "failedStatusMessageVerification", "FAIL");
				excelWrite.writeInCell("failedStatusMessageVerification Test Step Failed", "FAIL");
				ErrorLogger.logError(e.getClass().getName(),"failedStatusMessageVerification", e.getMessage());
				throw e;
			}
		}
}
