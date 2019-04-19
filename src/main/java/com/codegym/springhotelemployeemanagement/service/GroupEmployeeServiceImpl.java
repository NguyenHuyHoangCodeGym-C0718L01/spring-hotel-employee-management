package com.codegym.springhotelemployeemanagement.service;

import com.codegym.springhotelemployeemanagement.model.GroupEmployee;
import com.codegym.springhotelemployeemanagement.repository.GroupEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class GroupEmployeeServiceImpl implements GroupEmployeeService{

    @Autowired
    private GroupEmployeeRepository groupEmployeeRepository;

    @Override
    public Iterable<GroupEmployee> getAllGroupEmployees() {
        return groupEmployeeRepository.findAll();
    }

    @Override
    public Optional<GroupEmployee> getGroupEmployeeById(int id) {
        return groupEmployeeRepository.findById(id);
    }

    @Override
    public void saveGroupEmployee(GroupEmployee groupEmployee) {
        groupEmployeeRepository.save(groupEmployee);
    }

    @Override
    public void removeGroupEmployeeById(int id) {
        groupEmployeeRepository.deleteById(id);
    }
}
