package com.pages.Investment_BO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.pages.AddressChangeScreens.CSWD_LandingPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class ExistingDCASchedule extends Test_BaseClass{
	
	public ExistingDCASchedule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath="//div[text()='Add New Schedule']")
	public WebElement addNewSchedule_Btn;
	
	@FindBy(id="CDAccount")
	public WebElement cdAccount_drpdwn;
	
	@FindBy(id="PremiumAccount")
	public WebElement premiumAccount_drpdwn;
	
	@FindBy(id="Frequency")
	public WebElement frequency_drpdwn;
	
	@FindBy(xpath="//input[@id='StartDate']")
	public WebElement startDate_txtBox;
	
	@FindBy(id="EvntDate")
	public WebElement event_Date;
	
	@FindBy(id="EffDate")
	public WebElement eff_Date;
	
	@FindBy(xpath="//input[@id='EndDate']")
	public WebElement endDate_txtBox;
	
	//Transfer From Details
	@FindBy(id="TransferFrmMthd")
	public WebElement transferFrmMthd_drpdwn;
	
	@FindBy(id="DPLTN")
	public WebElement noOfPeriods_TxtBox;
	
	@FindBy(id="FlatAmount")
	public WebElement flatAmount_TxtBox;
	
	@FindBy(id="POV")
	public WebElement percent_TxtBox;
	
	@FindBy(id="FundID")
	public WebElement fundID_drpdwn;
	
	@FindBy(xpath="//input[@id='Fee']")
	public WebElement fee_txtBox;
	
	//Transfer To Details
	@FindBy(id="ToMthd")
	public WebElement transferToMthd_drpdwn;
	
	@FindBy(xpath="//table[@pl_prop_class='McCamish-Data-GetToFunds']//input[@id[contains(.,'Amount')]]")
	public WebElement amount_Table;
	
	@FindBy(xpath="//table[@pl_prop_class='McCamish-Data-GetToFunds']//input[@id[contains(.,'Percent')]]")
	public WebElement percent_Table;
	
	@FindBy(xpath="//table[@pl_prop_class='McCamish-Data-GetToFunds']//input[@id[contains(.,'Percent')]]")
	public WebElement percet_Table;
	
	@FindBy(xpath="//div[text()='Proceed']")
	public WebElement proceed_Btn;
	
	@FindBy(xpath="//div[text()='Validate Selection']")
	public WebElement validateSel_Btn;
	
	public void addNewSchedule_ButtonClick() throws Exception {
		try
		{
		addNewSchedule_Btn.click();

		extent_Reportlogger("Test Step Execution Successfull", "addNewSchedule_ButtonClick", "PASS");
		excelWrite.writeInCell("addNewSchedule_ButtonClick Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "addNewSchedule_ButtonClick", "FAIL");
		excelWrite.writeInCell("addNewSchedule_ButtonClick Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"addNewSchedule_ButtonClick", e.getMessage());
		throw e;
	}
	}
	
	public void enterStartingDetails() throws Exception {
		try
		{
			String cdAccount=reader.getMapData(CommonVariable.cdAccountType, map);	
			String premiumAccount=reader.getMapData(CommonVariable.premium_Account, map);
			String frequency=reader.getMapData(CommonVariable.frequency, map);
			String start_Date=reader.getMapData(CommonVariable.start_Date, map);
			String end_Date=reader.getMapData(CommonVariable.expire_Date, map);
		
		utility.dropdown_selectByVisibleText(cdAccount_drpdwn,cdAccount);
		utility.dropdown_selectByVisibleText(premiumAccount_drpdwn,premiumAccount);
		utility.dropdown_selectByVisibleText(frequency_drpdwn,frequency);
		Thread.sleep(1000);
		//startDate_txtBox.clear();
		startDate_txtBox.sendKeys(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+start_Date+Keys.TAB);
		Thread.sleep(1000);
		//endDate_txtBox.clear();
		//endDate_txtBox.sendKeys(end_Date+Keys.TAB);
		utility.enter_Text(endDate_txtBox,end_Date);
		//endDate_txtBox.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		//utility.enter_Text(startDate_txtBox,start_Date);
		//Thread.sleep(1000);
		extent_Reportlogger("Test Step Execution Successfull", "enterStartingDetails", "PASS");
		excelWrite.writeInCell("enterStartingDetails Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "enterStartingDetails", "FAIL");
		excelWrite.writeInCell("enterStartingDetails Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"enterStartingDetails", e.getMessage());
		throw e;
	}
	}

	public void enterTransferFromDetails_DCA() throws Exception {
		try
		{
		String transferFromMethod=reader.getMapData(CommonVariable.transferFrom_Method, map);
		String periods_FlatAmount_Percent=reader.getMapData(CommonVariable.periods_FlatAmount_Percent, map);
		String feeAmount=reader.getMapData(CommonVariable.feeAmount, map);
		utility.dropdown_selectByVisibleText(transferFrmMthd_drpdwn,transferFromMethod);
		Thread.sleep(1000);
		
		if(transferFromMethod.equals("Depletion")){
			utility.enter_Text(noOfPeriods_TxtBox,(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+periods_FlatAmount_Percent+Keys.TAB));
			//noOfPeriods_TxtBox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,periods_FlatAmount_Percent,Keys.TAB);
			}
		else if(transferFromMethod.equals("Flat Amount"))
		{
			utility.enter_Text(flatAmount_TxtBox,(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+periods_FlatAmount_Percent+Keys.TAB));
			
			//flatAmount_TxtBox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,periods_FlatAmount_Percent,Keys.TAB);
		}
		else if(transferFromMethod.equals("Percent of Value"))
		{
			utility.enter_Text(percent_TxtBox,(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+periods_FlatAmount_Percent+Keys.TAB));
		
			//percent_TxtBox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,periods_FlatAmount_Percent,Keys.TAB);
		}
		Thread.sleep(1000);
		utility.dropdown_selectByVisibleText(fundID_drpdwn,reader.getMapData(CommonVariable.fund_ID, map));

		if(fee_txtBox.isEnabled()){
		utility.enter_Text(fee_txtBox,(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+feeAmount+Keys.TAB));
		Thread.sleep(1000);
		}
		//fee_txtBox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE,feeAmount,Keys.TAB);
		
		extent_Reportlogger("Test Step Execution Successfull", "enterTransferFromDetails", "PASS");
		excelWrite.writeInCell("enterTransferFromDetails Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "enterTransferFromDetails", "FAIL");
		excelWrite.writeInCell("enterTransferFromDetails Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"enterTransferFromDetails", e.getMessage());
		throw e;
	}
	}

	public void enterTransferToDetails_DCA() throws Exception {
		try
		{
		String transferToMethod=reader.getMapData(CommonVariable.transferTo_MethodOr_TransferBy, map);
		utility.dropdown_selectByVisibleText(transferToMthd_drpdwn,transferToMethod);
		Thread.sleep(1000);
		if(transferToMethod.equals("Amount")){
			enterFund_AmountDetails("DCAEvent","TFunds");
		}
		else if(transferToMethod.equals("Percent"))
		{
			enterFund_PercentDetails("DCAEvent","TFunds");
		}
		Thread.sleep(1000);
		extent_Reportlogger("Test Step Execution Successfull", "enterTransferToDetails_DCA", "PASS");
		excelWrite.writeInCell("enterTransferToDetails_DCA Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "enterTransferToDetails_DCA", "FAIL");
		excelWrite.writeInCell("enterTransferToDetails_DCA Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"enterTransferToDetails_DCA", e.getMessage());
		throw e;
	}
	}

	public void enterFund_AmountDetails(String category_DCAEvent_FundTransfer, String nodeName) throws Exception {
		try
		{
			WebElement we=driver.findElement(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-"+category_DCAEvent_FundTransfer+"'][@node_name='"+nodeName+"']//table[@pl_prop_class='McCamish-Data-GetToFunds']"));
			List<WebElement> funds=we.findElements(By.tagName("tr"));
			
			Random random = new Random();
			int  numberOfFunds = random.nextInt(funds.size()-1) + 1;
			System.out.println("Number of Funds to be entered: "+numberOfFunds);
			int  startingFund = random.nextInt(funds.size()-1)+1;
			List<Integer> fundsToBeEntered = new ArrayList<Integer>();
			fundsToBeEntered.add(startingFund);
			
			while(fundsToBeEntered.size()<numberOfFunds){
				int newGeneratedNumber=random.nextInt(funds.size()-1) + 1;
				for(int j=0;j<fundsToBeEntered.size();j++){
					if(fundsToBeEntered.get(j)==newGeneratedNumber){
						break;
					}
					else if(j==(fundsToBeEntered.size()-1)){
						fundsToBeEntered.add(newGeneratedNumber);
					}
				}
			}
			System.out.println("Fund List "+fundsToBeEntered);

			List<Integer> amount = new ArrayList<Integer>();
			int  percent;
			String periods_FlatAmount_Percent=reader.getMapData(CommonVariable.periods_FlatAmount_Percent, map);
			int no=Integer.parseInt(periods_FlatAmount_Percent);
			
			for(int i=0;i<fundsToBeEntered.size();i++){
				if(no==0)
					break;
				percent = random.nextInt(no)+1;
				if(i==(fundsToBeEntered.size()-1))
					amount.add(no);
				else
					amount.add(percent);
				
				no=no-percent;
			}
			System.out.println("Funds: "+amount);
			for(int i=0;i<amount.size();i++)
			{
				System.out.println("Fund No: "+fundsToBeEntered.get(i));
				
				WebElement we1=driver.findElement(By.xpath("//tr[@oaargs[contains(.,'McCamish-Data-Get')]][@pl_index='"+fundsToBeEntered.get(i)+"']//input[@id[contains(.,'Amount')]]"));
				utility.enter_Text(we1,Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+amount.get(i).toString()+Keys.TAB);
				System.out.println("Funds "+amount.get(i).toString());
				Thread.sleep(2000);
			}
		extent_Reportlogger("Test Step Execution Successfull", "enterFund_AmountDetails", "PASS");
		excelWrite.writeInCell("enterFund_AmountDetails Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "enterFund_AmountDetails", "FAIL");
		excelWrite.writeInCell("enterFund_AmountDetails Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"enterFund_AmountDetails", e.getMessage());
		throw e;
	}
	}
	
	public void enterFund_UnitsDetails(String category_DCAEvent_FundTransfer, String nodeName) throws Exception {
		try
		{
			Random random = new Random();
			List<WebElement> funds=driver.findElements(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-"+category_DCAEvent_FundTransfer+"'][@node_name='"+nodeName+"']//tr[@oaargs[contains(.,'McCamish-Data-Get')]]//input[@id[contains(.,'Units')]]"));
			System.out.println("Actual Number of Funds: "+funds.size());
			
			for(int i=0;i<funds.size();i++)
			{
			int n=random.nextInt(101)+1;
			WebElement we=driver.findElement(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-"+category_DCAEvent_FundTransfer+"'][@node_name='"+nodeName+"']//input[@id[contains(.,'Units"+(i+1)+"')]]"));
			utility.enter_Text(we,""+n+Keys.TAB);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			}
		
		extent_Reportlogger("Test Step Execution Successfull", "enterFund_UnitsDetails", "PASS");
		excelWrite.writeInCell("enterFund_UnitsDetails Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "enterFund_UnitsDetails", "FAIL");
		excelWrite.writeInCell("enterFund_UnitsDetails Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"enterFund_UnitsDetails", e.getMessage());
		throw e;
	}
	}
	
	public void enterFund_PercentDetails(String category_DCAEvent_FundTransfer, String nodeName) throws Exception {
		try
		{
		List<WebElement> funds=driver.findElements(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-"+category_DCAEvent_FundTransfer+"'][@node_name='"+nodeName+"']//tr[@oaargs[contains(.,'McCamish-Data-Get')]]//input[@id[contains(.,'Percent')]]"));
		System.out.println("Actual Number of Funds: "+funds.size());
		
		Random random = new Random();
		int  numberOfFunds = random.nextInt(funds.size()) + 1;
		System.out.println("Number of Funds to be entered: "+numberOfFunds);
		int  startingFund = random.nextInt(funds.size())+1;
		List<Integer> fundsToBeEntered = new ArrayList<Integer>();
		fundsToBeEntered.add(startingFund);
		
		while(fundsToBeEntered.size()<numberOfFunds){
			int newGeneratedNumber=random.nextInt(funds.size()) + 1;
			for(int j=0;j<fundsToBeEntered.size();j++){
				if(fundsToBeEntered.get(j)==newGeneratedNumber){
					break;
				}
				else if(j==(fundsToBeEntered.size()-1)){
					fundsToBeEntered.add(newGeneratedNumber);
				}
			}
		}
		System.out.println("Fund List "+fundsToBeEntered);

		List<Integer> percentageAmount = new ArrayList<Integer>();
		int  percent;
		int no=100;
		
		for(int i=0;i<fundsToBeEntered.size();i++){
			if(no==0)
				break;
			percent = random.nextInt(no)+1;
			if(i==(fundsToBeEntered.size()-1))
				percentageAmount.add(no);
			else
				percentageAmount.add(percent);
			
			no=no-percent;
		}
		System.out.println("Rebalance List "+percentageAmount);
		
		for(int i=0;i<percentageAmount.size();i++)
		{
			System.out.println("Fund No: "+fundsToBeEntered.get(i));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
			WebElement we=driver.findElement(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-"+category_DCAEvent_FundTransfer+"'][@node_name='"+nodeName+"']//tr[@pl_index='"+fundsToBeEntered.get(i)+"']//input"));
			we.sendKeys((Keys.chord(Keys.CONTROL,"a")+percentageAmount.get(i)),Keys.TAB);
			Thread.sleep(1000);
			//utility.enter_Text(we,percentageAmount.get(i).toString());
			//utility.enter_Text(we,Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+percentageAmount.get(i).toString()+Keys.TAB);
			//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(1, TimeUnit.SECONDS));
		}
		extent_Reportlogger("Test Step Execution Successfull", "enterFund_PercentDetails", "PASS");
		excelWrite.writeInCell("enterFund_PercentDetails Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "enterFund_PercentDetails", "FAIL");
		excelWrite.writeInCell("enterFund_PercentDetails Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"enterFund_PercentDetails", e.getMessage());
		throw e;
	}
	}
	
	public void enterEventDateAndEffDate() throws Exception {
		try {
			String start_Date=reader.getMapData(CommonVariable.start_Date, map);
			event_Date.sendKeys(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+start_Date+Keys.TAB);
			Thread.sleep(1000);
			String effc_Date=reader.getMapData(CommonVariable.effective_Date, map);
			eff_Date.sendKeys(Keys.chord(Keys.CONTROL,"a")+Keys.BACK_SPACE+effc_Date+Keys.TAB);
			Thread.sleep(2000);
			
			extent_Reportlogger("Test Step Execution Successfull", "enterEventDateAndEffDate", "PASS");
			excelWrite.writeInCell("enterEventDateAndEffDate Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterEventDateAndEffDate", "FAIL");
			excelWrite.writeInCell("enterEventDateAndEffDate Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterEventDateAndEffDate", e.getMessage());
			throw e;
		}
}
	
	public void validateSel_ButtonClick() throws Exception {
		try
		{
		validateSel_Btn.click();
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

		extent_Reportlogger("Test Step Execution Successfull", "validateSel_ButtonClick", "PASS");
		excelWrite.writeInCell("validateSel_ButtonClick Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "validateSel_ButtonClick", "FAIL");
		excelWrite.writeInCell("validateSel_ButtonClick Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"validateSel_ButtonClick", e.getMessage());
		throw e;
	}
	}
	public void proceed_ButtonClick() throws Exception {
		try
		{
			proceed_Btn.click();
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));

		extent_Reportlogger("Test Step Execution Successfull", "proceed_ButtonClick", "PASS");
		excelWrite.writeInCell("proceed_ButtonClick Test Step Execution Successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "proceed_ButtonClick", "FAIL");
		excelWrite.writeInCell("proceed_ButtonClick Test Step Failed", "Fail");
		ErrorLogger.logError(e.getClass().getName(),"proceed_ButtonClick", e.getMessage());
		throw e;
	}
	}
}
