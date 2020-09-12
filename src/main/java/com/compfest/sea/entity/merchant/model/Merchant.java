package com.compfest.sea.entity.merchant.model;

import com.compfest.sea.entity.product.model.Product;
import com.compfest.sea.entity.proposal.model.Proposal;
import com.compfest.sea.entity.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchant {
  @Id
  @Column(name = "user_id")
  private int userID;

  @OneToOne @MapsId @JsonIgnore private User user;
  private String description;
  private boolean isVerified;
  private int balance;

  @OneToMany(mappedBy = "merchant")
  private List<Proposal> proposals;

  @OneToMany(mappedBy = "merchant")
  private List<Product> products;

  @OneToMany(mappedBy = "merchant")
  private List<Withdrawal> withdrawals;

  public Merchant(String description, boolean isVerified, int balance) {
    this.description = description;
    this.isVerified = isVerified;
    this.balance = balance;
  }
}
