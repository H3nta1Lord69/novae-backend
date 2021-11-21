package com.novae.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Carlos Garcia
 * Declaración tabla Card
 *
 */

@Entity
@Table (name = "franchise")
public class Franchise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id_franchise")
	private Long idFranchise;
	
	@Column (name = "name_franchise", unique = true)
	private String nameFranchise;

	public Franchise(String nameFranchise) {
		super();
		this.nameFranchise = nameFranchise;
	}

	public Long getIdFranchise() {
		return idFranchise;
	}

	public void setIdFranchise(Long idFranchise) {
		this.idFranchise = idFranchise;
	}

	public String getNameFranchise() {
		return nameFranchise;
	}

	public void setNameFranchise(String nameFranchise) {
		this.nameFranchise = nameFranchise;
	}

}
