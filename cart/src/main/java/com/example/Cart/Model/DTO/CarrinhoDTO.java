package com.example.Carrinho.Model.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarrinhoDTO {

    private Long clientId;
    private Long carId;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalEnd;
    private Double price;  // Você pode ignorar este campo se quiser calcular no backend
}
