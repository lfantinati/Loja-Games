package com.lojagames.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message ="O Atributo Descrição é obrigatorio" )
    private String descricao;

    /*@NotBlank(message = "O atibuto Tiro é Obrigatorio!")
    @Size(min = 5, max = 100,message = "O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres")
    private String Tiro;

    @NotBlank(message = "O atibuto Corrida é Obrigatorio!")
    @Size(min = 5, max = 100,message = "O atributo texto deve conter no minimo 5 e no maximo 100 caracteres")
    private String Corrida;

    @NotBlank(message = "O atibuto RPG é Obrigatorio!")
    @Size(min = 5, max = 100,message = "O atributo texto deve conter no minimo 5 e no maximo 100 caracteres")
    private String RPG;

    @NotBlank(message = "O atibuto MultiPlataforma é Obrigatorio!")
    @Size(min = 5, max = 100,message = "O atributo texto deve conter no minimo 5 e no maximo 100 caracteres")
    private String MultiPlataforma;*/

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("")
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*public String getTiro() {
        return Tiro;
    }

    public void setTiro(String tiro) {
        Tiro = tiro;
    }

    public String getCorrida() {
        return Corrida;
    }

    public void setCorrida(String corrida) {
        Corrida = corrida;
    }

    public String getRPG() {
        return RPG;
    }

    public void setRPG(String RPG) {
        this.RPG = RPG;
    }

    public String getMultiPlataforma() {
        return MultiPlataforma;
    }

    public void setMultiPlataforma(String multiPlataforma) {
        MultiPlataforma = multiPlataforma;
    }*/

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


}