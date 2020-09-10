package com.compfest.sea.repository.order.detail;

import com.compfest.sea.entity.order.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("OrderDetailDAODB")
public class OrderDetailDAOImpl implements OrderDetailDAO {
	@Autowired@Lazy private OrderDetailDAOJPA orderDetailDAOJPA;
	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		return orderDetailDAOJPA.save(orderDetail);
	}
}
