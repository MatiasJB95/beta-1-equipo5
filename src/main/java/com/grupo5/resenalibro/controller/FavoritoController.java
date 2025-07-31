package com.grupo5.resenalibro.controller;

import com.grupo5.resenalibro.persistence.entity.Favorito;
import com.grupo5.resenalibro.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/f")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @PostMapping
    public ResponseEntity<Favorito> agregar(@RequestBody Favorito favorito) {
        if (favoritoService.existe(favorito.getUsuarioId(), favorito.getExternalId(), favorito.getTipo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Ya existe
        }
        return ResponseEntity.ok(favoritoService.guardar(favorito));
    }

    @GetMapping("/{usuarioId}/t/{tipo}")
    public ResponseEntity<?> obtenerPorTipo(
            @PathVariable Long usuarioId,
            @PathVariable String tipo) {

        if (!tipo.equalsIgnoreCase("B") && !tipo.equalsIgnoreCase("M")) {
            return ResponseEntity.badRequest().body("Tipo inválido. Debe ser 'B' (libro) o 'M' (película).");
        }

        List<Favorito> favoritos = favoritoService.obtenerPorUsuarioYTipo(usuarioId, tipo.toUpperCase());

        if (favoritos.isEmpty()) {
            return ResponseEntity.ok().body("El usuario no tiene favoritos de tipo " + tipo.toUpperCase());
        }
        return ResponseEntity.ok(favoritos);
    }


    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestParam Long usuarioId,
                                         @RequestParam String externalId,
                                         @RequestParam String tipo) {
        favoritoService.eliminarPorUsuarioYExternalIdYTipo(usuarioId, externalId, tipo);
        return ResponseEntity.noContent().build();
    }
}