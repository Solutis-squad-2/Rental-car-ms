package com.example.Cart.Service;

import com.example.Cart.Model.DTO.CarrinhoDTO;
import com.example.Cart.Model.Entities.Carrinho;
import com.example.Cart.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Carro.Model.Entities.Carro;
import com.example.Carro.Service.CarroService;

import java.time.Duration;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarroService carroService;

    // Método para criar um novo carrinho
    public Carrinho criarCarrinho(CarrinhoDTO carrinhoDTO) {
        Carrinho carrinho = new Carrinho();
        carrinho.setClientId(carrinhoDTO.getClientId());

        // Aqui ajustamos o uso de orElseThrow
        Optional<Carro> carroOptional = Optional.ofNullable(carroService.findById(carrinhoDTO.getCarId()));
        if (carroOptional.isPresent()) {
            carrinho.setCarro(carroOptional.get());
        } else {
            throw new IllegalArgumentException("Carro não encontrado");
        }

        carrinho.setRentalStart(carrinhoDTO.getRentalStart());
        carrinho.setRentalEnd(carrinhoDTO.getRentalEnd());
        carrinho.setPrice(calcularPreco(carrinhoDTO));
        carrinho.setConfirmed(false);  // Carrinho ainda não confirmado
        return carrinhoRepository.save(carrinho);
    }

    // Método para buscar um carrinho pelo ID
    public Optional<Carrinho> getCarrinhoById(Long id) {
        return carrinhoRepository.findById(id);
    }

    // Método para calcular o preço da locação
    private Double calcularPreco(CarrinhoDTO carrinhoDTO) {
        long dias = Duration.between(carrinhoDTO.getRentalStart(), carrinhoDTO.getRentalEnd()).toDays();
        Optional<Carro> carroOptional = Optional.ofNullable(carroService.findById(carrinhoDTO.getCarId()));
        if (carroOptional.isPresent()) {
            Carro carro = carroOptional.get();
            return (double) (dias * carro.getValorDiaria());  // Multiplica os dias pelo valor da diária do carro
        } else {
            throw new IllegalArgumentException("Carro não encontrado");
        }
    }
}
