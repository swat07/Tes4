package com.pages.NonFinancialScreens;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;

public class NonFinancial_PerformTransaction extends Initialize_Browser{

	

		public NonFinancial_PerformTransaction(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Write Locators here
	
	//NFO
	
	@FindBy(xpath= "//a[@class='iconInsert']")
	public WebElement AddNew_NFO;
	
	@FindBy(xpath= ".//*[@id='AdjEffDate']")
	public WebElement Eff_Date;
	
	@FindBy(xpath= "//select[contains(@id,'NFO')]") 
	public WebElement Primary_NFO;
	
	@FindBy(xpath= "//select[contains(@id,'AltNFO')]")
	public WebElement Alt_NFO;
	
	@FindBy(xpath="//div[@class='content-inner ']//span//i//img[contains(@src,'webwb/save_pressed')]")
	public WebElement Save_Btn;
	
	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Submit')]")
	public WebElement NFO_Submit_Btn;


	@FindBy(xpath = "//table[@pl_prop='.NFOEventSummary']//tr[2]//td[1]//span")
	public WebElement NFO_eventCode;
	
	@FindBy(xpath=".//*[@id='submitButton']")
	public WebElement NFO_DoneBtn;
	
	//DOC
	
	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Add New Dividend Option')]")
	public WebElement AddNew_DividendOption;
	
	@FindBy(xpath=".//*[@id='FixPremStatus']")
	public WebElement Fixed_PremiumStatus;
	
	@FindBy(xpath=".//*[@id='DividendOpt']")
	public WebElement Dividend_Option;
	
	@FindBy(xpath=".//*[@id='EffDate']")
	public WebElement EffDate_DOC;
	
	@FindBy(xpath=".//*[@id='ExcessDivOpt']")
	public WebElement Excess_DivOption;
	
	@FindBy(xpath=".//*[@id='OptPayInd']")
	public WebElement Optional_PayInd;
	
	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Validate')]")
	public WebElement ValidateInput_DOC;
	
	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Submit')]")
	public WebElement Submit_DOC;
	
	//@FindBy(xpath = ".//*[@id='submitButton']")
	//@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Submit')]")
	@FindBy(xpath ="//button[text()='  Submit ']")
	public WebElement DividendConfirmation_Submit;
	
	
	//Agent Chnage
	
	@FindBy(xpath=".//*[@id='AGOption']")
	public WebElement Select_AgentOption;
	
	@FindBy(xpath ="//div[@class='pzbtn-rnd'][contains(.,'Add New Agent Affiliation')]")
	public WebElement Add_NewAgentAff;
	
	@FindBy(xpath="//input[@id='Response_Field_Name']")
	public WebElement Locate_Agent;
	
	@FindBy(xpath=".//*[@id='Eff Date']")
	public WebElement AgentChange_EffDate;
	
	@FindBy(xpath=".//*[@id='AffilCategory']")
	public WebElement AgentChange_EffCategory;
	
	@FindBy(xpath=".//*[@id='TermDate']")
	public WebElement Agency_TermDate;
	
	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Validate')]")
	public WebElement ValidateInput_AgentChange;
	
	@FindBy(xpath = "//div[@class='pzbtn-rnd'][contains(.,'Submit')]")
	public WebElement Submit_AgentChange;
	
	@FindBy(xpath=".//*[@id='submitButton']")
	public WebElement Done_AgentChange;
	
	
	//Last Page , communication Locators
	
	@FindBy(xpath=".//*[@id='Finding1']")
	public WebElement NFGoodto_Proceed;
	
	@FindBy(xpath=".//*[@id='Finding2']")
	public WebElement NFtrack_Corros;
	
	@FindBy(xpath=".//*[@id='submitButton']")
	public WebElement Submit_CommPage;
	
	
	
	
	
	
	
	
	
}

