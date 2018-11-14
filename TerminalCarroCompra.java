package uF4.practicas._07_11_18carroCompra;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class TerminalCarroCompra {
	/**
	 * ESTO ES LA VISTA DESDE EL TERMINAL DE LA APLICACION DEL CARRO DE LA COMPRA.  */
	
	Scanner lector = new Scanner(System.in);
	

	/**Muestra el menú principal de la aplicación. 	 */
	public void mostrarMenuPrincipal() {
		System.out.println("\n\n");
		System.out.println("============================");
		System.out.println("=======MENU PRINCIPAL=======");
		System.out.println("============================");
		System.out.println("1. Introducir Producto.");
		System.out.println("2. Mostrar Carro");
		System.out.println("3. Generar Factura");
		System.out.println("4. Vaciar Carro");
		System.out.println("0. Salir");
		System.out.print("\nElija una opción: ");
	}
	
	
	/**Muestra el menú de productos 	 */
	public void mostrarMenuProductos() {
		System.out.println("\n\n");
		System.out.println("===============MENU PRODUCTOS===============");
		System.out.println("1. Añadir un alimento.");  
		System.out.println("2. Añadir un producto de vestir.");
		System.out.println("3. Añadir un producto de electronica.");
		System.out.println("0. Volver al menu principal.");
		System.out.print("\nElija una opción: ");
	}
	
	
	
	/**Lee un entero que representa una opcion del menu.
	 * @Return un entero, -1 si la entrada no se numerica 	 */
	public int elegirOpcion() {
		int opcion = 0;

		try {
			opcion = Integer.parseInt(lector.nextLine());
		} catch (NumberFormatException e) {
			opcion = -1;
		}

		return opcion;
	}
	
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------

	/**Pide un codigo de barras hasta que se entre un valor no vacio.
	 * @Return codigo de barras no vacio 	 */
	public String leerCodigoBarras() {
		String codigoBarras;
		do {
			System.out.print("Ingrese codigo de barras: ");
			codigoBarras = lector.nextLine();
		} while (codigoBarras.isEmpty());
		return codigoBarras;
	}
		
		
	/**Lee un nombre admiten cadena vacia.
	 * @return nombre del producto	 */
	public String leerNombreProducto() {
		System.out.print("Nombre de producto: ");
		return lector.nextLine();  // asi devolvera lo ingresado
	}

	
	/**Lee un precio. Insiste hasta que el precio es correcto. Admite separador de
	 * Decimal en coma o en punto
	 * @Return precio unitario producto 	 */
	public float leerPrecio() {
		float precio;
		String line;
		System.out.print("Precio: ");

		try {
			line = lector.nextLine();
			line = line.replaceFirst(",", ".");
			precio = Float.parseFloat(line);
		} catch (NumberFormatException e) {
			System.out.println("Entrada incorrecta!");
			precio = leerPrecio();
		}
		return precio;
	}	
		
	
	/**Lee fecha d / M / uuuu, incluyendo barras separadoras. Insiste la lee hasta
	 * Obtener fecha correcta: 01/01/2018, 12/10/2018, etc.
	 * @return una fecha	 */
	
	public LocalDate leerFechaCaducidad() {
		LocalDate fecha;
		String ddMmAaaa;

		System.out.print("Fecha de caducidad (DD/MM/AAAA): ");
		ddMmAaaa = lector.nextLine();
		try {
			fecha = LocalDate.parse(ddMmAaaa, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
		} catch (DateTimeParseException e) {
			System.out.println("Format de la data incorrecta");
			System.out.println("Entra DD/MM/AAAA, per exemple, 21/12/2007");
			fecha = leerFechaCaducidad();
		}
		return fecha;
	} 

	
	/**Muestra en formato linea los datos de un producto. Nombre, precio y fecha caducidad
	 * (Alimentacion), dias de garantia (Electronica) y composicion textil (Ropa).
	 * @param producto el producte 	 */
	public void mostrarProducteTrobatAlCarro(Producto producto) {
		System.out.println("Nom: " + producto.getNombreProducto());
		System.out.format("Preu: %.2f\n", producto.getPrecio()); // !Preu entrat
		if (producto instanceof Alimentacion) {
			System.out.format("Fecha de caducidad: %d/%d/%d\n", ((Alimentacion) producto).getFechaCaducidad().getDayOfMonth(),
															    ((Alimentacion) producto).getFechaCaducidad().getMonthValue(),
															    ((Alimentacion) producto).getFechaCaducidad().getYear());
		} else if (producto instanceof Electronica) {
			System.out.println("Dias de garantia: " + ((Electronica) producto).getDiasGarantia());
		} else if (producto instanceof Ropa) { // Roba
			System.out.println("Composicion textil: " + ((Ropa) producto).getComposicionTextil());
		} 
	}
	
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------	
		
		
	/**Genera un listado resumen con los productos del carro y los importes.
	 * @param carro 	 */
	public void mostraCarroResum(CarroCompra carro) {
		System.out.println("\nRESUMEM DE PRODUCTOS");
		System.out.println("       PRODUCTO UNIDADES PRECIO_UNITARIO       TOTAL");
		mostraCarro(carro);
	}
		
		
	/**Muestra el nombre, las unidades, el precio y el preuTotal para todo producto al
	 * Carro, y el importe total. 	 */
	
	private void mostraCarro(CarroCompra carro) {
		int cantidadProductos;
		Producto p;
		int unitats;
		double preuUnitari;
		double preuTotalProducte;
		double importTotal = 0;

		cantidadProductos = carro.cantidadProductosCarro();  
		for (int i = 0; i < cantidadProductos; i++) {
			p = carro.getProducto(i);  // devuelve un objeto conteniendo un producto segun el indice.
			unitats = p.cantidadUnidades(); // esto va en la clase producto
			preuUnitari = p.calcularPrecio(); // esto va en la clase producto
			preuTotalProducte = preuUnitari * unitats;
			System.out.format("%15s %4d     %10.2f  %15.2f%n", p.getNombreProducto(), unitats, preuUnitari, preuTotalProducte);
			importTotal = importTotal + preuTotalProducte;
		} 
		System.out.format("%nTOTAL A PAGAR: %.2f   \n\n", importTotal);
	}	
	
	
	/**Mensaje de que no se ha podido anyadir el producto nombre. 
	 * @param nom 	 */
	public void missatgeCarroPle(String nom) {
		System.out.format("\nCARRO PLE\nProducte %s no afegit\n\n", nom);
	}
	
	
	/**Lee un numero entero. Insiste hasta que se entra un numero
	 * correcto. @Return dIas de garantIa 	 */
	public int llegirDiesGarantia() {
		int nDies;

		System.out.print("Dias de garantia: ");
		try {
			nDies = Integer.parseInt(lector.nextLine());
		} catch (NumberFormatException e) {
			nDies = llegirDiesGarantia();
		}
		return nDies;
	}
	
	
	/**Lee la composicion textil. Admite la cadena vacia o cualquier valor.
	 * @return composicion textil 	 */
	public String llegirComposicioTextil() {
		System.out.print("Composició tèxtil: ");
		return lector.nextLine();
	}
	
	
	
	
	/**Genera una factura con la fecha, los productos del carro y los importes.
	 * @param carro 	 */
	public void mostraCarroFacturacio(CarroCompra carro) {
		System.out.println("\n=========================================================");
		System.out.println("=========================FACTURA=========================");
		System.out.println("=========================================================");
		System.out.println("");
		LocalDate localDate = LocalDate.now();// For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = localDate.format(formatter);
		System.out.format("FECHA: %s%n%n", formattedString);

		System.out.println("       PRODUCTO UNIDADES PRECIO_UNITARIO         TOTAL");
		mostraCarro(carro);
		System.out.println("=========================================================");
		System.out.println("=========================================================");
	}
	
	
		

}
