package com.grupo5.resenalibro.dto;

import com.grupo5.resenalibro.persistence.entity.Resena;

import java.time.LocalDateTime;

public class ResenaResponse {
    public Long Id;
    public String externalId;
    public Long usuarioId;
    public String contenido;
    public Integer puntuacion;
    public LocalDateTime fecha;

    public ResenaResponse(Resena r) {
        this.Id = r.getId();
        this.externalId = r.getExternalId();
        this.usuarioId = r.getUsuarioId();
        this.contenido = r.getContenido();
        this.puntuacion = r.getPuntuacion();
        this.fecha = r.getFecha();
    }
}
