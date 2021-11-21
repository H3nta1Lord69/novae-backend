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

	/**
	 * Table Values
	 * id_card: Autoincrement, Long, Primary Key
	 * num_card: String, unique
	 * name_card: String
	 * cvv: String
	 * expired_date: String
	 * status: Boolean
	 * created_at: Date
	 * person_id: Foreign Key, Long, Many to One
	 */
	
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

	@Column (name = "franchise")
	private String franchise;

	@Column (name = "status")
	private boolean status;

	@Column (name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@Column(name = "person_id")
	private Long personId;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public Card() {

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

	public String getFranchise() {
		return franchise;
	}

	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	private static final long serialVersionUID = 1l;

}
