package com.dev.consolidacaodeconhecimentos.controller;

import com.dev.consolidacaodeconhecimentos.dto.CadastroUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid CadastroUsuarioDTO usuario) {
        return ResponseEntity.ok().body(usuarioService.cadastrarUsuario(usuario));
    }

}
