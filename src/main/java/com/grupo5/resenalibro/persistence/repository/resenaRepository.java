package com.grupo5.resenalibro.persistence.repository;

import com.grupo5.resenalibro.persistence.entity.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface resenaRepository extends JpaRepository<Resena, Long> {
    List<Resena> findByUsuarioId(Long usuarioId);

    List<Resena> findByExternalId(String externalBookId);

    Optional<Resena> findById(Long id);
    List<Resena> findByUsuarioIdAndTipo(Long usuarioId, String tipo);

    @Query("""
    SELECT
        SUM(CASE WHEN r.tipo = 'B' THEN 1 ELSE 0 END),
        SUM(CASE WHEN r.tipo = 'M' THEN 1 ELSE 0 END)
    FROM Resena r
    WHERE r.usuarioId = :usuarioId
""")
    List<Object[]> contarPorTipo(@Param("usuarioId") Long usuarioId);

}
