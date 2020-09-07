package com.compfest.sea.entity.proposal;

import com.compfest.sea.entity.category.Category;
import com.compfest.sea.entity.merchant.model.Merchant;
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

  private Integer reviewedByAdminId;

  @NotBlank
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "merchant_id", referencedColumnName = "user_id")
  private Merchant merchant;

  private String description;
  private Category merchantCategory;
  private String vision;
  private String mission;
  private String motivation;

  @Column(columnDefinition = "varchar(255) default 'ON_REVIEW'")
  private ProposalStatus proposalStatus;
}
