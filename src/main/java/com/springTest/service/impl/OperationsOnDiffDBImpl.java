package com.springTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springTest.model.db1.Employee;
import com.springTest.model.db2.Organization;
import com.springTest.repo.db1.EmployeeDao;
import com.springTest.repo.db2.OrganizationDao;
import com.springTest.service.OperationsOnDiffDB;

@Service
public class OperationsOnDiffDBImpl implements OperationsOnDiffDB{

	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private OrganizationDao orgDao;
	
	public void insertIntoDB1(Employee employee) {
		empDao.save(employee);
	}

	public void insertIntoDB2(Organization org) {
		orgDao.save(org);
	}

	public void deletefromDB1(int empId) {
		empDao.delete(empId);
	}

	public void deletefromDB2(int orgId) {
		orgDao.delete(orgId);
	}

	
	
	
}
