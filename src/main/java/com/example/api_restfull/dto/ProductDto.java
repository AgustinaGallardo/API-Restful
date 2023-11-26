package com.example.api_restfull.dto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public record ProductDto(
        @Positive(message = "IdProduct must be positive") long idProduct,
        @NotBlank(message = "Name cannot be blank") String name,
        @Min(value = 0, message = "PriceProduct must be greater than or equal to 0") float priceProduct
) {}
