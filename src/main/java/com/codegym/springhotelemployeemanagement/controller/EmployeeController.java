package com.codegym.springhotelemployeemanagement.controller;

import com.codegym.springhotelemployeemanagement.model.Employee;
import com.codegym.springhotelemployeemanagement.model.GroupEmployee;
import com.codegym.springhotelemployeemanagement.service.EmployeeService;
import com.codegym.springhotelemployeemanagement.service.GroupEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private GroupEmployeeService groupEmployeeService;

    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("groupEmployees")
    public Iterable<GroupEmployee> getAllGroupEmployees(){
        return groupEmployeeService.getAllGroupEmployees();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees")
    public String getHomePage(@RequestParam("name") Optional<String> name, Model model){
        if(name.isPresent()) {
            if(name.isPresent()){
                List<Employee> employeeList = new ArrayList<>();
                try {
                    Optional<Employee> employee = employeeService.getEmployeeById(Long.valueOf(name.get()));
                    if(employee.isPresent()){
                        employeeList.add(employee.get());
                        model.addAttribute("employees", employeeList);
                    }
                }catch (Exception e){
                    Optional<List<Employee>> employees = employeeService.getListEmployeeByName(name.get());
                    if(employees.isPresent()){
                        model.addAttribute("employees", employees.get());
                    }
                }
            }
        }
        return "list";
    }

    @GetMapping("/create-employee")
    public String getCreationPage(Model model){
        Optional<Long> lastestId = employeeService.getTheLastestId();
        Employee employee = new Employee();
        if(lastestId.isPresent()){
            employee.setId(lastestId.get());
        }
        model.addAttribute("employee", employee);
        return "create";
    }

    @PostMapping("/create-employee")
    public String createEmployee(@Valid @ModelAttribute("employee") Employee employee, Model model, BindingResult result){
        employeeService.saveEmployee(employee);
        model.addAttribute("message", "add successfully");
        return "create";
    }

    @GetMapping("/edit-employee/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if(employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "update";

        }else {
            return "error.404";
        }
    }

    @PostMapping("/edit-employee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.saveEmployee(employee);
        model.addAttribute("messages", "update successful");
        return "update";
    }

    @GetMapping("/delete-employee/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if(employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "delete";

        }else {
            return "error.404";
        }
    }

    @PostMapping("/delete-employee")
    public String deleteCustomer(@ModelAttribute("employee") Employee employee){
        employeeService.removeEmployeeById(employee.getId());
        return "redirect:employees";
    }
}
