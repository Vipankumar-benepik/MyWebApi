package com.webApi.MyWebApi.Services;

import com.webApi.MyWebApi.Entity.Employee;
import com.webApi.MyWebApi.Repository.GenericEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private GenericEmployee employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
