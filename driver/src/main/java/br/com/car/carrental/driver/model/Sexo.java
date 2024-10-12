package br.com.car.carrental.driver.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Sexo de uma pessoa.")
public enum Sexo {
    @Schema(description = "Masculino.")
    MASCULINO,

    @Schema(description = "Feminino.")
    FEMININO
}
