package com.pages.AddressChangeScreens.callPortal;

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

import com.pages.AddressChangeScreens.CopyExistandAddNew_PerformTranPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class CP_ChangeAccountAddress extends Initialize_Browser {
	
	public CP_ChangeAccountAddress(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	BaseUtils utility = new BaseUtils(driver);

	CopyExistandAddNew_PerformTranPage accountAddress;

	

	@FindBy(id = "OperationTypeChange Address")
	WebElement changeaccountAdd_rdBtn;

	@FindBy(xpath = ".//*[@id='OperationTypeChange Phone']")
	WebElement chnagePhn_rdBtn;

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-Data-GetPolicySummary']//tr[2]//td[1]")
	WebElement chngAccount_selPeopletoUpdte;

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-Data-GetPolicySummary']")
	WebElement selPeopletoUpdte_tbl;

	@FindBy(xpath = ".//*[@id='submitButton']")
	WebElement cSR_SubmitBtn;

	@FindBy(xpath = "//table[@pl_prop='.ResultList']")
	WebElement updatePerson_tble;

	@FindBy(xpath = ".//*[@id='StrongButton']/tbody/tr/td[2]")
	WebElement peopleUpdt_submit_btn;

	@FindBy(xpath = ".//*[@id='IntlFormatedno']")
	WebElement cp_IntlFrmtNo;

	@FindBy(xpath = ".//*[@id='IntlFormatedyes']")
	WebElement cp_IntlFrmtYes;

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

	@FindBy(xpath = ".//*[@id='pyKey']")
	WebElement cp_Zipcode;

	@FindBy(xpath = "//select[@id='AddressCountry']")
	WebElement address_Country_drpdwn;

	
	
	@FindBy(xpath = ".//*[@id='MCIntentAddlComments']")
	WebElement cp_AddComments;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Wrap Up')]")
	WebElement cp_WrapUp;

	@FindBy(xpath = ".//*[@id='ERRORMESSAGES_ALL']")
	WebElement errorMsz_CP;

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-Data-GetPolicySummary']//tr[2]//div[text()='No items']")
	WebElement noItemUpdate;

	public void selectPeople_updateAddressDetails(String testCase)
			throws Exception {

		try {
			String select_PeopleToUpdate = "";

			String updateAddresDtail = "";

			boolean isAccountaddress = changeaccountAdd_rdBtn.isSelected();
			
			select_PeopleToUpdate = reader.getMapData(
					CommonVariable.select_PeopleToUpdate_CP, map);
			updateAddresDtail = reader.getMapData(
					CommonVariable.updateAddresDtail_CP, map);

			if (testCase.equalsIgnoreCase("accountAddress") && isAccountaddress) {

				if (!(select_PeopleToUpdate == null)
						|| !(select_PeopleToUpdate == "")) {

					int parseData1 = Integer.parseInt(select_PeopleToUpdate
							.substring(0, 1)) + 1;

					String people_To_Update = Integer.toString(parseData1);

					int parseData2 = Integer.parseInt(updateAddresDtail
							.substring(0, 1)) + 1;

					String update_AddressDetails = Integer.toString(parseData2);

					driver.findElement(
							By.xpath("//table[@pl_prop_class='McCamish-Data-GetPolicySummary']//tr["
									+ people_To_Update + "]//td[1]")).click();

					cSR_SubmitBtn.click();

					driver.findElement(
							By.xpath("//table[@pl_prop='.ResultList']//tr["
									+ update_AddressDetails
									+ "]//td[1]//input[@class='checkbox chkBxCtl']"))
							.click();

					extent_Reportlogger("Test Step Execution Successfull",
							" Select the peoples to update the address", "Pass");
					excelWrite
							.writeInCell(
									"Select the peoples to update the address Test Step Execution Successfull",
									"Pass");

					cSR_SubmitBtn.click();
				} else {
					cSR_SubmitBtn.click();

					String errorMessage = errorMsz_CP.getText();
					System.out.println("+errorMessage" + errorMessage);
					extent_Reportlogger(":" + errorMessage, "Error Message",
							"Pass");
					excelWrite.writeInCell(
							" Error Message:" + errorMessage, "Pass");

				}
			} else {

				chnagePhn_rdBtn.click();

				int parseData1 = Integer.parseInt(select_PeopleToUpdate
						.substring(0, 1)) + 1;

				String people_To_Update = Integer.toString(parseData1);

				driver.findElement(
						By.xpath("//table[@pl_prop_class='McCamish-Data-GetPolicySummary']//tr["
								+ people_To_Update + "]//td[1]")).click();

				extent_Reportlogger("Test Step Execution Successfull",
						"Select the peoples to update the phone", "Pass");
				excelWrite
						.writeInCell(
								"Select the peoples to update the phone Test Step Execution Successfull",
								"Pass");

				cSR_SubmitBtn.click();
			}

		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"selectPeople_updateAddressDetails", "Fail");
			excelWrite
					.writeInCell(
							"selectPeople_updateAddressDetails Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"selectPeople_updateAddressDetails", e.getMessage());
			throw e;

		}

	}

	public void change_AccountAddress() throws Exception {
		accountAddress = new CopyExistandAddNew_PerformTranPage(driver);
		String isCommentReq = "";
		String InterNational_Format = reader.getMapData(
				CommonVariable.Flag_to_click_InterNatForamt, map);
		if (InterNational_Format.equalsIgnoreCase("N")) {

			boolean selected_status = cp_IntlFrmtNo.isSelected();

			if (selected_status) {
				this.editAddressCP("accountAddress");

				cSR_SubmitBtn.click();

			}
		} else {

			this.editAddressCP("changePhone");
			utility.click_On_Button(cSR_SubmitBtn);
			
		}

		// Landing on Accept changes and click on Submit Button
		utility.click_On_Button(cSR_SubmitBtn);
		

		// Landing on Exit DArress Change Page and clicl on Done Button
		utility.click_On_Button(cSR_SubmitBtn);
		

	}

	public void editAddressCP(String testCaseName) throws Exception {
		try {
			if (!(reader.getMapData(CommonVariable.edit_addressLine1, map) == null || reader
					.getMapData(CommonVariable.edit_addressLine1, map) == "")) {

				
				  utility.enter_Text(addressLine1, reader.getMapData(
				 CommonVariable.edit_addressLine1, map));
				 

			}

			if (!(reader.getMapData(CommonVariable.edit_addressLine2, map) == null || reader
					.getMapData(CommonVariable.edit_addressLine2, map) == "")) {

				

				
				  utility.enter_Text(addressLine2, reader.getMapData(
				  CommonVariable.edit_addressLine2, map));
				 

			}
			if (!(reader.getMapData(CommonVariable.edit_addressLine3, map) == null || reader
					.getMapData(CommonVariable.edit_addressLine3, map) == "")) {

			

				
				  utility.enter_Text(addressLine3, reader.getMapData(
				  CommonVariable.edit_addressLine3, map));
				 

			}
			if (!(reader.getMapData(CommonVariable.edit_addressLine4, map) == null || reader
					.getMapData(CommonVariable.edit_addressLine4, map) == "")) {

				

				
				  utility.enter_Text(addressLine4, reader.getMapData(
				  CommonVariable.edit_addressLine4, map));
				 

			}

			if (testCaseName.equalsIgnoreCase("accountAddress")) {

				if (!(reader.getMapData(CommonVariable.edit_City, map) == null || reader
						.getMapData(CommonVariable.edit_City, map) == "")) {

					

					
					  utility.enter_Text(address_City,
					  reader.getMapData(CommonVariable.edit_City, map));
					 

				} else {
					extent_Reportlogger(":City Should Not be blank",
							"upadteAddress", "Pass");
					excelWrite.writeInCell(
							"upadteAddress:City Should Not be blank", "Pass");

				}

				utility.selectvalueByText_DropdownList(address_State_drpdwn,
						reader.getMapData(CommonVariable.edit_State, map));

				String zip_Code = reader.getMapData(
						CommonVariable.edit_ZipCode, map);

				if (zip_Code != null && zip_Code != "" && !zip_Code.isEmpty()) {

					String regex = "\\d{5}";
					if (zip_Code.matches(regex)) {

						utility.enter_Text(cp_Zipcode, zip_Code);
					} else {
						excelWrite.writeInCell(
								"Invalid Zip Code: ZIP code should be 5 digit numeric - "
										+ zip_Code, "Fail");

					}
				}
			} else {
				if (!(reader.getMapData(CommonVariable.edit_Country, map) == null || reader
						.getMapData(CommonVariable.edit_Country, map) == "")) {
					utility.selectvalueByText_DropdownList(
							address_Country_drpdwn,
							reader.getMapData(CommonVariable.edit_Country, map));
				}
			}

			extent_Reportlogger("Test Step Execution Successfull",
					"editAddressCP", "Pass");
			excelWrite.writeInCell(
					"editAddressCP Test Step Execution Successfull", "Pass");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "editAddressCP",
					"Fail");
			excelWrite.writeInCell(
					"editAddressCP Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(), "editAddressCP",
					e.getMessage());
			throw e;
		}
	}
}
