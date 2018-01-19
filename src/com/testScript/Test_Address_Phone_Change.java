package com.testScript;

import java.io.IOException;

import jxl.write.WriteException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import com.functions.addressChange.InitialCommonScreens_ReusableFunction;
import com.pages.AddressChangeScreens.AddressType_PerformTransPage;
import com.pages.AddressChangeScreens.CSWD_GoodOrderCheckPage;
import com.pages.AddressChangeScreens.CSWD_LandingPage;
import com.pages.Login.CSWD_LoginPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;
import com.utility.WriteExcelFile;

public class Test_Address_Phone_Change extends Test_BaseClass {


	
	InitialCommonScreens_ReusableFunction resuablefunction= new InitialCommonScreens_ReusableFunction(driver);;
	
	AddressType_PerformTransPage addressChangeFunction; 
	

	// Address Change_Backoff
	@Test(priority = 0)
	public void Address_Change_Backoff() throws Exception {

		try {
			
			addressChangeFunction = new AddressType_PerformTransPage(driver);
			resuablefunction	= new InitialCommonScreens_ReusableFunction(driver);

			//Landing Page
			resuablefunction.landing_page();   
			//Select selectCategoryAndTransaction 
			resuablefunction.selectCategoryAndTransaction(); 
			//Execute Checklist
			resuablefunction.executeChecklist(); 
			//Process IGO Questions
			resuablefunction.processTasks();   
			// executing Address  phone Change
			addressChangeFunction.change_existingAddress(); 

			
		} catch (Exception e) {

			extent_Reportlogger("Test Case Failed", "Address_Change_Backoff",
					"Fail");
			excelWrite.writeInCell(
					"Address_Change_Backoff Test Case Failed", "Fail");
			ErrorLogger.logError(e.getClass().getName(),
					"Address_Change_Backoff", e.getMessage());

			e.printStackTrace();
			throw e;
		}

	}

}
