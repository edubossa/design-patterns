package br.com.globalcode.idp.dao;

import br.com.globalcode.idp.exception.DeleteCascadeException;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Turma;
import br.com.globalcode.idp.model.Curso;
import br.com.globalcode.idp.util.Debug;
import br.com.globalcode.idp.util.FormatHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO extends BaseDAO {

    private static TurmaDAO instance = new TurmaDAO();

    private TurmaDAO() {
    }

    public static TurmaDAO getInstance() {
        return instance;
    }

    public Turma getTurma(long codigo) throws GlobalcodeException {
        Turma retorno = null;
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            String sql = "select codigo_turma, turmas.codigo_curso, data_inicio, data_termino, numero_vagas, turmas.descricao, periodo, cursos.apelido, cursos.nome from turmas, cursos where turmas.codigo_curso=cursos.codigo_curso and codigo_turma=" + codigo;
            Debug.log("Recuperando entidade turma do banco: " + sql, 5);
            rs = st.executeQuery(sql);
            if (rs.next()) {
                retorno = new Turma(rs.getLong("codigo_turma"),
                        rs.getString("turmas.descricao"),
                        rs.getString("periodo"), rs.getDate("data_inicio"),
                        rs.getDate("data_termino"),
                        rs.getInt("numero_vagas"));
                retorno.setCurso(new Curso(rs.getLong("turmas.codigo_curso"), rs.getString("cursos.nome"), rs.getString("cursos.apelido")));
            }
            rs.close();
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
        return retorno;
    }
    
public void delete(Turma turma) throws GlobalcodeException {
    Connection conn = getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      st = conn.createStatement();

      rs = st.executeQuery("select codigo_turma from matriculas where codigo_turma=" + turma.getCodigoTurma());
      if(rs.next()) {
        throw new DeleteCascadeException("Turma n�o pode ser excluido pois ainda possui matriculas no sistema.");
      }
      rs.close();

      String sql = null;
      sql = "delete from turmas " +
            " where codigo_turma=" + turma.getCodigoTurma();
      Debug.log(sql, 7);
      st.executeUpdate(sql);
    }
    catch (SQLException e) {
      throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
    }
    finally {
      closeResources(conn, st, null);
    }
  }

  public void save(Turma turma) throws GlobalcodeException {
    Connection conn = getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      st = conn.createStatement();
      String sql = null;
      //Checando se � um novo curso...
      if(turma.getCodigoTurma()==0) {
        //long novoCodigo = this.getAutoIncrement("turmas", "codigo_turma");
        //turma.setCodigoTurma(novoCodigo);
        sql = "insert into turmas " +
            "(codigo_curso, descricao, periodo, " +
            "data_inicio, data_termino, numero_vagas) " +
            " values (" + 
            turma.getCurso().getCodigoCurso() + ", " +
            "'" + turma.getDescricao() + "', " +
            "'" + turma.getPeriodo() + "', " +
            "'" + FormatHelper.getInstance().databaseDateFormat(turma.getDataInicio()) + "', " +
            "'" + FormatHelper.getInstance().databaseDateFormat(turma.getDataTermino()) + "', " +
            turma.getNumeroVagas() + ")";

        Debug.log(sql, 7);
      }
      else {
        sql = "update turmas set " +
            "codigo_curso=" + turma.getCurso().getCodigoCurso() + ", " +
            "descricao='" + turma.getDescricao() + "', " +
            "periodo='" + turma.getPeriodo() + "', " +
            "data_inicio='" + FormatHelper.getInstance().databaseDateFormat(turma.getDataInicio()) + "', " +
            "data_termino='" + FormatHelper.getInstance().databaseDateFormat(turma.getDataTermino()) + "', " +
            "numero_vagas=" + turma.getNumeroVagas() +
            " where codigo_turma=" + turma.getCodigoTurma();
        Debug.log(sql, 7);
      }
      st.executeUpdate(sql);
    }
    catch (SQLException e) {
      throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
    }
    finally {
      closeResources(conn, st, rs);
    }
  }

  public Turma[] getTurmas(boolean lite) throws GlobalcodeException {
    List<Turma> turmas = new ArrayList<Turma>();
    Connection conn = getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      st = conn.createStatement();
      rs = st.executeQuery(lite ?
          "select codigo_turma, turmas.codigo_curso, data_inicio, turmas.descricao, periodo, cursos.nome, cursos.apelido from turmas, cursos where turmas.codigo_curso=cursos.codigo_curso order by data_inicio" :
          "select codigo_turma, turmas.codigo_curso, data_inicio, data_termino, numero_vagas, turmas.descricao, periodo, cursos.nome, cursos.apelido from turmas, cursos where turmas.codigo_curso=cursos.codigo_curso order by data_inicio");
      Turma tempObject;
      while (rs.next()) {
        if (lite)
          tempObject = new Turma(rs.getLong("codigo_turma"), rs.getString("turmas.descricao"),
                                 rs.getString("periodo"), rs.getDate("data_inicio"));

        else
          tempObject = new Turma(rs.getLong("codigo_turma"), rs.getString("turmas.descricao"),
                                 rs.getString("periodo"), rs.getDate("data_inicio"),
                                 rs.getDate("data_termino"), rs.getInt("numero_vagas"));
        //tempObject.setCurso(CursosDAO.getInstance().getCurso(rs.getLong("codigo_curso")));
        tempObject.setCurso(new Curso(rs.getLong("turmas.codigo_curso"), rs.getString("cursos.nome"),rs.getString("cursos.apelido")));
        turmas.add(tempObject);
      }
    }
    catch (SQLException e) {
      throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
    }
    finally {
      closeResources(conn, st, rs);
    }
    return turmas.toArray(new Turma[0]);
  }
  
}
