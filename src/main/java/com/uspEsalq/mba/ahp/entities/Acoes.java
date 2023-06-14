package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Acoes")
public class Acoes implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String cd_Acao;
//	@OneToMany(mappedBy = "acoes_empresa", cascade = CascadeType.ALL)
	private Long id_Empresa;
//	@OneToMany(mappedBy = "acoes_Segmmentos", cascade = CascadeType.ALL)	
	private Long id_Segmento;
	
	public Acoes() {		
	}

	public Acoes(Long id, String cd_Acao, Long id_Empresa, Long id_Segmento) {
		super();
		this.id = id;
		this.cd_Acao = cd_Acao;
		this.id_Empresa = id_Empresa;
		this.id_Segmento = id_Segmento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acoes other = (Acoes) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCd_Acao() {
		return cd_Acao;
	}

	public void setCd_Acao(String cd_Acao) {
		this.cd_Acao = cd_Acao;
	}

	public Long getId_Empresa() {
		return id_Empresa;
	}

	public void setId_Empresa(Long id_Empresa) {
		this.id_Empresa = id_Empresa;
	}

	public Long getId_Segmento() {
		return id_Segmento;
	}

	public void setId_Segmento(Long id_Segmento) {
		this.id_Segmento = id_Segmento;
	}
	
	
}
