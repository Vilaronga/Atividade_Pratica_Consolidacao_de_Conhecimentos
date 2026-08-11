package com.dev.consolidacaodeconhecimentos.service;

import com.dev.consolidacaodeconhecimentos.dto.AtualizarUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.dto.CadastroUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.dto.ListagemUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.model.Usuario;
import com.dev.consolidacaodeconhecimentos.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String cadastrarUsuario(CadastroUsuarioDTO dto){
        if (usuarioRepository.existsUsuarioByEmail(dto.email())) {
            throw new RuntimeException("O usuário já está cadastrado!");
        }

        Usuario novoUsuario = new Usuario(dto);
        novoUsuario.setDataCadastro(LocalDateTime.now());
        usuarioRepository.save(novoUsuario);

        return "O usuário " + dto.nome() + " foi cadastrado com sucesso!";
    }

    public List<ListagemUsuarioDTO> consultarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<ListagemUsuarioDTO> listaUsuarioDTOS = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            ListagemUsuarioDTO dto = new ListagemUsuarioDTO(usuario);
            listaUsuarioDTOS.add(dto);
        }

        return listaUsuarioDTOS;
    }

    public ListagemUsuarioDTO consultarUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        return new ListagemUsuarioDTO(usuario);
    }

    @Transactional
    public ListagemUsuarioDTO atualizarUsuario(Long id, AtualizarUsuarioDTO dtoAtualizado) {
        Usuario usuarioAtual = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuarioAtual.atualizarUsuario(dtoAtualizado);
        usuarioRepository.save(usuarioAtual);

        return new ListagemUsuarioDTO(usuarioAtual);
    }

    @Transactional
    public ListagemUsuarioDTO excluirUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        ListagemUsuarioDTO usuarioExcluido = new ListagemUsuarioDTO(usuario);

        usuarioRepository.deleteById(id);

        return usuarioExcluido;
    }
}
