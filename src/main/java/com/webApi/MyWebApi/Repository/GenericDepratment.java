package com.webApi.MyWebApi.Repository;

import com.webApi.MyWebApi.Entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericDepratment extends GenericRepository<Department, Long>{
}
