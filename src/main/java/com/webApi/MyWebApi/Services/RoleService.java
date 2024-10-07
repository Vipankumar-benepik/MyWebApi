package com.webApi.MyWebApi.Services;

import com.webApi.MyWebApi.Entity.Role;
import com.webApi.MyWebApi.Repository.GenericRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private GenericRole roleRepository;

    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public void delete(Long id){
        roleRepository.deleteById(id);
    }
}
