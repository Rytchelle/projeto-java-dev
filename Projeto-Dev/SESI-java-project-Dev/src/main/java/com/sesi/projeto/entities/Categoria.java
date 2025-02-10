package com.sesi.projeto.entities;

import com.sesi.projeto.dto.CategoriaDTO;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "categorias")
    private Set<Produto> produtos = new HashSet<>();

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria() {
    }

    public Categoria(CategoriaDTO dtocategoria){
        this.nome = dtocategoria.nome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}