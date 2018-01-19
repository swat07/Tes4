package com.manager;

import com.utility.ErrorLogger;
import com.utility.ExcelUtils;
import com.utility.OutputFolderStructure;
import com.utility.ReadPropertyFile;
import com.utility.RuntimeXML;
import com.utility.WriteExcelFile;

public class ControlManager {

	/*
	 * Store Y/N market value, selected by user
	 */
	public static String application = null;

	/*
	 * @function: setup folder structure and output file
	 * 
	 * @function: execute market wise testng class
	 */
	public static void controTestNG() throws Exception {

		try {
			preTestSetup(ReadPropertyFile.loadProperty("APPLICATION_NAME"));
			new TestNGTrigger();
		} catch (Exception e) {
			e.printStackTrace();
			ErrorLogger.logError(e.getClass().getName(), "controTestNG",
					e.getMessage());
		}
	}

	/*
	 * createBlanckXmlFile(String packgecountryName,String
	 * sheetName,ArrayList<XLClassMethodInfo> list) Create Dynamic Xml File have
	 * suite information and specific test case name for execution Get Test Data
	 * From TestSheet.xl File , this data tells which perticular test case will
	 * execute
	 * 
	 * Create output folder structure Folder structure contain out xl file and
	 * one subfolder contaion screeen shot
	 * 
	 * Folder structure contain out xl file and one subfolder contaion screeen
	 * shot
	 */
	public static void preTestSetup(String packageName) throws Exception {

		try {
			application = packageName;
			System.out.println(application);
			OutputFolderStructure.createOutputFolderPath();
			OutputFolderStructure.createScreenShotFolderPath();
			OutputFolderStructure.createExtentReportFolderPath();
			WriteExcelFile.createXlSheet(application, OutputFolderStructure.poutputfolderpath);
			RuntimeXML.createBlankXMlFile(application,
					ExcelUtils.getexecutionData(application+"_Test_Cases"));
		} catch (Exception e) {
			e.printStackTrace();
			ErrorLogger.logError(e.getClass().getName(), "preTestSetup",
					e.getMessage());
		}
	}
}
