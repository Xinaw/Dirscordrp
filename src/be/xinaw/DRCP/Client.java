package be.xinaw.DRCP;

public class Client {
	private static final Client INSTANCE = new Client();
	public static final Client getInstancee() {
		return INSTANCE;
		}
	
	private DiscordRP discordRP = new DiscordRP();
	
	public void init() {
		discordRP.start();
		System.out.println("RP start");
	}
	public void shutdown() {
		discordRP.shutdown();
		System.out.println("RP shutdown");
	}
   public DiscordRP getDiscordRP() {
	   return discordRP;
   }
}
