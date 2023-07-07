package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	public void guardar(Estudiante estu);
	public void borrar(String cedula);
	public Estudiante buscarPorCD(String cedula);
	public void actualizar(Estudiante estu);
	public Estudiante buscarPorApellido(String apellido);
	public List<Estudiante> reportePorApellido(String apellido);
	public Estudiante buscarPorApellidoYNombre(String apellido,String nombre);

	public Estudiante buscarPorApellidoTyped(String apellido);
	public Estudiante buscaPorApellidoNamed(String apellido);
	public Estudiante buscaPorApellidoNamedQuery(String apellido);
	

	public Estudiante buscarPorApellidoNativeQuery(String apellido);
	
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido);
	

	public Estudiante buscarPorNombreNamedQuery(String nombre);
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre);
}
