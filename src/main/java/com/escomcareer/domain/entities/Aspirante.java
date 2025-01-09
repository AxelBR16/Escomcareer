package com.escomcareer.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aspirante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 100) // Especifica el nombre de la columna, que no puede ser nula, y establece un tamaño de 100 caracteres.
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100) // Similar al anterior, con las mismas restricciones.
    private String apellido;

    @Column(name = "email", nullable = false, unique = true, length = 150) // Columna de email, que debe ser única y con un tamaño máximo de 150 caracteres.
    private String email;

    @Column(name = "password", nullable = false, length = 255) // Columna de password, con longitud de 255 caracteres.
    private String password;
}
