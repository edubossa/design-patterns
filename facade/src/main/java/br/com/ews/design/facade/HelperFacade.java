package br.com.ews.design.facade;

import java.sql.Connection;

public class HelperFacade {
	
	public enum DBTypes {
		MYSQL, ORACLE;
	}
	
	public enum ReportTypes {
		HTML, PDF;
	}
	
	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName){
        Connection con = null;
        switch (dbType){
        case MYSQL: 
            con = MySQLHelper.getMySQLDBConnection();
            MySQLHelper mySqlHelper = new MySQLHelper();
            switch(reportType){
            case HTML:
                mySqlHelper.generateMySQLHTMLReport(tableName, con);
                break;
            case PDF:
                mySqlHelper.generateMySQLPDFReport(tableName, con);
                break;
            }
            break;
        case ORACLE: 
            con = OracleHelper.getOracleDBConnection();
            OracleHelper oracleHelper = new OracleHelper();
            switch(reportType){
            case HTML:
                oracleHelper.generateOracleHTMLReport(tableName, con);
                break;       
            case PDF:
                oracleHelper.generateOraclePDFReport(tableName, con);
                break;
            }
            break;
        }
         
    }
	
}
