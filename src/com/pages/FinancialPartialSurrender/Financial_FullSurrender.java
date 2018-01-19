package com.pages.FinancialPartialSurrender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class Financial_FullSurrender extends Initialize_Browser {

	public Financial_FullSurrender(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//label[text()='Tax']")
	public WebElement tax_Tab;
	
	@FindBy(id = "IRSDistCode")
	public WebElement irs_DistCode_DrpDown;
	
	@FindBy(xpath = "//div[text()='Calculate']")
	public WebElement calculate_Btn;
	
	@FindBy(id = "VerifiedDisbFlag")
	public WebElement verifiedDisbFlag_checkBox;
	
	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement validate_Btn;
	
	
	public void openTab(String tabName) throws Exception {
		try {
			driver.findElement(By.xpath("//label[text()='"+tabName+"']")).click();
			extent_Reportlogger("Test Step Execution successfull","openTab-"+tabName, "PASS");
			excelWrite.writeInCell("openTab-"+tabName+ "Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "openTab-"+tabName, "FAIL");
			excelWrite.writeInCell("openTab-"+tabName+" Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"openTab-"+tabName, e.getMessage());
			throw e;
	}
}
	
	public void taxAndDisbursementTabProcess() throws Exception {
		try {
			openTab("Tax");
			utility.selectvalueByText_DropdownList(irs_DistCode_DrpDown,reader.getMapData(CommonVariable.IRS_Distributioncode, map));
			calculate_Btn.click();
			Thread.sleep(3000);
			openTab("Disbursement");
			verifiedDisbFlag_checkBox.click();
			validate_Btn.click();
			Thread.sleep(2000);
			extent_Reportlogger("Test Step Execution successfull","taxAndDisbursementTabProcess", "PASS");
			excelWrite.writeInCell("taxAndDisbursementTabProcess Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "taxAndDisbursementTabProcess", "FAIL");
			excelWrite.writeInCell("taxAndDisbursementTabProcess Test Step Execution Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"taxAndDisbursementTabProcess", e.getMessage());
			throw e;
	}
}

}
