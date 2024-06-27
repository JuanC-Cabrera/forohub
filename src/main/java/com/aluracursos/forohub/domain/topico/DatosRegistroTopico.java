package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public record DatosRegistroTopico(
        @Getter
        @NotBlank
        String titulo,
        @Getter
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {

}
