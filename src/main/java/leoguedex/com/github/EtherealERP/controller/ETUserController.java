package leoguedex.com.github.EtherealERP.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import leoguedex.com.github.EtherealERP.domain.dto.UpdatePasswordDTO;
import leoguedex.com.github.EtherealERP.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.EtherealERP.service.ETUserService;
import leoguedex.com.github.EtherealERP.service.FileStorageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etuser")
public class ETUserController {

    private final ETUserService service;
    private final FileStorageService fileStorageService;

    @PatchMapping
    public ResponseEntity<Void> updateUser(@ModelAttribute UpdateUserDataDTO fileUpload) throws IllegalStateException, IOException {

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

    @GetMapping("/picture/{profilePicName}")
    public ResponseEntity<byte[]> obterImagem(@PathVariable String profilePicName) throws IOException {
        
        var imagemBytes = fileStorageService.getProfilePicByName(profilePicName);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imagemBytes);
    }
}
