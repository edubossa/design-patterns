package br.com.globalcode.idp.dao;

import br.com.globalcode.idp.exception.GlobalcodeException;
import br.com.globalcode.idp.locator.ServiceLocator;
import br.com.globalcode.idp.util.Debug;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {

    protected void closeResources(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            Debug.log("Erro ao fechar recursos. " + e.getMessage(), 7);
        }
    }

    protected Connection getConnection() throws GlobalcodeException {
        Connection conn = ServiceLocator.getInstance().getConnection();
        return conn;
    }
}
