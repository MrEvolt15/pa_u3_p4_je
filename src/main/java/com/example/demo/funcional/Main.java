package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		/*
		 * IPersona per = new PersonaImpl(); per.caminar(); // 1. Supplier
		 * 
		 * // Clases:
		 * 
		 * IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		 * LOG.info("Supplier clase:" + supplier1.getId());
		 * 
		 * // Lambdas IPersonaSupplier<String> supplier2 = () -> "17522859486";
		 * LOG.info("Supplier1 lambda:" + supplier2.getId());
		 * 
		 * IPersonaSupplier<String> supplier3 = () -> { String cedula = "1564156";
		 * cedula = cedula + "zzzzzzzzzz"; return cedula; };
		 * LOG.info("Supplier2 lambda:" + supplier3.getId());
		 * 
		 * // Metodos referenciados
		 * 
		 * IPersonaSupplier<Integer> supplier4 = MetodosReferenciados::getId;
		 * LOG.info("Supplier metodo referenciado:" + supplier4.getId());
		 * 
		 * // 2. CONSUMER
		 * 
		 * // Clases IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		 * LOG.info("Cosumer clase:"); consumer1.accept("Nelson Soria");
		 * 
		 * // LAMBDAS IPersonaConsumer<String> consumer2 = cadena -> { LOG.info("1");
		 * LOG.info("2"); LOG.info(cadena); }; LOG.info("Cosumer Lambdas:");
		 * consumer2.accept("Nelson2"); // Metodos referenciados
		 * IPersonaConsumer<String> consumer3 = MetodosReferenciados::aceptar;
		 * LOG.info("Cosumer Metodos Referenciados:");
		 * consumer3.accept("Nelson Soria 3");
		 * 
		 * // 3. PREDICATE // LAMBDAS IPersonaPredicate<Integer> predicate1 = valor ->
		 * valor.compareTo(8) == 0; LOG.info("Predicate Lambda: " +
		 * predicate1.evaluar(4));
		 * 
		 * IPersonaPredicate<Integer> predicate2 = valor -> { Integer valor2 = 10; valor
		 * = valor + valor2; if (valor.compareTo(100) > 0) { return true; } else {
		 * return false; } }; LOG.info("Predicate Lambda: " + predicate2.evaluar(95));
		 * 
		 * IPersonaPredicate<String> predicate3 = caracter -> "Joel".contains(caracter);
		 * LOG.info("Predicate Lambda: " + predicate3.evaluar("o"));
		 * 
		 * IPersonaBiPredicate<String, String> predicate4 = (caracter, nombre) ->
		 * nombre.contains(caracter); LOG.info("BiPredicate Lambda: " +
		 * predicate4.evaluar("N", "Nelson"));
		 * 
		 * // Metodos referenciados IPersonaPredicate<Integer> predicate5 =
		 * MetodosReferenciados::evaluar; LOG.info("Predicate Metodos Referenciados: " +
		 * predicate5.evaluar(500));
		 * 
		 * // 4. FUNCTION
		 * 
		 * IPersonaFunction<String, Integer> function1 = numero -> numero.toString();
		 * LOG.info("Funcion1 Lambda: " + function1.aplicar(8));
		 * 
		 * IPersonaFunction<String, Integer> function2 = numero -> { String valorFinal =
		 * numero.toString().concat("Valor"); return valorFinal; };
		 * LOG.info("Funcion2 Lambda: " + function2.aplicar(10)); // Metodos
		 * referenciados IPersonaFunction<Character, Integer> function3 =
		 * MetodosReferenciados::aplicarf; LOG.info("Function Metodos Referenciados:");
		 * LOG.info(function3.aplicar(3).toString());
		 * 
		 * // 5. unary operator IPersonaUnaryOperator<Integer> unary1 = numero -> numero
		 * + (numero * 2); LOG.info("Unary Lambda: " + unary1.aplicar(3)); // Metodos
		 * referenciados IPersonaUnaryOperator<String> unary3 =
		 * MetodosReferenciados::aplicaru; LOG.info("Unary Metodos Referenciados:");
		 * LOG.info(unary3.aplicar("agregado"));
		 * 
		 * // 6. unary operator Funtion IPersonaUnaryOperatorFunction<Integer> unary2 =
		 * numero -> numero + (numero * 2); LOG.info("UnaryOperatorFunction Lambda: " +
		 * unary2.aplicar(3));
		 */
		////////////////// Metodos High Order**************

		// SUPPLIER
/*
		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		MetodosHighOrder.metodo(supplierHO);

		// 2. Lambdas
		MetodosHighOrder.metodo(() -> "17654561HO");

		// 3. Metodos referenciados
		MetodosHighOrder.metodo(MetodosReferenciados::getIdHO);

		// CONSUMER

		// 1. Clase

		MetodosHighOrder.metodoConsumer(new PersonaConsumerImpl(), "Nelson");
		// 2. Lambdas

		MetodosHighOrder.metodoConsumer(cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		}, "Lambdas Consumer");

		// 3. Metodos referenciados
		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar, "MetodosReferenciados Consumer");

		// Function

		// 1. Clase

		MetodosHighOrder.metodoFunction(new PersonaFunctionImpl(), 2);
		// 2. Lambdas

		MetodosHighOrder.metodoFunction(numero -> {
			Character valorFinal = numero.toString().charAt(1);
			LOG.info(valorFinal.toString());
			return valorFinal;
		}, 32);

		// 3. Metodos referenciados
		MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicarf, 3);

		// Predicate

		// 1. Clase

		MetodosHighOrder.metodoPredicate(new PersonaPredicateImp(), 100);
		// 2. Lambdas

		MetodosHighOrder.metodoPredicate(valor -> {
			Boolean valorCompara = valor.compareTo(100) < 0;
			LOG.info(valorCompara.toString());
			return valorCompara;
		}, 200);

		// 3. Metodos referenciados
		MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluar, 40);

		// Unary Operator

		// 1. Clase

		MetodosHighOrder.metodoUnaryOperator(new PersonaUnaryOperatorImpl(), "alga");
		// 2. Lambdas

		MetodosHighOrder.metodoUnaryOperator(letras -> {
			String resultado = "val: ";
			return resultado.concat(letras);
		}, "abdcse");

		// 3. Metodos referenciados
		MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::aplicaru, "aumento");

		// ******************* Interfaces Funcionales Java ******
		// 1. Supplier

		Stream<String> lista = Stream.generate(() -> "17654561HO").limit(10);
		lista.forEach(cadena -> LOG.info(cadena));
		

		// 2. Consumer
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		listaNumeros.forEach(cadena -> {
			LOG.info(" " + cadena);

		});

		// 3. Predicate

		Stream<Integer> listaFinal = listaNumeros.stream().filter(numero -> numero >= 5);
		listaFinal.forEach(numero -> LOG.info("Valor:" + numero));

		// 4. Function
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return "N:" + num;
		});
		listaCambiada.forEach(cadena -> LOG.info(cadena));

		// 5. UnaryOperator

		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return num;
		});
		listaCambiada2.forEach(cadena -> LOG.info(" " + cadena));
*/		
		
		// 1. Supplier

		Stream<String> lista2 = Stream.generate(MetodosReferenciados::getIdHO).limit(10);
		lista2.forEach(cadena -> LOG.info(cadena));
		LOG.info("Prueba: " + lista2);

		// 2. Consumer
		List<Integer> listaNumeros2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		listaNumeros2.forEach(MetodosReferenciados::aceptar);

		// 3. Predicate

		Stream<Integer> listaFinal2 = listaNumeros2.stream().filter(MetodosReferenciados::evaluar);
		listaFinal2.forEach(numero -> LOG.info("Valor:" + numero));

		// 4. Function
		Stream<String> listaCambiada3 = listaNumeros2.stream().map(MetodosReferenciados::aplicarf);
		listaCambiada3.forEach(cadena -> LOG.info(cadena));

		// 5. UnaryOperator

		Stream<Integer> listaCambiada4 = listaNumeros2.stream().map(MetodosReferenciados::aplicarUInteger);
		listaCambiada4.forEach(cadena -> LOG.info(" " + cadena));

	}

}
