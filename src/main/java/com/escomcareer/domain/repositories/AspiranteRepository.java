package com.escomcareer.domain.repositories;

import com.escomcareer.domain.entities.Aspirante;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AspiranteRepository extends CrudRepository<Aspirante, Integer> {
    Optional<Aspirante> findByEmailAndPassword(String email, String password);
    Optional<Aspirante> findByEmail(String email);
}
