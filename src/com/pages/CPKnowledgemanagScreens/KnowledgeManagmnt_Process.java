package com.pages.CPKnowledgemanagScreens;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.PolicyChangeScreens.PolicyChange_PerformTransactionScreen;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;
import com.utility.ReadPropertyFile;

public class KnowledgeManagmnt_Process extends Initialize_Browser {

	public KnowledgeManagmnt_Process(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	BaseUtils utility = new BaseUtils(driver);

	String helpDocPath = "";

	String sopDocPath = "";

	String fileExtension = "";
	String filepath = "";
	String helpDocCurrent_Time = "";
	String sopDocCurrent_Time = "";
	String sopSplitTime = "";
	String helpSplitTime = "";
	/*
	 * String uploadedfileName1 = ""; String uploadedfileName2 = "";
	 */
	long helpSec;
	long sopSec;
	// Locators

	@FindBy(xpath = "//a[text()='Knowledge Managment']")
	public WebElement knowledgeManag_link;

	@FindBy(id = "DocTypeHDOC")
	public WebElement helpDoc_rdBtn;

	@FindBy(id = "DocTypeSOPDOC")
	public WebElement sopDoc_rdBtn;

	@FindBy(xpath = "//select[@id='PolicyType']")
	public WebElement cp_policyType_drpdwn;

	@FindBy(xpath = "//select[@id='IntentCategory']")
	public WebElement cp_TransCategory_drpdwn;

	@FindBy(xpath = "//select[@id='IntentTask']")
	public WebElement cp_TransTask_drpdwn;

	// file uploader lcoatrs
	@FindBy(xpath = ".//*[@id='$PpyDisplayHarness$ppxAttachName']")
	public WebElement cp_fileUpload;

	@FindBy(xpath = "//button[@name='DocuploadNew_pyDisplayHarness_14']")
	public WebElement uploadBtn;

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']")
	public WebElement gridTable;

	@FindBy(xpath = "//div[text()='Uploaded On']")
	public WebElement sort_uploadOnBtn;

	@FindBy(xpath = "//a[text()='Next']")
	public WebElement gridNext_lnk;

	@FindBy(xpath = "//a[text()='HELP / SOP Documents']")
	public WebElement Help_SOPdoc_link;

	// verify uploded doc

	@FindBy(xpath = "//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']")
	public WebElement verfiyUploadeddoc_link;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Close')]")
	public WebElement validateInput_Close_Btn;

	@FindBy(xpath = "//div[text()='Done']")
	public WebElement cp_DoneBtn;

	@FindBy(xpath = "//select[@id='pyDescription']")
	public WebElement SwitchUsrCP_drpdwn;

	public void knwldgeManagmnt_processTask() throws Exception {
		try {
			String policyType = "";
			String trans_Category_CP = "";
			String trans_Task_CP = "";

			policyType = reader.getMapData(CommonVariable.policy_Type_CP, map);

			trans_Category_CP = reader.getMapData(
					CommonVariable.trans_Category_CP, map);

			trans_Task_CP = reader
					.getMapData(CommonVariable.trans_Task_CP, map);
			// Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("testiframe");
			// Thread.sleep(1000);

			knowledgeManag_link.click();

			helpDoc_rdBtn.click();

			utility.selectvalueByText_DropdownList(cp_policyType_drpdwn,
					policyType);

			utility.selectvalueByText_DropdownList(cp_TransCategory_drpdwn,
					trans_Category_CP);

			utility.selectvalueByText_DropdownList(cp_TransTask_drpdwn,
					trans_Task_CP);

			excelWrite
					.writeInCell(
							"selectCategoryAndTransaction(policyType Selected = "
									+ policyType + ", "
									+ "trans_Category_CP passed = "
									+ trans_Category_CP + " and "
									+ "trans_Task_CP Selected = "
									+ trans_Task_CP + ")", "Pass");

			extent_Reportlogger(" Executed successfully",
					"selectCategoryAndTransaction", "Pass");

		} catch (Exception e) {
			extent_Reportlogger("Test Case Failed",
					"knwldgeManagmnt_processTask", "Fail");
			excelWrite.writeInCell(
					"knwldgeManagmnt_processTask Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"knwldgeManagmnt_processTask", e.getMessage());

			e.printStackTrace();
			throw e;
		}

	}

	// file upload help doc
	public void fileUploading_HelpSopDoc(String docType) throws Exception {
		try {

			helpDocPath = ReadPropertyFile
					.loadFileProperties("HELP_FIletoUploadPath");
			sopDocPath = ReadPropertyFile
					.loadFileProperties("SOP_FiletoUploadPath");

			String workingDir = System.getProperty("user.dir");

			Robot robot = new Robot();
			Thread.sleep(2000);
			cp_fileUpload.click();
			// robot.setAutoDelay(2000);
			// Specify the file location with extension

			if (docType.equalsIgnoreCase("HelpDoc")) {

				filepath = helpDocPath;

			} else {
				filepath = sopDocPath;

			}

			if (!(filepath.equalsIgnoreCase(workingDir))) {
				fileExtension = FilenameUtils.getExtension(filepath);

				if (fileExtension.equalsIgnoreCase("pdf")
						|| fileExtension.equalsIgnoreCase("docx")
						|| fileExtension.equalsIgnoreCase("doc")) {

					/*
					 * Robot robot = new Robot(); Thread.sleep(2000);
					 * cp_fileUpload.click();
					 */

					StringSelection sel = new StringSelection(filepath);
					// Copy to clipboard
					Toolkit.getDefaultToolkit().getSystemClipboard()
							.setContents(sel, null);

					robot.setAutoDelay(2000);

					// Press Enter
					robot.keyPress(KeyEvent.VK_ENTER);
					// Release Enter
					robot.keyRelease(KeyEvent.VK_ENTER);
					// Press CTRL+V
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					// Release CTRL+V
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_V);
					Thread.sleep(2000);
					// Press Enter
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);

					if (docType.equalsIgnoreCase("HelpDoc")) {

						utility.click_On_Button(uploadBtn);
						Timestamp timestamp = new Timestamp(
								System.currentTimeMillis());
						System.out.println("heltimestamp" + timestamp);
						SimpleDateFormat sdf = new SimpleDateFormat(
								"MMM d, YYYY h:mm:ss a");
						helpSec = timestamp.getSeconds();

						extent_Reportlogger("Successfully",
								"HELP Document uploaded ", "Pass");
						excelWrite.writeInCell(
								"HELP Document uploaded  Successfully", "Pass");
						Thread.sleep(3000);

						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("window.scrollBy(0,300)", "");

						utility.click_On_Button(sort_uploadOnBtn);
						Thread.sleep(2000);
						utility.click_On_Button(sort_uploadOnBtn);
						Thread.sleep(2000);

						List<WebElement> rows = gridTable.findElements(By
								.tagName("tr"));

						int countRows = rows.size();
						for (int i = 2; i <= countRows; i++) {
							String rowValueDate = driver
									.findElement(
											By.xpath("//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']//tbody//tr["
													+ i + "]//td[6]"))
									.getText();

							SimpleDateFormat sdf1 = new SimpleDateFormat(
									"MMM d, YYYY h:mm:ss a");
							Date date = sdf1.parse(rowValueDate);
							long actualSec = date.getSeconds();
							long DiffSec = helpSec - actualSec;
							timestamp
									.setSeconds((int) (timestamp.getSeconds() - DiffSec));
							helpDocCurrent_Time = sdf.format(timestamp);

							Thread.sleep(2000);

							String fileName = FilenameUtils.getName(filepath);

							String rowValDocName = driver
									.findElement(
											By.xpath("//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']//tbody//tr["
													+ i + "]//td[5]"))
									.getText();

							if (helpDocCurrent_Time
									.equalsIgnoreCase(rowValueDate)
									&& rowValDocName.equalsIgnoreCase(fileName)) {
								extent_Reportlogger("Successfully Verified",
										"HelpDoc Document uploaded in Grid",
										"Pass");

								excelWrite
										.writeInCell(
												"HelpDoc Document uploaded in Grid Successfully Verified",
												"Pass");
								break;
							} else {
								extent_Reportlogger("not Verified",
										"HelpDoc Document uploaded in Grid",
										"Fail");

								excelWrite
										.writeInCell(
												"HelpDoc Document uploaded in Grid not Verified",
												"Fail");
							}

						}

					} else {

						utility.click_On_Button(uploadBtn);
						Timestamp timestamp = new Timestamp(
								System.currentTimeMillis());
						System.out.println("SOptimestamp" + timestamp);
						SimpleDateFormat sdf = new SimpleDateFormat(
								"MMM d, YYYY h:mm:ss a");
						sopSec = timestamp.getSeconds();

						extent_Reportlogger("Successfully",
								"SOP Document uploaded ", "Pass");
						excelWrite.writeInCell(
								"SOP Document uploaded  Successfully",
								"Pass");
						Thread.sleep(3000);

						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("window.scrollBy(0,300)", "");

						utility.click_On_Button(sort_uploadOnBtn);
						Thread.sleep(2000);
						utility.click_On_Button(sort_uploadOnBtn);
						Thread.sleep(2000);

						List<WebElement> rows = gridTable.findElements(By
								.tagName("tr"));
						int countRows = rows.size();
						for (int i = 2; i <= countRows; i++) {

							String rowValueDate = driver
									.findElement(
											By.xpath("//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']//tbody//tr["
													+ i + "]//td[6]"))
									.getText();

							SimpleDateFormat sdf1 = new SimpleDateFormat(
									"MMM d, YYYY h:mm:ss a");
							Date date = sdf1.parse(rowValueDate);
							long actualSec = date.getSeconds();
							long DiffSec = sopSec - actualSec;

							timestamp
									.setSeconds((int) (timestamp.getSeconds() - DiffSec));
							sopDocCurrent_Time = sdf.format(timestamp);

							String fileName = FilenameUtils.getName(filepath);

							String rowValDocName = driver
									.findElement(
											By.xpath("//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']//tbody//tr["
													+ i + "]//td[5]"))
									.getText();

							if (sopDocCurrent_Time
									.equalsIgnoreCase(rowValueDate)
									&& rowValDocName.equalsIgnoreCase(fileName)) {
								extent_Reportlogger("Successfully Verified",
										"SopDoc Document uploaded in Grid",
										"Pass");

								excelWrite
										.writeInCell(
												"SopDoc Document uploaded in Grid Successfully Verified",
												"Pass");
								break;
							} else {
								extent_Reportlogger("not Verified",
										"SopDoc Document uploaded in Grid",
										"Fail");

								excelWrite
										.writeInCell(
												"SopDoc Document uploaded in Grid not Verified",
												"Fail");
							}

						}

					}

				} else {

					extent_Reportlogger(":" + docType, "Invalid FileExtension",
							"Pass");
					excelWrite.writeInCell(
							"Invalid File Extension :" + docType, "Pass");
				}
			} else {
				extent_Reportlogger(":" + docType, "FilePath is empty", "Pass");
				excelWrite.writeInCell("FilePath is empty :" + docType, "Pass");

			}

		} catch (Exception e) {
			extent_Reportlogger("Test Case Failed", "fileUploading_HelpSopDoc",
					"Fail");
			excelWrite.writeInCell("fileUploading_HelpSopDoc Test Case Failed",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"fileUploading_HelpSopDoc", e.getMessage());

			e.printStackTrace();
			throw e;
		}
	}

	

	// Switch to User call Portal

	public void switchToUserCP() throws Exception {
		try {
			Thread.sleep(2000);
			utility.select_DropdownList(SwitchUsrCP_drpdwn, "MCRMFW:Users");

			Thread.sleep(4000);
			extent_Reportlogger("Successfully ",
					"Switched to manager to User call Portal", "Pass");

			excelWrite.writeInCell(
					"Switched to manager to User call Portal Successfully ",
					"Pass");
		} catch (Exception e) {
			extent_Reportlogger("Test Case Failed", "switchToUserCP", "Fail");
			excelWrite.writeInCell("switchToUserCP Test Case Failed", "Fail");

			throw e;
		}

	}

	public void displayedHelp_SOPUploadedDoc() throws Exception {
		try {
			Help_SOPdoc_link.click();
			String parentwindow = "";
			// Switvh to another window
			Thread.sleep(8000);
			ArrayList<String> docList = new ArrayList<String>();
			parentwindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			Thread.sleep(5000);
			while (i1.hasNext()) {
				String child_window = i1.next();

				System.out.println("value" + child_window);
				if (!parentwindow.equalsIgnoreCase(child_window)) {

					driver.switchTo().window(child_window);
					((JavascriptExecutor) driver)
							.executeScript("window.focus();");

					System.out.println("After switching" + driver.getTitle());
					break;

				}
			}

			driver.manage().window().maximize();

			// verfy uploaded link

			String uploadedfileName1 = driver
					.findElement(
							By.xpath("//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']//tbody//tr[2]//td[2]"))
					.getText();

			if (uploadedfileName1.equalsIgnoreCase("testfile.pdf")
					|| uploadedfileName1.equalsIgnoreCase("testfile.docx")) {

				extent_Reportlogger("Successfully",
						" Uploaded Document displayed", "Pass");
				excelWrite.writeInCell(
						"Uploaded Document displayed Successfully", "Pass");
			} else {

				extent_Reportlogger("on Validation Screen",
						" Uploaded Document not  displayed ", "Pass");
				excelWrite
						.writeInCell(
								"Uploaded Document not  displayed on Validation Screen",
								"Pass");
			}
			String uploadedfileName2 = driver
					.findElement(
							By.xpath("//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']//tbody//tr[3]//td[2]"))
					.getText();

			if (uploadedfileName2.equalsIgnoreCase("testfile.pdf")
					|| uploadedfileName2.equalsIgnoreCase("testfile.docx")) {
				extent_Reportlogger("Successfully",
						" Uploaded Document displayed", "Pass");
				excelWrite.writeInCell(
						" Uploaded Document displayed Successfully", "Pass");
			} else {

				extent_Reportlogger("on Validation Screen",
						"  Uploaded Document not  displayed", "Pass");
				excelWrite
						.writeInCell(
								"Uploaded Document not  displayed on Validation Screen",
								"Pass");
			}

			utility.click_On_Button(validateInput_Close_Btn);

			// switch to back window

			driver.switchTo().window(parentwindow);// changes

			driver.switchTo().frame("cpmInteractionDivFrame");
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame(
					driver.findElement(By.xpath("//frame[@name='DIACTION']")));
			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");

			utility.click_On_Button(cp_DoneBtn);

		} catch (Exception e) {
			extent_Reportlogger("Test Case Failed",
					"displayedHelp_SOPUploadedDoc", "Fail");
			excelWrite.writeInCell(
					"displayedHelp_SOPUploadedDoc Test Case Failed", "Fail");
			throw e;
		}
	}

	// check grid row Exist or not??
	public boolean rowsExistfaceChange(int i) {

		try {

			driver.findElement(
					By.xpath("//table[@pl_prop_class='McCamish-FW-MCRMFW-Data-CPAttachFile']//tbody//tr["
							+ i + "]//td[2]")).getTagName();

			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
