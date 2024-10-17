package com.example.Carro.config;

import com.example.Carro.Model.Entities.*;
import com.example.Carro.Repository.AcessorioRepository;
import com.example.Carro.Repository.FabricanteRepository;
import com.example.Carro.Repository.ModeloCarroRepository;
import com.example.Carro.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Seeds implements CommandLineRunner {

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public void run(String... args) throws Exception {
        // Inserindo fabricantes caso não existam
        if (fabricanteRepository.count() == 0) {
            List<Fabricante> fabricantes = Arrays.asList(
                    new Fabricante("Toyota"),
                    new Fabricante("Honda"),
                    new Fabricante("Ford"),
                    new Fabricante("Chevrolet"),
                    new Fabricante("Nissan"),
                    new Fabricante("Volkswagen"),
                    new Fabricante("Hyundai"),
                    new Fabricante("Kia"),
                    new Fabricante("BMW"),
                    new Fabricante("Mercedes-Benz")
            );
            fabricanteRepository.saveAll(fabricantes);
        }

        // Recupera a lista de fabricantes já existentes
        List<Fabricante> fabricantes = fabricanteRepository.findAll();

        // Inserindo acessórios
        if (acessorioRepository.count() == 0) {
            Acessorio[] acessorios = {
                    new Acessorio("Ar Condicionado"),
                    new Acessorio("Airbags"),
                    new Acessorio("Trava Elétrica"),
                    new Acessorio("Vidros Elétricos"),
                    new Acessorio("Direção Hidráulica"),
                    new Acessorio("Sensor de Estacionamento"),
                    new Acessorio("Câmera de Ré"),
                    new Acessorio("Faróis de Neblina"),
                    new Acessorio("Rodas de Liga Leve"),
                    new Acessorio("Sistema de Som")
            };
            acessorioRepository.saveAll(Arrays.asList(acessorios));
        }

        // Inserindo modelos de carro, utilizando os fabricantes carregados anteriormente
        if (modeloCarroRepository.count() == 0) {
            ModeloCarro[] modelos = {
                    new ModeloCarro(Categoria.SEDAN_GRANDE, "Camry", fabricantes.get(0)),
                    new ModeloCarro(Categoria.HATCH_COMPACTO, "Fit", fabricantes.get(1)),
                    new ModeloCarro(Categoria.ESPORTIVO, "Mustang", fabricantes.get(2)),
                    new ModeloCarro(Categoria.SEDAN_MEDIO, "Onix", fabricantes.get(3)),
                    new ModeloCarro(Categoria.UTILITARIO_COMERCIAL, "NV3500", fabricantes.get(4)),
                    new ModeloCarro(Categoria.SEDAN_COMPACTO, "Jetta", fabricantes.get(5)),
                    new ModeloCarro(Categoria.HATCH_MEDIO, "Elantra", fabricantes.get(6)),
                    new ModeloCarro(Categoria.SEDAN_GRANDE, "Optima", fabricantes.get(7)),
                    new ModeloCarro(Categoria.ESPORTIVO, "Z4", fabricantes.get(8)),
                    new ModeloCarro(Categoria.SEDAN_GRANDE, "S-Class", fabricantes.get(9))
            };
            modeloCarroRepository.saveAll(Arrays.asList(modelos));
        }

        // Recupera a lista de modelos já existentes
        List<ModeloCarro> modelos = modeloCarroRepository.findAll();

        // Inserindo carros, utilizando os modelos carregados anteriormente
        if (carroRepository.count() == 0) {
            Carro[] carros = {
                    new Carro("ABC1234", "1HGBH41JXMN109186", "Preto", 150.00f, true, modelos.get(0)),
                    new Carro("DEF5678", "2HGEJ6672WH542178", "Branco", 100.00f, false, modelos.get(1)),
                    new Carro("GHI9012", "3FAFP40367R186493", "Vermelho", 250.00f, true, modelos.get(2)),
                    new Carro("JKL3456", "1G1BC5SM7H7123456", "Azul", 120.00f, false, modelos.get(3))
                    // Adicione mais carros conforme necessário
            };
            carroRepository.saveAll(Arrays.asList(carros));
        }
    }
}
