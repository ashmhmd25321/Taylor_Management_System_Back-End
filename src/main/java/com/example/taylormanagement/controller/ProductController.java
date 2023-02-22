package com.example.taylormanagement.controller;

import com.example.taylormanagement.entity.ImageModel;
import com.example.taylormanagement.entity.Product;
import com.example.taylormanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = {"/addProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile") MultipartFile[] file) {

        try {
           Set<ImageModel> images = uploadImage(file);
           product.setProductImages(images);
           return productService.addNewProduct(product);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        for (MultipartFile file: multipartFiles) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );

            imageModels.add(imageModel);

        }

        return imageModels;

    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                        @RequestParam(defaultValue = "") String searchKey) {
        List<Product> result = productService.getAllProducts(pageNumber, searchKey);
        System.out.println(result.size());
        return result;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteProductDetails/{productId}")
    public void deleteProductDetails(@PathVariable("productId") Integer productId) {
        productService.deleteProductDetails(productId);
    }

    @GetMapping("/getProductDetailsById/{productId}")
    public Product getProductDetailsById(@PathVariable("productId") Integer productId) {
        return productService.getProductDetailsById(productId);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'TAYLOR')")
    @GetMapping("/getProductDetails/{isSingleProductCheckout}/{productId}")
    public List<Product> getProductDetails(@PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
                                           @PathVariable(name = "productId") Integer productId) {
                return productService.getProductDetails(isSingleProductCheckout, productId);
    }
}
