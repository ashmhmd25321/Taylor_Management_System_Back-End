package com.example.taylormanagement.service;

import com.example.taylormanagement.configuration.JwtRequestFilter;
import com.example.taylormanagement.dao.CartDAO;
import com.example.taylormanagement.dao.OrderDetailDAO;
import com.example.taylormanagement.dao.ProductDAO;
import com.example.taylormanagement.dao.UserDAO;
import com.example.taylormanagement.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private static final String ORDER_PLACED = "Placed";

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CartDAO cartDAO;

    public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout) {
        List<OrderProductQuantity> orderProductQuantities = orderInput.getOrderProductQuantities();

        for (OrderProductQuantity o: orderProductQuantities) {
            Product product = productDAO.findById(o.getProductId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDAO.findById(currentUser).get();

            OrderDetail orderDetail = new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACED,
                    product.getDiscountedPrice() * o.getQuantity(),
                    product,
                    user
            );

            if (!isSingleProductCheckout) {
                List<Cart> carts = cartDAO.findByUser(user);
                carts.stream().forEach(x -> cartDAO.deleteById(x.getCartId()));
            }

            orderDetailDAO.save(orderDetail);
        }
    }

}
