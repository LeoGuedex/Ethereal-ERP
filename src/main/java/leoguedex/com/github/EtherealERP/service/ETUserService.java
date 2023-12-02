package leoguedex.com.github.EtherealERP.service;

import leoguedex.com.github.EtherealERP.domain.ETUser;
import leoguedex.com.github.EtherealERP.domain.dto.UpdatePasswordDTO;
import leoguedex.com.github.EtherealERP.domain.dto.UpdateUserDataDTO;
import leoguedex.com.github.EtherealERP.exception.ApiException;
import leoguedex.com.github.EtherealERP.repository.ETUserRepository;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

@Service
public class ETUserService {

    private final ETUserRepository repository;
    private final PasswordEncoder encoder;
    private final FileStorageService fileStorageService;

    public ETUserService(ETUserRepository repository, PasswordEncoder encoder, FileStorageService fileStorageService) {
        this.repository = repository;
        this.encoder = encoder;
        this.fileStorageService = fileStorageService;
    }

    public ETUser findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("email not found."));
    }

    public ETUser createUser(ETUser user) {
        return repository.save(user);
    }

    public boolean updateLogedUserData(UpdateUserDataDTO newUserData) throws IllegalStateException, IOException {

        MultipartFile ProfilePicture = newUserData.getHcUserPic();
        ETUser logedUser = getLoggedUser();
        String fileName = null;

        logedUser.setEmail(newUserData.getEmail());
        logedUser.getUserData().setAddress(newUserData.getAddress());
        logedUser.getUserData().setFirstName(newUserData.getFirstName());
        logedUser.getUserData().setLastName(newUserData.getLastName());
        logedUser.getUserData().setPhoneNumber(newUserData.getPhone());

        if (ProfilePicture != null) {
            fileName = StringUtils.cleanPath(ProfilePicture.getOriginalFilename())
                .replace("image", "profile_picture_user_" + logedUser.getId().toString());
            fileStorageService.updatePhoto(ProfilePicture, fileName);
        }
        
        logedUser.getUserData().setProfilePictureName(fileName);

        repository.save(logedUser);

        return true;
    }

    public void updatePassword(UpdatePasswordDTO updatePasswordDTO) {

        ETUser logedUser = getLoggedUser();

        boolean passwordMatch = encoder.matches(updatePasswordDTO.getCurrentPassword(), logedUser.getPassword());
        if (!passwordMatch) {
            throw new ApiException("the old password doesn't match", HttpStatus.BAD_REQUEST);
        }
        logedUser.setPassword(encoder.encode(updatePasswordDTO.getNewPassword()));
        repository.save(logedUser);
    }

    private ETUser getLoggedUser() {
        return (ETUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
