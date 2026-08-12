package com.dev.consolidacaodeconhecimentos.controller;

import com.dev.consolidacaodeconhecimentos.dto.UsuarioDTO;
import com.dev.consolidacaodeconhecimentos.dto.ListagemUsuarioDTO;
import com.dev.consolidacaodeconhecimentos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Post
    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
    }

    // Get
    @GetMapping
    public ResponseEntity<List<ListagemUsuarioDTO>> consultarUsuarios(){
        return ResponseEntity.ok().body(usuarioService.consultarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListagemUsuarioDTO> consultarUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.consultarUsuarioPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ListagemUsuarioDTO>> consultarUsuarioPorNome(@PathVariable String nome){
        return ResponseEntity.ok().body(usuarioService.consultarUsuariosNome(nome));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ListagemUsuarioDTO> consultarUsuarioPorEmail(@PathVariable String email){
        return ResponseEntity.ok().body(usuarioService.consultarUsuarioEmail(email));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ListagemUsuarioDTO> consultarUsuarioPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok().body(usuarioService.consultarUsuarioCpf(cpf));
    }

    @GetMapping("/telefone/{telefone}")
    public ResponseEntity<List<ListagemUsuarioDTO>> consultarUsuarioPorTelefone(@PathVariable String telefone){
        return ResponseEntity.ok().body(usuarioService.consultarUsuariosTel(telefone));
    }

    @GetMapping("/dataNasc/{dataNas}")
    public ResponseEntity<List<ListagemUsuarioDTO>> consultarUsuarioPorDtNas(@PathVariable LocalDate dataNas){
        return ResponseEntity.ok().body(usuarioService.consultarUsuariosDtNas(dataNas));
    }

    @GetMapping("/dataCad/{dataCad}")
    public ResponseEntity<List<ListagemUsuarioDTO>> consultarUsuarioPorDtCad(@PathVariable LocalDateTime dataCad){
        return ResponseEntity.ok().body(usuarioService.consultarUsuariosDtCad(dataCad));
    }

    // Put
    @PutMapping("/atualizar")
    public ResponseEntity<ListagemUsuarioDTO> atualizarUsuario(@RequestParam Long id, @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok().body(usuarioService.atualizarUsuario(id, dto));
    }

    @PutMapping("/alterar/ativar")
    public ResponseEntity<String> ativarUsuario(@RequestParam Long id){
        return ResponseEntity.ok().body(usuarioService.alterarUsuario(id, "ativar"));
    }

    @PutMapping("/alterar/inativar")
    public ResponseEntity<String> inativarUsuario(@RequestParam Long id){
        return ResponseEntity.ok().body(usuarioService.alterarUsuario(id, "inativar"));
    }

    @PutMapping("/alterar/excluir")
    public ResponseEntity<String> excluirUsuario(@RequestParam Long id){
        return ResponseEntity.ok().body(usuarioService.alterarUsuario(id, "excluir"));
    }

    @PutMapping("/alterar/resgatar")
    public ResponseEntity<String> resgatarUsuario(@RequestParam Long id){
        return ResponseEntity.ok().body(usuarioService.alterarUsuario(id, "resgatar"));
    }

    // Delete
    @DeleteMapping("/deletar")
    public ResponseEntity<ListagemUsuarioDTO> deletarUsuario(@RequestParam Long id){
        return ResponseEntity.ok().body(usuarioService.excluirUsuario(id));
    }
}
