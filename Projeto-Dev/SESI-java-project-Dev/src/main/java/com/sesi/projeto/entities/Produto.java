package com.sesi.projeto.entities;

import com.sesi.projeto.dto.ProdutoDTO;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double preco;
	private String descricao;
	private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_produto_categoria",
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();

	@OneToMany(mappedBy = "id.produto")
	private Set<ItemDoPedido> itens = new HashSet<>();
	public Set<ItemDoPedido> getItens(){
		return itens;
	}

	public List<Pedido> getPedido(){
		return itens.stream().map(x -> x.getPedido()).toList();
	}

	public Produto() {

	}

	public Produto(ProdutoDTO d) {
		this.nome = d.nome();
		this.preco = d.preco();
		this.descricao = d.descricao();
		this.imgUrl = d.imgUrl();
	}

	public Produto(Long id, String nome, double preco, String descricao, String imgUrl) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imgUrl = imgUrl;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}