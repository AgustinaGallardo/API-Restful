package com.example.api_restfull.dto;
import com.example.api_restfull.entity.Client;
import com.example.api_restfull.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class  OrderDto {
    private Long id_order;
    private LocalDate date;
    private Client client;
    private List<Product> products;
    private List<Long> productIds;
    private Long orderNumber;
    private boolean isActive = true;

}