package com.example.taylormanagement.service;

import com.example.taylormanagement.dao.ProductDAO;
import com.example.taylormanagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product addNewProduct(Product product) {
        Product p = productDAO.save(product);
        return p;
    }

    public List<Product> getAllProducts(int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 8);
        if (searchKey.equals("")) {
            return (List<Product>) productDAO.findAll(pageable);
        } else {
            return productDAO.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
                    searchKey, searchKey, pageable
            );
        }

    }

    public void deleteProductDetails(Integer productId) {
        productDAO.deleteById(productId);
    }

    public Product getProductDetailsById(Integer productId) {
        return productDAO.findById(productId).get();
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
        if (isSingleProductCheckout) {
            List<Product> list = new ArrayList<>();
            Product product = productDAO.findById(productId).get();
            list.add(product);
            return list;
        } else {

        }

        return new ArrayList<>();
    }
}
