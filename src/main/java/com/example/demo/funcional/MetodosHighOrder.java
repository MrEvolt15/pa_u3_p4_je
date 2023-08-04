package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	public static void metodo(IPersonaSupplier<String> funcion) {
		funcion.getId();
		LOG.info("High Order Supplier: "+ funcion.getId());
	}
	public static void metodoConsumer(IPersonaConsumer<String> funcion, String arg) {
		funcion.accept(arg);
	}
	
	
	public static void metodoFunction(IPersonaFunction<Character, Integer> funcion, Integer arg) {
		funcion.aplicar(arg);
		LOG.info("High Order Function: "+ funcion.aplicar(arg));
	}
	public static void metodoPredicate(IPersonaPredicate<Integer> funcion,Integer arg) {
		funcion.evaluar(arg);
		LOG.info("High Order Predicate: "+ funcion.evaluar(arg));
	}
	public static void metodoUnaryOperator(IPersonaUnaryOperator<String> funcion, String arg) {
		funcion.aplicar(arg);
		LOG.info("High Order Unary Operator: "+ funcion.aplicar(arg));
	}
}

