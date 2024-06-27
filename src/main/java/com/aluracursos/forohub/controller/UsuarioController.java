package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.UsuarioRepository;
import com.aluracursos.forohub.domain.usuario.UsuarioService;
import com.aluracursos.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody(required = false) Usuario nuevoUsuario) {
        if (nuevoUsuario == null) {
            throw new ValidacionDeIntegridad("No se envió ningún dato en la solicitud.");
        }

        // Llamar al método del servicio para validar la existencia del usuario
        usuarioService.validarUsuarioExistente(nuevoUsuario);

        // Si no hay errores, proceder con la creación del usuario
        Usuario usuarioCreado = usuarioRepository.save(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

}
