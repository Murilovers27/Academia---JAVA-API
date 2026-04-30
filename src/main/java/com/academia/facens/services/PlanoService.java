package com.academia.facens.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.academia.facens.dto.PlanoResponse;
import com.academia.facens.entity.Plano;
import com.academia.facens.exception.RecursoNaoEncontradoException;
import com.academia.facens.repository.PlanoRepository;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public PlanoResponse cadastrar(PlanoResponse request) {

        if (request.getNome() == null || request.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do plano é obrigatório");
        }

        if (request.getValor() == null || request.getValor() <= 0) {
            throw new IllegalArgumentException("Valor do plano deve ser maior que zero");
        }

        Plano plano = new Plano();
        plano.setNome(request.getNome());
        plano.setValor(request.getValor());

        Plano salvo = planoRepository.save(plano);

        return new PlanoResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getValor()
        );
    }

    public List<PlanoResponse> listarTodos() {
        return planoRepository.findAll()
                .stream()
                .map(p -> new PlanoResponse(p.getId(), p.getNome(), p.getValor()))
                .collect(Collectors.toList());
    }

    public Plano buscarPorId(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Plano não encontrado"));
    }
}