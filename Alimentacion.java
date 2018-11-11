package uF4.practicas._07_11_18carroCompra;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alimentacion extends Producto {

	// con esto se puede trabajar exactamente solo con la fecha
	private LocalDate fechaCaducidad; // Esto sera la fecha final de producto
	private LocalDate fechaActual;  // esto sera la fecha actual del sistema

	// CONSTRUCTOR
	public Alimentacion(String nombreProducto, String codigoBarras, double precio, int dia, int mes, int agno) {
		super(nombreProducto, codigoBarras, precio);
		this.fechaCaducidad = LocalDate.of(agno, mes, dia);
	}

	// GETTER Y SETTER
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}

	
	// METODOS
	
	//devuelve la fecha actual en el sistema
	private LocalDate fechaActual() {
		return fechaActual = LocalDate.now();
	}
	
	//Obtiene el precio del producto basado en la fecha de caducidad y la fecha actual
	@Override
	public double variacionPrecioProducto() {
		double precioSegunFecha;
		//Obtiene la cantidad de dias que quedan entre la fecha actual y la fecha de caducidad.
		long diasRestantes = ChronoUnit.DAYS.between(fechaActual(), getFechaCaducidad());
		//Formula para obtener el precio del producto
		precioSegunFecha = getPrecio() - getPrecio() *(1.0 / (diasRestantes + 1)) + (getPrecio() * 0.1);
		// la letra 'd' significa double
		return Math.round(precioSegunFecha * 100d) / 100d;  // se devuelve el precio solo con 2 decimales
	}
	
	
	@Override
	public String toString() {
		// Poniendo esto se hereda el 'toString' de producto y solo se le agrega la caracteristica especifica del producto alimentacion.
		//return super.toString() + "\nFecha caducidad: " + fechaCaducidad;
		return "Nombre de producto: " + getNombreProducto() + 
			   "\nCodigo de Barras: " + getCodigoBarras() + 
			   "\nPrecio: " +  variacionPrecioProducto() + 
			   "\nFecha de Caducidad: " + getFechaCaducidad();
	}
	
}


