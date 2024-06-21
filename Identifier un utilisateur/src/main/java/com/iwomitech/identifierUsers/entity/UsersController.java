package com.iwomitech.identifierUsers.entity;

import com.iwomitech.identifierUsers.entity.service.UsersServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Users")
@AllArgsConstructor
public class UsersController {
    private final UsersServiceImpl usersService;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> register(@RequestBody UsersDto usersDto){
        if(usersRepository.findByUsername(usersDto.getUsername()) != null){
             return new ResponseEntity<UsersDto>(HttpStatus.valueOf("Username already exists"));
        }
        usersDto.setPassword(passwordEncoder.encode(usersDto.getPassword()));

        UsersDto saveUsers = usersService.register(usersDto);
        return new ResponseEntity<>(saveUsers, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UsersDto> login(@RequestBody UsersDto dto){
        System.out.println("uuu "+dto);
        try {
            Users users = this.usersRepository.findByUsername(dto.getUsername());
            if (passwordEncoder.matches(dto.getPassword(), users.getPassword())){
               UsersDto usersDto = UsersMapper.mapToUsersDto(users);
                return new  ResponseEntity<UsersDto>(usersDto,HttpStatus.BAD_REQUEST);
            }
            else {
                UsersDto usersDto = UsersMapper.mapToUsersDto(users);
                return new  ResponseEntity<UsersDto>(usersDto ,HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<UsersDto>(HttpStatus.valueOf("password and username incorret"));
        }
    }

    @GetMapping(":/searchAll")
    public List<UsersDto> search(){
        return usersService.search();
    }
    @GetMapping("/searchByUsername/{username}")
    public UsersDto searchByUsername(@PathVariable String username){
       return this.usersService.searchByUsername(username);
    }

}
