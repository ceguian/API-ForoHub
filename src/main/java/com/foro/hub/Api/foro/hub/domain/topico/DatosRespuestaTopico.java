package com.foro.hub.Api.foro.hub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        LocalDateTime fecha,
        String curso,
        Boolean estado
) {
}
