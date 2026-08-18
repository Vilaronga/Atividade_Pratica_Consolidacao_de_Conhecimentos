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

    // =================Buscas Gerais=========================

    // Todos que não estão excluídos
    List<Usuario> findByDataExclusaoIsNull();

    //Todos os que foram excluídos
    List<Usuario> findByDataExclusaoIsNotNull();

    //Somente os ativos
    List<Usuario> findByAtivoIsTrue();

    //Somente os inativos e não excluídos();
    List<Usuario> findByAtivoIsFalseAndDataExclusaoIsNull();

    // =================Buscas por Nome=========================

    //Todos ativos e inativos
    List<Usuario> findAllByNomeAndDataExclusaoIsNull(String nome);

    //Somente os usuários ativos
    List<Usuario> findByNomeAndAtivoIsTrue(String nome);

    //Somente os usuários inativos
    List<Usuario> findByNomeAndAtivoIsFalseAndDataExclusaoIsNull(String nome);

    //Todos ativos e inativos pelo nome incompleto
    List<Usuario> findByNomeContainingIgnoreCaseAndDataExclusaoIsNull(String nome);

    //Somente ativos pelo nome incompleto
    List<Usuario> findByNomeContainingIgnoreCaseAndAtivoIsTrue(String nome);

    //Somente inativos pelo nome incompleto
    List<Usuario> findByNomeContainingIgnoreCaseAndAtivoIsFalseAndDataExclusaoIsNull(String nome);

    // =================Buscas por Email=========================

    //Somente um usuário ativo ou inativo pelo email
    Optional<Usuario> findByEmailAndDataExclusaoIsNull(String email);

    //Somente um usuário ativo pelo email
    Optional<Usuario> findByEmailAndAtivoIsTrue(String email);

    //Somente um usuário inativo pelo email
    Optional<Usuario> findByEmailAndAtivoIsFalseAndDataExclusaoIsNull(String email);

    //Busca por email incompleto ativos ou inativos
    List<Usuario> findByEmailContainingIgnoreCaseAndDataExclusaoIsNull(String email);

    //Busca por email incompleto somente ativos
    List<Usuario> findByEmailContainingIgnoreCaseAndAtivoIsTrue(String email);

    //Busca por email incompleto inativos
    List<Usuario> findByEmailContainingIgnoreCaseAndAtivoIsFalseAndDataExclusaoIsNull(String email);

    // =================Buscas por Email=========================

    //Traz todos por cpf, ativos e inativos
    Optional<Usuario> findByCpfAndDataExclusaoIsNull(String cpf);

    //Traz todos por cpf e ativos
    Optional<Usuario> findByCpfAndAtivoIsTrue(String cpf);

    //Traz todos por cpf e inativos
    Optional<Usuario> findByCpfAndAtivoIsFalseAndDataExclusaoIsNull(String cpf);

    //Busca todos os ativos e inativos por cpf incompleto
    List<Usuario> findByCpfContainingAndDataExclusaoIsNull(String cpf);

    //Busca todos os ativos por cpf incompleto
    List<Usuario> findByCpfContainingAndAtivoIsTrue(String cpf);

    //Busca todos os inativos por cpf incompleto
    List<Usuario> findByCpfContainingAndAtivoIsFalseAndDataExclusaoIsNull(String cpf);

    // =================Buscas por Telefone=========================

    //Traz todos por telefone, ativos e inativos
    List<Usuario> findAllByTelefoneAndDataExclusaoIsNull(String telefone);

    //Traz todos por telefone todos os ativos
    List<Usuario> findAllByTelefoneAndAtivoIsTrue(String telefone);

    //Traz todos por telefone todos os inativos
    List<Usuario> findAllByTelefoneAndAtivoIsFalseAndDataExclusaoIsNull(String telefone);

    //Busca todos por telefone incompleto os ativos e inativos
    List<Usuario> findByTelefoneContainingAndDataExclusaoIsNull(String telefone);

    //Busca todos por telefone incompleto os ativos
    List<Usuario> findByTelefoneContainingAndAtivoIsTrue(String telefone);

    //Busca todos por telefone incompleto os inativos
    List<Usuario> findByTelefoneContainingAndAtivoIsFalseAndDataExclusaoIsNull(String telefone);

    // =================Buscas por Data de Nascimento=========================
    //TODO terminar de criar os métodos de busca
    List<Usuario> findAllByDataNascimentoAndDataExclusaoIsNull(LocalDate dataNascimento);

    List<Usuario> findByDataNascimentoContainingIgnoreCaseAndDataExclusaoIsNull(LocalDate dataNascimento);

    // =================Buscas por Data de Cadastro=========================
    //TODO terminar de criar os métodos de busca
    List<Usuario> findAllByDataCadastroAndDataExclusaoIsNull(LocalDateTime dataCadastro);

    // =================Métodos de verificação=========================
    boolean existsUsuarioByEmailAndDataExclusaoIsNull(String email);

    boolean existsUsuarioByCpfAndDataExclusaoIsNull(String cpf);

    boolean existsByTelefoneAndDataExclusaoIsNull(String telefone);

    boolean existsByDataNascimentoAndDataExclusaoIsNull(LocalDate dataNascimento);

    boolean existsByDataCadastroAndDataExclusaoIsNull(LocalDateTime dataCadastro);
}
