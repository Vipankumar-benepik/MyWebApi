package com.webApi.MyWebApi.Repository;

import com.webApi.MyWebApi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEmployee extends JpaRepository<Employee, Long> {
}
