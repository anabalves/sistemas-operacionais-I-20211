package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCavaleiros;

public class Principal {

	public static void main(String[] args) {
		
		int permissoesPorta = 1;
		Semaphore semaforoPorta = new Semaphore(permissoesPorta); 
		
		int permissoesPedra = 1;
		Semaphore semaforoPedra = new Semaphore(permissoesPedra); 
		
		int permissoesTocha = 1;
		Semaphore semaforoTocha = new Semaphore(permissoesTocha); 
		
		for (int idCavaleiro = 1; idCavaleiro <= 4; idCavaleiro++) {   
			ThreadCavaleiros threadCavaleiros = new ThreadCavaleiros(idCavaleiro, semaforoPorta, semaforoPedra, semaforoTocha);
			threadCavaleiros.start();
		}

	}

}
