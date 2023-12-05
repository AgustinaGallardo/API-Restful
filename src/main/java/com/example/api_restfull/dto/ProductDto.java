package com.example.api_restfull.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto{
        @NotBlank(message = "IdProduct cannot be blank")
        private long idProduct;
        @NotBlank(message = "Name cannot be blank")
        private String name;
        @Min(value = 0, message = "PriceProduct must be greater than or equal to 0")
        private float priceProduct;

        private boolean isActive = true;
}
