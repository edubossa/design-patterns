package br.com.globalcode.idp.dao;

import br.com.globalcode.idp.exception.DeleteCascadeException;
import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.model.Curso;
import br.com.globalcode.idp.util.Debug;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO extends BaseDAO {

    private static CursoDAO instance = new CursoDAO();

    private CursoDAO() {
    }

    public static CursoDAO getInstance() {
        return instance;
    }

    public Curso[] getCursos(boolean lite) throws GlobalcodeException {
        List<Curso> cursos = new ArrayList<Curso>();
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(lite ? "select codigo_curso, nome, apelido from cursos order by nome" : "select codigo_curso, nome, apelido, descricao, carga_horaria from cursos order by nome");
            Curso tempObject;
            while (rs.next()) {
                if (lite) {
                    tempObject = new Curso(rs.getInt("codigo_curso"), rs.getString("nome"),
                            rs.getString("apelido"));
                } else {
                    tempObject = new Curso(rs.getInt("codigo_curso"), rs.getString("nome"),
                            rs.getString("apelido"), rs.getString("descricao"),
                            rs.getInt("carga_horaria"));
                }
                cursos.add(tempObject);
            }
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
        return cursos.toArray(new Curso[0]);
    }

    public Curso getCurso(long codigo) throws GlobalcodeException {
        Curso retorno = null;
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            String sql = "select codigo_curso, nome, apelido, descricao, carga_horaria from cursos where codigo_curso=" + codigo;
            Debug.log("Recuperando entidade curso do banco: " + sql, 5);
            rs = st.executeQuery(sql);
            if (rs.next()) {
                retorno = new Curso(rs.getInt("codigo_curso"), rs.getString("nome"),
                        rs.getString("apelido"), rs.getString("descricao"),
                        rs.getInt("carga_horaria"));
            }
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, rs);
        }
        return retorno;
    }

    public void delete(Curso curso) throws GlobalcodeException {
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select codigo_curso from turmas where codigo_curso=" + curso.getCodigoCurso());
            if (rs.next()) {
                throw new DeleteCascadeException("Curso nao pode ser excluido pois ainda possui turmas no sistema.");
            }
            rs.close();

            String sql = null;
            sql = "delete from cursos " +
                    " where codigo_curso=" + curso.getCodigoCurso();
            Debug.log(sql, 7);
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new GlobalcodeException("Erro de DAO - RDBMS: " + e.getMessage(), e);
        } finally {
            closeResources(conn, st, null);
        }
    }

    public void save(Curso curso) throws GlobalcodeException {
        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            String sql = null;
            //Checando se � um novo curso...
            if (curso.getCodigoCurso() == 0) {
                //long novoCodigo = this.getAutoIncrement("cursos", "codigo_curso");
                //curso.setCodigoCurso(novoCodigo);
                sql = "insert into cursos " +
                        "( nome, apelido, descricao, carga_horaria) " +
                        " values (" +
                        "'" + curso.getNome() + "', " +
                        "'" + curso.getApelido() + "', " +
                        "'" + curso.getDescricao() + "', " +
                        curso.getCargaHoraria() + ")";
                Debug.log(sql, 7);
            } else {
                sql = "update cursos set " +
                        "nome='" + curso.getNome() + "', " +
                        "apelido='" + curso.getApelido() + "', " +
                        "descricao='" + curso.getDescricao() + "', " +
                        "carga_horaria=" + curso.getCargaHoraria() +
                        " where codigo_curso=" + curso.getCodigoCurso();
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
