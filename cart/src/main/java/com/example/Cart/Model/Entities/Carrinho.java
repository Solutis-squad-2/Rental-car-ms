package com.example.Cart.Model.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Carro.Model.Entities.Carro;
import com.example.Carro.Service.CarroService;


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

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;  // Relacionamento com Carro

    @Column(nullable = false)
    private LocalDateTime rentalStart;  // Data de início do aluguel

    @Column(nullable = false)
    private LocalDateTime rentalEnd;  // Data de fim do aluguel

    @Column(nullable = false)
    private Double price;  // Preço calculado do aluguel

    @Column(nullable = false)
    private boolean confirmed;  // Indica se o aluguel foi confirmado ou está em processo

    public Carrinho(long l, long l1, LocalDateTime localDateTime, LocalDateTime localDateTime1, double v, boolean b) {
    }
}
