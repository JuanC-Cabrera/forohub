package com.aluracursos.forohub.domain.topico;

import java.util.Date;

public record DatosRespuestaTopico (
        Long id,
        String titulo,
        String mensaje,
        Date fechaCreacion,
        EstadoTopico status,
        String autor,
        String curso  ) {
}
