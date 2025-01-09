package com.escomcareer.services.impl;

import com.escomcareer.domain.entities.Pregunta;
import com.escomcareer.domain.repositories.PreguntaRepository;
import com.escomcareer.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PreguntaServiceImpl implements PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    public Pregunta guardarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }
}
