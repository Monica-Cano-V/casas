package com.ventas.casas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registro")
public class Registro {
	@Column
	@Id
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private float presupuesto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public float getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}
	public Registro(int id, String nombre, String apellido, float presupuesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.presupuesto = presupuesto;
	}
	@Override
	public String toString() {
		return "Registro [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", presupuesto=" + presupuesto
				+ "]";
	}
	public Registro() {
		super();
	}
	
	

}
