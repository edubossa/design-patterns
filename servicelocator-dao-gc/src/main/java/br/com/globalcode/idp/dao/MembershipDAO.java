package br.com.globalcode.idp.dao;

import br.com.globalcode.idp.exception.DeleteCascadeException;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Membership;
import br.com.globalcode.idp.util.Debug;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembershipDAO extends BaseDAO {

    private static MembershipDAO instance = new MembershipDAO();

    private MembershipDAO() {
    }

    public static MembershipDAO getInstance() {
        return instance;
    }

    public Membership[] getMemberships(boolean lite) throws GlobalcodeException {
        List<Membership> alunos = new ArrayList<Membership>();
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(lite ? "select codigo_membership, nome from memberships order by nome" : "select codigo_membership, nome, endereco, data_inclusao from memberships order by nome");
            Membership tempObject;
            while (rs.next()) {
                if (lite) {
                    tempObject = new Membership(rs.getLong("codigo_membership"), rs.getString("nome"));
                } else {
                    tempObject = new Membership(rs.getLong("codigo_membership"), rs.getString("nome"),
                            rs.getString("endereco"), rs.getTimestamp("data_inclusao"));
                }
                alunos.add(tempObject);
            }
            rs.close();
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
        return alunos.toArray(new Membership[0]);
    }

    public Membership getMembership(long codigo, boolean lite) throws GlobalcodeException {
        Membership retorno = null;
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            String sql;
            if (lite) {
                sql = "select codigo_membership, nome from memberships where codigo_membership=" + codigo;
            } else {
                sql = "select codigo_membership, nome, endereco, data_inclusao from memberships where codigo_membership=" + codigo;
            }
            Debug.log("Recuperando entidade membership do banco: " + sql, 5);
            rs = st.executeQuery(sql);
            if (rs.next()) {
                if (lite) {
                    retorno = new Membership(rs.getInt("codigo_membership"),
                            rs.getString("nome"));
                } else {
                    retorno = new Membership(rs.getInt("codigo_membership"),
                            rs.getString("nome"),
                            rs.getString("endereco"),
                            rs.getTimestamp("data_inclusao"));
                }
            }
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
        return retorno;
    }

    public void delete(Membership membership) throws GlobalcodeException {
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select codigo_membership from matriculas where codigo_membership=" + membership.getCodigoMembership());
            if (rs.next()) {
                throw new DeleteCascadeException("Membership n�o pode ser excluido pois ainda possui matriculas no sistema.");
            }
            rs.close();
            String sql = null;
            sql = "delete from memberships " +
                    " where codigo_membership=" + membership.getCodigoMembership();
            Debug.log(sql, 7);
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
    }

    public void save(Membership membership) throws GlobalcodeException {
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql = null;
            //Checando se � um novo curso...
            if (membership.getCodigoMembership() == 0) {
                //long novoCodigo = this.getAutoIncrement("memberships", "codigo_membership");
                //membership.setCodigoMembership(novoCodigo);
                sql = "insert into memberships " +
                        "(nome, endereco, data_inclusao) " +
                        " values (" +
                        "'" + membership.getNome() + "', " +
                        "'" + membership.getEndereco() + "', " +
                        "NOW()) ";

                Debug.log(sql, 7);
            } else {
                sql = "update memberships set " +
                        "nome='" + membership.getNome() + "', " +
                        "endereco='" + membership.getEndereco() + "' " +
                        " where codigo_membership=" + membership.getCodigoMembership();
                Debug.log(sql, 7);
            }
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
    }
}
