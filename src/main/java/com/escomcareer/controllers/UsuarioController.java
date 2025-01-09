package com.escomcareer.controllers;

import com.escomcareer.domain.entities.User;
import com.escomcareer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"*"})

public class UsuarioController {
    @Autowired
    private UserService usuarioService;

    @GetMapping
    public List<User> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public ResponseEntity<User> guardarUsuario(@RequestBody User usuario) {
        User usuarioGuardado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(usuarioGuardado);
    }
}
