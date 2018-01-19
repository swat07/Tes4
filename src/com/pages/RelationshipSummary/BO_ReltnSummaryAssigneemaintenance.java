package com.pages.RelationshipSummary;

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
import com.utility.Test_BaseClass;

public class BO_ReltnSummaryAssigneemaintenance extends Test_BaseClass{
	
	
	BaseUtils utility = new BaseUtils(driver);

	public BO_ReltnSummaryAssigneemaintenance(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,' Submit ')]")
	public WebElement clkOnSubmit;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit To VPAS')]")
	public WebElement submitToVPAS;
	
	@FindBy(id = "Finding2")
	public WebElement Select_Trackcorrespondence;
	
	@FindBy(id = "Finding1")
	public WebElement Select_AdminChecklist;
	
	public void submitConfirmation () throws Exception{
		try{
			
			
			clkOnSubmit.click();
			
			extent_Reportlogger(":SucessfullyDone", "sendUpdatedAssigneeToVPAS", "PASS");
			excelWrite.writeInCell(
					"sendUpdatedAssigneeToVPASDone", "Pass");

		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "sendUpdatedAssigneeToVPAS", "FAIL");
			
			excelWrite.writeInCell(
					"addNewAssigne", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	
	public void submitConfirmationDD() throws Exception{
		try{
			
			submitToVPAS.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2 , TimeUnit.SECONDS));
			clkOnSubmit.click();
			
			extent_Reportlogger(":SucessfullyDone", "sendUpdatedAssigneeToVPAS", "PASS");
			excelWrite.writeInCell(
					"sendUpdatedAssigneeToVPASDone", "Pass");

		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "sendUpdatedAssigneeToVPAS", "FAIL");
			
			excelWrite.writeInCell(
					"addNewAssigne", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	
	public void selectAdminChklistTaskBO() throws Exception {
		try {
			
			
			utility.selectvalueByText_DropdownList(
					Select_AdminChecklist,
					 reader.getMapData(CommonVariable.admin_Checklist, map));
			
			String eventtype = reader.getMapData(CommonVariable.admin_Checklist, map);
		
			extent_Reportlogger(":Selected Value is :" +eventtype, "Select_AdminChecklist is done and ", "Pass");
		
			excelWrite.writeInCell("Select_AdminChecklistDone = " + reader.getMapData(CommonVariable.admin_Checklist, map ), "Pass");
			utility.selectvalueByText_DropdownList(
					Select_Trackcorrespondence,
					 reader.getMapData(CommonVariable.select_Track, map));
			String eventtype3 = reader.getMapData(CommonVariable.select_Track, map);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			extent_Reportlogger(":Selected Value is :" +eventtype3, "Select_TrackcorrespondenceforOwner is done and ", "Pass");
			
			excelWrite.writeInCell("Select_TrackcorrespondenceforOwnerDone = " + reader.getMapData(CommonVariable.select_Track, map ), "Pass");
			
		}
			
			catch(Exception e)
			{
				extent_Reportlogger(":Fail", "Select_TrackcorrespondenceforOwner", "Fail");
				excelWrite.writeInCell(
						"Select_TrackcorrespondenceforOwner ", "Fail");
			}
		}
	
}
