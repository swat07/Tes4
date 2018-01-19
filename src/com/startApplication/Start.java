package com.startApplication;

import com.manager.ControlManager;
import com.utility.ErrorLogger;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			ControlManager.controTestNG();

		} catch (Exception e) {
			e.printStackTrace();
			ErrorLogger
					.logError(e.getClass().getName(), "main", e.getMessage());
		}

	}

}
