package com.springTest.service;

import com.springTest.model.db1.Employee;
import com.springTest.model.db2.Organization;

public interface OperationsOnDiffDB {

	void insertIntoDB1(Employee employee);
	void insertIntoDB2(Organization org);
	void deletefromDB1(int empId);
	void deletefromDB2(int orgId);
	
}
