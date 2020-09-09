package com.compfest.sea.entity.order.model;

import com.compfest.sea.entity.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "varchar(255) default 'IN_CART'")
  private OrderStatus status;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private Date createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private User customer;

  @Column(name = "reviewer_id")
  private Integer reviewedByAdminId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private Date reviewedAt;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderDetail> orderDetails;
}
