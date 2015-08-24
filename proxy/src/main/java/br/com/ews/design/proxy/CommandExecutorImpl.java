package br.com.ews.design.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) throws Exception {
		System.out.println("'" + cmd + "' command executed.");
		Process exec = Runtime.getRuntime().exec(cmd);
		BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
		String line = "";
		while( (line = br.readLine()) != null ) {
			System.out.println(line);
		}
	}

}
