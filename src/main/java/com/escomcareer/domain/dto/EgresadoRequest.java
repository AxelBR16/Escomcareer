package com.escomcareer.domain.dto;


import lombok.Data;

@Data
public class EgresadoRequest {
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private int carreraId;
}
