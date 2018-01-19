package com.pages.RelationshipSummary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ReadDataFromExcel;
import com.utility.ScreenShot;
import com.utility.Test_BaseClass;


public class RelationshipSummary_Owner_Change extends Initialize_Browser {

	
	//CSWD_Resuablefunction_AddressChange cswd_Resuablefunction =new CSWD_Resuablefunction_AddressChange();
	
	
	

	public RelationshipSummary_Owner_Change(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	

	
	@FindBy(id = "Owner Change")
	public WebElement OwnerChange;
	

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add New Owner(s)')]")
	public WebElement click_AddNewAlphaOwner;
	
	//@FindBy(name = "DisplayOwnerDetails_pyWorkPage_82")
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add / Search Alpha For Owner')]")
	public WebElement click_Add_Search_AlphaOwner;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Update Owner Alpha Info')]")
	public WebElement click_UpdateOwnerdetails;
	

	@FindBy(id = "AddIndvRecTypeExistRec")
	public WebElement click_Existing_Individual_Record;
	
	@FindBy(name = "MCAlphaEditPersInfoInd_pyWorkPage_8")
	public WebElement click_Search_Individual_Record;
	
	@FindBy(id = "FirstName")
	public WebElement enter_FirstName;
	
	//@FindBy(id = "LastName")
	
	@FindBy(id = "FirstName")
	public WebElement enter_FirstNameContingent;
	
	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement enter_LastName;
	
	@FindBy(id = "SSN")
	public WebElement enter_SSNNUmber;
	
	@FindBy(id = "Birth Date")
	public WebElement enter_BirthDate;
	

	@FindBy(name = "MCAlphaMaintSearchRec_pyWorkPage_25")
	public WebElement click_SearchIndividualRecord;
	
	//@FindBy(name = "$PFindPolicyRecords$ppxResults$l$pEditFlag")
	
	//@FindBy(xpath = "//*[@id='$PFindPolicyRecords$ppxResults$l$pEditFlag']")

	@FindBy(xpath = "//table[@summary='FindPolicyRecords.pxResults']//td[2]//table//tr[2]//td[2]//input[@type='radio']")
	public WebElement select_PersonName;
	
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Select Record')]")
	public WebElement click_SelectRecord;
	
	@FindBy(name = "MCAlphaMaintSearchRec_pyWorkPage_25")
	public WebElement select_Record;
	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,'  Submit New Alpha Info To VPAS(R) ')]")
	public WebElement Submit_Updated_Alpha_InfoToVPAS;
	
	
	@FindBy(id = "AllocPct")
	public WebElement enter_Percentage;
	
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[3]//td[6]//input[@type='text']")
	public WebElement enter_ConPercentage;
	
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Send Updated Owner Info To VPAS(R)')]")
	public WebElement send_Updated_Owner_InfoToVPAS;
	
	@FindBy(id = "pySelected1")
	public WebElement select_UpdatedRecord;
	
	@FindBy(id = "pySelected2")
	public WebElement select_ContingentUpdatedRecord;
	
	
	@FindBy(className = "buttonTdButton")
	public WebElement updated_VPAS;
	
	@FindBy(xpath = "//*[@id='RULE_KEY']/div[1]/div/div/div/div/div/div/div/div/div/div/span")
	public WebElement verify_Message;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement click_Close;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Update Owner Alpha Info')]")
	public WebElement click_UpdateOwnerInfo;
	
	@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div[1]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button")
	public WebElement click_SubmitUpdateOwnerInfo;
	
	@FindBy(xpath = "//*[@id='EXPAND-OUTERFRAME']/tbody/tr/td")
	public WebElement click_window;
	//*[@id='EXPAND-OUTERFRAME']/tbody/tr/td
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Done')]")
	public WebElement click_OnDone;
	
	@FindBy(id = "submitButton")
	public WebElement click_Submit;
	
	@FindBy(xpath = "//*[@id='RelationCode']")
	public WebElement click_Owner_Relationship;
	
	@FindBy(id = "Finding1")
	public WebElement Select_good_ToProceed;
	
	@FindBy(id = "Finding2")
	public WebElement Select_Trackcorrespondence;
	
	@FindBy(id = "Response1")
	public WebElement Select_AdminChecklist;
	
	//Used in TC_2 for Beneficiary change functionality
	
	@FindBy(id = "Beneficiary Change")
	//@FindBy(xpath = ".//*[@id='PolicyCategory']//option[@value='Beneficiary Change']")
	public WebElement BeneficiaryChange;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add New Beneficiary(s)')]")
	public WebElement click_AddBeneficiary;
	
	@FindBy(id = "pySelected1")
	public WebElement select_Toremoveexistingbeneficiary ;
	
	@FindBy(id = "pySelected2")
	public WebElement select_Toremoveexistingbeneficiary1 ;
	
	
	@FindBy(id = "pySelected")
	public WebElement select_CheckboxToRemovedata ;
	
	//@FindBy(xpath = "//div[@class='oflowDivM'][contains(.,'Remove')]")
	@FindBy(xpath = "//a[text()='Remove']")
	public WebElement click_OnRemove;
	
	@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div[1]/div/div/div/div/div/div/div/span/button")
	public WebElement click_AddAlphaforBeneficiary;
	
	
	//@FindBy(className = "oflowDivM")
	@FindBy(xpath = "//div[@base_ref='pyWorkPage']//li//table//label[text()='Email Information']")
	public WebElement click_EmailInformation;
	
	
	@FindBy(id = "EmailAddress")
	public WebElement enter_EmailInfo;
	
	@FindBy(id = "pyNote")
	public WebElement enter_ConfirmEmailInfo;
	
	@FindBy(id = "Relationship")
	//*[@id='Relationship']
	public WebElement select_Relationship;
	
	//table[@pl_prop='.PolicyDetailsList']//tr[3]//td[7]
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[3]//td[7]//select[@id='Relationship']")
	public WebElement select_COnRelationship;

	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[3]//td[2]//select[@id='RelationCode']")
	public WebElement select_ContingentBeneficiary;
	
	@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div[2]/div/div/div/div/div[1]/div/div/span/button")
	public WebElement click_SendToVpas;
	
	//@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/span/button")
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Update Beneficiary')]")

	public WebElement click_UpdateBeneficiaryConti;

	@FindBy(id = "FirstName")
	public WebElement enter_UpdateNameContingent;
	
	@FindBy(xpath = "//*[@id='RULE_KEY']/div[2]/div/div/div[1]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button")
	public WebElement submit_UpdatedInfo;
	
	@FindBy(id = "Finding1")
	public WebElement Select_good_ToProceedforOwner;
	
	@FindBy(id = "Finding2")
	public WebElement Select_TrackcorrespondenceforOwner;
	
	
	@FindBy(id = "submitButton")
	//@FindBy(xpath = "//button[text()='  Submit ']")
	public WebElement click_On_Submit;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Change POA(s)')]")
	public WebElement click_ChangePOA;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Alpha')]")
	public WebElement click_ADDAlpha;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Change Contact')]")
	public WebElement click_Contact;
	
	@FindBy(id = "pySelected4")
	public WebElement select_POARecordchkbox ;
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[5]//td[7]//select[@id='WebAccessType4']")
	public WebElement select_AccessType;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit To VPAS')]")
	public WebElement submit_SendToVpas;
	
	
	
	public void select_AddNewUser() throws Exception{
		
		try{
			InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
	
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		utility.click_On_Button(click_AddNewAlphaOwner);
		
		extent_Reportlogger("select_AddNewUser", "Login Fail Screen", "Pass");
		
		excelWrite.writeInCell(
				"select_AddNewUser", "Pass");
	
		}
		catch (InterruptedException e) {
					
					extent_Reportlogger("submit_InfoToVpas", "Login Fail Screen", "FAIL");
					
					excelWrite.writeInCell(
							"select_AddNewUser", "Fail");
				
					
					e.printStackTrace();
				}
							
				}
				
		
		public void select_AddSearchAlphaUser() throws Exception {
		
			try {
				
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
		
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(click_Add_Search_AlphaOwner);
			
		
			
			
				
			} catch (InterruptedException e) {
				extent_Reportlogger("Selection of ALpha User is falied", "Owner Maintenance Fail", "FAIL");
				
				excelWrite.writeInCell(
						"Selected AlphaUser", "Fail");
				
			
				e.printStackTrace();
			}

			
		}
		public void submit_InfoToVpas() throws Exception{
			
			try {
				InitialCommonScreens_ReusableFunction resuablefunction = new InitialCommonScreens_ReusableFunction(driver);
			
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				extent_Reportlogger("submit_InfoToVpas", "contact Change", "PASS");
				excelWrite.writeInCell(
						"submit_InfoToVpas ", "Pass");
			

			
			
			select_UpdatedRecord.click();
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			extent_Reportlogger("select_UpdatedRecord", "contact Change", "PASS");
			excelWrite.writeInCell(
					"select_UpdatedRecord ", "Pass");
			
			}
			catch (InterruptedException e) {
						
						extent_Reportlogger("submit_InfoToVpas", "Login Fail Screen", "FAIL");
						excelWrite.writeInCell(
								"submit_InfoToVpas", "Fail");
						
						
						e.printStackTrace();
					}
								
					}
					
		
		public void click_SerachAlphaForBeneficiary() throws Exception
		{
		
		try {
			
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			select_UpdatedRecord.click();
			extent_Reportlogger(":SuccessfullyDone", "click_SerachAlphaForBeneficiary", "PASS");
			
			excelWrite.writeInCell(
					"click_SerachAlphaForBeneficiaryDone", "Pass");
			
		} catch (InterruptedException e) {
			
			extent_Reportlogger("click_SerachAlphaForBeneficiary", "Login Fail Screen", "FAIL");
			excelWrite.writeInCell(
					"submit_InfoToVpas", "Fail");
			
			e.printStackTrace();
		}
					
		}
		
		
		
		public void send_InfoToVPAS() throws Exception
		{
			try {
			
				excelWrite.writeInCell(
						"click_OnDoneSucessfully ", "Pass");
		
				 extent_Reportlogger(":Sucessfully", "clickOnDone", "PASS");
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				
				click_OnDone.click();
	
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				Actions actions1 = new Actions(driver);
				actions1.moveToElement(click_Submit).click()
						.perform();
			
				excelWrite.writeInCell(
						"click_OnDoneSucessfully ", "Pass");
				
				 extent_Reportlogger(":Sucessfully", "clickOnSubmit", "PASS");
		
			
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	
		public String verifyPrimaryOwnerRelationship() throws Exception 
		{
			
			
			String getTextPrimaryOwner = driver.findElement(By.xpath("//select[@id='RelationCode']//option[@value='OWNER']")).getText().trim();
			//*[@id='RelationCode']//option[@selected=""]
			System.out.println("Verify_Method : " +getTextPrimaryOwner);
			extent_Reportlogger("verifyPrimaryOwnerRelationship", "Owner Manitenance", "PASS");
			
			excelWrite.writeInCell(
					"verifyPrimaryOwnerRelationship", "Pass");
			
			Thread.sleep(5000);
			return getTextPrimaryOwner;
		}
		
	
		
		
		public void select_AddBeneficiaryUser()
				throws Exception
			
			{
				
		
			try {
		
			click_AddBeneficiary.click();
			
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			Thread.sleep(3000);
			
			WebElement wb=driver.findElement(By.xpath("//table[@pl_prop='tempPolicyDtlsPage.PolicyDetailsList']"));
			List<WebElement> elements=wb.findElements(By.tagName("tr"));
		
			System.out.println("no of rows: "+ elements.size());
			int rownNUM=elements.size();
			Thread.sleep(3000);
			for(int i=0;i<rownNUM;i++){
				System.out.println("no of rows: "+ i);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr[2]//td[1]")).click();
				if (i<rownNUM-1)
				{
				System.out.println("Inside loop");
				Thread.sleep(3000);
				click_OnRemove.click();
				
				}
				
			}
			
			}
			
			 catch (InterruptedException e) {
				
				e.printStackTrace();
				extent_Reportlogger("select_AddBeneficiaryUser", "Login Fail Screen", "FAIL");
				
				excelWrite.writeInCell(
						"select_AddBeneficiaryUser", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
			
			}
			
		public void select_PoAdata()
				throws Exception
				{
			try 
			{
				
				Thread.sleep(1000);
				WebElement wb=driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']"));
				List<WebElement> elements=wb.findElements(By.tagName("tr"));
				System.out.println("no of rows: "+ elements.size());
				int enter_POAData = elements.size();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[1]//input[@type='checkbox']")).click();
				
				
				Thread.sleep(2000);
				
				utility.enter_Text(driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[5]//input")), reader.getMapData(CommonVariable.enter_AccessEndDate, map));
				
				extent_Reportlogger("enter_AccessEndDate", "contact Change", "PASS");
				excelWrite.writeInCell(
						"enter_AccessEndDate", "Pass");
				
				System.out.println("Print "+  reader.getMapData(CommonVariable.enter_AccessType, map));
				Thread.sleep(2000);
				/*System.out.println("Print "+  reader.getMapData(CommonVariable.enter_AccessEndDate, map));
				System.out.println("MAp value*****"+map);*/
				//driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[5]//input")).sendKeys(reader.getMapData(CommonVariable.enter_AccessEndDate, map));
			
				System.out.println("Print "+  reader.getMapData(CommonVariable.enter_AccessType, map));
	
				
					int i = enter_POAData-1;
			
					System.out.println("MAp value*****" +i);
			{
		
				Thread.sleep(2000);
				
				
				utility.selectvalueByText_DropdownList(driver.findElement(By.xpath("//*[@id='WebAccessType"+i+"']")), reader.getMapData(CommonVariable.enter_AccessType, map));
				
				//utility.selectvalueByText_DropdownList(driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[7]")), reader.getMapData(CommonVariable.enter_AccessType, map));
		
			
			}
		
			excelWrite.writeInCell(
					"select_PoAdata excuted successfully", "Pass");
			extent_Reportlogger("select_PoAdata excuted successfully", "select_PoAdata Screen", "Pass");
				
			}
			 catch (InterruptedException e) {
				
				e.printStackTrace();
				excelWrite.writeInCell(
						"select_PoAdata excuted Unsuccessfully", "Fail");
				extent_Reportlogger("select_PoAdata excuted Unsuccessfully", "select_PoAdata Screen", "Fail");
					
			}
			
			
			}
			
		public void select_contact_changedata()
				throws Exception
				{
			try 
			{
				Thread.sleep(2000);
				WebElement wb=driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']"));
				List<WebElement> elements=wb.findElements(By.tagName("tr"));
				System.out.println("no of rows: "+ elements.size());
				int enter_POAData = elements.size();
				
				
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[1]//input[@type='checkbox']")).click();
				
				
				int i = enter_POAData-1;
				
				Thread.sleep(3000);
				
				utility.enter_Text(driver.findElement(By.xpath("//table[@pl_prop='.PolicyDetailsList']//tr["+enter_POAData+"]//td[6]//input")), reader.getMapData(CommonVariable.enter_AccessEndDate, map));
				
				extent_Reportlogger("enter_AccessEndDate", "contact Change", "PASS");
				excelWrite.writeInCell(
						"enter_AccessEndDate", "Pass");
				
				System.out.println("Print "+  reader.getMapData(CommonVariable.enter_AccessType, map));
			
				extent_Reportlogger(":Executed Successfully", "select_Relationcode", "PASS");
				excelWrite.writeInCell(
						"select_Relationcode Executed Successfully", "Pass");
				Thread.sleep(5000);
				
				utility.selectvalueByText_DropdownList(driver.findElement(By.xpath("//*[@id='RelationCode"+i+"']")), reader.getMapData(CommonVariable.select_Relationcode, map));
				
			
				
			excelWrite.writeInCell(
					"select_contact_changedata is Executed Successfully", "Pass");
			extent_Reportlogger(":Executed Successfully", "select_contact_changedata", "Pass");
				
			}
			 catch (Exception e) {
					
					excelWrite.writeInCell(
							"select_contact_changedata failed", "Fail");
					extent_Reportlogger(": Failed", "select_contact_changedata", "Fail");

				
					throw e;
			}
			
			
			}
		
		public void send_InfoToVPASforContingentBeneficiary() throws Exception
		{
			try {
				
				
				
				extent_Reportlogger("click_SendToVpas", "Beneficiary change screen", "PASS");
				excelWrite.writeInCell(
						"click_SendToVpas ", "Pass");
				Thread.sleep(1000);
			
				click_SendToVpas.click();
			
				Thread.sleep(1000);
				
			
				click_UpdateBeneficiaryConti.click();
				Thread.sleep(1000);
				
				
			
				enter_UpdateNameContingent.click();
				
				excelWrite.writeInCell(
						"send_InfoToVPASforContingentBeneficiaryDone", "Pass");
				extent_Reportlogger(":SuccessfullyDone", "send_InfoToVPASforContingentBeneficiary", "Pass");
				
			}
			 catch (Exception e) {
				 excelWrite.writeInCell(
							"send_InfoToVPASforContingentBeneficiary Failed", "Fail");
					extent_Reportlogger("send_InfoToVPASforContingentBeneficiary Failed", "send_InfoToVPASforContingentBeneficiary", "Fail");
					

				
					throw e;
			}
			
			
			}
			
		public void submit_InfoToVPASConti() throws Exception
		{
			try {
				Thread.sleep(5000);
				utility.click_On_Button(click_OnDone);
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				Thread.sleep(3000);
				Actions action = new Actions(driver);
				action.moveToElement(click_On_Submit).click().perform();
			
				System.out.println(" clicked on  Submit button");
			
		
				excelWrite.writeInCell(
						"submit_InfoToVPASContingentUserisDOne", "Pass");
				extent_Reportlogger(":SuccessfullyDone", "submit_InfoToVPASContingentUserisDOne", "Pass");
				
				
			}
			 catch (Exception e) {
				 excelWrite.writeInCell(
							"submit_InfoToVPASConti Fail", "Fail");
					extent_Reportlogger("submit_InfoToVPASConti Fail", "submit_InfoToVPASConti", "Fail");

				
					throw e;
			}
			
			
			}
		
		/*	int i = 1;
				for (int i = 1; i < rownNUM; i++)
				while (i < rownNUM)
				
			{
			System.out.println("below click on check box");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='pySelected1']")).click();
				driver.findElement(By.xpath("//*[@id='pySelected"+i+"']")).click();
				Thread.sleep(5000);
				
				System.out.println("//*[@id='pySelected1"+i+"']");
				rownNUM--;
				
				
			}*/
		public void submit_SubmitInfoPOA() throws Exception
		{
			try {
				
			
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				Actions action = new Actions(driver);
				action.moveToElement(click_On_Submit).click().perform();
			
				excelWrite.writeInCell(
						"submit_SubmitInfoPOAisDone", "Pass");
				extent_Reportlogger(":ExecutedSucessfully", "submit_SubmitInfoPOA", "Pass");
				
			}
			 catch (Exception e) {

					excelWrite.writeInCell(
							"SubmitInfoPOA", "Fail");
					extent_Reportlogger("submit_SubmitInfoPOA", "submit_SubmitInfoPOA", "Fail");

				
					throw e;
			}
			
			
			}
		
		public void submit_SubmitInfoContct() throws Exception
		{
			try {

			

				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
				
			
				Actions action = new Actions(driver);
				action.moveToElement(click_On_Submit).click().perform();
				
				excelWrite.writeInCell(
						"SubmitInfoContctisDone", "Pass");
				extent_Reportlogger(":ExecutedSucessfully", "submit_SubmitInfoContct", "Pass");
				
				
			}
			 catch (Exception e) {
					excelWrite.writeInCell(
							"submit_SubmitInfoContct", "Fail");
					extent_Reportlogger("submit_SubmitInfoContct", "submit_SubmitInfoContct", "Fail");

				
					throw e;
			}
			
			
			}
		
		
		public String verifyPrimaryBeneficiaryType() throws Exception 
		{
			System.out.println("Enter in Validation for Beneficiary Type");
			Thread.sleep(5000);
			String getTextPrimaryBeneficiary = driver.findElement(By.xpath("//select[@id='RelationCode']//option[@value='BENEPRIM']")).getText().trim();
			//*[@id='RelationCode']//option[@selected=""]
			System.out.println("Verify_Method : " +getTextPrimaryBeneficiary);
		
			
			extent_Reportlogger(":Sucessfully Done", "verifyPrimaryBeneficiaryTypeUser", "PASS");
			
			excelWrite.writeInCell("verifyPrimaryBeneficiaryTypeUserisDOne =" +getTextPrimaryBeneficiary , "Pass"); 
			
			return getTextPrimaryBeneficiary;
		}
		
		public void submit_BeneficiaryType() throws Exception{
			
			try {
				
		
			
			utility.click_On_Button(Submit_Updated_Alpha_InfoToVPAS);
			Thread.sleep(1000);
			click_Close.click();
			
			Thread.sleep(1000);

			select_UpdatedRecord.click();
		
		
			
			}
			catch (InterruptedException e) {
						
				excelWrite.writeInCell(
						"submit_BeneficiaryType", "Fail");
				extent_Reportlogger("submit_BeneficiaryType", "submit_BeneficiaryType", "Fail");
						ErrorLogger.logError(e.getClass().getName(),
								"submit_BeneficiaryType", e.getMessage());
						
						e.printStackTrace();
					}
								
					}
					
		
		public void submit_ContingentBeneficiaryType() throws Exception{
			
			try {
				Thread.sleep(1000);
				Submit_Updated_Alpha_InfoToVPAS.click();
				Thread.sleep(5000);
				click_Close.click();
				Thread.sleep(1000);
				
				
				
		
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
		
		

	}
	
