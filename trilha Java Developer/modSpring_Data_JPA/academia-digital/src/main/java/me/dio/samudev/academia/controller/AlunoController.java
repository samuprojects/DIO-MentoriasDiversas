package me.dio.samudev.academia.controller;

import jakarta.validation.Valid;
import me.dio.samudev.academia.entity.Aluno;
import me.dio.samudev.academia.entity.AvaliacaoFisica;
import me.dio.samudev.academia.entity.form.AlunoForm;
import me.dio.samudev.academia.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                              String dataDeNascimento){
        return service.getAll(dataDeNascimento);
    }
}
