package com.bloodbank.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bloodbank.dao.DonarDAO;
import com.bloodbank.dao.DonarDAOImpl;
import com.bloodbank.model.Donar;

public class DonarController {

	ResultSet rs;

	DonarDAO donardaoimpl = new DonarDAOImpl();

	public int addDonar(Donar donar) {
		int result = donardaoimpl.addDonar(donar);
		return result;
	}

	public int displayDonarId(String name) {
		int result = donardaoimpl.displayDonarId(name);
		return result;
	}

	public void modifyDonar(Donar donar) {
		donardaoimpl.modifyDonar(donar);
	}

	public boolean checkLogin(String emailId, String password) {
		boolean result = donardaoimpl.checkLogin(emailId, password);
		return result;

	}

	public ResultSet displayDonarProfile(String emailId) throws SQLException {
		return donardaoimpl.displayDonarProfile(emailId);

	}

}
