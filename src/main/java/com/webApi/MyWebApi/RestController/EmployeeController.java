package com.webApi.MyWebApi.RestController;

import com.webApi.MyWebApi.Entity.Employee;
import com.webApi.MyWebApi.Jwt.JwtUtils;
import com.webApi.MyWebApi.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/getdata")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Employee>> getById(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }


//    @PostMapping("/setdata")
//    public Employee createEmployee(@RequestBody Employee employee){
//        return employeeService.save(employee);
//    }

    @PostMapping("/setdata")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
//        return ResponseEntity<Employee>(createdEmployee,HttpStatus.CREATED);
//        return ResponseEntity.ok(createdEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
