package com.example.taylormanagement.dao;


import com.example.taylormanagement.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailDAO extends CrudRepository<OrderDetail, Integer> {
}
