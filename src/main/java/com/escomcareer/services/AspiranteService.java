package com.escomcareer.services;

import com.escomcareer.domain.entities.Aspirante;

import java.util.List;
import java.util.Optional;

public interface AspiranteService {
    public List<Aspirante> findAll();
    public Optional<Aspirante> findById(Integer id);
    public Aspirante save(Aspirante aspirante);
    public void deleteById(Integer id);
    public Optional<Aspirante> authenticate(String email, String password);
}
