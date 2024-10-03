package me.dio.samudev.academia.service;

import me.dio.samudev.academia.entity.Matricula;
import me.dio.samudev.academia.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {

    Matricula create(MatriculaForm form);

    Matricula get(Long id);

    List<Matricula> getAll(String bairro);

    void delete(Long id);

}