package ejercicio02;

/*  Introduce por teclado un texto (pulse enter y a continuación ctrl.^d para terminar).
 * Imprime en pantalla el número de veces que aparece cada letra del abecedario en el texto. 
 * Pista: emplea un array de contadores donde se asocie la posición con el contador correspondiente.
 * (‘a’ – ‘a’ = 0, ‘b’ – ‘a’ = 1 y así sucesivamente). 
 * En una línea aparecerán las letras del abecedario y en la siguiente el número de veces que aparece cada letra.*/

import java.io.IOException;
//Siempre que se utilice un método read hay que importar el paquete java.io.IOException

public class ContadorLetras
{
	public static void main(String[] args) throws IOException 
	{
		int abc[] = new int ['z'-'a'+1];
		System.out.println("Introduce un texto (pulse enter y, a continuación, Control+d para terminar): ");
		final char eof = (char) -1;
		
		char car = (char) System.in.read();
		
		while(car != eof)
		{
			//convertimos a minúscula
			car = Character.toLowerCase(car);
			
			//comprobamos si es una letra del abecedario	
			if(car >= 'a' && car <= 'z')
				abc[car-'a']++;
			car = (char) System.in.read(); //Siempre que se utilice un método read hay que importar el paquete java.io.IOException
		
		}
		System.out.println("\n\n");
		
		for(char letra = 'a'; letra <= 'z'; letra++)
		{
			System.out.print(letra + "  ");
		}
		
		System.out.println("\n");
		
		for(int i = 0; i < 'z'-'a'+1; i++)
		{
			System.out.print(abc[i]+"  ");
		}

	}

}
