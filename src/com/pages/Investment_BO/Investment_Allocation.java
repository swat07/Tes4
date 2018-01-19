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


public class Investment_Allocation extends Test_BaseClass{
	
	public Investment_Allocation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//div[text()='Create New Allocation']")
	public WebElement createNewAlloc_Btn;
	
	//Allocation Add New Variables Pop up
	@FindBy(xpath = "//label[text()='Adhoc Rebalance (Reallocation)']")
	public WebElement transaction_ChkBOx;
	
	@FindBy(xpath = "//div[@fa_title='     Allocation Add New Variables     ']//div[text()='Submit']")
	public WebElement popup_Submit_Btn;
	
	@FindBy(xpath = "//div[@fa_title='     Allocation Add New Variables     ']//div[text()='Cancel']")
	public WebElement popup_Cancel_Btn;
	
	//Select CD Account Type
	@FindBy(id = "CDAccType")
	public WebElement cdAccountType_drpdwn;
	
	@FindBy(xpath = "//div[text()='Proceed']")
	public WebElement proceed_Btn;
	
	@FindBy(xpath = "//label[text()='Total']/ancestor::table[1]")
	public WebElement totalValue;
	
	@FindBy(xpath = "//table[@id='ERRORTABLE']")
	public WebElement error_Table;
	
	@FindBy(xpath = "//li[@class='errorText']")
	public WebElement rebalanceTotal_ErrorTxt;
	
	@FindBy(xpath = "//input[@id='EffectiveDate2']")
	public WebElement effectiveDate_TxtBox;
	
	@FindBy(xpath = "//input[@id='StartDate']")
	public WebElement startDate_TxtBox;
	
	@FindBy(xpath = "//input[@id='Expiration']")
	public WebElement expiration_TxtBox;
	
	@FindBy(id = "Frequency")
	public WebElement frequency_DrpDwn;

	@FindBy(id = "Period")
	public WebElement period_DrpDwn;
	
	@FindBy(id = "Basis")
	public WebElement basis_DrpDwn;
	
	@FindBy(xpath = ".//*[@id='IsDeductionAlloc']")
	public WebElement deductionAlloc_chkBox;
	
	@FindBy(xpath = "//table[@pl_prop='.InvSetupFunds']")
	public WebElement funds_table;
	
	@FindBy(xpath = "//select[@id[contains(.,'ModelModType')]]")
	public WebElement model_ModType;
	
	
	public void createNewAllocationClick() throws Exception {
		try {
			//Click on Create New Allocation screen
			createNewAlloc_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "createNewAllocationClick", "PASS");
			excelWrite.writeInCell("createNewAllocationClick Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "createNewAllocationClick", "FAIL");
			excelWrite.writeInCell("createNewAllocationClick Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"createNewAllocationClick", e.getMessage());
			throw e;
		}
}

	public void enterScheduleDetails() throws Exception {
		try {
			startDate_TxtBox.sendKeys(reader.getMapData(CommonVariable.start_Date, map),Keys.TAB);
			
			expiration_TxtBox.sendKeys(reader.getMapData(CommonVariable.expire_Date, map),Keys.TAB);
			
			utility.selectvalueByText_DropdownList(frequency_DrpDwn,reader.getMapData(CommonVariable.frequency, map));
			
			utility.selectvalueByText_DropdownList(period_DrpDwn,reader.getMapData(CommonVariable.select_Period, map));
			
			utility.selectvalueByText_DropdownList(basis_DrpDwn,reader.getMapData(CommonVariable.select_Basis, map));
			
			effectiveDate_TxtBox.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
			effectiveDate_TxtBox.sendKeys(reader.getMapData(CommonVariable.effective_Date, map),Keys.TAB);
			
			Thread.sleep(1000);
			extent_Reportlogger("Test Step Execution Successfull", "enterScheduleDetails", "PASS");
			excelWrite.writeInCell("enterScheduleDetails Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterScheduleDetails", "FAIL");
			excelWrite.writeInCell("enterScheduleDetails Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterScheduleDetails", e.getMessage());
			throw e;
		}
}
	
	public void allocationAddNewVarialble_Popup() throws Exception {
		try {
			String value=reader.getMapData(CommonVariable.transactionSelection_Popup, map);
			
			driver.findElement(By.xpath("//input[@type='checkbox'][@id='"+value+"']")).click();
			
			if(value.equalsIgnoreCase("AutoRebalance")){
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@type='checkbox'][@id='"+value+"']")).click();
			}
			Thread.sleep(1000);
			popup_Submit_Btn.click();
			
			extent_Reportlogger("Test Step Execution Successfull", "allocationAddNewVariable_Popup", "PASS");
			excelWrite.writeInCell("allocationAddNewVariable_Popup Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "allocationAddNewVariable_Popup", "FAIL");
			excelWrite.writeInCell("allocationAddNewVariable_Popup Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"allocationAddNewVariable_Popup", e.getMessage());
			throw e;
		}
}

	public void cdAccountSelection() throws Exception {
		try {
			if(cdAccountType_drpdwn.isEnabled()){
				utility.selectvalueByText_DropdownList(cdAccountType_drpdwn,reader.getMapData(CommonVariable.cdAccountType, map));
			}
			extent_Reportlogger("Test Step Execution Successfull", "cdAccountSelection", "PASS");
			excelWrite.writeInCell("cdAccountSelection Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "cdAccountSelection", "FAIL");
			excelWrite.writeInCell("cdAccountSelection Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"cdAccountSelection", e.getMessage());
			throw e;
		}
}
	
	public void enterFundDetails(String fundTablePl_Prop,String AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc) throws Exception {
		try {
			WebElement fundTble=driver.findElement(By.xpath("//table[@pl_prop='"+fundTablePl_Prop+"']"));
			List<WebElement> funds=fundTble.findElements(By.tagName("tr"));
			System.out.println("Actual Number of Funds: "+funds.size());
			
			Random random = new Random();
			int  numberOfFunds = random.nextInt(funds.size()-1) + 1;
			System.out.println("Number of Funds to be entered: "+numberOfFunds);
			int  startingFund = random.nextInt(funds.size()-1)+1;
			List<Integer> fundsToBeEntered = new ArrayList<Integer>();
			fundsToBeEntered.add(startingFund);
			
			while(fundsToBeEntered.size()<numberOfFunds){

				int newGeneratedNumber=random.nextInt(funds.size()-1) + 1;

				System.out.println("Generated no: "+newGeneratedNumber);
				for(int j=0;j<fundsToBeEntered.size();j++){
					boolean flag=driver.findElement(By.xpath("//table[@pl_prop='"+fundTablePl_Prop+"']//tr["+(newGeneratedNumber+1)+"]//td[3]//span")).getText().contains("CGO");
					if(flag){
						System.out.println("CGO available");
						break;
					}
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
			System.out.println(AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc);
			
			for(int i=0;i<percentageAmount.size();i++)
			{
				
				if(reader.getMapData(CommonVariable.transactionSelection_Popup, map).equalsIgnoreCase("AutoRebalance")){
					WebElement modeType=driver.findElement(By.xpath("//tr["+(fundsToBeEntered.get(i)+1)+"]//select[@id[contains(.,'ModelModType')]]"));
					boolean modeCheck=modeType.isEnabled();
					System.out.println("modeType enabled: "+modeCheck);
					if(modeType.isEnabled())
					{
						utility.selectvalueByText_DropdownList(modeType,reader.getMapData(CommonVariable.model_ModType, map));
					}
				}
				driver.findElement(By.xpath("//table[@pl_prop='"+fundTablePl_Prop+"']//tr["+(fundsToBeEntered.get(i)+1)+"]//td["+AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc+"]//input")).sendKeys(percentageAmount.get(i).toString(),Keys.TAB);
			}
			String event="";
			if(AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc.equalsIgnoreCase("4")){
				event="AdhocRebalance";
			}
			else if(AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc.equalsIgnoreCase("5")){
				event="AutoRebal";
			}
			else if(AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc.equalsIgnoreCase("6")){
				event="NewAllocation";
			}
			else if(AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc.equalsIgnoreCase("7")){
				event="DeductionAlloc";
			}
				
			
			Thread.sleep(1000);
			extent_Reportlogger("Test Step Execution Successfull", "enterFundDetailsFor"+event, "PASS");
			excelWrite.writeInCell("enterFundDetailsFor"+AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc+" Test Step Execution Successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "enterFundDetailsFor"+AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc, "FAIL");
			excelWrite.writeInCell("enterFundDetails"+AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc+" Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"enterFundDetailsFor"+AdhocRebalanceOrAutoRebalOrNewAllocationOrDeductionAlloc, e.getMessage());
			throw e;
		}
}
	
	public void total_Verification() throws Exception {
		try {
			List <WebElement> totalValues=totalValue.findElements(By.tagName("p"));
			String totalPercentage[]=new String[totalValues.size()];
			String transactionName[]=new String[totalValues.size()];
			
			for(int i=0;i<totalValues.size();i++){
				totalPercentage[i]=driver.findElement(By.xpath("//label[text()='Total']/ancestor::table[1]//td["+(i+2)+"]//p")).getText();
				transactionName[i]=driver.findElement(By.xpath("//label[text()='Total']/ancestor::table[1]//td["+(i+2)+"]//p")).getAttribute("Name").substring(23);
				System.out.println("Name : "+totalPercentage[i]);
				System.out.println("Name : "+transactionName[i]);
			}
			proceed_Btn.click();
			
			for(int i=0;i<totalValues.size();i++)
			{
				if(totalPercentage[i].equalsIgnoreCase("100"))
				{
					extent_Reportlogger("Successfull: Total is 100% thereby able to proceed", "Total_VerificationFor"+transactionName[i], "PASS");
					excelWrite.writeInCell("Total_VerificationFor"+transactionName[i]+" Successfull: Total is 100% thereby able to proceed", "PASS");
				}
				else
				{
					if(error_Table.isDisplayed())
					{
						extent_Reportlogger("Successfull: Error Message is ("+rebalanceTotal_ErrorTxt.getText()+")", "Total_ErrorMessage_VerificationFor"+transactionName[i], "PASS");
						excelWrite.writeInCell("Total_ErrorMessage_VerificationFor"+transactionName[i]+" Successfull: Error Message is ("+rebalanceTotal_ErrorTxt.getText()+")", "PASS");
					}
					else
					{
						extent_Reportlogger("Unuccessfull: No Error displayed", "Total_ErrorMessage_VerificationFor"+transactionName[i], "FAIL");
						excelWrite.writeInCell("Total_ErrorMessage_VerificationFor"+transactionName[i]+" Unsuccessfull: No Error displayed", "FAIL");
					}
					extent_Reportlogger("Successfull: Total is "+totalPercentage+"% thereby not able to proceed further", "Total_VerificationFor"+transactionName[i], "PASS");
					excelWrite.writeInCell("Total_VerificationFor"+transactionName[i]+" Successfull: Total is "+totalPercentage+"% thereby able not able to proceed further", "PASS");
				}
			}
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "Total_Verification", "FAIL");
			excelWrite.writeInCell("Total_Verification Test Step Execution Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),"Total_Verification", e.getMessage());
			throw e;
		}
}

}
