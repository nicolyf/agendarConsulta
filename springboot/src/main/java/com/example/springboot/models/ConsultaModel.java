package com.example.springboot.models;

import com.example.springboot.enums.EstadoSessaoEnum;
import com.example.springboot.enums.TipoSessaoEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
public class ConsultaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String avaliacoes;
    private LocalDateTime dateTime;
    private TipoSessaoEnum tipoSessao;
    private EstadoSessaoEnum estadoSessao;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UserModel usuario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissional_id", referencedColumnName = "id")
    private ProfissionalModel profissional;
    @OneToOne(mappedBy = "consulta")
    private AvaliacaoModel avaliacao;

    public AvaliacaoModel getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(AvaliacaoModel avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(String avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TipoSessaoEnum getTipoSessao() {
        return tipoSessao;
    }

    public void setTipoSessao(TipoSessaoEnum tipoSessao) {
        this.tipoSessao = tipoSessao;
    }

    public EstadoSessaoEnum getEstadoSessao() {
        return estadoSessao;
    }

    public void setEstadoSessao(EstadoSessaoEnum estadoSessao) {
        this.estadoSessao = estadoSessao;
    }

    public UserModel getUser() {
        return usuario;
    }

    public void setUser(UserModel user) {
        this.usuario = user;
    }

    public ProfissionalModel getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalModel profissional) {
        this.profissional = profissional;
    }
}
