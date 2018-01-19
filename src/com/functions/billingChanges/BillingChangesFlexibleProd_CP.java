/*package com.functions.billingChanges;

import com.pages.BillingChanges.CallPortal.CP_BillingFlexibleProductPage;
import com.utility.BaseUtils;
import com.utility.CommonVariable;
import com.utility.Initialize_Browser;
import com.utility.WriteExcelFile;

public class BillingChangesFlexibleProd_CP extends Initialize_Browser {
	
	BaseUtils utility = new BaseUtils();
	CP_BillingFlexibleProductPage CP_BillingFlexibleProductScreen;
	
	//Payor Change Method
	public void BillingChangesFlexible_PayorChangeMethod() throws Exception 
	{

		try
		{
			CP_BillingFlexibleProductScreen = new CP_BillingFlexibleProductPage();
			
		utility.selectvalueByText_DropdownList(CP_BillingFlexibleProductScreen.CP_BillingChangeOptions,reader.getMapData(CommonVariable.CP_BillingChangeOptions,map));
		
		extent_Reportlogger(" Successfully Selected ","Billing Change Option ", "Pass");
		WriteExcelFile.writeInCell(" Billing Change Option Successfully Selected ","pass");
		
		utility.click_On_Button(CP_BillingFlexibleProductScreen.CP_ChangePayor);
		
		CP_BillingFlexibleProductScreen.CP_PolicyOwnerRadioBtn.click();
		
				
		extent_Reportlogger(" Successfully Updated ","Payor Change Details ", "Pass");
		WriteExcelFile.writeInCell(" Payor Change Details Updated Successfully ","pass");
		
		CP_BillingFlexibleProductScreen.CP_BillingSubmitVpas.click();
		
		
			
		
			
					
			
			
	} catch (Exception e) {
	

		throw e;
		
		
	}
}
	
	
	
}

		*/