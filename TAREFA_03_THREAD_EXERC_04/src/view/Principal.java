package view;

import controller.SapoThread;

public class Principal {
	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			SapoThread sapoThread = new SapoThread(i);
			sapoThread.start();
		}
		System.out.println("Corrida de Sapos Iniciada");

	}
}
