package com.dev.consolidacaodeconhecimentos.dto;

import com.dev.consolidacaodeconhecimentos.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ListagemUsuarioDTO(
        String nome,

        String email,

        String cpf,

        String telefone,

        LocalDate dataNascimento,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss")
        LocalDateTime dataCadastro
){
    public ListagemUsuarioDTO(Usuario u) {
        this(
                u.getNome(),
                u.getEmail(),
                u.getCpf(),
                u.getTelefone(),
                u.getDataNascimento(),
                u.getDataCadastro());
    }
}
