package com.iwomi.identification.service;

import com.iwomi.identification.entity.User;
import com.iwomi.identification.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

    private final UserRepository userRepository;

    public List<User> search(){
        return userRepository.findAll();
    }
    public List<User> searchUsername(String username){
        if (this.userRepository.findUserByUsername(username) == null){
            throw new UsernameNotFoundException("User not found with username:"+username);
        }
        return userRepository.findUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found with username:"+username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));

    }
}
