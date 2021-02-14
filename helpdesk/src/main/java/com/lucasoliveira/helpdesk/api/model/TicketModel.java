package com.lucasoliveira.helpdesk.api.model;

import com.lucasoliveira.helpdesk.api.entity.UserEntity;
import com.lucasoliveira.helpdesk.api.enumerator.PriorityEnum;
import com.lucasoliveira.helpdesk.api.enumerator.StatusEnum;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketModel {

  private String id;

  private UserModel user;

  private LocalDateTime date;

  private String title;

  private Integer number;

  private StatusEnum status;

  private PriorityEnum priority;

  private UserEntity assignedUser;

  private String description;

  private String image;

  private List<ChangeStatusModel> changes;

}
