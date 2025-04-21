package co.edu.unipiloto.estdatos.tallerheap.mundo;

import java.util.ArrayList;
import java.util.Comparator;

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
	private Heap<Pedido> pedidosRecibidos;
	
	/**
	 * Getter de pedidos recibidos
	 */
	public Heap<Pedido> getPedidosRecibidos() {
		return pedidosRecibidos;
	}

	/** 
	 * Cola de elementos por despachar
	 */
	private ArrayList<Pedido> colaDespachos;
	
	/**
	 * Getter de elementos por despachar
	 */
	public ArrayList<Pedido> getColaDespachos() {
		return colaDespachos;
	}
	
	// ----------------------------------
    // Constructor
    // ----------------------------------

	/**
	 * Constructor de la clase Pizzeria
	 */
	public Pizzeria()
	{
		// Comparador por cercanía primero, luego precio
		pedidosRecibidos = new Heap<>(new Comparator<Pedido>() {
			public int compare(Pedido p1, Pedido p2) {
				if (p1.getCercania() == p2.getCercania()) {
					return Double.compare(p2.getPrecio(), p1.getPrecio());
				} else {
					return Integer.compare(p2.getCercania(), p1.getCercania());
				}
			}
		});
		colaDespachos = new ArrayList<>();
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
		Pedido nuevo = new Pedido(nombreAutor, precio, cercania);
		pedidosRecibidos.agregar(nuevo);
	}
	
	// Atender al pedido más importante de la cola
	
	/**
	 * Retorna el proximo pedido en la cola de prioridad o null si no existe.
	 * @return p El pedido proximo en la cola de prioridad
	 */
	public Pedido atenderPedido()
	{
		Pedido p = pedidosRecibidos.retirar();
		if (p != null) {
			colaDespachos.add(p);
		}
		return p;
	}

	/**
	 * Despacha al pedido proximo a ser despachado. 
	 * @return Pedido proximo pedido a despachar
	 */
	public Pedido despacharPedido()
	{
		if (!colaDespachos.isEmpty()) {
			return colaDespachos.remove(0);
		}
		return null;
	}
	
	/**
	 * Retorna la cola de prioridad de pedidos recibidos como una lista. 
	 * @return list lista de pedidos recibidos.
	 */
	 public ArrayList<Pedido> pedidosRecibidosList()
	 {
		 return pedidosRecibidos.aLista();
	 }
	 
	 /**
	  * Retorna la cola de prioridad de despachos como una lista. 
	  * @return list cola de prioridad de despachos.
	  */
	 public ArrayList<Pedido> colaDespachosList()
	 {
		 return new ArrayList<>(colaDespachos);
	 }
}