package com.example.springboot.controller;

import com.example.springboot.dtos.ConsultaRecordDTO;
import com.example.springboot.models.ConsultaModel;
import com.example.springboot.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;
    @PostMapping("/criarConsulta")
    public ResponseEntity<ConsultaModel> create(@RequestBody @Valid ConsultaRecordDTO consulta) {
        ConsultaModel consultaCreated = consultaService.create(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaCreated);
    }

    @GetMapping("/{consultaId}")
    public ResponseEntity<ConsultaModel> get(@RequestParam Integer id) {
        ConsultaModel consulta = this.consultaService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

    @PutMapping("/iniciar/{consultaId}")
    public ResponseEntity<ConsultaModel> iniciarConsulta(@RequestParam Integer id){
        ConsultaModel consultaUpdated = this.consultaService.iniciarConsulta(id);
        return ResponseEntity.status(HttpStatus.OK).body(consultaUpdated);
    }

    @PutMapping("/finalizar/{consultaId}")
    public ResponseEntity<ConsultaModel> finalizarConsulta(@RequestParam Integer id){
        ConsultaModel consultaUpdated = this.consultaService.finalizarConsulta(id);
        return ResponseEntity.status(HttpStatus.OK).body(consultaUpdated);
    }
}
