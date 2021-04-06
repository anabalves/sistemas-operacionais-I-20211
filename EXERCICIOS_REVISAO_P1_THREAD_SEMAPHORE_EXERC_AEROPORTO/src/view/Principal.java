package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Principal {

	public static void main(String[] args) {
		
		int permissoesPistaSul = 1;
		Semaphore semaforoPistaSul = new Semaphore(permissoesPistaSul);
		
		int permissoesPistaNorte = 1;
		Semaphore semaforoPistaNorte = new Semaphore(permissoesPistaNorte);

		for (int idAviao = 1; idAviao <= 12; idAviao++) {
			ThreadAeroporto threadAeroporto = new ThreadAeroporto(idAviao, semaforoPistaSul, semaforoPistaNorte);
			threadAeroporto.start();
		}

	}

}
