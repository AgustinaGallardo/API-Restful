package com.example.api_restfull.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "`customer_order`")
public class Order{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_order")
    private long idOrder;
    @ManyToOne
    private Client clientOrder;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrder;



}
