package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Empleados;

/*
 *@author Nicol 
 */


public interface IEmpleadosDAO extends JpaRepository<Empleados,Long> {
	
	
	//Listar empleados por campo nombre
	public List<Empleados> findByNombre(String nombre);
	
	//Listar empleados por campo trabajo
	public List<Empleados> findByTrabajo(String trabajo);
}
