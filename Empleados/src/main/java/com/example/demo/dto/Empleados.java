package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Empleados") // en caso que la tabla sea diferente
public class Empleados {

	// ENUM
	public enum Trabajos {
		DESARROLLADOR, CONTADOR, ADMINISTRADOR, AUXILIAR
	}

	// Atributos de entidad Empleados
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Busca ultimo valor e incrementa desde id final de db
	private Long id;

	@Column(name = "nombre") // no hace falta si se llama igual
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "salario")
	private Double salario;

	@Column(name = "trabajo")
	private Trabajos trabajo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;

	// Constructores
	public Empleados() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param salario
	 * @param trabajo
	 * @param fecha
	 */

	public Empleados(Long id, String nombre, String apellido, Double salario, Trabajos trabajo, Date fecha) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.trabajo = trabajo;
		this.fecha = fecha;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the salario
	 */
	public Double getSalario() {
		return salario;
	}

	/**
	 * @return the trabajo
	 */
	public Trabajos getTrabajo() {
		return trabajo;
	}

	/**
	 * @param trabajo the trabajo to set
	 */
	public void setTrabajo(Trabajos trabajo) {
		
		switch(trabajo) {
		case DESARROLLADOR:
			this.trabajo = trabajo.DESARROLLADOR;
			this.salario = (double) 2500;
			break;
		case CONTADOR:
			this.trabajo = trabajo.CONTADOR;
			this.salario = (double) 1400;
			break;
		case  ADMINISTRADOR:
			this.trabajo = trabajo.ADMINISTRADOR;
			this.salario = (double) 3000;
			break;
		case AUXILIAR:
			this.trabajo = trabajo.AUXILIAR;
			this.salario = (double) 1600;
			break;
		}
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Empleado [id= " + id + ", nombre= " + nombre + ", apellido= " + apellido + ", salario= " + salario
				+ ", trabajo= " + trabajo + ", fecha= " + fecha + "]";
	}
}
