package com.iwomi.projet.file.repository;

import com.iwomi.projet.file.model.FileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StorageRepository extends CrudRepository<FileImage, Long> {

    @Override
    Optional<FileImage> findById(Long aLong);
    Optional<FileImage> findByName(String name);

}
