package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class RenderPlayerLxuna extends Module{

	
	public static boolean renderPlayerModelLxuna = false;
	
	
	public void onEnable() {
		
		 renderPlayerModelLxuna = true;
		
		
	}
	
	public void onDisable() {
		
		 renderPlayerModelLxuna = false;
		
	}
	
	
	public RenderPlayerLxuna() {
		super("RenderSelf", Keyboard.KEY_NONE, Category.RENDER, "O");
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
