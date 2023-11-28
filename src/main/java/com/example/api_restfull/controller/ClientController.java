package com.example.api_restfull.controller;
import com.example.api_restfull.dto.ClientDto;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addClient(@Validated @RequestBody ClientDto clientDto) throws MyException {

        clientService.addClient(clientDto);
        return new ResponseEntity<>("Client added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{clientId}")
    public ResponseEntity<String> updateClient(@PathVariable Long clientId, @Validated @RequestBody ClientDto updatedClientDto) throws MyException {
        clientService.updateClient(clientId, updatedClientDto);
        return new ResponseEntity<>("Client updated successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


}
