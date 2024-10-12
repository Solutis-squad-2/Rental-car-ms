package br.com.car.carrental.driver.model;

import br.com.car.carrental.driver.dto.MotoristaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

import static java.time.LocalDateTime.now;
import static java.util.Optional.ofNullable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "Motorista")
@Table(
        name = "tb_motorista",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_motorista_numero_cnh", columnNames = "numerocnh"),
        }
)
public class Motorista extends Pessoa{

    @Column(nullable = false)
    @Schema(description = "Número da Carteira Nacional de Habilitação (CNH) do motorista.")
    private String numeroCNH;

    public Motorista(@Valid MotoristaDTO motoristaDTO) {
        this.setNome(motoristaDTO.nome());
        this.setDataNascimento(motoristaDTO.dataNascimento());
        this.setCpf(motoristaDTO.cpf());
        this.setEmail(motoristaDTO.email());
        this.setSexo(motoristaDTO.sexo());
        this.setLastUpdated(now());
        this.setAtivo(true);
        this.numeroCNH = motoristaDTO.numeroCNH();
    }

    public void atualizarInformacoes(@Valid MotoristaDTO dadosAtualizacaoMotorista) {
        ofNullable(dadosAtualizacaoMotorista.nome()).ifPresent(this::setNome);
        ofNullable(dadosAtualizacaoMotorista.dataNascimento()).ifPresent(this::setDataNascimento);
        ofNullable(dadosAtualizacaoMotorista.email()).ifPresent(this::setEmail);
        ofNullable(dadosAtualizacaoMotorista.sexo()).ifPresent(this::setSexo);
        ofNullable(dadosAtualizacaoMotorista.numeroCNH()).ifPresent(value -> this.numeroCNH = value);
        ofNullable(dadosAtualizacaoMotorista.cpf()).ifPresent(this::setCpf);
        this.setLastUpdated(now());
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Motorista motorista = (Motorista) o;
        return getId() != null && Objects.equals(getId(), motorista.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
