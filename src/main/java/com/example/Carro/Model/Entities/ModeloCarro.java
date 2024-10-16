package com.example.Carro.Model.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelos_carro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModeloCarro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante nomeFabricante;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
