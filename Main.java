package uF4.practicas._07_11_18carroCompra;


import java.beans.FeatureDescriptor;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



public class Main {

	/**Codigo para los productos:
	 * Alimentacion --> ALI001
	 * Electronica  --> ELEC001
	 * Ropa			--> RO001
	 */
	
	
	
	public static void main(String[] args) {
		
		
		Alimentacion alimentacion = new Alimentacion("arroz", "12345", 23.4, 12, 12, 2018);
		System.out.println(alimentacion.toString());
		
		
		System.out.println("");
		System.out.println("-----------------------------------------");
		
		
		Ropa ropa = new Ropa("camisa", "9876", 12.34, "licra");
		System.out.println(ropa.toString());
		
		System.out.println("");
		System.out.println("-----------------------------------------");

		
		Electronica electronica = new Electronica("TV", "9134", 120.34, 30);
		System.out.println(electronica.toString());
		
		
		
	
		
		/*
		LocalDate date = LocalDate.of(1999, Month.AUGUST, 23);           
	    DayOfWeek dia=date.getDayOfWeek(); 
	    System.out.printf("El día que conocí a quien es mi esposa fue el %s y fue un %s%n",date,dia); 
		*/
		
		
		/*
		System.out.println("--------------------");
		System.out.println("Fecha final: " + alimentacion.getFechaCaducidad());
		System.out.println();
		
		System.out.println("--------------------");
		// obtiene la fecha actual del sistema
		LocalDate date = LocalDate.now();
		System.out.println("Fecha actual: " + date);
		*/
	
	
		
		
		
		
	
		/*
		//Esto es para restar los das del año
		String startDate = "2018 11 10";  //
		String passedDate = "2020 12 31";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		LocalDate date1 = LocalDate.parse(startDate, formatter);
		LocalDate date2 = LocalDate.parse(passedDate, formatter);

		long elapsedDays = ChronoUnit.DAYS.between(date1, date2);
		System.out.println(elapsedDays); // 58 (correct)
		*/
		
		 
		

		
		
		
		
	}
	
	
		//ESto es para la fecha 
	   public static LocalDate llegirData() {
	        LocalDate d;
	        String ddMmAaaa;
	        
	        Scanner lector = new Scanner(System.in);

	        System.out.print("Fecha de caducidad (DD/MM/AAAA): ");
	        ddMmAaaa = lector.nextLine();
	        try {
	            d = LocalDate.parse(ddMmAaaa, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
	        } catch (DateTimeParseException e) {
	            System.out.println("Formato de fecha incorrecta");
	            System.out.println("Entra DD/MM/AAAA, per exemple, 21/12/2007");
	            d = llegirData();
	        }
	        return d;
	    }

}
