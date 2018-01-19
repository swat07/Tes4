package com.testScript;

import org.testng.annotations.Test;

import com.functions.common_CP.Common_Functions;
import com.pages.AddressChangeScreens.callPortal.CP_ChangeAccountAddress;
import com.pages.AddressChangeScreens.callPortal.CP_ChangePhone;
import com.pages.commonScreens_CP.Action_Summary;
import com.utility.ErrorLogger;
import com.utility.Test_BaseClass;
import com.utility.WriteExcelFile;

public class Test_AddressChange_CP extends Test_BaseClass{
	
	CP_ChangeAccountAddress cp_ChangeAccountAddress;
	Common_Functions common_Functions;
	CP_ChangePhone changePhn;
	Action_Summary action_Summary;
	
	
	@Test(priority = 0)
	public void AddressChange_CP() throws Exception {
		
		try {
			cp_ChangeAccountAddress = new CP_ChangeAccountAddress(driver);
			common_Functions = new Common_Functions(driver);
			changePhn = new CP_ChangePhone(driver);
			action_Summary = new Action_Summary(driver);

			// Change Account Address
			common_Functions.callPortal_ActionLaunch();
			cp_ChangeAccountAddress
					.selectPeople_updateAddressDetails("accountAddress");
			cp_ChangeAccountAddress.change_AccountAddress();
			changePhn.callPortalAddressChange_EndInteraction("accountAddress");
			// Change Phone
			action_Summary.action_LinkClick();
			action_Summary.backTrackexpandAction_SelectCategory();
			action_Summary.launch_ButtonClick();
			driver.switchTo().frame("cpmTabbedNavigation-DIVFrame");
			cp_ChangeAccountAddress
					.selectPeople_updateAddressDetails("changePhone");
			changePhn.changePhone_CP();
			changePhn.callPortalAddressChange_EndInteraction("changePhone");

		} catch (Exception e) {
			extent_Reportlogger("Test Step Execution failed",
					"AddressChange_CP", "Fail");
			excelWrite.writeInCell(
					"AddressChange_CP Test Step Execution Unsuccessfull",
					"Fail");
			ErrorLogger.logError(e.getClass().getName(), "AddressChange_CP",
					e.getMessage());
			throw e;

		}
	}
	

}
