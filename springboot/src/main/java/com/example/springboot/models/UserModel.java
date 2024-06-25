package com.example.springboot.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoModel endereco;
    @OneToMany(mappedBy = "usuario")
    private List<AvaliacaoModel> avaliacoes;
    @OneToMany(mappedBy = "usuario")
    private List<ConsultaModel> consultas;


    public EnderecoModel getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<AvaliacaoModel> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoModel> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<ConsultaModel> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaModel> consultas) {
        this.consultas = consultas;
    }
}