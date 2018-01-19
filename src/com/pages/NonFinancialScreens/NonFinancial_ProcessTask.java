package com.pages.NonFinancialScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;

public class NonFinancial_ProcessTask extends Test_BaseClass {
	
	public NonFinancial_ProcessTask(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Write Locators here
	
	@FindBy(id = "Finding2")
	public WebElement nonfinreq_drpdwn;
	
	@FindBy(id = "Response1")
	public WebElement taskToPerf_Formreceived_drpdwn;
	
	@FindBy(id = "Finding1")
	public WebElement taskToPerf_requiredSignValidated_drpdwn;
	
	@FindBy(id = "Response3")
	public WebElement taskToPerf_ReqIGO_drpdwn;
	
	@FindBy(id = "Finding1")
	public WebElement procDec_SignValidate_drpdwn;
	
	@FindBy(id = "Finding3")
	public WebElement procDec_GoodOrderReq_drpdwn;
	
	@FindBy(xpath = ".//*[@id='submitButton']")	
	public WebElement submit_Btn;
	
	@FindBy(xpath = ".//*[@id='submitButton']")	
	public WebElement ProcessTask_submit;
	

}
