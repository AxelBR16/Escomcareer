package com.escomcareer.services.impl;

import com.escomcareer.domain.entities.Aspirante;
import com.escomcareer.domain.repositories.AspiranteRepository;
import com.escomcareer.services.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class AspiranteServiceImpl implements AspiranteService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Aspirante> findAll() {
        return (List<Aspirante>) aspiranteRepository.findAll();
    }

    @Override
    @Transactional
    public Aspirante save(Aspirante aspirante) {
        if (aspirante.getPassword() != null) {
            aspirante.setPassword(passwordEncoder.encode(aspirante.getPassword()));
        }
        return aspiranteRepository.save(aspirante);
    }


    @Override
    @Transactional
    public Optional<Aspirante> findById(Integer id) {
        return aspiranteRepository.findById(id);
    }

    public void deleteById(Integer id) {
        aspiranteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Aspirante> authenticate(String email, String rawPassword) {
        Optional<Aspirante> aspiranteOpt = aspiranteRepository.findByEmail(email);

        if (aspiranteOpt.isPresent()) {
            Aspirante aspirante = aspiranteOpt.get();
            if (passwordEncoder.matches(rawPassword, aspirante.getPassword())) {
                return aspiranteOpt;
            }
        }
        return Optional.empty();
    }
}
