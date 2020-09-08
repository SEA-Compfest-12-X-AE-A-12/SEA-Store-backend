package com.compfest.sea.entity.proposal.model;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.merchant.model.Merchant;
import com.compfest.sea.entity.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "proposals")
public class Proposal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name="reviewer_id")
  private Integer reviewedByAdminId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "merchant_id", referencedColumnName = "user_id")
  private Merchant merchant;

  private String description;
  @Enumerated(EnumType.STRING)
  private Category merchantCategory;
  private String vision;
  private String mission;
  private String motivation;

  @Column(columnDefinition = "varchar(255) default 'ON_REVIEW'")
  @Enumerated(EnumType.STRING)
  private ProposalStatus proposalStatus;
}
