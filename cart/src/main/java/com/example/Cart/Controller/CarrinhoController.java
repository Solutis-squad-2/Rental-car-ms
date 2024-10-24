package com.example.Cart.Controller;

import com.example.Cart.Model.DTO.AluguelDTO;
import com.example.Cart.Model.DTO.CarrinhoDTO;
import com.example.Cart.Model.Entities.Carrinho;
import com.example.Cart.Service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    // Endpoint para buscar um carrinho pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoDTO> getCarrinhoById(@PathVariable Long id) {
        return carrinhoService.getCarrinhoById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NoSuchElementException("Carrinho não encontrado"));
    }

    // Endpoint para criar um novo carrinho
    @PostMapping
    public ResponseEntity<CarrinhoDTO> criarCarrinho(@RequestBody AluguelDTO carrinhoDTO) {
        CarrinhoDTO carrinho = carrinhoService.criarCarrinho(carrinhoDTO);
        return ResponseEntity.ok(carrinho);
    }
}
