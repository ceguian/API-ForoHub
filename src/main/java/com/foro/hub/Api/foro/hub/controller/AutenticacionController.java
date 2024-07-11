package com.foro.hub.Api.foro.hub.controller;

import com.foro.hub.Api.foro.hub.domain.usuario.DatosAutenticacionUsuarios;
import com.foro.hub.Api.foro.hub.domain.usuario.Usuario;
import com.foro.hub.Api.foro.hub.infra.security.DatosJWTToken;
import com.foro.hub.Api.foro.hub.infra.security.TokenService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuarios datosAutenticacionUsuarios){

        var authtoken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuarios.login(),
                datosAutenticacionUsuarios.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authtoken);
        var JWTToken= tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTToken));
    }
}
