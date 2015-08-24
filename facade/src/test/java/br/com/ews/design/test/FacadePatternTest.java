package br.com.ews.design.test;

import java.sql.Connection;

import org.junit.Test;

import br.com.ews.design.facade.HelperFacade;
import br.com.ews.design.facade.HelperFacade.DBTypes;
import br.com.ews.design.facade.HelperFacade.ReportTypes;
import br.com.ews.design.facade.MySQLHelper;
import br.com.ews.design.facade.OracleHelper;

/**
 * De acordo com o padrao de projeto GoF Facade e:
 * <p>
 * Fornecer uma interface unificada para um conjunto de interfaces em um subsistema. 
 * Facade Pattern define uma interface de nível mais elevado que faz com que o subsistema seja mais fácil de usar
 *
 */
public class FacadePatternTest {

	private String tableName = "Employee";
	
	@Test
	public void testSemUsarFacade() {
		
		System.out.println();
		System.out.println("-----------------[testSemUsarFacade]--------------------");
		
		Connection connMySQL  = MySQLHelper.getMySQLDBConnection();
		MySQLHelper mySQLHelper = new MySQLHelper();
		mySQLHelper.generateMySQLHTMLReport(tableName, connMySQL);
		
		Connection connOracle = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, connOracle);
		
	}
	
	@Test
	public void testComFacade() {

		System.out.println();
		System.out.println("-----------------[testComFacade]--------------------");
		
		HelperFacade.generateReport(DBTypes.MYSQL, ReportTypes.HTML, tableName);
		HelperFacade.generateReport(DBTypes.ORACLE, ReportTypes.PDF, tableName);	
		
	}

}
