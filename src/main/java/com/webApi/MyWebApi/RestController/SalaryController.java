package com.webApi.MyWebApi.RestController;

import com.webApi.MyWebApi.Entity.Salary;
import com.webApi.MyWebApi.Services.SalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/salary")
public class SalaryController {
    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/getdata")
    public ResponseEntity<List<Salary>> getAll(){
        List<Salary> salaries = salaryService.findAll();
        return ResponseEntity.ok(salaries);
    }

    @PostMapping("/setdata")
    public ResponseEntity<Salary> createSalary(@RequestBody Salary salary){
        Salary createSalary = salaryService.save(salary);
        return ResponseEntity.status(HttpStatus.CREATED).body(salary);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Salary>> getById(@PathVariable Long id){
        Optional<Salary> salary = salaryService.findById(id);
        return ResponseEntity.ok(salary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        salaryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
