package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class AirJump extends Module{

	
	
	
	
	public void onEnable() {
		
		
	}
	
	public void onDisable() {
		

	}
	
	
	public AirJump() {
		super("AirJump", Keyboard.KEY_I, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.thePlayer.onGround = true;
				
				
			}
		}
	}

}
