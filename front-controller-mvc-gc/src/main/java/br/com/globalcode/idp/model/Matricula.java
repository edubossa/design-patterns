package br.com.globalcode.idp.model;

public class Matricula implements java.io.Serializable {
  private long codigoMatricula;
  private java.util.Date dataMatricula;
  private Turma turma;
  private Membership aluno;
  private long codigoTurma;
  private long codigoMembership;
  private String nomeMembership;
  public Matricula() {
    dataMatricula = new java.util.Date();
  }
  public Matricula(long codigo, java.util.Date dataMatricula, long codigoTurma, long codigoMembership) {
    this.setCodigoMatricula(codigo);
    this.setDataMatricula(dataMatricula);
    this.setCodigoTurma(codigoTurma);
    this.setCodigoMembership(codigoMembership);
  }

  public long getCodigoMatricula() {
    return codigoMatricula;
  }
  public void setCodigoMatricula(long codigoMatricula) {
    this.codigoMatricula = codigoMatricula;
  }
  public java.util.Date getDataMatricula() {
    return dataMatricula;
  }
  public void setDataMatricula(java.util.Date dataMatricula) {
    this.dataMatricula = dataMatricula;
  }
  public Turma getTurma() {
    return turma;
  }
  public void setTurma(Turma turma) {
    this.turma = turma;
  }
  public Membership getAluno() {
    return aluno;
  }
  public void setAluno(Membership aluno) {
    this.aluno = aluno;
  }
  public long getCodigoTurma() {
    return codigoTurma;
  }
  public void setCodigoTurma(long codigoTurma) {
    this.codigoTurma = codigoTurma;
  }
  public long getCodigoMembership() {
    return codigoMembership;
  }
  public void setCodigoMembership(long codigoMembership) {
    this.codigoMembership = codigoMembership;
  }
  public String getNomeMembership() {
    if(aluno!=null) return this.aluno.getNome();
    else return "";
  }

}