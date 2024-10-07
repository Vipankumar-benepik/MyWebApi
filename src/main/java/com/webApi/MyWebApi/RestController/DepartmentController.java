package com.webApi.MyWebApi.RestController;

import com.webApi.MyWebApi.Entity.Department;
import com.webApi.MyWebApi.Services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/getdata")
    public ResponseEntity<List<Department>> getAll(){
        List<Department> departments = departmentService.findAll();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Department>> getById(@PathVariable Long id){
        Optional<Department> department = departmentService.findById(id);
        return ResponseEntity.ok(department);
    }

    @PostMapping("/setdata")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department createDepartment = departmentService.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
