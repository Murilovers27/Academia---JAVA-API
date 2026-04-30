package com.academia.facens.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.academia.facens.dto.AlunoResponse;
import com.academia.facens.dto.request.AlunoRequest;
import com.academia.facens.entity.Aluno;
import com.academia.facens.entity.Plano;
import com.academia.facens.exception.RegraNegocioException;
import com.academia.facens.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final PlanoService planoService;

    public AlunoService(AlunoRepository alunoRepository, PlanoService planoService) {
        this.alunoRepository = alunoRepository;
        this.planoService = planoService;
    }

    public AlunoResponse cadastrar(AlunoRequest request) {

        if (alunoRepository.existsByEmail(request.getEmail())) {
            throw new RegraNegocioException("Email já cadastrado");
        }

        Plano plano = planoService.buscarPorId(request.getPlanoId());

        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setPlano(plano);

        Aluno salvo = alunoRepository.save(aluno);

        return new AlunoResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getPlano().getNome()
        );
    }

    public List<AlunoResponse> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(a -> new AlunoResponse(
                        a.getId(),
                        a.getNome(),
                        a.getEmail(),
                        a.getPlano().getNome()
                ))
                .collect(Collectors.toList());
    }
}