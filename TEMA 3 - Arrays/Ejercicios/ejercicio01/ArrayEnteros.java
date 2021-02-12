// Dise�a una clase denominada ArrayEnteros con las siguientes métodos:
	
package ejercicio01;

import java.util.Scanner;

public class ArrayEnteros 
{
	//atributos 
	
		private int array[];
		private int tamMax;
		private int numElem;
		
		
	//constructores 
		
		/*Constructor sin parámetros. Solicitamos por teclado el tama�o del array, creamos
		espacio para almacenar la informaci�n e inicializamos el n�mero de elementos. */
		public ArrayEnteros() 
		{
			Scanner entrada = new Scanner(System.in);
			System.out.print("Introduce el tama�o de la lista: ");
			tamMax = entrada.nextInt();
			array = new int[tamMax];
			numElem = 0;
		}
		
		//Constructor copia
		public ArrayEnteros(ArrayEnteros copia) {
			tamMax = copia.tamMax;
			array = new int[tamMax];
			numElem = 0;
			for (int i = 0; i < copia.numElem; i++) {
				array[i] = copia.array[i];
				numElem ++;
			}
		}
		
		// Constructor que reciba el tamaño del array.
		public ArrayEnteros(int tamMax)
		{
			this.tamMax = tamMax;
			array = new int[tamMax];
			numElem = 0;
		}
		
		
	//métodos
			
		// leerArray. Introduce por teclado el contenido del array hasta que el usuario teclee 999 o no quepan más datos.
		public void leerArray() 
		{
			int num;
			boolean salir; 
			System.out.println("El tamaño máximo del array es " + tamMax);
			
			Scanner entrada = new Scanner(System.in);
			
			do{
				System.out.print("Introduce un número (teclea 999 para terminar): ");
				num = entrada.nextInt();
				salir = num == 999 || numElem == tamMax -1;
				if (num != 999) {
					array[numElem] = num;
					numElem ++;
				}				
			}
			while(!salir);
			
		}
		
		
		//escribirArray. Visualiza en pantalla el contenido del array.
		public void escribirArray()
		{
			for(int i = 0; i < numElem; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println(" ");
		}
		
		
		/*insertar. Solicita la posición donde se desea insertar un dato, siendo ésta una de las
		 * que están ocupadas. Si la posición es válida lleva a cabo la inserción actualizando el número
		 * de elementos. */
		public void insertar()
		{
			int dato, posicion;
			boolean posicionValida;
			
			//Pedir el dato por teclado
			Scanner entrada = new Scanner (System.in);
			System.out.print("Introduce el dato que quieres insertar: ");
			dato = entrada.nextInt();

			//Pedir la posición por teclado y comprobar que está ocupada
			do
			{
				System.out.print("Introduce la posición en la que quieres insertar el dato: ");
				posicion = entrada.nextInt();
				posicionValida = (posicion >= 0 && posicion <= numElem);
				if (!posicionValida) {
					System.out.print("La posición no es válida. ");
				}
			}
			while (!posicionValida);
			
			//Mover los elementos para insertar el nuevo en la posición indicada
			//OJO: Si el array está lleno, el programa fallará
			
			for(int i = numElem; i > posicion; i--) {
				array[i] = array[i-1];
			}
			array[posicion] = dato;
			numElem++;
			
		}
		
		
		/* Eliminar. Solicita la posici�n donde se desea eliminar un dato, siendo �sta una de las que est�n ocupadas. 
		* Si la posici�n es v�lida lleva a cabo la eliminaci�n actualizando el n�mero de elementos.*/
		public void eliminar()
		{
			int posicion;
			boolean posicionValida;

			//Pedir la posici�n por teclado y comprobar que est� ocupada
			do
			{
				Scanner entrada = new Scanner (System.in);
				System.out.print("Introduce la posici�n de la que quieres eliminar el dato: ");
				posicion = entrada.nextInt();
				posicionValida = (posicion >= 0 && posicion <= numElem);
				if (!posicionValida) {
					System.out.print("La posici�n no es v�lida. ");
				}
			}
			while (!posicionValida);
			
			//Eliminar el elemento de la posici�n indicada y mover los elementos
									
			for(int i = posicion; i < numElem -1; i++) 
			{
				array[i] = array[i + 1];
			}
			numElem--;
		}
		
		/*busquedaSecuencial. Realiza un b�squeda secuencial (no ordenada). 
		 * Devuelve la posici�n donde se encuentra el elemento, -1 si no se encuentra.*/
		
		//Opci�n 1
		public int busquedaSecuencial(int buscado)
		{
			for (int i = 0; i < numElem; i++)
			{
				if (buscado == array[i])
				{
					return i; 
				}
			}
			return -1;
		}
		
		//Opci�n 2: Es churrusquera: mejor hacerlo con la de arriba, que es un for y queda más elegante
		public int busquedaSecuencial2(int buscado)
		{
			int posicion = 0;
			boolean encontrado = false;
			while (!encontrado && posicion < numElem) 
			{
				if (buscado == array[posicion]) 
				{
					encontrado = true;	
				}
				else 
				{
					posicion++;
				}
			}
			if (encontrado)
			{
				return posicion;
			}
			else {
				return -1;
			}
		}
		
		/* ordenaBurbuja. Ordena de menor a mayor por el m�todo de la burbuja. 
		 * Para ello, recorremos el array y comparamos elementos adyacentes. 
		 * Si no estan ordenados los intercambiamos. */
		public void ordenaBurbuja()
		{
			boolean hayIntercambio;
			do {
				hayIntercambio = false;
				for(int i = 0; i < numElem - 1; i++)
				{
					if(array[i] > array[i+1])
					{
						int auxiliar = array[i];
						array[i] = array[i+1];
						array[i+1] = auxiliar;
						hayIntercambio = true;
					}
				}
			}while(hayIntercambio);
		}	
		
		/* busquedaBinaria. Realiza una b�squeda binaria o dicot�mica (ordenada). 
		 * Este algoritmo busca en un array que previamente debe de estar ordenado.
		 * Si es así, es más rápido que una búsqueda secuencial. */
		public int busquedaBinaria(int buscado) 
		{
			int primeraPos = 0;
			int ultimaPos = numElem - 1;
			int centralPos;
			do {
				//Calculamos la posición central
				centralPos = (primeraPos + ultimaPos) / 2;
				if(buscado > array[centralPos])
					primeraPos = centralPos + 1;
				else if(buscado < array[centralPos])
					ultimaPos = centralPos -1;
			}while(primeraPos <= ultimaPos && buscado != array[centralPos]);
			//Si lo ha encontrado, devolvemos la posición en la que está; si no, devolvemos -1
			if(buscado == array[centralPos])
				return centralPos;
			return -1;
		}
			
		/* fusion. Fusiona o mezcla dos arrays previamente ordenados. */
		 public ArrayEnteros fusion(ArrayEnteros array2)
		 {
			 //creamos un tercer array para meter los datos fusionados
			 ArrayEnteros array3 = new ArrayEnteros(numElem + array2.numElem); //Esta operación determina el tamaño máximo de la cadena, pero no asigna valor a numElem
			 //inicializamos los indices de los 3 arrays
			 int i = 0; //índice array1
			 int j = 0; //indice array2
			 int k = 0; //indice array3
			 
			 //Comparamos los valores de array 1 y array2 y vamos copiando el más pequeño en array3
			 // De este modo, array 3 estará ordenado 
			 while(i < numElem &&  j < array2.numElem)
			 {
				 if(array[i] < array2.array[j])
				 {
					 array3.array[k] = array[i];
					 i++;
					 k++;
				 }
				 else
				 {
					 array3.array[k] = array2.array[j];
					 j++;
					 k++;
				 }			 			 
			 }
			 //Como lo habitual es que los arrays tengan distintos tamaños,  
			 // copiamos los elementos restantes
			 while(i < numElem)
			 {
				 array3.array[k] = array[i];
				 i++;
				 k++;
			 }
			 
			 while(j < array2.numElem)
			 {
				 array3.array[k] = array2.array[j];
				 j++;
				 k++;
				 
			 }
			 array3.numElem = k; //Aquí asignamos valor a numElem de array 3; hasta ahora no lo tenía y, si no hacemos esto, el array no funcionará
			 return array3;
			 
		 }
		 
		/* ParesImpares. Visualiza en pantalla el n�mero de pares e impares que hay en el array. */
		
		/* Media. Visualiza en pantalla la media aritm�tica de los elementos del array. */
}
