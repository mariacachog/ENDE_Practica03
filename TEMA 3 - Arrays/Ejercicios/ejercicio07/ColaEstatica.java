package colaestatica;

/** Una cola es una estructura en la cual, el primero en entrar es el
 * primero en salir (FIFO).
 * 
 * En nuestro ejemplo vamos a emplear una cola lineal
 * sobre un array.
 * 
 * @author luis
 *
 */

public class ColaEstatica {
	
	//atributos
	private int fin;
	private int inicio;
	private int tamMax;
	private char cola[];
	
	//Constructor
	public ColaEstatica()
	{
		fin = 0;
		inicio = 0;
		tamMax = 'z' - 'a' + 1;
		cola = new char[tamMax];
	}
	
	//Hacemos un método que compruebe si la cola está llena
	public boolean colaLlena() {
		return (fin == tamMax);
	}
	
	//Hacemos un método para meter letras en la cola
	public void meter(char letra)
	{
		if (colaLlena())
		{
			System.err.println("ERROR: la cola está llena.");
		}
		else
		{
			cola[fin] = letra;
			fin++;
		}
	}
	
	//Hacemos un método que compruebe si la cola está vacía
	public boolean colaVacia() {
		return (inicio == fin);
	}
	
	/*Hacemos un método para sacar letras de la cola y que se 
		muestren en pantalla las letras eliminadas*/
	public char sacar()
	{
		if (colaVacia())
		{
			System.err.println("ERROR: La cola está vacía.");
			return 0;
		}
		else
		{
			inicio++;
			return cola[inicio -1];
		}
	}
	/*Hacemos un método para rellenar la cola con las letras del
	 * abecedario */
	public void rellenar()
	{
		for(char letra = 'a'; letra <= 'z'; letra++) 
		{
			meter(letra);
		}
	}
	
	//Hacemos un método para vaciar la cola
	public void vaciar()
	{
		while (!colaVacia())
		{
			System.out.print(sacar() + " ");
		}
	}
}
