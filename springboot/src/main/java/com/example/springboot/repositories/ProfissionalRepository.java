package com.example.springboot.repositories;
import com.example.springboot.models.ProfissionalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<ProfissionalModel, Integer> {
}
