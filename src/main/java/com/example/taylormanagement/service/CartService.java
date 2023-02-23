package com.example.taylormanagement.service;

import com.example.taylormanagement.configuration.JwtRequestFilter;
import com.example.taylormanagement.dao.CartDAO;
import com.example.taylormanagement.dao.ProductDAO;
import com.example.taylormanagement.dao.UserDAO;
import com.example.taylormanagement.entity.Cart;
import com.example.taylormanagement.entity.Product;
import com.example.taylormanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    public Cart addToCart(Integer productId) {

        Product product = productDAO.findById(productId).get();
        String userName = JwtRequestFilter.CURRENT_USER;

        User user = null;

        if (userName != null) {
            user = userDAO.findById(userName).get();
        }

        List<Cart> cartList = cartDAO.findByUser(user);

        List<Cart> filteredList = cartList.stream().filter(x -> x.getProduct().getProductId() == product.getProductId()).collect(Collectors.toList());

        if (filteredList.size() > 0) {
            return null;
        }

        if (product != null && user != null) {
            Cart cart = new Cart(product, user);
            return cartDAO.save(cart);
        }

        return null;
    }

    public List<Cart> getCartDetails() {
        String userName = JwtRequestFilter.CURRENT_USER;
        User user = userDAO.findById(userName).get();
        return cartDAO.findByUser(user);
    }

    public void deleteCartItem(Integer cartId) {
        cartDAO.deleteById(cartId);
    }
}
