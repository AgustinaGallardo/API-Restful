package com.example.api_restfull.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDto {
    @NotBlank(message = "IdClient cannot be blank")
    private long idClient;

    @NotBlank(message = "Phone cannot be blank")
    private String phone;

    @Email(message = "Invalid email address")
    private String email;

}