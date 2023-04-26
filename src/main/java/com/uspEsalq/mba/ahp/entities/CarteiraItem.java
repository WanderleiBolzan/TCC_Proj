package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uspEsalq.mba.ahp.entities.pk.CarteiraItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carteira_item")
public class CarteiraItem implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CarteiraItemPk id = new CarteiraItemPk();
	
	private Long id_Empresa;
	private Instant Data;
	private Integer Quantidade;
	private Double abertura;
	private Double maxima;
	private Double minima;
	private Double fechamento;
	private Double volume;
	private Double preco_ajustado;
	private Double maxima_Anterior;
	private Double minima_Anterior;
	private Double compra;
	private Double venda;
	private Double resultados;
	
	public CarteiraItem() {		
	}

	public CarteiraItem(Carteira carteira, Ativos ativo, Long id_Empresa, Instant data, Integer quantidade, Double abertura,
			Double maxima, Double minima, Double fechamento, Double volume, Double preco_ajustado,
			Double maxima_Anterior, Double minima_Anterior, Double compra, Double venda, Double resultados) {
		super();
		id.setCarteira(carteira);
		id.setAtivos(ativo);
		this.id_Empresa = id_Empresa;
		this.Data = data;
		this.Quantidade = quantidade;
		this.abertura = abertura;
		this.maxima = maxima;
		this.minima = minima;
		this.fechamento = fechamento;
		this.volume = volume;
		this.preco_ajustado = preco_ajustado;
		this.maxima_Anterior = maxima_Anterior;
		this.minima_Anterior = minima_Anterior;
		this.compra = compra;
		this.venda = venda;
		this.resultados = resultados;
	}
	
	@JsonIgnore
	public Carteira getCarteira() {
		return id.getCarteira();
	}
	
	public void setCarteira(Carteira carteira) {
		id.setCarteira(carteira);
	}
	
	public Ativos getAtivos() {
		return id.getAtivos();
	}
	
	public void setAtivos(Ativos ativos) {
		id.setAtivos(ativos);
	}
	
	public Long getId_Empresa() {
		return id_Empresa;
	}

	public void setId_Empresa(Long id_Empresa) {
		this.id_Empresa = id_Empresa;
	}

	public Instant getData() {
		return Data;
	}

	public void setData(Instant data) {
		Data = data;
	}

	public Integer getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}

	public Double getAbertura() {
		return abertura;
	}

	public void setAbertura(Double abertura) {
		this.abertura = abertura;
	}

	public Double getMaxima() {
		return maxima;
	}

	public void setMaxima(Double maxima) {
		this.maxima = maxima;
	}

	public Double getMinima() {
		return minima;
	}

	public void setMinima(Double minima) {
		this.minima = minima;
	}

	public Double getFechamento() {
		return fechamento;
	}

	public void setFechamento(Double fechamento) {
		this.fechamento = fechamento;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getPreco_ajustado() {
		return preco_ajustado;
	}

	public void setPreco_ajustado(Double preco_ajustado) {
		this.preco_ajustado = preco_ajustado;
	}

	public Double getMaxima_Anterior() {
		return maxima_Anterior;
	}

	public void setMaxima_Anterior(Double maxima_Anterior) {
		this.maxima_Anterior = maxima_Anterior;
	}

	public Double getMinima_Anterior() {
		return minima_Anterior;
	}

	public void setMinima_Anterior(Double minima_Anterior) {
		this.minima_Anterior = minima_Anterior;
	}

	public Double getCompra() {
		return compra;
	}

	public void setCompra(Double compra) {
		this.compra = compra;
	}

	public Double getVenda() {
		return venda;
	}

	public void setVenda(Double venda) {
		this.venda = venda;
	}

	public Double getResultados() {
		return resultados;
	}

	public void setResultados(Double resultados) {
		this.resultados = resultados;
	}
	
	public Set<CarteiraItem> getItems() {
		return getItems();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteiraItem other = (CarteiraItem) obj;
		return Objects.equals(id, other.id);
	}

}
