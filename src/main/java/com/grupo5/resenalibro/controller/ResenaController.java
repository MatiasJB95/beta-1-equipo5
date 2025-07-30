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
    @RequestMapping("/api/resenas")
    public class ResenaController {

        @Autowired
        private ResenaService resenaService;

        @PostMapping
        public ResponseEntity<ResenaResponse> crearReseña(@RequestBody ResenaRequest request) {
            Resena nueva = resenaService.crearResena(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResenaResponse(nueva));

        }

        @GetMapping("/usuario/{usuarioId}")
        public List<ResenaResponse> getByUsuario(@PathVariable Long usuarioId) {
            return resenaService.getByUsuario(usuarioId)
                    .stream()
                    .map(ResenaResponse::new)
                    .toList();
        }

        @GetMapping("/libro/{externalBookId}")
        public List<Resena> getByLibro(@PathVariable String externalBookId) {
            return resenaService.getByLibro(externalBookId);
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
