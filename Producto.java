package uF4.practicas._07_11_18carroCompra;

public class Producto {
	
	private String codigoBarras;
	private double precio;
	private String nombreProducto;
	
	//CONSTRUCTOR
	public Producto (String nombreProducto, String codigoBarras, double precio) {
		this.codigoBarras = codigoBarras;
		this.precio = precio;
		this.nombreProducto = nombreProducto;
	}

	
	//GETTER Y SETTER
	public String getCodigoBarras() {
		return codigoBarras;
	}


	public double getPrecio() {
		return precio;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	
	//METODOS
	// obtendra el precio segun la condicion especifica que tengo el producto
	public double variacionPrecioProducto() {
		return 0.0;
	}


	@Override
	public String toString() {
		return "Nombre de producto: " + nombreProducto + 
			   "\nCodigo de Barras: " + codigoBarras + 
			   "\nPrecio: " + precio;
	}


	
	
	
	
	
	
	
	
	

}
