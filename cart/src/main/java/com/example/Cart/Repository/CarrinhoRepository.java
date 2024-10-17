package com.example.Carrinho.Repository;

import com.example.Carrinho.Model.Entities.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
