package com.example.springboot.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDTO(@NotBlank String nome, @NotBlank String cpf, @NotBlank String rg, @NotNull EnderecoRecordDTO endereco) {
}
