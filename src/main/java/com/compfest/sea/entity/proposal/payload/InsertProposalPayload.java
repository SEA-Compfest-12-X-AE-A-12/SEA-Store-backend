package com.compfest.sea.entity.proposal.payload;

import com.compfest.sea.entity.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class InsertProposalPayload {
	private Integer merchantId;
	private String description;
	private String merchantCategory;
	private String vision;
	private String mission;
	private String motivation;
}
