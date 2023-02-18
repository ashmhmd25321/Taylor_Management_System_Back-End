package com.example.taylormanagement.dao;

import com.example.taylormanagement.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE productStatus LIKE %?1%", nativeQuery = true)
    List<Product> findProductByStatus(String status);
}
