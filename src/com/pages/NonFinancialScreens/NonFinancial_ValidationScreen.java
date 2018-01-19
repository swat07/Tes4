package com.pages.NonFinancialScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Initialize_Browser;

public class NonFinancial_ValidationScreen extends Initialize_Browser {
	



	public NonFinancial_ValidationScreen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Submit')]")
	public WebElement validateInput_Submit_Btn;
		
		
		
		//@FindBy(xpath="//table[@id='bodyTbl_right']//tbody")	
	@FindBy(xpath="//table[@pl_prop_class='McCamish-Data-ValidateSummery']")
		public WebElement validateMessagesTable;
		
		@FindBy(xpath="//table[@id='bodyTbl_right']//tbody//tr")
		public WebElement rows;
		
		
		
		@FindBy(xpath="//table[@pl_prop='.ValidationSummary']")
		public WebElement policyChangedate_validateMessagesTable;
		
		
		@FindBy(xpath=".//*[@id='RULE_KEY']/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/span")
		public WebElement validateMessages;
		
		//@FindBy(xpath="//div[@class='field-item dataLabelRead']")
		
		@FindBy(xpath="//table[@aria-label='Validation Messages']/following-sibling::table//div[@class='field-item dataLabelRead']")
		//@FindBy(xpath="//div[@pyclassname='McCamish-FW-BckOff-Work-PolicyChanges-CellCovMaint']//div[@class='field-item dataLabelRead']")
		public WebElement checkNoerror_validateMessages1;
		
		
		@FindBy(xpath="//div[@pyclassname='McCamish-FW-BckOff-Work-PolicyChanges-FaceChange']//div[@class='field-item dataLabelRead']")
		public WebElement reduceface_ValidateMsz;
		
		@FindBy(xpath="//div[@node_name='MCDisplayValidateMsgs']//table//tr[1]//td[2]//label")
		public WebElement addCovrage_ValidationMsz;
		
		//@FindBy(xpath=".//*[@id='RULE_KEY']/table/tbody/tr/td[1]/nobr/label")
		//@FindBy(xpath="//div[@datasource='pyWorkPage.ValidateList_MCDisplayValidateMsgs_1']//table//tr[1]//td[1]//label")
		
		//@FindBy(xpath="//table[@pl_prop='.ValidateList']")
		@FindBy(xpath="//table[@pl_prop_class='McCamish-Data-ValidateSummery']")
		public WebElement review_ValidationMsz;
		
		
		@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
		public WebElement validateInput_Close_Btn;
		
		
	}


