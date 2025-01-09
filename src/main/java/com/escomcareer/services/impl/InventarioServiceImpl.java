package com.escomcareer.services.impl;

import com.escomcareer.domain.entities.Inventario;
import com.escomcareer.domain.entities.Pregunta;
import com.escomcareer.domain.entities.Respuesta;
import com.escomcareer.domain.entities.User;
import com.escomcareer.domain.repositories.InventarioRepository;
import com.escomcareer.domain.repositories.RespuestaRepository;
import com.escomcareer.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public List<Respuesta> resolverInventario(Long inventarioId, Long usuarioId, Map<Long, Integer> respuestas) {
        List<Respuesta> respuestasGuardadas = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : respuestas.entrySet()) {
            Long preguntaId = entry.getKey();
            int respuestaTexto = entry.getValue();

            Respuesta respuesta = new Respuesta();
            respuesta.setPregunta(new Pregunta(preguntaId, null, null, null));
            respuesta.setRespuesta(respuestaTexto);

            respuestasGuardadas.add(respuestaRepository.save(respuesta));
        }

        return respuestasGuardadas;
    }
}
