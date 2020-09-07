package com.compfest.sea.entity.product.model;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
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
  private Category category;

  @Column(name = "active", columnDefinition = "boolean default true")
  private Boolean active = true;
}
