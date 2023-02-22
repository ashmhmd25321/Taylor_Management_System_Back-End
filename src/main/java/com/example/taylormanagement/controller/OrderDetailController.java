package com.example.taylormanagement.controller;

import com.example.taylormanagement.entity.OrderInput;
import com.example.taylormanagement.service.OrderDetailService;
import com.example.taylormanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/placeOrder")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'TAYLOR')")
    public void placeOrder(@RequestBody OrderInput orderInput) {
    orderDetailService.placeOrder(orderInput);
    }

}
