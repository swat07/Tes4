package com.manager;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.utility.ErrorLogger;
import com.utility.RuntimeXML;



public class TestNGTrigger {

	public TestNGTrigger() throws IOException {

		try {
			// Create object of TestNG Class
			TestNG runner = new TestNG();

			// Create a list of String
			List<String> suitefiles = new ArrayList<String>();

			// Add xml file which you have to execute
			// suitefiles.add("miscellaneous\\hotel.xml");

			suitefiles.add(RuntimeXML.xlFile);
			
			
			System.out.println("create report");

			// now set xml file for execution
			runner.setTestSuites(suitefiles);

			// finally execute the runner using run method
			runner.run();
		} catch (Exception e) {
			e.printStackTrace();
			ErrorLogger.logError(e.getClass().getName(), "TestNGTrigger",
					e.getMessage());
		}

	}
}

