package com.iwomi.identification.controller;

import com.iwomi.identification.entity.User;
import com.iwomi.identification.liste.EnumRole;
import com.iwomi.identification.repository.UserRepository;
import com.iwomi.identification.service.CustomUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RegistrationLoginController {
    private final CustomUserDetailService customUserDetailService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        if(this.userRepository.findByUsername(user.getUsername()) != null)
            return ResponseEntity.badRequest().body("Username already exists");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestParam User user){
        try {
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            return ResponseEntity.ok("Login successful");
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid username or password");
        }
    }
    @GetMapping("/search")
    public List<User> search(){
        return customUserDetailService.search();
    }

    @GetMapping("/search/{username}")
    public List<User> searchUsername (@PathVariable String username){
        return customUserDetailService.searchUsername(username);
    }
}
