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
@Table (name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id_person")
	private Long idPerson;
	
	@Column (name = "name_person")
	private String namePerson;
	
	@Column (name = "uid", unique = true)
	private String uid;

	public Person(String namePerson, String uid) {
		super();
		this.namePerson = namePerson;
		this.uid = uid;
	}

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

}
