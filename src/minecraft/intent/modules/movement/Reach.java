package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;

public class Reach extends Module{

	
	public static boolean isReachLXUNA = false;
	
	
	public void onEnable() {
		isReachLXUNA = true;
		
		
	}
	
	public void onDisable() {
		isReachLXUNA = false;
	}
	
	
	public Reach() {
		super("Reach", Keyboard.KEY_V, Category.PLAYER, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				   
			}
		}
	}

}
