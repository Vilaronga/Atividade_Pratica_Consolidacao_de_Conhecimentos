package com.dev.consolidacaodeconhecimentos.model;

import com.dev.consolidacaodeconhecimentos.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    //Constructors
    public Usuario(UsuarioDTO dto){
        this.nome = dto.nome();
        this.email = dto.email();
        this.cpf = dto.cpf();
        this.telefone = dto.telefone();
        this.dataNascimento = dto.dataNascimento();
    }

    public void atualizarUsuario(UsuarioDTO dto){
        if (dto.nome() != null) {
            this.nome = dto.nome();
        }

        if (dto.cpf() != null) {
            this.cpf = dto.cpf();
        }

        if (dto.email() != null) {
            this.email = dto.email();
        }

        if (dto.telefone() != null) {
            this.telefone = dto.telefone();
        }

        if (dto.dataNascimento() != null) {
            this.dataNascimento = dto.dataNascimento();
        }
    }
}
