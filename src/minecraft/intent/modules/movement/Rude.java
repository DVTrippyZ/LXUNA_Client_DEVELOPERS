package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Rude extends Module{

	
	
	private String rudeMsgLXUNA = "Bruh ur ass at dis :/";
	
	public void onEnable() {
		
		mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(rudeMsgLXUNA));
		
	}
	
	public void onDisable() {
		
		mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(rudeMsgLXUNA));
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

}
