package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Fall extends Module{

	
	
	
	
	public void onEnable() {
		
		
	}
	
	public void onDisable() {
		
	}
	
	
	public Fall() {
		super("Fall", Keyboard.KEY_K, Category.PLAYER, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.fallDistance > 2) {
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
					
				}
			}
		}
	}

}
