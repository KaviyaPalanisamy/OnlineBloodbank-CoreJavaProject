package com.bloodbank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.model.BloodBank;
import com.bloodbank.view.BloodBankDriver;

public class BloodBankDAOImpl implements BloodBankDAO {

	ResultSet rs;

	public int addLifeSaver(BloodBank bloodbank) {
		int rs = 0;

		try {

			Statement st = BloodBankDriver.con.createStatement();
			String query = ("insert into BloodBankDetail values (Bloodbank_pid.nextval,'"
					+ bloodbank.getName()
					+ "','"
					+ bloodbank.getAddress()
					+ "',"
					+ bloodbank.getPincode()
					+ ",'"
					+ bloodbank.getState()
					+ "','"
					+ bloodbank.getCity()
					+ "','" + bloodbank.getPhoneNumber() + "')");

			rs = st.executeUpdate(query);

		} catch (SQLException e) {
			System.out.println(e);
		}
		return rs;

	}

	public int deleteLifeSaver(int id) {
		int rs = 0;
		try {
			Statement st = BloodBankDriver.con.createStatement();
			String query = ("delete from BloodBankDetail where personid =" + id + " ");
			rs = st.executeUpdate(query);
		} catch (SQLException e) {

		}
		return rs;
	}

	public ResultSet searchLifeSaveContactPerson(String state, String city) {
		ResultSet rs = null;
		try {

			Statement st = BloodBankDriver.con.createStatement();
			rs = st.executeQuery("select * from BloodBankDetail where state = '"
					+ state + "' and city = '" + city + "'");

		} catch (SQLException e) {
			System.out.println(e);
		}

		return rs;
	}

	public boolean checkAdminLogin(String userName, String password) {
		try {

			Statement st = BloodBankDriver.con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from Adminlogdetail where username='"
							+ userName + "' and password='" + password + "'");

			while (rs.next()) {
				return true;

			}

		} catch (SQLException e) {

		}

		return false;
	}

	public ResultSet viewDonarDetails() {

		try {

			Statement st = BloodBankDriver.con.createStatement();
			String str = ("select * from donardetails order by donarId");
			rs = st.executeQuery(str);

		} catch (SQLException e) {
			System.out.println(e);
		}

		return rs;

	}

	public ResultSet viewLifeSaverDetails() {

		try {

			Statement st = BloodBankDriver.con.createStatement();
			String str = ("select * from BloodBankDetail order by personId");
			rs = st.executeQuery(str);

		} catch (SQLException e) {
			System.out.println(e);
		}

		return rs;

	}

}
