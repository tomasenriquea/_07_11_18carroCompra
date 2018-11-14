package uF4.practicas._07_11_18carroCompra;

import java.time.LocalDate;
import java.util.ArrayList;



public class CarroCompra{
	//private int cantidadMaxProductos;  // por sistema sera 100 por defecto
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	
	
	public CarroCompra(int cantidadMaxProductos) {
		// le da una cantidad al ArrayLis para que no consuma mas recurso
		this.listaProductos.ensureCapacity(cantidadMaxProductos);  
		// con esto se corta el exceso de memoria si no se usara un espacio libre en el array
		this.listaProductos.trimToSize();
		
	}


	//GETTER Y SETTER
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}


	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	//METODOS
	// agregara un producto sea cual sea a la lista del arrayList mientras este no este llena 
	public void agregarProducto(Producto producto) {
		listaProductos.add(producto);
	}
	
	//Agrega Ropa
	public void agregarProducto(String nombreProducto, String codigoBarras, double precio, String composicionTextil) {
		listaProductos.add(new Ropa(nombreProducto, codigoBarras, precio, composicionTextil));
	}
	
	//Agrega Alimentos
	public void agregarProducto(String nombreProducto, String codigoBarras, double precio, LocalDate fechaCaducidad) {
		listaProductos.add(new Alimentacion(nombreProducto, codigoBarras, precio, fechaCaducidad));
	}
	
	//Agrega Articulos de electronica
	public void agregarProducto(String nombreProducto, String codigoBarras, double precio, int diasGarantia) {
		listaProductos.add(new Electronica(nombreProducto, codigoBarras, precio, diasGarantia));
	}

	
	
	//Borra la lista del carrito
	public void BorrarCarro() {
		listaProductos.clear();
		System.out.println("Carrito Borrado");
	}
	
	//muestra el contenido total de la lista de productos
	public void mostrarProductos() {
		for (Producto producto : listaProductos) {
			System.out.println("");
			System.out.println(producto);
		}
	}
	
	// devolvera la cantidad de productos en el arrayList
	public int cantidadProductosCarro() {
		int cantidadProductos;
		return cantidadProductos = listaProductos.size();
	}
	
	//devolvera un objeto producto por producto segun el indice 
	public Producto getProducto(int indice) {
		//System.out.println(listaProductos.get(indice));
		Producto p = listaProductos.get(indice);
		return p;		
	}
	
	
	//Buscara un producto por medio de su codigo de barras
	public Producto buscarProducto(String codigoBarras) {
		Producto producto = null;
		if (listaProductos.contains(codigoBarras)) {
			int indice = listaProductos.lastIndexOf(codigoBarras);
			producto = listaProductos.get(indice);
		}
		return producto;
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

