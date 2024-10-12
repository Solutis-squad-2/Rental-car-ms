package br.com.car.carrental.driver.dto;

import br.com.car.carrental.driver.model.Motorista;
import br.com.car.carrental.driver.model.Sexo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MotoristaDTO(
        Long id,
        String nome,
        String email,
        LocalDate dataNascimento,
        @NotNull(message = "O CPF é obrigatório.")
        String cpf,
        Sexo sexo,
        Boolean ativo,
        LocalDateTime dataCreated,
        LocalDateTime lastUpdated,
        String numeroCNH
) {


    public  MotoristaDTO (Motorista motorista) {
        this(
                motorista.getId(),
                motorista.getNome(),
                motorista.getEmail(),
                motorista.getDataNascimento(),
                motorista.getCpf(),
                motorista.getSexo(),
                motorista.getAtivo(),
                motorista.getDataCreated(),
                motorista.getLastUpdated(),
                motorista.getNumeroCNH()
        );
    }
}
