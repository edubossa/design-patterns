package br.com.globalcode.idp.model;

public class Curso implements java.io.Serializable {
	private String nome;
	private String descricao;
	private long codigoCurso;
	private int cargaHoraria;
	private String apelido;

	public Curso() {
		nome = "";
		descricao = "";
		apelido = "";

	}

	public Curso(long codigo, String nome, String apelido) {
		this(codigo, nome, apelido, null, 0);
	}

	public Curso(long codigo, String nome, String apelido, String descricao, int cargaHoraria) {
		setCodigoCurso(codigo);
		setNome(nome);
		setApelido(apelido);
		setDescricao(descricao);
		setCargaHoraria(cargaHoraria);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(long codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String toString() {
		return this.nome;
	}
}