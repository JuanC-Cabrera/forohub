package com.aluracursos.forohub.domain.usuario;

import com.aluracursos.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validarUsuarioExistente(Usuario nuevoUsuario) {
        boolean nombreExistente = usuarioRepository.existsByNombre(nuevoUsuario.getNombre());
        boolean emailExistente = usuarioRepository.existsByEmail(nuevoUsuario.getEmail());

        if (nombreExistente && emailExistente) {
            throw new ValidacionDeIntegridad("Ya existe un usuario con ese nombre y correo.");
        } else if (nombreExistente) {
            throw new ValidacionDeIntegridad("Ya existe un usuario con ese nombre.");
        } else if (emailExistente) {
            throw new ValidacionDeIntegridad("Ya existe un usuario con ese correo.");
        }
    }
}