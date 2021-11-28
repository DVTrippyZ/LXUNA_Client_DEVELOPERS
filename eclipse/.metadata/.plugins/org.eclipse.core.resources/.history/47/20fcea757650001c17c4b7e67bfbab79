package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

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
