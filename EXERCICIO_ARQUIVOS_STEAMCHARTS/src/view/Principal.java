package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ISteamController;
import controller.SteamController;

public class Principal {

	public static void main(String[] args) {
		ISteamController steamController = new SteamController();

		int opc = 0;

		int op1Ano;
		String op1Mes;
		Double op1MediaJogadoresAtivos;
		int op2Ano;
		String op2Mes;
		String op2Dir;
		String op2NomeArquivo;
		
		while (opc != 3) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite uma opção válida " + "\n 1- Filtrar informações por ano, mês e média (Exibir em Console) "
							+ "\n 2- Filtrar informações por ano e mês (Exibir em Arquivo) " + "\n 3- Sair",
					JOptionPane.QUESTION_MESSAGE));

			switch (opc) {

			case 1:
				op1Ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano: "));
				op1Mes = JOptionPane.showInputDialog(null, "Digite o mês: ");
				op1MediaJogadoresAtivos = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a média de jogadores: "));
				try {
					steamController.filtraConsole(op1Ano, op1Mes, op1MediaJogadoresAtivos);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				op2Ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano: "));
				op2Mes = JOptionPane.showInputDialog(null, "Digite o mês: ");
				op2Dir = JOptionPane.showInputDialog(null, "Digite um diretório válido: ");
				op2NomeArquivo = JOptionPane.showInputDialog(null, "Digite um nome de arquivo válido: ");
				try {
					steamController.filtraArquivo(op2Dir, op2NomeArquivo, op2Ano, op2Mes);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "Programa Finalizado com sucesso!", "Programa Finalizado",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida", "Opção Inválida",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

		}
	}
}
