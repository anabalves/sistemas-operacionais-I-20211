package controller;

public class ThreadSomaMatriz extends Thread {

	int [][] matriz;
	int linha;
	 
	public ThreadSomaMatriz(int[][] matriz, int linha) {
		this.matriz = matriz;
		this.linha = linha;
	}

	@Override
	public void run() {
		somaMatriz(matriz, linha);
	}

	private void somaMatriz(int[][] matriz, int linha) {
		int somaMatriz = 0;
		
		for (int coluna = 0; coluna < 5; coluna++) {
			somaMatriz = somaMatriz + matriz[linha][coluna];
		}
		
		System.out.println("Na ThreadId#" + getId() + " a soma da linha " + (linha + 1) + " da matriz é igual a " + somaMatriz);
	}
	
}
