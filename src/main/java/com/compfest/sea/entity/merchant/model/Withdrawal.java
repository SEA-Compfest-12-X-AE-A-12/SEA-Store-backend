package com.compfest.sea.entity.merchant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "withdrawals")
public class Withdrawal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private Integer amount;

  @Column
  private Integer remainingBalance;

  @Size(max = 50)
  @Column
  private String bankName;

  @Size(max = 50)
  @Pattern(regexp = "\\d+")
  @Column
  private String accountNumber;

  @ManyToOne
  @JoinColumn(name = "merchant_id", nullable = false)
  @JsonIgnore
  private Merchant merchant;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "timestamp")
  private Date timestamp;

  public Withdrawal(Integer amount, String bankName, String accountNumber, Merchant merchant, Integer remainingBalance) {
    this.amount = amount;
    this.remainingBalance = remainingBalance;
    this.bankName = bankName;
    this.accountNumber = accountNumber;
    this.merchant = merchant;
  }
}
