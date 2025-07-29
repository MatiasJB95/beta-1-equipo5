package com.grupo5.resenalibro.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String externalBookId;
    private Long usuarioId;
    private String contenido;
    private LocalDateTime fecha = LocalDateTime.now();

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private Integer puntuacion;

}
