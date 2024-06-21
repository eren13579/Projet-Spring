package com.iwomi.identification.repository;

import com.iwomi.identification.entity.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentifierRepository extends JpaRepository<Identifier, String> {

    public Identifier findIdentifierByNumeroCode(String code);
}
