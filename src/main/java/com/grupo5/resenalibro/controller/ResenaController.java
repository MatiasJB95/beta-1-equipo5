package com.grupo5.resenalibro.controller;

import com.grupo5.resenalibro.dto.ResenaRequest;
import com.grupo5.resenalibro.dto.ResenaResponse;
import com.grupo5.resenalibro.persistence.entity.Resena;
import com.grupo5.resenalibro.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
