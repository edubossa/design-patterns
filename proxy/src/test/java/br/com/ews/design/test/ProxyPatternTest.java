package br.com.ews.design.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import br.com.ews.design.proxy.CommandExecutor;
import br.com.ews.design.proxy.CommandExecutorProxy;

public class ProxyPatternTest {

	@Test
	public void testAdmin() {
		try {
			
			CommandExecutor executor = new CommandExecutorProxy("edubossa", "123456");
			executor.runCommand("free -m");

		} catch(Exception e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testUser() {
		try {
			
			CommandExecutor executor = new CommandExecutorProxy("joao", "123456");
			executor.runCommand("rm");
			
		} catch(Exception e) {			
			fail(e.getMessage());
		}
	}

}
