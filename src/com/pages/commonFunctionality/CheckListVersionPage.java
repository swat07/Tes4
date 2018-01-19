package com.pages.commonFunctionality;

import java.util.concurrent.TimeUnit;

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


public class CheckListVersionPage extends Initialize_Browser{
	public CheckListVersionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(id = "PegaGadget1Ifr")
	public WebElement chkLstCopyFrame;
	
	@FindBy(id = "PolTypeID")
	public WebElement product_DrpDwn;
	
	@FindBy(id = "KeyCategory")
	public WebElement catogory_DrpDwn;
	
	@FindBy(id = "submitButton")
	public WebElement next_Btn;
	
	public void selectProduct_Category() throws Exception {
		try { 
			driver.switchTo().frame(driver.switchTo().activeElement());
			//Select Product
			utility.dropdown_selectByVisibleText(product_DrpDwn, reader.getMapData(CommonVariable.product, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			//Select Key Category
			utility.dropdown_selectByVisibleText(catogory_DrpDwn, reader.getMapData(CommonVariable.category, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			//Clcik on Next button
			next_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "selectProduct_Category", "PASS");
			excelWrite.writeInCell("Test Step Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectProduct_Category", "FAIL");
			excelWrite.writeInCell("Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"selectProduct_Category", e.getMessage());
			throw e;
		}
	}
}
