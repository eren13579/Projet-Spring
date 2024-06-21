package com.iwomitech.identifierUsers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private long id;
    private String username;
    private String password;
    private ListUsers role;
}
