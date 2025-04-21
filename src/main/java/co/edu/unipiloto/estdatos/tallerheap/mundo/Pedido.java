package co.edu.unipiloto.estdatos.tallerheap.mundo;

public class Pedido
{

	// ----------------------------------
	// Atributos
	// ----------------------------------

	/**
	 * Precio del pedido
	 */
	private double precio;
	
	/**
	 * Autor del pedido
	 */
	private String autorPedido;
	
	/**
	 * Cercania del pedido
	 */
	private int cercania;
	
	// ----------------------------------
	// Constructor
	// ----------------------------------
	
	/**
	 * Constructor del pedido
	 * TODO Defina el constructor de la clase
	 */
	public Pedido(String autorPedido, double precio, int cercania) {
		this.autorPedido = autorPedido;
		this.precio = precio;
		this.cercania = cercania;
	}
	
	// ----------------------------------
	// Métodos
	// ----------------------------------
	
	/**
	 * Getter del precio del pedido
	 */
	public double getPrecio()
	{
		return precio;
	}
	
	/**
	 * Getter del autor del pedido
	 */
	public String getAutorPedido()
	{
		return autorPedido;
	}
	
	/**
	 * Getter de la cercania del pedido
	 */
	public int getCercania() {
		return cercania;
	}
	
	// Hacer esto
	
	/**
	 * Representación textual del pedido
	 */
	@Override
	public String toString() {
		return "Pedido{" +
				"autor='" + autorPedido + '\'' +
				", precio=" + precio +
				", cercania=" + cercania +
				'}';
	}
}
