package br.com.car.carrental.driver.dto;

import br.com.car.carrental.driver.model.Motorista;
import br.com.car.carrental.driver.model.Sexo;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record MotoristaCadastroDTO(
        String nome,
        String email,
        LocalDate dataNascimento,
        @NotNull(message = "O CPF é obrigatório.")
        String cpf,
        Sexo sexo,
        Boolean ativo,
        String numeroCNH
) {


    public  MotoristaCadastroDTO (Motorista motorista) {
        this(
                motorista.getNome(),
                motorista.getEmail(),
                motorista.getDataNascimento(),
                motorista.getCpf(),
                motorista.getSexo(),
                motorista.getAtivo(),
                motorista.getNumeroCNH()
        );
    }
}

