package com.codegym.springhotelemployeemanagement.service;

import com.codegym.springhotelemployeemanagement.model.Employee;
import com.codegym.springhotelemployeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void removeEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Optional<Long> getTheLastestId() {
        return employeeRepository.getLastestId();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public Optional<List<Employee>> getListEmployeeByName(String name) {
        return employeeRepository.getListEmployee(name);
    }
}
