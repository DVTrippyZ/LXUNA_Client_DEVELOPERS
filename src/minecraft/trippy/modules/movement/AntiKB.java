package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class AntiKB extends Module{

	
	public static boolean LXUNAANTIKBTRUE = false;
	
	
	public void onEnable() {
		
		mc.thePlayer.isDead = true;
		
	}
	
	public void onDisable() {
		
		mc.thePlayer.isDead = false;
	}
	
	
	public AntiKB() {
		super("IsDead", Keyboard.KEY_U, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				   //mc.thePlayer.isDead = true;
				   
			}
		}
	}

}
