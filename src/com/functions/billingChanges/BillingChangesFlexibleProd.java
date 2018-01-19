package com.functions.billingChanges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pages.AddressChangeScreens.VPAS_PopUpPage;
import com.pages.BillingChanges.PerformTransactionPage;
import com.utility.BaseUtils;
import com.utility.Initialize_Browser;



/*
//Class is calling the function made in Billing_fixed pages
*/
public class BillingChangesFlexibleProd extends Initialize_Browser {
	
	public BillingChangesFlexibleProd(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	PerformTransactionPage performTransaction;
	BaseUtils utility = new BaseUtils(driver);
	VPAS_PopUpPage  vPAS_PopUpPage;

	//Method for status change scenarios
	
	public void modifyBillChanges(WebElement value,String text) throws Exception {
		
		performTransaction = new PerformTransactionPage(driver);
		vPAS_PopUpPage= new VPAS_PopUpPage(driver);
		////Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		utility.selectvalueByText_DropdownList(value,text);
		
		//Thread.sleep(7000);
		////Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		//This method will check the input(text) from user and it will select the respective method from the perform transaction pages
		
		if (text.equalsIgnoreCase("Payor Details")) {
			performTransaction.modify_payorChange();
			
		}else if (text.equalsIgnoreCase("Bill To Date")) {
			performTransaction.modifyBill_ToDate();
			
		} else if (text.equalsIgnoreCase("Day Of Month")) {
			performTransaction.modifyDate_OfMonth();
			
		}else if (text.equalsIgnoreCase("Manual Bill")) {
			performTransaction.modifyManual_Bill();
			
		}else if (text.equalsIgnoreCase("Loan Bill")) {
			performTransaction.modifyLoan_Bill();
			
		}else if (text.equalsIgnoreCase("Planned Premium Update")) {
			performTransaction.modify_PlannedPremium();

		} 		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		////Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		utility.click_On_Button(performTransaction.doneChanges);
		////Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		vPAS_PopUpPage.vpas_Submit();
	}

	
	public void modifyBillingelections(WebElement value,String text) throws Exception {
		
		performTransaction = new PerformTransactionPage(driver);
		vPAS_PopUpPage= new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		utility.selectvalueByText_DropdownList(value,text);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		//method calling the billing elections method from perform transaction page
		performTransaction.modifyBilling_Elections();
		
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		vPAS_PopUpPage.vpas_Submit();
	}
	

	public void modifyBilling_EFTToMail(WebElement value,String text) throws Exception {
		
		performTransaction = new PerformTransactionPage(driver);
		vPAS_PopUpPage= new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		utility.selectvalueByText_DropdownList(value,text);
		Thread.sleep(7000);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		//method calling the EFT to Mail method from perform transaction page
		performTransaction.modifyBillingChange_EFTToMail();
		
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(15, TimeUnit.SECONDS));
	
		vPAS_PopUpPage.vpas_Submit();
	}
	
	public void modifyBilling_MailToEFT(WebElement value,String text) throws Exception {
		
		performTransaction = new PerformTransactionPage(driver);
		vPAS_PopUpPage= new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		utility.selectvalueByText_DropdownList(value,text);
		Thread.sleep(7000);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		//method calling the Mail To EFT method from perform transaction page
		performTransaction.modifyBillingChange_MailToEFT();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		//System.out.println("befr done");
		utility.click_On_Button(performTransaction.doneChanges);
		
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		vPAS_PopUpPage.vpas_Submit();
	}
	
	public void modifyBillingCancel(WebElement value,String text) throws Exception {
		
		performTransaction = new PerformTransactionPage(driver);
		vPAS_PopUpPage= new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		utility.selectvalueByText_DropdownList(value,text);
		
		Thread.sleep(7000);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		performTransaction.modify_billingToCancel();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		utility.click_On_Button(performTransaction.doneChanges);
		
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		vPAS_PopUpPage.vpas_Submit();
	}
	
	public void modifyBillingSuspend(WebElement value,String text) throws Exception {
		
		performTransaction = new PerformTransactionPage(driver);
		vPAS_PopUpPage= new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		utility.selectvalueByText_DropdownList(value,text);
		
		Thread.sleep(7000);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		performTransaction.modify_billingToSuspend();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		utility.click_On_Button(performTransaction.doneChanges);
		
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		vPAS_PopUpPage.vpas_Submit();
	}
	
	public void modifyBillingResume(WebElement value,String text) throws Exception {
		
		performTransaction = new PerformTransactionPage(driver);
		vPAS_PopUpPage= new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		
		utility.selectvalueByText_DropdownList(value,text);
		
		Thread.sleep(7000);
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		performTransaction.modify_CancelToResume();
		/*driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");*/
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		System.out.println("befr done");
		utility.click_On_Button(performTransaction.doneChanges);
		
		//Sleeper.SYSTEM_//Sleeper.sleep(new Duration(5, TimeUnit.SECONDS));
		vPAS_PopUpPage.vpas_Submit();
	}
	
}
