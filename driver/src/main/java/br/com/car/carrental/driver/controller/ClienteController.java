package br.com.car.carrental.driver.controller;




import br.com.car.carrental.driver.dto.MotoristaDTO;
import br.com.car.carrental.driver.model.Motorista;
import br.com.car.carrental.driver.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Cliente Controller", description = "Controller para gerenciamento de clientes (motoristas)")
public class ClienteController {

    @Autowired
    private MotoristaService motoristaService;




    @PostMapping
    @Operation(summary = "Cadastrar um novo cliente", description = "Cria um novo cliente com os dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados de cadastro inválidos.")
    })
    public ResponseEntity<MotoristaDTO> cadastrar(
            @RequestBody @Valid MotoristaDTO dadosCadastroMotorista,
            UriComponentsBuilder uriBuilder
    ) {
        var motorista = motoristaService.cadastrarMotorista(dadosCadastroMotorista);
        var uri = uriBuilder.path("/api/v1/cliente/{id}").buildAndExpand(motorista.getId()).toUri();
        return ResponseEntity.created(uri).body(new MotoristaDTO(motorista));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Detalhar um cliente", description = "Retorna os detalhes de um cliente específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    public ResponseEntity<MotoristaDTO> detalhar(@PathVariable Long id) {
        Motorista motorista = motoristaService.buscarPorId(id);
        MotoristaDTO dto = new MotoristaDTO(motorista);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    @Operation(summary = "Listar clientes", description = "Retorna uma lista paginada de clientes.")
    @ApiResponse(responseCode = "200", description = "Lista de clientes.")
    public ResponseEntity<Page<MotoristaDTO>> listar(@PageableDefault(size = 20, sort = {"nome"}) Pageable paginacao) {
        var motoristas = motoristaService.listar(paginacao);
        return ResponseEntity.ok(motoristas);
    }

    @Transactional
    @PatchMapping
    @Operation(summary = "Atualizar alguns dados do cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Dados de atualização inválidos."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    public ResponseEntity<MotoristaDTO> atualizar(@RequestBody @Valid MotoristaDTO dadosAtualizacaoMotorista) {
        Motorista motorista = motoristaService.atualizarMotorista(dadosAtualizacaoMotorista);
        MotoristaDTO motoristaDTO = new MotoristaDTO(motorista);
        return ResponseEntity.ok(motoristaDTO);
    }

    @Transactional
    @PatchMapping("/{id}")
    @Operation(summary = "Desativar um cliente, impedindo-o de realizar novos aluguéis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente desativado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        motoristaService.desativarMotorista(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um cliente da base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado.")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return ResponseEntity.noContent().build();
    }
}