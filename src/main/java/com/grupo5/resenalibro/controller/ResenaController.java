package com.grupo5.resenalibro.controller;

import com.grupo5.resenalibro.dto.ResenaRequest;
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
        public ResponseEntity<Resena> crearReseña(@RequestBody ResenaRequest request) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(resenaService.crearReseña(request));
        }

        @GetMapping("/usuario/{usuarioId}")
        public List<Resena> getByUsuario(@PathVariable Long usuarioId) {
            return resenaService.getByUsuario(usuarioId);
        }

        @GetMapping("/libro/{externalBookId}")
        public List<Resena> getByLibro(@PathVariable String externalBookId) {
            return resenaService.getByLibro(externalBookId);
        }
}
