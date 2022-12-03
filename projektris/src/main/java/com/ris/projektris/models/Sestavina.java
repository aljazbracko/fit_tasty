package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class Sestavina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSestavina;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRecept")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Recept recept;

	private String kolicina;
	private String ime;

	public Long getIdSestavina() {
		return idSestavina;
	}

	public void setIdSestavina(Long idSestavina) {
		this.idSestavina = idSestavina;
	}

	public Recept getRecept() {
		return recept;
	}

	public void setRecept(Recept recept) {
		this.recept = recept;
	}

	public String getKolicina() {
		return kolicina;
	}

	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getIme() {
		return this.ime;
	}

}