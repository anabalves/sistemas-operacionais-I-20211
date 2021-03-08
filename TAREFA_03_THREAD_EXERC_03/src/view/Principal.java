package view;

import controller.ThreadSomaMatriz;

public class Principal {

	public static void main(String[] args) {
		int[][] matriz = new int[3][5];
		System.out.println("Matriz:");
	    for (int linha = 0; linha < 3; linha++) {
	        for (int coluna = 0; coluna < 5; coluna++) {
	        	matriz[linha][coluna] = getRandomNumber();
	          System.out.print(matriz[linha][coluna] + "\t");
	        }
	        System.out.println();
	      }
	    System.out.println();
	    
	    for (int linha = 0; linha < 3; linha++) {
	    	Thread threadSomaMatriz = new ThreadSomaMatriz(matriz, linha);
	    	threadSomaMatriz.start();
	      }

	}
	
	public static int getRandomNumber() {
		return (int) ((Math.random() * (100 - 1) + 1));
	}

}
