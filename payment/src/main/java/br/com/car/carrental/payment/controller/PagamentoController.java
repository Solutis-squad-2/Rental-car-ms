package br.com.car.carrental.payment.controller;

import br.com.car.carrental.payment.dto.PagamentoDTO;
import br.com.car.carrental.payment.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoDTO> realizarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        PagamentoDTO pagamento = pagamentoService.realizarPagamento(pagamentoDTO);
        return ResponseEntity.ok(pagamento);
    }
}
