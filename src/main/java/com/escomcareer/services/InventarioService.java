package com.escomcareer.services;

import com.escomcareer.domain.entities.Inventario;
import com.escomcareer.domain.entities.Respuesta;

import java.util.List;
import java.util.Map;

public interface InventarioService {
    Inventario guardarInventario(Inventario inventario);
    List<Respuesta> resolverInventario(Long inventarioId, Long usuarioId, Map<Long, Integer> respuestas);
}
