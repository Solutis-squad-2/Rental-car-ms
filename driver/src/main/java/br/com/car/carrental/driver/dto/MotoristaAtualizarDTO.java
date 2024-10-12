package br.com.car.carrental.driver.dto;

import br.com.car.carrental.driver.model.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record MotoristaAtualizarDTO(
        @NotNull(message = "ID é obrigatório")
        @Schema(description = "ID do motorista a ser atualizado.")
        Long id,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 80, message = "O nome deve ter entre 3 e 80 caracteres")
        @Schema(description = "Nome completo do motorista.")
        String nome,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Schema(description = "Data de nascimento do motorista.")
        LocalDate dataNascimento,

        @Column(unique = true)
        @NotBlank(message = "O CPF é obrigatório")
        @Schema(description = "CPF do motorista.")
        String cpf,

        @Column(unique = true)
        @NotBlank(message = "O e-mail é obrigatório")
        @Schema(description = "Endereço de email do motorista.")
        String email,

        @Column(unique = true)
        @NotBlank(message = "O número da CNH é obrigatório")
        @Schema(description = "Número da CNH do motorista.")
        String numeroCNH,

        @NotNull(message = "O sexo é obrigatório")
        @Schema(description = "Sexo do motorista.")
        Sexo sexo,

        Boolean ativo
) {

}
