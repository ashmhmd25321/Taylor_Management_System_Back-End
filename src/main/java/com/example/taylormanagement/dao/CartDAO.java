package com.example.taylormanagement.dao;

import com.example.taylormanagement.entity.Cart;
import com.example.taylormanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartDAO extends CrudRepository<Cart, Integer> {
    public List<Cart> findByUser(User user);
}
