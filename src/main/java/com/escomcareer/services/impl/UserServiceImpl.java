package com.escomcareer.services.impl;

import com.escomcareer.domain.entities.User;
import com.escomcareer.domain.repositories.UserRepository;
import com.escomcareer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> listarUsuarios() {
        return (List<User>) usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public User guardarUsuario(User usuario) {
        return usuarioRepository.save(usuario);
    }
}
