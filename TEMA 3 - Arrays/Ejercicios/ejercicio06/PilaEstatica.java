package pilaestatica;

/** Una pila estática se implementa sobre una array. 
 * Una pila es una estructura en la cual, el último elemento en entrar,
 * es el primero en salir (LIFO).
 * 
 * Como ejemplo, vamos a introducir el abecedario en una pila utilizando un
 * array de caracteres.
 * 
 * Cima va a ser la posiución donde insertamos y eliminamos los caracteres.
 * 
 * @author luis
 */

public class PilaEstatica 
{
	//atributos
	private char pila[];
	private int cima;
	private int tamMax;
	
	//Constructor
	public PilaEstatica() 
	{
		cima = 0;
		tamMax = 'z' - 'a' + 1;
		pila = new char[tamMax];
	}
	
	//Método que retorna un valor que indica si la pila está llena
	public boolean pilaLlena()
	{
		return (cima == tamMax);
	}
	
	//Este método mete una letra en la pila
	public void meter(char letra) 
	{
		//Compruebo si la pila está llena
		if (pilaLlena())
		{
			System.err.println("ERROR: la pila está llena.");
		}
		else
		{
			pila[cima] = letra;
			cima++;
		}
	}
	
	//Método que retorna un valor que indica si la pila está vacía
	public boolean pilaVacia()
	{
		return (cima == 0);
	}
	
	//Este método retorna la letra que saca de la pila
	public char sacar()
	{
		//Comprobamos si la pila está vacía
		if (pilaVacia())
		{
			System.err.println("ERROR. La pila está vacía.");
			return 0;
		}
		else
		{
			cima--;
			return pila[cima];
		}
	}
	
	//Este método rellena la pila con el abecedario
	public void rellenar()
	{
		for(char letra = 'a'; letra <= 'z'; letra++)
		{
			meter(letra);
		}
	}
	
	/*Este método vacía la pila, llevando a pantalla las letras 
	que ha sacado*/
	public void vaciar() 
	{
		while (!pilaVacia())
		{
			System.out.print(sacar() + " ");
		}
	}
	
	
}
