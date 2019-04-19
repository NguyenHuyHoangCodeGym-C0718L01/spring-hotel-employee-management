package com.codegym.springhotelemployeemanagement.service;

import com.codegym.springhotelemployeemanagement.model.GroupEmployee;

import java.util.Optional;

public interface GroupEmployeeService {

    Iterable<GroupEmployee> getAllGroupEmployees();

    Optional<GroupEmployee> getGroupEmployeeById(int id);

    void saveGroupEmployee(GroupEmployee groupEmployee);

    void removeGroupEmployeeById(int id);
}
