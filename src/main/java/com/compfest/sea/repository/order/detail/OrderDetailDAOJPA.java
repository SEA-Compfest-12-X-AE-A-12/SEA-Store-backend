package com.compfest.sea.repository.order.detail;

import com.compfest.sea.entity.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAOJPA extends JpaRepository<OrderDetail, Integer> {}
