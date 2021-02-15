/* Diseña una clase denominada Cadena para manipular cadenas. 
 * Los caracteres se almcenarán en un array de caracteres. 
 * La clase dispondrá de los siguientes métodos: */

package ejercicio03;

import java.io.IOException;
//Siempre que se utilice un método read hay que importar el paquete java.io.IOException

public class Cadena {
	
	/* Un constructor que reciba el tamaño máximo de la cadena y pida memoria para el tamaño máximo +1, 
	 * puesto que después del último carácter almacendo en el array guardaremos un '/0' que indique fin de cadena. */
	private char cadena[];
	private int tamMax;
	
	public Cadena(int tamMax)
	{
		this.tamMax = tamMax;
		cadena = new char[tamMax + 1];
	}
	
	/* leerCadena. Lee una cadena por teclado, almacenando un '/0' después del último carácter. 
	 * Dejamos de introducir caracteres a pulsar enter*/
	public void leerCadena() throws IOException //Siempre que se utilice un método read hay que importar el paquete java.io.IOException
	{
		int i = 0;
		char letra = (char)System.in.read();
		
		while(i < tamMax &&letra != '\n')
		{
			cadena[i] = letra;
			i++;
			letra = (char)System.in.read();
			//Siempre que se utilice un método read hay que importar el paquete java.io.IOException
		}
		cadena[i] = '\0';
	}
	
	//escribirCadena. Envía el contenido de la cadena al monitor.
	
	//Opción 1: usando un bucle for
	public void escribirCadenaFor()
	{
		for(int i = 0; cadena[i] != '\0'; i++)
		{
			System.out.print(cadena[i]);
		}
		System.out.println();
	}
	
	//Opción 2: usando un bucle while
		public void escribirCadenaWhile()
		{
			int i = 0;
			while(cadena[i] != '\0')
			{
				System.out.print(cadena[i]);
				i++;
			}
			System.out.println();
		}
	
		
	//longitud. Retorna el número de caracteres que contiene la cadena.
	public int longitud()
	{
		int posicion = 0;
		while(cadena[posicion] != '\0')
		{
			posicion++;
		}
		return posicion;
	}
	
	
	//eliminarVocales. Elimina las letras vocales de la cadena moviendo los caracteres siguientes una posición atrás.
	
	// Para ello, necesitaremos un método esVocal que indique si una letra es vocal.
	public boolean esVocal(char letra)
	{
		letra = Character.toLowerCase(letra);
		return (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u');
	}
	
	//Ahora que ya podemos saber qué letras son vocales, creamos el método que las elimine
	public void eliminarVocales()
	{
		for(int i = 0; cadena[i] != '\0'; i++)
		{
			if(esVocal(cadena[i])) {
				for(int j = i; cadena[j] != '\0'; j++)
				{
					cadena[j]= cadena[j+1];
				}
			}
		}		
	}
		
	// esPalindromo. Un palíndromo es una palabra que se lee igual de izquierda a derecha que de derecha a izquierda
	public boolean esPalindromo()
	{
		int ultimaPosicion = longitud()-1;
		
		for(int i = 0; i < ultimaPosicion/2; i++)
		{
			if(cadena[i] != cadena[ultimaPosicion-i])
			{
				return false;
			}	
		}
		return true;
	}
	
}
