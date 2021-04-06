package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSJF;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idProcesso = 1; idProcesso <= 20; idProcesso++) {
			ThreadSJF threadSJF = new ThreadSJF(idProcesso, semaforo);
			threadSJF.start();
		}
	}

}
