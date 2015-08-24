package br.com.globalcode.idp.model;


public class Turma implements java.io.Serializable {
  private long codigoTurma;
  private java.util.Date dataInicio;
  private int numeroVagas;
  private Curso curso;
  private java.util.Date dataTermino;
  private Matricula[] matriculas;
  private String periodo;
  private String descricao;

  public Turma() {
    curso = new Curso();
    periodo = "";
    descricao = "";

  }

  public Turma(long codigo, String descricao, String periodo, java.util.Date dataInicio) {
    setCodigoTurma(codigo);
    setDescricao(descricao);
    setPeriodo(periodo);
    setDataInicio(dataInicio);
  }
  public Turma(long codigo, String descricao, String periodo, java.util.Date dataInicio,
               java.util.Date dataTermino, int numeroVagas) {
    this(codigo, descricao, periodo, dataInicio);
    setDataTermino(dataTermino);
    setNumeroVagas(numeroVagas);
  }

  public long getCodigoTurma() {
    return codigoTurma;
  }
  public void setCodigoTurma(long codigoTurma) {
    this.codigoTurma = codigoTurma;
  }
  public java.util.Date getDataInicio() {
    return dataInicio;
  }
  public void setDataInicio(java.util.Date dataInicio) {
    this.dataInicio = dataInicio;
  }
  public int getNumeroVagas() {
    return numeroVagas;
  }
  public void setNumeroVagas(int numeroVagas) {
    this.numeroVagas = numeroVagas;
  }
  public Curso getCurso() {
    return curso;
  }
  public void setCurso(Curso curso) {
    this.curso = curso;
  }
  public java.util.Date getDataTermino() {
    return dataTermino;
  }
  public void setDataTermino(java.util.Date dataTermino) {
    this.dataTermino = dataTermino;
  }
  public Matricula[] getMatriculas() {
    return matriculas;
  }
  public void setMatriculas(Matricula[] matriculas) {
    this.matriculas = matriculas;
  }
  public String getPeriodo() {
    return periodo;
  }
  public void setPeriodo(String periodo) {
    this.periodo = periodo;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}