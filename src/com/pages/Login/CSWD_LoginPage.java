package com.pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ReadDataFromExcel;
import com.utility.Test_BaseClass;

public class CSWD_LoginPage extends Initialize_Browser {
	
	public CSWD_LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	BaseUtils utility = new BaseUtils(driver);
	@FindBy(id = "txtUserID")
	WebElement userid;

	@FindBy(id = "txtPassword")
	WebElement Password;

	@FindBy(className = "loginButton")
	WebElement loginButton_Btn;

	
	
	public void login_To_CSWD_application() throws Exception {
		try {
			Thread.sleep(2000);
			String userName=null;
			String password=null;
			if(reader.getMapData(CommonVariable.Portal, map).equalsIgnoreCase("Manager"))
			{
				userName=reader.getCellData("Application", 2, 2);
				password=reader.getCellData("Application", 3, 2);
			}
			else if(reader.getMapData(CommonVariable.Portal, map).equalsIgnoreCase("User"))
			{
				userName=reader.getCellData("Application", 2, 3);
				password=reader.getCellData("Application", 3, 3);
			}
			else if(reader.getMapData(CommonVariable.Portal, map).equalsIgnoreCase("Manager Call"))
			{
				userName=reader.getCellData("Application", 2, 4);
				password=reader.getCellData("Application", 3, 4);
			}
			else if(reader.getMapData(CommonVariable.Portal, map).equalsIgnoreCase("User Call"))
			{
				userName=reader.getCellData("Application", 2, 5);
				password=reader.getCellData("Application", 3, 5);
			}	
		
			Thread.sleep(1000);
			utility.enter_Text(userid, userName);
			Thread.sleep(1000);
			utility.enter_Text(Password, password);
			Thread.sleep(1000);
			extent_Reportlogger("Test Step Execution successfull","login_To_CSWD_application", "Pass");
			utility.click_On_Button(loginButton_Btn);
		
			excelWrite.writeInCell("login_To_CSWD_application Test Step Execution successfull", "Pass");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			reader.updateStatusInExcel("CSWD_Test_Cases","Fail", currentTCName);
			extent_Reportlogger("Test Step Execution failed", "login_To_CSWD_application", "Fail");
			excelWrite.writeInCell("login_To_CSWD_application Test Step Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"login_To_CSWD_application", e.getMessage());
			throw e;
	}
	}
}
