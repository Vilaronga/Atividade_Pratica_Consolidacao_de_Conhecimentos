package com.dev.consolidacaodeconhecimentos.service;

import com.dev.consolidacaodeconhecimentos.dto.CadastroUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.model.Usuario;
import com.dev.consolidacaodeconhecimentos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private static UsuarioRepository usuarioRepository;

    public String cadastrarUsuario(CadastroUsuarioDTO dto){
        if (usuarioRepository.existsUsuarioByEmail(dto.email())) {
            throw new RuntimeException("O usuário já está cadastrado!");
        } else {
            Usuario novoUsuario = new Usuario(dto);
            usuarioRepository.save(novoUsuario);
            String nomeUsuario = dto.nome();
            return "O usuário " + nomeUsuario + " foi cadastrado com sucesso!";
        }
    }

}
