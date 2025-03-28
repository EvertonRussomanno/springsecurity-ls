package martins.ton.springsecurity.controllers;

import lombok.RequiredArgsConstructor;
import martins.ton.springsecurity.config.security.TokenService;
import martins.ton.springsecurity.dto.LoginRequestDTO;
import martins.ton.springsecurity.dto.LoginResponseDTO;
import martins.ton.springsecurity.dto.RegisterRequestDTO;
import martins.ton.springsecurity.entities.User;
import martins.ton.springsecurity.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.repository.findByEmail(body.email());
        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setName(body.name());
            newUser.setLastName(body.lastName());
            newUser.setUserPhone(body.userPhone());
            newUser.setEmail(body.email());
            newUser.setUserRg(body.userRg());
            newUser.setUserCpf(body.userCpf());
            newUser.setUserName(body.email());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new LoginResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
