package com.ac1.facens.services;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.academia.facens.FacensApplication;
import com.academia.facens.dto.PlanoResponse;
import com.academia.facens.dto.request.PlanoRequest;
import com.academia.facens.services.PlanoService;

import jakarta.transaction.Transactional;

@SpringBootTest(classes = FacensApplication.class)
@Transactional
@Commit
class PlanoServiceTest {

    @Autowired
    private PlanoService planoService;

    @Test
    void deveInserirPlanoNoBancoDeDados() {

        PlanoRequest request = new PlanoRequest();
        request.setNome("Plano Teste JUnit");
        request.setValor(150.0);

        PlanoResponse response = planoService.cadastrar(request);

        assertThat(response.getId()).isNotNull();
        assertThat(response.getNome()).isEqualTo("Plano Teste JUnit");
    }
}