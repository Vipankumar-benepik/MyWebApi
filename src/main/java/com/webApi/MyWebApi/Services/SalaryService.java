package com.webApi.MyWebApi.Services;

import com.webApi.MyWebApi.Entity.Salary;
import com.webApi.MyWebApi.Repository.GenericSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {
    @Autowired
    private GenericSalary salaryReposiory;

    public Optional<Salary> findById(Long id){
        return salaryReposiory.findById(id);
    }

    public List<Salary> findAll(){
        return salaryReposiory.findAll();
    }

    public Salary save(Salary salary){
        return salaryReposiory.save(salary);
    }

    public void delete(Long id){
        salaryReposiory.deleteById(id);
    }
}
