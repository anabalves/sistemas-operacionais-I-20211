package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ProcessosController {
	
	private Process processo;
	private InputStream fluxo;
	private InputStreamReader leitor;
	private BufferedReader buffer;

	public ProcessosController() {
		super();
	}

	public String getOS() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void listarProcessos(String sistemaOperacional) {
		if (sistemaOperacional.contains("Windows")) {
			try {
				processo = Runtime.getRuntime().exec("tasklist");
				fluxo = processo.getInputStream();
				leitor = new InputStreamReader(fluxo);
				buffer = new BufferedReader(leitor);

				String linha = buffer.readLine();

				while (linha != null) {
					
					System.out.println(linha);

					linha = buffer.readLine();
				}
				System.out.println();
				
				fluxo.close();
				leitor.close();
				buffer.close();

			} catch (IOException e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
			}
		} else if (sistemaOperacional.contains("Linux")) {
			try {
				processo = Runtime.getRuntime().exec("ps");
				fluxo = processo.getInputStream();
				leitor = new InputStreamReader(fluxo);
				buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();

				while (linha != null) {
					
					System.out.println(linha);

					linha = buffer.readLine();
				}
				
				System.out.println();
				
				fluxo.close();
				leitor.close();
				buffer.close();
			} catch (IOException e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
			}
		} else {
			JOptionPane.showMessageDialog(null,  "Configurações de sistema não encontradas", "Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public String matarProcessoPorNome(String sistemaOperacional, String processoNome) {
		StringBuffer buffer = new StringBuffer();

		if (sistemaOperacional.contains("Windows")) {

			String cmdprocessoPID = "TASKKILL /PID";
			String cmdprocessoNome = "TASKKILL /IM";

			try {

				buffer.append(cmdprocessoNome);
				buffer.append(" ");
				buffer.append(processoNome);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdprocessoPID);
				buffer.append(" ");
				buffer.append(processoNome);
			}
			return "O processo " + processoNome + " foi encerrado com sucesso!";

		} else if (sistemaOperacional.contains("Linux")) {

			String cmdprocessoPID = "kill";
			String cmdprocessoNome = "pkill";

			try {

				buffer.append(cmdprocessoNome);
				buffer.append(" ");
				buffer.append(processoNome);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdprocessoPID);
				buffer.append(" ");
				buffer.append(processoNome);
			}
			return "O processo " + processoNome + " foi encerrado com sucesso!";
		} else {
			return "Configurações do sistema não encontradas!";
		}
	}

	public String matarProcessoPorPID(String sistemaOperacional, int processoPID) {
		
		StringBuffer buffer = new StringBuffer();

		if (sistemaOperacional.contains("Windows")) {
			
			String cmdprocessoPID = "TASKKILL /PID";
			String cmdprocessoNome = "TASKKILL /IM";

			try {
				buffer.append(cmdprocessoPID);
				buffer.append(" ");
				buffer.append(processoPID);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdprocessoNome);
				buffer.append(" ");
				buffer.append(processoPID);
			}
			return "O processo " + processoPID + " foi encerrado com sucesso!";

		} else if (sistemaOperacional.contains("Linux")) {
			
			String cmdprocessoPID = "kill";
			String cmdprocessoNome = "pkill";
			
			try {
				buffer.append(cmdprocessoPID);
				buffer.append(" ");
				buffer.append(processoPID);

				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException except) {
					except.printStackTrace();
				}

			} catch (NumberFormatException e) {
				buffer.append(cmdprocessoNome);
				buffer.append(" ");
				buffer.append(processoPID);
			}
			return "O processo " + processoPID + " foi encerrado com sucesso!";
		} else {
			return "Configurações do sistema não encontradas!";
		}
	}

}
