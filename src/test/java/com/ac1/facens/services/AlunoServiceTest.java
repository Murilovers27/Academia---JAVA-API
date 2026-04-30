package com.ac1.facens.services;



import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.academia.facens.FacensApplication;
import com.academia.facens.dto.AlunoResponse;
import com.academia.facens.dto.PlanoResponse;
import com.academia.facens.dto.request.AlunoRequest;
import com.academia.facens.dto.request.PlanoRequest;
import com.academia.facens.services.AlunoService;
import com.academia.facens.services.PlanoService;

@SpringBootTest(classes = FacensApplication.class)
@Transactional
@Commit
class AlunoServiceTest {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PlanoService planoService;

    @Test
    void deveInserirAlunoNoBancoDeDados() {

        // cria plano real
        PlanoRequest planoRequest = new PlanoRequest();
        planoRequest.setNome("Plano Aluno Teste");
        planoRequest.setValor(120.0);

        PlanoResponse plano = planoService.cadastrar(planoRequest);

        // cria aluno real
        AlunoRequest alunoRequest = new AlunoRequest();
        alunoRequest.setNome("Aluno JUnit");
        alunoRequest.setEmail("aluno.junit@email.com");
        alunoRequest.setPlanoId(plano.getId());

        AlunoResponse aluno = alunoService.cadastrar(alunoRequest);

        assertThat(aluno.getId()).isNotNull();
        assertThat(aluno.getEmail()).isEqualTo("aluno.junit@email.com");
    }
}