package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

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
