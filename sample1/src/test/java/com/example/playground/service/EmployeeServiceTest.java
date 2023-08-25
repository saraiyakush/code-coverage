package com.example.playground.service;

import com.example.playground.model.Employee;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    public void findEmployeesByFirstName_shouldReturnEmptyList_whenFirstNameIsEmpty() {
        String firstName = "";
        List<Employee> actualEmployees = employeeService.findEmployeesByFirstName(firstName);
        assertEquals(0, actualEmployees.size());
    }

    @Test
    public void findEmployeesByFirstName_shouldReturnEmptyList_whenNoMatchFound() {
        String firstName = "John";
        List<Employee> actualEmployees = employeeService.findEmployeesByFirstName(firstName);
        assertEquals(0, actualEmployees.size());
    }

    @Test
    public void findEmployeesByFirstName_shouldReturnMatchingEmployees_whenMatchFound() {
        String firstName = "Ankit";
        List<Employee> actualEmployees = employeeService.findEmployeesByFirstName(firstName);
        assertEquals(1, actualEmployees.size());

        firstName = "ankit";
        actualEmployees = employeeService.findEmployeesByFirstName(firstName);
        assertEquals(0, actualEmployees.size());
    }
}
