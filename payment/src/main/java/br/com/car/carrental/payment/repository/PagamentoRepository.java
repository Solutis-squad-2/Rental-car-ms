package br.com.car.carrental.payment.repository;

import br.com.car.carrental.payment.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
