package com.factory;


import java.sql.Connection;

import com.dao.IEmployeeDAO;
import com.dao.impl.EmployeeDAOImpl;

/**
 * DAOFactory class returns an IDAO, which does not specify IDAOImpl class.
 */
public class DAOFactory {
	public static IEmployeeDAO getIEmployeeInstance(Connection conn) {
		return new EmployeeDAOImpl(conn);
	}

}
