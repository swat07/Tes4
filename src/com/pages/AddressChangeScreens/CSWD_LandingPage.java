package com.pages.AddressChangeScreens;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;

import com.utility.BaseUtils;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.WriteExcelFile;

public class CSWD_LandingPage extends Initialize_Browser {

	

	public CSWD_LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);

	@FindBy(xpath = "//a[@title='Launch another portal']")
	public WebElement launchPortal;

	@FindBy(xpath = "//td[text()='Back Office Worker Portal']")
	public WebElement backOffice_WorkPortal;

	@FindBy(xpath = "//td[text()='Back Office Portal']")
	public WebElement backOfficePortal;

	@FindBy(xpath = "//a[@class='Header_nav'][contains(.,'Create')]")
	WebElement create;

	@FindBy(xpath = "//td[text()='BckOff']")
	WebElement backOffice;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
	public WebElement submit_Policy;

	@FindBy(xpath = "//td[text()='BckOff']")
	WebElement selectCase;

	@FindBy(xpath = "//select[@id='KeyTopic1']")
	public WebElement selectCategory_drpdwn;

	@FindBy(id = "PolicyNo")
	public WebElement policyNo;

	@FindBy(id = "PolicyCategory")
	public WebElement policyTransaction_drpdwn;

	@FindBy(xpath = "//div[text()='Submit']")
	public WebElement submit_Btn;

	@FindBy(id = "submitButton")
	public WebElement submitProcessTask_Btn;

	@FindBy(xpath = ".//*[@id='$PCaseContentsPage$ppxResults$l2$ppxResults$l1']/ul/li[2]/div/a[1]")
	public WebElement executeChecklist;

	public void selectCase() throws Exception {

		try {

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(create);
		//	create.click();

			System.out.println("click on create");

			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			utility.click_On_Button(backOffice);
			//backOffice.click();

			excelWrite.writeInCell("selectCase execution Passed", "Pass");
			// Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

		} catch (Exception e) {

			excelWrite.writeInCell("selectCase execution failed", "Fail");
			extent_Reportlogger("Execution failed ", "selectCase", "Fail");

			ErrorLogger.logError(e.getClass().getName(), "selectCase",
					e.getMessage());
			e.printStackTrace();
			throw e;

		}

	}

}
