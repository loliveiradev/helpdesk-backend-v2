package com.lucasoliveira.helpdesk.api.model;

import com.lucasoliveira.helpdesk.api.enumerator.StatusEnum;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeStatusModel {

  private String id;

  private TicketModel ticket;

  private UserModel userChange;

  private LocalDateTime dateChangeStatus;

  private StatusEnum status;

}
