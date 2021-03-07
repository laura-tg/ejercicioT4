package ejercicioT4;

import java.util.Scanner;

public class ejercicioT4
{
	// Generar n�meros primos de 1 a max
	public static int[] generarPrimos (int max)
	{
		int dim = max + 1; // Tama�o del array
		boolean[] esPrimo = new boolean[dim];
		if (max >= 2) {
			inicializarArray(dim, esPrimo);
			criba(dim, esPrimo);
			int cuenta = cuantosPrimos(dim, esPrimo);
			return rellenarVector(dim, esPrimo, cuenta);
		} else { // max < 2
			return new int[0];
			// Vector vac�o
		}
	}
	private static int[] rellenarVector(int dim, boolean[] esPrimo, int cuenta) {
		int i,j;
		int[] primos = new int[cuenta];
		for (i=0, j=0; i<dim; i++) {
			if (esPrimo[i])
				primos[j++] = i;
		}
		return primos;
	}
	private static int cuantosPrimos(int dim, boolean[] esPrimo) {
		int i;
		int cuenta = 0;
		for (i=0; i<dim; i++) {
			if (esPrimo[i])
				cuenta++;
		}
		return cuenta;
	}
	private static void criba(int dim, boolean[] esPrimo) {
		int i, j;
		for (i=2; i<Math.sqrt(dim)+1; i++) {
			if (esPrimo[i]) {
				// Eliminar los m�ltiplos de i
				for (j=2*i; j<dim; j+=i)
					esPrimo[j] = false;
			}
		}
	}
	private static void inicializarArray(int dim, boolean[] esPrimo) {
		int i;
		for (i=0; i<dim; i++)
			esPrimo[i] = true;
		// Eliminar el 0 y el 1, que no son primos
		esPrimo[0] = esPrimo[1] = false;
	}
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce el n�mero para la criba de Erast�tenes:");
		int dato=teclado.nextInt();
		int vector[]=new int[dato];
		System.out.println("\nVector inicial hasta :"+dato);
		for (int i = 0; i < vector.length; i++) {
				if (i%10==0) System.out.println();
				System.out.print(i+1+"\t");
		}
		vector=generarPrimos(dato);
		System.out.println("\nVector de primos hasta:"+dato);
		for (int i = 0; i < vector.length; i++) {
			if (i%10==0) System.out.println();
			System.out.print(vector[i]+"\t");
		}
	}
	
}