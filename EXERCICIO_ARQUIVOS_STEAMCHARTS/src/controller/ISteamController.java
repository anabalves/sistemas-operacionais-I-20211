package controller;

import java.io.IOException;

public interface ISteamController {

	public void filtraConsole(String path, String nome, int op1Ano, String op1Mes, Double op1MediaJogadoresAtivos) throws IOException;
	public void filtraArquivo(String op2Dir, String op2NomeArquivo, int op2Ano, String op2Mes) throws IOException;

}