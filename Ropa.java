package uF4.practicas._07_11_18carroCompra;

public class Ropa extends Producto{

	private String composicionTextil;
	
	//CONSTRUCTOR
	public Ropa(String nombreProducto, String codigoBarras, double precio, String composicionTextil) {
		super(nombreProducto, codigoBarras, precio);
		this.composicionTextil = composicionTextil;
	}


	//GETTER Y SETTER
	public String getComposicionTextil() {
		return composicionTextil;
	}



	public void setComposicionTextil(String composicionTextil) {
		this.composicionTextil = composicionTextil;
	}


	//METODOS
	@Override
	public String toString() {
		//Al poner asi, se esta llamando al metodo de la clase padre y lo concatenamos con el ultimo dato.
		return super.toString() + "\nComposicion: " +  composicionTextil;
	}
	
}
