package com.example.Carro.Repository;

import com.example.Carro.Model.Entities.Carro;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    @EntityGraph(attributePaths = {"acessorios", "modeloCarro", "aluguel"})
    @Override
    Optional<Carro> findById(Long id);

    @Query("SELECT c FROM Carro c LEFT JOIN FETCH c.acessorios LEFT JOIN FETCH c.modeloCarro WHERE c.id = :id")
    Optional<Carro> findByIdWithAcessorios(@Param("id") Long id);
}
