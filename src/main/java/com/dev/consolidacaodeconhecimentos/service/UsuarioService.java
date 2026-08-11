package com.dev.consolidacaodeconhecimentos.service;

import com.dev.consolidacaodeconhecimentos.dto.UsuarioDTO;
import com.dev.consolidacaodeconhecimentos.dto.ListagemUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.model.Usuario;
import com.dev.consolidacaodeconhecimentos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Create - Post
    @Transactional
    public String cadastrarUsuario(UsuarioDTO dto){
        if (usuarioRepository.existsUsuarioByEmail(dto.email())) {
            throw new RuntimeException("O usuário já está cadastrado!");
        }

        Usuario novoUsuario = new Usuario(dto);
        novoUsuario.setDataCadastro(LocalDateTime.now());
        usuarioRepository.save(novoUsuario);

        return "O usuário " + dto.nome() + " foi cadastrado com sucesso!";
    }

    //Read - Get
    @Transactional(readOnly=true)
    public List<ListagemUsuarioDTO> consultarUsuarios(){
        return usuarioRepository.findAll()
                .stream()
                .map(ListagemUsuarioDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public ListagemUsuarioDTO consultarUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        return new ListagemUsuarioDTO(usuario);
    }

    @Transactional(readOnly=true)
    public List<ListagemUsuarioDTO> consultarUsuariosNome(String nome){
        return usuarioRepository.findAllByNome(nome)
                .stream()
                .map(ListagemUsuarioDTO::new)
                .toList();
    }

    @Transactional(readOnly=true)
    public ListagemUsuarioDTO consultarUsuarioEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        return new ListagemUsuarioDTO(usuario);
    }

    @Transactional(readOnly=true)
    public ListagemUsuarioDTO consultarUsuarioCpf(String cpf){
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        return new ListagemUsuarioDTO(usuario);
    }

    @Transactional(readOnly=true)
    public List<ListagemUsuarioDTO> consultarUsuariosTel(String telefone){
        return usuarioRepository.findAllByTelefone(telefone)
                .stream()
                .map(ListagemUsuarioDTO::new)
                .toList();
    }

    @Transactional(readOnly=true)
    public List<ListagemUsuarioDTO> consultarUsuariosDtNas(LocalDate dataNas){
        return usuarioRepository.findAllByDataNascimento(dataNas)
                .stream()
                .map(ListagemUsuarioDTO::new)
                .toList();
    }

    @Transactional(readOnly=true)
    public List<ListagemUsuarioDTO> consultarUsuariosDtCad(LocalDateTime dataCad){
        return usuarioRepository.findAllByDataCadastro(dataCad)
                .stream()
                .map(ListagemUsuarioDTO::new)
                .toList();
    }

    //Update - Put
    @Transactional
    public ListagemUsuarioDTO atualizarUsuario(Long id, UsuarioDTO dtoAtualizado) {
        Usuario usuarioAtual = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuarioAtual.atualizarUsuario(dtoAtualizado);

        return new ListagemUsuarioDTO(usuarioAtual);
    }

    //Delete
    @Transactional
    public ListagemUsuarioDTO excluirUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        ListagemUsuarioDTO usuarioExcluido = new ListagemUsuarioDTO(usuario);

        usuarioRepository.deleteById(id);

        return usuarioExcluido;
    }
}
