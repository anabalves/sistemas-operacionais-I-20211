package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idCarro = 1; idCarro < 5; idCarro++) {
			ThreadCruzamento threadCruzamento = new ThreadCruzamento(idCarro, semaforo);
			threadCruzamento.start();
		}

	}

}
