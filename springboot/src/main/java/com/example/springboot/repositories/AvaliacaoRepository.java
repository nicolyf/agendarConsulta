package com.example.springboot.repositories;

import com.example.springboot.models.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, Integer> {
}
