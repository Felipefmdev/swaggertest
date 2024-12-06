package com.example.swaggertest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.swaggertest.entity.InstrutorEntity;
import com.example.swaggertest.service.InstrutorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    @Operation(summary = "Listar todos os instrutores", description = "Listagem de Instrutores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<List<InstrutorEntity>> getAll() {
        List<InstrutorEntity> instrutores = instrutorService.getAll();
        if (!instrutores.isEmpty())
            return new ResponseEntity<>(instrutores, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar instrutor por ID", description = "Busca de um instrutor específico pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<InstrutorEntity> getById(@PathVariable Integer id) {
        InstrutorEntity instrutor = instrutorService.getById(id);
        if (instrutor != null)
            return new ResponseEntity<>(instrutor, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Criar um novo instrutor", description = "Criação de um novo instrutor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Instrutor criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida")
    })
    public ResponseEntity<InstrutorEntity> saveInstrutor(@RequestBody InstrutorEntity instrutor) {
        return new ResponseEntity<>(instrutorService.saveInstrutor(instrutor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um instrutor", description = "Atualização de um instrutor existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instrutor atualizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<InstrutorEntity> updateInstrutor(@PathVariable Integer id, @RequestBody InstrutorEntity instrutor) {
        InstrutorEntity instrutorAtualizado = instrutorService.updateInstrutor(id, instrutor);
        if (instrutorAtualizado != null)
            return new ResponseEntity<>(instrutorAtualizado, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um instrutor", description = "Deleção de um instrutor existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instrutor deletado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<Boolean> deleteInstrutor(@PathVariable Integer id) {
        if (instrutorService.deleteInstrutor(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
