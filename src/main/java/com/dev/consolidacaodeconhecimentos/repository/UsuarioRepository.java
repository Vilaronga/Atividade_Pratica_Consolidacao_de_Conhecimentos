package com.dev.consolidacaodeconhecimentos.repository;

import com.dev.consolidacaodeconhecimentos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByNome(String nome);

    List<Usuario> findByNomeContainingIgnoreCase(String nome);

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByEmailContainingIgnoreCase(String email);

    Optional<Usuario> findByCpf(String cpf);

    List<Usuario> findByCpfContainingIgnoreCase(String cpf);

    List<Usuario> findAllByTelefone(String telefone);

    List<Usuario> findAllByDataNascimento(LocalDate dataNascimento);

    List<Usuario> findByDataNascimentoContainingIgnoreCase(LocalDate dataNascimento);

    List<Usuario> findAllByDataCadastro(LocalDateTime dataCadastro);

    boolean existsUsuarioByEmail(String email);

    boolean existsUsuarioByCpf(String cpf);

    boolean existsByTelefone(String telefone);

    boolean existsByDataNascimento(LocalDate dataNascimento);

    boolean existsByDataCadastro(LocalDateTime dataCadastro);
}
