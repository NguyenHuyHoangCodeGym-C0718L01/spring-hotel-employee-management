package com.codegym.springhotelemployeemanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="group_employee")
public class GroupEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_name")
    private String name;

    @OneToMany(mappedBy = "groupEmployee")
    private List<Employee> employeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
