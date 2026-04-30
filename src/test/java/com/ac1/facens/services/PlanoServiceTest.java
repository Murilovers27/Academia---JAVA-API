package com.ac1.facens.services;
import com.academia.facens.FacensApplication;
import com.academia.facens.dto.request.PlanoRequest;
import com.academia.facens.entity.Plano;
import com.academia.facens.repository.PlanoRepository;
import com.academia.facens.services.PlanoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = FacensApplication.class)
class PlanoServiceTest {

    @Autowired
    private PlanoService planoService;

    @MockBean
    private PlanoRepository planoRepository;

    @Test
    void deveCadastrarPlanoComSucesso() {

        // 1️⃣ Entrada simulada (request)
        PlanoRequest request = new PlanoRequest();
        request.setNome("Mensal");
        request.setValor(100.0);

        // 2️⃣ Objeto que o repository "fingirá" salvar
        Plano planoSalvo = new Plano();
        planoSalvo.setId(1L);
        planoSalvo.setNome("Mensal");
        planoSalvo.setValor(100.0);

        // 3️⃣ Configuração do mock
        when(planoRepository.save(any())).thenReturn(planoSalvo);

        // 4️⃣ Execução do método testado
        var response = planoService.cadastrar(request);

        // 5️⃣ Verificações (asserts)
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getNome()).isEqualTo("Mensal");
        assertThat(response.getValor()).isEqualTo(100.0);
    }
}