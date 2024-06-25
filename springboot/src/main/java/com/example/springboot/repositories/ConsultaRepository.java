package com.example.springboot.repositories;

import com.example.springboot.models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {
}
