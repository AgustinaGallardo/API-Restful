package com.example.api_restfull.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

public record ClientDto(
        @NotBlank(message = "IdClient cannot be blank") long idClient,
        @NotBlank(message = "Phone cannot be blank") String phone,
        @Email(message = "Invalid email address") String email
) {






}