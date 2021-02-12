package pilaestatica;

public class TestPilaEstatica {
	
	public static void main (String args[])
	{
	//Instanciamos una pila estática
	PilaEstatica pila = new PilaEstatica();
	
	//Rellenamos la pila con el abecedario
	pila.rellenar();
	
	//
	pila.meter('M');
	
	//Vaciamos la pila
	pila.vaciar();
	
	//
	pila.sacar();
	}
}
