package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.Client;
import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Velocity extends Module{

	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		

		
	}
	
	
	public Velocity() {
		super("AntiKB", Keyboard.KEY_NONE, Category.PLAYER, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			
					
			
					if(mc.thePlayer.hurtTime > 0) {
						mc.thePlayer.motionX *= 0.15f;
						mc.thePlayer.motionZ *= 0.15f;
					
				}
				
			}
		}
	}

}
