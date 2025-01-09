package com.escomcareer.domain.repositories;

import com.escomcareer.domain.entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
