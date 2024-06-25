package com.aluracursos.forohub.domain.topico;

import java.util.Date;

public record DatosRespuestaTopicos(
        Long id,
        String titulo,
        String mensaje,
        Date fechaCreacion,
        EstadoTopico status,
        String autor,
        String curso  ) {

    public DatosRespuestaTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }

}
