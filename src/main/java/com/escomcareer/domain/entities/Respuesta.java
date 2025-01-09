package com.escomcareer.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @Column(nullable = false)
    private int respuesta;

    public Respuesta() {
    }

    public Respuesta(Long id, Pregunta pregunta, User usuario, int respuesta) {
        this.id = id;
        this.pregunta = pregunta;
        this.usuario = usuario;
        this.respuesta = respuesta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "id=" + id +
                ", pregunta=" + pregunta +
                ", usuario=" + usuario +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }
}
