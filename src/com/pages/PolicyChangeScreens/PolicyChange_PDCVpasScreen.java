package com.pages.PolicyChangeScreens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Initialize_Browser;

public class PolicyChange_PDCVpasScreen extends Initialize_Browser{
	
	public PolicyChange_PDCVpasScreen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = ".//*[@id='submitButton']")
	public WebElement PDCVpasSubmit_Btn;

}
