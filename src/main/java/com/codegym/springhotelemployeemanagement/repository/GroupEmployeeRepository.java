package com.codegym.springhotelemployeemanagement.repository;

import com.codegym.springhotelemployeemanagement.model.GroupEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupEmployeeRepository extends CrudRepository<GroupEmployee, Integer> {
}
