package com.example.Carrinho.Controller;

import com.example.Carrinho.Model.DTO.CarrinhoDTO;
import com.example.Carrinho.Model.Entities.Carrinho;
import com.example.Carrinho.Service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public ResponseEntity<Carrinho> criarCarrinho(@RequestBody CarrinhoDTO carrinhoDTO) {
        Carrinho novoCarrinho = carrinhoService.criarCarrinho(carrinhoDTO);
        return new ResponseEntity<>(novoCarrinho, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> buscarCarrinho(@PathVariable Long id) {
        try {
            Carrinho carrinho = carrinhoService.getCarrinhoById(id);  // Implemente este método no service
            return ResponseEntity.ok(carrinho);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
