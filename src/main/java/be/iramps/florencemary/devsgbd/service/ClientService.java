package be.iramps.florencemary.devsgbd.service;

import be.iramps.florencemary.devsgbd.dto.ClientDto;
import be.iramps.florencemary.devsgbd.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> read();
    Client readOne(Long id);
    void create(Client newItem);
    Client update(Long id, ClientDto update);
    Client delete(Long id);
}