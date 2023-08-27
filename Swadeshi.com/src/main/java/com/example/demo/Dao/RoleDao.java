package com.example.demo.Dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}