package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;

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
