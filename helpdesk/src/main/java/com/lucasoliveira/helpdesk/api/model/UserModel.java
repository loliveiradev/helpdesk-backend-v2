package com.lucasoliveira.helpdesk.api.model;

import com.lucasoliveira.helpdesk.api.entity.UserEntity;
import com.lucasoliveira.helpdesk.api.enumerator.ProfileEnum;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

  private String id;
  private String email;
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
