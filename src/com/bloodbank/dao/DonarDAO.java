package com.bloodbank.dao;

import java.sql.ResultSet;

import com.bloodbank.model.Donar;

public interface DonarDAO {

	public int addDonar(Donar donar);

	public int displayDonarId(String name);

	public int modifyDonar(Donar donar);

	public boolean checkLogin(String emailId, String password);

	public ResultSet displayDonarProfile(String emailId);

}
