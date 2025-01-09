package com.escomcareer.controllers;

import com.escomcareer.domain.dto.EgresadoRequest;
import com.escomcareer.domain.entities.Egresado;
import com.escomcareer.services.EgresadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/egresados")
public class EgresadoController {

    @Autowired
    private EgresadoService egresadoService;

    @PostMapping
    public ResponseEntity<Egresado> agregarEgresado(
            @RequestBody EgresadoRequest egresadoRequest) {
        try {
            // Crear un nuevo egresado a partir de la solicitud
            Egresado egresado = new Egresado();
            egresado.setNombre(egresadoRequest.getNombre());
            egresado.setApellidos(egresadoRequest.getApellidos());
            egresado.setEmail(egresadoRequest.getEmail());
            egresado.setPassword(egresadoRequest.getPassword());

            // Llamar al servicio con el egresado y el carreraId
            Egresado nuevoEgresado = egresadoService.agregarEgresado(egresado, egresadoRequest.getCarreraId());
            return ResponseEntity.ok(nuevoEgresado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
