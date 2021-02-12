package ejercicio04;

public class Testmatriz {
	
	public static void main(String[] args) {
		Matriz matriz1 = new Matriz();
		matriz1.introducirDatos();
		matriz1.verMatriz();
		System.out.println("La suma de la diagonal principal Versión1 es: " + matriz1.sumaDiagonalV1());
		matriz1.sumaTotalesFilas();
		matriz1.sumaTotalesColumnas();
	}

}
