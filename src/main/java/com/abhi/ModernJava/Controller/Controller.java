package com.abhi.ModernJava.Controller;

import com.abhi.ModernJava.Service.EmployeeService;
import com.abhi.ModernJava.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {
    @Autowired
    EmployeeService employeeService;
/* Note : Access all the apis at location - http://localhost:8080/swagger-ui/index.html*/

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @PostMapping("streams/addEmployee")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "added " + employee.toString();
    }

    @PostMapping("streams/addManyEmployee")
    public String addManyEmployee(@RequestBody List<Employee> employees) {
        employeeService.addManyEmployee(employees);
        return "added " + employees.toString();
    }

    @GetMapping("/streams/employee/all")
    public ArrayList<Employee> getAllEmployees() {
        return  employeeService.getEmployeeList();
    }

    @PutMapping("streams/employee/increment/{id}/{increment}")
    public String incrementSalary(@PathVariable int id, @PathVariable int increment) {
        employeeService.incrementSalaryById(id, increment);
        return "Salary incremented!";
    }

    @PutMapping("streams/employee/increment/{name}/{increment}")
    public String incrementSalary(@PathVariable String name, @PathVariable int increment) {
        employeeService.incrementSalaryByName(name, increment);
        return "Salary incremented!";
    }

    @GetMapping("streams/employee/stats")
    public String getStats() {
        return employeeService.getStats();
    }

    @GetMapping("/streams/employee/groupByFirstChar")
    public List<Employee> groupByFirstChar() {
        return employeeService.groupByFirstChar();
    }

    @GetMapping("/streams/employee/groupBySalary")
    public List<Employee> groupBySalary() {
        return employeeService.groupBySalary();
    }

}
