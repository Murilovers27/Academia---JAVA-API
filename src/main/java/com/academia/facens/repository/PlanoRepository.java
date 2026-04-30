package com.academia.facens.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.facens.entity.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    
}
