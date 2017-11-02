package com.bloodbank.controller;

import java.sql.ResultSet;

import com.bloodbank.dao.BloodBankDAO;
import com.bloodbank.dao.BloodBankDAOImpl;
import com.bloodbank.model.BloodBank;

public class BloodBankController {

	BloodBankDAO bloodbankdaoimpl = new BloodBankDAOImpl();

	public int addLifeSaver(BloodBank bloodbank) {
		int result = bloodbankdaoimpl.addLifeSaver(bloodbank);
		return result;
	}

	public int deleteLifeSaver(int id) {
		int result = bloodbankdaoimpl.deleteLifeSaver(id);
		return result;
	}

	public ResultSet viewDonarDetails() {
		ResultSet rs = bloodbankdaoimpl.viewDonarDetails();
		return rs;
	}

	public ResultSet viewLifeSaverDetails() {
		ResultSet rs = bloodbankdaoimpl.viewLifeSaverDetails();
		return rs;
	}

	public ResultSet searchLifeSaveContactPerson(String state, String city) {
		ResultSet rs = bloodbankdaoimpl
				.searchLifeSaveContactPerson(state, city);
		return rs;
	}

	public boolean checkAdminLogin(String userName, String password) {
		boolean result = bloodbankdaoimpl.checkAdminLogin(userName, password);

		return result;

	}
}
