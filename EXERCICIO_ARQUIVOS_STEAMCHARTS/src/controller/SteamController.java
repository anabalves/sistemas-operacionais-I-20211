package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class SteamController implements ISteamController {

	private static final String ARQ_STEAM = "C:\\temp\\SteamCharts.csv";

	public SteamController() {
		super();
	}

	@Override
	public void filtraConsole(int op1Ano, String op1Mes, Double op1MediaJogadoresAtivos) throws IOException {
		File arq = new File(ARQ_STEAM);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			List<List<String>> rows = new ArrayList<>();
			List<String> headers = Arrays.asList("Código", "Nome do jogo", "Média de jogadores ativos");
			rows.add(headers);
			int contador = 0;
			while (linha != null) {
				String[] FiltraConsole = linha.split(",");
				if (FiltraConsole[1].contains(Integer.toString(op1Ano)) && FiltraConsole[2].equalsIgnoreCase(op1Mes)
						&& Double.parseDouble(FiltraConsole[3]) >= op1MediaJogadoresAtivos) {
					contador++;
					String codigo = Integer.toString(contador);
					rows.add(Arrays.asList(codigo, FiltraConsole[0], FiltraConsole[3]));
				}
				linha = buffer.readLine();
			}
			System.out.println(formatAsTable(rows));
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void filtraArquivo(String op2Dir, String op2NomeArquivo, int op2Ano, String op2Mes) throws IOException {
		File arq = new File(ARQ_STEAM);
		if (arq.exists() && arq.isFile()) {
			String conteudo = geraConteudo(op2Ano, op2Mes);
			File dir = new File(op2Dir);
			if (dir.exists() && dir.isDirectory()) {
				File newArq = new File(op2Dir, op2NomeArquivo + ".csv");
				if (!newArq.exists()) {
					geraArquivo(conteudo, newArq);
				} else {
					throw new IOException("Arquivo já existente");
				}
			} else {
				throw new IOException("Diretório inválido");
			}
		} else {
			throw new IOException("Arquivo não encontrado");
		}
	}

	private void geraArquivo(String conteudo, File newArq) throws IOException {
		FileWriter fileWriter = new FileWriter(newArq, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.write(conteudo);
		printWriter.flush();
		printWriter.close();
		fileWriter.close();
		JOptionPane.showMessageDialog(null,
				"Arquivo .csv salvo com sucesso!");
	}

	private String geraConteudo(int op2Ano, String op2Mes) throws IOException {
		String salvar = "Código;Nome do jogo;Média de jogadores ativos\n";
		File arq = new File(ARQ_STEAM);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			int contador = 0;
			while (linha != null) {
				String[] FiltraConsole = linha.split(",");
				if (FiltraConsole[1].contains(Integer.toString(op2Ano)) && FiltraConsole[2].equalsIgnoreCase(op2Mes)) {
					contador++;
					String codigo = Integer.toString(contador);
					salvar += codigo + ";" + FiltraConsole[0] + ";" + FiltraConsole[3] + "\n";
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		return salvar;
	}

	public static String formatAsTable(List<List<String>> rows) {
		int[] maxLengths = new int[rows.get(0).size()];
		for (List<String> row : rows) {
			for (int i = 0; i < row.size(); i++) {
				maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
			}
		}

		StringBuilder formatBuilder = new StringBuilder();
		for (int maxLength : maxLengths) {
			formatBuilder.append("%-").append(maxLength + 2).append("s");
		}
		String format = formatBuilder.toString();

		StringBuilder result = new StringBuilder();
		for (List<String> row : rows) {
			result.append(String.format(format, row.toArray(new String[0]))).append("\n");
		}
		return result.toString();
	}

}