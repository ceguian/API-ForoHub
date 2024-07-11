package com.foro.hub.Api.foro.hub.controller;

import com.foro.hub.Api.foro.hub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@ResponseBody
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicosController {

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
       return service.registrar(datosRegistroTopico, uriComponentsBuilder);


    }
    @GetMapping
    public  ResponseEntity<Page<DatosListadoTopico>> listaDeTopicos(@PageableDefault(size=10, sort="titulo")Pageable paginacion){
        return service.listarTopicos(paginacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornoTopico(@PathVariable Long id){
        return service.mostrarTopicoPorId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        return service.actualizarDatos(id ,datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity borrarTopico(@PathVariable Long id){
        return service.eliminarDatos(id);
    }
}
