package com.lucasoliveira.helpdesk.api.entity;

import com.lucasoliveira.helpdesk.api.enumerator.PriorityEnum;
import com.lucasoliveira.helpdesk.api.enumerator.StatusEnum;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
public class TicketEntity {

  @Id
  private String id;

  @DBRef(lazy = true)
  private UserEntity user;

  private LocalDateTime date;

  private String title;

  private Integer number;

  private StatusEnum status;

  private PriorityEnum priority;

  @DBRef(lazy = true)
  private UserEntity assignedUser;

  private String description;

  private String image;

  @Transient
  private List<ChangeStatusEntity> changes;

}
