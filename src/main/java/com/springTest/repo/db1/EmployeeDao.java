package com.springTest.repo.db1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springTest.model.db1.Employee;


@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
