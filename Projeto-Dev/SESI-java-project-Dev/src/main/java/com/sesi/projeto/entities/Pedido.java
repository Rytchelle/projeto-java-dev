package com.sesi.projeto.entities;

import com.sesi.projeto.dto.PedidoDTO;
import jakarta.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "tb_pedido")
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momento;
    private StatusDoPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    //
    @OneToMany(mappedBy =  "id.pedido")
    private Set<ItemDoPedido> itens = new HashSet<>();
    public Set<ItemDoPedido> getItens(){
        return itens;
    }
    public List<Produto> getProduto(){
        return itens.stream().map(x -> x.getProduto()).toList();
    }

    public Pedido(Long id, Instant momento, StatusDoPedido status) {
        this.id = id;
        this.momento = momento;
        this.status = status;
    }


    public Pedido() {
    }

    public Pedido(PedidoDTO dtopedido){
        this.momento = dtopedido.momento();
        this.status = dtopedido.status();
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}