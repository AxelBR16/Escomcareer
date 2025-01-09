package com.escomcareer.controllers;

import com.escomcareer.domain.entities.Aspirante;
import com.escomcareer.services.impl.AspiranteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aspirantes")
public class AspiranteController {

    @Autowired
    private AspiranteServiceImpl aspiranteService;

    // Listar todos los aspirantes
    @GetMapping
    public ResponseEntity<List<Aspirante>> getAllAspirantes() {
        List<Aspirante> aspirantes = aspiranteService.findAll();
        return ResponseEntity.ok(aspirantes);
    }

    // Buscar aspirante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aspirante> getAspiranteById(@PathVariable Integer id) {
        Optional<Aspirante> aspirante = aspiranteService.findById(id);
        return aspirante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo aspirante
    @PostMapping
    public ResponseEntity<Aspirante> createAspirante(@RequestBody Aspirante aspirante) {
        Aspirante nuevoAspirante = aspiranteService.save(aspirante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAspirante);
    }

    // Actualizar un aspirante existente
    @PutMapping("/{id}")
    public ResponseEntity<Aspirante> updateAspirante(@PathVariable Integer id, @RequestBody Aspirante aspirante) {
        Optional<Aspirante> aspiranteExistente = aspiranteService.findById(id);
        if (aspiranteExistente.isPresent()) {
            aspirante.setId(id); // Asegúrate de asignar el ID para actualizar el registro existente
            Aspirante aspiranteActualizado = aspiranteService.save(aspirante);
            return ResponseEntity.ok(aspiranteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un aspirante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAspirante(@PathVariable Integer id) {
        Optional<Aspirante> aspirante = aspiranteService.findById(id);
        if (aspirante.isPresent()) {
            aspiranteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
