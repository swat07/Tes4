package com.pages.AddressChangeScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utility.Initialize_Browser;

public class CSWD_GoodOrderCheckPage extends Initialize_Browser {

	

	public CSWD_GoodOrderCheckPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "Response1")
	public WebElement taskToPerf_SignVerified_drpdwn;

	@FindBy(id = "Response2")
	public WebElement taskToPerf_ReqIGO_drpdwn;

/*	@FindBy(id = "Finding1")
	WebElement procDec_SignValidate;
*/
	
	@FindBy(id = "Finding1")
	public WebElement procDec_SignValidate_drpdwn;

	
	@FindBy(id = "Finding2")
	public WebElement procDec_NonFinReq_drpdwn;
	
	@FindBy(id = "Finding3")
	public WebElement procDec_GoodOrderReq_drpdwn;
	
	@FindBy(id = "submitButton")
	public WebElement submit;
	
	//OFCA Successfully
	
	@FindBy(id = "Finding1")
	public WebElement oFCA_drpdwn;
	
		
	
	
	
	public void submit(){
		submit.click();
	}

	
}
