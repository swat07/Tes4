package com.pages.Investment_BO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;


public class CGO_Allocation extends Test_BaseClass{
	public CGO_Allocation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(id = "PreAccNum")
	public WebElement premiumAccount_drpDwn;
	
	@FindBy(xpath = "//div[text()='Fund Allocation']")
	public WebElement fundAllocation_Btn;
	
	@FindBy(xpath = "//div[text()='CGO Override']")
	public WebElement cgoOverride_Btn;
	
	@FindBy(xpath = "//div[text()='OK']")
	public WebElement ok_Btn;
	
	@FindBy(xpath = "//div[text()='Cancel']")
	public WebElement cancel_Btn;

	@FindBy(xpath = "//div[text()='Validate']")
	public WebElement validate_Btn;
	
	@FindBy(xpath = "//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']")
	public WebElement investmentFunds_Table;
	
	@FindBy(xpath = "//div[text()='Submit']")
	public WebElement submit_Btn;
	
	@FindBy(xpath = "//button[text()='  Confirm ']")
	public WebElement confirm_Btn;
	
	@FindBy(id = "Event Date for VPAS Automated Transactions")
	public WebElement event_Date;
	
	@FindBy(id = "EffDate")
	public WebElement eff_Date;
	
	public void selectPremiumAccount() throws Exception {
		try {
			String premiumAccnt=reader.getMapData(CommonVariable.premium_Account, map);
			utility.dropdown_selectByVisibleText(premiumAccount_drpDwn,premiumAccnt);
			Thread.sleep(1000);
			extent_Reportlogger("Test Step Execution Successfull", "selectPremiumAccount", "PASS");
			excelWrite.writeInCell("selectPremiumAccount Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "selectPremiumAccount", "FAIL");
			excelWrite.writeInCell("selectPremiumAccount Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"selectPremiumAccount", e.getMessage());
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
			Thread.sleep(1000);
			
			extent_Reportlogger("Test Step Execution Successfull", "enterEventDateAndEffDate", "PASS");
			excelWrite.writeInCell("enterEventDateAndEffDate Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterEventDateAndEffDate", "FAIL");
			excelWrite.writeInCell("enterEventDateAndEffDate Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterEventDateAndEffDate", e.getMessage());
			throw e;
		}
}
	
	public void fundAllocation_ButtonClick() throws Exception {
		try {
			while(!fundAllocation_Btn.isDisplayed()){
				Thread.sleep(1000);
			}
			fundAllocation_Btn.click();
			extent_Reportlogger("Test Step Execution Successfull", "fundAllocations_ButtonClick", "PASS");
			excelWrite.writeInCell("fundAllocation_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "fundAllocations_ButtonClick", "FAIL");
			excelWrite.writeInCell("fundAllocation_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"fundAllocation_ButtonClick", e.getMessage());
			throw e;
		}
}

	public void enterInvestmentFundDetails(String fundName) throws Exception {
		try
		{
			while(!investmentFunds_Table.isDisplayed()){
				System.out.println("not displayed");
				Thread.sleep(1000);
			}
		List<WebElement> totalFunds=investmentFunds_Table.findElements(By.tagName("tr"));
		System.out.println("total Funds: "+totalFunds.size());
		
		List<WebElement> mainFunds=driver.findElements(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']//tr//td[4]//span[contains(text(),'"+fundName+"')]/ancestor::tr[1]"));
		System.out.println("Main Funds : "+mainFunds.size());
		List<String> mainFundsIndexes = new ArrayList<String>();
		
		for(int i=0;i<mainFunds.size();i++){
			String rowIndex=mainFunds.get(i).getAttribute("pl_index");
			System.out.println("Row Index:  "+rowIndex);
			mainFundsIndexes.add(rowIndex);
		}
		
		Random random=new Random();
		int  numberOfFunds = random.nextInt(totalFunds.size()-1) + 1;
		System.out.println("Number of Funds to be entered: "+numberOfFunds);
		int  startingFund = random.nextInt(mainFundsIndexes.size());
		List<Integer> fundsToBeEntered = new ArrayList<Integer>();
		fundsToBeEntered.add(Integer.parseInt(mainFundsIndexes.get(startingFund)));
		
		while(fundsToBeEntered.size()<numberOfFunds){
			int newGeneratedNumber=random.nextInt(totalFunds.size()-1) + 1;
			for(int j=0;j<fundsToBeEntered.size();j++){
				if(fundsToBeEntered.get(j)==newGeneratedNumber){
					break;
				}
				else if(j==(fundsToBeEntered.size()-1)){
					fundsToBeEntered.add(newGeneratedNumber);
				}
			}
		}
		
		int  percent;
		int no=100;
		System.out.println("fundsTo be entered: "+fundsToBeEntered);
		for(int i=0;i<fundsToBeEntered.size();i++){
			String existingAmount=driver.findElement(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']//tr[@pl_index='"+fundsToBeEntered.get(i)+"']//td[7]//input")).getAttribute("value");
			int existAmnt=Integer.parseInt(existingAmount);
			System.out.println("existing Amount: "+existAmnt);
			
			if(no==0)
				break;
			
			if(existAmnt<=no){
			driver.findElement(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']//tr[@pl_index='"+fundsToBeEntered.get(i)+"']//td[1]//input[2]")).click();
			
			//WebElement modeType=driver.findElement(By.xpath("//tr[@pl_index='"+fundsToBeEntered.get(i)+"']//select[@id[contains(.,'ModelModType')]]"));
			//boolean modeCheck=modeType.isEnabled();
			//System.out.println("modeType enabled: "+modeCheck);
			//if(modeType.isEnabled())
			//{
				//utility.selectvalueByText_DropdownList(modeType,reader.getMapData(CommonVariable.model_ModType, map));
			//}
			
			Thread.sleep(1000);
			no=no-existAmnt;
			percent = random.nextInt(no)+1;
			
			if(existAmnt==0){
				if(i==(fundsToBeEntered.size()-1)){
					WebElement we=driver.findElement(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']//tr[@pl_index='"+fundsToBeEntered.get(i)+"']//td[7]//input"));
					we.sendKeys((Keys.chord(Keys.CONTROL,"a")+no),Keys.TAB);
					//we.sendKeys(Keys.TAB);
					//utility.enter_Text(we,(Keys.chord(Keys.CONTROL,"a")+no));
					System.out.println("entered Amount1: "+no);
					no=0;
				}
				else{
					WebElement we=driver.findElement(By.xpath("//div[@pyclassname='McCamish-FW-BckOff-Work-Investment-CGOAllocation']//table[@pl_prop='.InvSetupFunds']//tr[@pl_index='"+fundsToBeEntered.get(i)+"']//td[7]//input"));
					we.sendKeys((Keys.chord(Keys.CONTROL,"a")+percent),Keys.TAB);
					//we.sendKeys(Keys.TAB);
					//utility.enter_Text(we,(Keys.chord(Keys.CONTROL,"a")+percent));
					System.out.println("entered Amount2: "+percent);
					no=no-percent;
				}
				Thread.sleep(1000);
				WebElement modeType=driver.findElement(By.xpath("//tr["+(fundsToBeEntered.get(i)+1)+"]//select[@id[contains(.,'ModelModType')]]"));
				boolean modeCheck=modeType.isEnabled();
				System.out.println("modeType enabled: "+modeCheck);
				if(modeType.isEnabled())
				{
					utility.selectvalueByText_DropdownList(modeType,reader.getMapData(CommonVariable.model_ModType, map));
				}

				Thread.sleep(1000);
			}
			}
		}
			extent_Reportlogger("Test Step Execution Successfull", "enterInvestmentFundDetails", "PASS");
			excelWrite.writeInCell("enterInvestmentFundDetails Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterInvestmentFundDetails", "FAIL");
			excelWrite.writeInCell("enterInvestmentFundDetails Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterInvestmentFundDetails", e.getMessage());
			throw e;
		}
}

	public void validate_ButtonClick() throws Exception {
		try {
			validate_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "validate_ButtonClick", "PASS");
			excelWrite.writeInCell("validate_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "validate_ButtonClick", "FAIL");
			excelWrite.writeInCell("validate_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"validate_ButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void ok_ButtonClick() throws Exception {
		try {
			ok_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "ok_ButtonClick", "PASS");
			excelWrite.writeInCell("ok_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "ok_ButtonClick", "FAIL");
			excelWrite.writeInCell("ok_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"ok_ButtonClick", e.getMessage());
			throw e;
		}
}
	
	public void submit_ButtonClick() throws Exception {
		try {
			submit_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "submit_ButtonClick", "PASS");
			excelWrite.writeInCell("submit_ButtonClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "submit_ButtonClick", "FAIL");
			excelWrite.writeInCell("submit_ButtonClick Test Step Execution Unsuccessfull", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"submit_ButtonClick", e.getMessage());
			throw e;
		}
}
}
