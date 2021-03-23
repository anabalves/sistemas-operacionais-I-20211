package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadFormula1 extends Thread {

	private int idCarro;
	private int numeroEquipe;
	private Semaphore semaforoCarrosPista;
	private int menorTempo;
	private static int quantidadeCarrosTerminaram;
	private static int equipes[][] = new int[14][3];

	public ThreadFormula1(int numeroEquipe, Semaphore semaforoCarrosPista) {
		this.numeroEquipe = numeroEquipe;
		this.semaforoCarrosPista = semaforoCarrosPista;
	}

	@Override
	public void run() {
		for (idCarro = 1; idCarro <= 2; idCarro++) {
//			---------------------- Inicio Seção Critica ----------------------
			try {
				semaforoCarrosPista.acquire();
				corridaPista(idCarro);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoCarrosPista.release();
			}
//			---------------------- Fim Seção Critica ----------------------	
			contabilizarMenorTempo();
		}

		if (quantidadeCarrosTerminaram == 14) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("********************** TODOS AS EQUIPES TERMINARAM! **********************");
			System.out.println();
			ranking();
		}

	}

	public void corridaPista(int idCarro) {
		menorTempo = 99999;
		System.out.println("O carro " + idCarro + " da equipe " + numeroEquipe + " entrou na pista");
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 3; i++) {
			int tempo = getRandomTempo(2000, 500);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 1) {
				menorTempo = tempo;
			} else {
				if (tempo < menorTempo) {
					menorTempo = tempo;
				}
			}
			System.out.println("O carro " + idCarro + " da equipe " + numeroEquipe + " deu a " + i
					+ "º volta na pista em " + tempo + "ms.");
		}
		System.out.println("O carro " + idCarro + " da equipe " + numeroEquipe
				+ " terminou suas 3 voltas e saiu da pista, seu melhor tempo foi de " + menorTempo);
	}

	private void contabilizarMenorTempo() {
		equipes[quantidadeCarrosTerminaram][0] = idCarro;
		equipes[quantidadeCarrosTerminaram][1] = numeroEquipe;
		equipes[quantidadeCarrosTerminaram][2] = menorTempo;
		quantidadeCarrosTerminaram++;
	}

	private void ranking() {
		int auxIdCarro;
		int auxnumeroEquipe;
		int auxTempos;

		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 12; j++) {
				if (equipes[i][2] < equipes[j][2]) {
					auxIdCarro = equipes[i][0];
					auxnumeroEquipe = equipes[i][1];
					auxTempos = equipes[i][2];

					equipes[i][0] = equipes[j][0];
					equipes[i][1] = equipes[j][1];
					equipes[i][2] = equipes[j][2];

					equipes[j][0] = auxIdCarro;
					equipes[j][1] = auxnumeroEquipe;
					equipes[j][2] = auxTempos;
				}
			}
		}

		System.out.println("*************************************************************");
		System.out.println("********************** GRID DE LARGADA **********************");
		System.out.println("*************************************************************");
		for (int i = 0; i <= 13; i++) {
			System.out.println("\n" + (i + 1) + "º posição | Carro: " + equipes[i][0] + " | Equipe: " + equipes[i][1]
					+ " | Melhor tempo: " + equipes[i][2] + "ms.");
		}
	}

	public static int getRandomTempo(int maximo, int minimo) {
		Random rd = new Random();
		int tempo = rd.nextInt(maximo);
		while (tempo < minimo) {
			tempo = rd.nextInt(maximo);
		}
		return tempo;
	}

}
