package controller;

import java.util.Random;

public class ThreadCassino extends Thread {

	private int idCompetidor;
	private int soma;
	private static int quantidadeCompetidores = 0;
	private int pontuacao = 0;

	public ThreadCassino(int idCompetidor) {
		this.idCompetidor = idCompetidor;
	}

	@Override
	public void run() {
		while (pontuacao < 5) {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (competicao() == true) {
				System.out.println("O competidor " + idCompetidor + " tem " + (pontuacao + 1) + " ponto(s)");
				pontuacao++;
				if (pontuacao == 5) {
					ranking();
				}
			}
		} 
	}

	private boolean competicao() {
		int dado1 = getRandom(5, 1);
		int dado2 = getRandom(5, 1);
		soma = dado1 + dado2;
		if (soma == 7 || soma == 11) {
			return true;
		} else {
			return false;
		}
	}

	private void ranking() {
		quantidadeCompetidores++;
		if (quantidadeCompetidores == 1) {
			System.out.println("O competidor " + idCompetidor + " foi o " + quantidadeCompetidores + "º a conseguir 5 Pontos e ganhou o prêmio de R$ 5000,00");
		} else if (quantidadeCompetidores == 2) {
			System.out.println("O competidor " + idCompetidor + " foi o " + quantidadeCompetidores + "º a conseguir 5 Pontos e ganhou o prêmio de R$ 4000,00");
		} else if (quantidadeCompetidores == 3) {
			System.out.println("O competidor " + idCompetidor + " foi o " + quantidadeCompetidores + "º a conseguir 5 Pontos e ganhou o prêmio de R$ 3000,00");
		}  else if (quantidadeCompetidores > 3) {
			System.out.println("O competidor " + idCompetidor + " foi o " + quantidadeCompetidores + "º a conseguir 5 Pontos e não ganhou nenhum prêmio! ");
		}

	}
	
	public int getRandom(int maximo, int minimo) {
		Random rd = new Random();
		return rd.nextInt(maximo - minimo + 1) + minimo;
	}
}