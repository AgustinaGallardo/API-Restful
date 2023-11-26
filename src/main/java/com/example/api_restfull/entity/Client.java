package com.example.api_restfull.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "`client`")
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_client")
        private long idClient;
        private String email;
        private String phone;

}