package com.example.springboot.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "profissional")
public class ProfissionalModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String especializacao;
    private String telefone;
    private String crm;
    @OneToMany(mappedBy = "profissional")
    private List<ConsultaModel> consultas;
    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }


    public List<ConsultaModel> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaModel> consultas) {
        this.consultas = consultas;
    }
}
