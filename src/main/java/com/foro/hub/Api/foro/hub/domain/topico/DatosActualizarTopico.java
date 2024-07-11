package com.foro.hub.Api.foro.hub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        String autor,
        String curso

) {
}
