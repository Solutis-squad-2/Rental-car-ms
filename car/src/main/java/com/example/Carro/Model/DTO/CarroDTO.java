package com.example.Carro.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    @JsonProperty("ID do Carro")
    private Long id;

    @JsonProperty("Placa")
    private String placa;

    @JsonProperty("Chassi")
    private String chassi;

    @JsonProperty("Cor")
    private String cor;

    @JsonProperty("Valor da Diária")
    private float valorDiaria;

    @JsonProperty("Acessórios")
    private Set<AcessorioDTO> acessorios; // DTO para Acessório

}
