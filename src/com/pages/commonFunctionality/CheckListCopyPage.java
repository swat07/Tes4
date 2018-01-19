package com.pages.commonFunctionality;

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

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;


public class CheckListCopyPage extends Initialize_Browser{
		public CheckListCopyPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		BaseUtils utility = new BaseUtils(driver);
		static int tableRowsinCopyPage;
		static String qsnToBeCopied;
		
		@FindBy(id = "CaseName")
		public WebElement keyTopic_DrpDwn;
		
		@FindBy(id = "CaseType")
		public WebElement actionAct_DrpDwn;
		
		@FindBy(id = "KeyProductType")
		public WebElement keyProductType_DrpDwn;
		
		@FindBy(id = "KeyCategory")
		public WebElement keyCategory_DrpDwn;
		
		@FindBy(id = "backButton")
		public WebElement back_Btn;
		
		@FindBy(id = "submitButton")
		public WebElement next_Btn;
		
		@FindBy(xpath = "//table[@id='ViewTable']//input[@title='Select All Rows']")
		public WebElement allQsn_ChkBox;
		
		@FindBy(xpath = "//table[@id='ViewTable']")
		public WebElement qsn_table;
		
		
		public void selectValuesInCheckListCopy() throws Exception {
			try { 
				//Select Key Topic
				utility.dropdown_selectByVisibleText(keyTopic_DrpDwn, reader.getMapData(CommonVariable.key_Topic, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Select Active Action
				utility.dropdown_selectByVisibleText(actionAct_DrpDwn, reader.getMapData(CommonVariable.action_Active, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Select Key Product
				utility.dropdown_selectByVisibleText(keyProductType_DrpDwn, reader.getMapData(CommonVariable.key_Product_Type, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Select Key Category
				utility.dropdown_selectByVisibleText(keyCategory_DrpDwn, reader.getMapData(CommonVariable.key_Category, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				List<WebElement> qsnTableRows=qsn_table.findElements(By.tagName("tr"));
				tableRowsinCopyPage=qsnTableRows.size();
				
				//Select Question Check Box
				allQsn_ChkBox.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Click on Next button
				next_Btn.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(15, TimeUnit.SECONDS));

				extent_Reportlogger("Test Step Execution Successfull", "selectValuesInCheckListCopy", "PASS");
				excelWrite.writeInCell("Test Step Failed", "Fail");
			} catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "selectValuesInCheckListCopy", "FAIL");
				excelWrite.writeInCell("Test Step Failed", "Fail");
				ErrorLogger.logError(e.getClass().getName(),
						"selectValuesInCheckListCopy", e.getMessage());
				throw e;
			}
		}
		
		public void selectQsnToCopy() throws Exception {
			try { 
				//Select any random Question to copy
				//Select Key Topic
				utility.dropdown_selectByVisibleText(keyTopic_DrpDwn, reader.getMapData(CommonVariable.key_Topic, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Select Active Action
				utility.dropdown_selectByVisibleText(actionAct_DrpDwn, reader.getMapData(CommonVariable.action_Active, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Select Key Product
				utility.dropdown_selectByVisibleText(keyProductType_DrpDwn, reader.getMapData(CommonVariable.key_Product_Type, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Select Key Category
				utility.dropdown_selectByVisibleText(keyCategory_DrpDwn, reader.getMapData(CommonVariable.key_Category, map));
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				
				List<WebElement> qsnTableRows=qsn_table.findElements(By.tagName("tr"));
				tableRowsinCopyPage=qsnTableRows.size();
				Random rand = new Random(); 
				int value = rand.nextInt(qsnTableRows.size())+2; 
				System.out.println("copy value: "+value);
				driver.findElement(By.xpath("//table[@id='ViewTable']//tr["+(value)+"]//td//input[@type='checkbox']")).click();
				qsnToBeCopied=driver.findElement(By.xpath("//table[@id='ViewTable']//tr["+(value)+"]//td[2]")).getText();
				System.out.println("Qsn: "+qsnToBeCopied);
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
				
				//Click on Next button
				next_Btn.click();
				Sleeper.SYSTEM_SLEEPER.sleep(new Duration(15, TimeUnit.SECONDS));

				extent_Reportlogger("Test Step Execution Successfull", "selectQsnToCopy", "PASS");
				excelWrite.writeInCell("Test Step Failed", "Fail");
			} catch (Exception e) {
				extent_Reportlogger("Test Step Execution failed", "selectQsnToCopy", "FAIL");
				excelWrite.writeInCell("Test Step Failed", "Fail");
				ErrorLogger.logError(e.getClass().getName(),
						"selectQsnToCopy", e.getMessage());
				throw e;
			}
			}
}
