package br.com.ews.design.facade;

import java.sql.Connection;

public class OracleHelper {
	
	public static Connection getOracleDBConnection() {
		return null;
	}
	
	public void generateOraclePDFReport(String tableName, Connection conn) {
		System.out.println("MySQLHelper#generateOraclePDFReport");
	}
	
	public void generateOracleHTMLReport(String tableName, Connection conn) {
		System.out.println("MySQLHelper#generateOracleHTMLReport");
	}
	
}
