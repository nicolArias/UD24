package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Empleados;

public interface IEmpleadosService {
	
	//Metodos del CRUD
	public List<Empleados> listarEmpleados(); //Listar todo
	
	public Empleados guardarEmpleado(Empleados empleados);//Guarda un empleado CREATE
	
	public Empleados empleadoXID(Long id);//Leer datos de un empleado READ
	
	public List<Empleados> listarEmpleadoNombre(String nombre);//Listar empleados por campo nombre
	
	public List<Empleados> listarEmpleadoTrabajo(String trabajo);//Listar empleados por campo trabajo
	
	public Empleados actualizarEmpleado(Empleados empleado);//Actiañoza datos del empleado UPDATE
	
	public void eliminarEmpleado(Long id);//Elimina el cliente DELETE
}
