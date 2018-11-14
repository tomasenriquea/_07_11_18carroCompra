package uF4.practicas._07_11_18carroCompra;

import java.time.LocalDate;

public class AplicacionCarroCompra {
	/**
	 * ESTO SERA LA PARTE DEL CONTROLADOR
	 */
	
	final static int MAX_PRODUCTOS_DEFECTO = 100;

	// tipos de productes
	final static int ALIMENTACION = 1;
	final static int TEXTIL = 2;
	final static int ELECTRONICA = 3;

	// opciones menu principal
	final static int ENTRAR_PRODUCTOS = 1;
	final static int MOSTRAR_CARRO = 2;
	final static int FACTURAR = 3;
	final static int VACIAR_CARRO = 4;
	final static int SALIR = 0;

	
	private CarroCompra carro; // Carro de compra donde ponemos los productos
	private TerminalCarroCompra vista; // Entradas y salidas desde terminal

	
	//CONSTRUCTORES
	public AplicacionCarroCompra() {
		this(MAX_PRODUCTOS_DEFECTO);
	}

	
	public AplicacionCarroCompra(int maxProductes) {
		if (maxProductes <= 0) {
			maxProductes = MAX_PRODUCTOS_DEFECTO;
		}
		carro = new CarroCompra(maxProductes);
		vista = new TerminalCarroCompra();
	}
	
	
	//GETTER Y SETTER
	public CarroCompra getCarro() {
		return carro;
	}


	public TerminalCarroCompra getVista() {
		return vista;
	}


	public void setCarro(CarroCompra carro) {
		this.carro = carro;
	}


	public void setVista(TerminalCarroCompra vista) {
		this.vista = vista;
	}
	
	
	//-----------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------

	/**Controla las opciones del menu principal:
	 * 1-Entrar productos
	 * 2-Mostrar Carro Compras
	 * 3-Facturar (Vaciar el Carro)
	 * 4-Vaciar Carro Compras
	 * 0-Salir  */
	public void menuPrincipal() {
		int opcion;

		do {
			vista.mostrarMenuPrincipal();
			opcion = vista.elegirOpcion();
			switch (opcion) {
			case ENTRAR_PRODUCTOS:
				menuEntrarProducto();
				break;
			case MOSTRAR_CARRO:
				vista.mostraCarroResum(carro);
				break;
			case FACTURAR: // vacia el carro
				vista.mostraCarroFacturacio(carro);
				buidaCarro();
				break;
			case VACIAR_CARRO:
				buidaCarro();
				break;
			case SALIR:
				break;
			default:
				//vista.missatgeOpcioIncorrecta();
				break;
			}
		} while (opcion != SALIR);
	}
	
	
	//Borrara la lista del carro de compras que esta almacenara en un arrayList
	public void buidaCarro() {
		carro.BorrarCarro();
	}
	
	
	
	/**Controla las opciones para introducir un producto al carro:
	 * 1-ALIMENTACION
	 * 2-Electronica
	 * 3-Textil
	 * 0-Salir	 */
	public void menuEntrarProducto() {
		int opcion;

		do {
			vista.mostrarMenuProductos();
			opcion = vista.elegirOpcion();
			switch (opcion) {
			case ALIMENTACION:
				introduirProducte(ALIMENTACION);
				break;
			case ELECTRONICA:
				introduirProducte(ELECTRONICA);
				break;
			case TEXTIL:
				introduirProducte(TEXTIL);
				break;
			case SALIR:
				break;
			default:
				//vista.missatgeOpcioIncorrecta();
				break;
			}
		} while (opcion != SALIR);
	}
	
	
	
	/**Pide los datos de un producto y lo introduce en el carro.
	 * Si despues de entrar el codigo de barras encuentra un producto igual al carro
	 * (Mismo codigo de barras) muestra el resto de datos de forma automatica.
	 * Si el carro esto lleno captura la excepcion CarroPleException y muestra un
	 * Mensaje Carro Pleno.
	 * @Param tipusProducte 1-ALIMENTACION 2-Electronica 3-Ropa 	
	 * Solo introduce los datos por consola */
	public void introduirProducte(int tipusProducte) {
		String codigoBarras, nombre;
		double precio;
		Producto producto;

		codigoBarras = vista.leerCodigoBarras();
		//Buscara un producto por medio de su codigo de barras
		producto = carro.buscarProducto(codigoBarras);  
		if (producto == null) { // entrar datos del producto nuevo
			nombre = vista.leerNombreProducto();
			precio = vista.leerPrecio();
			switch (tipusProducte) {
			case ALIMENTACION:
				LocalDate fechaCaducidad = vista.leerFechaCaducidad();
				//producto = new Alimentacion(nombre, codigoBarras, precio, fechaCaducidad);
				carro.agregarProducto(nombre, codigoBarras, precio, fechaCaducidad);
				break;
				
			case ELECTRONICA:
				int dies = vista.llegirDiesGarantia();
				//producto = new Electronica(nombre, codigoBarras, precio, dies);
				// esto de abajo agrega el producto a las lista
				carro.agregarProducto(nombre, codigoBarras, precio, dies);
				break;
				
			case TEXTIL:
				String textil = vista.llegirComposicioTextil();
				//producto = new Ropa(nombre, codigoBarras, precio, textil);
				carro.agregarProducto(nombre, codigoBarras, precio, textil);
				break;
			default:
				break; 
			} 
			
		} else { //mostrar datos del producto ya existente
			vista.mostrarProducteTrobatAlCarro(producto);
		}

	
			
			
			
			
			
	
	} 
	
	
	
}
