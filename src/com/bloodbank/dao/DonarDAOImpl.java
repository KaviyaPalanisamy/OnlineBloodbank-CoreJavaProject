package com.bloodbank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.model.Donar;
import com.bloodbank.view.BloodBankDriver;

public class DonarDAOImpl implements DonarDAO {

	ResultSet rs;

	public int addDonar(Donar donar) {
		try {
			Statement st = BloodBankDriver.con.createStatement();
			String query = ("insert into donardetails values (Bloodbank_did.nextval,'"
					+ donar.getName()
					+ "','"
					+ donar.getAge()
					+ "','"
					+ donar.getWeight()
					+ "','"
					+ donar.getGender()
					+ "','"
					+ donar.getBloodGroup()
					+ "','"
					+ donar.getPhoneNumber()
					+ "','"
					+ donar.getEmailId()
					+ "','"
					+ donar.getState()
					+ "','"
					+ donar.getCity()
					+ "','"
					+ donar.getArea()
					+ "','"
					+ donar.getPassword() + "')");

			int rs = st.executeUpdate(query);
			while (rs > 0) {
				return rs;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 0;
	}

	public int displayDonarId(String name)

	{
		int result = 0;
		try {

			Statement st = BloodBankDriver.con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from donardetails where name='"
							+ name + "'");

			while (rs.next()) {

				result = rs.getInt(1);

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return result;

	}

	public boolean checkLogin(String emailId, String password) {
		try {
			Statement st = BloodBankDriver.con.createStatement();
			rs = st.executeQuery("select * from donardetails where emailId='"
					+ emailId + "' and password='" + password + "'");
			while (rs.next()) {
				return true;

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}

	public int modifyDonar(Donar donar) {

		try {

			Statement st = BloodBankDriver.con.createStatement();
			String query = "update donardetails set name='" + donar.getName()
					+ "',age='" + donar.getAge() + "',weight='"
					+ donar.getWeight() + "',gender='" + donar.getGender()
					+ "',bloodgroup='" + donar.getBloodGroup()
					+ "',phonenumber='" + donar.getPhoneNumber()
					+ "',emailid='" + donar.getEmailId() + "',state='"
					+ donar.getState() + "',city='" + donar.getCity()
					+ "',area='" + donar.getArea() + "',password='"
					+ donar.getPassword() + "' where donarId ="
					+ donar.getDonarId() + " ";
			int rs = st.executeUpdate(query);
			if (rs > 0)
				return rs;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 0;
	}

	public ResultSet displayDonarProfile(String emailId) {
		try {

			Statement st = BloodBankDriver.con.createStatement();

			String str = ("select * from donardetails where emailId = '"
					+ emailId + "'");
			rs = st.executeQuery(str);

		} catch (SQLException e) {
			System.out.println(e);
		}

		return rs;

	}
}
