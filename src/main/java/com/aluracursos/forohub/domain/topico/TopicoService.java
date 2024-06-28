package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    @Autowired
    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void validarTopicoExistente(@Valid DatosRegistroTopico nuevoTopico) {
        boolean tituloExistente = topicoRepository.existsByTitulo(nuevoTopico.titulo());
        boolean mensajeExistente = topicoRepository.existsByMensaje(nuevoTopico.mensaje());

        if (tituloExistente && mensajeExistente) {
            throw new ValidacionDeIntegridad("Ya existe un topico con ese titulo y mensaje.");
        } else if (tituloExistente) {
            throw new ValidacionDeIntegridad("Ya existe un topico con ese titulo.");
        } else if (mensajeExistente) {
            throw new ValidacionDeIntegridad("Ya existe un topico con ese mensaje.");
        }
    }
}
