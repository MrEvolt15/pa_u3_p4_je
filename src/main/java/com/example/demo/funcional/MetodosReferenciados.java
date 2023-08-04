package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public static Integer getId() {
		return 8;
	}
	public static String getIdHO() {
		LOG.info("Metodos referenciado");
		return "Joel Espinosa";
	}
	public static void aceptar(Integer arg) {
		String cadena = "Joel";
		LOG.info(cadena+ " "+ arg);
	}
	public static boolean evaluar(Integer arg) {
		
		if(arg.compareTo(100)<0) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public static String aplicarf(Integer arg) {
		String resultado = "palabra secreta";
		
		return  "La letra es: "+resultado.charAt(arg);
	}
	public static String aplicaru(String arg) {
		String resultado = "val: ";
		
		return resultado.concat(arg);
	}
	public static Integer aplicarUInteger(Integer arg) {
		Integer valorInicial =0;
		return valorInicial+arg;
	}
}
