package com.example.Cart.Service;

import com.example.Cart.Model.DTO.AluguelDTO;
import com.example.Cart.Model.DTO.CarrinhoDTO;
import com.example.Cart.Model.DTO.CarroDTO;
import com.example.Cart.Model.Entities.Carrinho;
import com.example.Cart.Repository.CarrinhoRepository;
import com.example.Cart.http.CarClient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarClient carClient;

    // Método para criar um novo carrinho
    public CarrinhoDTO criarCarrinho(AluguelDTO aluguelDTO) {

        CarroDTO carroDTO = carClient.getCarro(aluguelDTO.idCarro());
        Carrinho carrinho = new Carrinho();
        carrinho.setClientId(aluguelDTO.idCliente());
        carrinho.setCarroId(aluguelDTO.idCarro());

        carrinho.setRentalStart(LocalDateTime.now());
        carrinho.setRentalEnd(aluguelDTO.rentalEnd());
        carrinho.setPrice(10d);
        carrinho.setConfirmed(false);
        carrinhoRepository.save(carrinho);
        CarrinhoDTO carrinhoDTO = new CarrinhoDTO(
                carrinho.getClientId(),
                carrinho.getRentalStart(),
                carrinho.getRentalEnd(),
                carrinho.getPrice(),
                carroDTO // Adicione o carro ao DTO se necessário.
        );
        return carrinhoDTO;
    }

    // Método para buscar um carrinho pelo ID
    public Optional<CarrinhoDTO> getCarrinhoById(Long id) {
        Optional<Carrinho> optionalCarrinho = carrinhoRepository.findById(id);
        if (optionalCarrinho.isPresent()) {
            Carrinho carrinho = optionalCarrinho.get();
            CarroDTO carro = carClient.getCarro(carrinho.getCarroId()); // Certifique-se de que este método também retorne o que você espera.
            CarrinhoDTO carrinhoDTO = new CarrinhoDTO(
                    carrinho.getClientId(),
                    carrinho.getRentalStart(),
                    carrinho.getRentalEnd(),
                    carrinho.getPrice(),
                    carro // Adicione o carro ao DTO se necessário.
            );
            return Optional.of(carrinhoDTO);
        } else {
            return Optional.empty(); // Retorne um Optional vazio se o carrinho não for encontrado.
        }
    }

    // Método para calcular o preço da locação
    private Double calcularPreco(Carrinho c, CarroDTO carroDTO) {
        long dias = Duration.between(c.getRentalStart(), c.getRentalEnd()).toDays();


        return (double) (dias * carroDTO.valorDiaria());  // Multiplica os dias pelo valor da diária do carro

    }
}
