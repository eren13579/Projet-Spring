package com.iwomi.identification.mapper;

import com.iwomi.identification.DTO.ImageDto;
import com.iwomi.identification.entity.Image;

public class ImageMap {
    public static ImageDto mapToImageDto(Image image){
        return new ImageDto(
                image.getId(),
                image.getName(),
                image.getSize(),
                image.getFileImage()
        );
    }
}
