package intent.modules.movement;

import org.lwjgl.input.Keyboard;

import intent.events.Event;
import intent.events.listeners.EventUpdate;
import intent.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class ForceCreative extends Module{

	
	
	
	
	public void onEnable() {
		
		mc.thePlayer.capabilities.isCreativeMode = true;
		
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isCreativeMode = false;
	
		
	}
	
	
	public ForceCreative() {
		super("GetCreative", Keyboard.KEY_NONE, Category.PLAYER, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
