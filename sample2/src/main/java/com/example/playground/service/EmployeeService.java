package com.example.playground.service;

import com.example.playground.model.Employee;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeService {

    private Set<Employee> employees = Set.of(
            Employee.builder().id(1L).firstName("Ankit").build(),
            Employee.builder().id(2L).firstName("Barbara").build(),
            Employee.builder().id(3L).firstName("Michael").build(),
            Employee.builder().id(4L).firstName("Tarun").build(),
            Employee.builder().id(5L).firstName("Jessica").build());

    public List<Employee> findEmployeesByFirstName(String firstName) {

        if (firstName == null || "".equalsIgnoreCase(firstName)) {
            return Collections.emptyList();
        }

        return employees.stream()
                .filter(employee -> firstName.equalsIgnoreCase(employee.getFirstName()))
                .collect(Collectors.toList());
    }
}
