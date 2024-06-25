package com.example.springboot.controller;

import com.example.springboot.dtos.ProfissionalRecordDTO;
import com.example.springboot.models.ProfissionalModel;
import com.example.springboot.services.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/profissional")
public class ProfissionalController {
    @Autowired
    ProfissionalService profissionalService;

    @PostMapping("/cadastrarProfissional")
    public ResponseEntity<ProfissionalModel> create(@RequestBody @Valid ProfissionalRecordDTO profissional) {
        var profissionalCreated = this.profissionalService.create(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalCreated);
    }

    @GetMapping("/{profissionalId}")
    public ResponseEntity<ProfissionalModel> get(@RequestParam Integer id) {
        var profissional = this.profissionalService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(profissional);
    }

    @PutMapping("/{profissionalId}")
    public ResponseEntity<ProfissionalModel> update(@RequestParam Integer id, @RequestBody ProfissionalRecordDTO profissional){
        this.profissionalService.get(id);
        var profissionalUpdated = this.profissionalService.update(profissional);
        return ResponseEntity.status(HttpStatus.OK).body(profissionalUpdated);
    }
    @DeleteMapping("/{profissionalId}")
    public ResponseEntity delete(@RequestParam Integer id) {
        this.profissionalService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
