package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

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
