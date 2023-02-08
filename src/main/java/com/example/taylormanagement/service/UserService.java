package com.example.taylormanagement.service;

import com.example.taylormanagement.dao.UserDAO;
import com.example.taylormanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User registerUser(User user){
        return userDAO.save(user);
    }
}
