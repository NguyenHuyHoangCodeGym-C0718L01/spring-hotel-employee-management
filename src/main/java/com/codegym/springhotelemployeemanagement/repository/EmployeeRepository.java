package com.codegym.springhotelemployeemanagement.repository;

import com.codegym.springhotelemployeemanagement.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("Select Max(e.id) From Employee e")
    Optional<Long> getLastestId();

    @Query("Select e from Employee e where e.id=?1")
    Optional<Employee> getEmployeeById(Long id);

    @Query("Select e from Employee e where e.name=?1")
    Optional<List<Employee>> getListEmployee(String name);
}
