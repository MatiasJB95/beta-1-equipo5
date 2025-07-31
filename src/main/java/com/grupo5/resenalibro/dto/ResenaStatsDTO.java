package com.grupo5.resenalibro.dto;

public class ResenaStatsDTO {
    private Long usuarioId;
    private Long cantidadLibros;
    private Long cantidadPeliculas;

    public ResenaStatsDTO(Long usuarioId, Long cantidadLibros, Long cantidadPeliculas) {
        this.usuarioId = usuarioId;
        this.cantidadLibros = cantidadLibros;
        this.cantidadPeliculas = cantidadPeliculas;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(Long cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public Long getCantidadPeliculas() {
        return cantidadPeliculas;
    }

    public void setCantidadPeliculas(Long cantidadPeliculas) {
        this.cantidadPeliculas = cantidadPeliculas;
    }
}
