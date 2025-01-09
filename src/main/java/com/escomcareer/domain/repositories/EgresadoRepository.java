package com.escomcareer.domain.repositories;

import com.escomcareer.domain.entities.Egresado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EgresadoRepository extends CrudRepository<Egresado, Integer> {
    Optional<Egresado> findByEmail(String email);

}
