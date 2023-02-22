package com.example.taylormanagement.dao;

import com.example.taylormanagement.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {

//    @Query(value = "SELECT * FROM product WHERE productStatus LIKE %?1%", nativeQuery = true)
    public List<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
            String key1, String key2, Pageable pageable
    );

    public List<Product> findAll(Pageable pageable);
}
