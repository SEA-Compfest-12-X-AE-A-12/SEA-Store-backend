package com.compfest.sea.repository.order;

import com.compfest.sea.entity.order.model.Order;
import com.compfest.sea.entity.order.model.OrderStatus;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderDAOJPACustom extends Repository<Order, Integer> {
  @Query("SELECT o FROM Order o WHERE  o.customer_id = :customer AND o.status  = :status")
  Optional<Order> findByCustomerIdAndStatus(
      @Param("customer") Integer customer, @Param("status") OrderStatus status);
}
