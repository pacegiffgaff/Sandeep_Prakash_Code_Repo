package com.giffgaff.orgservice.controller;

import com.giffgaff.orgservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrganizationController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/org/{companyName}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String companyName)
    {
        return employeeService.getEmployees(companyName);
    }


}
