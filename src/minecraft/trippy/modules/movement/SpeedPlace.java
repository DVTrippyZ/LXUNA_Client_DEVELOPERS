package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class SpeedPlace extends Module{

	
	public static boolean isDelayLXUNA = false;
	
	
	public void onEnable() {
		isDelayLXUNA = true;
		
		
	}
	
	public void onDisable() {
		isDelayLXUNA = false;
	}
	
	
	public SpeedPlace() {
		super("SpeedPlace", Keyboard.KEY_F, Category.PLAYER, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				   
			}
		}
	}

}
