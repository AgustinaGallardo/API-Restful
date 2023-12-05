package com.example.api_restfull.service;
import com.example.api_restfull.converter.ClientMapper;
import com.example.api_restfull.dto.ClientDto;
import com.example.api_restfull.entity.Client;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private final ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Transactional
    public ClientDto addClient(ClientDto clientDto) throws MyException {

        validate(clientDto);

        Client client = clientMapper.convertToEntity(clientDto);

        clientRepository.save(client);
        return clientMapper.convertToDto(client);
    }
    private void validate(ClientDto clientDto) throws MyException {
        if(clientDto.getEmail().isEmpty()){
        throw new MyException("El email no puede estar vacio");
        }
        if(clientDto.getPhone().isEmpty()){
            throw new MyException("El teleofno no puede estar vacio");
        }
    }

    public void updateClient(Long clientId, ClientDto updatedClientDto) {

                Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + clientId));

        existingClient.setPhone(updatedClientDto.getPhone());
        existingClient.setEmail(updatedClientDto.getEmail());

        clientRepository.save(existingClient);
    }

    public List<ClientDto> getAllClients() {
        List<Client> lstClients = clientRepository.findAll();
        return clientMapper.convertToDtoList(lstClients);
    }


    public ClientDto deactivateClient(Long id_client) {
        Client client = clientRepository.findById(id_client).orElse(null);

        if (client != null) {
            client.setActive(false);
            Client savedClient = clientRepository.save(client);
            return clientMapper.convertToDto(savedClient);
        } else {
            System.out.println("It wasn´t possible to find a client with the ID: " + id_client);
            return null;
        }
    }

    public ClientDto findClientById(long id_client) {

        Client client = clientRepository.findById(id_client).orElse(null);

        if (client != null) {
            return clientMapper.convertToDto(client);
        } else {
            System.out.println("It wasn´t possible to find a client with the ID: " + id_client);
            return null;
        }
    }


}
