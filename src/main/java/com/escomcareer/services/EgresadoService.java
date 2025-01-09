package com.escomcareer.services;

import com.escomcareer.domain.entities.Egresado;

import java.util.Optional;

public interface EgresadoService {
    public Egresado agregarEgresado(Egresado egresado, int carreraId);
    public Optional<Egresado> authenticate(String email, String rawPassword);
}
