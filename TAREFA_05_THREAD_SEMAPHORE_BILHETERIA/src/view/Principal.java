package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBilheteria;

public class Principal {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		int quantidadeIngressos;

		for (int idPessoa = 0; idPessoa < 300; idPessoa++) {
			quantidadeIngressos = (int) ((Math.random() * 4) + 1);
			ThreadBilheteria threadBilheteria = new ThreadBilheteria(idPessoa, quantidadeIngressos, semaforo);
			threadBilheteria.start();
		}

	}

}
