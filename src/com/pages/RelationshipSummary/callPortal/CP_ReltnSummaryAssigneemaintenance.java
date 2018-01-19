package com.pages.RelationshipSummary.callPortal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.functions.relationshipSummary.RelationshipSummaryCommonOprations;
import com.pages.commonScreens_CP.Action_Summary;
import com.pages.commonScreens_CP.Workflow_Confirmation;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;

import com.utility.Test_BaseClass;


public class CP_ReltnSummaryAssigneemaintenance extends Test_BaseClass {
	

	
	BaseUtils utility = new BaseUtils(driver);

	public CP_ReltnSummaryAssigneemaintenance(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "pySelected1")
	public WebElement clickonRemoveChcbox;
	
	@FindBy(id = "EffDate")
	public WebElement effectiveDate;
	
	@FindBy(xpath = "//table[@pl_prop='pyWorkPage.PolicyDetailsList']//tr[2]//td[8]//a")
	public WebElement click_OnRemove;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add  New Assignee(s)')]")
	public WebElement clickAddNewAssigne;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add / Search Alpha For Assignee')]")
	public WebElement clickSearchAlphUser;
	
	@FindBy(id = "FirstName")
	public WebElement enter_FirstName;
	
	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement enter_LastName;
	
	@FindBy(id = "SSN")
	public WebElement enter_SSNNUmber;
	
	@FindBy(id = "Birth Date")
	public WebElement enter_BirthDate;
	
	@FindBy(xpath = "//div[@base_ref='pyWorkPage']//li//table//label[text()='Email Information']")
	public WebElement click_EmailInformation;
	
	@FindBy(id = "EmailAddress")
	public WebElement enter_EmailInfo;
	
	@FindBy(id = "pyNote")
	public WebElement enter_ConfirmEmailInfo;
	
	@FindBy(xpath = "//td[@class='buttonTdMiddle'][contains(.,'  Submit New Alpha Info To VPAS(R) ')]//button")
	public WebElement click_SubmitAplha;
	
	@FindBy(xpath = ".//*[@id='RULE_KEY']/div[1]/div/div/div/div/div/span")
	public WebElement Select_invalidIderrMsg;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement vPAS_Close_Btn;
	
	@FindBy(xpath = "//label[@for='.Description']/following-sibling::div//span")
	public WebElement SelectPOPUpMsz;
	
	@FindBy(id = "pySelected1")
	public WebElement selectAssigneeChk;
	
	@FindBy(xpath = "//select[@id='RelationCode1']")
	public WebElement selectAssigneeType;
	
	@FindBy(xpath = "//select[@id='RelationCode1']")
	public WebElement selectAssigneeTypeValue;
	
	@FindBy(id = "Amount1")
	public WebElement chkAmountText;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Send Updated AssigneeInfo To VPAS(R)')]")
	public WebElement SendAssigneToVPAS;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Update Assignee Alpha info')]")
	public WebElement clickUpdateAssignee;
	
	
	@FindBy(id = "FirstName")
	public WebElement enter_UpdateName;
	
	@FindBy(xpath = "//td[@class='buttonTdMiddle']//button[contains(.,'Submit Updated Alpha Info To VPAS(R)')]")
	public WebElement clkSubmitbtn;
	
	@FindBy(xpath = "//label[@for='.note']/following-sibling::div//span")
	public WebElement SelectAddedInfoPOPUpMsz;
	
	

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Send Updated AssigneeInfo To VPAS(R)')]")
	public WebElement SendUpdatedInfotovpas;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Done')]")
	public WebElement clkOnDone;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Wrap Up')]")
	public WebElement clkOnWrapUp;

	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'End Interaction')]")
	public WebElement clkEndInteraction;

	public void addNewAssigne()throws Exception {
		
		try{
		
			RelationshipSummaryCommonOprations Relationship_userPersonalDetails = new RelationshipSummaryCommonOprations(driver);
			
			//check effective date
			Relationship_userPersonalDetails.checkingEffectiveDate();
			
			//Click on NewAssigne
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(clickAddNewAssigne);
			//clicking on RemoveEnrty
			
			
			
			//driver.switchTo().frame(driver.switchTo().activeElement());
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			WebElement wb = driver.findElement(By.xpath("//table[@pl_prop='pyWorkPage.PolicyDetailsList']"));
			List<WebElement> elements=wb.findElements(By.tagName("tr"));
		
			System.out.println("No of rows: "+ elements.size());
		
			int rownum = elements.size();
			for (int i=0; i<rownum ; i++)
			{
				System.out.println("no of rows: "+ i);
				
				driver.findElement(By.xpath("//table[@pl_prop='pyWorkPage.PolicyDetailsList']//tr[2]//td[1]")).click();
			
				if (i<rownum-1)
				{
				System.out.println("Inside loop");
				
				click_OnRemove.click();
				
				}
				
			}
			clickSearchAlphUser.click();
			
			extent_Reportlogger(":SucessfullyDone", "addNewAssigne", "PASS");
			excelWrite.writeInCell(
					"addNewAssigneDone", "Pass");
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "addNewAssigne", "FAIL");
			
			excelWrite.writeInCell(
					"addNewAssigne", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	public void callPortal_EndInteraction() throws Exception {
		try {
			Workflow_Confirmation workflow_Confirmation = new Workflow_Confirmation(driver);
			Action_Summary action_Summary=new Action_Summary(driver);
			
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("cpmInteractionDivFrame");
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			
			action_Summary.wrapUp_LinkClick();
			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
			action_Summary.enterWrapUpDetails_EndInteraction();
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "callPortal_EndInteraction", "FAIL");
			excelWrite.writeInCell("callPortal_EndInteraction Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"callPortal_EndInteraction", e.getMessage());
			throw e;
		}
	}
	
	public void selectAssigneeType() throws Exception {

		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,TimeUnit.SECONDS));
			 selectAssigneeChk.click();
			 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			 utility.selectvalueByText_DropdownList(selectAssigneeType,reader.getMapData(CommonVariable.selectAssigneeType, map));
			 System.out.println("Selected value is : "+reader.getMapData(CommonVariable.selectAssigneeType, map));
			 
			// String isAssigneeType = selectAssigneeTypeValue.getAttribute("selected");
			 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			 Select select=new Select(selectAssigneeTypeValue);
			 String isAssigneeType=select.getFirstSelectedOption().getText();
		 
			 System.out.println("Value" +isAssigneeType);
			 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,TimeUnit.SECONDS));
			 
			 extent_Reportlogger(":Check is Sucessfully Done", "AssigneeType", "PASS");

				excelWrite.writeInCell("AssigneeType is = " + isAssigneeType, "Pass");
			 
			 if (isAssigneeType.equalsIgnoreCase("Collateral Assignee")){
			
				 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,TimeUnit.SECONDS));
				 if(chkAmountText.isEnabled())
				 {
					 extent_Reportlogger(":AmountTextbox is Enabled Check is done ", "For Collateral AssigneeType", "PASS");

					excelWrite.writeInCell("AmountTextbox is Enabled Check is done ", "Pass");
						
					 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,TimeUnit.SECONDS));
					 utility.enter_Text(chkAmountText, (reader.getMapData(CommonVariable.enterAmountAssignee, map)+Keys.TAB));
					
					 
					 extent_Reportlogger(":Sucessfully Done", "AmountEnteredforAssignee", "PASS");
					 String enteredAmount = (reader.getMapData(CommonVariable.enterAmountAssignee, map));
					 
					excelWrite.writeInCell("AmountEnteredforAssignee = " + enteredAmount, "Pass"); 
				 }
				 else{
					
					 extent_Reportlogger(":AmountTextbox is Disabled:it should not be Disabled", "For Collateral AssigneeType", "Fail");

						excelWrite.writeInCell(" For Collateral AssigneeType: AmountTextbox is Disabled:it should not be Disabled ", "Fail");
				 }
			 }
			 
				 else if(isAssigneeType.equalsIgnoreCase("Absolute Assignee")){
					 
					 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5,TimeUnit.SECONDS));
					 if(!chkAmountText.isEnabled())
					 {
						 extent_Reportlogger(":AmountText is Disabled Check is done ", "For Absolute Assignee Type", "PASS");

						excelWrite.writeInCell("For Absolute Assignee Type AmountText is Disabled Check is done ", "Pass");
							
						 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,TimeUnit.SECONDS));
				
					 }
					 else {
						 	extent_Reportlogger(":AmountTextbox is Enabled: it should not be Enabled ", "For Absolute Assignee Type", "Fail");

							excelWrite.writeInCell(":AmountTextbox is Enabled : it should not be Enabled  ", "Fail");
								
							 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,TimeUnit.SECONDS));
					 }
					 
				 }
			 
					 else{
						 
						 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3,TimeUnit.SECONDS));
						 extent_Reportlogger(":Selection Check is done ", "Assignee Type is not Selected", "Fail");

							excelWrite.writeInCell("Assignee Type is not Selected Check is done ", "Fail");
					 
				 
				 }
			 
		

			

		} catch (Exception e) {

			excelWrite.writeInCell("selectCase execution failed", "Fail");
			extent_Reportlogger("Execution failed ", "selectCase", "Fail");

			ErrorLogger.logError(e.getClass().getName(), "selectCase",
					e.getMessage());
			e.printStackTrace();
			throw e;

		}

	}
	
	
	
	
	public void sendAssigneeToVPAS() throws Exception{
	
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		//Relationship_userPersonalDetails = new RelationshipSummary_userPersonalDetails();
		
		SendAssigneToVPAS.click();
	
		clickUpdateAssignee.click();
		
		extent_Reportlogger(":SucessfullyDone", "sendAssigneeToVPAS", "PASS");
		excelWrite.writeInCell(
				"sendAssigneeToVPASDone", "Pass");
		
	

	}
	
	

	
	
	public void sendUpdatedAssigneeToVPAS() throws Exception{
		try{
			
			//Relationship_userPersonalDetails = new RelationshipSummary_userPersonalDetails();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			SendUpdatedInfotovpas.click();
			clkOnDone.click();
			
			/*clkOnDone.click();
			clkOnWrapUp.click();
			clkEndInteraction.click();*/
			
			
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
	
	
	
	
	
}



