package br.com.globalcode;
public class ConfigManager {
  private String serverName = "201.122.234.23:7937";
  private static ConfigManager instance = new ConfigManager();

  private ConfigManager() {
  }
  
  public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }
  
  public static ConfigManager getInstance() {
      return instance;
  }
}
