package com.grupo5.resenalibro.service;

import com.grupo5.resenalibro.dto.ResenaRequest;
import com.grupo5.resenalibro.dto.ResenaStatsDTO;
import com.grupo5.resenalibro.persistence.entity.Resena;
import com.grupo5.resenalibro.persistence.repository.resenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {
    @Autowired
    private resenaRepository resenaRepo;

    public Resena crearResena(ResenaRequest request) {
        Resena resena = new Resena();
        resena.setExternalId(request.externalId);
        resena.setUsuarioId(request.usuarioId);
        resena.setTipo(request.tipo);
        resena.setContenido(request.contenido);
        resena.setPuntuacion(request.puntuacion);
        resena.setFecha(LocalDateTime.now());

        return resenaRepo.save(resena);
    }

    public List<Resena> getByUsuario(Long usuarioId) {
        return resenaRepo.findByUsuarioId(usuarioId);
    }

    public Optional<Resena> findById(Long id) {
        return resenaRepo.findById(id);
    }
    public Resena save(Resena resena) {
        return resenaRepo.save(resena);
    }

    public boolean existsById(Long id) {
        return resenaRepo.existsById(id);
    }

    public void deleteById(Long id) {
        resenaRepo.deleteById(id);
    }

    public List<Resena> findByUsuarioIdAndTipo(Long usuarioId, String tipo) {
        return resenaRepo.findByUsuarioIdAndTipo(usuarioId, tipo);
    }
    public List<Resena> findByExternalBookId(String externalBookId) {
        return resenaRepo.findByExternalId(externalBookId);
    }

    public ResenaStatsDTO obtenerEstadisticas(Long usuarioId) {
        Object[] fila = resenaRepo.contarPorTipo(usuarioId).get(0);
        Number libros = (Number) fila[0];
        Number pelis = (Number) fila[1];

        return new ResenaStatsDTO(
                usuarioId,
                libros != null ? libros.longValue() : 0L,
                pelis != null ? pelis.longValue() : 0L
        );
    }

}
