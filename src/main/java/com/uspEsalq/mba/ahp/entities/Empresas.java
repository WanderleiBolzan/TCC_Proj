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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_empresas")
public class Empresas implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private Long id_Segmento;
	private String razao_Social;
	private String acao;
		
	@JsonIgnore
	@ManyToMany(mappedBy = "empresas")
	private Set<Ativos> ativos = new HashSet<>();
	//
	public Empresas() {
	}

	public Empresas (Long id, Long id_segmento, String razao_social,String acao) {
		super();
		this.id = id;
		this.id_Segmento = id_segmento;
		this.razao_Social = razao_social;
		this.acao = acao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_Segmento() {
		return id_Segmento;
	}

	public void setId_Segmento(Long id_segmento) {
		this.id_Segmento = id_segmento;
	}

	public String getRazao_Social() {
		return razao_Social;
	}

	public void setRazao_Social(String razao_social) {
		this.razao_Social = razao_social;
	}

	public Set<Ativos> getAtivos() {
		return ativos;
	}
	
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
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
		Empresas other = (Empresas) obj;
		return Objects.equals(id, other.id);
	}
	
}
