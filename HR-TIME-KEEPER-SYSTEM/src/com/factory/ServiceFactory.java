package com.factory;

import com.dao.service.IEmployeeService;
import com.dao.service.impl.EmployeeServiceImpl;

/**
 * ServiceFactory class returns an IService, which does not specify IServiceImpl
 * class.
 */
public class ServiceFactory {
	public static IEmployeeService getIEmployeeServiceInstance() {
		return new EmployeeServiceImpl();
	}

}
