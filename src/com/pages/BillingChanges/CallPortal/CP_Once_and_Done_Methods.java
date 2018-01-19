package com.pages.BillingChanges.CallPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.ErrorLogger;
import com.utility.Initialize_Browser;

public class CP_Once_and_Done_Methods extends Initialize_Browser {
	
	
	public CP_Once_and_Done_Methods(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	
	}
	
	
	BaseUtils utility = new BaseUtils(driver);
	
	
	//Locator of comment section
	
	@FindBy(xpath=".//*[@id='MCIntentAddlComments']")
	public WebElement AddnlComment_OnceDone;

	
	//Locator of submit button after comment
	
	
	@FindBy(xpath=".//*[@id='submitButton']")
	public WebElement Submit_OnceDone;
	
		
	
	//Method of reissue scenario
	
	public void CP_OnceAndDone_ReIssueMethod() throws Exception
	{
	try
	{
		utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
		utility.click_On_Button(Submit_OnceDone);
		
		
	} catch (Exception e) {
		
		extent_Reportlogger("Execution Failed","CP_OnceAndDone_ReIssue", "Fail");
		excelWrite.writeInCell("CP_OnceAndDone_ReIssue Test Case Failed","Fail");
		ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_ReIssue", e.getMessage());
		e.printStackTrace();


		throw e;


	}
}

	
	//Method of Termination Scenario
	
	public void CP_OnceAndDone_TerminationMethod() throws Exception
	{
	try
	{
		utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
		utility.click_On_Button(Submit_OnceDone);
		
		
	} catch (Exception e) {
		
		extent_Reportlogger("Execution Failed","CP_OnceAndDone_Termination", "Fail");
		excelWrite.writeInCell("CP_OnceAndDone_Termination Test Case Failed","Fail");
		ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_Termination", e.getMessage());
		e.printStackTrace();


		throw e;


	}
}

	
	//Method of Gender Change
	
	
	public void CP_OnceAndDone_GenderChangeMethod() throws Exception
	{
	try
	{
		utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
		utility.click_On_Button(Submit_OnceDone);
		
		
	} catch (Exception e) {
		
		extent_Reportlogger("Execution Failed","CP_OnceAndDone_GenderChange", "Fail");
		excelWrite.writeInCell("CP_OnceAndDone_GenderChange Test Case Failed","Fail");
		ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_GenderChange", e.getMessage());
		e.printStackTrace();


		throw e;


		}
	
	}
	



	//Method of Loan Intent
	
	
		public void CP_OnceAndDone_LoanIntentMethod() throws Exception
		{
		try
		{
			utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
			
			utility.click_On_Button(Submit_OnceDone);
			
			
		} catch (Exception e) {
			
			extent_Reportlogger("Execution Failed","CP_OnceAndDone_LoanIntent", "Fail");
			excelWrite.writeInCell("CP_OnceAndDone_LoanIntent Test Case Failed","Fail");
			ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_LoanIntent", e.getMessage());
			e.printStackTrace();


			throw e;
	
	
	
	
	}
		}
		
		
		//Method of misstatements
		
		
			public void CP_OnceAndDone_MisstatementsMethod() throws Exception
			{
			try
			{
				utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
				
				utility.click_On_Button(Submit_OnceDone);
				
				
			} catch (Exception e) {
				
				extent_Reportlogger("Execution Failed","CP_OnceAndDone_Misstatements", "Fail");
				excelWrite.writeInCell("CP_OnceAndDone_Misstatements Test Case Failed","Fail");
				ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_Misstatements", e.getMessage());
				e.printStackTrace();


				throw e;
		
		
				}
			}
			
		
			//Method of order prospectus
			
			
			public void CP_OnceAndDone_OrderProspectusMethod() throws Exception
			{
			try
			{
				utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
				
				utility.click_On_Button(Submit_OnceDone);
				
				
			} catch (Exception e) {
				
				extent_Reportlogger("Execution Failed","CP_OnceAndDone_OrderProspectus", "Fail");
				excelWrite.writeInCell("CP_OnceAndDone_OrderProspectus Test Case Failed","Fail");
				ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_OrderProspectus", e.getMessage());
				e.printStackTrace();


				throw e;
		
		
				}
			
			
			}
			
	//Method of General Enquiry			
			
			public void CP_OnceAndDone_GeneralInquiryMethod() throws Exception
			{
			try
			{
				utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
				
				utility.click_On_Button(Submit_OnceDone);
				
				
			} catch (Exception e) {
				
				extent_Reportlogger("Execution Failed","CP_OnceAndDone_GeneralInquiry", "Fail");
				excelWrite.writeInCell("CP_OnceAndDone_GeneralInquiry Test Case Failed","Fail");
				ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_GeneralInquiry", e.getMessage());
				e.printStackTrace();


				throw e;
		
		
				}
			
			
			}
			
			
			
	//Method of miscellaneous intent
			
			public void CP_OnceAndDone_MiscellaneousMethod() throws Exception
			{
			try
			{
				utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
				
				utility.click_On_Button(Submit_OnceDone);
				
				
			} catch (Exception e) {
				
				extent_Reportlogger("Execution Failed","CP_OnceAndDone_Miscellaneous", "Fail");
				excelWrite.writeInCell("CP_OnceAndDone_Miscellaneous Test Case Failed","Fail");
				ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_Miscellaneous", e.getMessage());
				e.printStackTrace();


				throw e;
		
		
				}
			
			
			}	
			
			
	//Method of Verbalpassword			
			
			public void CP_OnceAndDone_VerbalPasswordMethod() throws Exception
			{
			try
			{
				utility.enter_Text(AddnlComment_OnceDone,reader.getMapData(CommonVariable.AddnlComment_OnceDone,map));
				
				utility.click_On_Button(Submit_OnceDone);
				
				
			} catch (Exception e) {
				
				extent_Reportlogger("Execution Failed","CP_OnceAndDone_VerbalPassword", "Fail");
				excelWrite.writeInCell("CP_OnceAndDone_VerbalPassword Test Case Failed","Fail");
				ErrorLogger.logError(e.getClass().getName(),"CP_OnceAndDone_VerbalPassword", e.getMessage());
				e.printStackTrace();


				throw e;
		
		
				}
			
			
			}
			
}



	
	


