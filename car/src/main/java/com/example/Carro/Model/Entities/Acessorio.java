package com.example.Carro.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "acessorio")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Acessorio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String descricao;

        // Relação muitos-para-muitos com Carro (mapeada do outro lado)
        @ManyToMany(mappedBy = "acessorios")
        @JsonIgnore
        private Set<Carro> carros;
}
