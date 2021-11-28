package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class HighJump extends Module{

	public static boolean LXUNAJUMPHACKTRUE = false;
	
	
	
	public void onEnable() {
		
		LXUNAJUMPHACKTRUE = true;
		
	}
	
	public void onDisable() {
		
		LXUNAJUMPHACKTRUE = false;
	}
	
	
	public HighJump() {
		super("HighJump", Keyboard.KEY_B, Category.MOVEMENT, "N");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
