package com.sesi.projeto.entities;

import com.sesi.projeto.dto.ItemDoPedidoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_item_pedido")
public class ItemDoPedido {

    @EmbeddedId
    private ItemDoPedidoPK id = new ItemDoPedidoPK();

    private Double preco;
    private int  quantidade;

    public ItemDoPedido(Pedido pedido, Produto produto, int quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;

    }

    public ItemDoPedido() {
    }

    public ItemDoPedido(ItemDoPedidoDTO dtoitempedido){
        this.quantidade = dtoitempedido.quantidade();
        this.preco = dtoitempedido.preco();
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public  void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }


    public ItemDoPedidoPK getId() {
        return id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setId(ItemDoPedidoPK id) {
        this.id = id;
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }


}