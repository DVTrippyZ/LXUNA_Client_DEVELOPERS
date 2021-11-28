package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class EnabledAll extends Module{

	
	
	
	
	public void onEnable() {
		
		for(Module m : Client.modules) {
			
			if(!m.toggled) {
			m.toggled = true;
			}
		}
		
	}
	
	public void onDisable() {
		for(Module m : Client.modules) {
			
			if(m.toggled) {
			m.toggled = false;
			}
		}

	}
	
	
	public EnabledAll() {
		super("ToggleAll", Keyboard.KEY_MINUS, Category.MOVEMENT, "U");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
				
			}
		}
	}

}
