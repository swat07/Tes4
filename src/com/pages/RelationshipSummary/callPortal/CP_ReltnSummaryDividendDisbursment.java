package com.pages.RelationshipSummary.callPortal;

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
import com.utility.Test_BaseClass;

public class CP_ReltnSummaryDividendDisbursment extends Test_BaseClass {
	
	BaseUtils utility = new BaseUtils(driver);

	public CP_ReltnSummaryDividendDisbursment(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);

	}

	
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[2]//td[7]//a")
	public WebElement click_OnRemove;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add Payee')]")
	public WebElement clickAddPayee;
	
	@FindBy(xpath = "//table[@pl_prop ='.PolicyDetailsList']//a[@title='Add Method']")
	public WebElement clickOnAddMethod;
	
	@FindBy(xpath = "//div[@node_name='MCAddDisbMethod']//tr[1]//td[2]//label[@for='DivDisbMethodEFT']")
	public WebElement DISBURSEMENTMethodTypeisEFT;
	
	@FindBy(xpath = "//div[@node_name='MCAddDisbMethod']//tr[1]//td[2]//label[@for='DivDisbMethodCheck']")
	public WebElement DISBURSEMENTMethodTypeisCheck;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add New Account')]")
	public WebElement clickAddNewAcnt;
	
	@FindBy(xpath = "//select[@id='AccountType']")
	public WebElement selectAcntType;
	
	@FindBy(id = "AccountName")
	public WebElement enterAcntName;
	
	@FindBy(id = "AccountNumber")
	public WebElement enterAcntNUb;

	@FindBy(id = "ABANumber")
	public WebElement enterABANumb;
	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,'  OK ')]")
	public WebElement clkOnOkBtn;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Add New Address')]")
	public WebElement clkAddNewAdrs;
	
	@FindBy(id = "AddressType")
	public WebElement selectAdrsType;
	
	@FindBy(id = "AddressLine1")
	public WebElement enterAdrsLine;
	
	@FindBy(id = "IntlFormatedno")
	 WebElement international_FormatNo_rdBtn;
	
	@FindBy(id = "AddressLine1")
	 WebElement addressLine1;

	@FindBy(id = "AddressLine2")
	 WebElement addressLine2;

	@FindBy(id = "AddressLine3")
	 WebElement addressLine3;

	@FindBy(id = "AddressLine4")
	 WebElement addressLine4;

	@FindBy(id = "AddressCity")
	 WebElement address_City;

	@FindBy(xpath = "//select[@id='AddressState']")
	 WebElement address_State_drpdwn;

	@FindBy(id = "pyKey")
	 WebElement address_Zip;

	@FindBy(id = "IntlFormatedyes")
	 WebElement international_FormatYes_rdBtn;
	

	@FindBy(xpath = "//select[@id='AddressCountry']")
	 WebElement address_Country_drpdwn;

	@FindBy(xpath = "//table[@pl_prop='.PolicyInfo.AddressList']//tr[2]//td[1]//input[@type='radio']")
	public WebElement submitRecord;
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyInfo.BankInfoList']//tr[2]//td[1]//input[@type='radio']")
	public WebElement submitRecordforEFT;
	
	@FindBy(id = "submitButton")
	 WebElement clkSubmit;
	
	@FindBy(id = "pySelected1")
	 WebElement selectRecordforUpdate;
	
	@FindBy(xpath = "//table[@pl_prop='.PolicyDetailsList']//tr[2]//td[6]//input[@type='text']")
	public WebElement selectRecordforEntrAMnt;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit To VPAS')]")
	public WebElement submitToVPAS;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Update Payee')]")
	public WebElement click_UpdateAlpha;
	
	@FindBy(xpath = "//button[@class='buttonTdButton'][contains(.,'  Done ')]")
	public WebElement clkDone;
	
	
	public void deletePresentPayee()throws Exception {
		try{
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			WebElement wb = driver.findElement(By.xpath("//table[@pl_prop ='.PolicyDetailsList']"));
			List<WebElement> elements=wb.findElements(By.tagName("tr"));
			System.out.println("NO of rows" +elements.size());
			
			int rowCount= elements.size();
			for(int i =0;i<rowCount;i++){
				
				System.out.println("no of rows"+i);
				driver.findElement(By.xpath("//table[@pl_prop ='.PolicyDetailsList']//tr[2]//td[1]")).click();
				
				if (i<rowCount-1)
				{
				System.out.println("Inside loop");
				
				click_OnRemove.click();
				
				}
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				clickAddPayee.click();
			}
			extent_Reportlogger(":Executed Sucessfully", "deletePresentPayee", "PASS");
			excelWrite.writeInCell(
					"TestStep deletePresentPayee Executed successfully", "Pass");
}
		catch(Exception e){
			extent_Reportlogger(":Failed", "deletePresentPayee", "FAIL");
			
			excelWrite.writeInCell(
					"deletePresentPayee", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
		}
		
	}
	
	public void clickDISBURSEMENTType()throws Exception {
		try{
			
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			clickOnAddMethod.click();
			
			extent_Reportlogger(":Executed Sucessfully", "deletePresentPayee", "PASS");
			excelWrite.writeInCell(
					"TestStep deletePresentPayee Executed successfully", "Pass");
			
}
		catch(Exception e){
			extent_Reportlogger(":Failed", "deletePresentPayee", "FAIL");
			
			excelWrite.writeInCell(
					"deletePresentPayee", "Fail");
			
			ErrorLogger.logError(e.getClass().getName(),
					"Login Failed", e.getMessage());
		}
		
	}

		public void selectDISBURSEMENTMethodType(String DISBURSEMENTMethodType )throws Exception {
			try{
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				System.out.println("DISBURSEMENTMethodType=" +reader.getMapData(CommonVariable.selectDisbursementMethodType, map));
				
				if (DISBURSEMENTMethodType.equalsIgnoreCase("EFT"))
				{
					
					this.DISBURSEMENTMethodTypeEFT();
					this.submitRecordforEFT();
				
			
				}
				
				else if (DISBURSEMENTMethodType.equalsIgnoreCase("Check")){
					
					boolean selected_status = DISBURSEMENTMethodTypeisCheck
							.isSelected();
					//DISBURSEMENTMethodTypeisCheck.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					clkAddNewAdrs.click();
					selectInternationalFormat();
					this.submitRecord();
				
			}
				
				extent_Reportlogger(":Executed Sucessfully", "deletePresentPayee", "PASS");
				excelWrite.writeInCell(
						"TestStep deletePresentPayee Executed successfully", "Pass");
				
	}
			catch(Exception e){
				extent_Reportlogger(":Failed", "deletePresentPayee", "FAIL");
				
				excelWrite.writeInCell(
						"deletePresentPayee", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
		}
		
		public void selectInternationalFormat()throws Exception {
			try{
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				 utility.selectvalueByText_DropdownList(selectAdrsType,reader.getMapData(CommonVariable.selectAdrstype, map));
				 
				 String Type =reader.getMapData(CommonVariable.selectAdrstype, map);
					
				extent_Reportlogger(":and Value is" +Type, "Address selection is Done", "PASS");
				excelWrite.writeInCell("Address selection is Done and Value is = " + reader.getMapData(CommonVariable.selectAdrstype, map ), "Pass"); 
			
				
				String InterNational_Format = reader.getMapData(
						CommonVariable.Flag_to_click_InterNatForamt, map);
				if (InterNational_Format.equalsIgnoreCase("N")) {
					international_FormatNo_rdBtn.click();
					boolean selected_status = international_FormatNo_rdBtn
							.isSelected();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,
							TimeUnit.SECONDS));

					// CSR can change any address details if required and then
					// select the address type to
					// update(Billing/residence/mailing/disbursement/
					this.upadteAddress();

				}
					
		
			else {
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				international_FormatYes_rdBtn.click();
				// CSR can change any address details if required
				
				this.upadteAddresswithY();
				
				}
	
	}
			catch(Exception e){
				extent_Reportlogger(":Failed", "deletePresentPayee", "FAIL");
				
				excelWrite.writeInCell(
						"deletePresentPayee", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
		}
		
		public void DISBURSEMENTMethodTypeEFT() throws Exception {
			try{
				
				
					DISBURSEMENTMethodTypeisEFT.click();
					String Type =reader.getMapData(CommonVariable.selectDisbursementMethodType, map);
					
					extent_Reportlogger(":and DISBURSEMENTMethodTypeis +Type", "DISBURSEMENTMethodTypeSelection is Done", "PASS");
					excelWrite.writeInCell("DISBURSEMENTMethodTypeSelection is DOne and DISBURSEMENTMethodTypeis = " + reader.getMapData(CommonVariable.selectDisbursementMethodType, map ), "Pass"); 
			
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					clickAddNewAcnt.click();
					
					excelWrite.writeInCell(
							"Test Step Executed Successfully clickAddNewAcnt", "Pass");
					extent_Reportlogger(":Test Step Executed Successfully", "clickAddNewAcnt", "Pass");
					
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					//selectAcntType
					 utility.selectvalueByText_DropdownList(selectAcntType,reader.getMapData(CommonVariable.selectAcntType, map));
					 System.out.println("Selected value is : "+reader.getMapData(CommonVariable.selectAcntType, map));
					 String Type1 =reader.getMapData(CommonVariable.selectAcntType, map);
						
					extent_Reportlogger(":and Value is "+Type1 , "AccountType Selection is Done", "PASS");
					excelWrite.writeInCell("AccountType Selection is Done and Value is: = " + reader.getMapData(CommonVariable.selectAcntType, map ), "Pass"); 
					//Enter Acnt Name
					 utility.enter_Text(enterAcntName, (reader.getMapData(CommonVariable.enterAcntName, map)+Keys.TAB));
					 String Type2 =reader.getMapData(CommonVariable.enterAcntName, map);
					extent_Reportlogger(":and Value is" +Type2, "Account Name is Entered", "PASS");
					excelWrite.writeInCell("Account Name is Entered and Value is: = " + reader.getMapData(CommonVariable.enterAcntName, map ), "Pass"); 
					 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					//Enter Acnt Numb
					 utility.enter_Text(enterAcntNUb, (reader.getMapData(CommonVariable.enterAcntNub, map)+Keys.TAB));
					 String Type3 =reader.getMapData(CommonVariable.enterAcntNub, map);
					extent_Reportlogger(":and Value is" +Type3, "Account Number is Entered", "PASS");
					excelWrite.writeInCell("Account Number is Entered and Value is: = " + reader.getMapData(CommonVariable.enterAcntNub, map ), "Pass"); 
					 //Enter ABA Numb
					 utility.enter_Text(enterABANumb, (reader.getMapData(CommonVariable.enterABANubr, map)+Keys.TAB));
					 String Type4 =reader.getMapData(CommonVariable.enterABANubr, map);
					extent_Reportlogger(":and Value is" +Type4, "ABA Number is Entered", "PASS");
					excelWrite.writeInCell("ABA Number is Entered and Value is: = " + reader.getMapData(CommonVariable.enterABANubr, map ), "Pass"); 
					 Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					 clkOnOkBtn.click();
						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		
					
				excelWrite.writeInCell(
						"DISBURSEMENTMethodTypeEFT TestStep Executed Successfully", "Pass");
				extent_Reportlogger(":TestStep Executed Successfully", "DISBURSEMENTMethodTypeEFT", "Pass");
				
		
				
	}
			catch(Exception e){
				extent_Reportlogger(":TestStep Executed UnSuccessfully", "DISBURSEMENTMethodTypeEFT ", "FAIL");
				
				excelWrite.writeInCell(
						"DISBURSEMENTMethodTypeEFT Execution is fail", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
		}
		public void upadteAddress() throws Exception {
	try {

		
		

		if (!(reader.getMapData(CommonVariable.edit_addressLine1, map) == null || reader
				.getMapData(CommonVariable.edit_addressLine1, map) == "")) {

			utility.enter_Text(addressLine1, reader
					.getMapData(CommonVariable.edit_addressLine1, map));
			
		}
		
		if (!(reader.getMapData(CommonVariable.edit_addressLine2, map) == null || reader
				.getMapData(CommonVariable.edit_addressLine2, map) == "")) {

			utility.enter_Text(addressLine2, reader
					.getMapData(CommonVariable.edit_addressLine2, map));
			
		}
		if (!(reader.getMapData(CommonVariable.edit_addressLine3, map) == null || reader
				.getMapData(CommonVariable.edit_addressLine3, map) == "")) {

			utility.enter_Text(addressLine3, reader
					.getMapData(CommonVariable.edit_addressLine3, map));
		
		}
		if (!(reader.getMapData(CommonVariable.edit_addressLine4, map) == null || reader
				.getMapData(CommonVariable.edit_addressLine4, map) == "")) {

			utility.enter_Text(addressLine4, reader
					.getMapData(CommonVariable.edit_addressLine4, map));
			
		}
		
	
		
		extent_Reportlogger(":Test Step Execution is done Successfully" , "Enter Address is for Flag N", "PASS");
		excelWrite.writeInCell("Enter Address is for Flag N :Test Step Execution is done Successfully ", "Pass");
		
		if (!(reader.getMapData(CommonVariable.edit_City, map) == null || reader
				.getMapData(CommonVariable.edit_City, map) == "")) {

			utility.enter_Text(address_City,
					reader.getMapData(CommonVariable.edit_City, map));
			String Type =reader.getMapData(CommonVariable.edit_City, map);
			
			extent_Reportlogger(":and Value is" +Type, "City selection is Done", "PASS");
			excelWrite.writeInCell("City selection is Done and Value is = " + reader.getMapData(CommonVariable.edit_City, map ), "Pass");
	}
		else
		{	extent_Reportlogger(":City Should Not be blank", "upadteAddress", "Pass");
		excelWrite.writeInCell("upadteAddress:City Should Not be blank", "Pass");
			
		}
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,
				TimeUnit.SECONDS));
		
		 
		
		utility.selectvalueByText_DropdownList(
				address_State_drpdwn,
				reader.getMapData(CommonVariable.edit_State, map));
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,
				TimeUnit.SECONDS));
		String zip_Code = reader.getMapData(CommonVariable.edit_ZipCode,
				map);

		if (zip_Code != null && zip_Code != "" && !zip_Code.isEmpty()) {
			

			String regex = "\\d{5}";
			if (zip_Code.matches(regex)) {
				utility.enter_Text(address_Zip, zip_Code);
			} else {
				excelWrite.writeInCell(
						"Invalid Zip Code: ZIP code should be 5 digit numeric - "
								+ zip_Code, "Fail");

				

			}
			String Type =reader.getMapData(CommonVariable.edit_ZipCode, map);
			
			extent_Reportlogger(":and Value is" +Type, "Enter ZipCode is Done", "PASS");
			excelWrite.writeInCell("Enter ZipCode is Done and Value is = " + reader.getMapData(CommonVariable.edit_ZipCode, map ), "Pass");
		}
		 clkOnOkBtn.click();
		
		 extent_Reportlogger(" test step execution   successfully ",
					"MC Add New Address Test Step Executed Successfully", "Pass");

			excelWrite.writeInCell(
					"MC Add New Address Test Step Executed Successfully ", "Pass");
		

	} catch (Exception e) {
		extent_Reportlogger(" Execution Failed",
				"upadteAddress", "Fail");

		excelWrite.writeInCell(
				"Failed in upadteAddress", "Fail");
		ErrorLogger.logError(e.getClass().getName(),
				" upadteAddress ", e.getMessage());

		e.printStackTrace();
		throw e;
	}
}
		public void upadteAddresswithY() throws Exception {
			try {

				
				

				if (!(reader.getMapData(CommonVariable.edit_addressLine1, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine1, map) == "")) {

					utility.enter_Text(addressLine1, reader
							.getMapData(CommonVariable.edit_addressLine1, map));
					
				}
				
				if (!(reader.getMapData(CommonVariable.edit_addressLine2, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine2, map) == "")) {

					utility.enter_Text(addressLine2, reader
							.getMapData(CommonVariable.edit_addressLine2, map));
					
				}
				if (!(reader.getMapData(CommonVariable.edit_addressLine3, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine3, map) == "")) {

					utility.enter_Text(addressLine3, reader
							.getMapData(CommonVariable.edit_addressLine3, map));
				
				}
				if (!(reader.getMapData(CommonVariable.edit_addressLine4, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine4, map) == "")) {

					utility.enter_Text(addressLine4, reader
							.getMapData(CommonVariable.edit_addressLine4, map));
					
				}
				
				extent_Reportlogger(":Test Step Execution is done Successfully" , "Enter Address is for Flag Y", "PASS");
				excelWrite.writeInCell("Enter Address is for Flag Y :Test Step Execution is done Successfully ", "Pass");
				
				if (!(reader.getMapData(CommonVariable.edit_Country, map) == null || reader
						.getMapData(CommonVariable.edit_Country, map) == "")) {
					utility.selectvalueByText_DropdownList(
							address_Country_drpdwn,
							reader.getMapData(CommonVariable.edit_Country, map));
					String Type =reader.getMapData(CommonVariable.edit_Country, map);
					
					extent_Reportlogger(":and Value is" +Type, "Country selection is Done", "PASS");
					excelWrite.writeInCell("Country selection is Done and Value is = " + reader.getMapData(CommonVariable.edit_Country, map ), "Pass");
			}
				
				else
				{	extent_Reportlogger(":Country Should Not be blank", "upadteAddress", "Pass");
				excelWrite.writeInCell("upadteAddress:City Should Not be blank", "Pass");
					
				}
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,
						TimeUnit.SECONDS));
				
			
				 clkOnOkBtn.click();
				
				extent_Reportlogger(" test step execution   successfully ",
						"MC Add New Address Test Step Executed Successfully", "Pass");

				excelWrite.writeInCell(
						"MC Add New Address Test Step Executed Successfully ", "Pass");
				

			} catch (Exception e) {
				extent_Reportlogger(" Execution Failed",
						"MC Add New Address Test Step:", "Fail");

				excelWrite.writeInCell(
						"Failed in upadteAddress", "Fail");
				ErrorLogger.logError(e.getClass().getName(),
						" upadteAddress ", e.getMessage());

				e.printStackTrace();
				throw e;
			}
		}
		
		public void submitRecord()throws Exception {
			try{
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				submitRecord.click();
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				clkSubmit.click();
				
			/*	extent_Reportlogger(":Executed Sucessfully", "submitRecord", "PASS");
				excelWrite.writeInCell(
						"TestStep submitRecord Executed successfully", "Pass");*/
				
	}
			catch(Exception e){
				extent_Reportlogger(":Failed", "submitRecord", "FAIL");
				
				excelWrite.writeInCell(
						"submitRecord", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
		}
		public void submitRecordforEFT()throws Exception {
			try{
				
				submitRecordforEFT.click();
				
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				
				clkSubmit.click();
				
				extent_Reportlogger(":Executed Sucessfully", "submitRecord", "PASS");
				excelWrite.writeInCell(
						"TestStep submitRecord Executed successfully", "Pass");
				
	}
			catch(Exception e){
				extent_Reportlogger(":Failed", "submitRecord", "FAIL");
				
				excelWrite.writeInCell(
						"submitRecord", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
		}
		
		public void updatePayeeDetail()throws Exception {
			try{
				
				
				CP_ReltnSummaryPOAUpdates ReltnSummaryPOAUpdate = new CP_ReltnSummaryPOAUpdates(driver);
				selectRecordforUpdate.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				click_UpdateAlpha.click();
				ReltnSummaryPOAUpdate.enterandSubmitUpdatedName();
		
				extent_Reportlogger(":Executed Sucessfully", "updatePayeeDetail", "PASS");
				excelWrite.writeInCell(
						"TestStep updatePayeeDetail Executed successfully", "Pass");
				
	}
			catch(Exception e){
				extent_Reportlogger(":Failed", "updatePayeeDetail", "FAIL");
				
				excelWrite.writeInCell(
						"updatePayeeDetail", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
		}
		
		
		public void ToValidateNewAmntPerctng() throws Exception {
			try {
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1 , TimeUnit.SECONDS));
				double enterPercent =  Double.parseDouble((reader.getMapData(CommonVariable.enterAmnt, map)));
				 //int enterPercent = Integer.parseInt(reader.getMapData(CommonVariable.enterAmnt, map));
				System.out.println("Per value" +enterPercent );
				
			if (enterPercent==100.0)
			{
				
				/*Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5 , TimeUnit.SECONDS));
				
				utility.enter_Text(selectRecordforEntrAMnt, (reader.getMapData(CommonVariable.enterAmnt, map)+Keys.TAB));
				*/

				System.out.println("value" +reader.getMapData(CommonVariable.enterAmnt, map));
				
				String enterAmountTC1 = reader.getMapData(CommonVariable.enterAmnt, map);
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				selectRecordforEntrAMnt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE,enterAmountTC1);
			
				excelWrite.writeInCell(
						"ToValidateSurrenderPerctng Test step Executed Successfully" +enterPercent, "Pass");
				extent_Reportlogger(":Entered Value is :" +enterPercent, "Surrender Percentage is Verfied and ", "Pass");
			}
			
			else
				
			{
				System.out.println("Total Allocation Percentage Can Not Be More Than 100");
			}
			
			
			
			} catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "ToValidateSurrenderPerctng", "FAIL");
				excelWrite.writeInCell("ToValidateSurrenderPerctng Test Step Execution Unsuccessfull", "Fail");
				ErrorLogger.logError(e.getClass().getName(),"ToValidateSurrenderPerctng", e.getMessage());
				throw e;
			}
	}
		public void submitToVPASInfo()throws Exception {
			try{
				
				
				submitToVPAS.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2 , TimeUnit.SECONDS));
				clkDone.click();
		
				extent_Reportlogger(":Executed Sucessfully", "updatePayeeDetail", "PASS");
				excelWrite.writeInCell(
						"TestStep updatePayeeDetail Executed successfully", "Pass");
				
	}
			catch(Exception e){
				extent_Reportlogger(":Failed", "updatePayeeDetail", "FAIL");
				
				excelWrite.writeInCell(
						"updatePayeeDetail", "Fail");
				
				ErrorLogger.logError(e.getClass().getName(),
						"Login Failed", e.getMessage());
			}
			
		}
}
