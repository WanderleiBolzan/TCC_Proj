package com.uspEsalq.mba.ahp.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.entities.Carteira;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CarteiraItemPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "carteira_id")
	private Carteira carteira;

	@ManyToOne
	@JoinColumn(name = "ativo_id")	
	private Ativos ativos;
	
	public Carteira getCarteira() {
		return carteira;
	}
	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}
	public Ativos getAtivos() {
		return ativos;
	}
	public void setAtivos(Ativos ativos) {
		this.ativos = ativos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carteira == null) ? 0 : carteira.hashCode());
		result = prime * result + ((ativos == null) ? 0 : ativos.hashCode());
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
		CarteiraItemPk other = (CarteiraItemPk) obj;
		return Objects.equals(ativos, other.ativos) && Objects.equals(carteira, other.carteira);
	}
	
	

}
