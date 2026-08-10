package com.dev.consolidacaodeconhecimentos.service;

import com.dev.consolidacaodeconhecimentos.dto.CadastroUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.model.Usuario;
import com.dev.consolidacaodeconhecimentos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

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
        usuarioRepository.save(novoUsuario);

        return "O usuário " + dto.nome() + " foi cadastrado com sucesso!";
    }
}
