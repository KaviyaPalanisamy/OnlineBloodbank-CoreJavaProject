package com.bloodbank.dao;

import java.sql.ResultSet;

import com.bloodbank.model.BloodBank;

public interface BloodBankDAO {

	public boolean checkAdminLogin(String userName, String password);

	public int addLifeSaver(BloodBank bloodbank);

	public int deleteLifeSaver(int id);

	public ResultSet searchLifeSaveContactPerson(String state, String city);

	public ResultSet viewDonarDetails();

	public ResultSet viewLifeSaverDetails();

}
