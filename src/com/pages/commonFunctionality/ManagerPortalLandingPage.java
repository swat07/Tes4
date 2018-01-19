package com.pages.commonFunctionality;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class ManagerPortalLandingPage extends Test_BaseClass{
	
	public ManagerPortalLandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//a[@title='Launch another portal']")
	public WebElement launchPortal;
	
	@FindBy(xpath = "//td[text()='Back Office Portal']")
	public WebElement backOfficePortal;
	
	@FindBy(xpath = "//td[text()='Back Office Worker Portal']")
	public WebElement userPortal;
	
	@FindBy(xpath = "//a[@class='nav-toggle-one']")
	public WebElement userOptionMenu;
	
	@FindBy(xpath = "//td[text()='Catalog Admin']")
	public WebElement adminPortalLink;
	
	@FindBy(id = "PegaGadget0Ifr")
	public WebElement adminIFrame;
	
	@FindBy(xpath = "//li//ul//li[contains(.,'NonFin')]/preceding-sibling::li[1]//a")
	public WebElement nonFinCheckList_ExpandIcon;

	@FindBy(xpath = "//li[contains(.,'NonFin')]//ul[2]//li[1]//li//div[@id='iconExpandCollapse']/following-sibling::div")
	public WebElement actNFIGOCheck;
	
	@FindBy(xpath = "//i//img[@title='Build A  New List ']")
	public WebElement buildNewList_Icon;
	
	
	public void openAdminCatalog() throws Exception {
		try {
			//open user option menu
			userOptionMenu.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
			
			//Click on Admin portal Link
			adminPortalLink.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));

			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "openAdminCatalog", "PASS");
			excelWrite.writeInCell("Test Step Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "openAdminCatalog", "FAIL");
			excelWrite.writeInCell("Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"openAdminCatalog", e.getMessage());
			throw e;
		}
	}
	
	public void openBuildNonFinActNFIGOcheck() throws Exception {
		try { 
			driver.switchTo().frame("PegaGadget0Ifr");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,350)", "");
			
			//Open NonFin checklist
			nonFinCheckList_ExpandIcon.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			//Select actNFIGOCheck option
			actNFIGOCheck.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			//Click on buildNewList_Icon on bottom
			buildNewList_Icon.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			
			driver.switchTo().defaultContent();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "openBuildNonFinActNFIGOcheck", "PASS");
			excelWrite.writeInCell("Test Step Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "openBuildNonFinActNFIGOcheck", "FAIL");
			excelWrite.writeInCell("Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"openBuildNonFinActNFIGOcheck", e.getMessage());
			throw e;
		}
	}
}
