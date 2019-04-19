package com.codegym.springhotelemployeemanagement.service;

import com.codegym.springhotelemployeemanagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Iterable<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(long id);

    void saveEmployee(Employee employee);

    void removeEmployeeById(long id);

    Optional<Long> getTheLastestId();

    Optional<Employee> getEmployeeById(Long id);

    Optional<List<Employee>>getListEmployeeByName(String name);
}
