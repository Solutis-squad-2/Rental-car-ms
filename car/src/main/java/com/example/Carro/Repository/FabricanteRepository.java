package com.example.Carro.Repository;

import com.example.Carro.Model.Entities.Carro;
import com.example.Carro.Model.Entities.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
