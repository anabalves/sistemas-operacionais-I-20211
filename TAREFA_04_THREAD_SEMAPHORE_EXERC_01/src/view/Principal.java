package view;

import java.util.concurrent.Semaphore;

import controller.ThreadServidorMultiprocessamento;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
	    int calcSegIni = 0;
	    int calcSegFim = 0;
	    int tempoTransacao = 0;
	    int repeteRequisicoes = 0;

		for (int idThread = 1; idThread < 22; idThread++) {
			if (idThread % 3 == 0) {
				repeteRequisicoes = 3;
				calcSegIni = 1000;
				calcSegFim = 2000;
				tempoTransacao = 1500;
			} else if (idThread % 3 == 1) {
				repeteRequisicoes = 2;
				calcSegIni = 200;
				calcSegFim = 1000;
				tempoTransacao = 1000;
			} else if (idThread % 3 == 2) {
				repeteRequisicoes = 3;
				calcSegIni = 500;
				calcSegFim = 1500;
				tempoTransacao = 1500;
			}
			
			ThreadServidorMultiprocessamento threadServidorMultiprocessamento = new ThreadServidorMultiprocessamento(idThread, semaforo, calcSegIni, calcSegFim, repeteRequisicoes, tempoTransacao);
			threadServidorMultiprocessamento.start();
		}

	}

}
