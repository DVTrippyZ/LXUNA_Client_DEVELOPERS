package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

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
