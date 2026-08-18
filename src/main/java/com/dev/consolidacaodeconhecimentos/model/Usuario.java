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

    @Column(nullable = true)
    private LocalDateTime dataExclusao;

    @Column(nullable = false)
    private boolean ativo;

    //Constructors
    public Usuario(UsuarioDTO dto){
        this.nome = dto.nome();
        this.email = dto.email();
        this.cpf = dto.cpf();
        this.telefone = dto.telefone();
        this.dataNascimento = dto.dataNascimento();
        this.ativo = true;
        this.dataExclusao = null;
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

    public String alterarUsuario(String acao) {
        switch (acao) {
            case "ativar":
                if (this.ativo) {
                    return "O usuário já está ativo!";
                }
                this.ativo = true;
                return "O usuário " + this.nome + " foi ativado!";

            case "inativar":
                if (!this.ativo) {
                    return "O usuário já está inativo!";
                }
                this.ativo = false;
                return "O usuário " + this.nome + " foi inativado!";

            case "excluir":
                if (this.dataExclusao != null) {
                    return "O usuário não foi encontrado!";
                }
                this.ativo = false;
                this.dataExclusao = LocalDateTime.now();
                return "O usuário " + this.nome + " foi excluído!";

            case "resgatar":
                if (this.dataExclusao == null) {
                    return "O usuário já encontra-se disponível!";
                }
                this.ativo = true;
                this.dataExclusao = null;
                return "O usuário " + this.nome + " foi resgatado!";

            default:
                return "O comando é inválido!";
        }
    }
}
