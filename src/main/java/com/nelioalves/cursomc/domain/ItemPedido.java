package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.BitSet;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "ITEM_PEDIDO")
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id;
    private BigDecimal desconto;
    private Integer quantidade;
    private BigDecimal preco;

    public ItemPedido() {
        this.id = new ItemPedidoPK();
    }

    public ItemPedido(Pedido pedido, Produto produto, BigDecimal desconto, Integer quantidade, BigDecimal preco) {
        this.id = new ItemPedidoPK(pedido, produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return this.getId().getPedido();
    }

    public void setPedido(Pedido pedido) {
        this.id.setPedido(pedido);
    }

    public Produto getProduto() {
        return this.getId().getProduto();
    }

    public void setProduto(Produto produto) {
        this.id.setProduto(produto);
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getSubTotal() {
        return preco.subtract(desconto).multiply(new BigDecimal(quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        final StringBuilder sb = new StringBuilder();
        sb.append(getProduto().getNome());
        sb.append(", Desconto: ").append(desconto);
        sb.append(", Quantidade: ").append(quantidade);
        sb.append(", Preco: ").append(nf.format(preco));
        sb.append(", Sub-total: ").append(nf.format(getSubTotal()));
        sb.append('\n');
        return sb.toString();
    }
}
