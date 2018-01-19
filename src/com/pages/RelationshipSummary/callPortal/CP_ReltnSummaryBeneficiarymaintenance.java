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
import org.testng.Assert;

import com.functions.relationshipSummary.RelationshipSummaryCommonOprations;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class CP_ReltnSummaryBeneficiarymaintenance extends Initialize_Browser
{


	public CP_ReltnSummaryBeneficiarymaintenance(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add New Beneficiary(s)')]")
	public WebElement click_AddBeneficiary;
	
	@FindBy(xpath = "//a[text()='Remove']")
	public WebElement click_OnRemoveBene;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add / Search Alpha For Beneficiary')]")
	public WebElement click_AddAlphaforBeneficiary;
	
	@FindBy(id = "pySelected1")
	public WebElement select_UpdatedRecord;
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[3]//td[6]//input[@type='text']")
	public WebElement enter_Percentage;

	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[2]//td[6]//input[@type='text']")
	public WebElement enter_PercentagePrim;

	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[3]//td[7]//select[@id='Relationship']")
	public WebElement select_COnRelationship;
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[2]//td[7]//select[@id='Relationship']")
	public WebElement select_PrimRelationship;

	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[3]//td[2]//select[@id='RelationCode']")
	public WebElement select_ContingentBeneficiary;
	
	@FindBy(id = "FirstName")
	public WebElement enter_FirstNameContingent;
	
	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement enter_LastName;
	
	@FindBy(id = "SSN")
	public WebElement enter_SSNNUmber;
	
	@FindBy(id = "Birth Date")
	public WebElement enter_BirthDate;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement click_Close;
	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,'  Submit New Alpha Info To VPAS(R) ')]")
	public WebElement Submit_Updated_Alpha_InfoToVPAS;
	
	@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div[2]/div/div/div/div/div[1]/div/div/span/button")
	public WebElement click_SendToVpas;
	
	@FindBy(id = "pySelected1")
	public WebElement select_Toremoveexistingbeneficiary;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add / Search Alpha For Beneficiary')]")
	public WebElement click_UpdateBeneficiaryConti;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Update Beneficiary')]")
	public WebElement click_UpdateBeneficiaryContingent;
	
	@FindBy(id = "FirstName")
	public WebElement enter_UpdateNameContingent;
	
	
	//@FindBy(xpath = "//div[contains(text(),'Contingent')]/ancestor::td[1]/preceding-sibling::td")
	@FindBy(id = "pySelected2")
	public WebElement select_existingbeneficiary;
	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,'  Submit Updated Alpha Info To VPAS(R) ')]")
	public WebElement submit_UpdatedInfo;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Done')]")
	public WebElement click_OnDone;
	
	@FindBy(id = "submitButton")
	public WebElement submit_Btn;
	
	public void addNewBeneficiary()throws Exception {
		
		try{
			
			
			//Click on NewAssigne
		
			utility.click_On_Button(click_AddBeneficiary);
			//check effective date
			//Relationship_userPersonalDetails.checkingEffectiveDate();
			//clicking on RemoveEnrty
			
			
			
			//driver.switchTo().frame(driver.switchTo().activeElement());
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
			WebElement wb = driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']"));
			List<WebElement> elements=wb.findElements(By.tagName("tr"));
			
			System.out.println("No of rows: "+ elements.size());
		
			int rownum = elements.size();
			for (int i=0; i<rownum ; i++)
			{
				System.out.println("no of rows: "+ i);
				
				driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr[2]//td[1]")).click();
			
				if (i<rownum-1)
				{
				System.out.println("Inside loop");
				
				click_OnRemoveBene.click();
				
				}
				
			}
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			extent_Reportlogger(":SucessfullyDone", "addNewAssigneAndExixtingRowDataDeletion", "PASS");
			excelWrite.writeInCell(
					"addNewAssigneAndExixtingRowDataDeletionDone", "Pass");
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "addNewAssigneAndExixtingRowDataDeletion", "FAIL");
			
			excelWrite.writeInCell(
					"addNewAssigneAndExixtingRowDataDeletion", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	
	public void addAlphaBeneficiary()throws Exception {
		
		try{
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			utility.click_On_Button(click_AddAlphaforBeneficiary);
			
			extent_Reportlogger(":SucessfullyDone", "addAlphaBeneficiary", "PASS");
			excelWrite.writeInCell(
					"addAlphaBeneficiary is Done", "Pass");
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "addAlphaBeneficiary", "FAIL");
			
			excelWrite.writeInCell(
					"addAlphaBeneficiary", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	
	public void selectBeneficiaryType()throws Exception {
		
		try{
			
		
			//utility.click_On_Button(select_UpdatedRecord);
			
			String benefiaciaryTypeOptionTextExpected = "Primary Beneficiary";
			String clickPrimaryOptionText = verifyPrimaryBeneficiaryType();
			
			System.out.println("Start for Assert validation for Beneficiary");
		
			Assert.assertEquals(clickPrimaryOptionText, benefiaciaryTypeOptionTextExpected);
		
			//utility.selectvalueByText_DropdownList(selectAssigneeType,reader.getMapData(CommonVariable.selectAssigneeType, map));
			 System.out.println("Selected value is : "+reader.getMapData(CommonVariable.selectAssigneeType, map));
			 
			extent_Reportlogger(":SucessfullyDone", "addNewAssigne", "PASS");
			excelWrite.writeInCell(
					"addNewAssigneDone", "Pass");
			//Enter Percentage AMount
			utility.enter_Text(enter_PercentagePrim, (reader.getMapData(CommonVariable.Enter_New_Percentage, map)+Keys.TAB));
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		
			extent_Reportlogger(":Sucessfully Done", "Enter_New_Percentage", "PASS");
			excelWrite.writeInCell("Enter_New_PercentageisDone = " + reader.getMapData(CommonVariable.Enter_New_Percentage, map), "Pass"); 
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "addNewBeneficiary", "FAIL");
			
			excelWrite.writeInCell(
					"addNewBeneficiary", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}

	
	public String verifyPrimaryBeneficiaryType() throws Exception 
	{
		System.out.println("Enter in Validation for Beneficiary Type");
		
		String getTextPrimaryBeneficiary = driver.findElement(By.xpath("//select[@id='RelationCode']//option[@value='BENEPRIM']")).getText().trim();
	
		System.out.println("Verify_Method : " +getTextPrimaryBeneficiary);
	
		
		extent_Reportlogger(":Sucessfully Done", "verifyPrimaryBeneficiaryTypeUser", "PASS");
		
		excelWrite.writeInCell("verifyPrimaryBeneficiaryTypeUserisDOne =" +getTextPrimaryBeneficiary , "Pass"); 
		
		
		
		Thread.sleep(5000);
		return getTextPrimaryBeneficiary;
	}

	public void selectRelationShipForPrimaryUser()throws Exception {
		
		try{
			
			utility.select_DropdownList(select_PrimRelationship, reader.getMapData(CommonVariable.select_RelationshipPrim, map));
			extent_Reportlogger(":Sucessfully Done", "select_RelationshipPrimaryDone", "PASS");
			excelWrite.writeInCell("select_RelationshipPrimaryDone = " + reader.getMapData(CommonVariable.select_RelationshipPrim, map ), "Pass");
			

		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "selectRelationShipForPrimaryUser", "FAIL");
			
			excelWrite.writeInCell(
					"selectRelationShipForPrimaryUser", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	public void selectRelationShipForContingentUser()throws Exception {
		
		try{
			
			Thread.sleep(3000);
			utility.selectvalueByText_DropdownList(select_ContingentBeneficiary, reader.getMapData(CommonVariable.select_BeneficiaryType, map));
			extent_Reportlogger(":Successfully Done", "select_ContingentBeneficiaryTypeSelection", "PASS");
			excelWrite.writeInCell(
					"select_ContingentBeneficiaryselectionTypeisDOne=" +reader.getMapData(CommonVariable.select_BeneficiaryType, map), "Pass");
			
			utility.enter_Text(enter_Percentage, (reader.getMapData(CommonVariable.Enter_New_PercentageforContigentUser, map)+Keys.TAB));
			
		
			extent_Reportlogger(":Sucessfully Done", "Enter_New_PercentageforContigentUser", "PASS");
			excelWrite.writeInCell("Enter_New_PercentageforContigentUserisDone = " + reader.getMapData(CommonVariable.Enter_New_PercentageforContigentUser, map), "Pass"); 
	
			
			///need to chnage XPATH
			utility.select_DropdownList(select_COnRelationship, reader.getMapData(CommonVariable.select_RelationshipConti, map));
			extent_Reportlogger(":Sucessfully Done", "select_RelationshipPrimaryDone", "PASS");
			excelWrite.writeInCell("select_RelationshipPrimaryDone = " + reader.getMapData(CommonVariable.select_RelationshipConti, map ), "Pass");
			
			

		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "selectRelationShipForPrimaryUser", "FAIL");
			
			excelWrite.writeInCell(
					"selectRelationShipForPrimaryUser", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}

	

	public void selectContingentBeniType()throws Exception {
		
		try{
			
			utility.selectvalueByText_DropdownList(select_ContingentBeneficiary,reader.getMapData(CommonVariable.select_BeneficiaryType, map));
			 System.out.println("Selected value is : "+reader.getMapData(CommonVariable.select_BeneficiaryType, map));
			
			//Enter Percentage AMount
			utility.enter_Text(enter_Percentage, (reader.getMapData(CommonVariable.Enter_New_Percentage, map)+Keys.TAB));
			
		
			extent_Reportlogger(":Sucessfully Done", "selectContingentBeniType ", "PASS");
			excelWrite.writeInCell("Enter_New_PercentageisDone = " + reader.getMapData(CommonVariable.Enter_New_Percentage, map), "Pass"); 
	
		}
		catch(Exception e){
			extent_Reportlogger(":Failed", "addNewBeneficiary", "FAIL");
			
			excelWrite.writeInCell(
					"addNewBeneficiary", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
			
		}
		
	}
	
	public void enter_UserPersonalDetailsForContingentUser() throws Exception {
		try {
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				click_AddAlphaforBeneficiary.click();
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				utility.enter_Text(enter_FirstNameContingent,(reader.getMapData(CommonVariable.enter_ConFirstName, map )+Keys.TAB));
				extent_Reportlogger(":Sucessfully Done", "enter_FirstNameContingent", "PASS");
				excelWrite.writeInCell("enter_FirstNameContingentDone = " + reader.getMapData(CommonVariable.enter_ConFirstName, map ), "Pass");
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				utility.enter_Text(enter_LastName,(reader.getMapData(CommonVariable.enter_ConLastName, map )+Keys.TAB));
				

				String ssN_Number=reader.getMapData(CommonVariable.enter_SSNNumber, map);
				
				String regex = "\\d{9}";
				
				if(ssN_Number.matches(regex))
				{
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
					utility.enter_Text(enter_SSNNUmber, (reader.getMapData(CommonVariable.enter_ConSSNNumber, map)+Keys.TAB));
					
					extent_Reportlogger(":Sucessfully Done", "Entered_SSNNUmber", "PASS");
					excelWrite.writeInCell("Enter SSNNumber = " + reader.getMapData(CommonVariable.enter_SSNNumber, map ), "Pass"); 
					utility.enter_Text(enter_BirthDate, (reader.getMapData(CommonVariable.enter_COnBirthDate, map)+Keys.TAB));
				
					
				}
				
					else {
						
						System.out.println("User Entered wrong SSN 9 digitnumber!!!");
						
						extent_Reportlogger("User Entered wrong SSN 9 digitnumber!!!", "SSN NUmber for contact change screen", "PASS");
						excelWrite.writeInCell("Enter SSNNumber = " + reader.getMapData(CommonVariable.enter_SSNNumber, map ), "Pass"); 
				
					}
				
				
					
					excelWrite.writeInCell(
							"enter_UserPersonalDetailsForContingentTypeSuccessfullyDone", "Pass");
					extent_Reportlogger(":SuccessfullyDone", "enter_UserPersonalDetailsForContingentTypeSuccessfullyDone", "PASS");
		
			
			}
			
			catch(Exception e)
			{
				
			}
		}
		

	public void submitInfo_ContingentBeneficiaryType() throws Exception{
		
		try {
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));	
		//utility.click_On_Button(Submit_Updated_Alpha_InfoToVPAS);
		Submit_Updated_Alpha_InfoToVPAS.click();
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		//utility.click_On_Button(click_Close);
		click_Close.click();
	
		
	
		
		extent_Reportlogger(":Successfully Done", "submitInfoforContingentBeneficiaryType", "PASS");
		excelWrite.writeInCell(
				"submitInfoforContingentBeneficiaryTypeDone ", "Pass");
	
		
		}
	
		
		catch (InterruptedException e) {
			
			excelWrite.writeInCell(
					"submit_ContingentBeneficiaryType", "Fail");
			extent_Reportlogger("submit_ContingentBeneficiaryType", "submit_ContingentBeneficiaryType", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"submit_InfoToVpas", e.getMessage());
			
			e.printStackTrace();
		}
					
		}
	
	
	public void UpdateandSendInfoToVPASforContingentBeneficiary() throws Exception
	{
		try {
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			extent_Reportlogger("click_SendToVpas", "Beneficiary change screen", "PASS");
			excelWrite.writeInCell(
					"click_SendToVpas ", "Pass");
			
			
			
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(select_existingbeneficiary);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(click_UpdateBeneficiaryContingent);
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			utility.click_On_Button(enter_UpdateNameContingent);
			enter_UpdateNameContingent.clear();
			
			utility.enter_Text(enter_UpdateNameContingent, (reader.getMapData(CommonVariable.update_First_Name, map)+Keys.TAB));
			
			extent_Reportlogger(":Sucessfully Done", "enter_UpdateNameContingent", "PASS");

			
			excelWrite.writeInCell("enter_UpdateNameContingent = " + reader.getMapData(CommonVariable.update_First_Name, map ), "Pass"); 
		
			utility.click_On_Button(submit_UpdatedInfo);
			
			
			excelWrite.writeInCell(
					"send_InfoToVPASforContingentBeneficiaryDone", "Pass");
			extent_Reportlogger(":SuccessfullyDone", "send_InfoToVPASforContingentBeneficiary", "Pass");
			
		}
		 catch (Exception e) {
			 excelWrite.writeInCell(
						"send_InfoToVPASforContingentBeneficiary Failed", "Fail");
				extent_Reportlogger(": Failed", "send_InfoToVPASforContingentBeneficiary", "Fail");
				

			
				throw e;
		}
		
		
		}
	public void submitBeniContigentUserInfo() throws Exception{
		
		try {
			
			
			utility.click_On_Button(click_Close);
			
			
			
			utility.click_On_Button(click_OnDone);
			
			utility.click_On_Button(submit_Btn);
		extent_Reportlogger(":Successfully Done", "submitBeniContigentUserInfo", "PASS");
		excelWrite.writeInCell(
				"submitBeniContigentUserInfoDone ", "Pass");
	
		
		}
	
		
		catch (InterruptedException e) {
			
			excelWrite.writeInCell(
					"submit_ContingentBeneficiaryType", "Fail");
			extent_Reportlogger("submit_ContingentBeneficiaryType", "submit_ContingentBeneficiaryType", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"submit_InfoToVpas", e.getMessage());
			
			e.printStackTrace();
		}
					
		}
		
	
	
}
