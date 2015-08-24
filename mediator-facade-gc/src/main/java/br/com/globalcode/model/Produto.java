package br.com.globalcode.model;

public class Produto {

	private int id;
	private String nome;
	private String marca;
	private double preco;

	public Produto() {
	}

	public Produto(int id, String nome, double preco, String marca) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", marca=" + marca + ", preco=" + preco + "]";
	}

}
