package com.example.Carro.Repository;

import com.example.Carro.Model.Entities.Categoria;
import com.example.Carro.Model.Entities.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {

    List<ModeloCarro> findByCategoria(Categoria categoria);
}
