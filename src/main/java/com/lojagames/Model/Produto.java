package com.lojagames.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


// MONTAGEM DAS TABELAS NO BANCO DE DADOS
// NOME DA TABELA

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O atibuto titulo é Obrigatorio!")
    @Size(min = 5, max = 100,message = "O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres")
    private String nome;

    @NotBlank(message = "O atibuto texto é Obrigatorio!")
    @Size(min = 3, max = 100,message = "O atributo texto deve conter no minimo 5 e no maximo 100 caracteres")
    private String preco;

    @NotBlank(message = "O atibuto texto é Obrigatorio!")
    @Size(min = 5, max = 100,message = "O atributo texto deve conter no minimo 5 e no maximo 100 caracteres")
    private String tipo;

    @UpdateTimestamp
    private LocalDateTime data;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}