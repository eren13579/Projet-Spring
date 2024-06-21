package com.iwomi.identification.DTO;

import com.iwomi.identification.entity.Identifier;
import com.iwomi.identification.liste.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private String password;
    private String role;
    private String roleUser;
    private IdentifierDto identifierDto;

    public UserDto(long id, String username, String role, EnumRole roleUser, Identifier identifier) {
    }
}
