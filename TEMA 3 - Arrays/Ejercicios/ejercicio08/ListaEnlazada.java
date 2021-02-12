package listaEnlazada;

/**
 * Fecha: 12/02/2021
 * @author luis
 *
 * Una lista enlazada simple es una secuencia de nodos. Cada nodo
 * tendrá un par de atributos: uno de ellos guarda la información 
 * y le vamos a llamar "info" y el otro guardaría la referencia a 
 * otro nodo; le vamos a llamar "enlace".
 * 
 * Tendremos una referencia llamada "inicio" que apuntará siempre
 * al primer nodo de la lista.
 * 
 * EL final de la lista lo sabemos porque el último nodo, en el atributo
 * enlace, tendrá un "null".
 */

public class ListaEnlazada 
{
	
	/**Atributos */
	Nodo inicio; /** Apunta o referencia el primer nodo de la lista */
	
	/**Constructor */
	public ListaEnlazada()
	{
		inicio = null;
	}
	
	/**Este método inserta un nodo al principio de la lista*/
	public void insertarPrincipio(Object obj)
	{
		//Creamos un nuevo nodo y lo enlazamos con el primero
		Nodo nuevo = new Nodo(obj, inicio);
		//Actualizamos inicio
		inicio = nuevo;
	}
	
	/** Este método nos muestra en pantalla el contenido de la lista */
	public void verLista()
	{
		//Nos situamos en el primer nodo de la lista.
		Nodo actual = inicio;
		//Recorremos toda la lista
		while(actual != null)
		{
			System.out.println(actual.info);
			//Avanzamos al siguiente nodo
			actual = actual.enlace;
		}
	}
	
	/** Este método inserta un nodo al final de la lista */
	public void insertarFinal(Object obj)
	{
		
	}
}
