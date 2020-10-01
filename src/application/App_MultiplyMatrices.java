package application;

import java.util.Scanner;
import java.util.Locale;

public class App_MultiplyMatrices {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int lac; //Rows and columns == , because is a square matrix.
		System.out.print("Choose the number of rows and columns of the Square Matrix: ");
		lac = sc.nextInt();
		
		System.out.println("----------------");
		
		float[][] matriz1 = new float[lac][lac];
		
		float[][] matriz2 = new float[lac][lac];
		
		System.out.println("First Matrix:");
		for(int i = 0; i<matriz1.length;i++) {
			for(int c = 0; c<matriz1[i].length;c++) {
				matriz1[i][c] = sc.nextFloat();
			}
		}
		
		System.out.println("-----------------");
		System.out.println("Second Matrix:");
		
		for(int i = 0; i<matriz1.length;i++) {
			for(int c = 0; c<matriz1[i].length;c++) {
				matriz2[i][c] = sc.nextFloat();
			}
		}
		
		//System.out.println("---------------------");
		//System.out.println(matriz1.length);
		//System.out.println(matriz1[0].length);
		
		System.out.println("---------------------");
		
		System.out.println("The result is:\n ");
		
		float[][] finalMatrice = MultiplyMatrices(matriz1,matriz2);
		
		for (int i=0; i < finalMatrice.length;i++) {
			for(int c=0; c < finalMatrice[1].length;c++) {
				System.out.print(finalMatrice[i][c] + " ");
			}
			System.out.println();
		}
		
		System.out.printf("\nThe number of executions is: %d",(MultiplyMatricesQttInst(matriz1,matriz2)));
		
		sc.close();

	}
	
	public static float[][] MultiplyMatrices(float[][] matriz1,float[][] matriz2) {
        float[][] finalMatrice = new float[matriz1.length][matriz1[0].length];
        for(int i = 0; i < matriz1.length ;i++) {
            for (int c = 0; c < matriz1[i].length; c++) {
                finalMatrice[i][c] = matriz1[i][c] * matriz2[i][c];
            }
        }
        return finalMatrice;
    }

	
	public static int MultiplyMatricesQttInst(float[][] matriz1,float[][] matriz2) {
		int inst = 0;
		float[][] finalMatrice = new float[matriz1.length][matriz1[0].length];
		inst+=1;
		for(int i = 0; i < matriz1.length ;i++) {
			inst+=1;
			for (int c = 0; c < matriz1[i].length; c++) {
				inst+=1;
				finalMatrice[i][c] = matriz1[i][c] * matriz2[i][c];
				inst+=1;
			}
		}							// cost execution
		inst += matriz1.length + 1; // matriz1.lenght == qtt times exec, but no enter on 2º for
									// +1 == qtt times exec, but no enter on 1º for
		return inst;
	}
	
}
