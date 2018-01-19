package com.pages.commonFunctionality;

import java.text.SimpleDateFormat;
import java.util.Date;
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


public class OtherOptions extends Initialize_Browser 
{
	public OtherOptions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);

	@FindBy(xpath = "//div[text()='Other actions ']")
	public WebElement otherOptions_Menu;
	
	@FindBy(xpath = "//td[@title='Update Work Object Urgency']")
	public WebElement updateUrgency;
	
	//Urgency
	@FindBy(id = "pyUrgencyWorkAdjust")
	public WebElement urgencyAdjust_textBox;
	
	//Add New Question
	@FindBy(id = "pyNote")
	public WebElement qsn_textBox;
	
	@FindBy(id = "SMEorGroup")
	public WebElement sendTo_drpDwn;
	
	//Respond To Question
	@FindBy(xpath = "//textarea[@id='ResponseToQuestion']")
	public WebElement response_textBox;
	
	//Notify Manager
	@FindBy(id = "NotifyManager")
	public WebElement toNotifyManager_textBox;
	
	@FindBy(id = "NotifyQuestion")
	public WebElement notifyQuestion_textBox;
	
	//Create ad hoc Work
	@FindBy(id = "AdhocSelection")
	public WebElement selectYourAction_drpDwn;
	
	@FindBy(id = "pyManualTaskFlowName")
	public WebElement processToStart_drpDwn;
	
	@FindBy(id = "cal$PnewWorkPage$ppySLAActionField")
	public WebElement startDate_txtBox;
	
	@FindBy(id = "cal$PnewWorkPage$ppySLAGoalField")
	public WebElement goalDate_txtBox;
	
	@FindBy(id = "cal$PnewWorkPage$ppySLADeadlineField")
	public WebElement deadlineDate_txtBox;
	
	@FindBy(xpath = "//textarea[@displayedproperty='pyDescription'][@id='EXPAND']")
	public WebElement description_textBox;
	
	@FindBy(xpath = "//div[@id='$PnewWorkPage$ppySLAGoalError']//span")
	public WebElement slaGoal_Error;
	
	@FindBy(xpath = "//div[@id='$PnewWorkPage$ppySLADeadLineError']//span")
	public WebElement slaDeadline_Error;
	
	@FindBy(xpath = "//div[text()='Submit']")
	public WebElement submit_Btn;
	
	@FindBy(id = "pyEffortEstimate")
	public WebElement latestEstimate_textBox;
	
	@FindBy(id = "pyEffortActual")
	public WebElement actual_textBox;
	
	@FindBy(id = "pyProblemReason")
	public WebElement problemReason_TextBox;
	
	@FindBy(id = "pyRootCause")
	public WebElement rootCause_textBox;
	
	@FindBy(id = "pyAssignToTypeResource")
	public WebElement assigneToResource_radiobBtn;
	
	@FindBy(xpath = "//input[@name='$PnewWorkPage$ppyInitialAssignee']")
	public WebElement resource_txtBox;
	
	//return To WorkBasket
	@FindBy(id = "TransferWB")
	public WebElement transferToWB_drpDwn;
	
	@FindBy(xpath = "//button[text()='  Cancel ']")
	public WebElement reopenPopup_Cancel;

	public void selectOtherOptions(String optionToBeSelected) throws Exception {
		try {
			otherOptions_Menu.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			driver.findElement(By.xpath("//td[text()='"+optionToBeSelected+"']")).click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","selectOtherOptions_"+optionToBeSelected, "PASS");
			excelWrite.writeInCell("selectOtherOptions Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectOtherOptions_"+optionToBeSelected, "FAIL");
			excelWrite.writeInCell("selectOtherOptions_"+optionToBeSelected+" Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"selectOtherOptions_"+optionToBeSelected, e.getMessage());
			throw e;
	}
}
	
	public void enterValueToAdjustUrgency() throws Exception {
		try {
			selectOtherOptions("Update Work Object Urgenc...");
			
			urgencyAdjust_textBox.sendKeys(reader.getMapData(CommonVariable.urgency_Adjust, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","enterValueToAdjustUrgency", "PASS");
			excelWrite.writeInCell("enterValueToAdjustUrgency Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterValueToAdjustUrgency", "FAIL");
			excelWrite.writeInCell("enterValueToAdjustUrgency Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"enterValueToAdjustUrgency", e.getMessage());
			throw e;
	}
}
	
	public void addNewQuestionOtherOptions() throws Exception {
		try {
			selectOtherOptions("Add New Question");
			
			qsn_textBox.sendKeys(reader.getMapData(CommonVariable.new_Question, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			utility.selectvalueByText_DropdownList(sendTo_drpDwn, reader.getMapData(CommonVariable.send_To, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","addNewQuestionOtherOptions", "PASS");
			excelWrite.writeInCell("addNewQuestionOtherOptions Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "addNewQuestionOtherOptions", "FAIL");
			excelWrite.writeInCell("addNewQuestionOtherOptions Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"addNewQuestionOtherOptions", e.getMessage());
			throw e;
	}
}

	public void respondToQuestion() throws Exception {
		try {
			response_textBox.sendKeys(reader.getMapData(CommonVariable.responseFor_Question, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			driver.findElement(By.xpath("//button[text()='  Submit ']")).click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","respondToQuestion", "PASS");
			excelWrite.writeInCell("respondToQuestion Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "respondToQuestion", "FAIL");
			excelWrite.writeInCell("respondToQuestion Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"respondToQuestion", e.getMessage());
			throw e;
	}
}
	
	public void notifyOtherOptions() throws Exception {
		try {
			selectOtherOptions("Notify");
			
			toNotifyManager_textBox.sendKeys(reader.getMapData(CommonVariable.notifyTo_Manager, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			toNotifyManager_textBox.sendKeys(reader.getMapData(CommonVariable.responseFor_Question, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","notifyOtherOptions", "PASS");
			excelWrite.writeInCell("notifyOtherOptions Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "notifyOtherOptions", "FAIL");
			excelWrite.writeInCell("notifyOtherOptions Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"notifyOtherOptions", e.getMessage());
			throw e;
	}
}
	
	public void createAdHocWorkOtherOptions() throws Exception {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
            Date startDate = dateFormat.parse(reader.getMapData(CommonVariable.start_Date, map));
            Date goalDate = dateFormat.parse(reader.getMapData(CommonVariable.goal_Date, map));
            Date deadlineDate = dateFormat.parse(reader.getMapData(CommonVariable.deadline_Date, map));
			
			selectOtherOptions("Create Ad Hoc Work");
			
			utility.selectvalueByText_DropdownList(selectYourAction_drpDwn, reader.getMapData(CommonVariable.adHoc_Action, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			utility.selectvalueByText_DropdownList(processToStart_drpDwn, reader.getMapData(CommonVariable.processTo_Start, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			description_textBox.sendKeys(reader.getMapData(CommonVariable.description, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			assigneToResource_radiobBtn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			resource_txtBox.sendKeys(reader.getMapData(CommonVariable.assignTo_Resource, map));
			
			//driver.findElement(By.xpath("//div[@class='autocomplete_normal']")).click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			startDate_txtBox.sendKeys(reader.getMapData(CommonVariable.start_Date, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			goalDate_txtBox.sendKeys(reader.getMapData(CommonVariable.goal_Date, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			deadlineDate_txtBox.sendKeys(reader.getMapData(CommonVariable.deadline_Date, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			submit_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			if(goalDate.before(startDate) || deadlineDate.before(startDate) || deadlineDate.before(goalDate)){
				if(goalDate.before(startDate)){
					if(slaGoal_Error.isDisplayed()){
						extent_Reportlogger("Test Step Execution successfull: Error Icon for Goal Date check displayed","GoalDateErrorIconCheck", "PASS");
						excelWrite.writeInCell("GoalDateErrorIconCheck Test Step Execution successfull: Error Icon for Goal Date check displayed", "PASS");
						
						if(slaGoal_Error.getAttribute("title").equals("** Goal date can not be earlier than the Start Date"))
						{
							extent_Reportlogger("Test Step Execution successfull: ** Goal date can not be earlier than the Start Date","ErrorIconMessage_Verification", "PASS");
							excelWrite.writeInCell("ErrorIconMessage_Verification Test Step Execution successfull: ** Goal date can not be earlier than the Start Date", "PASS");
							
						}
						else{
							extent_Reportlogger("Test Step Execution failed: ** Goal date can not be earlier than the Start Date","ErrorIconMessage_Verification", "FAIL");
							excelWrite.writeInCell("ErrorIconMessage_Verification Test Step Execution failed: ** Goal date can not be earlier than the Start Date", "FAIL");
							
						}
						
					}
					else{
						extent_Reportlogger("Test Step Execution failed","GoalDateErrorIconCheckDisplay", "FAIL");
						excelWrite.writeInCell("GoalDateErrorIconCheckDisplay Test Step Execution failed", "FAIL");
						
					}
				}
				
				if(deadlineDate.before(startDate) && deadlineDate.before(goalDate)){
					if(slaDeadline_Error.isDisplayed())
					{
						extent_Reportlogger("Test Step Execution successfull: Error Icon for Deadline Date check displayed","DeadlineDateErrorIconCheck", "PASS");
						excelWrite.writeInCell("DeadlineDateErrorIconCheck Test Step Execution successfull: Error Icon for Deadline Date check displayed", "PASS");
						
						if(slaGoal_Error.getAttribute("title").equals("** Deadline can not be earlier than the Start Date"+"\n"+"** Deadline can not be earlier than the Goal Date"))
						{
							extent_Reportlogger("Test Step Execution successfull: ** Deadline can not be earlier than the Start Date"+"\n"+"** Deadline can not be earlier than the Goal Date","ErrorIconMessage_Verification", "PASS");
							excelWrite.writeInCell("ErrorIconMessage_Verification Test Step Execution successfull: ** Deadline can not be earlier than the Start Date"+"\n"+"** Deadline can not be earlier than the Goal Date", "PASS");
						}
						else
						{
							extent_Reportlogger("Test Step Execution failed: ** Deadline can not be earlier than the Start Date"+"\n"+"** Deadline can not be earlier than the Goal Date","ErrorIconMessage_Verification", "FAIL");
							excelWrite.writeInCell("ErrorIconMessage_Verification Test Step Execution failed: ** Deadline can not be earlier than the Start Date"+"\n"+"** Deadline can not be earlier than the Goal Date", "FAIL");
						}
						
					}
					else
					{
						extent_Reportlogger("Test Step Execution failed","DeadlineDateErrorIconCheckDisplay", "FAIL");
						excelWrite.writeInCell("DeadlineDateErrorIconCheckDisplay Test Step Execution failed", "FAIL");
					}
				}
				else if(deadlineDate.before(goalDate))
				{
					if(slaDeadline_Error.isDisplayed())
					{
						extent_Reportlogger("Test Step Execution successfull: Error Icon for Deadline Date check displayed","DeadlineDateErrorIconCheck", "PASS");
						excelWrite.writeInCell("DeadlineDateErrorIconCheck Test Step Execution successfull: Error Icon for Deadline Date check displayed", "PASS");
						
						if(slaGoal_Error.getAttribute("title").equals("** Deadline date can not be earlier than the Goal Date"))
						{
							extent_Reportlogger("Test Step Execution successfull: ** Deadline date can not be earlier than the Goal Date","ErrorIconMessage_Verification", "PASS");
							excelWrite.writeInCell("ErrorIconMessage_Verification Test Step Execution successfull: ** Deadline date can not be earlier than the Goal Date", "PASS");
						}
						else
						{
							extent_Reportlogger("Test Step Execution failed: ** Deadline date can not be earlier than the Goal Date","ErrorIconMessage_Verification", "FAIL");
							excelWrite.writeInCell("ErrorIconMessage_Verification Test Step Execution failed: ** Deadline date can not be earlier than the Goal Date", "FAIL");
						}
						
					}
					else
					{
						extent_Reportlogger("Test Step Execution failed","DeadlineDateErrorIconCheckDisplay", "FAIL");
						excelWrite.writeInCell("DeadlineDateErrorIconCheckDisplay Test Step Execution failed", "FAIL");
					}
				}
			}
	}catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "createAdHocWorkOtherOptions", "FAIL");
		excelWrite.writeInCell("createAdHocWorkOtherOptions Test Step Execution Failed", "FAIL");
		ErrorLogger.logError(e.getClass().getName(),"createAdHocWorkOtherOptions", e.getMessage());
		throw e;
	}
}

	public void createAdHocCompleteTask() throws Exception {
		try {
			latestEstimate_textBox.sendKeys(reader.getMapData(CommonVariable.latestEstimate_Days, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			actual_textBox.sendKeys(reader.getMapData(CommonVariable.actual_Days, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","createAdHocCompleteTask", "PASS");
			excelWrite.writeInCell("createAdHocCompleteTask Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "createAdHocCompleteTask", "FAIL");
			excelWrite.writeInCell("createAdHocCompleteTask Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"createAdHocCompleteTask", e.getMessage());
			throw e;
	}
}

	public void returnToWorkbasketOtherOptions() throws Exception {
		try {
			selectOtherOptions("Return To Workbasket");
			
			utility.selectvalueByText_DropdownList(transferToWB_drpDwn, reader.getMapData(CommonVariable.transferTo_WB, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","returnToWorkbasketOtherOptions", "PASS");
			excelWrite.writeInCell("returnToWorkbasketOtherOptions Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "returnToWorkbasketOtherOptions", "FAIL");
			excelWrite.writeInCell("returnToWorkbasketOtherOptions Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"returnToWorkbasketOtherOptions", e.getMessage());
			throw e;
	}
}
}
