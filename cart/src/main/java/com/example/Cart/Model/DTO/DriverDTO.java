package com.example.Cart.Model.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DriverDTO(
        String nome,
        String email,
        LocalDate dataNascimento,
        String cpf,
        Boolean ativo,
        String numeroCNH
) {
}
