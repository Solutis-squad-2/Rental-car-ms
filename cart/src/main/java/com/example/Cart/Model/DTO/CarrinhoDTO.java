package com.example.Cart.Model.DTO;

import com.example.Cart.Model.Entities.Carrinho;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

public record CarrinhoDTO(
        Long clientId,
        LocalDateTime rentalStart,
        LocalDateTime rentalEnd,
        Double price,
        CarroDTO carro
) {
}