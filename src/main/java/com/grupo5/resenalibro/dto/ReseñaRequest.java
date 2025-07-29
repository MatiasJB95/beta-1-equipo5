package com.grupo5.resenalibro.dto;

import lombok.Data;

import java.time.LocalDateTime;

public class ReseñaRequest {
    public String externalBookId;
    public Long usuarioId;
    public String contenido;
    public LocalDateTime fecha;
    public Integer puntuacion;
}
