package br.com.globalcode.cp.singleton;

public class ConfigManager {

	private static ConfigManager instance;
	private String serverName = "192.168.20.10:7937";

	private ConfigManager() {}
	
	/*   
	 * TODO Se nao estiver sincronizado, o acesso simultaneo de threads
	 * pode criar mais de uma instancia, quando usado na inicializacao do projeto.
	 */
	public static synchronized ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		return instance;
	}

	public String getServerName() {
		return serverName;
	}

}