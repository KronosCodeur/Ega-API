package tech.dracarys.egaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.dracarys.egaapi.entities.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findClientByEmail(String email);
}
