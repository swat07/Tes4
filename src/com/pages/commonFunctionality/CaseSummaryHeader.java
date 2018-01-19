package com.pages.commonFunctionality;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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


public class CaseSummaryHeader extends Test_BaseClass 
{
	public CaseSummaryHeader(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);

	@FindBy(xpath = "//label[@for='pyID']/following-sibling::div//span")
	public WebElement case_ID_value;
	
	@FindBy(xpath = "//label[@for='pxUrgencyWork']/following-sibling::div//span")
	public WebElement urgency_value;
	
	@FindBy(xpath = "//label[@for='pyStatusWork']/following-sibling::div//span[2]")
	public WebElement status_value;
	
	@FindBy(xpath = "//label[@for='SourceSystem']/following-sibling::div//span")
	public WebElement initiatedFrom_value;
	
	@FindBy(xpath = "//label[@for='.KeyCategory']/following-sibling::div//span")
	public WebElement category_value;
	
	@FindBy(xpath = "//label[@for='.KeyProductType']/following-sibling::div//span")
	public WebElement product_value;
	
	@FindBy(xpath = "//label[@for='PolicyNo']/following-sibling::div//span")
	public WebElement policyNo_value;
	
	@FindBy(xpath = "//a[@title='Suspend this case']")
	public WebElement terminate_Link;
	
	@FindBy(xpath = "//a[@title='Reopen this case']")
	public WebElement reOpen_Link;
	
	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	public WebElement suspend_Reopen_Popup_Title;
	
	@FindBy(xpath = "//div[@node_name='SuspendFLowMain']//table//tr[1]//label")
	public WebElement suspendPopup_Msg1;
	
	@FindBy(xpath = "//div[@node_name='SuspendFLowMain']//table//tr[2]//label")
	public WebElement suspendPopup_Msg2;
	
	@FindBy(xpath = "//div[@node_name='SuspendFLowMain']//table//table[@class='buttonMainTable ']//Button[text()='  Yes ']")
	public WebElement suspendYes_Btn;
	
	@FindBy(xpath = "//div[@node_name='SuspendFLowMain']//table//table[@class='buttonMainTable ']//Button[text()='  No ']")
	public WebElement suspendNo_Btn;
	
	@FindBy(xpath = "//div[@node_name='ReOpenCase']//label")
	public WebElement reopenPopup_Msg;
	
	@FindBy(id = "SelectedActionActive")
	public WebElement reOpenAction_DrpDwn;
	
	@FindBy(xpath = "//button[text()='  OK ']")
	public WebElement reopenPopup_Ok;
	
	@FindBy(xpath = "//button[text()='  Cancel ']")
	public WebElement reopenPopup_Cancel;
	
	static int befUrgencyValue;
	
	public void caseStatusValidation( String action) throws Exception {

			String status=status_value.getText().trim();
		try {
			System.out.println("Status Actual: "+status);
			//System.out.println("Status expected: "+reader.getMapData(CommonVariable.case_Status, map));
			if(action.equalsIgnoreCase("terminate"))
			{
				if(status.equals(reader.getMapData(CommonVariable.case_Status, map)))
				{
					extent_Reportlogger("Test Step Execution successfull: Expected and Actual Status are same: "+status,"caseStatusValidation", "PASS");
					excelWrite.writeInCell("caseStatusValidation Test Step Execution successfull: Expected and Actual Status are same: "+status, "PASS");
				}
				else
				{
					extent_Reportlogger("Test Step Execution failed: Wrong status update: "+status, "caseStatusValidation", "FAIL");
					excelWrite.writeInCell("caseStatusValidation Test Step Execution Failed: Wrong status update: "+status, "FAIL");
				}
			}
			else if(action.equalsIgnoreCase("reopen"))
			{
				if(reader.getMapData(CommonVariable.case_Status, map).equals("NFIGOCheck"))
				{
					if(status.equals("Pending-GoodOrderCheck"))
					{
						extent_Reportlogger("Test Step Execution successfull: Expected and Actual Status are same: "+status,"caseStatusValidation", "PASS");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution successfull: Expected and Actual Status are same: "+status, "PASS");
					}
					else
					{
						extent_Reportlogger("Test Step Execution failed: Wrong status update: "+status, "caseStatusValidation", "FAIL");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution Failed: Wrong status update: "+status, "FAIL");
					}
				}
				else if(reader.getMapData(CommonVariable.case_Status, map).equals("NFRPCheck"))
				{
					if(status.equals("Pending-RestrictedPersonCheck"))
					{
						extent_Reportlogger("Test Step Execution successfull: Expected and Actual Status are same: "+status,"caseStatusValidation", "PASS");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution successfull: Expected and Actual Status are same: "+status, "PASS");
					}
					else
					{
						extent_Reportlogger("Test Step Execution failed: Wrong status update: "+status, "caseStatusValidation", "FAIL");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution Failed: Wrong status update: "+status, "FAIL");
					}
				}
				else if(reader.getMapData(CommonVariable.case_Status, map).equals("NFProcTrans"))
				{
					if(status.equals("Pending-PerformTransaction"))
					{
						extent_Reportlogger("Test Step Execution successfull: Expected and Actual Status are same: "+status,"caseStatusValidation", "PASS");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution successfull: Expected and Actual Status are same: "+status, "PASS");
					}
					else
					{
						extent_Reportlogger("Test Step Execution failed: Wrong status update: "+status, "caseStatusValidation", "FAIL");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution Failed: Wrong status update: "+status, "FAIL");
					}
				}
				else if(reader.getMapData(CommonVariable.case_Status, map).equals("NFLtrConf"))
				{
					if(status.equals("Pending-Communication"))
					{
						extent_Reportlogger("Test Step Execution successfull: Expected and Actual Status are same: "+status,"caseStatusValidation", "PASS");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution successfull: Expected and Actual Status are same: "+status, "PASS");
					}
					else
					{
						extent_Reportlogger("Test Step Execution failed: Wrong status update: "+status, "caseStatusValidation", "FAIL");
						excelWrite.writeInCell("caseStatusValidation Test Step Execution Failed: Wrong status update: "+status, "FAIL");
					}
				}
			}
			else
			{
				if(status.equals("Resolved-Completed"))
				{
					extent_Reportlogger("Test Step Execution successfull: Expected and Actual Status are same: "+status,"caseStatusValidation", "PASS");
					excelWrite.writeInCell("caseStatusValidation Test Step Execution successfull: Expected and Actual Status are same: "+status, "PASS");
				}
				else
				{
					extent_Reportlogger("Test Step Execution failed: Wrong status update: "+status, "caseStatusValidation", "FAIL");
					excelWrite.writeInCell("caseStatusValidation Test Step Execution Failed: Wrong status update: "+status, "FAIL");
				}
			}
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed: Wrong status update: "+status, "caseStatusValidation", "FAIL");
			excelWrite.writeInCell("caseStatusValidation Test Step Execution Failed: Wrong status update: "+status, "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"caseStatusValidation", e.getMessage());
			throw e;
		}
	}
	
	public void terminateClick() throws Exception {
		try {
			terminate_Link.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			String popUp_Title=suspend_Reopen_Popup_Title.getText();
			String popUp_Msg=suspendPopup_Msg1.getText()+suspendPopup_Msg2.getText();
			
			System.out.println("Popup Title Actual: "+popUp_Title+", Popup Msg Actual: "+popUp_Msg);
			System.out.println("Popup Title Expected: "+reader.getMapData(CommonVariable.terminate_Popup_Title, map)+", Popup Msg Expected: "+reader.getMapData(CommonVariable.terminate_Popup_Msg, map));
			
			if(popUp_Title.equals(reader.getMapData(CommonVariable.terminate_Popup_Title, map)))
			{
				extent_Reportlogger("Test Step Execution successfull: Corrrect Terminate Popup Title- "+popUp_Title,"terminateClick", "PASS");
				excelWrite.writeInCell("terminateClick Test Step Execution successfull: Corrrect Terminate Popup Title- "+popUp_Title, "PASS");
			
				if(popUp_Msg.equals(reader.getMapData(CommonVariable.terminate_Popup_Msg, map)))
				{
					extent_Reportlogger("Test Step Execution successfull: Corrrect Terminate Popup Message- "+popUp_Msg,"terminateClick", "PASS");
					excelWrite.writeInCell("terminateClick Test Step Execution successfull: Corrrect Terminate Popup Message- "+popUp_Msg, "PASS");
				}
				else
				{
					extent_Reportlogger("Test Step Execution failed: Wrong Terminate Popup Message- "+popUp_Msg, "terminateClick", "FAIL");
					excelWrite.writeInCell("terminateClick Test Step Execution Failed: Wrong Terminate Popup Message- "+popUp_Msg, "FAIL");
				}
			}
			else
			{
				extent_Reportlogger("Test Step Execution failed: Wrong Terminate Popup Title- "+popUp_Title, "terminateClick", "FAIL");
				excelWrite.writeInCell("terminateClick Test Step Execution Failed: Wrong Terminate Popup Title- "+popUp_Title, "FAIL");
			}
			
			suspendYes_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(15, TimeUnit.SECONDS));
			
			caseStatusValidation("terminate");
			} catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "terminateClick", "FAIL");
				excelWrite.writeInCell("terminateClick Test Step Execution Failed", "FAIL");
				ErrorLogger.logError(e.getClass().getName(),"terminateClick", e.getMessage());
			throw e;
		}
		}
	
	public void reOpenClick() throws Exception {
		try {
			reOpen_Link.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			String popUp_Title_Actual=suspend_Reopen_Popup_Title.getText().trim();
			String popUp_Msg_Actual=reopenPopup_Msg.getText().trim();
			
			String popUp_Title_Expected=reader.getMapData(CommonVariable.reopen_Popup_Title, map);
			String popUp_Msg_Expected=reader.getMapData(CommonVariable.reopen_Popup_Msg, map);
			
			System.out.println("Into Reopen Title Actual: ("+popUp_Title_Actual+"), Into Reopen Title Expected: ("+popUp_Title_Expected+")");
			System.out.println("Into Reopen Message Actual: ("+popUp_Msg_Actual+"), Into Reopen Message Expected: ("+popUp_Msg_Expected+")");
			
			
			if(popUp_Title_Actual.equals(reader.getMapData(CommonVariable.reopen_Popup_Title, map)))
			{
				extent_Reportlogger("Test Step Execution successfull: Corrrect Reopen Popup Title- "+popUp_Title_Actual,"reOpenClick", "PASS");
				excelWrite.writeInCell("reOpenClick Test Step Execution successfull: Corrrect Reopen Popup Title- "+popUp_Title_Actual, "PASS");
			
				if(popUp_Msg_Actual.equals(reader.getMapData(CommonVariable.reopen_Popup_Msg, map)))
				{
					extent_Reportlogger("Test Step Execution successfull: Corrrect Reopen Popup Message- "+popUp_Msg_Actual,"reOpenClick", "PASS");
					excelWrite.writeInCell("reOpenClick Test Step Execution successfull: Corrrect Reopen Popup Message- "+popUp_Msg_Actual, "PASS");
					
					utility.dropdown_selectByVisibleText(reOpenAction_DrpDwn,reader.getMapData(CommonVariable.reOpen_Action, map));
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					
					reopenPopup_Ok.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(20, TimeUnit.SECONDS));
					
					extent_Reportlogger("Test Step Execution successfull","reOpenPopUpOkClick", "PASS");
					excelWrite.writeInCell("reOpenPopUpOkClick Test Step Execution successfull", "PASS");
				}
				else
				{
					extent_Reportlogger("Test Step Execution failed: Wrong Reopen Popup Message- "+popUp_Msg_Actual, "reOpenClick", "FAIL");
					excelWrite.writeInCell("reOpenClick Test Step Execution Failed: Wrong Reopen Popup Message- "+popUp_Msg_Actual, "FAIL");
				}
			}
			else
			{
				extent_Reportlogger("Test Step Execution failed: Wrong Reopen Popup Title- "+popUp_Title_Actual, "reOpenClick", "FAIL");
				excelWrite.writeInCell("reOpenClick Test Step Execution Failed: Wrong Reopen Popup Title- "+popUp_Title_Actual, "FAIL");
			}
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(15, TimeUnit.SECONDS));
			
			caseStatusValidation("reopen");
			} catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "reOpenClick", "FAIL");
				excelWrite.writeInCell("reOpenClick Test Step Execution Failed", "FAIL");
				ErrorLogger.logError(e.getClass().getName(),"reOpenClick", e.getMessage());
				throw e;
		}
	}

	public void caseSummaryInExecuteCheckList(){
			befUrgencyValue=Integer.parseInt(urgency_value.getText());
	}
	
	public void urgencyUpdate() throws Exception {
		try {
			int afUrgencyValue=Integer.parseInt(urgency_value.getText());
			int adjustUrgencyValue=Integer.parseInt(reader.getMapData(CommonVariable.urgency_Adjust, map));
			if(afUrgencyValue==(befUrgencyValue+adjustUrgencyValue)){
				extent_Reportlogger("Test Step Execution successfull","urgencyUpdate", "PASS");
				excelWrite.writeInCell("urgencyUpdate Test Step Execution successfull", "PASS");
			}
			else{
				extent_Reportlogger("Test Step Execution failed", "urgencyUpdate", "FAIL");
				excelWrite.writeInCell("urgencyUpdate Test Step Execution Failed", "FAIL");
			}
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "urgencyUpdate", "FAIL");
			excelWrite.writeInCell("urgencyUpdate Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"urgencyUpdate", e.getMessage());
			throw e;
		}
	}
	
}
