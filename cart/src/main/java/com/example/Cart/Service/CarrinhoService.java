package com.example.Carrinho.Service;

import com.example.Carrinho.Model.DTO.CarrinhoDTO;
import com.example.Carrinho.Model.Entities.Carrinho;
import com.example.Carrinho.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Carro.Model.Entities.Carro;
import com.example.Carro.Service.CarroService;


import java.time.Duration;
import java.util.NoSuchElementException;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarroService carroService;  // Supondo que você tenha um CarroService para acessar informações de carro

    public Carrinho criarCarrinho(CarrinhoDTO carrinhoDTO) {
        try {
            Carrinho carrinho = new Carrinho();
            carrinho.setClientId(carrinhoDTO.getClientId());
            carrinho.setCarro(carroService.getCarroById(carrinhoDTO.getCarId()));  // Obtenha o carro pelo ID
            carrinho.setRentalStart(carrinhoDTO.getRentalStart());
            carrinho.setRentalEnd(carrinhoDTO.getRentalEnd());
            carrinho.setPrice(calcularPreco(carrinhoDTO));
            carrinho.setConfirmed(false);  // Carrinho ainda não confirmado
            return carrinhoRepository.save(carrinho);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Carro ou cliente não encontrados");
        }
    }

    private Double calcularPreco(CarrinhoDTO carrinhoDTO) {
        long dias = Duration.between(carrinhoDTO.getRentalStart(), carrinhoDTO.getRentalEnd()).toDays();
        Carro carro = carroService.getCarroById(carrinhoDTO.getCarId());
        return dias * carro.getValorDiaria();  // Multiplica os dias pelo valor da diária do carro
    }
}
