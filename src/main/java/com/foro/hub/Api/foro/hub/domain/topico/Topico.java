package com.foro.hub.Api.foro.hub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean estado;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {

        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estado = true;
        this.curso = datosRegistroTopico.curso();
        this.autor = datosRegistroTopico.autor();
        this.fecha = LocalDateTime.now();
    }

    public void desactivarTopico(){
        this.estado = false;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo()!=null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje()!=null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
       if (datosActualizarTopico.curso()!=null){
           this.curso = datosActualizarTopico.curso();
       }
       if (datosActualizarTopico.autor()!=null){
           this.autor = datosActualizarTopico.autor();
       }

    }
}