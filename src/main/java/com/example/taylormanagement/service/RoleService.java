package com.example.taylormanagement.service;

import com.example.taylormanagement.dao.RoleDAO;
import com.example.taylormanagement.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public Role createNewRole(Role role) {
        return roleDAO.save(role);
    }
}
