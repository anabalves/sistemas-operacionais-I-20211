package view;

import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {

		OperacoesController op = new OperacoesController();
		op.percorreVetor1000();
		op.percorreVetor10000();
		op.percorreVetor100000();
	}

}
