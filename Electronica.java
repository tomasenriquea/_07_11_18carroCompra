package uF4.practicas._07_11_18carroCompra;

import java.time.LocalDate;

public class Electronica extends Producto implements Vendible{

	private int diasGarantia;
	
	//CONSTRUCTOR
	public Electronica(String nombreProducto, String codigoBarras, double precio, int diasGarantia) {
		super(nombreProducto, codigoBarras, precio);
		this.diasGarantia = diasGarantia;
		setPrecio(variacionPrecioProducto());
	}

	
	//GETTER Y SETTER
	public int getDiasGarantia() {
		return diasGarantia;
	}


	public void setDiasGarantia(int diasGarantia) {
		this.diasGarantia = diasGarantia;
	}


	//METODOS
	//Obteniene el precio del producto en base a la cantidad de dias de la garantia.
	@Override
	public double variacionPrecioProducto() {
		double precioSegunGarantia;
		precioSegunGarantia = getPrecio() + getPrecio() * (getDiasGarantia() / 365.0) * 0.1;
		return Math.round(precioSegunGarantia * 100d) / 100d;
	}
	
	
	@Override
	public String toString() {
		return "Nombre de producto: " + getNombreProducto() + 
			   "\nCodigo de Barras: " + getCodigoBarras() + 
			   "\nPrecio: " +  variacionPrecioProducto() + 
			   "\nDias de Garantia: " + getDiasGarantia();
	}


	@Override
	public void esVendible(LocalDate fechaCaducidad) {
		
		
	}
	
}
