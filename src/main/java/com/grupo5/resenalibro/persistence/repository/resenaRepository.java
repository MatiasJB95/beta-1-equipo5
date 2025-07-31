package com.grupo5.resenalibro.persistence.repository;

import com.grupo5.resenalibro.persistence.entity.Resena;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface resenaRepository extends JpaRepository<Resena, Long> {
    List<Resena> findByUsuarioId(Long usuarioId);

    List<Resena> findByExternalBookId(String externalBookId);

    Optional<Resena> findById(Long id);
    List<Resena> findByUsuarioIdAndTipo(Long usuarioId, String tipo);

}
