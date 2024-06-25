package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record EnderecoRecordDTO(@NotBlank String rua,@NotBlank String cep, String complemento, Integer numero){
}
