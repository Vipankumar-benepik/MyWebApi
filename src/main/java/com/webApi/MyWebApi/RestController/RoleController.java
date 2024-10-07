package com.webApi.MyWebApi.RestController;

import com.webApi.MyWebApi.Entity.Role;
import com.webApi.MyWebApi.Services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/getdata")
    public ResponseEntity<List<Role>> getAll(){
        List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @PostMapping("/setdata")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role createRole = roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Role>> getById(@PathVariable Long id){
        Optional<Role> role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
