package com.grupo5.resenalibro.service;

import com.grupo5.resenalibro.persistence.entity.Favorito;
import com.grupo5.resenalibro.persistence.repository.favoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {
    @Autowired
    private favoritoRepository favoritoRepo;
    public Favorito guardar(Favorito favorito) {
        return favoritoRepo.save(favorito);
    }

    public List<Favorito> obtenerPorUsuarioYTipo(Long usuarioId, String tipo) {
        return favoritoRepo.findByUsuarioIdAndTipo(usuarioId, tipo);
    }

    public void eliminarPorUsuarioYExternalIdYTipo(Long usuarioId, String externalId, String tipo) {
        favoritoRepo.deleteByUsuarioIdAndExternalIdAndTipo(usuarioId, externalId, tipo);
    }

    public boolean existe(Long usuarioId, String externalId, String tipo) {
        return favoritoRepo.findByUsuarioIdAndExternalIdAndTipo(usuarioId, externalId, tipo).isPresent();
    }
}
