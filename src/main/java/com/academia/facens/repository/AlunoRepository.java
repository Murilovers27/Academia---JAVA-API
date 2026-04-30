package com.academia.facens.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.facens.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByEmail(String email);

}
