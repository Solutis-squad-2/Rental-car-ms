package com.example.Cart.Model.DTO;

import java.time.LocalDateTime;

public record AluguelDTO(
        Long idCliente,
        LocalDateTime rentalEnd,
        Long idCarro
) {
}
