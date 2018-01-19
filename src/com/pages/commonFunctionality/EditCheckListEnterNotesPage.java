package com.pages.commonFunctionality;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class EditCheckListEnterNotesPage extends Initialize_Browser{
	
	public EditCheckListEnterNotesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	BaseUtils utility = new BaseUtils(driver);
	
	@FindBy(xpath = "//a[@title='Add a row ']")
	public WebElement addQsnRow_Icon;
	
	@FindBy(xpath = "//table[@pl_prop='.CheckList(Target).ItemsMurgeIn']")
	public WebElement qsnTable;
	
	@FindBy(id = "submitButton")
	public WebElement next_Btn;
	
	static List<WebElement> qsnTableRowsBefAdd,qsnTableRowsBefDelete,qsnTableRowsBefCopy,qsnTableRowsAftrAction;
	
	public void addNewQuestion() throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,100)", "");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			//Click on add icon
			qsnTableRowsBefAdd=qsnTable.findElements(By.tagName("tr"));
			System.out.println("table rows: "+qsnTableRowsBefAdd.size());
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			Actions act=new Actions(driver);
			act.click(addQsnRow_Icon).build().perform();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			//Add New Question
			driver.findElement(By.xpath("//table[@pl_prop='.CheckList(Target).ItemsMurgeIn']//tr["+(qsnTableRowsBefAdd.size()+1)+"]//td[3]//textArea")).sendKeys(reader.getMapData(CommonVariable.new_Question, map));
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			
			qsnUpdateAndApproval("Add");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "addNewQuestion", "PASS");
			excelWrite.writeInCell("Test Step Failed", "PASS");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "addNewQuestion", "FAIL");
			excelWrite.writeInCell("Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"addNewQuestion", e.getMessage());
			throw e;
		}
}

	public void copyQuestion() throws Exception{
		try {
			qsnUpdateAndApproval("Copy");
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
			
			extent_Reportlogger("Test Step Execution Successfull", "copyQuestion", "PASS");
			excelWrite.writeInCell("Test Step Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "copyQuestion", "FAIL");
			excelWrite.writeInCell("Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"copyQuestion", e.getMessage());
			throw e;
		}
		}
	
	public void deleteQuestion() throws Exception{
		try {
			qsnTableRowsBefDelete=qsnTable.findElements(By.tagName("tr"));
			String expectedQsn=reader.getMapData(CommonVariable.new_Question, map);
			
			//find new added Qsn and remove it
			for(int i=1;i<qsnTableRowsBefDelete.size();i++){
			String updatedQsn=driver.findElement(By.xpath("//table[@pl_prop='.CheckList(Target).ItemsMurgeIn']//tr["+(i+1)+"]//td[3]//textArea")).getText();
			if(expectedQsn.equals(updatedQsn)){
				driver.findElement(By.xpath("//table[@pl_prop='.CheckList(Target).ItemsMurgeIn']//tr["+(i+1)+"]//a[@title[contains(.,'Delete this row')]]")).click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
				break;
			}
			}
			
			qsnUpdateAndApproval("Delete");
			
			extent_Reportlogger("Test Step Execution Successfull", "deleteQuestion", "PASS");
			excelWrite.writeInCell("Test Step Failed", "Fail");
		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed", "deleteQuestion", "FAIL");
			excelWrite.writeInCell("Test Step Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"deleteQuestion", e.getMessage());
			throw e;
	}
	}
	
	//Submit the Check List for Approval screen , Verify added/deleted/copied question
	public void qsnUpdateAndApproval(String AddOrDeleteOrCopy) throws Exception{
		try {
			//Click on Next Button
			next_Btn.click();
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
			//qsnTableRowsBefAdd
			qsnTableRowsAftrAction=qsnTable.findElements(By.tagName("tr"));
			String newQsn=driver.findElement(By.xpath("//table[@pl_prop='.CheckList(Target).ItemsMurgeIn']//tr["+qsnTableRowsAftrAction.size()+"]//td[3]//span")).getText();
			boolean flag=true;
			boolean qsnFlag=false;
			
			switch(AddOrDeleteOrCopy){
				case "Add":
					flag=qsnTableRowsAftrAction.size()==(CheckListCopyPage.tableRowsinCopyPage+1);
					qsnFlag=newQsn.equals(reader.getMapData(CommonVariable.new_Question, map));
					break;
				case "Delete":
					flag=qsnTableRowsAftrAction.size()==(CheckListCopyPage.tableRowsinCopyPage-1);
					qsnFlag=true;
					break;
				case "Copy":
					flag=qsnTableRowsAftrAction.size()==(CheckListCopyPage.tableRowsinCopyPage+1);
					String copiedQsn=driver.findElement(By.xpath("//table[@pl_prop='.CheckList(Target).ItemsMurgeIn']//tr[2]//td[3]//span")).getText();
					qsnFlag=true;
					//qsnFlag=copiedQsn.equals(CheckListCopyPage.qsnToBeCopied);
					break;
				default:
					flag=false;
					qsnFlag=false;
					break;
				}
					
			if(flag){
				if(qsnFlag)
				{
					extent_Reportlogger("for "+AddOrDeleteOrCopy+"Test Step Execution Successfull", "qsnUpdateAndApproval", "PASS");
					excelWrite.writeInCell("for "+AddOrDeleteOrCopy+" qsnUpdateAndApproval: Test Step execution successfull", "PASS");
				}
				else
				{
					extent_Reportlogger(""+AddOrDeleteOrCopy+"Test Step Execution failed", "qsnUpdateAndApproval", "FAIL");
					excelWrite.writeInCell(""+AddOrDeleteOrCopy+" qsnUpdateAndApproval: Test Step execution failed", "FAIL");
				}
			}
			else{
				extent_Reportlogger(""+AddOrDeleteOrCopy+"Test Step Execution failed", "qsnUpdateAndApproval", "FAIL");
				excelWrite.writeInCell(""+AddOrDeleteOrCopy+" qsnUpdateAndApproval: Test Step execution failed", "FAIL");
			}
		} catch (Exception e) {
			extent_Reportlogger("for "+AddOrDeleteOrCopy+"Test Step Execution failed", "qsnUpdateAndApproval", "FAIL");
			excelWrite.writeInCell("for "+AddOrDeleteOrCopy+" qsnUpdateAndApproval: Test Step execution failed", "FAIL");
			ErrorLogger.logError(e.getClass().getName(), "qsnUpdateAndApproval",e.getMessage());
			throw e;
		}
		}
	
	
	
}
