# 🏋️ Academia – JAVA API
# Projeto Academia — Spring Boot

## 📌 Descrição

Aplicação backend desenvolvida com **Spring Boot**, aplicando boas práticas de arquitetura em camadas, uso de **DTOs**, **JPA/Hibernate**, **tratamento de exceções** e **testes automatizados**.

O sistema gerencia **Planos** e **Alunos**, obedecendo regras de negócio definidas.

---

## 🏗️ Estrutura do Projeto

<details>
<summary><strong>Clique para expandir a estrutura completa do projeto</strong></summary>

```text
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── academia
│   │   │           └── facens
│   │   │               ├── conexãoBD
│   │   │               │   └── ConexãoDB.java
│   │   │               ├── dto
│   │   │               │   ├── AlunoResponse.java
│   │   │               │   ├── PlanoResponse.java
│   │   │               │   └── request
│   │   │               │       ├── AlunoRequest.java
│   │   │               │       └── PlanoRequest.java
│   │   │               ├── entity
│   │   │               │   ├── Aluno.java
│   │   │               │   └── Plano.java
│   │   │               ├── exception
│   │   │               │   ├── RecursoNaoEncontradoException.java
│   │   │               │   └── RegraNegocioException.java
│   │   │               ├── FacensApplication.java
│   │   │               ├── repository
│   │   │               │   ├── AlunoRepository.java
│   │   │               │   └── PlanoRepository.java
│   │   │               └── services
│   │   │                   ├── AlunoService.java
│   │   │                   └── PlanoService.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── ac1
│                   └── facens
│                       ├── ContextLoadTest.java
│                       ├── FacensApplicationTests.java
│                       ├── repository
│                       └── services
│                           └── PlanoServiceTest.java
└── target
    ├── classes
    │   ├── application.properties
    │   └── com
    │       └── academia
    │           └── facens
    │               ├── conexãoBD
    │               │   └── ConexãoDB.class
    │               ├── dto
    │               │   ├── AlunoResponse.class
    │               │   ├── PlanoResponse.class
    │               │   └── request
    │               │       ├── AlunoRequest.class
    │               │       └── PlanoRequest.class
    │               ├── entity
    │               │   ├── Aluno.class
    │               │   └── Plano.class
    │               ├── exception
    │               │   ├── RecursoNaoEncontradoException.class
    │               │   └── RegraNegocioException.class
    │               ├── FacensApplication.class
    │               ├── repository
    │               │   ├── AlunoRepository.class
    │               │   └── PlanoRepository.class
    │               └── services
    │                   ├── AlunoService.class
    │                   └── PlanoService.class
    ├── generated-sources
    │   └── annotations
    ├── generated-test-sources
    │   └── test-annotations
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       │   └── default-compile
    │       │       ├── createdFiles.lst
    │       │       └── inputFiles.lst
    │       └── testCompile
    │           └── default-testCompile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── surefire-reports
    │   ├── com.ac1.facens.ContextLoadTest.txt
    │   ├── com.ac1.facens.FacensApplicationTests.txt
    │   ├── com.ac1.facens.services.PlanoServiceTest.txt
    │   ├── TEST-com.ac1.facens.ContextLoadTest.xml
    │   ├── TEST-com.ac1.facens.FacensApplicationTests.xml
    │   └── TEST-com.ac1.facens.services.PlanoServiceTest.xml
    └── test-classes
        └── com
            └── ac1
                └── facens
                    ├── ContextLoadTest.class
                    ├── FacensApplicationTests.class
                    └── services
                        └── PlanoServiceTest.class

52 directories, 51 files
``
</details>

---

## 🧩 Explicação do Código (resumida)

### 📦 Entidades
- **Plano**: entidade que representa os planos da academia.
- **Aluno**: entidade que representa os alunos matriculados.
- Relacionamento:
  - Um plano possui vários alunos.
  - Um aluno pertence a um plano.

### 📂 Repositórios
- Utilizam `JpaRepository`.
- `AlunoRepository` possui validação de e-mail duplicado através do método:
  - `existsByEmail(String email)`.

### 🔁 DTOs
- **Request DTOs**: usados para entrada de dados (`AlunoRequest`, `PlanoRequest`).
- **Response DTOs**: usados para saída de dados (`AlunoResponse`, `PlanoResponse`).
- Evitam exposição direta das entidades.

### ⚙️ Services
- Contêm toda a regra de negócio.
- Fazem validações.
- Interagem com os repositórios.
- Disparam exceções quando necessário.

### 🚨 Exceções
- `RegraNegocioException`
- `RecursoNaoEncontradoException`

---

## ✅ Regras de Negócio Implementadas

- ✅ Não permite cadastro de aluno com e-mail já existente.
- ✅ Não permite cadastro de aluno com plano inexistente.
- ✅ Exceções são disparadas quando regras são violadas.

---

## 🧪 Testes Automatizados

Os testes foram implementados utilizando:

- JUnit 5
- Spring Boot Test
- Mockito

### ✅ Testes implementados

- Teste de carregamento do contexto da aplicação.
- Teste de cadastro de plano com sucesso.
- Teste de validação de e-mail duplicado.
- Teste de validação de plano inexistente.
- Teste de disparo de exceções na camada Service.

---

## ▶️ Execução do Projeto

### 🔹 Pré-requisitos
- Java 21
- Maven
- MySQL configurado

### 🔹 Executar a aplicação
```bash
mvn spring-boot:run