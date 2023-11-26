package com.example.api_restfull.service;
import com.example.api_restfull.converter.ClientMapper;
import com.example.api_restfull.dto.ClientDto;
import com.example.api_restfull.entity.Client;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        // Puedes agregar validaciones adicionales aquí si es necesario

        // Convierte el DTO a la entidad Client utilizando ModelMapper
        Client client = clientMapper.convertToEntity(clientDto);

        // Guarda la entidad en la base de datos
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







}
