package leoguedex.com.github.HealthCoachWeb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdatePasswordDTO;
import leoguedex.com.github.HealthCoachWeb.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.HealthCoachWeb.service.HCUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hcuser")
public class HCUserController {

  private final HCUserService service;

  @PatchMapping  
  public ResponseEntity<Void> updateUser(@ModelAttribute UpdateUserDataDTO fileUpload) {

    boolean updatedData = service.updateLogedUserData(fileUpload);

    if(updatedData) {
      return ResponseEntity.ok().body(null);//"redirect:/profile?updatedData=true";
    }
    
    return ResponseEntity.badRequest().body(null);
  }

  @PatchMapping("/password")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void updatePassword(@RequestBody UpdatePasswordDTO newPasswordDTO) {
    service.updatePassword(newPasswordDTO);
  }
}
