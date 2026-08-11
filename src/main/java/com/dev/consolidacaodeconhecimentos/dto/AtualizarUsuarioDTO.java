package com.dev.consolidacaodeconhecimentos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record AtualizarUsuarioDTO(

        @NotBlank(message = "O nome não pode estar vazio!")
        @Size(message = "O número de caracteres ultrapassa 200.", max=200)
        String nome,

        @Email(message = "Formato de email inválido!")
        @NotBlank(message = "O email não pode estar vazio!")
        @Size(message = "O número de caracteres ultrapassa 100.", max=100)
        String email,

        @NotBlank(message = "O cpf não pode estar vazio!")
        @Size(message = "O cpf deve possuir exatamente 11 dígitos!", min=11, max=11)
        String cpf,

        @NotBlank(message = "O telefone não pode estar vazio!")
        @Size(message = "O telefone deve possuir de 10 a 11 dígitos!", min=10, max=11)
        String telefone,

        @Past(message = "Deve ser menor que a data atual.")
        @NotNull(message = "A data não pode estar em branco.")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dataNascimento
) {
}
