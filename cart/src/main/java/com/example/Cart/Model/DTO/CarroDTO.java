package com.example.Cart.Model.DTO;


import java.util.List;


public record CarroDTO(
        Long id,
        String placa,
        String chassi,
        String cor,
        Double valorDiaria,
        Boolean reserva,
        List<String> acessorios,
        String urlImagem,
        String modeloDescricao,
        String fabricanteNome,
        String categoria
) {
}
