package ejercicio05;

import java.util.Scanner;

/**
 * Esta aplicación gestiona una agenda de contactos
 * @author alumnoa
 * Fecha: 02/02/21
 */

public class Agenda {
	
	//atributos
	Contacto contactos[]; //Array de contactos
	int numElem; //Número de contactros que tiene la agenda

	/**
	 * Constructor de la clase
	 */
	public Agenda() {
		numElem = 0;
		contactos = new Contacto[numElem];
	}
	
	/**
	 * Este método solicita memoria para un elemento más
	 * y copia los elementos que estaban en el array original
	 */
	
	public void unElementoMas(Contacto auxiliar[]) {
		
		//Pedimos memoria para un elemento más
		contactos = new Contacto[numElem +1];
		
		//Copiamos los elementos del array antiguo (que hemos puesto en auxiliar) en el nuevo
		for (int i = 0; i < numElem; i++) {
			contactos[i] = auxiliar[i];
		}
		
		//Actualizamos el número de elementos
		numElem++;
	}
	
	/**
	 * Este método solicita memoria para un elemento menos y copia los elementos que 
	 * estaban en el array original excepto el que está marcado para ser eliminado
	 */
	
	public void unElementoMenos(Contacto auxiliar[]) {
		
		//Pedimos memoria para un elemento menos
		contactos = new Contacto[numElem -1];
		
		//Copiamos los elementos del array antiguo (que hemos puesto en auxiliar) 
		// en el nuevo excepto el contacto marcado para eliminar
		for (int i = 0; i < numElem; i++) {
			//Tenemos que declarar el índice del array destino porque la 
			//posición i es mayor que el tamaño de este array
			int j = 0;
			if (auxiliar[i] != null) {
				contactos[j] = auxiliar[i];
				j++;
			}
		}
		
		//Actualizamos el número de elementos
		numElem--;
	}
	
	/**
	 * Este método añade un nuevo contacto al final del array
	 */
	
	public void annadir(Contacto nuevoContacto) {
		unElementoMas(contactos);
		insertar(numElem -1, nuevoContacto); 
		//OJO: numElem siempre hace referencia a la posición siguiente a aquella en la que termina 
		//el último elemento
	}
	
	/**
	 * Este método inserta un contacto en la posición que le indiquemos (en este caso, en la ultima)
	 */
	
	public void insertar(int posicion, Contacto nuevoContacto) {
		
		//Validamos que la posición es correcta
		if (posicion >= 0 && posicion < numElem) {
			//Insertamos el contacto
			contactos[posicion] = nuevoContacto;
		}
		else {
			System.out.println("No se puede insertar el contacto; la posición no es correcta.");
		}
	}
	
	
	/**
	 * Este método marca un elemento para ser eliminado asignándole el valor null
	 * y llama al método para eliminar memoria
	 */
	
	public void marcarEliminado(int posicion) {
		contactos[posicion] = null;
		unElementoMenos(contactos);
	}
	
	/**
	 * Este método busca un contacto en la agenda:
	 * si lo encuentra, retorna su posición; si no lo encuentra, retorna -1.
	 */
	
	public int buscarContacto(String nombre) {
		for (int i = 0; i < numElem; i++) {
			if (nombre.equals(contactos[i].getNombre())) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Este método añade un nuevo contacto en la agenda:
	 * pide los datos del nuevo contactop, comprueba si está en la agenda y, si no, lo añade.
	 */
	
	public void nuevoContacto() {
		Contacto nuevoContacto = introducirDatos();
		int posicion = buscarContacto(nuevoContacto.getNombre());
		boolean existe = (posicion != -1);
		if (existe) {
			System.out.println("El contacto no se puede añadir porque ya existe");
		}
		else {
			annadir(nuevoContacto);
		}
	}
	
	/**
	 * Este método introduce por teclado los datos de un nuevo contacto y retorna su referencia
	 */
	
	public Contacto introducirDatos() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el nombre del nuevo contacto: ");
		String nombre = entrada.nextLine();
		System.out.println("Introduce el teléfono del nuevo contacto: ");
		String telefono = entrada.nextLine();
		System.out.println("Introduce el email del nuevo contacto: ");
		String email = entrada.nextLine();
		//Creamos el contacto con los parámetros introducidos para devolverlo
		Contacto nuevoContacto = new Contacto(nombre, telefono, email);
		return nuevoContacto;
	}
	
	/**
	 * Este método pide el nombre de un contacto para trabajar con él
	 */
	
	public String pedirNombre() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el nombre del contacto: ");
		return entrada.nextLine();
	}
	
	/**
	 * Este método realiza la consulta de un contacto por el nombre
	 */
	
	public void consultarContacto() {
		//Pedimos el nombre
		String nombre = pedirNombre();
		//Comprobamos si existe
		int posicion = buscarContacto(nombre);
		boolean existe = (posicion != -1);
		if (existe) {
			System.out.println(contactos[posicion]); //Como el método toString está sobrecargado 
			// en la clase contacto, se imprimirá toda la información en lugar de la referencia del objeto
		}
		else {
			System.out.println("El contacto no existe.");
		}		
	}
	
	/**
	 * Este método elimina un contacto
	 */
	
	public void eliminarContacto() {
		//Pedimos el nombre
		String nombre = pedirNombre();
		//Comprobamos si existe
		int posicion = buscarContacto(nombre);
		boolean existe = (posicion != -1);
		if (existe) {
			//Lo eliminamos marcándolo con un null
			marcarEliminado(posicion);
			System.out.println("Contacto eliminado.");
		}
		else {
			System.out.println("El contacto no existe.");
		}	
	}
	
	/**
	 * Creamos un método que compuebe si la agenda está vacía
	 */
	
	public boolean agendaVacia() {
		return (numElem == 0);
	}
	
	/**
	 * Este método sirve para listar todos los contactos de la agenda ordenador por el nombre
	 */
	
	public void listarOrdenado() {
		if (agendaVacia()) {
			System.out.println("La agenda está vacía.");
		}
		//Ordenamos la agenda
		else {
			ordenar();
			verAgenda();
		}
	
	}
	
	/**
	 * Este método sirve para ordenar la agenda
	 */
	
	public void ordenar() {
		/*Recorremos el array comparando elementos adyacentes. 
		 * Si no están bien colocados, los intercambiamos.*/
		boolean hayIntercambio;
		do {
			hayIntercambio = false;
			for (int i = 0; i < numElem-1; i++) {
				if (contactos[i].getNombre().compareTo(contactos[i+1].getNombre()) > 0) {
					//Los intercambiamos
					Contacto auxiliar = contactos[i+1];
					contactos[i+1] = contactos[i];
					contactos[i] = auxiliar;
					hayIntercambio = true;
				}
			}
		} 
		while(hayIntercambio);
	}
	
	/**
	 * Este método sirve para ver toda la agenda
	 */
	
	public void verAgenda() {
		for (int i = 0; i < numElem; i++) {
			System.out.println(contactos[i]); //Como el método toString está sobrecargado 
			// en la clase contacto, se imprimirá toda la información en lugar de la referencia del objeto
		}
	}
	
	/**
	 * Este método sirve para editar un contacto
	 */
	
	public void editarContacto () {
		//Pedimos el nombre
		String nombre = pedirNombre();
		//Comprobamos si existe
		int posicion = buscarContacto(nombre);
		boolean existe = (posicion != -1);
		if (existe) {
			//Creamos un menú para saber el campo que queremos editar
			Scanner entrada = new Scanner(System.in);
			boolean salir = false;
			do {
				System.out.println("Editando el contacto " + contactos[posicion]);
				System.out.println("Introduce la opción que necesites del menú: ");
				System.out.println("1 Editar nombre");
				System.out.println("2 Editar número");
				System.out.println("3 Editar email");
				System.out.println("4 Salir");
				int opcion = entrada.nextInt();
				salir = (opcion == 4);
				// Limpiamos el buffer
				entrada.nextLine();
				switch (opcion) {
					case 1: 
						System.out.println("Introduce el nuevo nombre: ");
						String nuevoNombre = entrada.nextLine();
						contactos[posicion].setNombre(nuevoNombre);
						System.out.println("Se ha editado el contacto:");
						System.out.println(contactos[posicion]);
						break;
					
					case 2: 
						System.out.println("Introduce el nuevo teléfono: ");
						String nuevoTelefono = entrada.nextLine();
						contactos[posicion].setTelefono(nuevoTelefono);
						System.out.println("Se ha editado el contacto:");
						System.out.println(contactos[posicion]);
						break;
					
					case 3: 
						System.out.println("Introduce el nuevo email: ");
						String nuevoEmail = entrada.nextLine();
						contactos[posicion].setEmail(nuevoEmail);
						System.out.println("Se ha editado el contacto:");
						System.out.println(contactos[posicion]);
						break;
		
					case 4: 
						salir = true;
						break;
						
					default:
						System.out.println("ERROR. Introduce una opción válida (1-4): ");
						break;
					} 
			}
			while (!salir);
		}
		else {
			System.out.println("El contacto no existe.");
		}	
	}
	
	/**
	 * Este método sirve para ver el menú.
	 */
	
	public int verMenu() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1 Crear un nuevo contacto");
		System.out.println("2 Editar un contacto");
		System.out.println("3 Eliminar un contacto");
		System.out.println("4 Consultar un contacto");
		System.out.println("5 Ver la agenda completa");
		System.out.println("6 Salir");
		int opcion = entrada.nextInt();
		return opcion;
	}
	
	/**
	 * Este método sirve para arrancar la aplicación.
	 */
	
	public void arrancarApp() {
		System.out.println("Esta es tu agenda de contactos.");
		boolean salir = false;
		do {
			int opcion = verMenu();
			salir = (opcion == 6);
			switch(opcion) {
			case 1:
				nuevoContacto();
				break;
			case 2:
				editarContacto();
				break;
			case 3:
				eliminarContacto();					
				break;
			case 4:
				consultarContacto();
				break;
			case 5:
				verAgenda();					
				break;	
			case 6:
				salir = true;
				break;
			}
		} while(!salir);
			
		
		System.out.println("Aplicación finalizada.");	
	}
}
