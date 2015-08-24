package br.com.globalcode.idp.model;


public class Membership implements java.io.Serializable {
  private long codigoMembership;
  private String nome;
  private String endereco;
  private java.util.Date dataInclusao;
  public Membership() {
    nome = "";
    endereco = "";
    dataInclusao = new java.util.Date();
    //dataInclusao = new java.util.Date();
  }
  public Membership(long codigo, String nome) {
    this(codigo, nome, null);
  }
  public Membership(long codigo, String nome, String endereco) {
    setCodigoMembership(codigo);
    setNome(nome);
    setEndereco(endereco);
  }

  public Membership(long codigo, String nome, String endereco, java.util.Date dataInc) {
    setCodigoMembership(codigo);
    setNome(nome);
    setEndereco(endereco);
    setDataInclusao(dataInc);
  }
  public long getCodigoMembership() {
    return codigoMembership;
  }
  public void setCodigoMembership(long codigoMembership) {
    this.codigoMembership = codigoMembership;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getEndereco() {
    return endereco;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
  public java.util.Date getDataInclusao() {
    return dataInclusao;
  }
  public void setDataInclusao(java.util.Date dataInclusao) {
    this.dataInclusao = dataInclusao;
  }

}