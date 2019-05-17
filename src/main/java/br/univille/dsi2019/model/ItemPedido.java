package br.univille.dsi2019.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Produto produto;
	private int quantidade;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
