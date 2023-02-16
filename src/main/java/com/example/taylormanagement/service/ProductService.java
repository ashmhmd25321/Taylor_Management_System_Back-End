package com.example.taylormanagement.service;

import com.example.taylormanagement.dao.ProductDAO;
import com.example.taylormanagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product addNewProduct(Product product) {
        Product p = productDAO.save(product);
        return p;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productDAO.findAll();
    }

    public void deleteProductDetails(Integer productId) {
        productDAO.deleteById(productId);
    }

    public Product getProductDetailsById(Integer productId) {
        return productDAO.findById(productId).get();
    }
}
