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
//		---------------------- Inicio Se��o Critica ----------------------
		try {
			if (idAviao % 2 == 0) {
				System.out.println(
						"A aeronave " + idAviao + " acaba de come�ar o procedimento de decolagem na pista Sul");
				pista  = "Pista Sul";
				semaforoPistaSul.acquire();
				procedimentosDeDecolagem();
			} else {
				System.out.println(
						"A aeronave " + idAviao + " acaba de come�ar o procedimento de decolagem na pista Norte");
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
//		---------------------- Fim Se��o Critica ----------------------		
	}

	private void procedimentosDeDecolagem() {
		manobrar();
		taxiar();
		decolar();
		afastarDaArea();
	}

	private void manobrar() {
		System.out.println("A aeronave " + idAviao + " est� manobrando na " + pista);
		int tempo = getRandomTempo(7000, 3000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de manobrar na " + pista + " depois de " + (tempo / 1000) + " segundos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	private void taxiar() {
        System.out.println("A aeronave " + idAviao + " est� taxiando na " + pista);
		int tempo = getRandomTempo(10000, 5000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de taxiar na " + pista + " depois de " + (tempo / 1000) + " segundos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	private void decolar() {
        System.out.println("A aeronave " + idAviao + " est� decolando na " + pista);
		int tempo = getRandomTempo(4000, 1000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de decolar na " + pista + " depois de " + (tempo / 1000) + " segundos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	private void afastarDaArea() {
        System.out.println("A aeronave " + idAviao + " est� se afastando da �rea na " + pista);
		int tempo = getRandomTempo(8000, 3000);
        try {
            sleep(tempo);
            System.out.println("A aeronave " + idAviao + " acabou de se afastar da �rea na " + pista + " depois de " + (tempo / 1000) + " segundos!" + " A pista est� liberada para a pr�xima Aeronave!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	public static int getRandomTempo(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}
}
