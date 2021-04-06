package controller;

import java.util.concurrent.Semaphore;

import view.Principal;

public class ThreadJoKenPo extends Thread {

	private String integranteTimeA;
	private String integranteTimeB;
	private Semaphore pontuacao;
	private int pontosIntegranteTimeA = 0;
	private int pontosIntegranteTimeB = 0;

	public ThreadJoKenPo(String integranteTimeA, String integranteTimeB, Semaphore pontuacao) {
		this.integranteTimeA = integranteTimeA;
		this.integranteTimeB = integranteTimeB;
		this.pontuacao = pontuacao;
	}

	@Override
	public void run() {
		duelar();
//		---------------------- Inicio Seção Critica ----------------------
		try {
			pontuacao.acquire();
			pontuacao();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pontuacao.release();
		}
//		---------------------- Fim Seção Critica ----------------------		
	}

	private void duelar() {
		int jogadaTimeA = 0;
		int jogadaTimeB = 0;
		String[] jogadas = { "Pedra", "Papel", "Tesoura" };

		try {
			sleep(1000);
			while (pontosIntegranteTimeA < 3 && pontosIntegranteTimeB < 3) {

				jogadaTimeA = (int) ((Math.random() * 3) + 1);
				jogadaTimeB = (int) ((Math.random() * 3) + 1);

				if (jogadaTimeA == jogadaTimeB) {
					System.out.println("O jogador " + integranteTimeA + " jogou " + jogadas[jogadaTimeA - 1]
							+ " e o jogador " + integranteTimeB + " jogou " + jogadas[jogadaTimeB - 1]);
					System.out.println("EMPATE entre " + integranteTimeA + " e " + integranteTimeB);
				} else if ((jogadaTimeA == 1 && jogadaTimeB == 3) || (jogadaTimeA == 2 && jogadaTimeB == 1)
						|| (jogadaTimeA == 3 && jogadaTimeB == 2)) {
					System.out.println("O jogador " + integranteTimeA + " jogou " + jogadas[jogadaTimeA - 1]
							+ " e o jogador " + integranteTimeB + " jogou " + jogadas[jogadaTimeB - 1]);
					System.out.println("O jogador " + integranteTimeA + " GANHOU o duelo com o jogador " + integranteTimeB);
					pontosIntegranteTimeA++;
				} else {
					System.out.println("O jogador " + integranteTimeA + " jogou " + jogadas[jogadaTimeA - 1]
							+ " e o jogador " + integranteTimeB + " jogou " + jogadas[jogadaTimeB - 1]);
					System.out.println("O jogador " + integranteTimeB + " GANHOU o duelo com o jogador " + integranteTimeA);
					pontosIntegranteTimeB++;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private void pontuacao() {
		Principal.PontuacaoTimeA += pontosIntegranteTimeA;
		Principal.PontuacaoTimeB += pontosIntegranteTimeB;
	}
}
