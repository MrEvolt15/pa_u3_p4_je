package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.respository.EstudianteRespository;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRespository estudianteRespository;
	
	@Override
	public void guardar(Estudiante estu) {
		this.estudianteRespository.insertar(estu);
		
	}

	@Override
	public void borrar(String cedula) {
		this.estudianteRespository.eliminar(cedula);
		
	}

	@Override
	public Estudiante buscarPorCD(String cedula) {
		
		return this.estudianteRespository.seleccionarPorCD(cedula);
	}

	@Override
	public void actualizar(Estudiante estu) {
		this.estudianteRespository.actualizar(estu);
		
	}

	@Override
	public Estudiante buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> reportePorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarListaPorApellido(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoYNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorApellidoYNombre(apellido, nombre);
	}

	@Override
	public Estudiante buscarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorApellidoTyped(apellido);
	}

	@Override
	public Estudiante buscaPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorApellidoNamed(apellido);
	}

	@Override
	public Estudiante buscaPorApellidoNamedQuery(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorApellidoNamedQuery(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNativeQuery(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorApellidoNativeQuery(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorApellidoNativeQueryNamed(apellido);
	}

	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorNombreNamedQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRespository.seleccionarPorNombreNativeQueryNamed(nombre);
	}

}
