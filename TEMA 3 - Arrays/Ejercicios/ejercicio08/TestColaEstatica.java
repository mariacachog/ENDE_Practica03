package colaestatica;

public class TestColaEstatica {

	public static void main(String[] args) {
		//Instanciamos una cola estática
		ColaEstatica cola = new ColaEstatica();
		
		//Rellenamos la cola con el abecedario
		cola.rellenar();
		
		//Intentamos meter una letra 
		cola.meter('M');
		
		//Vaciamos la cola
		cola.vaciar();
		
		//
		cola.sacar();

	}

}
