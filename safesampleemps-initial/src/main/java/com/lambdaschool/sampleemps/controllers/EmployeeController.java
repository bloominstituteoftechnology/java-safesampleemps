package com.lambdaschool.sampleemps.controllers;

import com.lambdaschool.sampleemps.models.Employee;
import com.lambdaschool.sampleemps.services.EmployeeService;
import com.lambdaschool.sampleemps.views.EmpNameCountJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees") // optional
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public ResponseEntity<?> listAllEmployees()
    {
        List<Employee> myEmployees = employeeService.findAllEmployees();
        return new ResponseEntity<>(myEmployees,
                                    HttpStatus.OK);
    }

    @GetMapping(value = "/employee/{employeeid}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable
                    long employeeid)
    {
        Employee e = employeeService.findEmployeeById(employeeid);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping(value = "/employeename/{subname}")
    public ResponseEntity<?> listEmployeesWithName(
            @PathVariable
                    String subname)
    {
        List<Employee> myEmployees = employeeService.findEmployeeNameContaining(subname);
        return new ResponseEntity<>(myEmployees,
                                    HttpStatus.OK);
    }

    @GetMapping(value = "/employeeemail/{subemail}")
    public ResponseEntity<?> listEmployeesWithEmail(
            @PathVariable
                    String subemail)
    {
        List<Employee> myEmployees = employeeService.findEmployeeEmailContaining(subemail);
        return new ResponseEntity<>(myEmployees,
                                    HttpStatus.OK);
    }

    @GetMapping(value = "/job/counts")
    public ResponseEntity<?> getEmpJobCounts()
    {
        List<EmpNameCountJobs> myEmployees = employeeService.getEmpNameCountJobs();
        return new ResponseEntity<>(myEmployees,
                                    HttpStatus.OK);
    }

    @PostMapping(value = "/employee",
            consumes = {"application/json"})
    public ResponseEntity<?> addNewEmployee(
            @Valid
            @RequestBody
                    Employee newEmployee)
    {
        // ids are not recognized by the Post method
        newEmployee.setEmployeeid(0);
        newEmployee = employeeService.save(newEmployee);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newEmployeeURI = ServletUriComponentsBuilder.fromCurrentRequest() // get the URI for this request
                .path("/{employeeid}") // add to it a path variable
                .buildAndExpand(newEmployee.getEmployeeid()) // populate that path variable with the newly created restaurant id
                .toUri(); // convert that work into a human readable URI
        responseHeaders.setLocation(newEmployeeURI); // in the header, set the location location to that URI
        return new ResponseEntity<>(null,
                                    responseHeaders,
                                    HttpStatus.CREATED);
    }

    @PutMapping(value = "/employee/{employeeid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateFullEmployee(
            @Valid // verifies the give employee record is valid
            @RequestBody
                    Employee updateEmployee, // the Jackson dependency converts from JSON to Java Objects
            @PathVariable
                    long employeeid) // the primary key of the employee record to replace
    {
        updateEmployee.setEmployeeid(employeeid); // set the primary key to the one from the path variable
        employeeService.save(updateEmployee);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/employee/{employeeid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateEmployee(
            @RequestBody
                    Employee updateEmployee,
            @PathVariable
                    long employeeid)
    {
        employeeService.update(updateEmployee,
                               employeeid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/{employeeid}")
    public ResponseEntity<?> deleteEmployeeById(
            @PathVariable
                    long employeeid)
    {
        employeeService.delete(employeeid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}