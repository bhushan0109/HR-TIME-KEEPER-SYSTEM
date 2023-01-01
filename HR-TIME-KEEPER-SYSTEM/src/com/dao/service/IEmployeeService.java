package com.dao.service;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vo.Employee;
import com.vo.TimeSheetTable;
import com.vo.Users;


public interface IEmployeeService {
    public boolean insert(Employee vo) throws Exception;
    public boolean update(Employee vo) throws Exception;
    public boolean delete(Set<Integer> eids) throws  Exception;
    public Employee findByEid(Integer eid) throws  Exception;
    public List<Employee> listAllEmployees() throws Exception;

    /**
     * fuzzyQuery calls IEmployeeDAO.findAllSplit(), returning List<Employee>
     * and calls IEmployeeDAO.getAllCount(), returning Integer.
     * @return if String="findAllSplit", Object=List<Employee>
     *     if String="getAllCount", Object=Integer
     * @throws Exception
     */
    public Map<String,Object> fuzzyQuery(Integer currentPage,Integer lineSize,String column,String keyWord)
            throws Exception;
	public Employee findUserByEmaildAndPassword(String emailId, String password);
	boolean resetPassword(Users vo) throws Exception;
	String findUserRoleByEmaild(String emailId) throws Exception;
	boolean insertTimeSheetTable(TimeSheetTable vo) throws Exception;
	List<TimeSheetTable> findListTimeSheetTableByEid(int eid) throws Exception;
	public List<TimeSheetTable> findAllListTimeSheetTableByEid();
	public boolean approvedTimeSheet(int id) throws Exception;
	public boolean approvedLeave(int id);
}
