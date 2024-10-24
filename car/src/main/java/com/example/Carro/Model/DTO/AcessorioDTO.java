package com.example.Carro.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcessorioDTO {

    @JsonProperty("ID do Acessório")
    private Long id;

    @JsonProperty("Descrição do Acessório")
    private String descricao;
}
