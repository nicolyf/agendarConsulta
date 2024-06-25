package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record AvaliacaoRecordDTO( @NotBlank String avaliacao) {
}
