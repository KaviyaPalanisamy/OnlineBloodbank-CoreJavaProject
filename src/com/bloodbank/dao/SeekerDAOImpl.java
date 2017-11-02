package com.bloodbank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bloodbank.model.Donar;
import com.bloodbank.view.BloodBankDriver;

public class SeekerDAOImpl implements SeekerDAO {

	ResultSet rs;

	public ResultSet searchDonar(Donar donar) {
		try {

			Statement st = BloodBankDriver.con.createStatement();
			String str = "select * from donardetails where state = '"
					+ donar.getState() + "' and city = '" + donar.getCity()
					+ "' and bloodgroup ='" + donar.getBloodGroup() + "'";

			ResultSet rs = st.executeQuery(str);
			return rs;
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;

	}

}
