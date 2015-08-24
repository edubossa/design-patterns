package br.com.globalcode.idp.dao;

import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.exception.MatriculaDuplicadaException;
import br.com.globalcode.idp.model.Matricula;
import br.com.globalcode.idp.model.Membership;
import br.com.globalcode.idp.util.Debug;
import br.com.globalcode.idp.util.FormatHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO extends BaseDAO {

    private static MatriculaDAO instance = new MatriculaDAO();

    private MatriculaDAO() {
    }

    public static MatriculaDAO getInstance() {
        return instance;
    }

    public Matricula getMatricula(long codigoMatricula) throws GlobalcodeException {
        Matricula retorno = null;
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select codigo_matricula, matriculas.codigo_membership, data_matricula, codigo_turma, memberships.nome from matriculas, memberships where matriculas.codigo_membership=memberships.codigo_membership and codigo_matricula=" + codigoMatricula);
            if (rs.next()) {
                retorno = new Matricula(rs.getLong("codigo_matricula"), rs.getDate("data_matricula"),
                        rs.getLong("codigo_turma"), rs.getLong("codigo_membership"));
                retorno.setAluno(new Membership(rs.getLong("matriculas.codigo_membership"), rs.getString("memberships.nome")));
            }
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
        return retorno;
    }

    public void delete(Matricula matricula) throws GlobalcodeException {
        Connection conn = getConnection();
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql = null;
            sql = "delete from matriculas " +
                    " where codigo_matricula=" + matricula.getCodigoMatricula();
            Debug.log(sql, 7);
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, null);
        }
    }

    public void save(Matricula matricula) throws GlobalcodeException {
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql = null;
            if (matricula.getCodigoMatricula() == 0) {
                rs = st.executeQuery("select codigo_matricula from matriculas where codigo_membership=" + matricula.getCodigoMembership() +
                        " and codigo_turma=" + matricula.getCodigoTurma());
                if (rs.next()) {
                    throw new MatriculaDuplicadaException("Já existe uma matricula para o aluno" + matricula.getCodigoMembership());
                }
                sql = "insert into matriculas " +
                        "(codigo_turma, codigo_membership, data_matricula) " +
                        " values (" +
                        matricula.getCodigoTurma() + ", " +
                        matricula.getCodigoMembership() + ", " +
                        "'" + FormatHelper.getInstance().databaseDateFormat(matricula.getDataMatricula()) + "') ";
                Debug.log(sql, 7);
            } else {
                sql = "update matriculas set " +
                        "data_matricula='" + FormatHelper.getInstance().databaseDateFormat(matricula.getDataMatricula()) + "' " +
                        " where codigo_matricula=" + matricula.getCodigoMatricula();
                Debug.log(sql, 7);
            }
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
    }
    
  public Matricula[] getMatriculas(long codigoTurma) throws GlobalcodeException {
    List<Matricula> matriculas = new ArrayList<Matricula>();
    Connection conn = getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
      st = conn.createStatement();
      rs = st.executeQuery("select codigo_matricula, matriculas.codigo_membership, data_matricula, codigo_turma, "
      										+ "memberships.nome from matriculas, memberships where matriculas.codigo_membership=memberships.codigo_membership and codigo_turma=" + codigoTurma);
      Matricula tempObject;
      while (rs.next()) {
        tempObject = new Matricula(rs.getLong("codigo_matricula"), rs.getDate("data_matricula"),
                                   rs.getLong("codigo_turma"), rs.getLong("matriculas.codigo_membership"));
			  tempObject.setAluno(new Membership(rs.getLong("matriculas.codigo_membership"), rs.getString("memberships.nome")));
        matriculas.add(tempObject);
      }
      rs.close();
    }
    catch (SQLException e) {
      throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
    }
    finally {
      closeResources(conn, st, rs);
    }

    return matriculas.toArray(new Matricula[0]);
  }
    
}
