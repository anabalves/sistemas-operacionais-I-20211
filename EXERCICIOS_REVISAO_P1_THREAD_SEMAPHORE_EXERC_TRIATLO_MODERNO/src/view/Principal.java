package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTriatloModerno;

public class Principal {

	public static void main(String[] args) {
		
		int permissoesArmasDeTiro = 5;
		Semaphore semaforoArmasDeTiro =new Semaphore(permissoesArmasDeTiro);
		
		int permissoesColocacao = 1;
		Semaphore semaforoColocacao = new Semaphore(permissoesColocacao);
		
		for (int idAtleta = 1; idAtleta <= 25; idAtleta++) {
			ThreadTriatloModerno threadTriatloModerno = new ThreadTriatloModerno(idAtleta, semaforoArmasDeTiro, semaforoColocacao);
			threadTriatloModerno.start();
		}

	}

}
