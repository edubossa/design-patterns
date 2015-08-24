package br.com.globalcode.cp.singleton;

public class UsaConfigManager {
	
	public static void main(String[] args) {
				
		new Thread(new Runnable() {
			@Override
			public void run() {
				String nomeServidor = ConfigManager.getInstance().getServerName();
				System.out.println(nomeServidor);
				ConfigManager config = ConfigManager.getInstance();
				System.out.println(config); 
			}
		}).start();
		
		for (int i = 0; i < 3; i++) {
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					ConfigManager config = ConfigManager.getInstance();
					System.out.println(config);
				}
			}).start();
			
		}
		
	}

}