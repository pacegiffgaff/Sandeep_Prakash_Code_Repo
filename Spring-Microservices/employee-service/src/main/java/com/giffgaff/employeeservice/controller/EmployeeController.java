package com.giffgaff.employeeservice.controller;

import com.giffgaff.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    private static Map<String, List<Employee>> employeeDB = new HashMap<String, List<Employee>>();

    static {
        employeeDB = new HashMap<String, List<Employee>>();

        List<Employee> lst = new ArrayList<Employee>();
        Employee std = new Employee("Sandeep", "IT");
        lst.add(std);
        std = new Employee("Lokesh", "HR");
        lst.add(std);

        employeeDB.put("abccompany", lst);

        lst = new ArrayList<Employee>();
        std = new Employee("Prakash", "SALES");
        lst.add(std);
        std = new Employee("Sukesh", "IT");
        lst.add(std);

        employeeDB.put("xyzcompany", lst);

    }

    @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
    public List<Employee> getStudents(@PathVariable String employeeName) {
        System.out.println("Getting Employee details for " + employeeName);

        List<Employee> employeeList = employeeDB.get(employeeName);
        if (employeeList == null) {
            employeeList = new ArrayList<Employee>();
            Employee std = new Employee("Not Found", "N/A");
            employeeList.add(std);
        }
        return employeeList;
    }
}
