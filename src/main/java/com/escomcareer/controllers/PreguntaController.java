package com.escomcareer.controllers;

import com.escomcareer.domain.entities.Pregunta;
import com.escomcareer.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;
    @PostMapping
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta) {
        return ResponseEntity.ok(preguntaService.guardarPregunta(pregunta));
    }
}
