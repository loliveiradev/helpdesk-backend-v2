package com.lucasoliveira.helpdesk.api.entity;

import com.lucasoliveira.helpdesk.api.enumerator.StatusEnum;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
public class ChangeStatusEntity {

  @Id
  private String id;

  @DBRef
  private TicketEntity ticket;

  @DBRef
  private UserEntity userChange;

  private LocalDateTime dateChangeStatus;

  private StatusEnum status;

}
