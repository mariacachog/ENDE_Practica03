package ejercicio04;

import java.util.Scanner;

public class Matriz {
	private int numColumnas;
	private int numFilas;
	private double matriz[][];

	//Constructor
	public Matriz() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el número de filas: ");
		numFilas = entrada.nextInt();
		System.out.println("Introduce el número de columnas: ");
		numColumnas = entrada.nextInt();
		matriz = new double[numFilas][numColumnas];
		}
	
	public void introducirDatos() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce los valores de la matriz: ");
		for(int fila = 0; fila < numFilas; fila ++) {
			for(int columna = 0; columna < numColumnas; columna ++) {
				matriz[fila][columna] = entrada.nextDouble();
			}
		}
	}
	
	
	public double sumaDiagonalV1() {
		double suma = 0;
		for(int fila = 0; fila < numFilas; fila ++) {
			for(int columna = 0; columna < numColumnas; columna ++) {
				//comprobamos que el elemento está en la diagonal principal (nº de filas = nº de columnas)
				if(fila == columna) {
					suma = suma + matriz[fila][columna];
				}
			}
		}
		return suma;
		// OJO: si nos piden los tres nº colocados en la parte derecha superior: 
		// nº de columnas > nº de filas
		// Si nos piden los tres nº colocados en la parte inferior izquierda: 
		// nº de filas > nº de columnas
	}
	
	public void sumaTotalesFilas() {
		
		// Instanciar los arrays auxiliares para almacenar los datos
		double sumaFilas[] = new double [numFilas];
		
		
		//Total por filas
		for(int fila = 0; fila < numFilas; fila++) {
			
			//Inicializar el acumulador de la suma de filas
			sumaFilas[fila] = 0;
			
			for(int columna = 0; columna < numColumnas; columna++) {
				sumaFilas[fila] = sumaFilas[fila] + matriz[fila][columna];
			}
		}
		System.out.println("La suma de las filas es " + sumaFilas[numFilas]);
	}
	
	public void sumaTotalesColumnas() {
		
		// Instanciar los arrays auxiliares para almacenar los datos
		double sumaColumnas[] = new double [numColumnas];
		
		//Total por columnas
		for(int columna = 0; columna < numColumnas; columna++) {
					
			//Inicializar el acumulador de la suma de columnas
			sumaColumnas[columna] = 0;
				
			for(int fila = 0; fila < numFilas; fila++) {
				sumaColumnas[columna] = sumaColumnas[columna] + matriz[fila][columna];
			}
		}	
		System.out.println("La suma de las columnas es " + sumaColumnas);
	}
}
