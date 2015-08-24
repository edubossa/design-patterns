package br.com.ews.design.facade;

import java.sql.Connection;

public class MySQLHelper {
	
	public static Connection getMySQLDBConnection() {
		return null;
	}
	
	public void generateMySQLPDFReport(String tableName, Connection conn) {
		System.out.println("MySQLHelper#generateMySQLPDFReport");
	}
	
	public void generateMySQLHTMLReport(String tableName, Connection conn) {
		System.out.println("MySQLHelper#generateMySQLHTMLReport");
	}
	
}
