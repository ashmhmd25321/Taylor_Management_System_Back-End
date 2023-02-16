package com.example.taylormanagement.dao;

import com.example.taylormanagement.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {
}
