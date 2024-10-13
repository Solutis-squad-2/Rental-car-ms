package br.com.car.carrental.driver.service;

import br.com.car.carrental.driver.dto.MotoristaAtualizarDTO;
import br.com.car.carrental.driver.dto.MotoristaCadastroDTO;
import br.com.car.carrental.driver.dto.MotoristaDTO;
import br.com.car.carrental.driver.model.Motorista;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MotoristaService {
    @Transactional
    Motorista cadastrarMotorista(@Valid MotoristaCadastroDTO motorista);

    Motorista buscarPorId(Long id);

    @Transactional
    Motorista atualizarMotorista(@Valid MotoristaAtualizarDTO motorista);

    @Transactional
    void deletarMotorista(Long id);

    @Transactional
    void desativarMotorista(Long id);

    Page<MotoristaDTO> listar(Pageable paginacao);
}
