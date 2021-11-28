package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class SpeedHack extends Module{

	private float speedLXUNA = 2.0f;
	
	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		
		
	}
	
	
	public SpeedHack() {
		super("Speed", Keyboard.KEY_C, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.onGround && mc.gameSettings.keyBindForward.pressed) {
					mc.thePlayer.motionX *= speedLXUNA;
					mc.thePlayer.motionZ *= speedLXUNA;
					
				} 
			}
		}
	}

}
