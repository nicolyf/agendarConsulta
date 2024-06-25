package com.example.springboot.controller;

import com.example.springboot.dtos.AvaliacaoRecordDTO;
import com.example.springboot.models.AvaliacaoModel;
import com.example.springboot.services.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/avaliacao")
public class AvaliacaoController {
    @Autowired
    AvaliacaoService avaliacaoService;

    @PostMapping("/user/{userId}/consulta/{consultaId}")
    public ResponseEntity<AvaliacaoModel> create(@RequestParam Integer userId, @RequestParam Integer consultaId, @RequestBody @Valid AvaliacaoRecordDTO avaliacao) {
        AvaliacaoModel avaliacaoCreated = avaliacaoService.create(userId, consultaId, avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoCreated);
    }

    @DeleteMapping("/{avalicaoId}")
    public ResponseEntity delete(@RequestParam Integer id) {
        this.avaliacaoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
