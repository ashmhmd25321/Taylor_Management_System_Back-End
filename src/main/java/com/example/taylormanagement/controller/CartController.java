package com.example.taylormanagement.controller;

import com.example.taylormanagement.entity.Cart;
import com.example.taylormanagement.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/addToCart/{productId}")
    public Cart addToCart(@PathVariable(name = "productId") Integer productId) {
        return cartService.addToCart(productId);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/getCartDetails")
    public List<Cart> getCartDetails() {
        return cartService.getCartDetails();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @DeleteMapping("/deleteCartItem/{cartId}")
    public void deleteCartItem(@PathVariable(name = "cartId") Integer cartId) {
        cartService.deleteCartItem(cartId);
    }
}
