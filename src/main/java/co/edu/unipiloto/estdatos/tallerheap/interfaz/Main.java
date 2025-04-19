package co.edu.unipiloto.estdatos.tallerheap.interfaz;

import co.edu.unipiloto.estdatos.tallerheap.mundo.Pedido;
import co.edu.unipiloto.estdatos.tallerheap.mundo.Pizzeria;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
// Prueba repo
public class Main
{
	/**
	 * BufferedReader para leer el input
	 */
	static BufferedReader br;
	/**
	 * Linea de texto que se lee
	 */
	static String ln;
	/**
	 * Mundo
	 */
	static Pizzeria pizzeria;
	
	/**
	 * Constante para ingreso a modo de interfaz de usuario
	 */
	static final int INTERFAZ_USUARIO = 1;
	/**
	 * Constante para ingreso a modo manual
	 */
	static final int INGRESO_MANUAL = 2;
	/**
	 * Constante para ingreso a modo de archivo de pruebas
	 */
	static final int ARCHIVO_DE_PRUEBAS = 3;
	/**
	 * Constante para salir del programa
	 */
	static final int SALIR = 4;
	
	private static final String ARCHIVO_PRUEBAS = "./data/tests.txt";
	
	
	
	
	/**
	 * Metodo principal del programa.
	 * @param args Argumentos que el programa recibe cuando se ejecuta.
	 * @throws Exception Si no se recibe el input esperado.
	 */
	public static void main(String[] args) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		boolean end = false;
		
		while(!end)
		{
			imprimirArchivo("./data/header.txt");
			Integer option = Integer.parseInt(br.readLine());
			if(option == INTERFAZ_USUARIO)
			{
				interfazUsuario();
			}
			else if(option == INGRESO_MANUAL)
			{
				imprimirArchivo("./data/ingresoManual.txt");
				ingresoManual();
			}
			else if(option == ARCHIVO_DE_PRUEBAS)
			{
				ingresoArchivoPruebas();
			}
			else if(option == SALIR)
			{
				System.out.println("SALIENDO");
				end = true;
			}
		}
	}
	
	/**
	 * Metodo que ejecuta la interfaz del usuario
	 * @throws Exception Si no se puede leer una linea del input
	 */
	static void interfazUsuario() throws Exception
	{
		pizzeria = new Pizzeria();
		boolean end = false;
		while(!end)
		{
			imprimirArchivo("./data/interfazUsuario.txt");
			System.out.println("Seleccione una opcion:");
			int option = Integer.parseInt(br.readLine());
			if(option == 1)
			{
				System.out.println("Escriba el primer nombre del autor del pedido:");
				String nombre = br.readLine();
				System.out.println("Escriba el precio del pedido:");
				double precio = Double.parseDouble(br.readLine()); 
				System.out.println("Escriba la cercania del pedido (1-5):");
				int cercania = Integer.parseInt(br.readLine());
				pizzeria.agregarPedido(nombre, precio, cercania);
				System.out.println("Pedido agregado.");
			}
			else if(option == 2)
			{
				Pedido p = pizzeria.atenderPedido();
				if(p == null) System.out.println("Cola vacia");
				else System.out.println("Pedido atendido: "+ p.getAutorPedido() + " - " + p.getPrecio() + " - " + p.getCercania());
			}
			else if(option == 3)
			{
				Pedido p = pizzeria.despacharPedido();
				if(p == null) System.out.println("Cola vacia");
				else System.out.println("Pedido despachado: "+ p.getAutorPedido() + " - " + p.getPrecio() + " - " + p.getCercania());
			}
			else if(option == 4)
			{
				imprimirColas(pizzeria);
			}
			else if(option == 5)
			{
				end = true;
			}
		}
	}
	
	/**
	 * Metodo que ejecuta el modo de ingreso de comandos.
	 * @throws Exception Si no se puede leer una linea del input.
	 */
	static void ingresoComandos(BufferedReader br) throws Exception
	{
		pizzeria = new Pizzeria();
		
		while( (ln = br.readLine()) != null && !ln.equalsIgnoreCase("SALIR"))
		{
			String comando = ln.split(" ")[0];
			if(comando.equalsIgnoreCase(Pizzeria.RECIBIR_PEDIDO))
			{
				String nombre = ln.split(" ")[1];
				Double precio = Double.parseDouble(ln.split(" ")[2]);
				Integer cercania = Integer.parseInt(ln.split(" ")[3]);
				pizzeria.agregarPedido(nombre, precio, cercania);
			}
			else if(comando.equalsIgnoreCase(Pizzeria.ATENDER_PEDIDO))
			{
				pizzeria.atenderPedido();
			}
			else if(comando.equalsIgnoreCase(Pizzeria.DESPACHAR_PEDIDO))
			{
				pizzeria.despacharPedido();
			}
			imprimirColas(pizzeria);
		}
	}
	
	/**
	 * Metodo que ejecuta el modo de ingreso de comandos.
	 * @throws Exception Si no se puede leer una linea del input.
	 */
	static void ingresoManual() throws Exception
	{
		ingresoComandos(br);
	}
	
	/**
	 * Metodo que ejecuta el modo de ingreso de archivo de pruebas.
	 * @throws Exception Si no se puede leer una linea del input.
	 */
	static void ingresoArchivoPruebas() throws Exception
	{
		try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PRUEBAS))) {
			ingresoComandos(br);
		}
	}
	
	/**
	 * Imprime las colas de la pizzeria que entra por parametro. 
	 * @param pizzeria Pizzeria de la cual se imprimiran las colas.
	 */
	static void imprimirColas(Pizzeria pizzeria)
	{
		imprimirColaPedidosRecibidos(pizzeria);
		imprimirColaDespachos(pizzeria);
		System.out.println();System.out.println();
	}
	
	/**
	 * Imprime la cola de pedidos recibidos de la pizzeria que recibe como argumento
	 * @param pizzeria Pizzeria de la cual se imprimira la cola.
	 */
	private static void imprimirColaPedidosRecibidos(Pizzeria pizzeria)
	{
		System.out.println("    PEDIDOS RECIBIDOS    ");
		int index = 1;
		
		try {
			for(Pedido p : pizzeria.pedidosRecibidosList())
			{
				System.out.printf("%d. %s ($%.2f)%n", index++, p.getAutorPedido(), p.getPrecio() );
			}
		} catch (java.lang.NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Cola pizzeria vacia");
			//e.printStackTrace();
		}
		System.out.println();
	}
	

	/**
	 * Imprime la cola de despachos de la pizzeria que recibe como argumento.
	 * @param pizzeria Pizzeria de la cual se imprimira la cola.
	 */
	private static void imprimirColaDespachos(Pizzeria pizzeria)
	{
		List<String> li=new ArrayList<String>();
		li.add("nuevo");
		Collections.sort(li);
		System.out.println("      COLA DESPACHOS      ");
		int index = 1;
		try {
			for(Pedido p : pizzeria.colaDespachosList())
			{
				System.out.printf("%d. %s (%d mts.)%n", index++, p.getAutorPedido(), p.getCercania() );
			}
		} catch (java.lang.NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Cola Pizzeria vacia");
			//e.printStackTrace();
		}
	}
	
	
	/**
	 * Imprime los contenidos de un archivo de texto en la ruta del programa, 
	 * con el nombre que entra por parametro. 
	 * @param nombre Nombre del archivo que se quiere imprimir.
	 */
	static void imprimirArchivo(String nombre)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
			   String line = null;
			   while ((line = br.readLine()) != null) {
			       System.out.println(line);
			   }
			   br.close();
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}
