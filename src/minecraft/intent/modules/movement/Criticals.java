package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.event.ClickEvent;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Criticals extends Module{

	
	
	
	
	public void onEnable() {
		
		
		
	}
	
	public void onDisable() {
		

	}
	
	
	public Criticals() {
		super("Criticals", Keyboard.KEY_Y, Category.COMBAT, "U");
		
	}
	
	
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				jump_min();
				
			}
		}
	}
	
	
	private void jump_min() {
		
		if(mc.thePlayer.onGround) {
		mc.thePlayer.addVelocity(0, 0.2, 0);
		mc.thePlayer.fallDistance = 0.2F;
		mc.thePlayer.onGround = false;
		
	}
	}
	
	private void jump_max() {
		
	}

}
