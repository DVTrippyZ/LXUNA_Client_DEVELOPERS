package render;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;

public class Bright extends Module{

	private float flySpeed = 1f;
	
	
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 100;
		
		
	}
	
	public void onDisable() {
		mc.gameSettings.gammaSetting = 1;
		
	}
	
	
	public Bright() {
		super("Bright", Keyboard.KEY_J, Category.RENDER, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
