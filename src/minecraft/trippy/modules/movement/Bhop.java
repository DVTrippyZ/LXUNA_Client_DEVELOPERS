package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class Bhop extends Module{

	
	
	
	
	public void onEnable() {
		
		mc.gameSettings.keyBindJump.pressed = true;
		
	}
	
	public void onDisable() {
		mc.gameSettings.keyBindJump.pressed = false;
		
	}
	
	
	public Bhop() {
		super("Bhop", Keyboard.KEY_M, Category.MOVEMENT, "Y");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
