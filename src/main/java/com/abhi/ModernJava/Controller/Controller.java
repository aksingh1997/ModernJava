package com.abhi.ModernJava.Controller;

import com.abhi.ModernJava.Service.JavaCoreService;
import com.abhi.ModernJava.model.Employee;
import com.abhi.ModernJava.model.EmployeeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    JavaCoreService service;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }

    @GetMapping("/streams/employee")
    public void streams() throws Exception {
        EmployeeBuilder.addEmployee(new Employee(1, "Abhi", 500));
        EmployeeBuilder.addEmployee(new Employee(2, "Shashank", 1000));
        EmployeeBuilder.addEmployee(new Employee(3, "Abhijeet", 1500));
        EmployeeBuilder.addEmployee(new Employee(4, "Abhi", 1200));
        EmployeeBuilder.addEmployee(null);

        EmployeeBuilder.getEmployeeList().stream().filter(Objects::nonNull).sorted().forEach(System.out::println);
        System.out.println("Incrementing salary -----------");
        EmployeeBuilder.incrementSalary(Arrays.asList(1, 2), 250);
        EmployeeBuilder.incrementSalaryByName("Abhi");
        EmployeeBuilder.getEmployeeList().stream().filter(Objects::nonNull).sorted().forEach(System.out::println);
    }

    @GetMapping("/stream/maths")
    public void mathOperations() {
        int arr[] = {}
    }

}
