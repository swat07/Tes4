package com.pages.commonScreens_CP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class Welcome_Page extends Initialize_Browser{
	public Welcome_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//a[text()='Service a Customer']")
	public WebElement serviceACustomer_Link;

	public void serviceACustomer_LinkClick() throws Exception {
		try {
			serviceACustomer_Link.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(4, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "serviceACustomer_LinkClick", "PASS");
			excelWrite.writeInCell("serviceACustomer_LinkClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "serviceACustomer_LinkClick", "FAIL");
			excelWrite.writeInCell("serviceACustomer_LinkClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"serviceACustomer_LinkClick", e.getMessage());
			throw e;
		}
}

}
