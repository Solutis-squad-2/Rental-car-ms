package com.example.Carro.Model.DTO;

import com.example.Carro.Model.Entities.Acessorio;
import com.example.Carro.Model.Entities.ModeloCarro;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDisponivelDTO {

    @JsonProperty("ID do Carro")
    private Long id;

    @JsonProperty("Valor da Diária")
    private float valorDiaria;

    @JsonProperty("Modelo do Carro")
    private ModeloCarro modeloCarro;

    @JsonProperty("Acessórios")
    private Set<Acessorio> acessorios;

    @JsonProperty("Reserva")
    private boolean reserva;

    //caso dê erro no '@AllArgsConstructor'

    /*
    public CarroDisponivelDTO(Long id, float valorDiaria, ModeloCarro modeloCarro, Set<Acessorio> acessorios, boolean reserva) {
        this.id = id;
        this.valorDiaria = valorDiaria;
        this.modeloCarro = modeloCarro;
        this.acessorios = acessorios;
        this.reserva = reserva;
     */
}
