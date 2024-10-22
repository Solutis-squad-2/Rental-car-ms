package com.example.Cart.http;

import com.example.Cart.Model.DTO.CarroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gateway")
public interface CarClient {
    @RequestMapping(method = RequestMethod.PUT, value = "/car-ms/carros/reservar-carro/{id}")
    void atualizaDisponibilidade(@PathVariable Long id);

    @GetMapping("/car-ms/carros/{id}")
    CarroDTO getCarro(@PathVariable("id") Long id);
}
