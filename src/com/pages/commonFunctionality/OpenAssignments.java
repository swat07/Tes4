package com.pages.commonFunctionality;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.Test_BaseClass;


public class OpenAssignments extends Test_BaseClass{
	
public OpenAssignments(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

BaseUtils utility = new BaseUtils(driver);

	@FindBy(xpath = "//a[text()='        Admin CkList   ']")
	public WebElement adminCheckListLink;
	
	@FindBy(id = "FindingApproveCheckList")
	public WebElement Finding_drpDwn;
	
	//Create
	@FindBy(xpath = "//a[@class='Header_nav'][contains(.,'Create')]")
	WebElement create;

	@FindBy(xpath = "//td[text()='BckOff']")
	WebElement backOffice;

	//Options
	@FindBy(xpath = "//a[@class='Header_nav'][contains(.,'Options')]")
	WebElement options;
	
	@FindBy(xpath = "//td[text()='Bulk Transfer']")
	public WebElement bulkTransfer;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Submit')]")
	WebElement submit_Policy;
	
	@FindBy(xpath = "//td[text()='BckOff']")
	WebElement selectCase;

	@FindBy(id = "KeyTopic1")
	public WebElement selectCategory_drpdwn;

	@FindBy(id = "PolicyNo")
	public WebElement policyNo;

	@FindBy(id = "PolicyCategory")
	public WebElement policyTransaction_drpdwn;

	@FindBy(xpath = "//button[text()='  Submit ']")
	public WebElement submit_Btn;

	@FindBy(xpath = "//div[text()='Submit']")
	public WebElement submitProcessTask_Btn;

	@FindBy(xpath = ".//*[@id='$PCaseContentsPage$ppxResults$l2$ppxResults$l1']/ul/li[2]/div/a[1]")
	public WebElement executeChecklist;
	
	String caseName;
	@FindBy(xpath = "//a[text()='        Respond To Question   ']")
	public WebElement respondToQsn;
	
	@FindBy(xpath = "//table[@pl_prop='.CheckList(Target).ItemsCapture']")
	public WebElement tastToPrformQsns_Table;
	
	
	public void clickCaseLink(String caseNameToBeClicked) throws Exception
	{
		try{//a[contains(text(),"Respond To Question")]
			driver.findElement(By.xpath("//a[contains(text(),'"+caseNameToBeClicked+"')]")).click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","clickCaseLink_"+caseNameToBeClicked, "PASS");
			excelWrite.writeInCell("clickCaseLink for "+caseNameToBeClicked+" Test Step Execution successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "clickCaseLink_"+caseNameToBeClicked, "FAIL");
		excelWrite.writeInCell("clickCaseLink_"+caseNameToBeClicked+" Test Step Failed", "FAIL");
		ErrorLogger.logError(e.getClass().getName(),"clickCaseLink_"+caseNameToBeClicked, e.getMessage());
		throw e;
	}
	}
	
	public void approveTask() throws Exception
	{
		try{
			utility.dropdown_selectByVisibleText(Finding_drpDwn, "Approve");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,100)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			submit_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			driver.switchTo().defaultContent();
			
			extent_Reportlogger("Test Step Execution successfull","approveTask", "PASS");
			excelWrite.writeInCell("approveTask Test Step Execution successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "approveTask", "FAIL");
		excelWrite.writeInCell("approveTask Test Step Execution Failed", "FAIL");
		ErrorLogger.logError(e.getClass().getName(),"approveTask", e.getMessage());
		throw e;
		}
		}
	
	public void createBackOff() throws Exception
	{
		try{
			//Click on Create Menu
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
			create.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			//Select Back Office
			backOffice.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","createBackOff", "PASS");
			excelWrite.writeInCell("createBackOff Test Step Execution successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "createBackOff", "FAIL");
		excelWrite.writeInCell("createBackOff Test Step Failed", "FAIL");
		ErrorLogger.logError(e.getClass().getName(),"createBackOff", e.getMessage());
		throw e;
		}
	}

	public void selectCategoryTransaction() throws Exception
{
	try{
		driver.switchTo().frame(driver.switchTo().activeElement());
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		
		utility.dropdown_selectByValue(selectCategory_drpdwn,reader.getMapData(CommonVariable.key_Topic, map));
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
		
		
		policyNo.sendKeys(reader.getMapData(CommonVariable.policy_Number, map),Keys.TAB);
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(20, TimeUnit.SECONDS));
		
		utility.dropdown_selectByVisibleText(policyTransaction_drpdwn,reader.getMapData(CommonVariable.key_Category, map));
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
		
		submitProcessTask_Btn.click();
		Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
		
		extent_Reportlogger("Test Step Execution successfull","selectCategoryTransaction", "PASS");
		excelWrite.writeInCell("selectCategoryTransaction Test Step Execution successfull", "PASS");
} catch (Exception e) {
	extent_Reportlogger("Test Step Execution failed", "selectCategoryTransaction", "FAIL");
	excelWrite.writeInCell("selectCategoryTransaction Test Step Failed", "FAIL");
	ErrorLogger.logError(e.getClass().getName(),"selectCategoryTransaction", e.getMessage());
	throw e;
	}
}

	public void optionsBulkTransferClick() throws Exception
	{
		try{
			//Click on Options Menu
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(7, TimeUnit.SECONDS));
			options.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			//Select Bulk Transfer
			bulkTransfer.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(9, TimeUnit.SECONDS));
			
			driver.switchTo().frame("PegaGadget1Ifr");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution successfull","optionsBulkTransferClick", "PASS");
			excelWrite.writeInCell("optionsBulkTransferClick Test Step Execution successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "optionsBulkTransferClick", "FAIL");
		excelWrite.writeInCell("optionsBulkTransferClick Test Step Failed", "FAIL");
		ErrorLogger.logError(e.getClass().getName(),"optionsBulkTransferClick", e.getMessage());
		throw e;
		}
	}
	
	public void clickExecuteCheckList() throws Exception{
		try{

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			executeChecklist.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(10, TimeUnit.SECONDS));
			
			driver.switchTo().defaultContent();

			extent_Reportlogger("Test Step Execution successfull","clickExecuteCheckList", "PASS");
			excelWrite.writeInCell("clickExecuteCheckList Test Step Execution successfull", "PASS");
	} catch (Exception e) {
		extent_Reportlogger("Test Step Execution failed", "clickExecuteCheckList", "FAIL");
		excelWrite.writeInCell("clickExecuteCheckList Test Step Failed", "FAIL");
		ErrorLogger.logError(e.getClass().getName(),"clickExecuteCheckList", e.getMessage());
		throw e;
		}
	}

	public void taskToPerformQuestions() throws Exception{
		try{
			driver.switchTo().frame("PegaGadget3Ifr");
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			List<WebElement> qsnTableRowsBefQsn=tastToPrformQsns_Table.findElements(By.tagName("tr"));
			String newUpdatedQsn=driver.findElement(By.xpath("//table[@pl_prop='.CheckList(Target).ItemsCapture']//tr["+qsnTableRowsBefQsn.size()+"]//td[2]//span")).getText();
				if(newUpdatedQsn.equals(reader.getMapData(CommonVariable.new_Question, map))){
					extent_Reportlogger("Test Step Execution successfull","taskToPerformQuestions", "PASS");
					excelWrite.writeInCell("taskToPerformQuestions Test Step Execution successfull", "PASS");
				}
				else{
					extent_Reportlogger("Test Step Execution failed: Updated Question is different from entered new Question", "taskToPerformQuestions", "FAIL");
					excelWrite.writeInCell("taskToPerformQuestions Test Step Failed: Updated Question is different from entered new Question", "FAIL");
				}

				driver.switchTo().defaultContent();
				driver.findElement(By.xpath("//img[@src='webwb/logo_11256325929.gif!!.gif']")).click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(8, TimeUnit.SECONDS));
				
				extent_Reportlogger("Test Step Execution successfull","taskToPerformQuestions", "PASS");
				excelWrite.writeInCell("taskToPerformQuestions Test Step Execution successfull", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "taskToPerformQuestions", "FAIL");
			excelWrite.writeInCell("taskToPerformQuestions Test Step Failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(),"taskToPerformQuestions", e.getMessage());
			throw e;
			}
	}
}




