package tech.dracarys.egaapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dracarys.egaapi.entities.Client;
import tech.dracarys.egaapi.repositories.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClientByEmail(String email){
        return clientRepository.findClientByEmail(email).get();
    }
}
