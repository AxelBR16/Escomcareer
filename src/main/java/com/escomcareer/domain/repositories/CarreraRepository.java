package com.escomcareer.domain.repositories;

import com.escomcareer.domain.entities.Carrera;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    Optional<Carrera> findById(int id);
}
