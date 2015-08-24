package br.com.ews.design.proxy;

/**
 * Now we want to provide only admin users to have full access of above class, 
 * if the user is not admin then only limited commands will be allowed. 
 * Here is our very simple proxy class implementation.
 */
public class CommandExecutorProxy implements CommandExecutor {
	
	private boolean isAdmin;
	private CommandExecutor executor;
	
	public CommandExecutorProxy(String user, String pwd) {
		if("edubossa".equals(user) && "123456".equals(pwd)) isAdmin = true;
		executor = new CommandExecutorImpl();
	}
	
	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) 
		{
			executor.runCommand(cmd);
		} 
		else 
		{
			if (cmd.trim().startsWith("rm")) {
				throw new Exception("rm command - acesso nao permitido");
			} else {
				executor.runCommand(cmd);
			}
		}
	}

}
