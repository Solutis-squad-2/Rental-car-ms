package com.example.Cart.config;

import com.example.Cart.Model.Entities.Carrinho;
import com.example.Cart.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class Seeds implements CommandLineRunner {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se o banco de dados já possui carrinhos
        if (carrinhoRepository.count() == 0) {
            List<Carrinho> carrinhos = List.of(
                    new Carrinho(1L, 1L, LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(5), 500.0, true),
                    new Carrinho(2L, 2L, LocalDateTime.now(), LocalDateTime.now().plusDays(3), 300.0, false)
                    // Adicione mais carrinhos conforme necessário
            );
            carrinhoRepository.saveAll(carrinhos);
        }
    }
}
