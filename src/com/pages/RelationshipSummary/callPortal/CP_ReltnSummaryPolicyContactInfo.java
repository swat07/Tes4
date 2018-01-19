package com.pages.RelationshipSummary.callPortal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.functions.relationshipSummary.RelationshipSummaryCommonOprations;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class CP_ReltnSummaryPolicyContactInfo extends Test_BaseClass {
	
		public CP_ReltnSummaryPolicyContactInfo(WebDriver driver){
			this.driver = driver;
			 PageFactory.initElements(driver, this);

	}

		BaseUtils utility = new BaseUtils(driver);
		RelationshipSummaryCommonOprations Relationship_userPersonalDetails;
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Change Contact')]")
		public WebElement click_ChangeConatact;
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Alpha')]")
		public WebElement click_ADDAlpha;
		
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Complete Intent')]")
		public WebElement click_OnCompleteIntent;
		
		@FindBy(id = "submitButton")
		public WebElement click_On_Submit;
		
		
		
		public void clickAddAlpha()throws Exception {
			
			try{
				utility.click_On_Button(click_ChangeConatact);
				utility.click_On_Button(click_ADDAlpha);
				
		
				excelWrite.writeInCell(
						"clicked on click_Contact ", "Pass");
				
				
					extent_Reportlogger("clicked_on_click_Contact", "Login Screen", "PASS");
		
			}
			catch(Exception e){
				extent_Reportlogger(":Failed", "clickChangePOA", "FAIL");
				
				excelWrite.writeInCell(
						"clickChangePOA", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
				
			}
			
		} 
		
		public void selectRelationshipAndEffectiveDate()throws Exception {
			
			try{
				CP_ReltnSummaryPOAUpdates CP_ReltnSummaryPOAUpdates = new CP_ReltnSummaryPOAUpdates(driver);
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				WebElement wb = driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']"));
				List<WebElement> elements=wb.findElements(By.tagName("tr"));
				System.out.println("no of rows: "+ elements.size());
				int enter_COntactChangeData = elements.size();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_COntactChangeData+"]//td[1]//input[@type='checkbox']")).click();
			
				
				System.out.println("MAp value*****"+map);
				
				int i = enter_COntactChangeData-1;
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.selectvalueByText_DropdownList(driver.findElement(By.xpath("//*[@id='RelationCode"+i+"']")), reader.getMapData(CommonVariable.selectReltnshipContactChng, map));
				String Reltnshp =  reader.getMapData(CommonVariable.selectReltnshipContactChng, map);
				
				extent_Reportlogger("Test Step Executed Successfully : =" +Reltnshp, "select_Relationcode", "PASS");
				
				excelWrite.writeInCell("select_Relationcode Test Step Executed Successfully = " + Reltnshp, "Pass"); 
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				
				
				utility.enter_Text(driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_COntactChangeData+"]//td[6]//input")), reader.getMapData(CommonVariable.enter_AccessEndDate, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				String enterAccessEndDate =  reader.getMapData(CommonVariable.enter_AccessEndDate, map);
				
				extent_Reportlogger("Test Step Executed Successfully : =" +enterAccessEndDate, "enter_AccessEndDate", "PASS");
				
				excelWrite.writeInCell("enter_AccessEndDate Test Step Executed Successfully = " + enterAccessEndDate, "Pass"); 
				extent_Reportlogger("enter_AccessEndDate", "contact Change", "PASS");
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				CP_ReltnSummaryPOAUpdates.submit_SendToVpas.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					Actions action = new Actions(driver);
					action.moveToElement(CP_ReltnSummaryPOAUpdates.click_On_Submit).click().perform();
					
			
				
			
			
				excelWrite.writeInCell(
						"select_PoAdata Test Step  excuted successfully", "Pass");
				extent_Reportlogger(" :Test Step excuted successfully", "select_PoAdata", "Pass");
				
		
			}
			catch(Exception e){
				extent_Reportlogger(":Failed", "clickChangePOA", "FAIL");
				
				excelWrite.writeInCell(
						"clickChangePOA", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
				
			}
			
		} 
		
		
		public void submitAlphaUpdatedInfoToVPAS()throws Exception {
			
			try{
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.click_On_Button(click_OnCompleteIntent);
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.click_On_Button(click_On_Submit);
				
				
			
				extent_Reportlogger(":SucessfullyDone", "submitAlphaUpdatedInfoToVPAS", "PASS");
				excelWrite.writeInCell(
						"submitAlphaUpdatedInfoToVPASDone", "Pass");
		
			}
			catch(Exception e){
				extent_Reportlogger(":Failed", "submitAlphaUpdatedInfoToVPAS", "FAIL");
				
				excelWrite.writeInCell(
						"submitAlphaUpdatedInfoToVPAS", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
				
			}
			
		}

		
		
		
		

}
