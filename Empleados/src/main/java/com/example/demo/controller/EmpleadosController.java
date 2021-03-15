package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleados;
import com.example.demo.dto.Empleados.trabajos;
import com.example.demo.service.EmpleadosServiceImpl;


@RestController
@RequestMapping("/unidad24")
public class EmpleadosController {

	@Autowired
	EmpleadosServiceImpl empleadosServiceImpl;	

	@GetMapping("/empleados")
	public List<Empleados> listarEmpleados() {
		return empleadosServiceImpl.listarEmpleados();
	}
	
	//Listar empleados por campo nombre
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleados> listarEmpleadosNombre(@PathVariable(name="nombre") String nombre){
		return empleadosServiceImpl.listarEmpleadoNombre(nombre);
	}
	
	//Listar empleados por campo trabajo
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleados> listarEmpleadosTrabajo(@PathVariable(name="trabajo") trabajos trabajo){
			return empleadosServiceImpl.listarEmpleadoTrabajo(trabajo);
		
	}
	
	@PostMapping("/empleados")
	public Empleados salvarEmpleado(@RequestBody Empleados empleado) {
		
		return empleadosServiceImpl.guardarEmpleado(empleado);
	}
	
	@GetMapping("/empleados/{id}")
	public Empleados empleadoXID(@PathVariable(name="id")Long id) {
		Empleados empleado_xid=new Empleados();
		
		empleado_xid=empleadosServiceImpl.empleadoXID(id);
		
		System.out.println("Cliente xID:");
		
		return empleado_xid;
	}
	
	@PutMapping("/empleados/{id}")
	public Empleados actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleados empleado) {
		Empleados empleado_seleccionado=new Empleados();
		Empleados empleado_actualizado=new Empleados();
		
		empleado_seleccionado=empleadosServiceImpl.empleadoXID(id);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellido(empleado.getApellido());
		empleado_seleccionado.setTrabajo(empleado.getTrabajo());
		empleado_seleccionado.setFecha(empleado.getFecha());
		empleado_actualizado=empleadosServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		
		System.out.println("El empleado seleccionado es: "+empleado_actualizado);
		
		return empleado_actualizado;
	}
	
	@DeleteMapping("/empleados/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")Long id) {
		empleadosServiceImpl.eliminarEmpleado(id);
	}
}
