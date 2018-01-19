package com.functions.billingChanges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.AddressChangeScreens.VPAS_PopUpPage;
import com.pages.BillingChanges.FixedPerformTransactionPage;
import com.utility.BaseUtils;
import com.utility.Initialize_Browser;




	/*
	//Class is calling the function made in Billing_fixed pages
	*/

	public class BillingChangesFixedProd extends Initialize_Browser {
		
		public BillingChangesFixedProd(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);

		}

	FixedPerformTransactionPage fixedperformTransaction;
	BaseUtils utility = new BaseUtils(driver);
	VPAS_PopUpPage  vPASPopUpPage;
	
	
	
	
	//Method for status change scenarios
	public void modify_billing_statusChanges(String status) throws Exception {

		fixedperformTransaction = new FixedPerformTransactionPage(driver);
		  vPASPopUpPage =new VPAS_PopUpPage(driver);
		////Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		//passing the status as a parameter and calling the biiling cancel function from billing fixed scenario pages
		fixedperformTransaction.modify_BillingToCancel(status);

		vPASPopUpPage.vpas_Submit();
	}

	public void modify_billingAhead() throws Exception {

		fixedperformTransaction = new FixedPerformTransactionPage(driver);
		  vPASPopUpPage =new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		//calling the function bill ahead from billing fixed pages
		fixedperformTransaction.modify_BillAhead();

		vPASPopUpPage.vpas_Submit();
	}

	public void modify_billingRebill() throws Exception {

		fixedperformTransaction = new FixedPerformTransactionPage(driver);
		  vPASPopUpPage =new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		//calling the function ReBill from billing fixed pages
		fixedperformTransaction.modify_ReBill();

		vPASPopUpPage.vpas_Submit();
	}

	public void modify_billingMailToEft() throws Exception {

		fixedperformTransaction = new FixedPerformTransactionPage(driver);
		vPASPopUpPage =new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		//calling the function Mail to EFT from billing fixed pages
		fixedperformTransaction.modify_MailToEFT();

		vPASPopUpPage.vpas_Submit();
	}
	
	
	public void modify_billingEftToMail() throws Exception {

		fixedperformTransaction = new FixedPerformTransactionPage(driver);
		vPASPopUpPage =new VPAS_PopUpPage(driver);
		//Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		//calling the function EFT to Mail from billing fixed pages
		fixedperformTransaction.modify_EftToMail();

		vPASPopUpPage.vpas_Submit();
	}
	
	

}
