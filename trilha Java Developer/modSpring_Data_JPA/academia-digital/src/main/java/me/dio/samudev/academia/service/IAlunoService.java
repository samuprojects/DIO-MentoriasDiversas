package me.dio.samudev.academia.service;

import me.dio.samudev.academia.entity.Aluno;
import me.dio.samudev.academia.entity.AvaliacaoFisica;
import me.dio.samudev.academia.entity.form.AlunoForm;
import me.dio.samudev.academia.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {

    Aluno create(AlunoForm form);

    Aluno get(Long id);

    List<Aluno> getAll(String dataDeNascimento);

    Aluno update(Long id, AlunoUpdateForm formUpdate);

    void delete(Long id);

    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);


}