package co.edu.unipiloto.estdatos.tallerheap.mundo;
import java.util.ArrayList;


public class Pizzeria 
{	
	// ----------------------------------
    // Constantes
    // ----------------------------------
                                	/**
	 * Constante que define la accion de recibir un pedido
	 */
	public final static String RECIBIR_PEDIDO = "RECIBIR";
	/**
	 * Constante que define la accion de atender un pedido
	 */
	public final static String ATENDER_PEDIDO = "ATENDER";
	/**
	 * Constante que define la accion de despachar un pedido
	 */
	public final static String DESPACHAR_PEDIDO = "DESPACHAR";
	/**
	 * Constante que define la accion de finalizar la secuencia de acciones
	 */
	public final static String FIN = "FIN";
	
	// ----------------------------------
    // Atributos
    // ----------------------------------
	
	/**
	 * Heap que almacena los pedidos recibidos
	 */
	// Hacer esto
	/**
	 * Getter de pedidos recibidos
	 */
	// Hacer esto
 	/** 
	 * Cola de elementos por despachar
	 */
	// Hacer esto
	/**
	 * Getter de elementos por despachar
	 */
	// Hacer esto
	
	// ----------------------------------
    // Constructor
    // ----------------------------------

	/**
	 * Constructor de la case Pizzeria
	 */
	public Pizzeria()
	{
	// Hacer esto
	}
	
	// ----------------------------------
    // Métodos
    // ----------------------------------
	
	/**
	 * Agrega un pedido a la cola de prioridad de pedidos recibidos
	 * @param nombreAutor nombre del autor del pedido
	 * @param precio precio del pedido 
	 * @param cercania cercania del autor del pedido 
	 */
	public void agregarPedido(String nombreAutor, double precio, int cercania)
	{
	// Hacer esto
	}
	
	// Atender al pedido más importante de la cola
	
	/**
	 * Retorna el proximo pedido en la cola de prioridad o null si no existe.
	 * @return p El pedido proximo en la cola de prioridad
	 */
	public Pedido atenderPedido()
	{
	// Hacer esto
		return  null;
	}

	/**
	 * Despacha al pedido proximo a ser despachado. 
	 * @return Pedido proximo pedido a despachar
	 */
	public Pedido despacharPedido()
	{
	// Hacer esto
	    return  null;
	}
	
	/**
	 * Retorna la cola de prioridad de pedidos recibidos como una lista. 
	 * @return list lista de pedidos recibidos.
	 */
	 public ArrayList<Pedido> pedidosRecibidosList()
	 {
	// Hacer esto
		 return  null;
	 }
	 
	 /**
	  * Retorna la cola de prioridad de despachos como una lista. 
	  * @return list cola de prioridad de despachos.
	  */
	 public ArrayList<Pedido> colaDespachosList()
	 {
	// Hacer esto
		 return  null;
	 }
}
