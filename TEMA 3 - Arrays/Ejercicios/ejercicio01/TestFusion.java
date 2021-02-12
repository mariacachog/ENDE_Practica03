package ejercicio01;

import java.util.Scanner;

public class TestFusion {

	public static void main(String[] args) 
	{
		//Creamos array1
		ArrayEnteros array1 = new ArrayEnteros();
				
		//Introducimos datos en el array
		Scanner entrada = new Scanner(System.in);
		array1.leerArray();
		
		//Enviamos a pantalla el contenido del array
		System.out.print("Este es el array 1: ");
		array1.escribirArray();
		
		//Lo ordenamos
		array1.ordenaBurbuja();
		
		//Y lo volvemos a mostrar, ya ordenado
		System.out.println();
		System.out.print("Este es el array 1 ordenado: ");
		array1.escribirArray();
		
		//Creamos array2
		ArrayEnteros array2 = new ArrayEnteros();
						
		//Introducimos datos en el array
		array2.leerArray();
				
		//Enviamos a pantalla el contenido del array
		System.out.print("Este es el array 2: ");
		array2.escribirArray();
		
		//Lo ordenamos
		array2.ordenaBurbuja();
		
		//Y lo volvemos a mostrar, ya ordenado
		System.out.println();
		System.out.print("Este es el array 2 ordenado: ");
		array2.escribirArray();
		
		//Creamos un tercer array y realizamos la fusión de array1 y array2
		ArrayEnteros array3 = array1.fusion(array2);
		System.out.print("Este es el array 3, que fusiona los arrays 1 y 2: ");
		array3.escribirArray();

	}

}
