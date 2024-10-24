package com.example.Carro.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name ="carros")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private float valorDiaria;
    private boolean reserva ;

    @JsonProperty("Modelo do carro")
    @ManyToOne
    @JoinColumn(name = "modelo_id")  // Nome da coluna que armazenará o ID do modelo
    private ModeloCarro modeloCarro;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "carro_acessorio", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "carro_id"), // FK para Carro
            inverseJoinColumns = @JoinColumn(name = "acessorio_id") // FK para Acessorio
    )
    private Set<Acessorio> acessorios;

    private String urlImagem;

    public Carro(String placa, String chassi, String cor, float valorDiaria, boolean reserva, ModeloCarro modeloCarro) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.reserva = reserva;
        this.modeloCarro = modeloCarro;
    }
}
