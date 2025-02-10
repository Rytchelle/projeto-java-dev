package com.sesi.projeto.entities;

import com.sesi.projeto.dto.UsuarioDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String senha;
    private String role;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Usuario(Long id, String name, String email, String telefone, String senha, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.role = role;
    }

    public Usuario() {
    }

    public  Usuario(UsuarioDTO dtouser){
        this.name = dtouser.name();
        this.email = dtouser.email();
        this.senha = dtouser.senha();
        this.telefone = dtouser.telefone();
        this.role = dtouser.role();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}