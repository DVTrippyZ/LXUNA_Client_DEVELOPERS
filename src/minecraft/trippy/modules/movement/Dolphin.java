package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Dolphin extends Module{

	private float dolphinLXUNAPRIVATE = 0.5f;
	
	
	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		
		
	}
	
	
	public Dolphin() {
		super("Dolphin", Keyboard.KEY_PERIOD, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.isInWater()) {
					mc.thePlayer.motionY += dolphinLXUNAPRIVATE;
					
					
				}
			}
		}
	}

}
