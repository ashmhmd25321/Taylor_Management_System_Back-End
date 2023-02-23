package com.example.taylormanagement.controller;

import com.example.taylormanagement.entity.OrderInput;
import com.example.taylormanagement.service.OrderDetailService;
import com.example.taylormanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/placeOrder/{isSingleProductCheckout}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'TAYLOR')")
    public void placeOrder(@PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
                           @RequestBody OrderInput orderInput) {
    orderDetailService.placeOrder(orderInput, isSingleProductCheckout);
    }

}
