package com.grupo5.resenalibro.service;

import com.grupo5.resenalibro.dto.ResenaRequest;
import com.grupo5.resenalibro.persistence.entity.Resena;
import com.grupo5.resenalibro.persistence.repository.resenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResenaService {
    @Autowired
    private resenaRepository resenaRepo;

    public Resena crearReseña(ResenaRequest request) {
        Resena resena = new Resena();
        resena.setExternalBookId(request.externalBookId);
        resena.setUsuarioId(request.usuarioId);
        resena.setContenido(request.contenido);
        resena.setFecha(LocalDateTime.now());

        return resenaRepo.save(resena);
    }

    public List<Resena> getByUsuario(Long usuarioId) {
        return resenaRepo.findByUsuarioId(usuarioId);
    }

    public List<Resena> getByLibro(String externalBookId) {
        return resenaRepo.findByExternalBookId(externalBookId);
    }
}
