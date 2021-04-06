package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

	private int idAviao;
	private Semaphore semaforoPistaSul;
	private Semaphore semaforoPistaNorte;
	private String pista = "";

	public ThreadAeroporto(int idAviao, Semaphore semaforoPistaSul, Semaphore semaforoPistaNorte) {
		this.idAviao = idAviao;
		this.semaforoPistaSul = semaforoPistaSul;
		this.semaforoPistaNorte = semaforoPistaNorte;
	}

	@Override
	public void run() {
//		---------------------- Inicio Seção Critica ----------------------
		try {
			if (idAviao % 2 == 0) {
				System.out.println(
						"A aeronave " + idAviao + " acaba de começar o procedimento de decolagem na pista Sul");
				pista  = "Pista Sul";
				semaforoPistaSul.acquire();
				procedimentosDeDecolagem();
			} else {
				System.out.println(
						"A aeronave " + idAviao + " acaba de começar o procedimento de decolagem na pista Norte");
				pista = "Pista Norte";
				semaforoPistaNorte.acquire();
				procedimentosDeDecolagem();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoPistaSul.release();
			semaforoPistaNorte.release();
		}
//		---------------------- Fim Seção Critica ----------------------		
	}

	private void procedimentosDeDecolagem() {
		manobrar();
		taxiar();
		decolar();
		afastarDaArea();
	}

	private void manobrar() {
		System.out.println("A aeronave " + idAviao + " está manobrando na " + pista);
		int tempo = getRandomTempo(7000, 3000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de manobrar na " + pista + " depois de " + (tempo / 1000) + " segundos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	private void taxiar() {
        System.out.println("A aeronave " + idAviao + " está taxiando na " + pista);
		int tempo = getRandomTempo(10000, 5000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de taxiar na " + pista + " depois de " + (tempo / 1000) + " segundos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	private void decolar() {
        System.out.println("A aeronave " + idAviao + " está decolando na " + pista);
		int tempo = getRandomTempo(4000, 1000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de decolar na " + pista + " depois de " + (tempo / 1000) + " segundos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	private void afastarDaArea() {
        System.out.println("A aeronave " + idAviao + " está se afastando da área na " + pista);
		int tempo = getRandomTempo(8000, 3000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de se afastar da área na " + pista + " depois de " + (tempo / 1000) + " segundos!" + " A pista está liberada para a próxima Aeronave!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	public static int getRandomTempo(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}
}
