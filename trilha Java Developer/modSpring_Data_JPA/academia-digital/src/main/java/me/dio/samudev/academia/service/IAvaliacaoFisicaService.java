package me.dio.samudev.academia.service;

import me.dio.samudev.academia.entity.AvaliacaoFisica;
import me.dio.samudev.academia.entity.form.AvaliacaoFisicaForm;
import me.dio.samudev.academia.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisica create(AvaliacaoFisicaForm form);

    AvaliacaoFisica get(Long id);

    List<AvaliacaoFisica> getAll();

    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);

    void delete(Long id);
}