package com.webApi.MyWebApi.Repository;

import com.webApi.MyWebApi.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
