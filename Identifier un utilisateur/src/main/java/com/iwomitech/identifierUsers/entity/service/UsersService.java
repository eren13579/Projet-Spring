package com.iwomitech.identifierUsers.entity.service;

import com.iwomitech.identifierUsers.entity.Users;
import com.iwomitech.identifierUsers.entity.UsersDto;

import java.util.List;

public interface UsersService {
    public UsersDto register (UsersDto usersDto);

    public List<UsersDto> search ();

    public UsersDto searchByUsername (String username);

    public UsersDto uploadUsers (UsersDto usersDto);

    public void delete (long id);
}
