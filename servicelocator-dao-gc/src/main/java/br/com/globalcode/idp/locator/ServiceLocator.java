package br.com.globalcode.idp.locator;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import br.com.globalcode.idp.exception.GlobalcodeException;

public class ServiceLocator {

    private final static String POOLING_NAME = "java:comp/env/jdbc/AAPooling1";
    private final static String DB_USER_NAME = "aa";
    private final static String DB_PASSWORD = "aa";
    private final static String DB_URL = "jdbc:mysql://academias:3306/aa";
    private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static InitialContext initCtx = null;
    private static ServiceLocator instance = new ServiceLocator();
    private boolean usePool = false;

    private ServiceLocator() {
    }

    public static ServiceLocator getInstance() {
        return instance;
    }

    public Connection getConnection() throws GlobalcodeException {
        if (usePool) {
            return getConnectionByPool();
        } else {
            return getConnectionManual();
        }
    }

    public Connection getConnectionManual() throws GlobalcodeException {
        Connection conn = null;
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(DB_URL, DB_USER_NAME,
                    DB_PASSWORD);
        } catch (Exception e) {
            throw new GlobalcodeException(
                    "Erro ao obter conexao via DriverManager: " 
                    + e.getMessage(), e);
        }
        return conn;
    }

    public Connection getConnectionByPool() throws GlobalcodeException {
        Connection conn = null;
        DataSource ds = null;
        try {
            if (initCtx == null) {
                initCtx = new InitialContext();
            }
            ds = (DataSource) initCtx.lookup(POOLING_NAME);
            conn = ds.getConnection();
        } catch (Exception e) {
            throw new GlobalcodeException("Erro ao obter conexao via JNDI: " 
                    + POOLING_NAME, e);
        }
        return conn;
    }
    
    public void setUsePool(boolean usePool) {
        this.usePool = usePool;
    }
}