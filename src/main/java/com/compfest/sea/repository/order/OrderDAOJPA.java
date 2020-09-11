package com.compfest.sea.repository.order;

import com.compfest.sea.entity.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAOJPA extends JpaRepository<Order, Integer> {}
