package com.dev.consolidacaodeconhecimentos.controller;

import com.dev.consolidacaodeconhecimentos.dto.AtualizarUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.dto.CadastroUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.dto.ListagemUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid CadastroUsuarioDTO usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<ListagemUsuarioDTO>> consultarUsuarios(){
        return ResponseEntity.ok().body(usuarioService.consultarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemUsuarioDTO> consultarUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.consultarUsuarioPorId(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ListagemUsuarioDTO> atualizarUsuario(@RequestParam Long id, @RequestBody AtualizarUsuarioDTO dto) {
        return ResponseEntity.ok().body(usuarioService.atualizarUsuario(id, dto));
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<ListagemUsuarioDTO> excluirUsuario(@RequestParam Long id){
        return ResponseEntity.ok().body(usuarioService.excluirUsuario(id));
    }
}
