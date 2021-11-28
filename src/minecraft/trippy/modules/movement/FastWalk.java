package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class FastWalk extends Module{

	private float WalkSpeed = 0.9f;
	
	
	
	public void onEnable() {
		
		 
		
		
	}
	
	public void onDisable() {
		
		mc.thePlayer.setSprinting(false);
	}
	
	
	public FastWalk() {
		super("FastWalk", Keyboard.KEY_H, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				mc.thePlayer.setSprinting(true);
			}
		}
	}

}
