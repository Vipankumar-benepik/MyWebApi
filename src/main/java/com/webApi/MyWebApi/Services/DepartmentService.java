package com.webApi.MyWebApi.Services;

import com.webApi.MyWebApi.Entity.Department;
import com.webApi.MyWebApi.Repository.GenericDepratment;
import com.webApi.MyWebApi.Repository.GenericEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private GenericDepratment departmentRepository;

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long id){
        return departmentRepository.findById(id);
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public void delete(Long id){
        departmentRepository.deleteById(id);
    }
}
