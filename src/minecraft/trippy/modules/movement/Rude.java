package trippy.modules.movement;

import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Rude extends Module{

	public static int y = 0;
	
	private String rudeMsgLXUNA = "Bruh ur ass at dis :/";
	
	public void onEnable() {
		
		functionTimer();
		
	}
	
	public void onDisable() {
		
		
	}
	
	
	public Rude() {
		super("Toxic", Keyboard.KEY_SEMICOLON, Category.CHAT, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
				
			}
		}
	}
	
	
	
		
		private void functionTimer() {
		
		
		new Timer().scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
		    	
            	y++;
            	mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(rudeMsgLXUNA + y));
            	
		    }
		},0,5000);
		
	}

}
