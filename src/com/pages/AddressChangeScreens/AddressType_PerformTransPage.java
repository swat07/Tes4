package com.pages.AddressChangeScreens;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.WriteExcelFile;

public class AddressType_PerformTransPage extends Initialize_Browser {

	
	public AddressType_PerformTransPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);

	CopyExistandAddNew_PerformTranPage CopyExistandAddNew;
	VPAS_PopUpPage vPASPopUpPage;

	

	@FindBy(id = "OperationTypeChange Address")
	WebElement Change_Address;

	@FindBy(name = "SelectOperation_pyWorkPage_44")
	WebElement update_Address_Btn;

	@FindBy(xpath = "//div[@class='field-item dataLabelWrite heading_3_dataLabelWrite']")
	WebElement select_one_record_alpha_update;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Cancel')]")
	WebElement pop_Up_select_one_record_Close;

	@FindBy(name = "SelectOperation_pyWorkPage_45")
	WebElement update_changePhone_Btn;

	@FindBy(xpath = "//*[@id='EXPAND-OUTERFRAME']/tbody/tr/td")
	WebElement pop_Up_to_Select_one_Record;

	@FindBy(xpath = ".//*[@id='submitButton']")
	WebElement submit_Vpsa_Btn;

	@FindBy(xpath = "//input[@id='OperationTypeChange Phone']")
	WebElement change_Phone_Btn;

	public void change_existingAddress() throws Exception {

		try {
			CopyExistandAddNew = new CopyExistandAddNew_PerformTranPage(driver);
			vPASPopUpPage = new VPAS_PopUpPage(driver);

			String copyExisting = "";
			String addNew = "";
			String changePhone = "";

			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			copyExisting = reader.getMapData(CommonVariable.Test_copy_Existing,
					map);
			addNew = reader.getMapData(CommonVariable.Test_add_New, map);
			changePhone = reader.getMapData(CommonVariable.Test_change_Phone,
					map);

			// Executing copy Existing Address
			if (copyExisting.equalsIgnoreCase("Yes")) {

				boolean selected_status = Change_Address.isSelected();

				if (selected_status) {

					select_PeopleToUpdate("Copy_Existing");
					CopyExistandAddNew.select_CopyExisting();

				}
			}
			// Executing Add New Address
			if (addNew.equalsIgnoreCase("Yes")) {

				select_PeopleToUpdate("add_NewAddress");
				CopyExistandAddNew.select_AddNew_Address();

			}
			// Executing Change Phone
			if (changePhone.equalsIgnoreCase("Yes")) {
				CopyExistandAddNew.select_change_PhoneNumber();
			}
			utility.click_On_Button(submit_Vpsa_Btn);
			// landing to resolve completed page
			vPASPopUpPage.vpas_Submit(); 

		} catch (Exception e) {
			extent_Reportlogger("Execution failed", "change_existingAddress ",
					"Fail");
			excelWrite.writeInCell(

			"Failed in change_existingAddress", "Fail");

			ErrorLogger.logError(e.getClass().getName(),
					"change_existingAddress", e.getMessage());
		
			throw e;
		}

	}

	// select  people to update for which we want to copy the address/Add New Address
	public void select_PeopleToUpdate(String testCaseName) throws Exception {
		try {
			String select_PeopleToUpdate_Value = "";

			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget2Ifr");
			if (testCaseName.equalsIgnoreCase("add_NewAddress")) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,-350)", "");
				select_PeopleToUpdate_Value = reader.getMapData(
						CommonVariable.select_PeopleToUpdate_Value_addNew, map);

			} else if (testCaseName.equalsIgnoreCase("Copy_Existing"))
				select_PeopleToUpdate_Value = reader
						.getMapData(
								CommonVariable.select_PeopleToUpdate_Value_copyExisting,
								map);
			else if (testCaseName.equalsIgnoreCase("Change_Phone"))
				select_PeopleToUpdate_Value = reader.getMapData(
						CommonVariable.select_PeopleToUpdate_Value_changePhone,
						map);

	//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

			// Negative  Scenario : check the checkbox is selected or not.If it not selected thn
			// popup will come

			if (select_PeopleToUpdate_Value == ""
					|| select_PeopleToUpdate_Value.isEmpty()) {

			//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				utility.click_On_Button(update_Address_Btn);
			//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

				pop_Up_to_Select_one_Record.click();

			//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				String pop_Up_to_Select_one_Record_Message = select_one_record_alpha_update
						.getText();

				extent_Reportlogger(testCaseName
						+ " :  "
						+ pop_Up_to_Select_one_Record_Message,
						"Select_record_pop_UP Message", "Fail");

				pop_Up_select_one_record_Close.click();
		//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

				excelWrite.writeInCell(testCaseName + " pop_UP Message - "
						+ pop_Up_to_Select_one_Record_Message, "Fail");

			}
               //positve Scanerio : select  people to update for which we want to copy the address/Add New Address
			else {
				int parseData = Integer.parseInt(select_PeopleToUpdate_Value
						.substring(0, 1)) + 1;
				String people_To_Update = Integer.toString(parseData);
				System.out
						.println("people_To_Update_addNew" + people_To_Update);

				List<WebElement> checkboxes = driver.findElements(By
						.xpath("//input[@id='pySelected'][@type='checkbox']"));
				boolean bValue = false;
				int a = checkboxes.size();
				System.out.println("size od " + a);
				for (int i = 0; i < a; i++) {
					bValue = checkboxes.get(i).isSelected();
					System.out.println("value ;;;;;" + bValue);
					if (bValue) {
						checkboxes.get(i).click();
						System.out.println("Uncheck the selected checkbox");
					} else {
						System.out.println("No checkbox is selected");
					}
				}

			//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				driver.findElement(
						By.xpath("//table[@summary='MCAddressUpdateResults.pxResults']//td[2]//table//tr["
								+ people_To_Update + "]//td[1]")).click();

				extent_Reportlogger(" :Successfully selected one  record for alpha update  ",
						testCaseName, "PASS");

				//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));

				if (testCaseName.equalsIgnoreCase("add_NewAddress")
						|| testCaseName.equalsIgnoreCase("Copy_Existing")) {

									
					
					utility.click_On_Button(update_Address_Btn);
				}

				else {
					System.out.println("inside phone");
					
					utility.click_On_Button(update_changePhone_Btn);
					
				}

				excelWrite.writeInCell(

				testCaseName + ":Successfully selected  one  record for alpha update", "Pass");

			}
		} catch (Exception e) {
			extent_Reportlogger("Execution Failed", "select_PeopleToUpdate",
					"PASS");
			excelWrite.writeInCell(testCaseName
					+ "Failed in select_PeopleToUpdate", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"select_PeopleToUpdate", e.getMessage());

			throw e;
		}
	}
}
