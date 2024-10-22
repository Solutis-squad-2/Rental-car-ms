package com.example.Cart.http;

import com.example.Cart.Model.DTO.DriverDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("driver-ms")
public interface DriverClient {

    @GetMapping("/cliente/{id]")
    DriverDTO getDriver(@PathVariable("id") Long id);
}
