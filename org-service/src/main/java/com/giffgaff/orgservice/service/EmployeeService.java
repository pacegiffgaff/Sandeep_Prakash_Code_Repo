package com.giffgaff.orgservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public String getEmployees(String companyName) {
        String response = restTemplate.exchange("http://employee-service/employee/{companyName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, companyName).getBody();
        return "Company Name -  " + companyName + " \n Employee Details " + response;
    }

    public String reliable(String companyName) {
        return "Employees can't be retrieved"+companyName;
    }

}
