package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Tb_Ativos")
public class Ativos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Ativo;
	private Long id_Segmento; 
	private Long id_Empresa;
	private Double preco;

	@ManyToMany
	@JoinTable(name = "ativos_empresas", joinColumns = @JoinColumn(name = "ativo_id"),inverseJoinColumns = @JoinColumn(name = "empresa_id"))
	private Set<Empresas> empresas = new HashSet<>();
	
	@OneToMany(mappedBy = "id.ativos")
	private Set<CarteiraItem> items = new HashSet<>();
	
	public Ativos() {	
	}

	public Ativos(Long id, String ativo, Long id_Segmento, Long id_Empresa, Double preco) {
		super();
		this.id = id;
		Ativo = ativo;
		this.id_Segmento = id_Segmento;
		this.id_Empresa = id_Empresa;
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CarteiraItem> getItems() {
		return items;
	}

	public void setItems(Set<CarteiraItem> items) {
		this.items = items;
	}

	public String getAtivo() {
		return Ativo;
	}

	public void setAtivo(String ativo) {
		Ativo = ativo;
	}

	public Long getId_Segmento() {
		return id_Segmento;
	}

	public void setId_Segmento(Long id_Segmento) {
		this.id_Segmento = id_Segmento;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId_Empresa() {
		return id_Empresa;
	}

	public void setEmpresas(Set<Empresas> empresas) {
		this.empresas = empresas;
	}

	public void setId_Empresa(Long id_Empresa) {
		this.id_Empresa = id_Empresa;
	}

	public Set<Empresas> getEmpresas() {
		return empresas;
	}

	@JsonIgnore
	public Set<Carteira> getCarteiras() {
		Set<Carteira> set = new HashSet<>();
		for (CarteiraItem x : items) {
			set.add(x.getCarteira());
		}
		return set;
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
		Ativos other = (Ativos) obj;
		return Objects.equals(Ativo, other.Ativo) && Objects.equals(empresas, other.empresas)
				&& Objects.equals(id, other.id) && Objects.equals(id_Empresa, other.id_Empresa)
				&& Objects.equals(id_Segmento, other.id_Segmento) && Objects.equals(preco, other.preco);
	}

}
