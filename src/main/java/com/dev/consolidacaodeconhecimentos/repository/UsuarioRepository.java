package com.dev.consolidacaodeconhecimentos.repository;

import com.dev.consolidacaodeconhecimentos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findAllByNome(String nome);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByCpf(String cpf);

    List<Usuario> findByTelefone(String telefone);

    List<Usuario> findAllByDataNascimento(LocalDate dataNascimento);

    List<Usuario> findAllByDataCadastro(LocalDate dataCadastro);

    boolean existsUsuarioByEmail(String email);

    boolean existsUsuarioByCpf(String cpf);

    boolean existsByTelefone(String telefone);

    boolean existsByDataNascimento(LocalDate dataNascimento);

    boolean existsByDataCadastro(LocalDate dataCadastro);
}
