package trippy.modules.movement;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import trippy.Client;
import trippy.events.Event;
import trippy.events.listeners.EventUpdate;
import trippy.modules.Module;

public class KeyPressLogs extends Module{

	
	public static boolean keyPressLogsLxunaOn = true;
	
	
	public void onEnable() {
		
		keyPressLogsLxunaOn = true;
		
		
	}
	
	public void onDisable() {
		
		keyPressLogsLxunaOn = false;
		
	}
	
	
	public KeyPressLogs() {
		super("KeyPress", Keyboard.KEY_NONE, Category.RENDER, "O");
		toggled = true;
		
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			if(e.isPre()) {
				
			}
		}
	}

}
