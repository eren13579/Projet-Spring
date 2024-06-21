package com.iwomitech.identifierUsers.entity.service;

import com.iwomitech.identifierUsers.entity.Users;
import com.iwomitech.identifierUsers.entity.UsersDto;
import com.iwomitech.identifierUsers.entity.UsersMapper;
import com.iwomitech.identifierUsers.entity.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;
    @Override
    public UsersDto register(UsersDto usersDto) {
        Users users = UsersMapper.mapToUsers(usersDto);
        Users saveUsers = usersRepository.save(users);
        return UsersMapper.mapToUsersDto(saveUsers);
    }

    @Override
    public List<UsersDto> search() {
        Users users = (Users) usersRepository.findAll();
        return (List<UsersDto>) UsersMapper.mapToUsersDto(users);
    }

    @Override
    public UsersDto searchByUsername(String username) {
        if(this.usersRepository.findUsersByUsername(username) == null){
        throw new UsernameNotFoundException("User not found with username:"+username);
        }
        Users users = this.usersRepository.findUsersByUsername(username);
        return UsersMapper.mapToUsersDto(users);
    }

    @Override
    public UsersDto uploadUsers(UsersDto usersDto) {
        return null;
    }

    @Override
    public void  delete(long id) {
         this.usersRepository.deleteById(id);
    }
}
