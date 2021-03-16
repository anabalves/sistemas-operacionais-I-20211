package view;

import java.util.concurrent.Semaphore;

import controller.ThreadOvercooked;

public class Principal {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		String nomePrato = "";
	    int calcSegIni = 0;
	    int calcSegFim = 0;

		for (int idPrato = 1; idPrato < 6; idPrato++) {
			if (idPrato % 2 == 0) {
				nomePrato = "Lasanha a Bolanhesa";
				calcSegIni = 600;
				calcSegFim = 1200;
			} else {
				nomePrato = "Sopa de Cebola";
				calcSegIni = 500;
				calcSegFim = 800;
			}
			
			ThreadOvercooked threadOvercooked = new ThreadOvercooked(idPrato, semaforo, nomePrato, calcSegIni, calcSegFim);
			threadOvercooked.start();
		}

	}

}
