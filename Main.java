package uF4.practicas._07_11_18carroCompra;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

public class Main {

	/**Codigo para los productos:
	 * Alimentacion --> ALI
	 * Electronica  --> ELE
	 * Ropa			--> ROP
	 */
	
	public static void main(String[] args) {
		
	
		
		
		AplicacionCarroCompra tienda = new AplicacionCarroCompra();	
		tienda.menuPrincipal();  //llama al menu principal de la tienda
		
		
		
		
		
		
		
		
		
		
		/*
		LocalDate fechaActual = LocalDate.now();
		System.out.println("Fecha actual: " + fechaActual);
		LocalDate fechaCaducidad;
		String ddmmAA = "13/11/2018";
		fechaCaducidad = LocalDate.parse(ddmmAA, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
		long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaCaducidad);
		System.out.println("Fecha caducidad: " + fechaCaducidad);
		System.out.println(diasRestantes);
		*/
		
		
	}
}
