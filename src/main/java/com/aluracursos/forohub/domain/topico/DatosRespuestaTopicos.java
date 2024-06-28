package com.aluracursos.forohub.domain.topico;

import java.util.Date;

public class DatosRespuestaTopicos {
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private EstadoTopico status;
    private String autorNombre;
    private String curso;

    public DatosRespuestaTopicos() {
        // Constructor vacío necesario para algunas operaciones de mapeo
    }

    public DatosRespuestaTopicos(Long id, String titulo, String mensaje, Date fechaCreacion, EstadoTopico status, String autorNombre, String curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.autorNombre = autorNombre;
        this.curso = curso;
    }

    public DatosRespuestaTopicos(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        this.fechaCreacion = topico.getFechaCreacion();
        this.status = topico.getStatus();
        this.autorNombre = topico.getAutor().getNombre(); // Asumiendo que el autor es un objeto Usuario y tiene un campo nombre
        this.curso = topico.getCurso();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoTopico getStatus() {
        return status;
    }

    public void setStatus(EstadoTopico status) {
        this.status = status;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

