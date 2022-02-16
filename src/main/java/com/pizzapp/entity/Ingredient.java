package com.pizzapp.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id_ingredient")
	private String id;
	@Column(name = "dv_cheese")
	private String cheese;
	@Column(name = "dv_sauce")
	private String sauce;
	@Column(name = "dv_mass")
	private String mass;
	@Column(name = "dv_topping")
	private String topping;
	@Column(name = "dv_olive")
	private String olive;
	@Column(name = "dv_status")
	private Boolean status;

}
