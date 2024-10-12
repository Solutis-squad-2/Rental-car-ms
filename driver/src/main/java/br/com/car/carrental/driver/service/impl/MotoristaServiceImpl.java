package br.com.car.carrental.driver.service.impl;

import br.com.car.carrental.driver.dto.MotoristaDTO;
import br.com.car.carrental.driver.model.Motorista;
import br.com.car.carrental.driver.repository.MotoristaRepository;
import br.com.car.carrental.driver.service.MotoristaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static org.slf4j.LoggerFactory.getLogger;

@Service
public class MotoristaServiceImpl implements MotoristaService {

    private static final Logger log = getLogger(MotoristaServiceImpl.class);

    @Autowired
    private MotoristaRepository motoristaRepository;


    @Override
    public Motorista cadastrarMotorista(@Valid MotoristaDTO motoristaDTO) {
        Motorista motorista = new Motorista(motoristaDTO);
        motoristaRepository.save(motorista);
        log.info("Motorista cadastrado com sucesso: {}", motorista);
        return motorista;
    }

    @Override
    public Motorista buscarPorId(Long id) {
        log.info("Buscando motorista por ID: {}", id);
        Motorista motorista = existeMotoristaPeloId(id);
        log.info("Motorista encontrado: {}", motorista);
        return motorista;
    }



    @Override
    @Transactional
    public Motorista atualizarMotorista(@Valid MotoristaDTO motoristaDTO) {
        log.info("Atualizando motorista com dados: {}", motoristaDTO);

        Motorista motorista = new Motorista(motoristaDTO);
        log.info("Motorista encontrado para atualização: {}", motorista);
        motoristaRepository.save(motorista);
        log.info("Motorista atualizado com sucesso: {}", motorista);
        return motorista;
    }

    @Override
    @Transactional
    public void deletarMotorista(Long id) {
        log.info("Deletando motorista com ID: {}", id);
        Motorista motorista = existeMotoristaPeloId(id); // Busca o motorista pelo ID

        log.info("Motorista encontrado para deleção: {}", motorista);
        motoristaRepository.delete(motorista); // Usa delete(motorista) para deletar o objeto
        log.info("Motorista deletado com sucesso: {}", id);
    }

    @Override
    @Transactional
    public void desativarMotorista(Long id) {
        log.info("Desativando motorista com ID: {}", id);

        Motorista motorista = existeMotoristaPeloId(id);
        log.info("Motorista encontrado para desativação: {}", motorista);

        motorista.desativar();

        motoristaRepository.save(motorista);
        log.info("Motorista desativado com sucesso: {}", motorista);
    }

    @Override
    public Page<MotoristaDTO> listar(Pageable paginacao) {
        return motoristaRepository
                .findAllByAtivoTrue(paginacao)
                .map(MotoristaDTO::new);
    }

    private Motorista existeMotoristaPeloId(Long id) {
        return motoristaRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Motorista não encontrado para desativação: {}", id);
                    return new EntityNotFoundException("Motorista não encontrado");
                });
    }




}