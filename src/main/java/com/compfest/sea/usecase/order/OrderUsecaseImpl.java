package com.compfest.sea.usecase.order;

import com.compfest.sea.entity.order.model.Order;
import com.compfest.sea.entity.order.model.OrderDetail;
import com.compfest.sea.entity.order.model.OrderStatus;
import com.compfest.sea.entity.order.payload.AddToCartRequestPayload;
import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.user.model.User;
import com.compfest.sea.repository.order.OrderDAO;
import com.compfest.sea.repository.order.detail.OrderDetailDAO;
import com.compfest.sea.usecase.product.ProductUsecase;
import com.compfest.sea.usecase.user.UserUsecase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("OrderUsecaseImpl")
public class OrderUsecaseImpl implements OrderUsecase {
  private final OrderDAO orderDAO;
  private final OrderDetailDAO orderDetailDAO;
  private final UserUsecase userUsecase;
  private final ProductUsecase productUsecase;

  public OrderUsecaseImpl(
      @Qualifier("OrderDAODB") OrderDAO orderDAO,
      @Qualifier("OrderDetailDAODB") OrderDetailDAO orderDetailDAO,
      UserUsecase userUsecase,
      ProductUsecase productUsecase) {
    this.orderDAO = orderDAO;
    this.orderDetailDAO = orderDetailDAO;
    this.userUsecase = userUsecase;
    this.productUsecase = productUsecase;
  }

  @Override
  public List<String> addToCart(AddToCartRequestPayload addToCartRequestPayload) {
    List<String> messages = new ArrayList<>();
    try {
      Product product = productUsecase.get(addToCartRequestPayload.getProductId());
      messages.addAll(validateAddToCart(addToCartRequestPayload, product));
      User user = userUsecase.findUserById(addToCartRequestPayload.getUserId());
      Order order =
          orderDAO
              .findByCustomerIdAndStatus(addToCartRequestPayload.getUserId(), OrderStatus.IN_CART)
              .orElse(null);
      if (order == null) {
        order = new Order(OrderStatus.IN_CART, user);
        order = orderDAO.save(order);
      }
      OrderDetail orderDetail =
          new OrderDetail(order, product, addToCartRequestPayload.getQuantity());
      orderDetailDAO.save(orderDetail);

      messages.add("Success add " + product.getName() + " to cart");
    } catch (Exception e) {
      messages.add("Failed, " + e);
    }
    return messages;
  }

  private List<String> validateAddToCart(
      AddToCartRequestPayload addToCartRequestPayload, Product product) {
    if (product == null) {
      return Arrays.asList("Failed, product not found");
    } else if (addToCartRequestPayload.getQuantity() < 0
        && addToCartRequestPayload.getQuantity() > product.getQuantity()) {
      return Arrays.asList("Failed, invalid amount of quantity");
    }
    return new ArrayList<>();
  }
}
