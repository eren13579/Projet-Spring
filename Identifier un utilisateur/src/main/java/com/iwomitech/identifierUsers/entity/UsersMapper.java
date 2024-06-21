package com.iwomitech.identifierUsers.entity;

public class UsersMapper {
    public static UsersDto mapToUsersDto(Users users){
        return new UsersDto(
          users.getId(),
          users.getUsername(),
          users.getPassword(),
          users.getRole()
        );
    }
    public static Users mapToUsers(UsersDto usersDto){
        return new Users(
                usersDto.getId(),
                usersDto.getUsername(),
                usersDto.getPassword(),
                usersDto.getRole()
        );
    }
}
