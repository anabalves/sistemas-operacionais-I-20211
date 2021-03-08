package view;

import controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {

		int[] vetor = new int[1000];

		for (int i = 0; i < 1000; i++) {
			vetor[i] = getRandomNumber();
		}
		
	    for(int num = 1; num <= 2; num++) {
	    	Thread threadVetor = new ThreadVetor(vetor, num);
	    	threadVetor.start();
	      }
		
	}

	public static int getRandomNumber() {
		return (int) ((Math.random() * (100 - 1) + 1));
	}

}
