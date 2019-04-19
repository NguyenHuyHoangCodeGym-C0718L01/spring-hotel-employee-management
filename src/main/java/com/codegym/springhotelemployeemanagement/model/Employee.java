package com.codegym.springhotelemployeemanagement.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name="birthday")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;

    @Column(name="genre")
    private String genre;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name="identity")
    private String identity;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "group_employee_id")
    private GroupEmployee groupEmployee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GroupEmployee getGroupEmployee() {
        return groupEmployee;
    }

    public void setGroupEmployee(GroupEmployee groupEmployee) {
        this.groupEmployee = groupEmployee;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        String number = employee.getPhoneNumber();
        String identity = employee.getIdentity();
        String name = employee.getName();
        Date birthday = employee.getBirthday();
        String genre = employee.getGenre();
        String email = employee.getEmail();
        String address = employee.getAddress();

        ValidationUtils.rejectIfEmpty(errors, name, "Empty field");
        ValidationUtils.rejectIfEmpty(errors, birthday.toString(), "Empty field");
        ValidationUtils.rejectIfEmpty(errors, genre, "Empty field");
        ValidationUtils.rejectIfEmpty(errors, number, "Empty field");
        ValidationUtils.rejectIfEmpty(errors, identity, "Empty field");
        ValidationUtils.rejectIfEmpty(errors, email, "Empty field");
        ValidationUtils.rejectIfEmpty(errors, address, "Empty field");

        //ko đủ chiều dài
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber", "number.length");
        }

        if(identity.length()!=9){
            errors.rejectValue("identity", "number.length");
        }
        //bắt đầu bằng 0
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "number.zero");
        }
        if (!identity.startsWith("0")){
            errors.rejectValue("identity", "number.zero");
        }
        //kiểu số
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "number.type");
        }
        if (!identity.matches("(^$|[0-9]*$)")){
            errors.rejectValue("identity", "number.type");
        }
    }
}
