package leoguedex.com.github.EtherealERP.controller;

import leoguedex.com.github.EtherealERP.domain.dto.UpdatePasswordDTO;
import leoguedex.com.github.EtherealERP.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.EtherealERP.service.ETUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etuser")
public class ETUserController {

    private final ETUserService service;

    @PatchMapping
    public ResponseEntity<Void> updateUser(@ModelAttribute UpdateUserDataDTO fileUpload) {

        boolean updatedData = service.updateLogedUserData(fileUpload);

        if (updatedData) {
            return ResponseEntity.ok().body(null);
        }

        return ResponseEntity.badRequest().body(null);
    }

    @PatchMapping("/password")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePassword(@RequestBody UpdatePasswordDTO newPasswordDTO) {
        service.updatePassword(newPasswordDTO);
    }
}
