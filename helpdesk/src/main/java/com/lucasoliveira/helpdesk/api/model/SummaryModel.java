package com.lucasoliveira.helpdesk.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SummaryModel {

  private Integer amountNew;
  private Integer amountResolved;
  private Integer amountApproved;
  private Integer amountDisapproved;
  private Integer amountAssigned;
  private Integer amountClosed;

}
