package com.foro.hub.Api.foro.hub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        String curso,
        String autor,
        LocalDateTime fecha
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getCurso(), topico.getAutor(), topico.getFecha());
    }
}
