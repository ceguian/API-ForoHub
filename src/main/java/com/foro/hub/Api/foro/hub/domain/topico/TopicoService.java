package com.foro.hub.Api.foro.hub.domain.topico;

import com.foro.hub.Api.foro.hub.infra.errores.ValidacionDeIntegridad;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class  TopicoService {

    @Autowired
    private TopicoRepository repository;


    public ResponseEntity<DatosRespuestaTopico> registrar(DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        var topico = repository.save(new Topico(datosRegistroTopico));
        var datosRespuesta = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getFecha(),
                topico.getCurso(),
                true);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuesta);


    }

    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(Pageable paginacion) {
        return ResponseEntity.ok(repository.findByEstadoTrue(paginacion).map(DatosListadoTopico::new));
    }

    public ResponseEntity<DatosRespuestaTopico> mostrarTopicoPorId(Long id) {
        if (!repository.findById(id).isPresent()) {

            throw new ValidacionDeIntegridad("Este tópico no fue encontrado.");
        }
        Topico topico = repository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getFecha(),
                topico.getCurso(),
                topico.getEstado());
        return ResponseEntity.ok(datosTopico);
    }


    public ResponseEntity actualizarDatos(Long id, DatosActualizarTopico datosActualizarTopico) {
        if (!repository.findById(id).isPresent()) {
            throw new ValidacionDeIntegridad("El tópico no ha sido encontrado, no es posible modificarlo.");
        }
        Topico topico = repository.getReferenceById(id);
        System.out.println(topico.getTitulo());
        System.out.println(datosActualizarTopico.titulo());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor(),
                topico.getFecha(),
                topico.getCurso(),
                topico.getEstado()
        ));
    }

    public ResponseEntity eliminarDatos(Long id){
        if (!repository.findById(id).isPresent()){
            throw new ValidacionDeIntegridad("El tópico no ha sido encontrado, no es posible eliminarlo.");
        }
        Topico topico = repository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.ok("El topico ha sido eliminado");
    }

}
