package ejercicio03;

import java.io.IOException;
//Siempre que se utilice un método read hay que importar el paquete java.io.IOException

public class TestCadena {

	public static void main(String[] args) throws IOException //Siempre que se utilice un método read hay que importar el paquete java.io.IOException
	{
		
		//Creamos una cadena de tamaño máximo 80
		Cadena cadena1 = new Cadena(80);
				
		//Introducimos el contenido de la cadena y lo guardamos en una dirección de memoria
		System.out.print("Introduce una cadena; pulsa enter para finalizar: ");
		cadena1.leerCadena();
		
		System.out.println();
		
		//Mostramos por pantalla la cadena que acabamos de guadar a trav�s de los m�todos escribirCadena
		System.out.print("Resultado del método escribirCadenaFor: ");
		cadena1.escribirCadenaFor();
				
		System.out.print("Resultado del método escribirCadenaWhile: ");
		cadena1.escribirCadenaWhile();

		//Creamos una copia de cadena1 y la mostramos en pantalla
		Cadena copiaCadena1 = new Cadena(cadena1);
		System.out.print("Resultado de crear una copia de la cadena anterior  y mostrarla con el método escribirCadenaFor: ");
		copiaCadena1.escribirCadenaFor();
		
		//Mostramos la longitud de las cadenas cadena1 y copiaCadena1
		System.out.println("La longitud de la cadena 1 es: " + cadena1.longitud());
		System.out.println("La longitud de la cadena copia es: " + copiaCadena1.longitud());
		
		//Eliminamos las vocales de la cadena1 y la imprimimos
		cadena1.eliminarVocales();
		System.out.println("Imprimimos la cadena1 sin vocales: ");
		cadena1.escribirCadenaFor();
		
		//Comprobamos si la copiaCadena1 es un palíndromo
		if(copiaCadena1.esPalindromo())
			System.out.println("La cadena copia es un palindromo");
		else
			System.out.println("La cadena copia no es un palindromo");
	}

}
