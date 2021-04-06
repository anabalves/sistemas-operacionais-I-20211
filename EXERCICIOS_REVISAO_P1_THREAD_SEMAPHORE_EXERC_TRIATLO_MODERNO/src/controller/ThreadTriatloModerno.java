package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadTriatloModerno extends Thread {

	private int idAtleta;
	private Semaphore semaforoArmasDeTiro;
	private Semaphore semaforoColocacao;
	private static int posicao = 0;
	private static int[][] colocacao = new int[25][2];
	private int pontuacaoTiroAoAlvo = 0;

	public ThreadTriatloModerno(int idAtleta, Semaphore semaforoArmasDeTiro, Semaphore semaforoColocacao) {
		this.idAtleta = idAtleta;
		this.semaforoArmasDeTiro = semaforoArmasDeTiro;
		this.semaforoColocacao = semaforoColocacao;
	}

	@Override
	public void run() {
		corrida();
//		---------------------- Inicio Seção Critica ----------------------
		try {
			semaforoArmasDeTiro.acquire();
			tiroAoAlvo();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforoArmasDeTiro.release();
		}
//		---------------------- Fim Seção Critica ----------------------	
		ciclismo();
//		---------------------- Inicio Seção Critica ----------------------
		try {
			semaforoColocacao.acquire();
			contabilizarPontuacao();
			if (posicao == 25) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n********************** TODOS OS ATLETAS TERMINARAM! **********************\n");
				ranking();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforoColocacao.release();
		}
//		---------------------- Fim Seção Critica ----------------------	
	}

	private void corrida() {
		System.out.println("\n  ***** CORRIDA ***** => O atleta " + idAtleta + " começou a corrida\n");

		int distanciaPercorrida = 0;

		int velocidade = getRandom(25, 20);

		System.out.println("\n  ***** CORRIDA ***** => O atleta " + idAtleta + " está correndo a " + velocidade + "m.s\n");

		while (3000 > distanciaPercorrida) {
			distanciaPercorrida += velocidade;

			try {
				sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n  ***** CORRIDA ***** => O atleta " + idAtleta + " terminou de correr\n");
	}

	private void tiroAoAlvo() {
		int tiros = 0;

		System.out.println("\n  ***** TIRO AO ALVO ***** => O atleta " + idAtleta + " começou o tiro ao alvo\n");

		while (tiros < 3) {
			try {
				pontuacaoTiroAoAlvo += getRandom(10, 0);
				int tempo = getRandom(3000, 500);
				sleep(tempo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tiros++;
		}

		System.out.println("\n  ***** TIRO AO ALVO ***** => O atleta " + idAtleta + " fez " + pontuacaoTiroAoAlvo
				+ " pontos no tiro ao alvo\n");
	}

	private void ciclismo() {
		System.out.println("\n  ***** CICLISMO ***** => O atleta " + idAtleta + " começou a pedalar\n");

		int distanciaPercorrida = 0;

		int velocidade = getRandom(40, 30);
		
		System.out.println("\n  ***** CICLISMO ***** => O atleta " + idAtleta + " está pedalando a " + velocidade + "m.s\n");

		while (5000 > distanciaPercorrida) {
			distanciaPercorrida += velocidade;
			try {
				sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n ***** CICLISMO ***** => O atleta " + idAtleta + " terminou de pedalar\n");
	}

	private void contabilizarPontuacao() {
		int pontosTotais = 250;
		for (int i = 0; i < 25; i++) {
			if (i == posicao) {
				colocacao[i][0] = idAtleta;
				colocacao[i][1] = pontosTotais + pontuacaoTiroAoAlvo;
				System.out.println("\n ***** PONTUAÇÃO PARCIAL ***** => O atleta " + idAtleta + " Chegou em " + (posicao + 1)
						+ "° e ficou com a pontuação de chegada de " + pontosTotais + " pontos. Aguarde o placar final!!!\n");
			}
			pontosTotais -= 10;
		}
		posicao = posicao + 1;
	}

	private void ranking() {
		for (int i = 0; i < 25; i++) {
			for (int j = i + 1; j < 25; j++) {
				if (colocacao[i][1] < colocacao[j][1]) {
					int[][] aux = colocacao;
					colocacao[i][0] = colocacao[j][0];
					colocacao[i][1] = colocacao[j][1];
					colocacao[j][0] = aux[i][0];
					colocacao[j][1] = aux[i][1];
				}
			}
		}

		System.out.println("*************************************************************");
		System.out.println("********************** PONTUAÇÃO FINAL **********************");
		System.out.println("*************************************************************");
		for (int i = 0; i < 25; i++) {
			System.out.println("\n" + (i + 1) + "º posição | Atleta: " + colocacao[i][0] + " | Pontuação: " + colocacao[i][1]);
		}

	}

	public static int getRandom(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}

}
