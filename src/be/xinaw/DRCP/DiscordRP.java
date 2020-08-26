package be.xinaw.DRCP;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {
	
	private boolean running = true;
	private long created = 0;
	
    public void start() {
    	this.created = System.currentTimeMillis();
    	DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			
			@Override
			public void apply(DiscordUser user) {
				System.out.println("hey " + user.username + "#" + user.discriminator + ".");
				update(Main.getInsstance().getPanele().getFirstLine(), "Mon sang");
				
			}
		}).build();
    	
    	DiscordRPC.discordInitialize(Main.getInsstance().getPanele().getID(), handlers, true);
    	new Thread("Discord RPC Callback") {
    		
    		@Override
    		public void run() {
    			while(running) {
    				DiscordRPC.discordRunCallbacks();
    			}
    		}	
    	}.start();
    }
    
    public void shutdown() {
    	running = false;
    	DiscordRPC.discordShutdown();
    }
    
    public void update(String firstLine, String secondLine) {
    	DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
    	b.setBigImage(Main.getInsstance().getPanele().getNameOfImage(), "");
    	b.setDetails(Main.getInsstance().getPanele().getFirstLine());
    	b.setStartTimestamps(created);
    	
    	DiscordRPC.discordUpdatePresence(b.build());
    }
}
