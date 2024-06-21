package com.iwomi.identification.service;

import com.iwomi.identification.entity.Identifier;
import com.iwomi.identification.repository.IdentifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentifierService {
    private final IdentifierRepository identifierRepository;

    public Identifier created (Identifier identifier){
      return identifierRepository.save(identifier);
    }

    public Identifier update (Identifier identifier, String code){
        return identifierRepository.findById(code).map(p ->{
            p.setNumeroCode(identifier.getNumeroCode());
            p.setFirstName(identifier.getFirstName());
            p.setLastName(identifier.getLastName());
            p.setType(identifier.getType());
            p.setImage(identifier.getImage());
            return identifierRepository.save(identifier);
        }).orElseThrow();
        }
        public void delete(String code){
           this.identifierRepository.deleteById(code);
        }
        public Optional<Identifier> search(String code){
            return identifierRepository.findById(code);
        }
    }

