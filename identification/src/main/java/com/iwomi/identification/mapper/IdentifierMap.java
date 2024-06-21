package com.iwomi.identification.mapper;

import com.iwomi.identification.DTO.IdentifierDto;
import com.iwomi.identification.entity.Identifier;

public class IdentifierMap {
    public static IdentifierDto mapToIdentifierDto(Identifier identifier){
        return new IdentifierDto(
                identifier.getNumeroCode(),
                identifier.getFirstName(),
                identifier.getLastName(),
                identifier.getType(),
                identifier.getImage()
        );
    }
}
