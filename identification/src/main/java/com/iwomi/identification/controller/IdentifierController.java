package com.iwomi.identification.controller;

import com.iwomi.identification.entity.Identifier;
import com.iwomi.identification.repository.IdentifierRepository;
import com.iwomi.identification.service.IdentifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IdentifierController {
    private final IdentifierService identifierService;
    private final IdentifierRepository identifierRepository;

    @PostMapping("/created")
    public ResponseEntity<?> created(@RequestBody Identifier identifier){
        Identifier identifier1 = identifierService.created(identifier);
        if(identifierRepository.findIdentifierByNumeroCode(identifier.getNumeroCode()) != null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identification already exists");
        }
        return ResponseEntity.ok(identifier1);
    }

    @GetMapping("/search_Identity/{code}")
    public ResponseEntity<?> search(@PathVariable String code){
        if (identifierService.search(code) == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identification does not exist");
        return  ResponseEntity.ok(identifierService.search(code));
    }
    @PutMapping("/update/{code}")
    public ResponseEntity<?> update(Identifier identifier,@PathVariable String code){
        identifierService.update(identifier,code);
        return ResponseEntity.ok("Successful modification");
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> delete(@PathVariable String code){
        identifierService.delete(code);
        return ResponseEntity.ok("successful delete");
    }
}
