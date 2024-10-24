package com.example.Carro.Model.DTO;

import com.example.Carro.Model.Entities.Categoria;
import com.example.Carro.Model.Entities.Fabricante;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    @JsonProperty("Descrição")
    private String descricao;

    @JsonProperty("Nome do Fabricante")
    private Fabricante nomeFabricante;

    @JsonProperty("Categoria")
    private Categoria categoria;

    @JsonProperty("Id do Fabricante")
    private Long id;

}
