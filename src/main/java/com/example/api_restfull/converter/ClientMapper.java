package com.example.api_restfull.converter;
import com.example.api_restfull.dto.ClientDto;
import com.example.api_restfull.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper{
   private final ModelMapper modelMapper;

   public ClientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ClientDto convertToDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    public Client convertToEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    public List<ClientDto> convertToDtoList(List<Client> clients) {
        return clients.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
