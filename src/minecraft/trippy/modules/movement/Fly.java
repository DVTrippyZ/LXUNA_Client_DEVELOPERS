package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Fly extends Module{

	private float flySpeed = 0.1f;
	
	
	
	public void onEnable() {
		
		
		
		
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		
		
	 
	}
	
	
	public Fly() {
		super("Fly", Keyboard.KEY_G, Category.MOVEMENT, "N");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.thePlayer.capabilities.isFlying = true;
			}
		}
	}

}
