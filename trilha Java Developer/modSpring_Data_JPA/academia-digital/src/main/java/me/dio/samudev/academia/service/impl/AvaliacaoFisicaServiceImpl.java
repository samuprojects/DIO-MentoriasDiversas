package me.dio.samudev.academia.service.impl;

import me.dio.samudev.academia.entity.Aluno;
import me.dio.samudev.academia.entity.AvaliacaoFisica;
import me.dio.samudev.academia.entity.form.AvaliacaoFisicaForm;
import me.dio.samudev.academia.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.samudev.academia.repository.AlunoRepository;
import me.dio.samudev.academia.repository.AvaliacaoFisicaRepository;
import me.dio.samudev.academia.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + form.getAlunoId()));

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação Física não encontrada com ID: " + id));
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação Física não encontrada com ID: " + id));

        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação Física não encontrada com ID: " + id));
        avaliacaoFisicaRepository.delete(avaliacaoFisica);
    }
}