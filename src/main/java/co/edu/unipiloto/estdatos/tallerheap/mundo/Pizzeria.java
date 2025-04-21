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
	// Usamos un max-heap para los pedidos recibidos (por precio)
	private Heap<Pedido> pedidosRecibidos;

	/**
	 * Getter de pedidos recibidos
	 */
	public Heap<Pedido> getPedidosRecibidos() {
		return pedidosRecibidos;
	}

 	/** 
	 * Cola de elementos por despachar (por cercanía)
	 */
	private Heap<Pedido> colaDespachos;

	/**
	 * Getter de elementos por despachar
	 */
	public ArrayList<Pedido> getColaDespachos() {
		return colaDespachos.aLista();
	}
	
	// ----------------------------------
    // Constructor
    // ----------------------------------

	/**
	 * Constructor de la clase Pizzeria
	 */
	public Pizzeria()
	{
		// Max-heap para los pedidos recibidos (ordenados por precio)
        pedidosRecibidos = new Heap<>(new Comparator<Pedido>() {
            public int compare(Pedido p1, Pedido p2) {
                // Comparación por precio (de mayor a menor)
                return Double.compare(p2.getPrecio(), p1.getPrecio()); // Mayor precio primero
            }
        });

		// Min-heap para los pedidos por despachar (ordenados por cercanía)
        colaDespachos = new Heap<>(new Comparator<Pedido>() {
            public int compare(Pedido p1, Pedido p2) {
                // Comparación por cercanía (de menor a mayor)
                return Integer.compare(p1.getCercania(), p2.getCercania()); // Menor cercanía primero
            }
        });
	}
	
	// ----------------------------------
    // Métodos
    // ----------------------------------
	
	/**
	 * Agrega un pedido a la cola de prioridad de pedidos recibidos
	 * @param nombreAutor nombre del autor del pedido
	 * @param precio precio del pedido 
	 * @param cercania cercanía del autor del pedido 
	 */
	public void agregarPedido(String nombreAutor, double precio, int cercania)
	{
		Pedido nuevo = new Pedido(nombreAutor, precio, cercania);
		pedidosRecibidos.agregar(nuevo);
	}
	
	/**
	 * Atender al pedido más importante de la cola
	 * Retorna el siguiente pedido en la cola de prioridad, o null si no existe.
	 * @return El pedido próximo en la cola de prioridad
	 */
	public Pedido atenderPedido()
	{
		Pedido p = pedidosRecibidos.retirar();
		if (p != null) {
			// Mover el pedido a la cola de despachos
			colaDespachos.agregar(p);
		}
		return p;
	}

	/**
	 * Despacha al próximo pedido en la cola de despachos.
	 * @return El próximo pedido a despachar
	 */
	public Pedido despacharPedido()
	{
		return colaDespachos.retirar();
	}
	
	/**
	 * Retorna la cola de prioridad de pedidos recibidos como una lista.
	 * @return lista de pedidos recibidos
	 */
	 public ArrayList<Pedido> pedidosRecibidosList()
	 {
		 return pedidosRecibidos.aLista();
	 }
	 
	 /**
	  * Retorna la cola de prioridad de despachos como una lista.
	  * @return lista de despachos
	  */
	 public ArrayList<Pedido> colaDespachosList()
	 {
		 return colaDespachos.aLista();
	 }
}
