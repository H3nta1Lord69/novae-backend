package com.novae.back.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Carlos Garcia
 * Declaración tabla Person
 *
 */

@Entity
@Table (name = "person")
public class Person implements Serializable {

	/**
	 * Table Values
	 * id_person: Autoincrement, Long, Primary Key
	 * name_person: String
	 * uid (User identification): String, Unique
	 * email: String, Unique
	 * password: String
	 * person_id: Primary Key, OneToMany relation
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_person")
	private Long idPerson;
	
	@Column (name = "name_person")
	private String namePerson;
	
	@Column (name = "uid", unique = true)
	private String uid;

	@Column (name = "email", unique = true)
	private String email;

	@Column (name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id_person")
	private List<Card> card = new ArrayList<>();

	/**
	 * Empty Constructor
	 */
	public Person(){

	}

	/**
	 * Individual Getters & Setters
	 */

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Card> getCard() {
		return card;
	}

	public void setCard(List<Card> card) {
		this.card = card;
	}

	private static final long serialVersionUID = 1l;
}
