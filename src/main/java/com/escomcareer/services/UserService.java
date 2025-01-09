package com.escomcareer.services;

import com.escomcareer.domain.entities.User;

import java.util.List;

public interface UserService {
    List<User> listarUsuarios();
    User guardarUsuario(User usuario);
}
