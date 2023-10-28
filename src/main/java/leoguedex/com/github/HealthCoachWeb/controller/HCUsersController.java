package leoguedex.com.github.HealthCoachWeb.controller;

import leoguedex.com.github.HealthCoachWeb.domain.HCUser;
import leoguedex.com.github.HealthCoachWeb.domain.dto.HCUserDTO;
import leoguedex.com.github.HealthCoachWeb.domain.dto.LoginDTO;
import leoguedex.com.github.HealthCoachWeb.repository.HCUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HCUsersController {

    @Autowired
    private HCUserRepository userRepository;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<HCUserDTO> login(@RequestBody LoginDTO loginDTO) {
        HCUser savedUser = userRepository.findByEmail(loginDTO.getEmail());

        if (savedUser != null && savedUser.getPassword().equals(loginDTO.getPassword())) {
            HCUserDTO userResponse = new HCUserDTO(savedUser.getId(), savedUser.getName(), savedUser.getUsername(),
                    savedUser.getEmail(), savedUser.getPersonFunction(), savedUser.getAdmin());
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
