package com.compfest.sea.repository.order;

import com.compfest.sea.entity.order.model.Order;
import com.compfest.sea.entity.order.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("OrderDAODB")
public class OrderDAODatabase implements OrderDAO {
  @Autowired @Lazy private OrderDAOJPA orderDAOJPA;
  @Autowired @Lazy private OrderDAOJPACustom orderDAOJPACustom;

  @Override
  public Order save(Order order) {
    return orderDAOJPA.save(order);
  }

  @Override
  public Optional<Order> findById(Integer id) {
    return orderDAOJPA.findById(id);
  }

  @Override
  public Optional<Order> findByCustomerIdAndStatus(Integer customerId, OrderStatus status) {
    return orderDAOJPACustom.findByCustomerIdAndStatus(customerId, status);
  }
}
