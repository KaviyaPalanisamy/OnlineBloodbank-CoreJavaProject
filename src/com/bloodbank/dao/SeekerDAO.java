package com.bloodbank.dao;

import java.sql.ResultSet;

import com.bloodbank.model.Donar;

public interface SeekerDAO {

	public ResultSet searchDonar(Donar donar);

}
