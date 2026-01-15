package teda.patrick.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teda.patrick.sa.entity.*;


public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email);
}
