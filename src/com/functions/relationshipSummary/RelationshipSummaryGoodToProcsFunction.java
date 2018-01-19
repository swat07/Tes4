package com.functions.relationshipSummary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.RelationshipSummary.RelationshipSummary_Owner_Change;
import com.pages.RelationshipSummary.callPortal.CP_ReltnSummaryAssigneemaintenance;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.Initialize_Browser;
//import com.utility.excelWrite;
import com.utility.Test_BaseClass;

public class RelationshipSummaryGoodToProcsFunction extends Test_BaseClass{
	
	public RelationshipSummaryGoodToProcsFunction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	
	CP_ReltnSummaryAssigneemaintenance ReltnSummaryAssigneemaintenance;
	
	public void selectAdminChklistTask() throws Exception {
		try {
			
			RelationshipSummary_Owner_Change RelationshipSummary_Owner = new RelationshipSummary_Owner_Change(driver);
			utility.selectvalueByText_DropdownList(
					RelationshipSummary_Owner.Select_AdminChecklist,
					 reader.getMapData(CommonVariable.admin_Checklist, map));
			
			String eventtype = reader.getMapData(CommonVariable.admin_Checklist, map);
		
			extent_Reportlogger(":Selected Value is :" +eventtype, "Select_AdminChecklist is done and ", "Pass");
		
			excelWrite.writeInCell("Select_AdminChecklistDone = " + reader.getMapData(CommonVariable.admin_Checklist, map ), "Pass");
			
			utility.selectvalueByText_DropdownList(
					RelationshipSummary_Owner.Select_good_ToProceedforOwner,
					 reader.getMapData(CommonVariable.select_GoodToProceed, map));
			String eventtype1 = reader.getMapData(CommonVariable.select_GoodToProceed, map);
			
			extent_Reportlogger(":Selected Value is :" +eventtype1, "Select_good_ToProceedforOwner is done and ", "Pass");
			
			excelWrite.writeInCell("Select_good_ToProceedforOwnerDone = " + reader.getMapData(CommonVariable.select_GoodToProceed, map ), "Pass");
			
			utility.selectvalueByText_DropdownList(
					RelationshipSummary_Owner.Select_TrackcorrespondenceforOwner,
					 reader.getMapData(CommonVariable.select_Track, map));
			String eventtype3 = reader.getMapData(CommonVariable.select_Track, map);
			
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
