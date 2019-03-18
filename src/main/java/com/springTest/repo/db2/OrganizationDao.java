package com.springTest.repo.db2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springTest.model.db2.Organization;

@Repository
public interface OrganizationDao extends CrudRepository<Organization, Integer>{

}
