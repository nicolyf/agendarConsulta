package com.example.springboot.dtos;

import com.example.springboot.enums.EstadoSessaoEnum;
import com.example.springboot.enums.TipoSessaoEnum;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRecordDTO(@NotNull LocalDateTime dateTime, @NotNull TipoSessaoEnum tipoSessaoEnum){
}
