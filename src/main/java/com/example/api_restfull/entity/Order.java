package com.example.api_restfull.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order{

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_order")
    private long idOrder;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client clientOrder;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date = LocalDate.now();

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    private Long orderNumber;
    private boolean isActive;

}
