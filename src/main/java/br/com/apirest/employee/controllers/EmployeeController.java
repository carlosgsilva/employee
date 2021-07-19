package br.com.apirest.employee.controllers;

import br.com.apirest.employee.entities.Employee;
import br.com.apirest.employee.respositories.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =     "/api")
@Api(value = "Employees API Rest")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    @ApiOperation(value = "Returns a list of employees")
    public List<Employee> employeeList() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    @ApiOperation(value = "Return an employee")
    public Employee employeeListOne(@PathVariable(value = "id") long id) {
        return employeeRepository.findById(id);
    }

    @PostMapping("/employee")
    @ApiOperation(value = "Creat a new employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    @ApiOperation(value = "Delete an employee")
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeRepository.delete(employee);
    }

    @PutMapping("/employee")
    @ApiOperation(value = "Update an employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

}
