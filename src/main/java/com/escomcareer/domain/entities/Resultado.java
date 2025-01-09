package com.escomcareer.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Resultado {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private User usuario;

        @ManyToOne
        @JoinColumn(name = "escala_id", nullable = false)
        private Escala escala;

        @Column(nullable = false)
        private int ponderacion;

        public Resultado() {
        }

        public Resultado(Long id, User usuario, Escala escala, int ponderacion) {
            this.id = id;
            this.usuario = usuario;
            this.escala = escala;
            this.ponderacion = ponderacion;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public User getUsuario() {
            return usuario;
        }

        public void setUsuario(User usuario) {
            this.usuario = usuario;
        }

        public Escala getEscala() {
            return escala;
        }

        public void setEscala(Escala escala) {
            this.escala = escala;
        }

        public int getPonderacion() {
            return ponderacion;
        }

        public void setPonderacion(int ponderacion) {
            this.ponderacion = ponderacion;
        }

        @Override
        public String toString() {
            return "Resultado{" +
                    "id=" + id +
                    ", usuario=" + usuario +
                    ", escala=" + escala +
                    ", ponderacion=" + ponderacion +
                    '}';
        }
    }

