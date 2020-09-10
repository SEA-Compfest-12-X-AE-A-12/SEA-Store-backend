package com.compfest.sea.repository.order;

import com.compfest.sea.entity.order.model.Order;

import java.util.Optional;

public interface OrderDAO {
	Order save(Order order);
	Optional<Order> findById(Integer id);
	Optional<Order> findByCustomerIdAndStatus(Integer customerId,String status);
}
