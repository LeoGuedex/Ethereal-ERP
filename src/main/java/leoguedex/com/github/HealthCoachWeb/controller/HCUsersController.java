package leoguedex.com.github.HealthCoachWeb.controller;

import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
import leoguedex.com.github.HealthCoachWeb.domain.dto.HCUserDTO;
import leoguedex.com.github.HealthCoachWeb.domain.dto.LoginDTO;
import leoguedex.com.github.HealthCoachWeb.repository.HCUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class HCUsersController {

    @Autowired
    private HCUserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<HCUserDTO> login(@RequestBody LoginDTO loginDTO) {
        HCUser savedUser = userRepository.findByEmail(loginDTO.getEmail());
        System.out.println("Login received. Email: " + loginDTO.getEmail() + " Password: " + loginDTO.getPassword());

        if (savedUser != null && savedUser.getPassword().equals(loginDTO.getPassword())) {
            HCUserDTO userResponse = new HCUserDTO(savedUser.getId(), savedUser.getName(), savedUser.getUsername(),
                    savedUser.getEmail(), savedUser.getPersonFunction(), savedUser.getAdmin());
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
