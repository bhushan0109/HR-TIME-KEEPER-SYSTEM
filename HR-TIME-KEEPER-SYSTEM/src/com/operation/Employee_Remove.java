package com.operation;

import java.util.HashSet;
import java.util.Set;

import com.factory.ServiceFactory;


public class Employee_Remove {
	public void removeFile(Integer employ_id) throws Exception {
		Set<Integer> eids = new HashSet<>();
		eids.add(employ_id);
		boolean delete = ServiceFactory.getIEmployeeServiceInstance().delete(eids);
		if (delete == true) {
			System.out.println("user delete succesfully");
		} else {
			System.out.println("user not deleted");
		}
	}
}
