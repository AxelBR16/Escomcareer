package com.escomcareer.services.impl;

import com.escomcareer.domain.entities.Carrera;
import com.escomcareer.domain.entities.Egresado;
import com.escomcareer.domain.repositories.CarreraRepository;
import com.escomcareer.domain.repositories.EgresadoRepository;
import com.escomcareer.services.EgresadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EgresadoServiceImpl implements EgresadoService {
    @Autowired
    private EgresadoRepository egresadoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Egresado agregarEgresado(Egresado egresado, int carreraId) {
        // Validar si la carrera existe
        Optional<Carrera> carreraOptional = carreraRepository.findById(carreraId);
        if (carreraOptional.isEmpty()) {
            throw new IllegalArgumentException("La carrera con el ID " + carreraId + " no existe.");
        }

        Optional<Egresado> existente = egresadoRepository.findByEmail(egresado.getEmail());

        if (existente.isPresent()) {
            throw new IllegalStateException("El correo ya está registrado.");
        }
        // Encriptar la contraseña del egresado si no es nula
        if (egresado.getPassword() != null) {
            egresado.setPassword(passwordEncoder.encode(egresado.getPassword()));
        }

        // Asignar la carrera al egresado
        egresado.setCarrera(carreraOptional.get());

        // Guardar el egresado en la base de datos
        return egresadoRepository.save(egresado);
    }

    @Transactional(readOnly = true)
    public Optional<Egresado> authenticate(String email, String rawPassword) {
        Optional<Egresado> egresadoOpt = egresadoRepository.findByEmail(email);

        if (egresadoOpt.isPresent()) {
            Egresado egresado = egresadoOpt.get();
            if (passwordEncoder.matches(rawPassword, egresado.getPassword())) {
                return egresadoOpt;
            }
        }
        return Optional.empty();
    }
}
