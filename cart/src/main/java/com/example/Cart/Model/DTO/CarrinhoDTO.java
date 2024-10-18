package com.example.Cart.Model.DTO;

import com.example.Cart.Model.Entities.Carrinho;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CarrinhoDTO {

    private Long clientId;
    private Long carId;
    private LocalDateTime rentalStart;
    private LocalDateTime rentalEnd;
    private Double price;

    public CarrinhoDTO(Carrinho carrinho) {
    }
}
