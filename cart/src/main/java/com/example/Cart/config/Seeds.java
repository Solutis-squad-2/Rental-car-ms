package com.example.Cart.config;

import com.example.Cart.Model.Entities.Carrinho;
import com.example.Cart.Repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class Seeds {

    @Autowired
    private CarrinhoRepository carrinhoRepository;


}
