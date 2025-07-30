package com.grupo5.resenalibro.persistence.repository;

import com.grupo5.resenalibro.persistence.entity.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface favoritoRepository extends JpaRepository<Favorito, Long> {
    List<Favorito> findByUsuarioIdAndTipo(Long usuarioId, String tipo);
    Optional<Favorito> findByUsuarioIdAndExternalIdAndTipo(Long usuarioId, String externalId, String tipo);
    void deleteByUsuarioIdAndExternalIdAndTipo(Long usuarioId, String externalId, String tipo);
}
