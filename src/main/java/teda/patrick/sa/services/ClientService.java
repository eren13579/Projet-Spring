package teda.patrick.sa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teda.patrick.sa.entity.*;
import teda.patrick.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        Client clientDanslaBD = this.clientRepository.findByEmail(client.getEmail());
        if (clientDanslaBD == null) {
            this.clientRepository.save(client);
        }
    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireOuCreer(Client clientAcreer) {
        Client clientDanslaBD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if (clientDanslaBD == null) {
            clientDanslaBD = this.clientRepository.save(clientAcreer);
        }
        return clientDanslaBD;
    }

    public void modifier(Client client, int id) {
        Client clientDansBD = this.lire(id);

        if (clientDansBD.getId() == client.getId()) {
            clientDansBD.setEmail(client.getEmail());
            clientDansBD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansBD);
        }
    }
}
