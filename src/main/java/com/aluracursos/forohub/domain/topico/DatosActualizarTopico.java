package com.aluracursos.forohub.domain.topico;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        String autor,
        String curso,
        EstadoTopico status
) {
    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public String mensaje() {
        return mensaje;
    }

    @Override
    public String autor() {
        return autor;
    }

    @Override
    public String curso() {
        return curso;
    }

    @Override
    public EstadoTopico status() {
        return status;
    }
}
