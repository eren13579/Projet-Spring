package com.iwomi.identification.DTO;

import com.iwomi.identification.entity.Image;
import com.iwomi.identification.liste.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IdentifierDto {
    private String numeroCode;
    private String firstName;
    private String LastName;
    private EnumType type;
    private ImageDto imageDto;

    public IdentifierDto(String numeroCode, String firstName, String lastName, EnumType type, Image image) {
    }
}
