package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadosDAO;
import com.example.demo.dto.Empleados;
import com.example.demo.dto.Empleados.trabajos;

@Service
public class EmpleadosServiceImpl implements IEmpleadosService{
	
	//Utilizamos los metodos de la interface IEmpleadosDAO, es como si instaciaramos.
	
	@Autowired
	IEmpleadosDAO iEmpleadosDAO;
	
	@Override
	public List<Empleados> listarEmpleados() {
		
		return iEmpleadosDAO.findAll();
	}

	@Override
	public Empleados guardarEmpleado(Empleados empleados) {
		
		return iEmpleadosDAO.save(empleados);
	}

	@Override
	public Empleados empleadoXID(Long id) {
		return iEmpleadosDAO.findById(id).get();
	}

	@Override
	public List<Empleados> listarEmpleadoNombre(String nombre) {
		return iEmpleadosDAO.findByNombre(nombre);
	}
	
	@Override
	public List<Empleados> listarEmpleadoTrabajo(trabajos trabajo) {
		return iEmpleadosDAO.findByTrabajo(trabajo);
	}


	@Override
	public Empleados actualizarEmpleado(Empleados empleado) {
		return iEmpleadosDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		iEmpleadosDAO.deleteById(id);
	}

}
