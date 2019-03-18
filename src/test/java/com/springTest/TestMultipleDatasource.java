package com.springTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.springTest.model.db1.Employee;
import com.springTest.model.db2.Organization;
import com.springTest.repo.db1.EmployeeDao;
import com.springTest.repo.db2.OrganizationDao;
import com.springTest.service.OperationsOnDiffDB;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMultipleDatasource {

	@Autowired
	 EmployeeDao empDao;
	
	@Autowired
	OperationsOnDiffDB operations;
	
	@Autowired
	 OrganizationDao orgDao;
	
	
	@Test
//	@Transactional
//	@Rollback(true)
	public void insertIntoBothDatabases() {
	
		Employee emp = new  Employee();
		emp.setId(1);
		emp.setName("Employee 1");
		
		Organization org = new Organization();
		org.setId(1);
		org.setName("Organization 1");
		
		operations.insertIntoDB1(emp);
		operations.insertIntoDB2(org);
	
		Employee empObj = empDao.findOne(emp.getId());
		Organization orgObj = orgDao.findOne(org.getId());
		
		assertEquals(empObj.getName(), emp.getName());
		assertEquals(orgObj.getName(), org.getName());
	}

}
