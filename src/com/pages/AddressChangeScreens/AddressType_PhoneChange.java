package com.pages.AddressChangeScreens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class AddressType_PhoneChange extends Initialize_Browser {
	

	public AddressType_PhoneChange(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath = "//table[@pl_prop='TempPhones.pxResults']//tr[contains(.,'Business')]//td[2]//input")
	 WebElement change_Phone_Business;

	@FindBy(xpath = "//table[@pl_prop='TempPhones.pxResults']//tr[contains(.,'Billing')]//td[2]//input")
	 WebElement change_Phone_Billing;

	@FindBy(xpath = "//table[@pl_prop='TempPhones.pxResults']//tr[contains(.,'Disbursement')]//td[2]//input")
	 WebElement change_Phone_Disbursement;

	@FindBy(xpath = "//table[@pl_prop='TempPhones.pxResults']//tr[contains(.,'Residence')]//td[2]//input")
	 WebElement change_Phone_Residence;

	@FindBy(xpath = "//table[@pl_prop='TempPhones.pxResults']//tr[contains(.,'Mailing')]//td[2]//input")
	 WebElement change_Phone_Mailing;

	@FindBy(className = "buttonTdButton")
	 WebElement submit_To_VPAS_ChangePhone_Btn;
	
	public void enter_Phone_Information() throws Exception {
		try {
			
			String phone_Billing = reader.getMapData(
					CommonVariable.change_Phone_Billing, map);
			String phone_Business = reader.getMapData(
					CommonVariable.change_Phone_Business, map);
			String phone_Disbursement = reader.getMapData(
					CommonVariable.change_Phone_Disbursement, map);
			String phone_Residence = reader.getMapData(
					CommonVariable.change_Phone_Residence, map);
			String phone_Mailing = reader.getMapData(
					CommonVariable.change_Phone_Mailing, map);
			System.out.println("print phone number" + phone_Billing
					+ phone_Residence + phone_Disbursement);
			String regex = "\\d{10}";

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			if (phone_Billing.matches(regex) && !(phone_Billing == null)) {
				change_Phone_Billing.click();
				change_Phone_Billing.sendKeys(phone_Billing,
						Keys.TAB);

			}

			else {
				ErrorLogger.logError("CSWD_AddressChange",
						"enter_Phone_Information", "Invalid phone number");
				excelWrite.writeInCell("Invalid phone number", "Fail");
			}
		//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (phone_Business.matches(regex) && !(phone_Business == null)) {
				change_Phone_Business.click();
				change_Phone_Business.sendKeys(
						phone_Business, Keys.TAB);
			} else {
				ErrorLogger.logError("CSWD_AddressChange",
						"enter_Phone_Information", "Invalid phone number");
				excelWrite.writeInCell("Invalid phone number", "Fail");
			}
		//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (phone_Disbursement.matches(regex)
					&& !(phone_Disbursement == null)) {
				change_Phone_Disbursement.click();
				change_Phone_Disbursement.sendKeys(
						phone_Disbursement, Keys.TAB);

			} else {
				ErrorLogger.logError("CSWD_AddressChange",
						"enter_Phone_Information", "Invalid phone number");
				excelWrite.writeInCell("Invalid phone number", "Fail");
			}

		//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			if (phone_Mailing.matches(regex) && !(phone_Mailing == null)) {
				change_Phone_Mailing.click();
				change_Phone_Mailing.sendKeys(phone_Mailing,
						Keys.TAB);

			} else {
				ErrorLogger.logError("CSWD_AddressChange",
						"enter_Phone_Information", "Invalid phone number");
				excelWrite.writeInCell("Invalid phone number", "Fail");

			}
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			if (phone_Residence.matches(regex) && !(phone_Residence == null)) {
				change_Phone_Residence.click();
				change_Phone_Residence.sendKeys(
						phone_Residence, Keys.TAB);

			} else {
				ErrorLogger.logError("CSWD_AddressChange",
						"enter_Phone_Information", "Invalid phone number");
				excelWrite.writeInCell("Invalid phone number", "Fail");
			}

		//	Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

			extent_Reportlogger(" successfully done ",
					"Enetered Phone Number", "Pass");

			excelWrite
					.writeInCell(
							"Successfully enetered Phone Number ",
							"Pass");

			submit_To_VPAS_ChangePhone_Btn.click();

		} catch (Exception e) {
			extent_Reportlogger(" Execution Failed", "enter_Phone_Information",
					"Pass");
			excelWrite.writeInCell("Failed in enter_Phone_Information",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					" enter_Phone_Information", e.getMessage());
		}

	}

}
