package com.example.swaggertest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.swaggertest.entity.TurmaEntity;
import com.example.swaggertest.service.TurmaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    @Operation(summary = "Listar todas as turmas", description = "Listagem de Turmas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<List<TurmaEntity>> getAll() {
        List<TurmaEntity> turmas = turmaService.getAll();
        if (!turmas.isEmpty())
            return new ResponseEntity<>(turmas, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar turma por ID", description = "Busca de uma turma específica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<TurmaEntity> getById(@PathVariable Integer id) {
        TurmaEntity turma = turmaService.getById(id);
        if (turma != null)
            return new ResponseEntity<>(turma, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Criar uma nova turma", description = "Criação de uma nova turma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Turma criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida")
    })
    public ResponseEntity<TurmaEntity> saveTurma(@RequestBody TurmaEntity turma) {
        return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma turma", description = "Atualização de uma turma existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turma atualizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<TurmaEntity> updateTurma(@PathVariable Integer id, @RequestBody TurmaEntity turma) {
        TurmaEntity turmaAtualizada = turmaService.updateTurma(id, turma);
        if (turmaAtualizada != null)
            return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma turma", description = "Deleção de uma turma existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turma deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")
    })
    public ResponseEntity<Boolean> deleteTurma(@PathVariable Integer id) {
        if (turmaService.deleteTurma(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
