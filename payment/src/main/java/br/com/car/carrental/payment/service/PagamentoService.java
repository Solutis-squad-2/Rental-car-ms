package br.com.car.carrental.payment.service;

import br.com.car.carrental.payment.dto.PagamentoDTO;
import br.com.car.carrental.payment.model.Pagamento;
import br.com.car.carrental.payment.model.Status;
import br.com.car.carrental.payment.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public PagamentoDTO realizarPagamento(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setCarrinhoId(pagamentoDTO.carrinhoId());
        pagamento.setDriverId(pagamentoDTO.driverId());
        pagamento.setValor(pagamentoDTO.valor());
        pagamento.setStatus(Status.CONFIRMADO);

        pagamentoRepository.save(pagamento);


        return new PagamentoDTO(pagamento.getCarrinhoId(), pagamento.getDriverId(), pagamento.getValor(), pagamento.getStatus());
    }
}
