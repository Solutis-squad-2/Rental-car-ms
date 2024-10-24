package com.example.Cart.Model.Entities;

import com.example.Cart.Model.DTO.CarroDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDateTime;

@Entity
@Table(name = "carrinhos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long clientId;  // Referência ao cliente (Pessoa)

    private Long carroId;  // Relacionamento com Carro

    @Column(nullable = false)
    private LocalDateTime rentalStart;  // Data de início do aluguel

    @Column(nullable = false)
    private LocalDateTime rentalEnd;  // Data de fim do aluguel

    @Column(nullable = false)
    private Double price;  // Preço calculado do aluguel

    @Column(nullable = false)
    private boolean confirmed;  // Indica se o aluguel foi confirmado ou está em processo

    public Carrinho(Long clientId, Long carroId, LocalDateTime rentalStart, LocalDateTime rentalEnd, Double price, boolean confirmed) {
        this.clientId = clientId;
        this.carroId = carroId;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.price = price;
        this.confirmed = confirmed;
    }
}
