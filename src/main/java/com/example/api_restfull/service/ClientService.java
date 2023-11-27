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
    public void addClient(ClientDto clientDto) throws MyException {

        // Convierte el DTO a la entidad Client utilizando ModelMapper
        Client client = clientMapper.convertToEntity(clientDto);

        clientRepository.save(client);
    }
    private void validation(String email, String phone) throws MyException {
        if(email.isEmpty()){
        throw new MyException("El email no puede estar vacio");
        }
        if(phone.isEmpty()){
            throw new MyException("El teleofno no puede estar vacio");
        }
    }


    public void updateClient(Long clientId, ClientDto updatedClientDto) {

                Client existingClient = clientRepository.findById(String.valueOf(clientId))
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + clientId));

        existingClient.setPhone(updatedClientDto.phone());
        existingClient.setEmail(updatedClientDto.email());

        clientRepository.save(existingClient);

    }
}
