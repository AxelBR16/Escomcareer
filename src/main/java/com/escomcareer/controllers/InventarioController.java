package com.escomcareer.controllers;

import com.escomcareer.domain.entities.Inventario;
import com.escomcareer.domain.entities.Respuesta;
import com.escomcareer.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class
InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public ResponseEntity<Inventario> guardarInventario(@RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.guardarInventario(inventario));
    }

    @PostMapping("/{inventarioId}/resolver/{usuarioId}")
    public ResponseEntity<List<Respuesta>> resolverInventario(
            @PathVariable Long inventarioId,
            @PathVariable Long usuarioId,
            @RequestBody Map<Long, Integer> respuestas
    ) {
        return ResponseEntity.ok(inventarioService.resolverInventario(inventarioId, usuarioId, respuestas));
    }
}
