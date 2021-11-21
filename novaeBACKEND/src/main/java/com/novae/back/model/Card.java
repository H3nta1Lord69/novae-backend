package com.novae.back.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Carlos Garcia
 * Declaración tabla Card
 *
 */
@Entity
@Table (name = "card")
public class Card implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_card")
	private Long idCard;
	
	@Column (name = "num_card", unique = true)
	private String numCard;
	
	@Column (name = "name_card")
	private String nameCard;
	
	@Column (name = "cvv")
	private String cvv;
	
	@Column (name = "expired_date")
	private String expiredDate;

	@Column (name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	@OneToOne
	@JoinColumn (name = "franchise_id_franchise")
	private Franchise franchise;
	
	@ManyToOne
	@JoinColumn (name = "person_id_person")
	private Person person;
	
	public Card(String numCard, String nameCard, String cvv, String expiredDate, Franchise franchise, Person person) {
		super();
		this.numCard = numCard;
		this.nameCard = nameCard;
		this.cvv = cvv;
		this.expiredDate = expiredDate;
		this.createAt = createAt;
		this.franchise = franchise;
		this.person = person;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public String getNameCard() {
		return nameCard;
	}

	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date expiredDate) {
		this.createAt = expiredDate;
	}

	public Franchise getFranchise() {
		return franchise;
	}

	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	private static final long serialVersionUID = 1l;

}
