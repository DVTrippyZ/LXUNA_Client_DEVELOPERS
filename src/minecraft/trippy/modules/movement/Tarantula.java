package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Tarantula extends Module{

	
	
	//0.42F
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		
		
	}
	
	
	public Tarantula() {
		super("Tarantula", Keyboard.KEY_O, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				if(mc.thePlayer.isCollidedHorizontally){
					mc.thePlayer.motionY = 0.30F;
				}
			}
		}
	}

}
