package com.grupo5.resenalibro.controller;

import com.grupo5.resenalibro.dto.ResenaRequest;
import com.grupo5.resenalibro.dto.ResenaResponse;
import com.grupo5.resenalibro.dto.ResenaUpdateDTO;
import com.grupo5.resenalibro.persistence.entity.Resena;
import com.grupo5.resenalibro.service.ResenaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/r")
    public class ResenaController {

        @Autowired
        private ResenaService resenaService;

        @PostMapping
        public ResponseEntity<ResenaResponse> crearReseña(@RequestBody ResenaRequest request) {
            Resena nueva = resenaService.crearResena(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResenaResponse(nueva));

        }

        @GetMapping("/u/{usuarioId}")
        public List<ResenaResponse> getByUsuario(@PathVariable Long usuarioId) {
            return resenaService.getByUsuario(usuarioId)
                    .stream()
                    .map(ResenaResponse::new)
                    .toList();
        }

    @GetMapping("/u/{usuarioId}/t/{tipo}")
    public ResponseEntity<List<Resena>> getResenasPorTipo(
            @PathVariable Long usuarioId,
            @PathVariable String tipo) {

        if (!tipo.equals("B") && !tipo.equals("M")) {
            return ResponseEntity.badRequest().build();
        }

        List<Resena> resenas = resenaService.findByUsuarioIdAndTipo(usuarioId, tipo);
        return ResponseEntity.ok(resenas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> actualizarResena(
            @PathVariable Long id,
            @RequestBody @Valid ResenaUpdateDTO dto) {

        Optional<Resena> resenaExistente = resenaService.findById(id);

        if (resenaExistente.isPresent()) {
            Resena r = resenaExistente.get();
            r.setContenido(dto.getContenido());
            r.setPuntuacion(dto.getPuntuacion());
            r.setFecha(LocalDateTime.now()); // opcional

            return ResponseEntity.ok(resenaService.save(r));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Long id) {
        if (resenaService.existsById(id)) {
            resenaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
