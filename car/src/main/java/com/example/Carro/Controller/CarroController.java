package com.example.Carro.Controller;

import com.example.Carro.Model.DTO.CarroDTO;
import com.example.Carro.Model.DTO.CarroDisponivelDTO;
import com.example.Carro.Model.DTO.CategoriaDTO;
import com.example.Carro.Model.Entities.Carro;
import com.example.Carro.Model.Entities.Categoria;
import com.example.Carro.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    //Listar todos os carros
    @GetMapping
    public List<Carro> findAll() {
       return carroService.findAll();
    }


    //Listar Carros por ID
    @GetMapping(value = "/{id}")
    public Carro findById(@PathVariable Long id) {
       return carroService.findById(id);
    }

    //Listar carros disponiveis
    @GetMapping(value = "/disponiveis")
    public List<CarroDisponivelDTO> procurarCarrosDisponiveis() {
       return carroService.procurarCarrosDisponiveis();
    }

    @PatchMapping(value = "/reservar-carro/{id}")
    public ResponseEntity<String> reservarCarroPorId(@PathVariable Long id) {

        Carro carroASerReservado = carroService.findById(id);

       //Verifica se o carro existe
        if(carroASerReservado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }

        //Verifica se já está reservado
        if (carroASerReservado.isReserva()) {
            //Se já estiver, erro 409
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("O carro " + carroASerReservado.getModeloCarro().getNomeFabricante().getNome() + " "
                            + carroASerReservado.getModeloCarro().getDescricao()
                            + " " + carroASerReservado.getPlaca() + " já está reservado");
        } else {
            // Se estiver disponivel, reserva o carro
            carroService.reservarCarro(carroASerReservado);

            return ResponseEntity.ok("O carro " + carroASerReservado.getModeloCarro().getNomeFabricante().getNome() + " "
                    + carroASerReservado.getModeloCarro().getDescricao()
                    + " " + carroASerReservado.getPlaca() + " foi reservado com sucesso!");
        }
    }

    @PatchMapping(value = "/devolver-carro/{id}")
    public ResponseEntity<String> devolverCarroPorId(@PathVariable Long id) {
        Carro carroASerDevolvido = carroService.findById(id);

        // Verifica o carro
        if(carroASerDevolvido == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }

        // Verifica se o carro está reservado
        if (!carroASerDevolvido.isReserva()) {
            // Se não estiver reservado, erro 409
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("O carro " + carroASerDevolvido.getModeloCarro().getNomeFabricante().getNome() + " "
                            + carroASerDevolvido.getModeloCarro().getDescricao()
                            + " " + carroASerDevolvido.getPlaca() + " já está disponível.");
        } else {
            // Se estiver reservado, devolve o carro e marca como disponível
            carroService.devolverCarro(carroASerDevolvido);

            return ResponseEntity.ok("O carro " + carroASerDevolvido.getModeloCarro().getNomeFabricante().getNome() + " "
                    + carroASerDevolvido.getModeloCarro().getDescricao()
                    + " " + carroASerDevolvido.getPlaca() + " foi devolvido com sucesso!");
        }
    }

    //Busca por Categoria
    @GetMapping(value = "/categoria/{categoria}")
    public ResponseEntity<List<CategoriaDTO>> buscarPorCategoria(@PathVariable String categoria){

        Categoria categoriaEnum;

        try {
            categoriaEnum = Categoria.valueOf(categoria.toUpperCase());
        } catch (IllegalArgumentException e) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria inválida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        List<CategoriaDTO> lista = carroService.buscarPorCategoria(categoriaEnum);


        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }


    @GetMapping(value = "/acessoriosid/{id}")
    public ResponseEntity<List<Carro>> buscaCarrosPorIdAcessorio(@PathVariable Long id) {
        if( id == null || id <=0 ){
            return ResponseEntity.badRequest().body(null);
        }


        List<Carro> carrosComAcessorio = carroService.buscaCarrosPorIdAcessorio(id);


        if(carrosComAcessorio.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(carrosComAcessorio);

        }
    }

}
