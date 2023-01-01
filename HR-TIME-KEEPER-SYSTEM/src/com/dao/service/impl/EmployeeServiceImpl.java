package com.dao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dao.dbc.DatabaseConnection;
import com.dao.service.IEmployeeService;
import com.factory.DAOFactory;
import com.vo.Employee;
import com.vo.TimeSheetTable;
import com.vo.Users;

/**
 * This impl class instantiates a DB connection, named dbc, and instructs
 * Service to operate.
 */
public class EmployeeServiceImpl implements IEmployeeService {

	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Employee vo) throws Exception {
		try {
			if (DAOFactory.getIEmployeeInstance(dbc.getConnection()).findByEid(vo.getEid()) == null) {
				return DAOFactory.getIEmployeeInstance(dbc.getConnection()).doCreate(vo);
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return false;
	}

	@Override
	public boolean insertTimeSheetTable(TimeSheetTable vo) throws Exception {
		try {
			if (DAOFactory.getIEmployeeInstance(dbc.getConnection()).doCreateTimeSheetTable(vo)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return false;
	}

	@Override
	public boolean update(Employee vo) throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return false;
	}

	@Override
	public boolean resetPassword(Users vo) throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).resetPassword(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return false;
	}

	@Override
	public boolean delete(Set<Integer> eids) throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).doRemoveBatch(eids);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return false;
	}

	@Override
	public Employee findByEid(Integer eid) throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findByEid(eid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return null;
	}

	@Override
	public String findUserRoleByEmaild(String emailId) throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findUserRoleByEmaild(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return "";
	}

	@Override
	public List<Employee> listAllEmployees() throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return null;
	}

	@Override
	public Map<String, Object> fuzzyQuery(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("findAllSplit", DAOFactory.getIEmployeeInstance(dbc.getConnection()).findAllSplit(currentPage,
					lineSize, column, keyWord));
			map.put("getAllCount", DAOFactory.getIEmployeeInstance(dbc.getConnection()).getAllCount(column, keyWord));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return null;
	}

	@Override
	public Employee findUserByEmaildAndPassword(String emailId, String password) {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findUserByEmaildAndPassword(emailId, password);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return null;
	}

	@Override
	public List<TimeSheetTable> findListTimeSheetTableByEid(int eid) throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findListTimeSheetTableByEid(eid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return null;
	}

	@Override
	public List<TimeSheetTable> findAllListTimeSheetTableByEid() {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).findAllListTimeSheetTableByEid();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return null;
	}

	@Override
	public boolean approvedTimeSheet(int id) throws Exception {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).approvedTimeSheet(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return false;
	}

	@Override
	public boolean approvedLeave(int id) {
		try {
			return DAOFactory.getIEmployeeInstance(dbc.getConnection()).approvedLeave(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection();
		}
		return false;
	}

}
