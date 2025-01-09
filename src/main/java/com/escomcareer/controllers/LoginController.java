package com.escomcareer.controllers;

import com.escomcareer.domain.entities.Aspirante;
import com.escomcareer.domain.entities.Egresado;
import com.escomcareer.services.AspiranteService;
import com.escomcareer.services.EgresadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    private AspiranteService aspiranteService;

    @Autowired
    private EgresadoService egresadoService;

    @PostMapping
    public String login(@RequestParam String email, @RequestParam String password) {
        Optional<Aspirante> aspirante = aspiranteService.authenticate(email, password);
        Optional<Egresado> egresado = egresadoService.authenticate(email, password);

        if (aspirante.isPresent()) {
            return "Aspirante";
        } else if (egresado.isPresent()) {
            return "Egresado";
        } else {
            return "Correo o contraseña incorrectos";
        }
    }
}
