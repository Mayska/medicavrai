package com.medicavrai.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "homeopathie")
public class Homeopathie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nom_homeopathie")
	private String nomHomeopathie;

	@Column(name = "description_homeopathie")
	private String descriptionHomeopathie;
}
