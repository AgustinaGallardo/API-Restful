package com.example.api_restfull.controller;
import com.example.api_restfull.dto.ClientDto;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
