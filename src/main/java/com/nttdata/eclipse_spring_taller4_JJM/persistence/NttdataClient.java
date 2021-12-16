package com.nttdata.eclipse_spring_taller4_JJM.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Proyecto Spring taller 3.
 *
 * Clase de la entidad Cliente.
 * 
 * @author Javier Jiménez Montesinos.
 *
 */
@Entity
@Table(name = "CLIENTE")
public class NttdataClient implements Serializable {

	/**
	 * Version
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * ID del cliente [PK].
	 */
	private Integer idClient;

	/*
	 * Nombre del Cliente.
	 */
	private String name;

	/*
	 * Apellido del cliente.
	 */
	private String lastName;

	/*
	 * DNI del cliente [Unique].
	 */
	private String DNI;

	/*
	 * Fecha de nacimiento del cliente.
	 */
	private String fechaNacimiento;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@Column(name = "NOMBRE", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "APELLIDOS", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "DNI", nullable = false, unique = true)
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	@Column(name = "FECHA_DE_NACIMIENTO", nullable = false)
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "NttdataClient [idClient=" + idClient + ", name=" + name + ", lastName=" + lastName + ", DNI=" + DNI
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
