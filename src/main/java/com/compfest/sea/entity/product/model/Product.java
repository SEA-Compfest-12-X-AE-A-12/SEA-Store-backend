package com.compfest.sea.entity.product.model;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.order.model.OrderDetail;
import com.compfest.sea.entity.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Data
@Entity
@Table(name = "\"products\"")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private Integer price;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @ManyToOne
  @JoinColumn(name = "merchant_id")
  private User merchant;

  @Column(name = "category")
  @Enumerated(EnumType.STRING)
  private Category category;

  @Column(name = "active", columnDefinition = "boolean default true")
  private Boolean active = true;

  @OneToMany(mappedBy = "product")
  private List<OrderDetail> orderDetails;

  public Product(Integer id, String name, String description, Integer price, Integer quantity, User merchant, Category category, Boolean active) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.merchant = merchant;
    this.category = category;
    this.active = active;
  }
}
