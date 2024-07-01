package com.abhi.ModernJava.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeBuilder {
    @Getter
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public static void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public static Optional<Employee> getEmployeeById(int id) {
        return employeeList.stream().filter(x -> x.getId() == id).findAny();
    }

    public static void incrementSalary(List<Integer> ids, int increment) {
        ids.stream().map(EmployeeBuilder::getEmployeeById).forEach(x -> x.ifPresent(y -> y.increaseSalary(increment)));
        //employeeList.stream().filter(Objects::nonNull).filter(employee -> ids.contains(employee.getId())).forEach();
    }

    public static void printAllEmployee() {
        employeeList.forEach(System.out::println);
    }

    public static  List<Employee> getEmployeesByName(String name) {
        return  employeeList.stream().filter(Objects::nonNull).filter(x -> x.name.equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public static void incrementSalaryByName(String name) {
        incrementSalary(employeeList.stream().filter(Objects::nonNull).filter(x -> x.getName().equalsIgnoreCase(name))
                .map(Employee::getId).collect(Collectors.toList()), 200);
    }
}
