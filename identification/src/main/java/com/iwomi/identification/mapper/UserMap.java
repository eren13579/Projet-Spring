package com.iwomi.identification.mapper;

import com.iwomi.identification.DTO.UserDto;
import com.iwomi.identification.entity.User;

public class UserMap {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                user.getRoleUser(),
                user.getIdentifier()
        );
    }
}
