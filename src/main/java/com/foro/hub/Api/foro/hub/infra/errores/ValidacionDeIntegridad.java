package com.foro.hub.Api.foro.hub.infra.errores;


public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String string) {
        super(string);
    }
}
