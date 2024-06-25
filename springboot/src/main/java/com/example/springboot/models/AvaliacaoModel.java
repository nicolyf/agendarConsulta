package com.example.springboot.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "avaliacao")
public class AvaliacaoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private LocalDateTime dateTime = LocalDateTime.now();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UserModel usuario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consulta_id", referencedColumnName = "id")
    private ConsultaModel consulta;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UserModel getUser() {
        return usuario;
    }

    public void setUser(UserModel user) {
        this.usuario = user;
    }

    public ConsultaModel getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaModel consulta) {
        this.consulta = consulta;
    }


}
