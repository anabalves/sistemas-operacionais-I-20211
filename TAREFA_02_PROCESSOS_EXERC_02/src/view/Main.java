package view;

import javax.swing.JOptionPane;

import controller.ProcessosController;

public class Main {

	public static void main(String[] args) {
		
		ProcessosController processosController = new ProcessosController();

		int opc = 0;
		int processoPID = 0;
		String processoNome;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de uma das opções\n "
					+ "1- Listar processos ativos\n "
					+ "2- Matar processo por nome\n "
					+ "3- Matar processo por PID\n "
					+ "9- Finalizar Programa!", JOptionPane.QUESTION_MESSAGE));
			
				switch (opc) {
				case 1:
					JOptionPane.showMessageDialog(null, "Os processos ativos serão listados no console", "Sucess", JOptionPane.INFORMATION_MESSAGE);
					processosController.listarProcessos(processosController.getOS());
					break;
				case 2:
					processoNome = JOptionPane.showInputDialog("Digite o nome do processo que deseja encerrar: \nexemplo: cmd.exe", JOptionPane.QUESTION_MESSAGE);
					JOptionPane.showMessageDialog(null, processosController.matarProcessoPorNome(processosController.getOS(), processoNome), "Sucess", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 3:
					processoPID = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo que deseja encerrar: \nexemplo: 36036", JOptionPane.QUESTION_MESSAGE));
					JOptionPane.showMessageDialog(null, processosController.matarProcessoPorPID(processosController.getOS(), processoPID), "Sucess", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "O programa foi finalizado!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}

		} while (opc != 9);
	}
}
