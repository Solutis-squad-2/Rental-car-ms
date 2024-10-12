package br.com.car.carrental.driver.repository;

import br.com.car.carrental.driver.model.Motorista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista,Long> {
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    boolean existsByNumeroCNH(String numeroCNH);

    Optional<Motorista> findByEmail(String email);

    Page<Motorista> findAllByAtivoTrue(Pageable pageable);
}
