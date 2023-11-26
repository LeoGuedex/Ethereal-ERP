package leoguedex.com.github.HealthCoachWeb.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordDTO {
  private String currentPassword;
  private String newPassword;
}
