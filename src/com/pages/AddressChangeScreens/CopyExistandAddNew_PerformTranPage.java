package com.pages.AddressChangeScreens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
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


public class CopyExistandAddNew_PerformTranPage extends Initialize_Browser {
	
	public CopyExistandAddNew_PerformTranPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	AddressType_PerformTransPage  SelectAddressType_peopletoUpadte;
	VPAS_PopUpPage  vPAS_PopUpPage;
	
	AddressType_PhoneChange phoneChangeScreen;
		
	
	// Click on exist Address
		@FindBy(id = "AddressUpdateTypeCopyExisting")
		 WebElement copyExisting_Address_rdBtn;
		
		// Select which address we want to copy
		@FindBy(name = "$PTempAddSelection$pSelectAddChgType")
		 WebElement select_ChangeAddressType_drpdwn;
		
		
		@FindBy(id = "IntlFormatedno")
		 WebElement international_FormatNo_rdBtn;

		@FindBy(id = "IntlFormatedyes")
		 WebElement international_FormatYes_rdBtn;
				
		
		@FindBy(id = "AddressUpdateTypeAddNew")
		 WebElement addNew_Address_rdBtn;
		
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

		@FindBy(id = "AddressZip")
		 WebElement address_Zip;

		@FindBy(xpath = "//select[@id='AddressCountry']")
		 WebElement address_Country_drpdwn;
		
		// Select addres with updated new one
		@FindBy(id = "AddTypeBill")
		 WebElement AddType_Bill;

		@FindBy(id = "AddTypeDisb")
		 WebElement AddType_Disb;

		@FindBy(id = "AddTypeMail")
		 WebElement AddType_Mail;

		@FindBy(id = "AddTypeRes")
		 WebElement AddType_Res;

		@FindBy(id = "AddTypeBusiness")
		 WebElement AddType_Business;

		@FindBy(xpath = "//table[@pl_prop='MCAlphaMaintPage.AddressList']")
		 WebElement addNew_AddTableData;
		
		@FindBy(xpath = "//input[@id='OperationTypeChange Phone']")
		 WebElement change_Phone_Btn;

		
		@FindBy(className = "buttonTdButton")
		 WebElement submit_To_VPAS_ChangePhone_Btn;
		
		@FindBy(xpath = "//*[@id='EXPAND-OUTERFRAME']/tbody/tr/td")
		 WebElement phone_Change_Pop_UP;
		
		@FindBy(xpath = "//label[@for='.Description']/following-sibling::div//span")
		 WebElement verify_Message;
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
		 WebElement vPAS_Close_Btn;
		
		
		public void select_CopyExisting() throws Exception {

			try {
				  vPAS_PopUpPage = new VPAS_PopUpPage(driver);

		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

				utility.click_On_Button(copyExisting_Address_rdBtn);

			//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

				utility.select_DropdownList(
						select_ChangeAddressType_drpdwn,
						reader.getMapData(
								CommonVariable.select_AddressType_To_CopyExisting,
								map));

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,100)", "");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");
		//		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				String InterNational_Format = reader.getMapData(
						CommonVariable.Flag_to_click_InterNatForamt, map);
				// Whether you want to select the International format or not!!
				if (InterNational_Format.equalsIgnoreCase("N")) {
					boolean selected_status = international_FormatNo_rdBtn
							.isSelected();

					if (selected_status) {

						Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2,
								TimeUnit.SECONDS));

						// CSR can change any address details if required and then
						// select the address type to
						// update(Billing/residence/mailing/disbursement/
						this.upadteAddress();

					}
				} else {
				//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					international_FormatYes_rdBtn.click();
					// CSR can change any address details if required
					this.upadteAddress();
					if (!(reader.getMapData(CommonVariable.edit_Country, map) == null || reader
							.getMapData(CommonVariable.edit_Country, map) == "")) {
						utility.selectvalueByText_DropdownList(
								address_Country_drpdwn,
								reader.getMapData(CommonVariable.edit_Country, map));
					}

				}

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
				// Select the address type which we want to update , it can be
				// any(Billing/Mailing/Residence/Disbursment/..)
				updateAddressType_withNewAddress("copy_Existing");

				// Handle the pop Up : Which shows updated in VPAS :Submit Updated
				// Alpha info to VPAS(R)
				vPAS_PopUpPage.submit_InfoToVPAS("copy_Existing");

				excelWrite.writeInCell("CopyExisting executed successfully ",
						"Pass");

			} catch (Exception e) {

				excelWrite.writeInCell(" Failed in CopyExisting", "Fail");

				ErrorLogger.logError(e.getClass().getName(),
						"Address_Change_Backoff- select_CopyExisting",
						e.getMessage());

				throw e;
			}

		}

		public void select_AddNew_Address() throws Exception {

			try {

				 vPAS_PopUpPage = new VPAS_PopUpPage(driver);

		//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

				addNew_Address_rdBtn.click();

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				String InterNational_Format = reader.getMapData(
						CommonVariable.Flag_to_click_InterNatForamt, map);
				if (InterNational_Format.equalsIgnoreCase("N")) {

					// Enter New Address when InterNational_Format is No
					enter_NewAddress();

				} else {
			//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
					// Enter New Address when InterNational_Format is No
					international_FormatYes_rdBtn.click();
					enter_NewAddress();
					utility.selectvalueByText_DropdownList(
							address_Country_drpdwn,
							reader.getMapData(CommonVariable.addNew_country, map));
				}

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				// Select the address type which we want to update , it can be
				// any(Billing/Mailing/Residence/Disbursment/..)
				updateAddressType_withNewAddress("add_NewAddress");

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

				// Handle the pop Up for add_New Address : Which shows updated in
				// VPAS :Submit Updated Alpha info to VPAS(R)
				vPAS_PopUpPage.submit_InfoToVPAS("add_NewAddress");

				excelWrite.writeInCell(

				"Add New Address submitted successfully", "Pass");

			} catch (Exception e) {

				excelWrite.writeInCell(

				"Failed in Add New Address", "Fail");
				ErrorLogger.logError(e.getClass().getName(),
						"Address_Change_Backoff - select_AddNew_Address ",
						e.getMessage());
				throw e;

			}
		}
		
		
		public void select_change_PhoneNumber() throws Exception {
			try {
				
				  SelectAddressType_peopletoUpadte = new AddressType_PerformTransPage(driver);
				  
				   phoneChangeScreen = new AddressType_PhoneChange(driver);
				JavascriptExecutor jsedown = (JavascriptExecutor) driver;
				jsedown.executeScript("window.scrollBy(0,-250)", "");
				

				String actual_ChangePhone_PopUpMessage = "";
				utility.click_On_Button(change_Phone_Btn);

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				SelectAddressType_peopletoUpadte.select_PeopleToUpdate("Change_Phone");

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));

				driver.switchTo().defaultContent();
				driver.switchTo().frame("PegaGadget2Ifr");

				// Enter new phone number for any phone
				// type(billing/mailing/residence/business/disbursement)
				phoneChangeScreen.enter_Phone_Information();

			//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				utility.click_On_Button(submit_To_VPAS_ChangePhone_Btn);
				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
				if (phone_Change_Pop_UP.isDisplayed()
						|| phone_Change_Pop_UP.isEnabled()) {

					phone_Change_Pop_UP.click();
					Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

					actual_ChangePhone_PopUpMessage = verify_Message
							.getText();

					extent_Reportlogger(": "
							+ actual_ChangePhone_PopUpMessage,
							"ChangePhone vPASPOP_UP Message", "PASS");
					excelWrite.writeInCell(

					"ChangePhone Pop Up message : "
							+ actual_ChangePhone_PopUpMessage, "Pass");

				
					utility.click_On_Button(vPAS_Close_Btn);

					excelWrite.writeInCell("Change Phone Number submitted successfully", "Pass");
				}

				else {
					excelWrite.writeInCell(

					"ChangePhone Pop Up not displayed  ", "Fail");

					throw new Exception("changePhone_PopUp not displayed");
				}
			} catch (Exception e) {

				extent_Reportlogger("Execution Failed ", "Change Phone Number",
						"PASS");
				excelWrite.writeInCell(

				"Failed in Change Phone Number ", "Fail");
				ErrorLogger.logError(e.getClass().getName(),
						"Address_Change_Backoff - select_change_PhoneNumber ",
						e.getMessage());
				throw e;
			}
		}
		
		public void upadteAddress() throws Exception {
			try {

				
				

				if (!(reader.getMapData(CommonVariable.edit_addressLine1, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine1, map) == "")) {

					
					String add1=reader
							.getMapData(CommonVariable.edit_addressLine1, map);
					
					addressLine1.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add1,
							Keys.TAB);
					
				}
				
				if (!(reader.getMapData(CommonVariable.edit_addressLine2, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine2, map) == "")) {

					
					
					String add2= reader
							.getMapData(CommonVariable.edit_addressLine2, map);
					addressLine2.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add2,
							Keys.TAB);
					
				}
				if (!(reader.getMapData(CommonVariable.edit_addressLine3, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine3, map) == "")) {

					
					
					String add3= reader
							.getMapData(CommonVariable.edit_addressLine3, map);
					addressLine3.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add3,
							Keys.TAB);
				
				}
				if (!(reader.getMapData(CommonVariable.edit_addressLine4, map) == null || reader
						.getMapData(CommonVariable.edit_addressLine4, map) == "")) {

					
					
					
					String add4= reader
							.getMapData(CommonVariable.edit_addressLine4, map);
					addressLine4.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add4,
							Keys.TAB);
					
					
				}
				if (!(reader.getMapData(CommonVariable.edit_City, map) == null || reader
						.getMapData(CommonVariable.edit_City, map) == "")) {

					
					
					
					String editCity= reader.getMapData(CommonVariable.edit_City, map);
					address_City.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, editCity,
							Keys.TAB);

				

				}
				else
				{	extent_Reportlogger(":City Should Not be blank", "upadteAddress", "Pass");
				excelWrite.writeInCell("upadteAddress:City Should Not be blank", "Pass");
					
				}

				
				utility.selectvalueByText_DropdownList(
						address_State_drpdwn,
						reader.getMapData(CommonVariable.edit_State, map));

				String zip_Code = reader.getMapData(CommonVariable.edit_ZipCode,
						map);

				if (zip_Code != null && zip_Code != "" && !zip_Code.isEmpty()) {
					

					String regex = "\\d{5}";
					if (zip_Code.matches(regex)) {
						
						address_Zip.sendKeys(
								Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, zip_Code,
								Keys.TAB);
					} else {
						excelWrite.writeInCell(
								"Invalid Zip Code: ZIP code should be 5 digit numeric - "
										+ zip_Code, "Fail");

						

					}
				}

				
				extent_Reportlogger(" test step execution   successfully ",
						"Upadte  address", "Pass");

				excelWrite.writeInCell(
						"Upadte  address test step execution   successfully ", "Pass");
				

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
		
		public void enter_NewAddress() throws Exception {
			try {
				

				if (!(reader.getMapData(CommonVariable.addNew_addressLine1, map) == null || reader
						.getMapData(CommonVariable.addNew_addressLine1, map) == "")) {
					
					
					
					
					String add1= reader
							.getMapData(CommonVariable.addNew_addressLine1, map);
					addressLine1.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add1,
							Keys.TAB);
				}
				if (!(reader.getMapData(CommonVariable.addNew_addressLine2, map) == null || reader
						.getMapData(CommonVariable.addNew_addressLine2, map) == "")) {
					
					
					
					String add2= reader
							.getMapData(CommonVariable.addNew_addressLine2, map);
					addressLine2.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add2,
							Keys.TAB);
				}
				if (!(reader.getMapData(CommonVariable.addNew_addressLine3, map) == null || reader
						.getMapData(CommonVariable.addNew_addressLine3, map) == "")) {
					
					
					
					
					String add3= reader
							.getMapData(CommonVariable.addNew_addressLine3, map);
					addressLine3.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add3,
							Keys.TAB);
					
				}
				if (!(reader.getMapData(CommonVariable.addNew_addressLine4, map) == null || reader
						.getMapData(CommonVariable.addNew_addressLine4, map) == "")) {
					
					
					
					String add4= reader
							.getMapData(CommonVariable.addNew_addressLine4, map);
					addressLine4.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, add4,
							Keys.TAB);
					
				}
				
				
				
				if (!(reader.getMapData(CommonVariable.addNew_city, map) == null || reader
						.getMapData(CommonVariable.addNew_city, map) == "")) {
				
					
					
					String addCity= reader.getMapData(CommonVariable.addNew_city, map);
					address_City.sendKeys(
							Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, addCity,
							Keys.TAB);

				}
				else
				{	extent_Reportlogger(":City Should Not be blank", "upadteAddress", "Pass");
				excelWrite.writeInCell("upadteAddress:City Should Not be blank", "Pass");
					
				}

			
				utility.selectvalueByText_DropdownList(
						address_State_drpdwn,
						reader.getMapData(CommonVariable.addNew_state, map));

			

				String zip_Code = reader.getMapData(CommonVariable.addNew_zipCode,
						map);
				if (zip_Code != null && zip_Code != "" && !zip_Code.isEmpty()) {
					System.out.println("zip_Code" + zip_Code);
					String regex = "\\d{5}";

					if (zip_Code.matches(regex)) {

						address_Zip.sendKeys(
								Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, zip_Code,
								Keys.TAB);
						

						
					} else {
						excelWrite.writeInCell(

						"Invalid Zip Code : ZIP code should be 5 digit numeric - "
								+ zip_Code, "Fail");
						ErrorLogger
								.logError("CSWD_AddressChange", "enter_NewAddress",
										"Invalid Zip Code : ZIP code should be 5 digit numeric ");

					}
				} else {
					excelWrite.writeInCell(

					"Zip Code value is either null or empty" + zip_Code, "Fail");
				}

				extent_Reportlogger(" successfully done ",
						"Entered New Address", "Pass");

				excelWrite.writeInCell(
						"Successfully entered new address", "Pass");

			} catch (Exception e) {
				extent_Reportlogger(" Execution Failed", "enter_NewAddress", "Pass");
				excelWrite.writeInCell(

				"Failed in enter_NewAddress", "Fail");
				ErrorLogger.logError(e.getClass().getName(),
						"Address_Change_Backoff - enter_NewAddress() ",
						e.getMessage());
			}
		}

		
		public void updateAddressType_withNewAddress(String testCasename)
				throws Exception {
			try {

				
				String addressTypes_Values = "";
				if (testCasename.equalsIgnoreCase("copy_Existing")) {
					addressTypes_Values = reader.getMapData(
							CommonVariable.selectAddressType_WithNewAddress, map)
							.toString();
				}

				if (testCasename.equalsIgnoreCase("add_NewAddress")) {
					addressTypes_Values = reader.getMapData(
							CommonVariable.add_NewAddress, map).toString();
					System.out.println("addNew_AddresValues" + addressTypes_Values);
				}

				String tokens[] = addressTypes_Values.split(",");
				

			
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");

				for (int i = 0; i < tokens.length; i++) {

					System.out.println("values of data " + i + ": " + tokens[i]);
					if (tokens[i].equalsIgnoreCase("Billing")) {
						AddType_Bill.click();
					}

					else if (tokens[i].equalsIgnoreCase("Disbursement")) {
						AddType_Disb.click();
					}

					else if (tokens[i].equalsIgnoreCase("Mailing")) {
						AddType_Mail.click();
					} else if (tokens[i].equalsIgnoreCase("Residence")) {
						AddType_Res.click();
					}

					else if (tokens[i].equalsIgnoreCase("Business")) {
						AddType_Business.click();
					}

					else {
						extent_Reportlogger(" Selected ",
								"No Value", "Pass");

						excelWrite
								.writeInCell(testCasename+":"+
										"No Value Selected",
										"Pass");
					}

				}

				extent_Reportlogger(" successfully done ",
						"select update address type  with new address", "Pass");

				excelWrite
						.writeInCell(testCasename+":"+
								"select update address type  with new address successfully done",
								"Pass");

			} catch (Exception e) {
				extent_Reportlogger(" Execution Failed",
						"updateAddressType_withNewAddress", "Pass");
				excelWrite.writeInCell("Failed in Update Address Method",
						"Fail");
				ErrorLogger.logError(e.getClass().getName(), "ChangeINAddress",
						e.getMessage());
				throw e;
			}
		}
		
		
}
