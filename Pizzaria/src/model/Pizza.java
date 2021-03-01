package model;

public class Pizza {

	private String nome;
	private String modificacoes;
	private double preco;
	private String tipo;
	private boolean bordaRecheada;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModificacoes() {
		return modificacoes;
	}
	public void setModificacoes(String modificacoes) {
		this.modificacoes = modificacoes;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isBordaRecheada() {
		return bordaRecheada;
	}
	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}
	
}
