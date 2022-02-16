package com.pizzapp.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Menu {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id_menu")
	private String id;

	// Seleccion de entre, vegano, celiaco, clasica
	@Column(name = "dv_name")
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dv_load")
	private Date load;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dv_edit")
	private Date edit;
	@Column(name = "dv_status")
	private Boolean status;

	@OneToOne
	private Photo photo;

}
