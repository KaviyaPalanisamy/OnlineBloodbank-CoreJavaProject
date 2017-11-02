package com.bloodbank.controller;

import java.sql.ResultSet;

import com.bloodbank.model.Donar;
import com.bloodbank.dao.SeekerDAO;
import com.bloodbank.dao.SeekerDAOImpl;

public class SeekerController {

	SeekerDAO seekerdaoimpl = new SeekerDAOImpl();

	public ResultSet searchDonar(Donar donar) {
		return seekerdaoimpl.searchDonar(donar);

	}

}
