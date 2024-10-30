package br.com.car.carrental.payment.dto;

import br.com.car.carrental.payment.model.Status;

import java.math.BigDecimal;

public record PagamentoDTO(
        Long carrinhoId,
        Long driverId,
        BigDecimal valor,
        Status status) {}
