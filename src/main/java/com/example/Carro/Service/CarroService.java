package com.example.Carro.Service;

import com.example.Carro.Model.DTO.CarroDTO;
import com.example.Carro.Model.DTO.CarroDisponivelDTO;
import com.example.Carro.Model.DTO.CategoriaDTO;
import com.example.Carro.Model.Entities.Acessorio;
import com.example.Carro.Model.Entities.Carro;
import com.example.Carro.Model.Entities.ModeloCarro;
import com.example.Carro.Repository.AcessorioRepository;
import com.example.Carro.Repository.CarroRepository;
import com.example.Carro.Repository.ModeloCarroRepository;
import com.example.Carro.Model.Entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public Carro findById(Long id) {
        return carroRepository.findByIdWithAcessorios(id).orElse(null);
    }

    public List<CarroDisponivelDTO> procurarCarrosDisponiveis() {
        List<Carro> todosOsCarros = findAll();
        List<CarroDisponivelDTO> carrosDisponiveis = new ArrayList<>();

        for (Carro carro : todosOsCarros) {
            if (!carro.isReserva()) {
                CarroDisponivelDTO dto = new CarroDisponivelDTO(
                        carro.getId(),
                        carro.getValorDiaria(),
                        carro.getModeloCarro(),
                        carro.getAcessorios(),
                        carro.isReserva()
                );
                carrosDisponiveis.add(dto);
            }
        }

        return carrosDisponiveis;
    }

    public void reservarCarro(Carro carro) {
        carro.setReserva(true);
        carroRepository.save(carro);
    }

    public void devolverCarro(Carro carro) {
        carro.setReserva(false);
        carroRepository.save(carro);
    }

    public List<CategoriaDTO> buscarPorCategoria(Categoria categoria) {
        List<ModeloCarro> carrosPorCategoria = modeloCarroRepository.findByCategoria(categoria);
        List<CategoriaDTO> lista = new ArrayList<>();

        for (ModeloCarro carros : carrosPorCategoria) {
            CategoriaDTO dto = new CategoriaDTO(
                    carros.getDescricao(),
                    carros.getNomeFabricante(),
                    carros.getCategoria(),
                    carros.getId()
                        );
            lista.add(dto);
        }

        return lista;
    }

    public List<Carro> buscaCarrosPorIdAcessorio(Long id) {
        List<Carro> carrosComAcessorio = new ArrayList<>();
        List<Carro> todosCarros = findAll();

        for (Carro carro : todosCarros) {
            for (Acessorio acessorio : carro.getAcessorios()) {
                if (acessorio.getId().equals(id)) {
                    carrosComAcessorio.add(carro);
                    break;
                }
            }
        }

        return carrosComAcessorio;
    }
}
