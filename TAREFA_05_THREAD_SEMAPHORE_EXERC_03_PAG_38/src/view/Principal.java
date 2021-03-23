package view;

import java.util.concurrent.Semaphore;

import controller.ThreadFormula1;

public class Principal {

	public static void main(String[] args) {

		int permissoesPista = 5;
		Semaphore semaforoPista = new Semaphore(permissoesPista);
		
		for (int numeroEquipe = 1; numeroEquipe <= 7; numeroEquipe++) {
            ThreadFormula1 threadFormula1 = new ThreadFormula1(numeroEquipe, semaforoPista);
            threadFormula1.start();
        }
	}
}