package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class SpeedHack extends Module{

	private float speedLXUNA = 2.0f;
	
	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		
		
	}
	
	
	public SpeedHack() {
		super("SpeedHack", Keyboard.KEY_C, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.onGround) {
					mc.thePlayer.motionX *= speedLXUNA;
					mc.thePlayer.motionZ *= speedLXUNA;
					
				}
			}
		}
	}

}
