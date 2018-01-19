package com.pages.AddressChangeScreens.callPortal;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.commonScreens_CP.Action_Summary;
import com.pages.commonScreens_CP.Workflow_Confirmation;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.WriteExcelFile;

public class CP_ChangePhone extends Initialize_Browser {

	public CP_ChangePhone(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);

	@FindBy(xpath = ".//*[@id='OperationTypeChange Phone']")
	WebElement chnagePhn_rdBtn;

	@FindBy(xpath = "//table[@pl_prop='.SearchResults']")
	WebElement changePhn_selPeopletoUpdte;

	@FindBy(xpath = ".//*[@id='submitButton']")
	WebElement cSR_SubmitBtn;

	@FindBy(xpath = "//table[@pl_prop='.PhoneChangeList']")
	WebElement updatePhnNumbers;

	@FindBy(xpath = "/button[@id='submitButton']")
	WebElement cP_DoneBtn;

	public void changePhone_CP() throws Exception {
		ArrayList<String> phoneList = new ArrayList<String>();
		String value = "";

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
		String regex = "\\d{10}";

		List<WebElement> rows = updatePhnNumbers.findElements(By.tagName("tr"));
		System.out.println("ds");
		int rowCount = rows.size();
		
		for (int i = 2; i <= rowCount; i++) {
			System.out.println("dfsd");
			if (rowsExist(i, 3)) {
				value = driver.findElement(
						By.xpath("//table[@pl_prop='.PhoneChangeList']//tr["
								+ i + "]//td[3]")).getText();
				if (value.equalsIgnoreCase("Billing")
						&& phone_Billing.matches(regex)
						&& !(phone_Billing == null)) {
					driver.findElement(
							By.xpath("//table[@pl_prop='.PhoneChangeList']//tr["
									+ i + "]//td[4]//input[@id='PhoneNumber']"))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"),
									Keys.BACK_SPACE, phone_Billing, Keys.TAB);
					
				}

				if (value.equalsIgnoreCase("Residence")
						&& phone_Residence.matches(regex)
						&& !(phone_Residence == null)) {
					driver.findElement(
							By.xpath("//table[@pl_prop='.PhoneChangeList']//tr["
									+ i + "]//td[4]//input[@id='PhoneNumber']"))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"),
									Keys.BACK_SPACE, phone_Residence, Keys.TAB);
					
				}

				if (value.equalsIgnoreCase("Disbursement")
						&& phone_Disbursement.matches(regex)
						&& !(phone_Disbursement == null)) {
					driver.findElement(
							By.xpath("//table[@pl_prop='.PhoneChangeList']//tr["
									+ i + "]//td[4]//input[@id='PhoneNumber']"))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"),
									Keys.BACK_SPACE, phone_Disbursement,
									Keys.TAB);
					
				}

				if (value.equalsIgnoreCase("Mailing")
						&& phone_Mailing.matches(regex)
						&& !(phone_Mailing == null)) {
					driver.findElement(
							By.xpath("//table[@pl_prop='.PhoneChangeList']//tr["
									+ i + "]td[4]//input[@id='PhoneNumber']"))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"),
									Keys.BACK_SPACE, phone_Mailing, Keys.TAB);
					
				}

				if (value.equalsIgnoreCase("Business")
						&& phone_Business.matches(regex)
						&& !(phone_Business == null)) {
					driver.findElement(
							By.xpath("//table[@pl_prop='.PhoneChangeList']//tr["
									+ i + "]//td[4]//input[@id='PhoneNumber']"))
							.sendKeys(Keys.chord(Keys.CONTROL, "a"),
									Keys.BACK_SPACE, phone_Business, Keys.TAB);
					
				}
			}

		}
		extent_Reportlogger("Test Step Execution Successfull",
				"changePhone_CP", "PASS");
		excelWrite.writeInCell(
				"changePhone_CP Test Step Execution Successfull", "PASS");
		utility.click_On_Button(cSR_SubmitBtn);
		
		// Landing to accept changes
		utility.click_On_Button(cSR_SubmitBtn);
		
		// transaction has been completed
		utility.click_On_Button(cSR_SubmitBtn);
		

	}

	public boolean rowsExist(int i, int j) {
		try {

			driver.findElement(
					By.xpath("//table[@pl_prop='.PhoneChangeList']//tbody//tr["
							+ i + "]//td[" + j + "]")).getTagName();

			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void callPortalAddressChange_EndInteraction(String testCase)
			throws Exception {
		try {
			Workflow_Confirmation workflow_Confirmation = new Workflow_Confirmation(driver);
			Action_Summary action_Summary = new Action_Summary(driver);

			workflow_Confirmation.enterComments();
			workflow_Confirmation.done_ButtonClick();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("cpmInteractionDivFrame");
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			if (testCase.equalsIgnoreCase("changePhone")) {
				action_Summary.wrapUp_LinkClick();
				driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
				action_Summary.enterWrapUpDetails_EndInteraction();
			}
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"callPortal_EndInteraction", "FAIL");
			excelWrite
					.writeInCell(
							"callPortal_EndInteraction Test Step Execution Unsuccessfull",
							"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"callPortal_EndInteraction", e.getMessage());
			throw e;
		}
	}

}
