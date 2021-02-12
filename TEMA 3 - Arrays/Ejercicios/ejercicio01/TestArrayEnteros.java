package ejercicio01;

import java.util.Scanner;

public class TestArrayEnteros {

	public static void main(String[] args)
	{
		
		//Creamos un objeto
		ArrayEnteros array = new ArrayEnteros();
				
		//Introducimos datos en el array
		array.leerArray();
				
		//Enviamos a pantalla el contaenido del array
		array.escribirArray();
		
		//Creamos una copia del array
		ArrayEnteros arrayCopia = new ArrayEnteros(array);
		
		//Insertamos un dato
		array.insertar();
		array.escribirArray();
		
		//Eliminamos un dato
		array.eliminar();
		array.escribirArray();
		
		//Buscamos un dato mediante búsqueda secuencial V.1.
		System.out.println("Busqueda secuencial version 1");
		Scanner entrada = new Scanner (System.in);
		System.out.print("Introduce el dato que quieres buscar: ");
		int buscado = entrada.nextInt();
		int posicion = array.busquedaSecuencial(buscado); //Lo que se pretende es bucar la posición del dato introducido
		//Enviamos un mensaje en función de si el dato ha sido encontrado o no (en este segundo caso, el método retornará el valor posición -1)
		boolean existe = (posicion != -1);
		if (existe) {
			System.out.println(buscado + " está en la posición " + posicion);
		} 
		else {
			System.out.println(buscado + " no está en el array.");
		}
		
		//Buscamos un dato mediante búsqueda secuencial V.2.
		System.out.println("Busqueda secuencial version 2");
		System.out.print("Introduce el dato que quieres buscar: ");
		buscado = entrada.nextInt();
		posicion = array.busquedaSecuencial2(buscado);
		//Enviamos un mensaje en función de si el dato ha sido encontrado o no (en este segundo caso, el método retornará el valor posición -1)
		existe = (posicion != -1);
		if (existe) {
			System.out.println(buscado + " está en la posición " + posicion);
		}
		else {
			System.out.println(buscado + " no está en el array.");
		}
		
		//Ordenamos los elementos del array
		System.out.print("Esta es nuestra array ahora: ");
		array.escribirArray();
		array.ordenaBurbuja();
		System.out.print("Esta es nuestra array ordenada (por el método de la burbuja): ");
		array.escribirArray();
		
		//Buscamos un dato mediante búsqueda binaria o dicotómica
		System.out.println("Busqueda binaria o dicotómica (sólo se puede usar en arrays ordenadas)");
		System.out.print("Introduce el dato que quieres buscar: ");
		buscado = entrada.nextInt();
		posicion = array.busquedaBinaria(buscado);
		//Enviamos un mensaje en función de si el dato ha sido encontrado o no (en este segundo caso, el método retornará el valor posición -1)
		existe = (posicion != -1);
		if(existe)
			System.out.println(buscado + " está en la posición " + posicion);
		else
			System.out.println(buscado + " no está en el array.");
		
		
		//Enviamos a pantalla el contaenido del array y de arrayCopia
		System.out.print("Esta es nuestra array ahora: ");
		array.escribirArray();
		System.out.print("Esta es la copia del array que escribimos inicialmente: ");
		arrayCopia.escribirArray();
	}

}
