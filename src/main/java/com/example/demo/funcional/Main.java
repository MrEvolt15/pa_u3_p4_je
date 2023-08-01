package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPersona per = new PersonaImpl();
		per.caminar();
		// 1. Supplier

		// Clases:

		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase:" + supplier1.getId());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "17522859486";
		LOG.info("Supplier1 lambda:" + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1564156";
			cedula = cedula + "zzzzzzzzzz";
			return cedula;
		};
		LOG.info("Supplier2 lambda:" + supplier3.getId());

		//Metodos referenciados
		MetodosReferenciados metodos= new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4= metodos::getId;
		LOG.info("Supplier metodo referenciado:" + supplier4.getId());
	
		
		// 2. CONSUMER

		// Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Cosumer clase:");
		consumer1.accept("Nelson Soria");

		// LAMBDAS
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Cosumer Lambdas:");
		consumer2.accept("Nelson2");
		//Metodos referenciados
		IPersonaConsumer<String> consumer3=metodos::aceptar;
		LOG.info("Cosumer Metodos Referenciados:" );
		consumer3.accept("Nelson Soria 3");
		
		
		// 3. PREDICATE
		//LAMBDAS
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8)==0;	
		LOG.info("Predicate Lambda: "+ predicate1.evaluar(4));
		
		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if(valor.compareTo(100)>0 ) {
				return true;
			}else {
				return false;
			}
		};
		LOG.info("Predicate Lambda: "+ predicate2.evaluar(95));
		
		IPersonaPredicate<String> predicate3 = caracter ->  "Joel".contains(caracter);
		LOG.info("Predicate Lambda: "+ predicate3.evaluar("o"));
		
		IPersonaBiPredicate<String,String> predicate4 = (caracter, nombre) ->  nombre.contains(caracter);
		LOG.info("BiPredicate Lambda: "+ predicate4.evaluar("N","Nelson"));
		
		//Metodos referenciados
		IPersonaPredicate<Integer> predicate5 =metodos::evaluar;
		LOG.info("Predicate Metodos Referenciados: "+ predicate5.evaluar(500));
		
		//4. FUNCTION
		
		IPersonaFunction<String, Integer> function1 = numero->numero.toString();
		LOG.info("Funcion1 Lambda: "+ function1.aplicar(8));

		IPersonaFunction<String, Integer> function2 = numero->
		{
			String valorFinal= numero.toString().concat("Valor");
			return valorFinal;
		};
		LOG.info("Funcion2 Lambda: "+ function2.aplicar(10));
		//Metodos referenciados
		IPersonaFunction<Character,Integer> function3 = metodos::aplicarf;
		LOG.info("Function Metodos Referenciados:" );
		LOG.info(function3.aplicar(3).toString());
		
		
		// 5. unary operator
		IPersonaUnaryOperator<Integer> unary1 = numero -> numero+(numero*2);
		LOG.info("Unary Lambda: "+ unary1.aplicar(3));
		//Metodos referenciados
		IPersonaUnaryOperator<String> unary3 = metodos::aplicaru;
		LOG.info("Unary Metodos Referenciados:" );
		LOG.info(unary3.aplicar("agregado"));
		
		// 6. unary operator Funtion
		IPersonaUnaryOperatorFunction<Integer> unary2 =numero -> numero+(numero*2);
		LOG.info("UnaryOperatorFunction Lambda: "+ unary2.aplicar(3));
		
		
	}

}