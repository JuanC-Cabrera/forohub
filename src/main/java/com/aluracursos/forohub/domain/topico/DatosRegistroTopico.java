package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String curso
) {

}
