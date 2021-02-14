package com.lucasoliveira.helpdesk.api.entity;

import com.lucasoliveira.helpdesk.api.enumerator.ProfileEnum;
import com.lucasoliveira.helpdesk.api.model.UserModel;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  @Id
  private String id;

  @Indexed(unique = true)
  @NotBlank(message = "Email required")
  @Email(message = "Email invalid")
  private String email;


  @NotBlank(message = "Password required")
  @Size(min = 6)
  private String password;

  private ProfileEnum profile;

  public static UserModel toModel(UserEntity entity) {
    return UserModel.builder()
        .id(entity.getId())
        .email(entity.getEmail())
        .password(entity.getPassword())
        .profile(entity.getProfile())
        .build();
  }

  public static UserEntity toEntity(UserModel model) {
    return UserEntity.builder()
        .id(model.getId())
        .email(model.getEmail())
        .password(model.getPassword())
        .profile(model.getProfile())
        .build();
  }

  public static List<UserModel> toModelList(List<UserEntity> entities) {
    return Optional.of(entities).orElse(Collections.emptyList())
        .stream().map(UserModel::toModel).collect(Collectors.toList());
  }

  public static List<UserEntity> toEntityList(List<UserModel> models) {
    return Optional.of(models).orElse(Collections.emptyList())
        .stream().map(UserEntity::toEntity).collect(Collectors.toList());
  }

}
