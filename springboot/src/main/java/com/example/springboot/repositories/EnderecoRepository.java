package com.example.springboot.repositories;


import com.example.springboot.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer> {
}